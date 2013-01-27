package com.company.application.carrental.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.GenericResultModelDto;
import com.company.application.carrental.client.model.vo.HelpListOutputModelDto;
import com.company.application.carrental.client.view.mediators.CustomHelpListMediator;
import com.company.gui.adkwidgets.client.ui.ADKWidget;
import com.company.gui.adkwidgets.client.ui.choice.ADKHelpList;
import com.company.gui.adkwidgets.client.ui.grid.ADKColumnList;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.google.gwt.core.client.GWT;

/**
 * April 2009
 * 
 * @author G_Lect ADKCustomHelpList Object
 */
public class ADKCustomHelpList extends ADKHelpList implements ADKWidget {

	public static String ID = "id";
	public static String SHORTNAME = "shortName";
	public static String NAME = "name";

	private static String searchField = SHORTNAME;
	private static String displayField = SHORTNAME;

	private EventType event = new EventType();
	private int maxResult;
	private int minCharForSearch;
	private CustomHelpListMediator mediator;

	private static final String DEFAULT_REG_EX = "^[a-zA-Z0-9\\s_%-/]*$";
	private static final String DEFAULT_REG_EX_MSG = "Only alphanumerical characters are accepted.";

	private String tableName;
	private String prefixField;
	private String databaseName;

	public ADKCustomHelpList(String id, final String label, String databaseName, String tableName, String prefixField, boolean isMandatory,
			int labelWidth, int inputWidth) {
		this(id, label, databaseName, tableName, isMandatory, labelWidth, inputWidth);
		this.prefixField = prefixField;
	}

