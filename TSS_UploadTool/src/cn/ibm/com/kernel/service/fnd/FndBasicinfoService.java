package cn.ibm.com.kernel.service.fnd;



import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.FndBasicinfo;
import cn.ibm.com.kernel.service.BaseService;



/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */

public interface FndBasicinfoService extends BaseService<FndBasicinfo> {   
	

	
	/**
	 * 获取全部基金基础信息
	 * @return
	 */
	List<Map> listAllFndBasicinfoForCache();
  
}

