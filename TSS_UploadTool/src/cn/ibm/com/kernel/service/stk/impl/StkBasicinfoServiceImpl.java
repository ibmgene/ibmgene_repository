package cn.ibm.com.kernel.service.stk.impl;



import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.StkBasicinfo;
import cn.ibm.com.kernel.dao.stk.StkBasicinfoDao;
import cn.ibm.com.kernel.service.impl.BaseServiceImpl;
import cn.ibm.com.kernel.service.stk.StkBasicinfoService;




/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class StkBasicinfoServiceImpl extends BaseServiceImpl<StkBasicinfo,StkBasicinfoDao> implements StkBasicinfoService{

	public Map findStkBasicinfoBytradingcode(Map param) {
		return this.getBaseDao().findStkBasicinfoBytradingcode(param);
	}
	public Map findStksectorBytradingcode(Map param) {
		return this.getBaseDao().findStksectorBytradingcode(param);
	}
	public List<Map> listStkBasicinfoForGeneration(Map param) {
		return this.getBaseDao().listStkBasicinfoForGeneration(param);
	}
	public List<Map> listAllStkBasicinfoForCache() {
		return this.getBaseDao().listAllStkBasicinfoForCache();
	}

}

