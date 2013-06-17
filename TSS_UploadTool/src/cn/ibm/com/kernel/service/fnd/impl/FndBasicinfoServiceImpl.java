package cn.ibm.com.kernel.service.fnd.impl;




import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.FndBasicinfo;
import cn.ibm.com.kernel.dao.fnd.FndBasicinfoDao;
import cn.ibm.com.kernel.service.fnd.FndBasicinfoService;
import cn.ibm.com.kernel.service.impl.BaseServiceImpl;




/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class FndBasicinfoServiceImpl extends BaseServiceImpl<FndBasicinfo,FndBasicinfoDao> implements FndBasicinfoService{




	public List<Map> listAllFndBasicinfoForCache() {
		return this.getBaseDao().listAllFndBasicinfoForCache();
	}

}

