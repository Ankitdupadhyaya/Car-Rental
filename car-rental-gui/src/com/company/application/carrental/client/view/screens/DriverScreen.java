package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverBackgroundCheckClientDto;
import com.company.application.carrental.client.model.vo.DriverMasterClientDto;
import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckInput;
import com.company.application.carrental.client.ui.ADKCustomHelpList;
import com.company.application.carrental.client.view.mediators.DriverScreenMediator;
import com.company.gui.adkwidgets.client.ui.button.ADKButton;
import com.company.gui.adkwidgets.client.ui.button.listener.ADKButtonListener;
import com.company.gui.adkwidgets.client.ui.field.ADKTextField;
import com.company.gui.adkwidgets.client.ui.panel.ADKPanel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.dnd.core.client.ListViewDragSource;
import com.sencha.gxt.dnd.core.client.ListViewDropTarget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.ListView;
import com.sencha.gxt.widget.core.client.Slider;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.ComboBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;

public class DriverScreen extends Composite {

	private static final String FINANCIAL_REG_CHECK = "Have you ever been suspended, expelled or otherwise disciplined or penalised by any financial regulatory body or by any financial self regulatory organisation, exchange or association, or been denied membership therein, or ever withdrawn your application to such membership?";
	private static final String EMPLOYMENT_GAP_CHECK = "Have you ever had a gap in your employment history of 6 months or greater?";
	private static final String TRAFFIC_VIOLATION_CHECK = "Have you ever been convicted or pleaded guilty to a crime of any kind other then minor traffic violation? Minor traffic violation - Include Parking tickets and other non moving violations in addition to traffic and similar moving violations. Driving while Intoxicated is not minor violation";
	private DriverScreenMediator mediator;

	ADKPanel formPanel;

	FieldSet basicFieldSet;

	private ADKButton saveApplicationButton;
	private ToolButton saveBackgroundCheckButton;

	private ADKCustomHelpList adkCustomHelpList;

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

	private TextField<String> identCodeTextField;
	private TextField<String> maritalStatusTextField;
	private TextField<String> passportNoTextField;
	private TextField<String> panNoTextField;

	private CheckBox trafficViolationCheckBox;
	private CheckBox empGapCheckBox;
	private CheckBox finRegCheckBox;

	private Slider ratingSlider;

	private DriverContactFB driverContactFB;
	private DriverAddressFB driverAddressFB;
	private DriverEducationFB driverEducationFB;
	private DriverEmploymentFB driverEmploymentFB;

	private static DriverMasterClientDto globalDriverClientDto;

	public DriverScreen(DriverScreenMediator mediator) {
		setMediator(mediator);

		buildUI();
	}

	private void buildUI() {
		final ADKPanel basicFormPanel = buildBasicTab();
		VerticalLayoutContainer basicContainer = new VerticalLayoutContainer();
		basicContainer.setScrollMode(ScrollMode.AUTO);
		basicContainer.add(basicFormPanel);

		final ADKPanel advancedFormPanel = buildBackgroundCheckTab();
		VerticalLayoutContainer advancedContainer = new VerticalLayoutContainer();
		advancedContainer.setScrollMode(ScrollMode.AUTO);
		advancedContainer.add(advancedFormPanel);

		final TabPanel tabPanel = new TabPanel();
		tabPanel.add(basicContainer, new TabItemConfig("Application"));
		tabPanel.add(advancedContainer, new TabItemConfig("Background Check"));

		initWidget(tabPanel);
	}

