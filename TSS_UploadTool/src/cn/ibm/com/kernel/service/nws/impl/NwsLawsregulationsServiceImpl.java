package cn.ibm.com.kernel.service.nws.impl;



import java.util.List;
import java.util.Map;

import cn.ibm.com.common.ajaxpage.PageList;
import cn.ibm.com.common.ajaxpage.PageProperty;
import cn.ibm.com.common.util.PageUtil;
import cn.ibm.com.entity.NwsLawsregulations;
import cn.ibm.com.kernel.dao.nws.NwsLawsregulationsDao;
import cn.ibm.com.kernel.service.impl.BaseServiceImpl;
import cn.ibm.com.kernel.service.nws.NwsLawsregulationsService;




/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */

public class NwsLawsregulationsServiceImpl extends BaseServiceImpl<NwsLawsregulations,NwsLawsregulationsDao> implements NwsLawsregulationsService{

	public int listFinancialLawsCount(Map param) {
		// TODO Auto-generated method stub
		return this.getBaseDao().listFinancialLawsCount(param);
	}

	public List listFinancialLawsByPage(Map param) { 
		// TODO Auto-generated method stub
		return this.getBaseDao().listFinancialLawsByPage(param);
	}

	public NwsLawsregulations findNwsLawsregulationsById(Map param) {
		// TODO Auto-generated method stub
		return this.getBaseDao().findNwsLawsregulationsById(param);
	}

	public PageList<Map> listSplitNwsLawsregulations(PageProperty pp) {
		int count = this.getBaseDao().getLawsregulationsCount(pp);
		int start = PageUtil.getStart(pp.getNpage(), count, pp
				.getNpagesize());
		int end = PageUtil.getEnd(pp.getNpage(), count, pp.getNpagesize());
		pp.putParamMap("start", start);
		pp.putParamMap("end", end);
		PageList<Map>	pageList = new PageList<Map>(pp, count, this.getBaseDao().listLawsregulationsDatas(pp));
		return pageList;
	}

}

