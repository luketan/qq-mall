package com.honglinktech.zbgj.base;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.StringUtils;

import com.honglinktech.zbgj.dao.helper.QueryHelper;
  
/** 
 * 使用场景 
 *  
 * 数据库是Oracle 
 * 主键列名为id 
 * 主键由程序提供（这里用的是UUID） 
 */  
public abstract class BaseDao<T>{
	private static Logger logger = Logger.getLogger(BaseDao.class); 
	
	public static final String TABLENAME ="tableName";
	
    /** 设置一些操作的常量 */  
    public static final String SQL_INSERT = "insert";  
    public static final String SQL_UPDATE = "update";  
    public static final String SQL_DELETE = "delete";  
  
    protected JdbcTemplate jdbcTemplate;  
  
    private Class<T> entityClass;  
  
    @SuppressWarnings("unchecked")  
    public BaseDao() {
//        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
//        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
    	Type type = getClass().getGenericSuperclass();
    	if(!(type instanceof ParameterizedType)){
    	    type = getClass().getSuperclass().getGenericSuperclass();
    	}
    	entityClass = (Class<T>)((ParameterizedType)type).getActualTypeArguments()[0];
//        System.out.println("Dao实现类是：" + entityClass.getName());  
    }  
  
    /**
     * 插入数据 返回自增长id
     * @param entity
     * @return
     * @throws BaseException
     */
    @SuppressWarnings("unused")
	public int save(T entity)  throws BaseException {  
        String sql = this.makeSql(entity,SQL_INSERT);  
        Object[] args = this.setArgs(entity, SQL_INSERT);  
        int[] argTypes = this.setArgTypes(entity, SQL_INSERT);
      
        logger.info("[save-sql]->"+sql);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				for(int i=0;i<args.length;i++){
					ps.setObject(i+1, args[i]);
				}
                return ps;
			}
		}, keyHolder);
