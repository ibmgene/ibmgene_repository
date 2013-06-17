package cn.ibm.com.kernel.dao.impl;



import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.ibm.com.common.util.PageProperty;
import cn.ibm.com.kernel.dao.BaseDao;

import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * 说明 ：
 * 作者： leic
 * 创建日期：2010-11-26
 * 最后修改日期：2010-11-26
 * 修改记录：
 */
public class BaseDaoImpl <T> extends SqlMapClientDaoSupport implements BaseDao<T> {
	protected static final Log log = LogFactory.getLog("log");
	
	Class<T> poClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	String poClassName = poClass.getSimpleName();
	public T getModel(Serializable serializable) {
		return (T) this.getSqlMapClientTemplate().queryForObject("get" + poClassName, serializable);
	}

	public int getCount(PageProperty pageProperty) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("get" + poClassName + "Count", pageProperty);
		return count;
	}

	public List<T> list(PageProperty pageProperty) {
		return this.getSqlMapClientTemplate().queryForList("list" + poClassName, pageProperty);
	}

	public List<T> listAll() {
		return this.getSqlMapClientTemplate().queryForList("listAll" + poClassName, null);
	}
	
	
	/**
     * @Description:创建数据对象
     * @param po 实体对象
     */
	public void insert(T model) {
		this.getSqlMapClientTemplate().insert("insert" + poClassName, model);
	}

	 /**
     * @Description:单条修改数据对象
     * @param po 实体对象
     * @return 所影响的行数
     */
	public int update(T model) {
		return this.getSqlMapClientTemplate().update("update" + poClassName,
				model);
	}
	
	/**
     * @Description:删除数据对象
     * @param param map参数
     * @return 所影响的行数
     */
	public int delete(Map param) {
		return this.getSqlMapClientTemplate().update("delete" + poClassName,param);
	}

	public void insertBat(final List<T> list) {
		try {

	           if (list != null) {

	              this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {

	                  public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {

	                     executor.startBatch();

	                     for (int i = 0, n = list.size(); i < n; i++) {

	                         executor.insert("insert" + poClassName, list.get(i));

	                     }

	                     executor.executeBatch();

	                     return null;

	                  }

	              });

	           }

	       } catch (Exception e) {

	           if (log.isDebugEnabled()) {

	              e.printStackTrace();

	              log.debug("batchInsert error: id [" + "insert" + poClassName + "], parameterObject ["+ list + "].  Cause: "+ e.getMessage());

	           }

	       }


		
	}


}
