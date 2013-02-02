package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverMasterClientDto;
import com.company.application.carrental.client.ui.ADKCustomHelpList;
import com.company.application.carrental.client.view.mediators.DriverScreenMediator;
import com.company.application.carrental.client.view.screens.DriverScreen.CarType;
import com.company.application.carrental.client.view.screens.DriverScreen.CarTypeProperties;
import com.company.application.carrental.client.view.screens.DriverScreen.LicenseTypeProperties;
import com.company.gui.adkwidgets.client.ui.button.ADKButton;
import com.company.gui.adkwidgets.client.ui.button.listener.ADKButtonListener;
import com.company.gui.adkwidgets.client.ui.panel.ADKPanel;
import com.company.gui.adkwidgets.client.ui.tab.ADKTabItem;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.dnd.core.client.ListViewDragSource;
import com.sencha.gxt.dnd.core.client.ListViewDropTarget;
import com.sencha.gxt.widget.core.client.ListView;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.TextArea;

public class DriverApplicationTab extends ADKTabItem {

	private DriverScreenMediator mediator;

	private ADKPanel formPanel;

	private FieldSet basicFieldSet;

	private ADKButton saveApplicationButton;
	private ADKCustomHelpList driverAppHelpList;
	private TextField<String> applicationNoTextField;
	private DateField applicationDateField;
	private TextField<String> applicationStatusTextField;
	private TextArea applicationRemarksTextField;
	private TextField<String> userTextField;

	private TextField<String> fullNameTextField;
	private TextField<String> primaryContactTextField;
	private TextField<String> currentAreaTextField;
	private TextField<String> genderTextField;
	private DateField dobDateField;

	private TextField<String> licenseNoTextField;
	private ComboBox licenseTypeCombo;
	private DateField licenseExpiryDateField;

	private TextArea medicalHistoryTextArea;
	private TextArea eyeSightTextArea;
	private TextArea diabetesTextArea;
	private TextArea accidentHistoryTextArea;

	public DriverApplicationTab(DriverScreenMediator mediator) {
		super("driverApplicationTab", "Driver Application");

		this.mediator = mediator;

		setWidth(800);
		setHeight(600);

		VerticalLayoutContainer basicContainer = new VerticalLayoutContainer();
		basicContainer.setScrollMode(ScrollMode.AUTO);
		basicContainer.add(buildBasicTab());

		add(basicContainer);
	}

	private List<String> getDriverHelplistColumns() {
		List<String> outputColumns = new ArrayList<String>();
		outputColumns.add("Driver_Id");
		outputColumns.add("Driver_FullName");
		outputColumns.add("Licence_No");
		return outputColumns;
	}

