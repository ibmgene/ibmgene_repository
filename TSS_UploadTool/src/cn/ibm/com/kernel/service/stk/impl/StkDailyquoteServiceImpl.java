package cn.ibm.com.kernel.service.stk.impl;



import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.StkDailyquote;
import cn.ibm.com.kernel.dao.stk.StkDailyquoteDao;
import cn.ibm.com.kernel.service.impl.BaseServiceImpl;
import cn.ibm.com.kernel.service.stk.StkDailyquoteService;


/**
 * StkDailyquoteServiceImpl.java, Created on  2010-12-05
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2010 <br/>
 * @author leic
 * @version $Revision: 1.0, Date: 2010-12-05  22:44:40
 */
public class StkDailyquoteServiceImpl extends BaseServiceImpl<StkDailyquote,StkDailyquoteDao> implements StkDailyquoteService{

	public StkDailyquote findStkDailyquoteBycode(Map param) {
		return this.getBaseDao().findStkDailyquoteBycode(param);
	}
	
	public List listStkDailyquoteBycode(Map param) {
		return this.getBaseDao().listStkDailyquoteBycode(param);
	}

}

