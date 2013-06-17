package cn.ibm.com.web.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.ibm.com.common.ajaxpage.PageList;
import cn.ibm.com.common.ajaxpage.PageProperty;
import cn.ibm.com.common.constants.GaotimeConstants;
import cn.ibm.com.common.util.ConfigurationHelper;
import cn.ibm.com.common.util.CookieOperate;
import cn.ibm.com.common.util.DateUtils;
import cn.ibm.com.common.util.FileOperate;
import cn.ibm.com.common.util.JSONUtil;
import cn.ibm.com.common.util.POIUtils;
import cn.ibm.com.common.util.PageUtil;
import cn.ibm.com.common.util.ReadConfig;
import cn.ibm.com.common.util.Utils;
import cn.ibm.com.entity.Globalxcallti;
import cn.ibm.com.entity.MachineType;
import cn.ibm.com.entity.NwsLawsregulations;
import cn.ibm.com.entity.Users;
import cn.ibm.com.kernel.service.globalxcallti.GlobalxcalltiService;
import cn.ibm.com.kernel.service.globalxcallti.MachineTypeService;
import cn.ibm.com.kernel.service.nws.NwsLawsregulationsService;



/**
 * TSS Entry
 * 
 * @author johnny
 *
 */
@Controller
public class OpetateController extends DefaultController {

	private static final Log log = LogFactory.getLog(OpetateController.class);
	
	@Autowired
	private ConfigurationHelper tssConfigurationHelper;
	
	@Autowired
	private GlobalxcalltiService globalxcalltiService; // globalxcallti
	