	private ADKPanel buildBasicTab() {
		formPanel = new ADKPanel("basicPanel");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHeight("700");
		verticalPanel.setSpacing(2);

		saveApplicationButton = new ADKButton("saveApplicationButton", "Save",
				new ADKButtonListener() {

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

		List<String> outputColumns = new ArrayList<String>();
		outputColumns.add("Driver_Id");
		outputColumns.add("Driver_FullName");
		outputColumns.add("Licence_No");

		adkCustomHelpList = new ADKCustomHelpList("driverApplicationHelpList",
				"Search Driver", "car_rental", "driver_master",
				"Driver_FullName", "Driver_FullName", outputColumns, false,
				100, 200);

		((ColumnConfig) adkCustomHelpList.getColumnsConfigList().get(0))
				.setHidden(true);

		EventType specialEvent = new EventType(800);
		adkCustomHelpList.setSpecialEventOnGridSelection(true, specialEvent);
		adkCustomHelpList.getHelpList().addListener(specialEvent,
				new Listener<BaseEvent>() {

					public void handleEvent(BaseEvent be) {
						mediator.searchDriverApplication((Integer) adkCustomHelpList
								.getModelValue().get("Driver_Id"));
					}
				});

		toolBar.add(adkCustomHelpList);

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
		appPanel.add(createTopFieldLabel(applicationNoTextField,
				"Application No"));
		appPanel.add(createTopFieldLabel(applicationDateField,
				"Application Date"));
		appPanel.add(createTopFieldLabel(applicationStatusTextField,
				"Application Status"));
		appPanel.add(createTopFieldLabel(applicationRemarksTextField,
				"Application Remarks"));
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
		appPanel.add(createTopFieldLabel(primaryContactTextField,
				"Primary Contact"));
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

		LicenseTypeProperties licenseTypeProperties = GWT
				.create(LicenseTypeProperties.class);
		ListStore store = new ListStore(licenseTypeProperties.value());
		store.add(new CarType("LMV", "LMV"));
		store.add(new CarType("HMV", "HMV"));
		licenseTypeCombo = new ComboBox(store, licenseTypeProperties.name());

		licenseExpiryDateField = new DateField();

		appPanel = new HorizontalPanel();
		appPanel.setSpacing(5);
		appPanel.add(createTopFieldLabel(licenseNoTextField, "License No"));
		appPanel.add(createTopFieldLabel(licenseTypeCombo, "License Type"));
		appPanel.add(createTopFieldLabel(licenseExpiryDateField,
				"License Expiry Date"));

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
		appPanel.add(createTopFieldLabel(medicalHistoryTextArea,
				"Medical History"));
		appPanel.add(createTopFieldLabel(eyeSightTextArea, "Eye Sight"));
		appPanel.add(createTopFieldLabel(diabetesTextArea, "Diabetes"));
		appPanel.add(createTopFieldLabel(accidentHistoryTextArea,
				"Accident History"));
		verticalPanel.add(appPanel);

		TextField driverRefNameTextField = new TextField();
		TextField driverRefNoTextField = new TextField();

		HorizontalLayoutContainer driverReferencePanel = new HorizontalLayoutContainer();
		Margins margins = new Margins(0, 5, 0, 0);
		HorizontalLayoutData horizontalLayoutData = new HorizontalLayoutData(
				200, 100, margins);
		driverReferencePanel.add(
				createTopFieldLabel(driverRefNameTextField,
						"Driver Reference Name"), horizontalLayoutData);
		driverReferencePanel.add(
				createTopFieldLabel(driverRefNoTextField,
						"Driver Reference Number"), horizontalLayoutData);

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

	private ADKPanel buildBackgroundCheckTab() {
		ADKPanel formPanel = new ADKPanel("backgroundCheckPanel");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHeight("700");
		verticalPanel.setSpacing(2);

		ButtonBar buttonBar = new ButtonBar();
		saveBackgroundCheckButton = new ToolButton(ToolButton.SAVE);

		saveBackgroundCheckButton.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				SaveDriverBackgroundCheckInput input = new SaveDriverBackgroundCheckInput();

				DriverBackgroundCheckClientDto backgroundCheckClientDto = new DriverBackgroundCheckClientDto();
				backgroundCheckClientDto
						.setIdentificationCode(identCodeTextField.getValue());
				backgroundCheckClientDto
						.setMaritalStatus(maritalStatusTextField.getValue());

				backgroundCheckClientDto.setPassportNo(passportNoTextField
						.getValue());
				backgroundCheckClientDto.setPanNo(panNoTextField.getValue());
				backgroundCheckClientDto
						.setTrafficViolation(trafficViolationCheckBox
								.getValue());
				backgroundCheckClientDto.setEmploymentGap(empGapCheckBox
						.getValue());
				backgroundCheckClientDto.setFinancialRegCheck(finRegCheckBox
						.getValue());

				input.addDriverContactList(driverContactFB.getAdkFormBinding()
						.getDataAdded());
				input.addDriverContactList(driverContactFB.getAdkFormBinding()
						.getDataUpdated());

				input.addDriverAddressList(driverAddressFB.getAdkFormBinding()
						.getDataAdded());
				input.addDriverAddressList(driverAddressFB.getAdkFormBinding()
						.getDataUpdated());

				input.addDriverEducationList(driverEducationFB
						.getAdkFormBinding().getDataAdded());
				input.addDriverEducationList(driverEducationFB
						.getAdkFormBinding().getDataUpdated());

				input.addDriverEmploymentList(driverEmploymentFB
						.getAdkFormBinding().getDataAdded());
				input.addDriverEmploymentList(driverEmploymentFB
						.getAdkFormBinding().getDataUpdated());

				mediator.saveDriverBackgroundCheck(input);
			}
		});

		buttonBar.add(saveBackgroundCheckButton);
		buttonBar.add(new ToolButton(ToolButton.REFRESH));
		verticalPanel.add(saveBackgroundCheckButton);

		identCodeTextField = new TextField();
		maritalStatusTextField = new TextField();
		passportNoTextField = new TextField();
		panNoTextField = new TextField();

		HorizontalLayoutContainer bgCheckPanel = new HorizontalLayoutContainer();
		Margins margins = new Margins(0, 5, 0, 0);
		HorizontalLayoutData horizontalLayoutData = new HorizontalLayoutData(
				100, 100, margins);
		bgCheckPanel.add(
				createTopFieldLabel(identCodeTextField, "Identification Code"),
				new HorizontalLayoutData(150, 100, margins));
		bgCheckPanel.add(
				createTopFieldLabel(maritalStatusTextField, "Marital Status"),
				horizontalLayoutData);
		bgCheckPanel.add(
				createTopFieldLabel(passportNoTextField, "Passport No."),
				horizontalLayoutData);
		bgCheckPanel.add(createTopFieldLabel(panNoTextField, "PAN No."),
				horizontalLayoutData);

		FieldSet bgCheckFieldSet = new FieldSet();
		bgCheckFieldSet.setSize("500", "80");
		bgCheckFieldSet.setHeadingText("Background Check");
		bgCheckFieldSet.setCollapsible(true);
		bgCheckFieldSet.add(bgCheckPanel);

		trafficViolationCheckBox = new CheckBox();
		trafficViolationCheckBox.setToolTip(TRAFFIC_VIOLATION_CHECK);
		empGapCheckBox = new CheckBox();
		empGapCheckBox.setToolTip(EMPLOYMENT_GAP_CHECK);
		finRegCheckBox = new CheckBox();
		finRegCheckBox.setToolTip(FINANCIAL_REG_CHECK);

		HorizontalLayoutContainer refCheckPanel = new HorizontalLayoutContainer();
		refCheckPanel.add(
				createTopFieldLabel(trafficViolationCheckBox,
						"Traffic Violation"), horizontalLayoutData);
		refCheckPanel.add(
				createTopFieldLabel(empGapCheckBox, "Employment Gap"),
				horizontalLayoutData);
		refCheckPanel.add(
				createTopFieldLabel(finRegCheckBox,
						"Financial Regulatory Check"),
				new HorizontalLayoutData(200, 100, margins));

		FieldSet refCheckFieldSet = new FieldSet();
		refCheckFieldSet.setSize("400", "80");
		refCheckFieldSet.setHeadingText("Reference Check");
		refCheckFieldSet.setCollapsible(true);
		refCheckFieldSet.add(refCheckPanel);

		// TextField ratingTextField = new TextField();
		// ratingTextField.setWidth(15);
		// ratingTextField.setHeight(10);

		ratingSlider = new Slider();
		ratingSlider.setMinValue(1);
		ratingSlider.setMaxValue(5);
		ratingSlider.setIncrement(1);

		HorizontalLayoutContainer driverRatingPanel = new HorizontalLayoutContainer();
		driverRatingPanel.add(createTopFieldLabel(ratingSlider, "1-5"),
				horizontalLayoutData);
		// driverRatingPanel.add(ratingTextField, new HorizontalLayoutData(20,
		// 10, new Margins(15, 5, 0, 5)));

		FieldSet driverRatingFieldSet = new FieldSet();
		driverRatingFieldSet.setSize("400", "80");
		driverRatingFieldSet.setHeadingText("Driver Rating");
		driverRatingFieldSet.setCollapsible(true);
		driverRatingFieldSet.add(driverRatingPanel);

		HorizontalPanel topPanel = new HorizontalPanel();
		topPanel.add(bgCheckFieldSet);
		topPanel.add(refCheckFieldSet);
		topPanel.add(driverRatingFieldSet);

		verticalPanel.add(topPanel);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		// horizontalPanel.add(new DriverContactControl().asWidget());
		// horizontalPanel.add(new DriverAddressControl().asWidget());
		// horizontalPanel.add(new DriverEducationControl().asWidget());
		driverContactFB = new DriverContactFB();
		horizontalPanel.add(driverContactFB.getAdkFormBinding());

		driverAddressFB = new DriverAddressFB();
		horizontalPanel.add(driverAddressFB.getAdkFormBinding());

		driverEducationFB = new DriverEducationFB();
		horizontalPanel.add(driverEducationFB.getAdkFormBinding());
		verticalPanel.add(horizontalPanel);

		horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		driverEmploymentFB = new DriverEmploymentFB();
		horizontalPanel.add(driverEmploymentFB.getAdkFormBinding());
		// horizontalPanel.add(new DriverEmploymentControl().asWidget());
		verticalPanel.add(horizontalPanel);

		formPanel.add(verticalPanel);

		return formPanel;
	}

