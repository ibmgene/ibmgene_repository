package cn.ibm.com.kernel.dao.stk;



import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.StkBasicinfo;
import cn.ibm.com.kernel.dao.BaseDao;


/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public interface StkBasicinfoDao extends BaseDao<StkBasicinfo>{

	/**
	 * (个股全景)根据股票代码查找股票简称代码交易市场
	 * @param param tradingcode-股票代码
	 * @return
	 */
	public Map findStkBasicinfoBytradingcode(Map param);
	/**
	 * (个股全景)根据股票代码查找股票行业
	 * @param param tradingcode-股票代码
	 * @return
	 */
	public Map findStksectorBytradingcode(Map param);
	
	/**
	 * 获取生成静态页面所需要的股票信息列表
	 * @param param (secucategoryCodeII-股票分类代码)
	 * @return
	 */
	public List<Map> listStkBasicinfoForGeneration(Map param);
	
	/**
	 * 获取全部股票基础信息
	 * @return
	 */
	public List<Map> listAllStkBasicinfoForCache();
}
