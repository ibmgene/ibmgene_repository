package cn.ibm.com.kernel.service;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.ibm.com.common.util.PageProperty;


/**
 * 说明 ：
 * 作者： leic
 * 创建日期：2010-11-26
 * 最后修改日期：2010-11-26
 * 修改记录：
 */
public interface BaseService<T> {
	 abstract T getModel(Serializable serializable);
	 
	 abstract boolean exists(Serializable serializable);
	 
	 abstract int getCount(PageProperty pageProperty);
	 
	 abstract List<T> list(PageProperty pageProperty);
	 
	 abstract List<T> listAll();
	 
	 
	 
	 
	 /**
	     * @Description:批量创建数据对象
	     * @param po 实体对象
	     */
	 public abstract void insertBat(final List<T> list);
	 
	 /**
	     * @Description:创建数据对象
	     * @param po 实体对象
	     */
	    public abstract void insert(T po);

	    /**
	     * @Description:单条修改数据对象
	     * @param po 实体对象
	     * @return 所影响的行数
	     */
	    public abstract int update(T po);
	    
	    /**
	     * @Description:删除数据对象
	     * @param param map参数
	     * @return 所影响的行数
	     */
	    public abstract int delete(Map param);
}
