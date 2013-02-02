package com.company.application.carrental.client.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.IconButton;
import com.sencha.gxt.widget.core.client.event.CellClickEvent;
import com.sencha.gxt.widget.core.client.event.CellClickEvent.CellClickHandler;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

/**
 * June 2009
 * 
 * @author G_Lect
 * @param <M> FormBinding Object
 */
public class ADKFormBinding1<M extends Serializable> extends ContentPanel {

	private static final String ID_COLUMN_REMOVE = "remove";
	private final FormPanel formPanel;
	private boolean formPanelPermanentlyDisable;
	private ToolBar topToolBar;

	private M currentM;
	private List<String> dtoFieldsToFeed;
	private IconButton buttonAdd;
	private IconButton buttonUpdate;
	private IconButton buttonClear;
	private IconButton buttonDelete;

	private Grid<M> grid;
	private List<ColumnConfig> columns;
	private ToolBar featuresToolBar;
	private List<M> data;
	private List<M> dataProtected;
	private List<M> dataRemoved;
	private List<M> dataUpdated;
	private List<M> dataUpdatedOld;
	private List<M> dataAdded;

	private String protectedField;
	private List<String> protectedValues;
	public boolean updateButtonRequired = true;
	private boolean confirmDeleteRequired;

	/**
	 * Form with fields linked to a grid
	 * 
	 * @param id : id of the grid
	 * @param title : title of the grid
	 * @param width : size
	 * @param height : size
	 * @param gridHeight : height of the grid
	 * @param datas : data to load into the grid
	 * @param columns : columns definition
	 * @param formPanel : the form Panel, allow TextField, DateField, SimpleComboBox, CheckBox.
	 * @param multiSelection : multiselection
	 * @param dtoFields : the list of the dto's fields which are linked by the name to the formulary fields
	 */
	public ADKFormBinding1(String id, String title, int width, int height, int gridHeight, final List<M> datas, List<ColumnConfig> columns,
			FormPanel formPanel, boolean multiSelection, List<String> dtoFields, ModelKeyProvider keyProvider) {
		// super(id);
		if (title != null && title.length() > 0) {
			setHeadingText(title);
			setHeaderVisible(true);
		}
		// setFrame(true);
		// setSize(width, height);
		// setLayout(new RowLayout(Orientation.VERTICAL));
		// gridCellRenderer = new ADKGridCellRenderer<M>();
		dtoFieldsToFeed = dtoFields;

		buttonAdd = new IconButton("icon-add");
		buttonAdd.setToolTip("Add the formulary's item to the grid");

		buttonUpdate = new IconButton("icon-table-edit");
		buttonUpdate.setToolTip("Update the current item selected");
		buttonUpdate.hide();

		dataRemoved = new ArrayList<M>();
		dataProtected = new ArrayList<M>();

		dataUpdated = new ArrayList<M>();
		dataAdded = new ArrayList<M>();

		dataUpdatedOld = new ArrayList<M>();

		data = new ArrayList<M>();
		if (datas != null) {
			for (M m : datas) {
				// gridCellRenderer.addNewElement(m);
				data.add(m);
			}
		}

		this.formPanel = formPanel;
		formPanelPermanentlyDisable = false;

		/* **** creation of the grid ***** */
		this.columns = columns;

		IdentityValueProvider<M> identity = new IdentityValueProvider<M>();
		final CheckBoxSelectionModel<M> sm = new CheckBoxSelectionModel<M>(identity);
		if (multiSelection) {
			columns.add(0, sm.getColumn());
		}

		grid = new Grid<M>(new ListStore<M>(keyProvider), new ColumnModel(columns));

		// grid.setAutoWidth(true);
		grid.setView(new GridView());
		if (multiSelection) {
			grid.setSelectionModel(sm);
			// grid.addPlugin(sm);
		}

		grid.addCellClickHandler(new CellClickHandler() {

			public void onCellClick(CellClickEvent event) {

			}
		});

		// grid.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent>() {
		//
		// public void handleEvent(SelectionChangedEvent be) {
		// if (be.getSelection().size() > 0) {
		// currentM = (M) be.getSelection().get(0);
		// fillEmptyCombos();
		// clearFormData();
		// fillFormWithData(currentM);
		// if (updateButtonRequired) {
		// buttonUpdate.show();
		// buttonAdd.hide();
		// } else {
		// buttonUpdate.hide();
		// buttonAdd.show();
		// }
		//
		// protectedData();
		// } else {
		// clearFormData();
		// buttonAdd.show();
		// buttonUpdate.hide();
		// enableForm();
		// }
		// }
		// });
		add(this.formPanel);
		buttonsCreations();
		featuresToolBar = new ToolBar();
		add(topToolBar);
		add(grid);
	}

