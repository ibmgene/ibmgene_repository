package cn.ibm.com.kernel.dao.nws.impl;




import java.util.List;
import java.util.Map;

import cn.ibm.com.common.ajaxpage.PageProperty;
import cn.ibm.com.entity.NwsLawsregulations;
import cn.ibm.com.kernel.dao.impl.BaseDaoImpl;
import cn.ibm.com.kernel.dao.nws.NwsLawsregulationsDao;



/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class NwsLawsregulationsDaoImpl extends BaseDaoImpl<NwsLawsregulations> implements NwsLawsregulationsDao{

	public int listFinancialLawsCount(Map param) {
		// TODO Auto-generated method stub
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("listFinancialLawsCount", param);
		if(count==null){
			return 0;
		}else{
			return count.intValue();
		}
	}

	public List listFinancialLawsByPage(Map param) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList("listFinancialLawsByPage",param);
	}

	public NwsLawsregulations findNwsLawsregulationsById(Map param) {
		return (NwsLawsregulations) this.getSqlMapClientTemplate().queryForObject("findNwsLawsById", param);
	}

	public int getLawsregulationsCount(PageProperty pp) {
		Integer count = (Integer) this.getSqlMapClientTemplate().queryForObject("listFinancialLawsCount", pp.getParamMap());
		if(count!=null){
			return count.intValue();
		}
		return 0;
	}

	public List<Map> listLawsregulationsDatas(PageProperty pp) {
		return this.getSqlMapClientTemplate().queryForList("listFinancialLawsByPage", pp.getParamMap());
	}
	
}
