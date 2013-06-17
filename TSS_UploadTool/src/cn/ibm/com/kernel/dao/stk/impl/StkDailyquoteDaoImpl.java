package cn.ibm.com.kernel.dao.stk.impl;




import java.util.List;
import java.util.Map;

import cn.ibm.com.entity.StkDailyquote;
import cn.ibm.com.kernel.dao.impl.BaseDaoImpl;
import cn.ibm.com.kernel.dao.stk.StkDailyquoteDao;



/**
 * StkDailyquoteDaoImpl.java, Created on  2010-12-05
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2010 <br/>
 * @author hyman
 * @version Revision: 1.0, Date: 2010-12-05  22:44:40 
 */
public class StkDailyquoteDaoImpl extends BaseDaoImpl<StkDailyquote> implements StkDailyquoteDao{

	public StkDailyquote findStkDailyquoteBycode(Map param) {
		return (StkDailyquote) this.getSqlMapClientTemplate().queryForObject("findStkDailyquoteBycode", param);

	}
	
	public List listStkDailyquoteBycode(Map param) {
		return  this.getSqlMapClientTemplate().queryForList("listDailyquoteBycode", param);

	}
	
}