	public void isUpdateButtonRequired(boolean isRequired) {
		updateButtonRequired = isRequired;
	}

	/**
	 * Form with fields linked to a grid, all fields in the formulary are binded to a dto fields. If you want to just link some fields, use the
	 * other constructor
	 * 
	 * @param id : id of the grid
	 * @param title : title of the grid
	 * @param width : size
	 * @param height : size
	 * @param gridHeight : height of the grid
	 * @param datas : data to load into the grid
	 * @param columns : columns definition
	 * @param formPanel : the form Panel, allow TextField, DateField, SimpleComboBox, CheckBox.
	 * @param multiSelection : multiselection
	 */
	// public ADKFormBinding(String id, String title, int width, int height, int gridHeight, final List<M> datas, List<ColumnConfig> columns,
	// FormPanel formPanel, boolean multiSelection) {
	// this(id, title, width, height, gridHeight, datas, columns, formPanel, multiSelection, new ArrayList<String>());
	// }

	/**
	 * Add a ADKGridStyleConfig to the Form
	 * 
	 * @param conditionsAndStyles : the HashMap with the values tested, and the css style associated
	 * @param conditionField : the attribute of the object where the value is tested.
	 */
	public void addConditionStyles(HashMap<Object, String> conditionsAndStyles, String conditionField) {
		// ADKGridStyleConfig<M> gvc = new ADKGridStyleConfig<M>(grid.getGrid(), conditionsAndStyles, conditionField);
		// grid.getView().setViewConfig(gvc);
	}

	/**
	 * Set grid height
	 * 
	 * @param gridHeight
	 */
	public void setGridHeight(int gridHeight) {
		if (gridHeight > 0) {
			grid.setHeight(gridHeight);
		} else {
			// grid.setAutoHeight(true);
		}
	}

