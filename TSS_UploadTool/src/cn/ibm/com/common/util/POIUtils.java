package cn.ibm.com.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ibm.com.entity.MachineType;
import cn.ibm.com.kernel.service.globalxcallti.MachineTypeService;

/**
 * 分页工具类
 */
public class POIUtils {
	
	@Autowired
	private ConfigurationHelper tssConfigurationHelper;
	

	
//	String test = tssConfigurationHelper.getProperty("wpc");
	
	public static List<Map> readXLSFromPath(String filepath) {
		FileInputStream inputStream = null;
		List<Map> resultListMap = new ArrayList();
		try {
			inputStream = new FileInputStream(new File(filepath));
			resultListMap = readXLS(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return resultListMap;
	}

	public static List<Map> readXLS(InputStream inputStream) throws IOException {
		//All result in List ,list0 is all List, List1 is lack column, list2 is machine type;
		List<Map> AllResultList = new ArrayList();
		
		
		//result List Map, in All result list0
		List<Map> resultListMap = new ArrayList();
		
		//lack column , in All result list0
		String lackColumnCheck = null;
		
		//lack and more MT, in all result list0
		String lackAndMoreMachineType = null;
		

		//machineType list, for check the machineType
//		List machineTypeList = new ArrayList();
		Set machineTypeSet = new HashSet();
		
		Set columnSet = new HashSet();
		
		// init the all Excell
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

		// get the first sheet
//		HSSFSheet sheet = workbook.getSheetAt(0);
//		HSSFSheet sheet = workbook.getSheet("Sheet1");

		// get the first line
//		HSSFRow row0 = sheet.getRow(0);

		// get the fist cell of fist line
//		HSSFCell cell = row0.getCell(0);
		
		
		for(int sheetIndex=0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++){
			int tempNumberOfSheet = workbook.getNumberOfSheets();
			
			HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
//			System.out.println("sheet No.:"+sheetIndex+", sheet name:"+workbook.getSheetName(sheetIndex));
			
			//circle every row
			for(int rowIndex=0; rowIndex <= sheet.getLastRowNum(); rowIndex++){
				int tempLastRowNum = sheet.getLastRowNum();
				
				List tempRowList = new ArrayList();
				Map tempCellMap = new HashMap();
				
				HSSFRow row = sheet.getRow(rowIndex);
				if(row == null){
					continue;
				}
				
				//circle every cell in the row
				for(int cellNum=0; cellNum<row.getLastCellNum(); cellNum++){
					int tempCellNum = row.getLastCellNum();
					
					HSSFCell cell = row.getCell(cellNum);
					String cellContent = null;
					if(cell != null){
						cellContent = getCellValue(cell);
					}
					
					//将如果是double类型的machineType，做取整操作
					if(cellNum == 1 && rowIndex >= 3){
						//如果machineType包含了小数点，就做取整操作。因为machineType如果是num类型，在上一步操作取值就必会带一位小数。
						if(cellContent.contains(".")){
							cellContent = Integer.toString((int)Math.floor(Double.valueOf(cellContent)));
						}
					}
					
					tempCellMap.put(String.valueOf(cellNum), cellContent);
//					System.out.println("No."+rowIndex+" Line   No."+cellNum+" col   content:"+cellContent);
					
					//为了判断缺少列
					if(rowIndex ==1){
						columnSet.add(cellContent);
					}
					
					
					//为了判断machine type缺少和多余
					if(cellNum == 1 && rowIndex >= 3){
//						machineTypeList.add(cellContent);
						machineTypeSet.add(cellContent);
					}
				}
				
				tempRowList.add(tempCellMap);
				resultListMap.addAll(tempRowList);
//				try{
//					resultListMap.add(tempRowList);
//				}catch(Exception e){
//					e.printStackTrace();
//				}
				
			}
			
//			System.out.println("--------------------------------------------------------------------");
			
			//为了判断缺少列
//			lackColumnCheck = checkColumn(columnSet);
			
			//为了判断machine type缺少和多余, 只传入set，判断部分，放入到controller里面处理。
//			String temp = checkMachineType(machineTypeList);
//			POIUtils poiUtils = new POIUtils();
//			lackAndMoreMachineType = poiUtils.checkMachineType(machineTypeSet);
			
		}
		
		//最终list里面，list0是整个数据
		Map allResultMap = new HashMap();
		allResultMap.put("allExcelData", resultListMap);
		allResultMap.put("lackColumn", columnSet);
		allResultMap.put("lackAndMoreMachineType", machineTypeSet);
		
		AllResultList.add(allResultMap);
		
//		return resultListMap;
		return AllResultList;

	}
	
	
	public static String getCellValue(HSSFCell cell){
		if(cell == null){
			return null;
		}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){
			return "0.0";
		}else if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
			return cell.getRichStringCellValue().getString();
		}else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
			//if it is a Date type
			if(HSSFDateUtil.isCellDateFormatted(cell)){
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				return dateFormat.format(date);
			}else{  //if it is a Double type
				return Double.toString(cell.getNumericCellValue());  //返回必带一位小数
			}
		}else if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN){
			boolean temp = cell.getBooleanCellValue();
			if(temp){
				return "true";
			}else{
				return "false";
			}
		}else if(cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA){
			return cell.getCellFormula();
		}
		
		return null;
	}
	
	
	private static String checkMachineType(List machineTypeList){
//		System.out.println(machineTypeList.size());
		
		return null;
		
	}
	
	

	
	

	
}
