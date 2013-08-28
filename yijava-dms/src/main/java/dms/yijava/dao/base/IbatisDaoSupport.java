package dms.yijava.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.yijava.common.utils.ReflectionUtils;
import com.yijava.orm.core.JsonPage;
import com.yijava.orm.core.Page;

public class IbatisDaoSupport<T> extends SqlSessionDaoSupport implements
		BaseDAO<T> {

	public static final String POSTFIX_INSERT = ".insert";
	public static final String POSTFIX_UPDATE = ".update";
	public static final String POSTFIX_DELETE = ".delete";
	public static final String POSTFIX_SELECTALL = ".selectAll";
	
	public static final String POSTFIX_DELETE_PRIAMARYKEY = ".deleteByPrimaryKey";
	public static final String POSTFIX_SELECT = ".select";
	
	public static final String POSTFIX_SELECTMAP = ".selectByMap";
	public static final String POSTFIX_SELECTMAP_COUNT = ".selectByMap.count";
	public static final String POSTFIX_SELECTOBJECT = ".selectByObject";
	public static final String POSTFIX_SELECTOBJECT_COUNT = ".selectByObject.count";
	public static final String POSTFIX_SELECTSQL = ".selectBySql";
	public static final String POSTFIX_COUNT = ".count";

	
	protected Class<T> entityClass;	

	/**
	 * 构造方法
	 */
	public IbatisDaoSupport() {
		entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}

	/**
	 * 构造方法
	 * 
	 * @param entityClass orm实体类型class
	 */
	public IbatisDaoSupport(Class<T> entityClass) {
		this.entityClass = entityClass;
	}	
	

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public <T> T get(Serializable id) {
		@SuppressWarnings("unchecked")
		T o = (T) this.getSqlSession().selectOne(entityClass.getSimpleName() + POSTFIX_SELECT, id);
		// TODO Auto-generated method stub
		//T o = (T) getSqlSession().queryForObject(entityClass.getSimpleName() + POSTFIX_SELECT, id);
		if (o == null) {
			throw new ObjectRetrievalFailureException(entityClass, id);
		}
		return o;
	}

	@Override
	public <T> List<T> getAll() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(entityClass.getSimpleName() + POSTFIX_SELECTALL);
		
		
	}

	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub
		getSqlSession().insert(entityClass.getSimpleName() + POSTFIX_INSERT, o);  
	}

	

	@Override
	public int remove(Object o) {
		// TODO Auto-generated method stub
		 return getSqlSession().delete(entityClass.getSimpleName() + POSTFIX_DELETE, o);  
	}

	@Override
	public  int removeById(Serializable id) {
		// TODO Auto-generated method stub
		return getSqlSession().delete(entityClass.getName() + POSTFIX_DELETE_PRIAMARYKEY, id);  
	}

	@Override
	public int update(Object o) {
		// TODO Auto-generated method stub
		 return getSqlSession().update(entityClass.getSimpleName() + POSTFIX_UPDATE, o);  
	}
	@Override
	public JsonPage<T> getScrollData(Map parameters, int offset, int pagesize) {
		// TODO Auto-generated method stub
		
		Long total = (Long) getSqlSession().selectOne(
			    entityClass.getSimpleName() + POSTFIX_SELECTMAP_COUNT,
			    parameters);
		
		  List<T> datas = getSqlSession().selectList(entityClass.getSimpleName() + POSTFIX_SELECTMAP, parameters);
		  
		  
		  
		return new JsonPage<T>(datas,total);
		//return null;
	}

	@Override
	public JsonPage<T> getScrollData(Map parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonPage<T> getScrollData(String name, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonPage<T> getScrollData(Object o, int offset, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonPage<T> getScrollData(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> find(String sql) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(sql);
		//return getSqlSession().selectList(sql);
	}
	
	@Override
	public <T> List<T> find(Map parameters) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(entityClass.getSimpleName() + POSTFIX_SELECT);
		
	}

}
