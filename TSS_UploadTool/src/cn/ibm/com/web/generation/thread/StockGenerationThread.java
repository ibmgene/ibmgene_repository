package cn.ibm.com.web.generation.thread;



import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.ibm.com.common.util.Utils;
import cn.ibm.com.web.generation.stock.StockMainGenerator;

public class StockGenerationThread implements Runnable {
	
	private StockMainGenerator stockMainGenerator;
	
	
	
	private static Logger error_log = Logger.getLogger("marketerrorlog");
	
	private List<Map> stockList;
	
	public void setStockList(List<Map> stockList) {
		this.stockList = stockList;
	}

	public void setStockMainGenerator(StockMainGenerator stockMainGenerator) {
		this.stockMainGenerator = stockMainGenerator;
	}
	

	public void run() {
		if(stockList!=null&&stockList.size()>0){
			for(Map stk:stockList){
				String tradingcode = Utils.trim((String) stk.get("tradingcode"));
				if(!"".equals(tradingcode)){
					
					try{
						stockMainGenerator.generateMain(tradingcode);
					}catch(Exception e){
						e.printStackTrace();
						error_log.error("生成个股全景时发生异常，交易号为："+tradingcode+" 错误信息："+e.getMessage());
					}
				}
			}
		}
	}

}