//        return jdbcTemplate.update(sql.toString(), args, argTypes);  
        return keyHolder.getKey()!=null?keyHolder.getKey().intValue():0;
    }  
  
   
    public int update(T entity) throws BaseException {  
        String sql = this.makeSql(entity,SQL_UPDATE);  
        Object[] args = this.setArgs(entity, SQL_UPDATE);  
        int[] argTypes = this.setArgTypes(entity, SQL_UPDATE);
        logger.info("[update-sql]->"+sql);
        return jdbcTemplate.update(sql, args, argTypes);  
    }  
  
   
    public int delete(T entity) throws BaseException {  
        String sql = this.makeSql(entity, SQL_DELETE);  
        Object[] args = this.setArgs(entity, SQL_DELETE);  
        int[] argTypes = this.setArgTypes(entity, SQL_DELETE);
        logger.info("[delete-sql]->"+sql);
        System.out.println("[delete-sql]->"+sql);
        return jdbcTemplate.update(sql, args, argTypes);  
    }  
  
   
    public int deleteById(Serializable id) {  
        String sql = " DELETE FROM " + getDBMapping(TABLENAME)[0] + " WHERE id=?";
        logger.info("[deleteById-sql]->"+sql);
        System.out.println("[deleteById-sql]->"+sql);
        return jdbcTemplate.update(sql, id);  
    }  
  
   
    public void deleteAll() {  
        String sql = " TRUNCATE TABLE " + getDBMapping(TABLENAME)[0];
        logger.info("[deleteAll-sql]->"+sql);
        jdbcTemplate.execute(sql);  
    }  
  
    public List<T> find(String sql){
    	logger.info("[find-sql]->"+sql);
    	return jdbcTemplate.query(sql, getRowMapper());
    }
    
    public Map<String, Object> findMap(String sql){
    	logger.info("[findMap-sql]->"+sql);
    	return jdbcTemplate.queryForMap(sql);
    }
    
	public List<T> find(String sql, RowMapper<T> rowMapper){
    	logger.info("[find-rowMapper-sql]->"+sql);
    	return jdbcTemplate.query(sql, rowMapper);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List findRowMapper(String sql, RowMapper rowMapper){
    	logger.info("[findRowMapper-rowMapper-sql]->"+sql);
    	return jdbcTemplate.query(sql, rowMapper);
    }
    
    public int updateExecute(String sql){
    	logger.info("[update Execute-sql]->"+sql);
    	return jdbcTemplate.update(sql);
    }
    
    public Map<String,Object> queryForMap(String sql){
    	logger.info("[queryForMap-sql]->"+sql);
    	return jdbcTemplate.queryForMap(sql);
    }
    /** 
     * 未完成 
     * @throws BaseException 
     */  
   
    public void saveBatch(List<T> list) throws BaseException {
    	if(list == null || list.size() == 0)
    		return;
    	String sql = makeBatchSql(list,SQL_INSERT);
    	logger.info("[batchSave-sql]->"+sql);
    	jdbcTemplate.execute(sql);
    }
  
    /** 
     * 未完成 
     */  
   
    public void batchUpdate(List<T> list) {
    	
    }
  
    public T findById(Serializable id) {  
        String sql = "SELECT * FROM " + getDBMapping(TABLENAME)[0] + " WHERE id=?"; 
//        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
        List<T> list = jdbcTemplate.query(sql, getRowMapper(), id);
        return list!=null && list.size()>0?list.get(0):null;  
    }  
   
    /**
     * whereMap key是枚举名称
     * @param map
     * @return
     */
    public List<T> findByWhere(Map<String, String[]> map) {
        String sql = "SELECT * FROM " + getDBMapping(TABLENAME)[0]+" "+makeWhereByMapArr(map); 
        logger.info("[sql-findByWhere]->"+sql);
        System.out.println("[sql-findByWhere]->"+sql);
        return jdbcTemplate.query(sql, getRowMapper());  
    }
    
    public List<T> findAll() {
        String sql = "SELECT * FROM " + getDBMapping(TABLENAME)[0];
        return jdbcTemplate.query(sql, getRowMapper());  
    }  
  
    public QueryHelper<T> findByQueryHelperNoCount(QueryHelper<T> queryHelper)throws BaseException  {  
        StringBuffer sql = new StringBuffer(" SELECT * FROM " + getDBMapping(TABLENAME)[0]); 
        StringBuffer sqlWhere = new StringBuffer();
        StringBuffer sqlOrderBy = new StringBuffer();
        if(!StringUtils.isEmpty(queryHelper.getQueryWhere())){
        	sqlWhere.append(" "+queryHelper.getQueryWhere());
        }else {
            if (queryHelper.getWhereMap() != null && queryHelper.getWhereMap().size() > 0) {
            	sqlWhere.append(makeWhereByMapArr(queryHelper.getWhereMap()));
            }  
            if (queryHelper.getOrderBy() != null && queryHelper.getOrderBy().size() > 0) {     	
            	sqlOrderBy.append(" ORDER BY ");  
                for (Map.Entry<String, String> me : queryHelper.getOrderBy().entrySet()) {
                    String columnName = me.getKey();  
                    String columnValue = me.getValue();  
                    sqlOrderBy.append(columnName).append(" ").append(columnValue).append(",");  
                }
                sqlOrderBy = sqlOrderBy.deleteCharAt(sqlOrderBy.length() - 1);  
            }  
        }
        sql.append(sqlWhere).append(sqlOrderBy);
        sql.append(" limit ?,? ");  
        logger.info("[sql-findByQueryHelperNoCount]->"+sql);
        System.out.println("[sql-findByQueryHelperNoCount]->"+sql);
        Object[] args = { (queryHelper.getIndex()-1) * queryHelper.getSize(), queryHelper.getSize() };  
//        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);  
        queryHelper.setResultList(jdbcTemplate.query(sql.toString(), args, getRowMapper()));
        return queryHelper;  
    }
    
    public QueryHelper<T> findByQueryHelper(QueryHelper<T> queryHelper) throws BaseException { 
        StringBuffer sql = new StringBuffer(" SELECT * FROM " + getDBMapping(TABLENAME)[0]); 
        StringBuffer sqlWhere = new StringBuffer();
        StringBuffer sqlOrderBy = new StringBuffer();
        if(!StringUtils.isEmpty(queryHelper.getQueryWhere())){
        	sqlWhere.append(" "+queryHelper.getQueryWhere());
        }else {
            if (queryHelper.getWhereMap() != null && queryHelper.getWhereMap().size() > 0) {
            	sqlWhere.append(makeWhereByMapArr(queryHelper.getWhereMap()));
            }  
        }
        if (queryHelper.getOrderBy() != null && queryHelper.getOrderBy().size() > 0) {        	
        	sqlOrderBy.append(makeOrderByMap(queryHelper.getOrderBy()));
        }  
        sql.append(sqlWhere).append(sqlOrderBy);
        sql.append(" limit ?,? ");  
        logger.info("[sql-findByQueryHelper]->"+sql);
        System.out.println("[sql-findByQueryHelper]->"+sql);
        Object[] args = { (queryHelper.getIndex()-1) * queryHelper.getSize(), queryHelper.getSize() };  
//        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);  
        queryHelper.setResultList(jdbcTemplate.query(sql.toString(), args, getRowMapper()));
        queryHelper.setTotalRow(findCountWhere(sqlWhere.toString()));
        return queryHelper;  
    }
    
    private String makeWhereByMapArr(Map<String, String[]> map){
    	StringBuffer sqlWhere = new StringBuffer();
    	sqlWhere.append(" WHERE 1=1 ");
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String[]> me : map.entrySet()) {  
                String columnName = me.getKey();  
                Object[] objs = getDBMapping(columnName);
                if(null!=objs){
	                String[] columnValue = me.getValue(); 
	                if(columnValue!=null && columnValue.length==1){
	                	 if(!StringUtils.isEmpty(columnValue[0])){
	                		 if(columnValue[0].indexOf("%")!=-1){
	                			 sqlWhere.append(" AND ").append(objs[0]).append(" like ").append("'"+columnValue[0]+"'");
	                		 }else{
	                			 sqlWhere.append(" AND ").append(objs[0]).append("=").append("'"+columnValue[0]+"'");
	                		 }
	                	 }
	                }else if(columnValue!=null && columnValue.length>1){
	                	 StringBuffer sqlWhereFlag = new StringBuffer();
	                	 sqlWhereFlag.append(" AND ( ");
	                	 for(String cv:columnValue){
	                		 if(!StringUtils.isEmpty(cv)){
	                			 if(columnValue[0].indexOf("%")!=-1){
	                				 sqlWhereFlag.append(objs[0]).append(" like ").append("'"+cv+"'").append(" OR ");
		                		 }else{
		                			 sqlWhereFlag.append(objs[0]).append("=").append("'"+cv+"'").append(" OR ");
		                		 }
	                		 }
	                	 }
	                	 sqlWhere.append(sqlWhereFlag.substring(0, sqlWhereFlag.lastIndexOf("OR")));
	                	 sqlWhere.append(")");
	                }
                }
            }
        }  
    	return sqlWhere.toString();
    }
    private String makeOrderByMap(Map<String, String> map){
    	StringBuffer sqlOrderBy = new StringBuffer();
        if (map != null && map.size() > 0) {
        	sqlOrderBy.append(" ORDER BY ");
            for (Map.Entry<String, String> me : map.entrySet()) {  
                String columnName = me.getKey();  
                Object[] objs = getDBMapping(columnName);
                if(null!=objs){
	                String orderValue = me.getValue();
	                orderValue = StringUtils.isEmpty(orderValue)?"ASC":orderValue;
	                sqlOrderBy.append(objs[0]).append(" ").append(orderValue).append(",");  
                }
            }
        }  
        sqlOrderBy = sqlOrderBy.deleteCharAt(sqlOrderBy.length() - 1);  
    	return sqlOrderBy.toString();
    }
    @SuppressWarnings("unused")
	private String makeWhereByMap(Map<String, String> map){
    	StringBuffer sqlWhere = new StringBuffer();
    	sqlWhere.append(" WHERE 1=1 ");
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> me : map.entrySet()) {  
                String columnName = me.getKey();
                Object[] objs = getDBMapping(columnName);
                if(null!=objs){
                	 String columnValue = me.getValue(); 
                    
                     if(columnValue.indexOf("%")!=-1){
                    	 sqlWhere.append(" AND ").append(objs[0]).append(" like ").append("'"+columnValue+"'");
            		 }else{
            			 sqlWhere.append(" AND ").append(objs[0]).append("=").append("'"+columnValue+"'");
            		 }
                }
            }
        }  
    	return sqlWhere.toString();
    }
    
    // 组装SQL  
    private String makeBatchSql(List<T> entitys, String sqlFlag) throws BaseException { 
    	
    	if(entitys==null || entitys.size()==0)
    		throw new RuntimeException("not null");
    	
        StringBuffer sql = new StringBuffer();
        try{
	        Field[] fields = (entityClass).getDeclaredFields();
	        if (sqlFlag.equals(SQL_INSERT)) {
	        	sql.append(" INSERT INTO " + getDBMapping(TABLENAME)[0]);  
	            sql.append("(");  
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entitys.get(0));
	                if(!StringUtils.isEmpty(fieldValue) || ("updateTime".equals(fields[i].getName()) || "createTime".equals(fields[i].getName()))){
		            	Object[] objs = getDBMapping(fields[i].getName());
		            	if((objs!=null && !(boolean)objs[3])){
			                String column = String.valueOf(getDBMapping(fields[i].getName())[0]);  
			                sql.append(column).append(","); 
		            	}
	                }
	            }
	            sql = sql.deleteCharAt(sql.length() - 1);  
	            sql.append(") VALUES ");
	        	for(T entity:entitys){
		            sql.append(" (");  
		            for (int i = 0; fields != null && i < fields.length; i++) {
		            	fields[i].setAccessible(true); // 暴力反射 
		                Object fieldValue =fields[i].get(entity);
		                if(!StringUtils.isEmpty(fieldValue) || ("updateTime".equals(fields[i].getName()) || "createTime".equals(fields[i].getName()))){
		                	Object[] objs = getDBMapping(fields[i].getName());
		                	if(("updateTime".equals(fields[i].getName()) || "createTime".equals(fields[i].getName()))){
		                		sql.append("now(),");
		                	}else if(objs!=null && !(boolean)objs[3]){
		                		if((int)objs[1]==Types.VARCHAR){
		                			sql.append("'"+fieldValue+"',");
		                		}else{
		                			sql.append(fieldValue+",");
		                		}
		                		 
		                	}
		                }
		            }
		            sql = sql.deleteCharAt(sql.length() - 1);  
		            sql.append("),");
	        	}
	        	sql = sql.deleteCharAt(sql.length() - 1);  
	        }else if (sqlFlag.equals(SQL_UPDATE)) {
	        } else if (sqlFlag.equals(SQL_DELETE)) {
	        }  
        }catch(Exception e) {
			e.printStackTrace();
			ExceptionEnum ee = ExceptionEnum.COMMON_DATEBASE_REFLEX_ERROE;
			ee.setLogString(e.getMessage());
			throw new BaseException(ee);
		}
        
        return sql.toString();  
    }
    // 组装SQL  
    private String makeSql(T entity, String sqlFlag) throws BaseException {  
        StringBuffer sql = new StringBuffer();
        try{
	        Field[] fields = (entityClass).getDeclaredFields();
	        if (sqlFlag.equals(SQL_INSERT)) {
	            sql.append(" INSERT INTO " + getDBMapping(TABLENAME)[0]);  
	            sql.append("(");  
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(!StringUtils.isEmpty(fieldValue) || ("updateTime".equals(fields[i].getName()) || "createTime".equals(fields[i].getName()))){
		            	Object[] objs = getDBMapping(fields[i].getName());
		            	if((objs!=null && !(boolean)objs[3])){
			                String column = String.valueOf(getDBMapping(fields[i].getName())[0]);  
			                sql.append(column).append(","); 
		            	}
	                }
	            }  
	            sql = sql.deleteCharAt(sql.length() - 1);  
	            sql.append(") VALUES (");  
	            for (int i = 0; fields != null && i < fields.length; i++) { 
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(!StringUtils.isEmpty(fieldValue) || ("updateTime".equals(fields[i].getName()) || "createTime".equals(fields[i].getName()))){
	                	Object[] objs = getDBMapping(fields[i].getName());
	                	if(objs!=null && !(boolean)objs[3]){
	                		sql.append("?,"); 
	                	}
	                }
	            }  
	            sql = sql.deleteCharAt(sql.length() - 1);  
	            sql.append(")");  
	        } else if (sqlFlag.equals(SQL_UPDATE)) {  
	            sql.append(" UPDATE " + getDBMapping(TABLENAME)[0] + " SET ");  
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(null!=fieldValue 
	                		&& !"updateTime".equals(fields[i].getName())
	                		&& !"createTime".equals(fields[i].getName())){
		            	Object[] objs = getDBMapping(fields[i].getName());
		            	
		                if (objs==null || Boolean.valueOf(objs[2].toString())) { // id 代表主键  
		                    continue; 
		                }
		                String column = String.valueOf(objs[0]); 
		                sql.append(column).append("=").append("?,"); 
	                }
	                
	            }  
	            sql = sql.deleteCharAt(sql.length() - 1);  
	            sql.append(" WHERE ");
	            
	            boolean exceptionFlag = false;
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(null!=fieldValue 
	                		&& !"updateTime".equals(fields[i].getName())
	                		&& !"createTime".equals(fields[i].getName())){
		        		Object[] objs = getDBMapping(fields[i].getName());
		                if (objs!=null && Boolean.valueOf(objs[2].toString())) {
		                	 sql.append(objs[0].toString()+"=?,"); 
		                	 exceptionFlag = true;
		                }
	                }
	            }
	            if(!exceptionFlag){
	            	throw new BaseException("修改调用此方法必须有主键");
	            }
	            sql = sql.deleteCharAt(sql.length() - 1);  
	            
	        } else if (sqlFlag.equals(SQL_DELETE)) {  
	            sql.append(" DELETE FROM " + getDBMapping(TABLENAME)[0] + " WHERE 1=1 ");
	            
	            boolean exceptionFlag = false;
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(!StringUtils.isEmpty(fieldValue)){
		            	Object[] objs = getDBMapping(fields[i].getName());
//		                if (objs!=null && Boolean.valueOf(objs[2].toString())) {
		            	if (objs!=null) {
		                	 sql.append(" and "+objs[0].toString()+"=? "); 
		                	 exceptionFlag = true;
		                }
	                }
	            }
	            if(!exceptionFlag){
	            	throw new BaseException(ExceptionEnum.COMMON_DATEBASE_PRIMARYKEY_ERROE);
	            }
	            sql = sql.deleteCharAt(sql.length() - 1);
	        }  
        }catch(IllegalArgumentException|IllegalAccessException e) {
			e.printStackTrace();
			ExceptionEnum ee = ExceptionEnum.COMMON_DATEBASE_REFLEX_ERROE;
			ee.setLogString(e.getMessage());
			throw new BaseException(ee);
		} 
        
        return sql.toString();  
    }  
    
    // 设置参数  
    private Object[] setArgs(T entity, String sqlFlag) throws BaseException{
    	try{
	        Field[] fields = (entityClass).getDeclaredFields();
	        if (sqlFlag.equals(SQL_INSERT)) {  
	            List<Object> args = new ArrayList<Object>();
	            for (int i = 0; args != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(!StringUtils.isEmpty(fieldValue)){
		            	Object[] objs = getDBMapping(fields[i].getName());
		            	if(objs!=null && !(boolean)objs[3]){
			                try {
			                    fields[i].setAccessible(true); // 暴力反射 
			                    if(!StringUtils.isEmpty(fields[i].get(entity))){
			                    	args.add(fields[i].get(entity));
			                    }
			                } catch (Exception e) {  
			                    throw new BaseException(ExceptionEnum.COMMON_DATEBASE_PARAMETER_ERROE);
			                }  
		            	}
	                }else if(("updateTime".equals(fields[i].getName()) || "createTime".equals(fields[i].getName()))){
	                	args.add(new Date());
	                }
	                
	            }
	            return args.toArray();  
	        } else if (sqlFlag.equals(SQL_UPDATE)) {
	        	 
	        	List<Object> argsList =new ArrayList<Object>();
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(null!=fieldValue 
	                		&& !"updateTime".equals(fields[i].getName())
	                		&& !"createTime".equals(fields[i].getName())){
	                	Object[] objs = getDBMapping(fields[i].getName());
		            	if (objs==null || Boolean.valueOf(objs[2].toString())) { //   
		                    continue; 
		                }
		                argsList.add(fieldValue);
	                }
	                
	            }  
	            
	            boolean exceptionFlag = false;
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(null!=fieldValue
	                		&& !"updateTime".equals(fields[i].getName())
	                		&& !"createTime".equals(fields[i].getName())){
		        		Object[] objs = getDBMapping(fields[i].getName());
		                if (objs!=null && Boolean.valueOf(objs[2].toString())) {
		                	 argsList.add(fieldValue);
		                	 exceptionFlag = true;
		                }
	                }
	            }
	            if(!exceptionFlag){
	            	throw new BaseException("修改调用此方法必须有主键");
	            }
	            
	            return argsList.toArray();
	        } else if (sqlFlag.equals(SQL_DELETE)) {  
	        	List<Object> argsList = new ArrayList<Object>();
	        	fields[0].setAccessible(true); // 暴力反射  
	            boolean exceptionFlag = false;
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(!StringUtils.isEmpty(fieldValue)){
		            	Object[] objs = getDBMapping(fields[i].getName());
//		                if (objs!=null && Boolean.valueOf(objs[2].toString())) {
		            	if (objs!=null) {
		                	 argsList.add(fieldValue); 
		                	 exceptionFlag = true;
		                }
	                }
	            }
	            if(!exceptionFlag){
	            	throw new BaseException("修改调用此方法有条件");
	            }
	            
	            return argsList.toArray();
	        }
    	}catch(IllegalArgumentException | IllegalAccessException e){
    		e.printStackTrace();
			ExceptionEnum ee = ExceptionEnum.COMMON_DATEBASE_REFLEX_ERROE;
			ee.setLogString(e.getMessage());
			throw new BaseException(ee);
    	}
        return null;  
  
    }
  
    // 设置参数类型（写的不全，只是一些常用的）  
    private int[] setArgTypes(T entity, String sqlFlag) throws BaseException {  
        Field[] fields = (entityClass).getDeclaredFields(); 
        List<Integer> argTypeList = new ArrayList<Integer>();
        
        try{
	        if (sqlFlag.equals(SQL_INSERT)) {  
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                Object[] objs = getDBMapping(fields[i].getName());
	                if(!StringUtils.isEmpty(fieldValue)){
	                	
	                	if(objs!=null && !(boolean)objs[3]){
		            		argTypeList.add(Integer.valueOf(objs[1].toString()));
		            	}
	                }else{
	                	
	                	if(objs!=null && !(boolean)objs[2] && !(boolean)objs[3] && !(boolean)objs[4]){
		            		throw new BaseException(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,objs[0].toString());
		            	}
	                }
	            }
	            return ArrayUtils.toPrimitive(argTypeList.toArray(new Integer[argTypeList.size()]));  
	        } else if (sqlFlag.equals(SQL_UPDATE)) {
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                Object[] objs = getDBMapping(fields[i].getName());
	                if(null!=fieldValue
	                		&& !"updateTime".equals(fields[i].getName())
	                		&& !"createTime".equals(fields[i].getName())){
		            	if (objs==null || Boolean.valueOf(objs[2].toString())) { //  
		                    continue; 
		                }
		                argTypeList.add(Integer.valueOf(objs[1].toString()));
	                }else{
	                	if(objs!=null && (boolean)objs[2]){
		            		throw new BaseException(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,objs[0].toString());
		            	}
	                }
	            }  
	            boolean exceptionFlag = false;
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(null!=fieldValue
	                		&& !"updateTime".equals(fields[i].getName())
	                		&& !"createTime".equals(fields[i].getName())){
		        		Object[] objs = getDBMapping(fields[i].getName());
		                if (objs!=null && Boolean.valueOf(objs[2].toString())) {
		                	 argTypeList.add(Integer.valueOf(objs[1].toString()));
		                	 exceptionFlag = true;
		                }
	                }
	            }
	            if(!exceptionFlag){
	            	throw new BaseException(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"");
	            }
	            return ArrayUtils.toPrimitive(argTypeList.toArray(new Integer[argTypeList.size()])); 
	        } else if (sqlFlag.equals(SQL_DELETE)) {  
	        	fields[0].setAccessible(true); // 暴力反射  
	            boolean exceptionFlag = false;
	            for (int i = 0; fields != null && i < fields.length; i++) {
	            	fields[i].setAccessible(true); // 暴力反射 
	                Object fieldValue =fields[i].get(entity);
	                if(!StringUtils.isEmpty(fieldValue)){
		            	Object[] objs = getDBMapping(fields[i].getName());
//		                if (objs!=null && Boolean.valueOf(objs[2].toString())) {
		            	if (objs!=null) {
		                	argTypeList.add(Integer.valueOf(objs[1].toString())); 
		                	exceptionFlag = true;
		                }
	                }
	            }
	            if(!exceptionFlag){
	            	throw new BaseException(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"");
	            }
	        }
        }catch (IllegalArgumentException | IllegalAccessException e) {
        	e.printStackTrace();
			ExceptionEnum ee = ExceptionEnum.COMMON_DATEBASE_REFLEX_ERROE;
			ee.setLogString(e.getMessage());
			throw new BaseException(ee);
		}
        return ArrayUtils.toPrimitive(argTypeList.toArray(new Integer[argTypeList.size()])); 
    }  
  
    /**
     * 查询总数
     * @param where
     * @return
     */
    public int findCount(Map<String, String[]> where) {  
        StringBuffer sql = new StringBuffer(" SELECT COUNT(1) FROM " + getDBMapping(TABLENAME)[0]);  
        if (where != null && where.size() > 0) {  
        	sql.append(makeWhereByMapArr(where));
        }  
        logger.info("[sql]->"+sql);
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }
    /**
     * 查询总数
     * @param where
     * @return
     */
    public int findCount(String sql) {  
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }
    /**
     * 查询总数
     * @param where 1=1
     * @return
     */
    public int findCountWhere(String where) {  
        StringBuffer sql = new StringBuffer(" SELECT COUNT(1) FROM " + getDBMapping(TABLENAME)[0]);  
        if (!StringUtils.isEmpty(where)) {  
        	sql.append(" "+where);
        }  
        logger.info("[sql]->"+sql);
        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }
    /**
     * 查询总数
     * @param where
     * @return
     */
    public List<T> findByWhere(String where) {  
        StringBuffer sql = new StringBuffer(" SELECT * FROM " + getDBMapping(TABLENAME)[0]);  
        if (!StringUtils.isEmpty(where)) {  
        	sql.append(" "+where);
        } 
        logger.info("[sql]->"+sql);
        System.out.println("[findByWhere.sql]->"+sql);
        return jdbcTemplate.query(sql.toString(), getRowMapper());  
    }
    	
    /**
     * spring jdbc处理
     * @param jdbcTemplate
     */
    public abstract void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    /**
     * object[] 0,数据库名字，1数据库类型，2是否是主键，3是否自动增长，4是否允许为空
     * @param name实体类的名字
     * @return
     */
    protected abstract Object[] getDBMapping(String name);
    
    /**
     * spring查询用的
     * @return
     */
    protected abstract RowMapper<T> getRowMapper();
  
}  