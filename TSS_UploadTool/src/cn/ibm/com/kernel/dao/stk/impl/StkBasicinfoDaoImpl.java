package cn.ibm.com.kernel.dao.stk.impl;




import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.StkBasicinfo;
import cn.ibm.com.kernel.dao.impl.BaseDaoImpl;
import cn.ibm.com.kernel.dao.stk.StkBasicinfoDao;




/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class StkBasicinfoDaoImpl extends BaseDaoImpl<StkBasicinfo> implements StkBasicinfoDao{

	public Map findStkBasicinfoBytradingcode(Map param) {
		return (Map)this.getSqlMapClientTemplate().queryForObject("findStkBasicinfoByTradingcode", param);
	}
	
	public Map findStksectorBytradingcode(Map param) {
		return (Map)this.getSqlMapClientTemplate().queryForObject("findStksectorByTradingcode", param);
	}

	public List<Map> listStkBasicinfoForGeneration(Map param) {
		return this.getSqlMapClientTemplate().queryForList("listStkBasicinfoForGeneration", param);
	}

	public List<Map> listAllStkBasicinfoForCache() {
		return this.getSqlMapClientTemplate().queryForList("listAllStkBasicinfoForCache");
	}
	
}
