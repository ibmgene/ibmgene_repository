package cn.ibm.com.kernel.dao.globalxcallti.impl;



import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.Globalxcallti;
import cn.ibm.com.kernel.dao.globalxcallti.GlobalxcalltiDao;
import cn.ibm.com.kernel.dao.impl.BaseDaoImpl;



/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class GlobalxcalltiDaoImpl extends BaseDaoImpl<Globalxcallti> implements GlobalxcalltiDao{




	public List<Map> listAllFndBasicinfoForCache() {
		return this.getSqlMapClientTemplate().queryForList("listAllFndBasicinfoForCache");
	}

	public List<Map> listGlobalxcalltiForTest() {
		return this.getSqlMapClientTemplate().queryForList("listGlobalxcalltiForTest");
	}

	
}
