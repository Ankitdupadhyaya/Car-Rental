package com.company.application.carrental.client.model.vo;

import com.extjs.gxt.ui.client.data.BaseModelData;

/**
 * March 2011
 * 
 * @author G_Lect
 */
public class GenericResultModelDto extends BaseModelData implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// private static String ID = "id";
	// private static String SHORTNAME = "shortName";
	// private static String NAME = "name";
	//
	// private static String TABLENAME = "tableName";
	// private static String DATABASENAME = "databaseName";

	public GenericResultModelDto() {

	}

	/**
	 * Constructor
	 */
	public GenericResultModelDto(String tableName) {
		setTableName(tableName);
	}

	/**
	 * @return Id
	 */
	public Integer getId() {
		return (Integer) get("id");
	}

	/**
	 * setId
	 * 
	 * @param Id
	 */
	public void setId(Integer id) {
		set("id", id);
	}

	/**
	 * @return SHORTNAME
	 */
	public String getShortName() {
		return (String) get("shortName");
	}

	/**
	 * setShortName
	 * 
	 * @param shortName
	 */
	public void setShortName(String shortName) {
		set("shortName", shortName);
	}

	/**
	 * @return NAME
	 */
	public String getName() {
		return (String) get("name");
	}

	/**
	 * setName
	 * 
	 * @param Name
	 */
	public void setName(String name) {
		set("name", name);
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return (String) get("tableName");
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		set("tableName", tableName);
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return (String) get("databaseName");
	}

	/**
	 * @param databaseName the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		set("databaseName", databaseName);
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return (String) get("columnName");
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		set("columnName", columnName);
	}
	
	/**
	 * @return the prefixColumnName
	 */
	public String getPrefixColumnName() {
		return (String) get("prefixColumnName");
	}

	/**
	 * @param columnName the prefixColumnName to set
	 */
	public void setPrefixColumnName(String prefixColumnName) {
		set("prefixColumnName", prefixColumnName);
	}
}