package cn.ibm.com.kernel.service.stk;



import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.StkDailyquote;
import cn.ibm.com.kernel.service.BaseService;


/**
 * IStkDailyquoteService.java, Created on  2010-12-05
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2010 <br/>
 * @author hyman
 * @version Revision: 1.0, Date: 2010-12-05  22:44:40  
 */
public interface StkDailyquoteService extends BaseService<StkDailyquote> {    
  
	/**
	 * (个股全景)根据股票代码查找最新行情
	 * @param param (tradingcode-交易代码,orderByFlag-排序标志)
	 * @return
	 */
	public StkDailyquote findStkDailyquoteBycode(Map param);
	
	/**
	 * (个股全景)市场表现-查找半年内股票行情与指数对比
	 * @param param (tradingcode-交易代码,inxtradingcode-指数代码,orderByFlag-排序标志)
	 * @return
	 */
	public List listStkDailyquoteBycode(Map param);
}

