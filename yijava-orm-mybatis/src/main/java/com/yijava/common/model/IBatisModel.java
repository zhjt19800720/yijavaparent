package com.yijava.common.model;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.rmi.CORBA.Util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

public class IBatisModel<T> extends PageInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4895224366252221777L;

	public static final String HOTSHOP_SQLMAPCLIENT_ID = "sqlMapClient";
	private static final String DEFAULT_STATEMENT_SAVE = "save";
	private static final String DEFAULT_STATEMENT_LIST = "find";
	private static final String DEFAULT_STATEMENT_GET = "load";
	private static final String DEFAULT_STATEMENT_DELETE = "delete";
	private static final String DEFAULT_STATEMENT_UPDATE = "update";
	private static final String DEFAULT_STATEMENT_COUNT = "count";
	private static final String DEFAULT_FROEIGN_FIELD_NAME = "Id";
	private static final String DEFAULT_PK_NAME = "id";
	protected String pk = "id";

	protected String ibatisClientId = "sqlMapClient";
	protected int id;
	protected String startTime;
	protected String endTime;
	private String tableKey;
	private int table;
	private Map<String, IBatisModel<?>> foreignKeys;
	private int tableNum;
	public String toStringFun;
	
	protected void setPk(String field)
	  {
	    this.pk = field;
	  }

	  protected void setTableKey(String tableKey, int tableNum)
	  {
	    this.tableKey = tableKey;
	    this.tableNum = tableNum;
	  }

	  public void setIbatisClientId(String ibatisClientId)
	  {
	    this.ibatisClientId = ibatisClientId;
	  }

	  private void setIBatisClient()
	  {
	    if (getSqlMapClient() == null)
	      setSqlMapClient((SqlMapClient)
	        SpringContainer.getBean(this.ibatisClientId));
	  }

	  public T load()
	  {
	    return load("load");
	  }

	  public T load(String statementName)
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    Object model = getSqlSession().queryForObject(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);
	    if ((model != null) && (this.foreignKeys != null)) {
	      Set keySet = this.foreignKeys.keySet();
	      for (String field : keySet)
	      {
	        IBatisModel foreignModel = (IBatisModel)this.foreignKeys.get(field);
	        try {
	          String key = BeanUtils.getProperty(model, field);

	          foreignModel.setPK(Integer.valueOf(key).intValue());
	          BeanUtils.setProperty(model, 
	            Util.getLowerCaseModelName(foreignModel), foreignModel
	            .load());
	        } catch (IllegalAccessException e) {
	          e.printStackTrace();
	        } catch (InvocationTargetException e) {
	          e.printStackTrace();
	        } catch (NoSuchMethodException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    return model;
	  }

	  public boolean exist()
	  {
	    return exist("count");
	  }

	  public boolean exist(String statementName)
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    Integer num = (Integer)getSqlMapClientTemplate().queryForObject(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);
	    if ((num == null) || (num.intValue() == 0))
	      return false;
	    return true;
	  }

	  public int getInt()
	  {
	    return getInt("count");
	  }

	  public int getInt(String statementName)
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    Object obj = getSqlMapClientTemplate().queryForObject(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);
	    if (obj != null) {
	      return ((Integer)obj).intValue();
	    }
	    return 0;
	  }

	  public String getString()
	  {
	    return getString("count");
	  }

	  public String getString(String statementName)
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    return (String)getSqlMapClientTemplate().queryForObject(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);
	  }

	  public List<T> find()
	  {
	    return find("find");
	  }

	  public List<T> find(String statementName)
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    if (getPerPageSize() > 0)
	    {
	      setDataCount(((Integer)
	        getSqlMapClientTemplate()
	        .queryForObject(
	        Util.getLowerCaseModelName(this) + 
	        "." + (
	        statementName == "find" ? "count" : 
	        new StringBuilder(String.valueOf(statementName)).append("Count").toString()), 
	        this)).intValue());

	      calculate();

	      if (getDataCount() == 0) {
	        return new ArrayList();
	      }
	    }

	    List list = getSqlMapClientTemplate().queryForList(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);

	    if (this.foreignKeys != null)
	    {
	      Iterator localIterator2;
	      for (Iterator localIterator1 = list.iterator(); localIterator1.hasNext(); 
	        localIterator2.hasNext())
	      {
	        Object m = (Object)localIterator1.next();
	        Set keySet = this.foreignKeys.keySet();
	        localIterator2 = keySet.iterator(); continue; String field = (String)localIterator2.next();
	        IBatisModel model = (IBatisModel)this.foreignKeys.get(field);
	        try {
	          String key = BeanUtils.getProperty(m, field);
	          model.setPK(Integer.valueOf(key).intValue());
	          BeanUtils.setProperty(m, 
	            Util.getLowerCaseModelName(model), model.load());
	        } catch (IllegalAccessException e) {
	          e.printStackTrace();
	        } catch (InvocationTargetException e) {
	          e.printStackTrace();
	        } catch (NoSuchMethodException e) {
	          e.printStackTrace();
	        }
	      }
	    }

	    return list;
	  }

	  public List findSingleField(String statementName)
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    return getSqlMapClientTemplate().queryForList(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);
	  }

	  public Object save()
	    throws Exception
	  {
	    return save("save");
	  }

	  public Object save(String statementName)
	    throws Exception
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    Object o = getSqlMapClientTemplate().insert(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);
	    return o;
	  }

	  public int update()
	    throws Exception
	  {
	    return update("update");
	  }

	  public int update(String statementName)
	    throws Exception
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    int n = getSqlMapClientTemplate().update(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);
	    return n;
	  }

	  public boolean saveOrUpdate()
	    throws Exception
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    return saveOrUpdate("save", 
	      "update");
	  }

	  public boolean saveOrUpdate(String saveStatementName, String updateStatementName)
	    throws Exception
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    if (update(updateStatementName) == 0) {
	      try {
	        save(saveStatementName);
	        return true;
	      } catch (Exception e) {
	        update(updateStatementName);
	      }
	    }
	    return false;
	  }

	  public int delete()
	    throws Exception
	  {
	    return delete("delete");
	  }

	  public int delete(String statementName)
	    throws Exception
	  {
	    setIBatisClient();
	    setTableFromTableKey();
	    return getSqlMapClientTemplate().delete(
	      Util.getLowerCaseModelName(this) + "." + statementName, this);
	  }

	  public void updateList(List<IBatisModel> list)
	  {
	    updateList(list, "update");
	  }

	  public void updateList(final List<IBatisModel> list, final String statementName)
	  {
	    setIBatisClient();
	    getSqlMapClientTemplate().execute(new SqlMapClientCallback()
	    {
	      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
	        executor.startBatch();
	        for (IBatisModel obj : list) {
	          obj.setTableFromTableKey();
	          executor.update(Util.getLowerCaseModelName(obj) + "." + 
	            statementName, obj);
	        }
	        return Integer.valueOf(executor.executeBatch());
	      }
	    });
	  }

	  public void saveList(List<IBatisModel> list)
	  {
	    saveList(list, "save");
	  }

	  public void saveList(final List<IBatisModel> list, final String statementName)
	  {
	    setIBatisClient();
	    getSqlMapClientTemplate().execute(new SqlMapClientCallback()
	    {
	      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
	        executor.startBatch();
	        for (IBatisModel obj : list) {
	          obj.setTableFromTableKey();
	          executor.insert(Util.getLowerCaseModelName(obj) + "." + 
	            statementName, obj);
	        }
	        return Integer.valueOf(executor.executeBatch());
	      }
	    });
	  }

	  public void deleteList(List<IBatisModel> list)
	  {
	    deleteList(list, "delete");
	  }

	  public void deleteList(final List<IBatisModel> list, final String statementName)
	  {
	    setIBatisClient();
	    getSqlMapClientTemplate().execute(new SqlMapClientCallback()
	    {
	      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
	        executor.startBatch();
	        for (IBatisModel obj : list) {
	          obj.setTableFromTableKey();
	          executor.delete(Util.getLowerCaseModelName(obj) + "." + 
	            statementName, obj);
	        }
	        return Integer.valueOf(executor.executeBatch());
	      }
	    });
	  }

	  public IBatisModel setPageNum(int num)
	  {
	    setPerPageSize(num);
	    return this;
	  }

	  public IBatisModel like(String field)
	  {
	    if (StringUtils.isEmpty(field))
	      return this;
	    try
	    {
	      String value = BeanUtils.getProperty(this, field);
	      if (!StringUtils.isEmpty(value))
	        BeanUtils.setProperty(this, field, "%" + value + "%");
	    } catch (IllegalAccessException e) {
	      e.printStackTrace();
	    } catch (InvocationTargetException e) {
	      e.printStackTrace();
	    } catch (NoSuchMethodException e) {
	      e.printStackTrace();
	    }
	    return this;
	  }

	  public IBatisModel startsWith(String field)
	  {
	    if (StringUtils.isEmpty(field))
	      return this;
	    try {
	      String value = BeanUtils.getProperty(this, field);
	      if (!StringUtils.isEmpty(value))
	        BeanUtils.setProperty(this, field, value + "%");
	    } catch (IllegalAccessException e) {
	      e.printStackTrace();
	    } catch (InvocationTargetException e) {
	      e.printStackTrace();
	    } catch (NoSuchMethodException e) {
	      e.printStackTrace();
	    }
	    return this;
	  }

	  public IBatisModel endsWith(String field)
	  {
	    if (StringUtils.isEmpty(field))
	      return this;
	    try {
	      String value = BeanUtils.getProperty(this, field);
	      if (!StringUtils.isEmpty(value))
	        BeanUtils.setProperty(this, field, "%" + value);
	    } catch (IllegalAccessException e) {
	      e.printStackTrace();
	    } catch (InvocationTargetException e) {
	      e.printStackTrace();
	    } catch (NoSuchMethodException e) {
	      e.printStackTrace();
	    }
	    return this;
	  }

	  public IBatisModel foreignKey(Class<? extends IBatisModel> modelClass)
	  {
	    return foreignKey(Util.getLowerCaseClassName(modelClass) + 
	      "Id", modelClass);
	  }

	  public IBatisModel foreignKey(String field, Class<? extends IBatisModel> modelClass)
	  {
	    if ((field == null) || (StringUtils.isEmpty(field))) {
	      return this;
	    }
	    if (this.foreignKeys == null)
	      this.foreignKeys = new HashMap();
	    try {
	      this.foreignKeys.put(field, (IBatisModel)modelClass.newInstance());
	    } catch (InstantiationException e) {
	      e.printStackTrace();
	    } catch (IllegalAccessException e) {
	      e.printStackTrace();
	    }
	    return this;
	  }

	  public int getId() {
	    return this.id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  private void setPK(int pk) {
	    if (this.pk.equals("id"))
	      setId(pk);
	    else
	      try {
	        BeanUtils.setProperty(this, this.pk, Integer.valueOf(pk));
	      } catch (IllegalAccessException e) {
	        e.printStackTrace();
	      } catch (InvocationTargetException e) {
	        e.printStackTrace();
	      }
	  }

	  public String getStartTime()
	  {
	    return this.startTime;
	  }

	  public void setStartTime(String startTime) {
	    this.startTime = startTime;
	  }

	  public String getEndTime() {
	    return this.endTime;
	  }

	  public void setEndTime(String endTime) {
	    this.endTime = endTime;
	  }

	  public String getTableKey() {
	    return this.tableKey;
	  }

	  public int getTable() {
	    return this.table;
	  }

	  public void setTable(int table) {
	    this.table = table;
	  }

	  private void setTableFromTableKey()
	  {
	    if (getTableKey() == null)
	      return;
	    String key = null;
	    try {
	      key = BeanUtils.getProperty(this, getTableKey());
	    } catch (IllegalAccessException e) {
	      e.printStackTrace();
	    } catch (InvocationTargetException e) {
	      e.printStackTrace();
	    } catch (NoSuchMethodException e) {
	      e.printStackTrace();
	    }
	    if ((key == null) || (key.trim().equals("")))
	      return;
	    setTable(Integer.valueOf(key).intValue() % this.tableNum);
	  }

	  protected int getTableNum()
	  {
	    return this.tableNum;
	  }

	  public String getToStringFun() {
	    return this.toStringFun;
	  }

	  public void setToStringFun(String toStringFun) {
	    this.toStringFun = toStringFun;
	  }

	  public String toString()
	  {
	    if (this.toStringFun != null)
	      try {
	        return (String)getClass().getMethod(this.toStringFun, null)
	          .invoke(this, null);
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    return null;
	  }

}