	@Autowired
	private MachineTypeService machineTypeService; // machine_type

	
	/**
	 * Globalxcallti
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/operator_panel.do")
	public String opetator_panelController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		
//		Resource resource = new ClassPathResource("test.properties");
//		Properties props = PropertiesLoaderUtils.loadProperties(resource);
//		String temp1 = props.getProperty("test1");
		

        request.setAttribute("username", "jingpeng@cn.ibm.com");
		
		return "operator/upload_excel";
	}

	
	
	/**
	 * Globalxcallti
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/readXLS.do")
	public String readExcellController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		
		String filePath = multipart.getParameter("textfield4");
		
		String year = multipart.getParameter("input_text_year"); //get the year
		String month = multipart.getParameter("input_text_month"); //get the month
		
		MultipartFile multipartFile = multipart.getFile("textfield4submit");
		String fileName = multipartFile.getOriginalFilename(); 
		byte[] binaryStream = null;
		try {
			binaryStream = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		//upload Excel File path
		String generate_excell_base_dir = tssConfigurationHelper.getProperty("generate_excell_base_dir");
		
		//创建目录，如果不存在的话
		String loginname = CookieOperate.getCookieByName(request, "loginname").getValue();
		FileOperate.mkdirs(generate_excell_base_dir+"/"+loginname);
		
		// generate the file	
		log.info("create the file :"+ generate_excell_base_dir+"/"+loginname+"/"+fileName);
		FileOperate.getFileFromBytes(binaryStream, generate_excell_base_dir+"/"+loginname+"/"+fileName);
		
		//read the Excel
		log.info("read the file :"+ generate_excell_base_dir+"/"+loginname+"/"+fileName);
		List<Map> resultListMap = (List<Map>) POIUtils.readXLSFromPath(generate_excell_base_dir+"/"+loginname+"/"+fileName).get(0).get("allExcelData");
		
		//lack of column
		Set lackColumnSet = (Set) POIUtils.readXLSFromPath(generate_excell_base_dir+"/"+loginname+"/"+fileName).get(0).get("lackColumn");
		String s_lackColumn = checkColumn(lackColumnSet);
		
		//lack and more machineType
		Set lackAndMoreMachineType = (Set) POIUtils.readXLSFromPath(generate_excell_base_dir+"/"+loginname+"/"+fileName).get(0).get("lackAndMoreMachineType");
		String s_lackAndMoreMachineType = checkMachineType(lackAndMoreMachineType);
		String[] s_machineType = s_lackAndMoreMachineType.split("&&&");
		
//		String[] s_machineType = lackAndMoreMachineType.split("|||");
		
		request.setAttribute("list", resultListMap);
		request.setAttribute("s_lackColumn", s_lackColumn);
		request.setAttribute("s_lackMachineType", s_machineType[0]);
		request.setAttribute("s_moreMachineType", s_machineType[1]);
		request.setAttribute("loginname", loginname);
		request.setAttribute("generate_excell_base_dir", generate_excell_base_dir);
		request.setAttribute("fileName", fileName);
		
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		
		return "operator/confirm_data";
	}

	
	
	/**
	 * Globalxcallti
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/importToDatabase.do")
	public void importExcellDataToDatabaseController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {


		String loginname = request.getParameter("loginname");
		String generate_excell_base_dir = request.getParameter("generate_excell_base_dir");
		String fileName = request.getParameter("fileName");
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		
		System.out.println(loginname);
		System.out.println(generate_excell_base_dir);
		System.out.println(fileName);
		
		List<Map> resultListMap = (List<Map>) POIUtils.readXLSFromPath(generate_excell_base_dir+"/"+loginname+"/"+fileName).get(0).get("allExcelData");

		
		
		for(int i=0; i<resultListMap.size(); i++){
			if(i>2){
				
				
				Map tempMap = resultListMap.get(i);
				Globalxcallti globalxcallti = new Globalxcallti();
				
//				String yymm = String.valueOf(Double.valueOf(tempMap.get("22").toString()).intValue())+tempMap.get("23").toString();
				String yymm = year+month;
				
				globalxcallti.setYymm(yymm);
				globalxcallti.setIot_gmt(tempMap.get("0").toString());
				globalxcallti.setMachine_type(tempMap.get("1").toString());
				globalxcallti.setMachine_month(Double.valueOf(tempMap.get("2").toString()));
				globalxcallti.setRa(Double.valueOf(tempMap.get("3").toString()));
//				globalxcallti.setRa_rate(0.0);
				globalxcallti.setValid_calls(Double.valueOf(tempMap.get("4").toString()).intValue());
				globalxcallti.setInvalid_cancelled(Double.valueOf(tempMap.get("5").toString()).intValue());
				globalxcallti.setEligible(Double.valueOf(tempMap.get("6").toString()).intValue());
				globalxcallti.setScreened(Double.valueOf(tempMap.get("7").toString()).intValue());
				globalxcallti.setFop(Double.valueOf(tempMap.get("8").toString()).intValue());
				globalxcallti.setCru_calls(Double.valueOf(tempMap.get("9").toString()).intValue());
				globalxcallti.setOn_site_calls(Double.valueOf(tempMap.get("10").toString()));
				globalxcallti.setTrst(Double.valueOf(tempMap.get("11").toString()));
				globalxcallti.setTotal_ap(Double.valueOf(tempMap.get("12").toString()));
				globalxcallti.setFapr(Double.valueOf(tempMap.get("13").toString()));
				globalxcallti.setNpra(Double.valueOf(tempMap.get("14").toString()));
				globalxcallti.setOn_site_fix_time(Double.valueOf(tempMap.get("15").toString()));
				globalxcallti.setTravel_time(Double.valueOf(tempMap.get("16").toString()));
				globalxcallti.setTotal_fix_time(Double.valueOf(tempMap.get("17").toString()));
				globalxcallti.setParts_used_cost(Double.valueOf(tempMap.get("18").toString()));
				globalxcallti.setParts_disbursed(Double.valueOf(tempMap.get("19").toString()));
				globalxcallti.setParts_good_return(Double.valueOf(tempMap.get("20").toString()));
				globalxcallti.setParts_used(Double.valueOf(tempMap.get("21").toString()));
				
				globalxcalltiService.insert(globalxcallti);
				
			}
		}
		
		//upload Excel File path
//		String generate_excell_base_dir = tssConfigurationHelper.getProperty("generate_excell_base_dir");
		String result= "success";
		
		response.getWriter().write(result);
	
		
		return ;
	}

	
	private String checkColumn(Set columnSet){
//		System.out.println(machineTypeList.size());
		Set OriginalColumnSet = new HashSet();
		OriginalColumnSet.add("IOT_GMT");
		OriginalColumnSet.add("MACHINE_TYPE");
		OriginalColumnSet.add("MACHINE_MONTH");
		OriginalColumnSet.add("RA");
		OriginalColumnSet.add("VALID_CALLS");
		OriginalColumnSet.add("INVALID_CHNCELLED");
		OriginalColumnSet.add("ELIGIBLE");
		OriginalColumnSet.add("SCREENED");
		OriginalColumnSet.add("FOP");
		OriginalColumnSet.add("CRU_CALLS");
		OriginalColumnSet.add("ON_SITE_CALLS");
		OriginalColumnSet.add("TRST");
		OriginalColumnSet.add("TOTAL_AP");
		OriginalColumnSet.add("FAPR");
		OriginalColumnSet.add("NPRA");
		OriginalColumnSet.add("ON_SITE_FIX_TIME");
		OriginalColumnSet.add("TRAVEL_TIME");
		OriginalColumnSet.add("TOTAL_FIX_TIME");
		OriginalColumnSet.add("PARTS_USED_COST");
		OriginalColumnSet.add("PARTS_DISBURSED");
		OriginalColumnSet.add("PARTS_GOOD_RETURN");
		OriginalColumnSet.add("PARTS_USED");
//		OriginalColumnSet.add("YEAR");
//		OriginalColumnSet.add("MONTH");
		
		   //交集      
		Collection intersection = CollectionUtils.intersection(OriginalColumnSet, columnSet);
		Collection lackColumn = CollectionUtils.disjunction(OriginalColumnSet, intersection);
		String s_lackColumn = ArrayUtils.toString(lackColumn.toArray());
		
		if("{}".equals(s_lackColumn)){
			s_lackColumn = "";
			
		}
		
		return s_lackColumn;
		
	}

	private String checkMachineType(Set machineTypeSet){
//		System.out.println(machineTypeList.size());
		
		//Original MachineType in database;
		List<MachineType> ListOfMachineType = null;
		try{
			ListOfMachineType = machineTypeService.listAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		Set originalMachineTypeSet = new HashSet();
		for(MachineType machineType : ListOfMachineType){
			originalMachineTypeSet.add(machineType.getMachine_type());
		}
		
		
		   //交集      
		Collection intersection = CollectionUtils.intersection(originalMachineTypeSet, machineTypeSet);
		
		//lack machineType
		Collection lackMachineType = CollectionUtils.subtract(originalMachineTypeSet, intersection);
		String s_lackMachineType = ArrayUtils.toString(lackMachineType.toArray());
		if("{}".equals(s_lackMachineType)){
			s_lackMachineType = "none";
			
		}
		
		
		//more machineType
		Collection moreMachineType = CollectionUtils.subtract(machineTypeSet, intersection);
		String s_moreMachineType = ArrayUtils.toString(moreMachineType.toArray());
		
		if("{}".equals(s_moreMachineType)){
			s_moreMachineType = "none";
		}
		
		//将两个字符串合并，中间用|||风格，后期可以以此区分处理。
		String s_lackAndMoreMachineType = s_lackMachineType+"&&&"+s_moreMachineType;
		
		return s_lackAndMoreMachineType;
	}
	

}
