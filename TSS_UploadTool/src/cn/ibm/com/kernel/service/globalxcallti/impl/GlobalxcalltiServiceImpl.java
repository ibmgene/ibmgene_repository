package cn.ibm.com.kernel.service.globalxcallti.impl;




import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.Globalxcallti;
import cn.ibm.com.kernel.dao.fnd.FndBasicinfoDao;
import cn.ibm.com.kernel.dao.globalxcallti.GlobalxcalltiDao;
import cn.ibm.com.kernel.service.globalxcallti.GlobalxcalltiService;
import cn.ibm.com.kernel.service.impl.BaseServiceImpl;




/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class GlobalxcalltiServiceImpl extends BaseServiceImpl<Globalxcallti,GlobalxcalltiDao> implements GlobalxcalltiService{




	public List<Map> listAllFndBasicinfoForCache() {
		return this.getBaseDao().listAllFndBasicinfoForCache();
	}

	public List<Map> listGlobalxcalltiForTest() {
		return this.getBaseDao().listGlobalxcalltiForTest();
	}

}

