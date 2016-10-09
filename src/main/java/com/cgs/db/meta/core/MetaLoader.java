package com.cgs.db.meta.core;

import java.util.Map;
import java.util.Set;

import com.cgs.db.exception.DataAccessException;
import com.cgs.db.meta.schema.Database;
import com.cgs.db.meta.schema.Function;
import com.cgs.db.meta.schema.Procedure;
import com.cgs.db.meta.schema.Schema;
import com.cgs.db.meta.schema.SchemaInfo;
import com.cgs.db.meta.schema.Table;
import com.cgs.db.meta.schema.Trigger;

import javax.sql.DataSource;

public interface MetaLoader {

	public DataSource getDataSource();

	/**
	 * get current datasource own Schema's table names
	 * 
	 * @return Set<String>
	 */
	Set<String> getTableNames() throws DataAccessException;
	
	/**
	 * get current datasource own schema's table.Default Level Table contaion
	 *  columns、primaryKey、ForeignKey、index
	 *  
	 * 
	 * @param tableName
	 * @return Table
	 */
	Table getTable(String tableName) throws DataAccessException;
	
	
	/**
	 * get current datasource own schema's table. 
	 * 
	 * @param tableName
	 * @param schemaLevel 
	 * @return
	 */
	Table getTable(String tableName, SchemaInfoLevel schemaLevel) throws DataAccessException;
	
	
	Table getTable(String tableName, SchemaInfo schemaInfo) throws DataAccessException;
		
	/**
	 * Gets the database's schema information
	 * 
	 * @return SchemaInfo
	 */
	Set<SchemaInfo> getSchemaInfos() throws DataAccessException;
	
	/**
	 * get current datasource own Schema
	 * 
	 * @return Schema
	 */
	Schema getSchema() throws DataAccessException;
	
	Schema getSchema(SchemaInfo schemaInfo) throws DataAccessException;
	
	/**
	 *  get current datasource own Schema
	 * 
	 * @param level
	 * @return Schema
	 */
	Schema getSchema(SchemaInfoLevel level) throws DataAccessException;
	
	Schema getSchema(SchemaInfo schemaInfo, SchemaInfoLevel level) throws DataAccessException;
	
	
	/**
	 * get currrent schema's procedure names.
	 * 
	 * @return Set<String>
	 */
	Set<String> getProcedureNames() throws DataAccessException;
	
	/**
	 * get procedure (current user can access)
	 * 
	 * @param procedureName the procedure's name(not be null)
	 * @return 
	 */	
	Procedure getProcedure(String procedureName) throws DataAccessException;
		
	/**
	 * get procedures (current user can access)
	 * 
	 * @return Map<String,Procedure>
	 */
	Map<String,Procedure> getProcedures() throws DataAccessException;
	
	/**
	 * get currrent schema's access trigger names.
	 * 
	 * @return Set<String>
	 */
	Set<String> getTriggerNames() throws DataAccessException;
	
	/**
	 * get trigger (current user can access)
	 * 
	 * @param triggerName the trigger's name(not be null)
	 * @return 
	 */	
	Trigger getTrigger(String triggerName) throws DataAccessException;
	
	/**
	 * get trigger (current user can access)
	 * 
	 * @return Map<String,Trigger>
	 */
	Map<String, Trigger> getTriggers() throws DataAccessException;
	
	/**
	 * get currrent schema's access function names.
	 * 
	 * @return Set<String>
	 */
	Set<String> getFunctionNames() throws DataAccessException;
	
	/**
	 * get function (current user can access)
	 * 
	 * @param functionName the trigger's name(not be null)
	 * @return 
	 */	
	Function getFunction(String name) throws DataAccessException;
	
	
	/**
	 * get Functions (current user can access)
	 * 
	 * @return Map<String,Function>
	 */
	Map<String, Function> getFunctions() throws DataAccessException;
	
	
	/**
	 * get this database's all the Schema.
	 * 
	 * <p><b>In oracle it is a dangerous function.There are too many system tables</b></p>
	 * 
	 * @return Database
	 */
	@Deprecated
	Database getDatabase() throws DataAccessException;
	
	/**
	 * get this database's all the Schema
	 * 
	 * <b>In oracle it is a dangerous function.There are too many system tables</b>
	 * 
	 * @param level
	 * @return Database
	 */
	@Deprecated
	Database getDatabase(SchemaInfoLevel level) throws DataAccessException;
}
