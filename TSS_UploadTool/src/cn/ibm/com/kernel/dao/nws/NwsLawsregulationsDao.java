package cn.ibm.com.kernel.dao.nws;




import java.util.List;
import java.util.Map;

import cn.ibm.com.common.ajaxpage.PageProperty;
import cn.ibm.com.entity.NwsLawsregulations;
import cn.ibm.com.kernel.dao.BaseDao;


/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public interface NwsLawsregulationsDao extends BaseDao<NwsLawsregulations>{

	/**
	 * 新闻法律法规分页查询
	 * @param param
	 * @return
	 */
	int listFinancialLawsCount(Map param);
	/**
	 * 新闻法律法规分页查询
	 * @param param
	 * @return
	 */
	List listFinancialLawsByPage(Map param);
	/**
	 * 根据主键查找法律内容
	 * @param param(id-主键)
	 * @return
	 */
	public NwsLawsregulations findNwsLawsregulationsById(Map param);
	/**
	 * 检索法律总条数
	 * @param param(id-主键)
	 * @return
	 */
	public int getLawsregulationsCount(PageProperty pp);
	/**
	 * 检索法律内容
	 * @param param(id-主键)
	 * @return
	 */
	public List<Map> listLawsregulationsDatas(PageProperty pp);

}