	// public Widget rowEditingGrid() {
	// final DriverContactProperties props =
	// GWT.create(DriverContactProperties.class);
	//
	// List<ColumnConfig<DriverContact, ?>> columns = new
	// ArrayList<ColumnConfig<DriverContact, ?>>();
	// ColumnConfig<DriverContact, String> cc1 = new ColumnConfig<DriverContact,
	// String>(props.contactType(), 100, "Contact Type");
	// ColumnConfig<DriverContact, String> cc2 = new ColumnConfig<DriverContact,
	// String>(props.contactNumber(), 100, "Contact Number");
	// ColumnConfig<DriverContact, Boolean> cc3 = new
	// ColumnConfig<DriverContact, Boolean>(props.isPrimary(), 80, "Primary");
	//
	// cc3.setCell(new SimpleSafeHtmlCell<Boolean>(new
	// AbstractSafeHtmlRenderer<Boolean>() {
	//
	// public SafeHtml render(Boolean arg0) {
	// return SafeHtmlUtils.fromString(arg0 ? "True" : "False");
	// }
	// }));
	//
	// columns.add(cc1);
	// columns.add(cc2);
	// columns.add(cc3);
	//
	// ColumnModel<DriverContact> cm = new ColumnModel<DriverContact>(columns);
	//
	// final ListStore<DriverContact> store = new
	// ListStore<DriverContact>(props.key());
	// List<DriverContact> contacts = new ArrayList<DriverContact>();
	// contacts.add(new DriverContact(1, "1", "1", true));
	// contacts.add(new DriverContact(2, "2", "2", false));
	// contacts.add(new DriverContact(3, "3", "3", true));
	// store.addAll(contacts);
	//
	// Grid grid = new Grid<DriverContact>(store, cm);
	// grid.getView().setAutoExpandColumn(cc1);
	//
	// // EDITING//
	// final GridEditing<DriverContact> editing = new
	// GridRowEditing<DriverContact>(grid);
	// editing.addEditor(cc1, new TextField());
	//
	// // SimpleComboBox<Light> combo = new SimpleComboBox<Light>(new
	// StringLabelProvider<Light>());
	// // combo.setPropertyEditor(new PropertyEditor<Light>() {
	// //
	// // @Override
	// // public Light parse(CharSequence text) throws ParseException {
	// // return Light.parseString(text.toString());
	// // }
	// //
	// // @Override
	// // public String render(Light object) {
	// // return object == null ? Light.SUNNY.toString() : object.toString();
	// // }
	// // });
	// // combo.setTriggerAction(TriggerAction.ALL);
	// // combo.add(Light.SUNNY);
	// // combo.add(Light.MOSTLYSUNNY);
	// // combo.add(Light.SUNORSHADE);
	// // combo.add(Light.MOSTLYSHADY);
	// // combo.add(Light.SHADE);
	// // combo.setForceSelection(true);
	// // editing.addEditor(cc2, new Converter<String, Light>() {
	// //
	// // @Override
	// // public String convertFieldValue(Light object) {
	// // return object == null ? Light.SUNNY.toString() : object.toString();
	// // }
	// //
	// // @Override
	// // public Light convertModelValue(String object) {
	// // return Light.parseString(object);
	// // }
	// //
	// // }, combo);
	//
	// // DateField dateField = new DateField(new
	// DateTimePropertyEditor(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));
	// // dateField.setClearValueOnParseError(false);
	// // editing.addEditor(cc3, dateField);
	//
	// CheckBox checkField = new CheckBox();
	// editing.addEditor(cc3, checkField);
	//
	// // column 5 is not editable
	//
	// // EDITING//
	//
	// FramedPanel cp = new FramedPanel();
	// cp.setHeadingText("Editable Grid Example");
	// cp.setPixelSize(300, 300);
	// cp.addStyleName("margin-10");
	//
	// ToolBar toolBar = new ToolBar();
	//
	// TextButton add = new TextButton("Add DriverContact");
	// add.addSelectHandler(new SelectHandler() {
	//
	// public void onSelect(SelectEvent event) {
	// DriverContact plant = new DriverContact();
	// plant.setContactNumber("234234");
	//
	// editing.cancelEditing();
	// store.add(0, plant);
	// editing.startEditing(new GridCell(0, 0));
	// }
	// });
	//
	// toolBar.add(add);
	//
	// VerticalLayoutContainer con = new VerticalLayoutContainer();
	// con.setBorders(true);
	// con.add(toolBar, new VerticalLayoutData(1, .1));
	// con.add(grid, new VerticalLayoutData(1, .9));
	//
	// cp.setWidget(con);
	//
	// cp.setButtonAlign(BoxLayoutPack.CENTER);
	// cp.addButton(new TextButton("Reset", new SelectHandler() {
	//
	// public void onSelect(SelectEvent event) {
	// store.rejectChanges();
	// }
	// }));
	//
	// cp.addButton(new TextButton("Save", new SelectHandler() {
	//
	// public void onSelect(SelectEvent event) {
	// store.commitChanges();
	// }
	// }));
	//
	// return cp;
	// }

