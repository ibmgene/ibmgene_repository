package cn.ibm.com.kernel.service.nws;



import java.util.List;
import java.util.Map;

import cn.ibm.com.common.ajaxpage.PageList;
import cn.ibm.com.common.ajaxpage.PageProperty;
import cn.ibm.com.entity.NwsLawsregulations;
import cn.ibm.com.kernel.service.BaseService;


/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */

public interface NwsLawsregulationsService extends BaseService<NwsLawsregulations> {    
	/**
	 * 新闻法律法规分页查询
	 * @param param 
	 * @return
	 */
	public int listFinancialLawsCount(Map param);
	/**
	 * 新闻法律法规分页查询
	 * @param param
	 * @return
	 */
	public List listFinancialLawsByPage(Map param);
	
	/**
	 * 根据主键查找法律内容
	 * @param param(id-主键)
	 * @return
	 */
	public NwsLawsregulations findNwsLawsregulationsById(Map param);
	/**
	 * 法律分页ajax版
	 * @param param(id-主键)
	 * @return
	 */
	public PageList<Map> listSplitNwsLawsregulations(PageProperty pp) ;
}

