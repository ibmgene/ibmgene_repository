package cn.ibm.com.web.cache;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.ibm.com.common.util.Utils;
import cn.ibm.com.kernel.service.fnd.FndBasicinfoService;

/**
 * 基金信息缓存生成
 * @author leichen
 *
 */
public class FundCache {
	
	@Autowired
	private FndBasicinfoService fndBasicinfoService;
	
	private List<Map> fundList;

	public List<Map> getFundList() {
		return fundList;
	}
	
	public synchronized void setFundList(){
		List<Map> list = fndBasicinfoService.listAllFndBasicinfoForCache();
		List<Map> tmpList = new ArrayList<Map>();
		for(Map map:list){
			tmpList.add(map);
		}
		if(tmpList.size()>0){
			this.fundList = tmpList;
		}
	}
	
	public List<Map> getFundListByTradingcode(String tradingcode){
		List<Map> list = new ArrayList<Map>();
		int i=0;
		for(Map map:fundList){
			String tradingcodeTmp = Utils.trim(map.get("tradingcode")) ;
			if(tradingcodeTmp.startsWith(tradingcode)){
				list.add(map);
				i++;
				if(i>=10){
					break;
				}
			}
		}
		return list;
	}
	
	public List<Map> getFundListByWord(String word){
		word = word.toUpperCase();
		List<Map> list = new ArrayList<Map>();
		int i=0;
		for(Map map:fundList){
			String secuabbr = Utils.trim(map.get("secuabbr"));
			String chispellingTmp = Utils.trim(map.get("chispelling"));
			if(secuabbr.startsWith(word)||chispellingTmp.startsWith(word)){
				list.add(map);
				i++;
				if(i>=10){
					break;
				}
			}
		}
		return list;
	}

}