	private ADKPanel buildBasicTab() {
		formPanel = new ADKPanel("basicPanel");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHeight("700");
		verticalPanel.setSpacing(2);

		saveApplicationButton = new ADKButton("saveApplicationButton", "Save", new ADKButtonListener() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				super.componentSelected(ce);

				DriverMasterClientDto masterClientDto = getApplicationFormData();

				mediator.saveDriverApplication(masterClientDto);
			}
		});

		ToolBar toolBar = new ToolBar();
		// ADKCustomHelpList adkCustomHelpList =
		// new ADKCustomHelpList("driverApplicationHelpList", "Search Driver",
		// "car_rental", "driver_master", false, 100, 200);
		// toolBar.add(adkCustomHelpList);

		List<String> outputColumns = getDriverHelplistColumns();

		driverAppHelpList =
				new ADKCustomHelpList("driverApplicationHelpList", "Search Driver", "car_rental", "driver_master", "Driver_FullName",
						"Driver_FullName", outputColumns, false, 100, 200);

		((ColumnConfig) driverAppHelpList.getColumnsConfigList().get(0)).setHidden(true);

		EventType specialEvent = new EventType(800);
		driverAppHelpList.setSpecialEventOnGridSelection(true, specialEvent);
		driverAppHelpList.getHelpList().addListener(specialEvent, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				mediator.searchDriverApplication((Integer) driverAppHelpList.getModelValue().get("Driver_Id"));
			}
		});

		toolBar.add(driverAppHelpList);
		toolBar.add(new FillToolItem());
		toolBar.add(saveApplicationButton);
		// toolBar.add(new ToolButton(ToolButton.REFRESH));
		verticalPanel.add(toolBar);

		applicationNoTextField = new TextField();
		applicationDateField = new DateField();
		applicationStatusTextField = new TextField();
		applicationRemarksTextField = new TextArea();
		userTextField = new TextField();

		HorizontalPanel appPanel = new HorizontalPanel();
		appPanel.add(createTopFieldLabel(applicationNoTextField, "Application No"));
		appPanel.add(createTopFieldLabel(applicationDateField, "Application Date"));
		appPanel.add(createTopFieldLabel(applicationStatusTextField, "Application Status"));
		appPanel.add(createTopFieldLabel(applicationRemarksTextField, "Application Remarks"));
		appPanel.add(createTopFieldLabel(userTextField, "User"));

		FieldSet appFieldSet = new FieldSet();
		appFieldSet.setHeadingText("Application");
		appFieldSet.setCollapsible(true);
		appFieldSet.setWidth(850);
		appFieldSet.add(appPanel);

		verticalPanel.add(appFieldSet);

		fullNameTextField = new TextField<String>();
		primaryContactTextField = new TextField();
		currentAreaTextField = new TextField();
		genderTextField = new TextField();
		dobDateField = new DateField();

		appPanel = new HorizontalPanel();
		appPanel.setSpacing(10);
		appPanel.add(createTopFieldLabel(fullNameTextField, "Full Name"));
		appPanel.add(createTopFieldLabel(primaryContactTextField, "Primary Contact"));
		appPanel.add(createTopFieldLabel(currentAreaTextField, "Current Area"));
		// verticalPanel.add(appPanel);
		//
		// appPanel = new HorizontalPanel();
		// appPanel.setSpacing(5);
		appPanel.add(createTopFieldLabel(genderTextField, "Gender"));
		appPanel.add(createTopFieldLabel(dobDateField, "DOB"));

		basicFieldSet = new FieldSet();
		basicFieldSet.setHeadingText("Basic Details");
		basicFieldSet.setCollapsible(true);
		basicFieldSet.setWidth(1000);
		basicFieldSet.add(appPanel);

		verticalPanel.add(basicFieldSet);

		licenseNoTextField = new TextField();

		LicenseTypeProperties licenseTypeProperties = GWT.create(LicenseTypeProperties.class);
		ListStore store = new ListStore(licenseTypeProperties.value());
		store.add(new CarType("LMV", "LMV"));
		store.add(new CarType("HMV", "HMV"));
		licenseTypeCombo = new ComboBox(store, licenseTypeProperties.name());

		licenseExpiryDateField = new DateField();

		appPanel = new HorizontalPanel();
		appPanel.setSpacing(5);
		appPanel.add(createTopFieldLabel(licenseNoTextField, "License No"));
		appPanel.add(createTopFieldLabel(licenseTypeCombo, "License Type"));
		appPanel.add(createTopFieldLabel(licenseExpiryDateField, "License Expiry Date"));

		FieldSet licenseFieldSet = new FieldSet();
		licenseFieldSet.setHeadingText("License");
		// licenseFieldSet.setCollapsible(true);
		licenseFieldSet.setWidth(550);
		licenseFieldSet.setHeight(100);
		licenseFieldSet.add(appPanel);

		HorizontalPanel parentPanel = new HorizontalPanel();
		parentPanel.setSpacing(5);
		parentPanel.add(licenseFieldSet);

		HorizontalPanel jobPrefPanel = new HorizontalPanel();

		FieldSet indiFieldSet = new FieldSet();
		indiFieldSet.setHeadingText("Individual");
		indiFieldSet.add(buildJobPrefPanel());
		jobPrefPanel.add(indiFieldSet);

		FieldSet companyFieldSet = new FieldSet();
		companyFieldSet.setHeadingText("Company");
		companyFieldSet.add(buildJobPrefPanel());
		jobPrefPanel.add(companyFieldSet);

		FieldSet jobPrefFieldSet = new FieldSet();
		jobPrefFieldSet.setHeadingText("Job Preference");
		// jobPrefFieldSet.setCollapsible(true);
		jobPrefFieldSet.setWidth(600);
		jobPrefFieldSet.setHeight(100);
		jobPrefFieldSet.add(jobPrefPanel);

		parentPanel.add(jobPrefFieldSet);
		verticalPanel.add(parentPanel);

		TextField totalExpTextField = new TextField();
		TextField curSalTextField = new TextField();
		TextField expSalTextField = new TextField();

		appPanel = new HorizontalPanel();
		appPanel.setSpacing(5);
		appPanel.add(createTopFieldLabel(totalExpTextField, "Total Exp"));
		appPanel.add(createTopFieldLabel(curSalTextField, "Current Salary"));
		appPanel.add(createTopFieldLabel(expSalTextField, "Expected Salary"));
		// verticalPanel.add(appPanel);

		medicalHistoryTextArea = new TextArea();
		eyeSightTextArea = new TextArea();
		diabetesTextArea = new TextArea();
		accidentHistoryTextArea = new TextArea();

		// appPanel = new HorizontalPanel();
		// appPanel.setSpacing(5);
		appPanel.add(createTopFieldLabel(medicalHistoryTextArea, "Medical History"));
		appPanel.add(createTopFieldLabel(eyeSightTextArea, "Eye Sight"));
		appPanel.add(createTopFieldLabel(diabetesTextArea, "Diabetes"));
		appPanel.add(createTopFieldLabel(accidentHistoryTextArea, "Accident History"));
		verticalPanel.add(appPanel);

		TextField driverRefNameTextField = new TextField();
		TextField driverRefNoTextField = new TextField();

		HorizontalLayoutContainer driverReferencePanel = new HorizontalLayoutContainer();
		Margins margins = new Margins(0, 5, 0, 0);
		HorizontalLayoutData horizontalLayoutData = new HorizontalLayoutData(200, 100, margins);
		driverReferencePanel.add(createTopFieldLabel(driverRefNameTextField, "Driver Reference Name"), horizontalLayoutData);
		driverReferencePanel.add(createTopFieldLabel(driverRefNoTextField, "Driver Reference Number"), horizontalLayoutData);

		FieldSet driverReferenceFieldSet = new FieldSet();
		driverReferenceFieldSet.setSize("450", "80");
		driverReferenceFieldSet.setHeadingText("Driver Reference");
		driverReferenceFieldSet.setCollapsible(true);
		driverReferenceFieldSet.add(driverReferencePanel);

		parentPanel = new HorizontalPanel();
		parentPanel.setSpacing(5);
		parentPanel.add(buildCarType());
		parentPanel.add(driverReferenceFieldSet);

		verticalPanel.add(parentPanel);

		formPanel.add(verticalPanel);
		return formPanel;
	}

	public void populateApplicationFormData() {

		// clearApplicationFormData();

		// applicationNoTextField.setValue(globalDriverClientDto.getApplicationNo());
		// applicationDateField.setValue(globalDriverClientDto.getApplicationDate());
		// applicationStatusTextField.setValue(globalDriverClientDto.getApplicationStatusName());
		// applicationRemarksTextField.setValue(globalDriverClientDto.getApplicationRemarks());
		// userTextField.setValue(globalDriverClientDto.getUserId());
		// fullNameTextField.setValue("Test");
		fullNameTextField.setValue(mediator.getGlobalDriverClientDto().getDriverFullName());
		primaryContactTextField.setValue(mediator.getGlobalDriverClientDto().getPrimaryContactNumber());
		// masterClientDto.setCurrentAreaId(currentAreaTextField.getCurrentValue());
		// masterClientDto.setGender(genderTextField.getCurrentValue());
		dobDateField.setValue(mediator.getGlobalDriverClientDto().getDob());

		licenseNoTextField.setValue(mediator.getGlobalDriverClientDto().getLicenceNo());
		// licenseTypeCombo.setValue(mediator.getGlobalDriverClientDto().getLicenceType());
		licenseExpiryDateField.setValue(mediator.getGlobalDriverClientDto().getLicenceExpiryDate());
		medicalHistoryTextArea.setValue(mediator.getGlobalDriverClientDto().getMedicalHistory());
		eyeSightTextArea.setValue(mediator.getGlobalDriverClientDto().getEyeSight());
		diabetesTextArea.setValue(mediator.getGlobalDriverClientDto().getDiabetes());
		accidentHistoryTextArea.setValue(mediator.getGlobalDriverClientDto().getAccidentHistory());

	}

	public void clearApplicationFormData() {
		// applicationNoTextField.setValue("");
		// applicationDateField.setValue("");
		// applicationStatusTextField.setValue("");
		// applicationRemarksTextField.setValue("");
		// userTextField.setValue("");
		fullNameTextField.setValue("");
		primaryContactTextField.setValue("");
		// masterClientDto.setCurrentAreaId("");
		// masterClientDto.setGender("");
		dobDateField.reset();

		licenseNoTextField.setValue("");

		// licenseTypeCombo.setValue("");
		licenseExpiryDateField.reset();
		medicalHistoryTextArea.setValue("");
		eyeSightTextArea.setValue("");
		diabetesTextArea.setValue("");
		accidentHistoryTextArea.setValue("");
	}

	public DriverMasterClientDto getApplicationFormData() {
		DriverMasterClientDto masterClientDto = new DriverMasterClientDto();
		masterClientDto.setApplicationNo(applicationNoTextField.getValue());
		masterClientDto.setApplicationDate(applicationDateField.getCurrentValue());
		masterClientDto.setApplicationStatusName(applicationStatusTextField.getValue());
		masterClientDto.setApplicationRemarks(applicationRemarksTextField.getCurrentValue());
		masterClientDto.setUserName(userTextField.getValue());

		masterClientDto.setDriverFullName(fullNameTextField.getValue());
		masterClientDto.setPrimaryContactNumber(primaryContactTextField.getValue());
		// masterClientDto.setCurrentAreaId(currentAreaTextField.getCurrentValue());
		// masterClientDto.setGender(genderTextField.getCurrentValue());
		masterClientDto.setDob(dobDateField.getCurrentValue());

		// masterClientDto.setLicenceNo(licenseNoTextField.getCurrentValue());
		masterClientDto.setLicenceType((String) licenseTypeCombo.getCurrentValue());
		masterClientDto.setLicenceExpiryDate(licenseExpiryDateField.getCurrentValue());
		masterClientDto.setMedicalHistory(medicalHistoryTextArea.getValue());
		masterClientDto.setEyeSight(eyeSightTextArea.getValue());
		masterClientDto.setDiabetes(diabetesTextArea.getValue());
		masterClientDto.setAccidentHistory(accidentHistoryTextArea.getValue());
		return masterClientDto;
	}

	public Widget buildCarType() {
		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingText("Car Type");
		fieldSet.setPixelSize(200, 100);
		fieldSet.setCollapsible(true);

		HorizontalLayoutContainer con = new HorizontalLayoutContainer();

		CarTypeProperties props = GWT.create(CarTypeProperties.class);
		ListStore<CarType> store = new ListStore<CarType>(props.value());
		// store.addSortInfo(new StoreSortInfo<CarType>(props.nameProp(),
		// SortDir.ASC));
		store.add(new CarType("Car", "Car"));
		store.add(new CarType("Bus", "Bus"));
		ListView list1 = new ListView(store, props.name());

		store = new ListStore<CarType>(props.value());
		// store.addSortInfo(new StoreSortInfo<CarType>(props.name(),
		// SortDir.ASC));

		ListView<CarType, String> list2 = new ListView<CarType, String>(store, props.name());
		list2.getSelectionModel().setSelectionMode(SelectionMode.MULTI);

		new ListViewDragSource<CarType>(list1);
		new ListViewDragSource<CarType>(list2);

		new ListViewDropTarget<CarType>(list1);
		new ListViewDropTarget<CarType>(list2);

		con.add(list1, new HorizontalLayoutData(.5, .8, new Margins(5)));
		con.add(list2, new HorizontalLayoutData(.5, .8, new Margins(5, 5, 5, 0)));

		fieldSet.add(con);

		return fieldSet;
	}

	private HorizontalPanel buildJobPrefPanel() {
		CheckBox temporaryCheckBox = new CheckBox();
		temporaryCheckBox.setBoxLabel("Temporary");

		CheckBox permanentCheckBox = new CheckBox();
		permanentCheckBox.setBoxLabel("Permanent");

		CheckBox adhocCheckBox = new CheckBox();
		adhocCheckBox.setBoxLabel("Adhoc");

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.add(temporaryCheckBox);
		horizontalPanel.add(permanentCheckBox);
		horizontalPanel.add(adhocCheckBox);
		return horizontalPanel;
	}

	private FieldLabel createTopFieldLabel(Widget widget, String label) {
		FieldLabel fieldLabel = new FieldLabel(widget, label);
		fieldLabel.setLabelAlign(LabelAlign.TOP);

		return fieldLabel;
	}

	public void refreshDriverScreen() {
		formPanel.refresh();
	}
}