	public ADKCustomHelpList(String id, final String label, String databaseName, String tableName, boolean isMandatory, int labelWidth,
			int inputWidth) {
		super(id, label, new ArrayList<GenericResultModelDto>(), isMandatory, searchField, null, labelWidth, inputWidth, displayField);
		this.prefixField = null;
		this.tableName = tableName;
		this.databaseName = databaseName;
		addSearchField(ID);
		mediator = new CustomHelpListMediator();
		mediator.setViewComponent(this);
		ADKColumnList<ColumnConfig> columnsConfig = new ADKColumnList<ColumnConfig>();
		columnsConfig.add(new ColumnConfig("id", "Id", 60));
		columnsConfig.add(new ColumnConfig("shortName", "Short Name", 90));
		columnsConfig.add(new ColumnConfig("name", "Name", 160));
		setColumnsConfigList(columnsConfig);
		setPopUpWidth(370);
		maxResult = 250;
		minCharForSearch = 1;
		Listener<BaseEvent> dynamicListlistener = new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				getHelpList().setToolTip("At least " + minCharForSearch + " characters are required to launch the search.");
				String currentValue = (String) getHelpList().getValue();
				if (ADKCustomHelpList.this.getHelpList().isValid() && currentValue != null && !"".equals(currentValue)) {
					if (currentValue.trim().length() >= minCharForSearch) {
						String val = currentValue;
						ADKCustomHelpList.this.getHelpList().disableEvents(true);
						ADKCustomHelpList.this.setValue(val.replace("%", ""));
						ADKCustomHelpList.this.getHelpList().disableEvents(false);

						mediator.getGenericResult(currentValue.toUpperCase(), maxResult);
					} else {
						Info.display(label, "At least " + minCharForSearch + " characters are required to launch the search.");
					}
				} else {
					if (currentValue == null || "".equals(currentValue)) {
						ADKCustomHelpList.this.setValue(null);
					}
				}
			}
		};
		this.getHelpList().setToolTip("At least " + minCharForSearch + " characters are required to launch the search.");
		setSpecialEventWhenSetValue(true, event);
		setDynamicListlistener(dynamicListlistener, event);

		// Auto validation when losing focus
		this.getHelpList().addListener(Events.Blur, dynamicListlistener);

		setRegex(DEFAULT_REG_EX, DEFAULT_REG_EX_MSG);

	}

	/**
	 * 
	 * @param id
	 * @param label
	 * @param databaseName
	 * @param tableName
	 * @param inputColumn - The column to be searched upon ( WHERE inputColumn = "Value")
	 * @param displayColumn - The column to be displayed in the helplist
	 * @param outputColumns - The columns that needs to be displayed in the output grid ( SELECT )
	 * @param isMandatory
	 * @param labelWidth
	 * @param inputWidth
	 * 
	 *            Description - This custom help list can be used to create a helplist which can search in any table given the input column as the
	 *            search criteria and set of output columns to be displayed to the user, and finally the display column , which is displayed in the
	 *            helplist once the user select a particular row.
	 * 
	 */
	public ADKCustomHelpList(String id, final String label, String databaseName, String tableName, String inputColumn, String displayColumn,
			final List<String> outputColumns, boolean isMandatory, int labelWidth, int inputWidth) {
		super(id, label, new ArrayList<HelpListOutputModelDto>(), isMandatory, displayColumn, null, labelWidth, inputWidth, inputColumn);

		this.prefixField = null;
		this.tableName = tableName;
		this.databaseName = databaseName;
		mediator = new CustomHelpListMediator();
		mediator.setViewComponent(this);

		ADKColumnList<ColumnConfig> columnsConfig = new ADKColumnList<ColumnConfig>();
		for (String outputColumn : outputColumns) {
			columnsConfig.add(new ColumnConfig(outputColumn, outputColumn, 160));
		}
		setColumnsConfigList(columnsConfig);

		setPopUpWidth(370);
		maxResult = 250;
		minCharForSearch = 1;

		Listener<BaseEvent> dynamicListlistener = new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				getHelpList().setToolTip("At least " + minCharForSearch + " characters are required to launch the search.");
				String currentValue = (String) getHelpList().getValue();
				if (ADKCustomHelpList.this.getHelpList().isValid() && currentValue != null && !"".equals(currentValue)) {
					if (currentValue.trim().length() >= minCharForSearch /* && currentValue != "%" */) {
						String val = currentValue;
						ADKCustomHelpList.this.getHelpList().disableEvents(true);
						ADKCustomHelpList.this.setValue(val.replace("%", ""));
						ADKCustomHelpList.this.getHelpList().disableEvents(false);

						mediator.getCustomGenericResult(currentValue.toUpperCase(), outputColumns, maxResult);
					} else {
						Info.display(label, "At least " + minCharForSearch + " characters are required to launch the search.");
					}
				} else {
					if (currentValue == null || "".equals(currentValue)) {
						ADKCustomHelpList.this.setValue(null);
					}
				}
			}
		};
		this.getHelpList().setToolTip("At least " + minCharForSearch + " characters are required to launch the search.");
		setSpecialEventWhenSetValue(true, event);
		setDynamicListlistener(dynamicListlistener, event);

		// Auto validation when losing focus
		this.getHelpList().addListener(Events.Blur, dynamicListlistener);

		setRegex(DEFAULT_REG_EX, DEFAULT_REG_EX_MSG);
	}

	public void setRegex(String regEx, String msg) {
		this.getHelpList().setRegex(regEx);
		this.getHelpList().getMessages().setRegexText(msg);
	}

	/**
	 * @return the maxResult
	 */
	public int getMaxResult() {
		return maxResult;
	}

	/**
	 * @param maxResult the maxResult to set
	 */
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	/**
	 * @return the minCharForSearch
	 */
	public int getMinCharForSearch() {
		return minCharForSearch;
	}

	/**
	 * @param minCharForSearch the minCharForSearch to set
	 */
	public void setMinCharForSearch(int minCharForSearch) {
		this.minCharForSearch = minCharForSearch;
	}

	public void getGenericResultSuccessAction(List<GenericResultModelDto> result) {
		this.setList1Store(result);
		try {
			this.search(1, false, true, true);
		} catch (RuntimeException re) {
			GWT.log(re.getMessage());
		}
	}

	public void getCustomGenericResultSuccessAction(List<HelpListOutputModelDto> result) {
		this.setList1Store(result);
		try {
			this.search(1, false, true, true);
		} catch (RuntimeException re) {
			GWT.log(re.getMessage());
		}
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @param databaseName the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	/**
	 * @return the prefixField
	 */
	public String getPrefixField() {
		return prefixField;
	}

	/**
	 * PrefixField is what is before _Id, _ShortName... for table's columns. In main case it's the table name, but if it is different you can
	 * specify here the prefix.
	 * 
	 * @param prefixField the prefixField to set
	 */
	public void setPrefixField(String prefixField) {
		this.prefixField = prefixField;
	}

	public void reset() {
		this.refresh();
	}

}