	private FieldLabel createTopFieldLabel(Widget widget, String label) {
		FieldLabel fieldLabel = new FieldLabel(widget, label);
		fieldLabel.setLabelAlign(LabelAlign.TOP);

		return fieldLabel;
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

	public DriverScreenMediator getMediator() {
		return mediator;
	}

	private void setMediator(DriverScreenMediator mediator) {
		this.mediator = mediator;
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

		ListView<CarType, String> list2 = new ListView<CarType, String>(store,
				props.name());
		list2.getSelectionModel().setSelectionMode(SelectionMode.MULTI);

		new ListViewDragSource<CarType>(list1);
		new ListViewDragSource<CarType>(list2);

		new ListViewDropTarget<CarType>(list1);
		new ListViewDropTarget<CarType>(list2);

		con.add(list1, new HorizontalLayoutData(.5, .8, new Margins(5)));
		con.add(list2,
				new HorizontalLayoutData(.5, .8, new Margins(5, 5, 5, 0)));

		fieldSet.add(con);

		return fieldSet;
	}

	public DriverMasterClientDto getApplicationFormData() {
		DriverMasterClientDto masterClientDto = new DriverMasterClientDto();
		masterClientDto.setApplicationNo(applicationNoTextField.getValue());
		masterClientDto.setApplicationDate(applicationDateField
				.getCurrentValue());
		masterClientDto.setApplicationStatusName(applicationStatusTextField
				.getValue());
		masterClientDto.setApplicationRemarks(applicationRemarksTextField
				.getCurrentValue());
		masterClientDto.setUserName(userTextField.getValue());

		masterClientDto.setDriverFullName(fullNameTextField.getValue());
		masterClientDto.setPrimaryContactNumber(primaryContactTextField
				.getValue());
		// masterClientDto.setCurrentAreaId(currentAreaTextField.getCurrentValue());
		// masterClientDto.setGender(genderTextField.getCurrentValue());
		masterClientDto.setDob(dobDateField.getCurrentValue());

		// masterClientDto.setLicenceNo(licenseNoTextField.getCurrentValue());
		masterClientDto.setLicenceType((String) licenseTypeCombo
				.getCurrentValue());
		masterClientDto.setLicenceExpiryDate(licenseExpiryDateField
				.getCurrentValue());
		masterClientDto.setMedicalHistory(medicalHistoryTextArea.getValue());
		masterClientDto.setEyeSight(eyeSightTextArea.getValue());
		masterClientDto.setDiabetes(diabetesTextArea.getValue());
		masterClientDto.setAccidentHistory(accidentHistoryTextArea.getValue());
		return masterClientDto;
	}

	public void populateApplicationFormData() {

		// clearApplicationFormData();

		// applicationNoTextField.setValue(globalDriverClientDto.getApplicationNo());
		// applicationDateField.setValue(globalDriverClientDto.getApplicationDate());
		// applicationStatusTextField.setValue(globalDriverClientDto.getApplicationStatusName());
		// applicationRemarksTextField.setValue(globalDriverClientDto.getApplicationRemarks());
		// userTextField.setValue(globalDriverClientDto.getUserId());
		// fullNameTextField.setValue("Test");
		fullNameTextField.setValue(globalDriverClientDto.getDriverFullName());
		primaryContactTextField.setValue(globalDriverClientDto
				.getPrimaryContactNumber());
		// masterClientDto.setCurrentAreaId(currentAreaTextField.getCurrentValue());
		// masterClientDto.setGender(genderTextField.getCurrentValue());
		dobDateField.setValue(globalDriverClientDto.getDob());

		licenseNoTextField.setValue(globalDriverClientDto.getLicenceNo());
		// licenseTypeCombo.setValue(globalDriverClientDto.getLicenceType());
		licenseExpiryDateField.setValue(globalDriverClientDto
				.getLicenceExpiryDate());
		medicalHistoryTextArea.setValue(globalDriverClientDto
				.getMedicalHistory());
		eyeSightTextArea.setValue(globalDriverClientDto.getEyeSight());
		diabetesTextArea.setValue(globalDriverClientDto.getDiabetes());
		accidentHistoryTextArea.setValue(globalDriverClientDto
				.getAccidentHistory());

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

	interface LicenseTypeProperties extends PropertyAccess<LicenseType> {

		ModelKeyProvider<LicenseType> value();

		LabelProvider<LicenseType> name();
	}

	class LicenseType {

		private String name;
		private String value;

		public LicenseType() {
			super();
			// TODO Auto-generated constructor stub
		}

		public LicenseType(String name, String value) {
			super();
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	interface CarTypeProperties extends PropertyAccess<CarType> {

		ModelKeyProvider<CarType> value();

		ValueProvider<CarType, String> name();
	}

	static class CarType {

		private String name;
		private String value;

		public CarType() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CarType(String name, String value) {
			super();
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public void refreshApplicationForm() {

	}

	public static DriverMasterClientDto getGlobalDriverClientDto() {
		return globalDriverClientDto;
	}

	public void setGlobalDriverClientDto(
			DriverMasterClientDto globalDriverClientDto) {
		this.globalDriverClientDto = globalDriverClientDto;
	}
}