	/**
	 * create form buttons
	 */
	private void buttonsCreations() {
		topToolBar = new ToolBar();
		buttonUpdate.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				updateM();

			}
		});

		buttonClear = new IconButton("icon-switch");
		buttonClear.setToolTip("Clear the formulary");
		buttonClear.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				grid.getSelectionModel().deselectAll();
				clearFormData();
				buttonAdd.show();
				buttonUpdate.hide();
				grid.getView().refresh(false);
			}
		});
		buttonDelete = new IconButton("icon-delete");
		buttonDelete.setToolTip("Revome the selection");
		buttonDelete.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				List<M> selectedItems = grid.getSelectionModel().getSelectedItems();
				for (M m : selectedItems) {
					removeM(m);
				}
				grid.getView().refresh(false);
			}
		});

		topToolBar.add(buttonUpdate);
		topToolBar.add(new SeparatorToolItem());
		topToolBar.add(buttonClear);
		topToolBar.add(new SeparatorToolItem());
		buttonAdd.setVisible(false);
		topToolBar.add(buttonAdd);
		topToolBar.add(new SeparatorToolItem());
		topToolBar.add(buttonDelete);

		// grid.setTopComponent(topToolBar);
	}

	public M getCurrentM() {
		return currentM;

	}

	/**
	 * Test if the current selection could be Modified.
	 */
	private void protectedData() {
		// boolean isProtected = false;
		// if (dataProtected.contains(currentM)) {
		// isProtected = true;
		// }
		// if (protectedField != null && protectedValues != null) {
		// for (String value : protectedValues) {
		// Object currentObj = currentM.get(protectedField);
		// String currentValue = currentObj.toString();
		// if (value.equals(currentValue)) {
		// isProtected = true;
		// }
		// }
		// }
		// if (isProtected) {
		// disableForm();
		// } else {
		// enableForm();
		// }
	}

	/**
	 * Disable form and buttons
	 */
	public void disableForm() {
		buttonAdd.hide();
		buttonUpdate.hide();
		buttonClear.hide();
		// for (Field f : formPanel.getFields()) {
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKPanel) {
		// ADKPanel panelField = (ADKPanel) formPanel.getWidgetById(f.getId());
		// panelField.disable();
		// }
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKLabel) {
		// ADKLabel labelField = (ADKLabel) formPanel.getWidgetById(f.getId());
		// labelField.disable();
		// }
		// }
	}

	/**
	 * Enable form and buttons
	 */
	public void enableForm() {
		// if (!formPanelPermanentlyDisable) {
		// buttonClear.show();
		// for (Field f : formPanel.getFields()) {
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKPanel) {
		// ADKPanel panelField = (ADKPanel) formPanel.getWidgetById(f.getId());
		// panelField.enable();
		// }
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKLabel) {
		// ADKLabel labelField = (ADKLabel) formPanel.getWidgetById(f.getId());
		// labelField.enable();
		// }
		// }
		// }
	}

	/**
	 * Add the disable feature concerning object which have these values for a specific field
	 * 
	 * @param field : the field tested
	 * @param values : values which disable the form
	 */
	public void addProtectedDatas(String field, List<String> values) {
		this.protectedField = field;
		this.protectedValues = values;
	}

	/**
	 * @return formPanel : ADKFormPanel of the FormBinding
	 */
	public FormPanel getFormPanel() {
		return formPanel;
	}

	/**
	 * Add an item to the grid (and to the dataAdded list). Use it in your "setAddListener()" method. Notice that item added through this method,
	 * then deleted (through the icon button), won't be stored in the dataRemoved list.
	 * 
	 * @param item
	 * @param deletable : true if the item is deletable through the icon button
	 */
	public void addGridItem(M item, boolean deletable) {
		if (deletable) {
			// gridCellRenderer.addNewElement(item);
		}
		data.add(item);
		dataAdded.add(item);
		grid.getStore().add(0, item);
	}

	/**
	 * Add an existing(not new) item to the grid.
	 * 
	 * @param item
	 * @param deletable : true if the item is deletable through the icon button
	 */
	public void addGridExistingItem(M item, boolean deletable) {
		if (deletable) {
			// gridCellRenderer.addNewElement(item);
		}
		data.add(item);
		grid.getStore().add(0, item);
	}

	/**
	 * Add a protected item (no editable) to the grid (and to the dataAdded list) Notice that item added through this method, then deleted (through
	 * the icon button), won't be stored in the dataRemoved list.
	 * 
	 * @param item
	 * @param deletable : true if the item is deletable through the icon button
	 */
	public void addGridItemProtected(M item, boolean deletable) {
		if (deletable) {
			// gridCellRenderer.addNewElement(item);
		}
		dataProtected.add(item);
		data.add(item);
		dataAdded.add(item);
		grid.getStore().add(0, item);
	}

	/**
	 * Add a listener to the store of the grid
	 * 
	 * @param listener
	 */
	// public void addStoreListener(StoreListener<M> listener) {
	// grid.getStore().addStoreListener(listener);
	// }

	/**
	 * Return the list of models stored in the grid store
	 * 
	 * @return list<M>
	 */
	public List<M> getGridDatas() {
		return data;
	}

	/**
	 * Set the Add feature, with the listener sent. You should use the "getCurrentFormModelData()" to recover informations form fields
	 * 
	 * @param listener
	 */
	public void setAddListener(SelectHandler handler) {
		buttonAdd.setVisible(true);
		buttonAdd.addSelectHandler(handler);
	}

	/**
	 * Get the data of the form in a BaseModelData object
	 * 
	 * @return newM the BaseModelData created with the form's fields.
	 */
	// public BaseModelData getCurrentFormModelData() {
	// BaseModelData newM = new BaseModelData();
	// for (Field f : formPanel.getFields()) {
	// if (dtoFieldsToFeed.size() == 0 || dtoFieldsToFeed.contains(f.getName())) {
	// boolean specialField = false;
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKCombo) {
	// ADKCombo comboField = (ADKCombo) formPanel.getWidgetById(f.getId());
	// specialField = true;
	// if (comboField.getModelValue() != null && comboField.isAutomaticGetValueAsModel()) {
	// newM.set(f.getName(), comboField.getModelValue());
	// } else {
	// newM.set(f.getName(), comboField.getValue());
	// }
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKHelpList) {
	// ADKHelpList helpListField = (ADKHelpList) formPanel.getWidgetById(f.getId());
	// specialField = true;
	// if (helpListField.getModelValue() != null && helpListField.isAutomaticGetValueAsModel()) {
	// newM.set(f.getName(), helpListField.getModelValue());
	// } else {
	// newM.set(f.getName(), helpListField.getValue());
	// }
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKSimpleComboField) {
	// ADKSimpleComboField comboField = (ADKSimpleComboField) formPanel.getWidgetById(f.getId());
	// if (comboField.getValue() != null) {
	// newM.set(f.getName(), comboField.getModelValue());
	// }
	// specialField = true;
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKAmountField) {
	// ADKAmountField amountField = (ADKAmountField) formPanel.getWidgetById(f.getId());
	// specialField = true;
	// if (amountField.getValue() != null && amountField.getName() != null) {
	// newM.set(amountField.getName(), amountField.getValueAsDouble());
	// }
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKIntegerAmountField) {
	// ADKIntegerAmountField integerField = (ADKIntegerAmountField) formPanel.getWidgetById(f.getId());
	// specialField = true;
	// if (integerField.getValue() != null && integerField.getName() != null) {
	// newM.set(integerField.getName(), integerField.getValueAsInteger());
	// }
	// }
	// if (!specialField && f.getValue() != null && f.getName() != null) {
	// newM.set(f.getName(), f.getValue());
	// }
	// }
	// }
	// return newM;
	// }

	/**
	 * Method to add the values of the currentM's to the combo if its necessary
	 */
	private void fillEmptyCombos() {
		// for (Field f : formPanel.getFields()) {
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKCombo) {
		// ADKCombo comboField = (ADKCombo) formPanel.getWidgetById(f.getId());
		// Object comboObject = currentM.get(comboField.getName());
		// // if (comboObject != null && comboObject instanceof ModelData) {
		// if (comboObject instanceof ModelData) {
		// if (!comboField.getStore().getModels().contains(currentM.get(comboField.getName()))) {
		// comboField.getStore().add((ModelData) currentM.get(comboField.getName()));
		// }
		// }
		// }
		// }
	}

	/**
	 * Return the grid
	 * 
	 * @return grid
	 */
	public Grid<M> getGrid() {
		return grid;
	}

	/**
	 * Remove all Elements in the grid store
	 */
	public void cleanGridStore() {
		grid.getStore().clear();
		// gridCellRenderer.removeAllElements();
		data.clear();
		dataProtected.clear();
	}

	/**
	 * @param hide
	 */
	public void hideUpdateButton(boolean hide) {
		buttonUpdate.setVisible(!hide);
	}

	/**
	 * @param hide
	 */
	public void hideClearButton(boolean hide) {
		buttonClear.setVisible(!hide);
	}

	/**
	 * @param hide
	 */
	public void hideAddButton(boolean hide) {
		buttonAdd.setVisible(!hide);
	}

	/**
	 * @param hide
	 */
	public void hideDeleteButton(boolean hide) {
		buttonDelete.setVisible(!hide);
	}

	/**
	 * Return the list of the elements deleted in the grid
	 * 
	 * @return dataRemoved
	 */
	public List<M> getDataRemoved() {
		return dataRemoved;
	}

	/**
	 * Remove all elements in the DataRemoved list
	 */
	public void cleanDataRemoved() {
		dataRemoved.clear();
	}

	/**
	 * Remove in store, data, dataProtected, dataAdded, dataUpdated, dataUpdatedOld, and gridCellRenderer list. Add the item to the dataRemoved
	 * list if dataAdded list does not contains this object. CAREFUL : If the item is an updated one, we put the old values of this object
	 * 
	 * @param m
	 */
	private void removeM(M m) {
		int indexInUpdatedLists = getObjectIndex(dataUpdated, m);
		grid.getStore().remove(m);
		// gridCellRenderer.removeElement(m);
		data.remove(m);
		dataProtected.remove(m);
		dataUpdated.remove(m);
		// If it's present in dataAdded list, we consider that the object is not persistent.
		if (!dataAdded.contains(m)) {
			// We check if data has been modified, to recover the references values in the dataUpdatedOld list.
			if (indexInUpdatedLists > -1) {
				// Map<String, Object> map = dataUpdatedOld.get(indexInUpdatedLists).getProperties();
				// for (String fieldName : map.keySet()) {
				// m.set(fieldName, map.get(fieldName));
				// }
				// Now we can remove it to the updateOld list.
				dataUpdatedOld.remove(indexInUpdatedLists);
			}
			dataRemoved.add(m);
		}
		dataAdded.remove(m);
	}

	public int getObjectIndex(List<M> list, M object) {
		if (list != null && object != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(object)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * return protected Data in the grid
	 * 
	 * @return dataProtected
	 */
	public List<M> getDataProtected() {
		return dataProtected;
	}

	/**
	 * Fill the form with the Model selected
	 * 
	 * @param m
	 */
	private void fillFormWithData(M m) {
		// for (Field f : formPanel.getFields()) {
		// if (f.getName() != null && m.get(f.getName()) != null) {
		// boolean specialField = false;
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKCombo) {
		// ADKCombo comboField = (ADKCombo) formPanel.getWidgetById(f.getId());
		// comboField.setValue(m.get(f.getName()));
		// specialField = true;
		// }
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKSimpleComboField) {
		// ADKSimpleComboField comboField = (ADKSimpleComboField) formPanel.getWidgetById(f.getId());
		// comboField.setValue(m.get(f.getName()));
		// specialField = true;
		// }
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKAmountField) {
		// ADKAmountField amountField = (ADKAmountField) formPanel.getWidgetById(f.getId());
		// amountField.setValue(m.get(f.getName()));
		// specialField = true;
		// }
		// /* This call is mandatory to go in the right setValue() of the ADKHelpList object, and not in the Field object */
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKHelpList) {
		// ADKHelpList helpList = (ADKHelpList) formPanel.getWidgetById(f.getId());
		// helpList.setValue(m.get(f.getName()));
		// specialField = true;
		// }
		//
		// if (!specialField) {
		// try {
		// f.setValue(m.get(f.getName()));
		// } catch (ClassCastException e) {
		// f.setRawValue((String) m.get(f.getName()));
		// }
		// }
		// }
		// }
	}

	/**
	 * Clean the form
	 */
	public void clearFormData() {
		// for (Field f : formPanel.getFields()) {
		// if (!(f instanceof LabelField)) {
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKCombo) {
		// ADKCombo panelField = (ADKCombo) formPanel.getWidgetById(f.getId());
		// if (panelField.isRefreshAllowed()) {
		// f.reset();
		// }
		// } else if (formPanel.getWidgetById(f.getId()) instanceof ADKHelpList) {
		// ADKHelpList panelField = (ADKHelpList) formPanel.getWidgetById(f.getId());
		// if (panelField.isRefreshAllowed()) {
		// f.reset();
		// panelField.clearValue();
		// }
		// } else if (formPanel.getWidgetById(f.getId()) instanceof ADKTextField) {
		// ADKTextField panelField = (ADKTextField) formPanel.getWidgetById(f.getId());
		// if (panelField.isRefreshAllowed()) {
		// f.reset();
		// }
		// } else {
		// f.reset();
		// }
		// }
		// }
	}

	/**
	 * @return unprotectedData the list of element non protected in the grid
	 */
	public List<M> getUnprotectedData() {
		List<M> unprotectedData = new ArrayList<M>();
		for (M m : data) {
			if (!dataProtected.contains(m)) {
				unprotectedData.add(m);
			}
		}
		return unprotectedData;
	}

	/**
	 * @return buttonAdd
	 */
	public IconButton getButtonAdd() {
		return buttonAdd;
	}

	/**
	 * @return formPanelPermanentlyDisable
	 */
	public boolean isFormPanelPermanentlyDisable() {
		return formPanelPermanentlyDisable;
	}

	/**
	 * @param formPanelPermanentlyDisable
	 */
	public void setFormPanelPermanentlyDisable(boolean formPanelPermanentlyDisable) {
		this.formPanelPermanentlyDisable = formPanelPermanentlyDisable;
	}

	/**
	 * @return list of deletable items in the grid
	 */
	// public List<M> getDeletableData() {
	// return gridCellRenderer.getListElements();
	// }

	/**
	 * @param flag
	 */
	public void setGridHeaderVisible(boolean flag) {
		this.grid.setHideHeaders(!flag);
	}

	/**
	 * @param flag
	 */
	public void setGridBodyBorder(boolean flag) {
		this.grid.setBorders(flag);
	}

	/**
	 * @param flag
	 */
	public void setGridBorders(boolean flag) {
		this.grid.setBorders(flag);
	}

	/**
	 * Add the PDF export features
	 */
	public void addPdfExport() {
		// Button exportPDF = new Button();
		// exportPDF.setIconStyle(ADKResources.ICON_STYLES.EXPORT_PDF);
		// exportPDF.setToolTip("Export the report to PDF Format");
		// // final ReportExportServiceFmkCommand commandExport = new ReportExportServiceFmkCommand();
		//
		// final String myTitle = getHeading();
		//
		// exportPDF.addSelectionListener(new SelectionListener<ButtonEvent>() {
		//
		// @Override
		// public void componentSelected(ButtonEvent ce) {
		// int formWidth = formPanel.getWidth();
		// int formHeight = formPanel.getHeight();
		// Object args[] = new Object[7];
		// args[0] = (String) myTitle;
		// args[1] = Integer.valueOf(formHeight);
		// args[2] = Integer.valueOf(formWidth);
		// args[3] = data;
		// args[4] = transformToColumnModelDto();
		// args[5] = transformToColumnModelDto();
		// args[6] = transformFormularyToFieldsDto();
		// ApplicationFacade.getInst().sendNotification(ApplicationEvents.GRID_FORMULA_PDF_EXPORT, args, null);
		// // commandExport.exportFormularyAndGridPDF(myTitle, formHeight, formWidth, data, transformToColumnModelDto(),
		// // transformToColumnModelDto(), null,transformFormularyToFieldsDto());
		// }
		//
		// });
		// featuresToolBar.add(exportPDF);
		// setTopComponent(featuresToolBar);
	}

	/**
	 * transform the fields of the formulary to a List of FieldDto
	 * 
	 * @return
	 */
	// private List<FieldDto> transformFormularyToFieldsDto() {
	// List<FieldDto> fieldList = new ArrayList<FieldDto>();
	// FieldDto fieldDto;
	//
	// Point positionFormPanel = formPanel.getPosition(false);
	// int xFormPanel = positionFormPanel.x;
	// int yFormPanel = positionFormPanel.y;
	//
	// for (Field f : formPanel.getFields()) {
	// Point positionvalue = f.getPosition(false);
	// int xValue = positionvalue.x;
	// int yValue = positionvalue.y;
	// int xLabel = 0;
	// int yLabel = 0;
	//
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKFieldPanel) {
	// ADKFieldPanel field = (ADKFieldPanel) formPanel.getWidgetById(f.getId());
	// field.getContainer().getPosition(false);
	// Point positionLabel = field.getContainer().getPosition(false);
	// xLabel = positionLabel.x;
	// yLabel = positionLabel.y;
	// }
	//
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKCombo) {
	// ADKCombo comboField = (ADKCombo) formPanel.getWidgetById(f.getId());
	// fieldDto =
	// new FieldDto(comboField.getId(), comboField.getContainer().getHeight(), comboField.getLabel(), comboField.getLabelWidth(),
	// comboField.getValue(), comboField.getInputWidth());
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKSimpleComboField) {
	// ADKSimpleComboField comboField = (ADKSimpleComboField) formPanel.getWidgetById(f.getId());
	// fieldDto =
	// new FieldDto(comboField.getId(), comboField.getContainer().getHeight(), comboField.getLabel(), comboField.getLabelWidth(),
	// comboField.getValue(), comboField.getInputWidth());
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKTextField) {
	// ADKTextField textField = (ADKTextField) formPanel.getWidgetById(f.getId());
	// fieldDto =
	// new FieldDto(textField.getId(), textField.getContainer().getHeight(), textField.getLabel(), textField.getLabelWidth(),
	// textField.getValue(), textField.getInputWidth());
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKCheckBoxField) {
	// ADKCheckBoxField checkBoxField = (ADKCheckBoxField) formPanel.getWidgetById(f.getId());
	// String value = "";
	// if (checkBoxField.getValue()) {
	// value = "[X]";
	// } else {
	// value = "[  ]";
	// }
	//
	// fieldDto =
	// new FieldDto(checkBoxField.getId(), checkBoxField.getContainer().getHeight(), checkBoxField.getLabel(),
	// checkBoxField.getLabelWidth(), value, checkBoxField.getInputWidth());
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKCheckBox) {
	// ADKCheckBox checkBoxField = (ADKCheckBox) formPanel.getWidgetById(f.getId());
	// fieldDto =
	// new FieldDto(checkBoxField.getId(), checkBoxField.getContainer().getHeight(), checkBoxField.getLabel(),
	// checkBoxField.getLabelWidth(), null, 0);
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	//
	// for (CheckBox cb : checkBoxField.getCheckBoxs()) {
	// Point cbPositionvalue = cb.getPosition(false);
	// String value = "";
	// if (cb.getValue()) {
	// value = "[X] ";
	// } else {
	// value = "[  ] ";
	// }
	// value += cb.getValueAttribute();
	// xValue = cbPositionvalue.x;
	// yValue = cbPositionvalue.y;
	// fieldDto = new FieldDto(cb.getId(), cb.getHeight(), null, 0, value, cb.getWidth());
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	// }
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKHelpList) {
	// ADKHelpList helpListField = (ADKHelpList) formPanel.getWidgetById(f.getId());
	// fieldDto =
	// new FieldDto(helpListField.getId(), helpListField.getContainer().getHeight(), helpListField.getLabel(),
	// helpListField.getLabelWidth(), helpListField.getValue(), helpListField.getInputWidth());
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKDateField) {
	// ADKDateField dateField = (ADKDateField) formPanel.getWidgetById(f.getId());
	// fieldDto =
	// new FieldDto(dateField.getId(), dateField.getContainer().getHeight(), dateField.getLabel(), dateField.getLabelWidth(),
	// dateField.getStringValue(), dateField.getInputWidth());
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	// }
	// if (formPanel.getWidgetById(f.getId()) instanceof ADKRadio) {
	// ADKRadio radioField = (ADKRadio) formPanel.getWidgetById(f.getId());
	// fieldDto =
	// new FieldDto(radioField.getId(), radioField.getContainer().getHeight(), radioField.getLabel(), radioField.getLabelWidth(),
	// radioField.getValue(), radioField.getInputWidth());
	// setFieldDtoPosition(fieldDto, xLabel, yLabel, xValue, yValue, xFormPanel, yFormPanel);
	// fieldList.add(fieldDto);
	// }
	// }
	// return fieldList;
	// }

	/**
	 * Set the field position
	 * 
	 * @param fieldDto
	 * @param xLabel
	 * @param yLabel
	 * @param xValue
	 * @param yValue
	 * @param xFormPanel
	 * @param yFormPanel
	 */
	// private void setFieldDtoPosition(FieldDto fieldDto, int xLabel, int yLabel, int xValue, int yValue, int xFormPanel, int yFormPanel) {
	// fieldDto.setXLabel(xLabel - xFormPanel);
	// fieldDto.setYLabel(yLabel - yFormPanel);
	// fieldDto.setXValue(xValue - xFormPanel);
	// fieldDto.setYValue(yValue - yFormPanel);
	// }

	/**
	 * Transform the columnConfig to ColumnModelDto
	 * 
	 * @return List of ColumnModelDto
	 */
	// private List<ColumnModelDto> transformToColumnModelDto() {
	// final List<ColumnModelDto> columnsDto = new ArrayList<ColumnModelDto>();
	// for (ColumnConfig columnConfig : columns) {
	// ColumnModelDto c = new ColumnModelDto(columnConfig.getId(), columnConfig.getHeader(), columnConfig.getWidth());
	// if (columnConfig instanceof ADKCheckColumnConfig) {
	// c.setNumber(false);
	// c.setDate(false);
	// c.setFloat(false);
	// c.setDouble(false);
	// c.setBoolean(true);
	// } else {
	// ADKColumnType columnType = (ADKColumnType) columnConfig;
	// if (columnType.getType() == 'D') {
	// c.setDate(true);
	// c.setNumber(false);
	// c.setFloat(false);
	// c.setDouble(false);
	// } else if (columnType.getType() == 'N') {
	// c.setNumber(true);
	// c.setDate(false);
	// c.setFloat(false);
	// c.setDouble(false);
	// } else if (columnType.getType() == 'F') {
	// c.setFloat(true);
	// c.setNumber(false);
	// c.setDate(false);
	// c.setDouble(false);
	// } else if (columnType.getType() == 'O') {
	// c.setFloat(false);
	// c.setNumber(false);
	// c.setDate(false);
	// c.setDouble(true);
	// } else {
	// c.setNumber(false);
	// c.setDate(false);
	// c.setFloat(false);
	// c.setDouble(false);
	// }
	// }
	// if (c.getId().compareTo(ID_COLUMN_REMOVE) != 0) {
	// columnsDto.add(c);
	// }
	// }
	// return columnsDto;
	// }

	/**
	 * @return the buttonUpdate
	 */
	public IconButton getButtonUpdate() {
		return buttonUpdate;
	}

	/**
	 * @return the buttonClear
	 */
	public IconButton getButtonClear() {
		return buttonClear;
	}

	/**
	 * Set the list of the dto's fields which are linked by the name to the formulary fields
	 * 
	 * @param dtoFields
	 */
	public void setDtoFieldsToFeed(List<String> dtoFields) {
		dtoFieldsToFeed = dtoFields;
	}

	/**
	 * @return the dataUpdated
	 */
	public List<M> getDataUpdated() {
		return dataUpdated;
	}

	/**
	 * @return the dataUpdatedOld
	 */
	public List<M> getDataUpdatedOld() {
		return dataUpdatedOld;
	}

	/**
	 * @return the dataAdded
	 */
	public List<M> getDataAdded() {
		return dataAdded;
	}

	/**
	 * Remove all elements in the DataAdded list
	 */
	public void cleanDataAdded() {
		dataAdded.clear();
	}

	/**
	 * Remove all elements in the DataUpdated list
	 */
	public void cleanDataUpdated() {
		dataUpdated.clear();
	}

	/**
	 * Remove all data list : added, updated, removed, grid datas...
	 */
	public void cleanAllDatas() {
		data.clear();
		dataAdded.clear();
		dataProtected.clear();
		dataUpdated.clear();
		dataUpdatedOld.clear();
		dataRemoved.clear();
		grid.getStore().clear();
		// gridCellRenderer.removeAllElements();
	}

	// public void setResizable(final boolean autoResizeGrid) {
	// Resizable r = new Resizable(this);
	// r.setDynamic(true);
	// r.addResizeListener(new ResizeListener() {
	//
	// public void resizeEnd(ResizeEvent re) {
	// if (autoResizeGrid) {
	// grid.setWidth(ADKFormBinding.this.getWidth() - 10);
	// }
	// }
	// });
	// }

	public void updateM() {
		boolean allIsValid = true;

		// Saving old data
		// M oldM = (M) new BaseModelData(currentM.getProperties());
		// for (Field f : formPanel.getFields()) {
		// if (f.isValid()) {
		// if (dtoFieldsToFeed.size() == 0 || dtoFieldsToFeed.contains(f.getName())) {
		//
		// currentM.set(f.getName(), f.getValue());
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKCombo) {
		// ADKCombo comboField = (ADKCombo) formPanel.getWidgetById(f.getId());
		// if (comboField.getModelValue() != null && comboField.isAutomaticGetValueAsModel()) {
		// currentM.set(f.getName(), comboField.getModelValue());
		// } else {
		// currentM.set(f.getName(), comboField.getValue());
		// }
		// }
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKHelpList) {
		// ADKHelpList helpList = (ADKHelpList) formPanel.getWidgetById(f.getId());
		// if (helpList.getModelValue() != null && helpList.isAutomaticGetValueAsModel()) {
		// currentM.set(f.getName(), helpList.getModelValue());
		// } else {
		// currentM.set(f.getName(), helpList.getValue());
		// }
		// }
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKSimpleComboField) {
		// ADKSimpleComboField comboField = (ADKSimpleComboField) formPanel.getWidgetById(f.getId());
		// currentM.set(f.getName(), comboField.getModelValue());
		// }
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKAmountField) {
		// ADKAmountField amountField = (ADKAmountField) formPanel.getWidgetById(f.getId());
		// currentM.set(f.getName(), amountField.getValueAsDouble());
		// }
		// if (formPanel.getWidgetById(f.getId()) instanceof ADKIntegerAmountField) {
		// ADKIntegerAmountField integerField = (ADKIntegerAmountField) formPanel.getWidgetById(f.getId());
		// currentM.set(f.getName(), integerField.getValueAsInteger());
		// }
		// }
		// } else {
		// allIsValid = false;
		// }
		// }
		if (allIsValid) {
			grid.getStore().update(currentM); // For the display
			grid.getView().refresh(false);
			if (!dataUpdated.contains(currentM) && !dataAdded.contains(currentM)) {
				dataUpdated.add(currentM);
				// We set the first reference of the object
				// dataUpdatedOld.add(oldM);
			} else if (dataUpdated.contains(currentM)) {
				// It's a new update of an already updated object
				// for (int i = 0; i < dataUpdated.size(); i++) {
				// if (dataUpdated.get(i).equals(oldM)) {
				// dataUpdated.set(i, currentM);
				// }
				// }
			}
		}
	}

	/**
	 * @return the confirmDeleteRequired
	 */
	public boolean isConfirmDeleteRequired() {
		return confirmDeleteRequired;
	}

	/**
	 * @param confirmDeleteRequired the confirmDeleteRequired to set
	 */
	public void setConfirmDeleteRequired(boolean confirmDeleteRequired) {
		this.confirmDeleteRequired = confirmDeleteRequired;
	}

	private void remove() {
		removeM(currentM);
		grid.getView().refresh(false);
	}

	private void confirmDelete() {
		if (isConfirmDeleteRequired()) {
			final ConfirmMessageBox mb = new ConfirmMessageBox("Confirmation Required", "Are you ready?");
			mb.addHideHandler(new HideHandler() {

				public void onHide(HideEvent event) {
					if (mb.getHideButton() == mb.getButtonById(PredefinedButton.YES.name())) {
						remove();
					} else if (mb.getHideButton() == mb.getButtonById(PredefinedButton.NO.name())) {
						// perform NO action
					}
				}
			});
			mb.setWidth(300);
			mb.show();

			// MessageBox adkMessage = new MessageBox("Confirm Deletion", "Are you sure you want to delete the record");
			// adkMessage.setYesNoCancelType();
			// adkMessage.confirm(new Listener<MessageBoxEvent>() {
			//
			// public void handleEvent(MessageBoxEvent be) {
			// Button btn = be.getButtonClicked();
			// if ("yes".equalsIgnoreCase(btn.getText())) {
			// remove();
			// }
			// }
			// });
		} else {
			remove();
		}
	}
}