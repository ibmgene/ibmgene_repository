package cn.ibm.com.web.generation;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.ibm.com.common.constants.GaotimeConstants;
import cn.ibm.com.kernel.service.fnd.FndBasicinfoService;
import cn.ibm.com.kernel.service.stk.StkBasicinfoService;
import cn.ibm.com.web.generation.stock.StockMainGenerator;
import cn.ibm.com.web.generation.thread.StockGenerationThread;

public class GenerationThreadManager {
	
	private static Logger error_log = Logger.getLogger("marketerrorlog");
	
	@Autowired
	private StkBasicinfoService stkBasicinfoService;
	@Autowired
	private StockMainGenerator stockMainGenerator;
	

	
	public void generateStock(){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("secucategoryCodeIIs", "'"+GaotimeConstants.SECU_CATEGORY_CODEII_A+"','"+GaotimeConstants.SECU_CATEGORY_CODEII_B+"'");
		List<Map> stkBasicInfoList = stkBasicinfoService.listStkBasicinfoForGeneration(param);
		if(stkBasicInfoList!=null&&stkBasicInfoList.size()>0){
			StockGenerationThread thread = new StockGenerationThread();
			
			thread.setStockMainGenerator(stockMainGenerator);
			thread.setStockList(stkBasicInfoList);
			new Thread(thread).start();
		}
	}
	
	

}
