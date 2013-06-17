package cn.ibm.com.kernel.service.impl;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.ibm.com.common.util.PageProperty;
import cn.ibm.com.kernel.dao.BaseDao;
import cn.ibm.com.kernel.service.BaseService;



/**
 * 说明 ：
 * 作者： leic
 * 创建日期：2010-11-26
 * 最后修改日期：2010-11-26
 * 修改记录：
 */
public class BaseServiceImpl<T,I extends BaseDao<T>> implements BaseService<T> {
	protected static final Log log = LogFactory.getLog("log");

	private I baseDao;
	
	public I getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(I baseDao) {
		this.baseDao = baseDao;
	}

	public T getModel(Serializable serializable) {
		return baseDao.getModel(serializable);
	}

	public boolean exists(Serializable serializable) {
		if(getModel(serializable) == null){
		    return false;
		}else{
			return true;
		}
	}

	public int getCount(PageProperty pageProperty) {
		return baseDao.getCount(pageProperty);
	}

	public List<T> list(PageProperty pageProperty) {
		return baseDao.list(pageProperty);
	}

	public List<T> listAll() {
		return baseDao.listAll();
	}
	
	
	
	/**
     * @Description:创建数据对象
     * @param po 实体对象
     */
	public void insert(T model) {
		baseDao.insert(model);
	}

	/**
     * @Description:单条修改数据对象
     * @param po 实体对象
     * @return 所影响的行数
     */
	public int update(T model) {
		int result = baseDao.update(model);
		return result;
	}
	
	/**
     * @Description:删除数据对象
     * @param param map参数
     * @return 所影响的行数
     */
	public int delete(Map param) {
		int result = baseDao.delete(param);
		return result;
	}

	public void insertBat(List<T> list) {
		baseDao.insertBat(list);
		
	}
}
