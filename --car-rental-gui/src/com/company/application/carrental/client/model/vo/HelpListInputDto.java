package com.company.application.carrental.client.model.vo;

import java.util.List;

/**
 * April 2009
 * 
 * @author G_Lect
 */
public class HelpListInputDto implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String value;
	private int maxResult;
	private String database;
	private String tableName;
	private String inputColumn;
	private List<String> outputColumns;

	/**
	 * Constructor
	 */
	public HelpListInputDto() {

	}

	public String getValue() {
		return value;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public String getDatabase() {
		return database;
	}

	public String getTableName() {
		return tableName;
	}

	public String getInputColumn() {
		return inputColumn;
	}

	public List<String> getOutputColumns() {
		return outputColumns;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setInputColumn(String inputColumn) {
		this.inputColumn = inputColumn;
	}

	public void setOutputColumns(List<String> outputColumns) {
		this.outputColumns = outputColumns;
	}

}
