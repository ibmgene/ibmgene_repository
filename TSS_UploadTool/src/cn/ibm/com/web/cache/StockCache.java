package cn.ibm.com.web.cache;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ibm.com.common.util.Utils;
import cn.ibm.com.kernel.service.stk.StkBasicinfoService;
/**
 * 股票基础信息缓存生成
 * @author leichen
 *
 */
public class StockCache {
	
	@Autowired
	private StkBasicinfoService stkBasicinfoService;
	
	private List<Map> stockList;

	public List<Map> getStockList() {
		return stockList;
	}
	
	public synchronized void setStockList(){
		List<Map> list = stkBasicinfoService.listAllStkBasicinfoForCache();
		List<Map> tmpList = new ArrayList<Map>();
		for(Map map:list){
			tmpList.add(map);
		}
		if(tmpList.size()>0){
			this.stockList = tmpList;
		}
	}
	
	public List<Map> getStockListByTradingcode(String tradingcode){
		List<Map> list = new ArrayList<Map>();
		int i=0;
		for(Map map:stockList){
			String tradingcodeTmp = (String) map.get("tradingcode");
			if(tradingcodeTmp.startsWith(tradingcode)){
				list.add(map);
				i++;
				/*if(i>=10){
					break;
				}*/
			}
		}
		return list;
	}
	
	public List<Map> getStockListByChispelling(String chispelling){
		chispelling = chispelling.toUpperCase();
		List<Map> list = new ArrayList<Map>();
		int i=0;
		for(Map map:stockList){
			String chispellingTmp = Utils.trim(map.get("chispelling"));
			if(chispellingTmp.startsWith(chispelling)){
				list.add(map);
				i++;
				if(i>=10){
					break;
				}
			}
		}
		return list;
	}
	
	public List<Map> getStockListByWord(String word){
		word = word.toUpperCase();
		List<Map> list = new ArrayList<Map>();
		int i=0;
		for(Map map:stockList){
			String secuabbr = Utils.trim(map.get("secuabbr"));
			String chispellingTmp = Utils.trim(map.get("chispelling"));
			if(secuabbr.startsWith(word)||chispellingTmp.startsWith(word)){
				list.add(map);
				i++;
				/*if(i>=10){
					break;
				}*/
			}
		}
		return list;
	}

}
