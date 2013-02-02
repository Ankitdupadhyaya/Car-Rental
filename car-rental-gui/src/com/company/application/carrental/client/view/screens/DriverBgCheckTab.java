package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverAddressModelDto;
import com.company.application.carrental.client.model.vo.DriverBackgroundCheckClientDto;
import com.company.application.carrental.client.model.vo.DriverContactModelDto;
import com.company.application.carrental.client.model.vo.DriverEducationModelDto;
import com.company.application.carrental.client.model.vo.DriverEmploymentModelDto;
import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckInput;
import com.company.application.carrental.client.ui.ADKCustomHelpList;
import com.company.application.carrental.client.view.mediators.DriverScreenMediator;
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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.Slider;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;

public class DriverBgCheckTab extends ADKTabItem {

	private DriverScreenMediator mediator;

	private static final String FINANCIAL_REG_CHECK =
			"Have you ever been suspended, expelled or otherwise disciplined or penalised by any financial regulatory body or by any financial self regulatory organisation, exchange or association, or been denied membership therein, or ever withdrawn your application to such membership?";
	private static final String EMPLOYMENT_GAP_CHECK = "Have you ever had a gap in your employment history of 6 months or greater?";
	private static final String TRAFFIC_VIOLATION_CHECK =
			"Have you ever been convicted or pleaded guilty to a crime of any kind other then minor traffic violation? Minor traffic violation - Include Parking tickets and other non moving violations in addition to traffic and similar moving violations. Driving while Intoxicated is not minor violation";

	private ADKButton saveBackgroundCheckButton;

	private ADKCustomHelpList driverBgHelpList;

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

	public DriverBgCheckTab(DriverScreenMediator mediator) {
		super("driverBgCheckTab", "Driver Background Check");

		this.mediator = mediator;

		setWidth(800);
		setHeight(800);

		VerticalLayoutContainer basicContainer = new VerticalLayoutContainer();
		basicContainer.setScrollMode(ScrollMode.AUTO);
		basicContainer.add(buildBackgroundCheckTab());

		add(basicContainer);
	}

	private List<String> getDriverHelplistColumns() {
		List<String> outputColumns = new ArrayList<String>();
		outputColumns.add("Driver_Id");
		outputColumns.add("Driver_FullName");
		outputColumns.add("Licence_No");

		return outputColumns;
	}

	private ADKPanel buildBackgroundCheckTab() {
		ADKPanel formPanel = new ADKPanel("backgroundCheckPanel");

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHeight("700");
		verticalPanel.setSpacing(2);

		ButtonBar buttonBar = new ButtonBar();
		saveBackgroundCheckButton = new ADKButton("saveApplicationButton", "Save", new ADKButtonListener() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				super.componentSelected(ce);
				SaveDriverBackgroundCheckInput input = getBackgroundCheckFormData();

				mediator.saveDriverBackgroundCheck(input);
			}

		});

		List<String> outputColumns = getDriverHelplistColumns();

		driverBgHelpList =
				new ADKCustomHelpList("driverApplicationHelpList", "Search Driver", "car_rental", "driver_master", "Driver_FullName",
						"Driver_FullName", outputColumns, false, 100, 200);

		((ColumnConfig) driverBgHelpList.getColumnsConfigList().get(0)).setHidden(true);

		EventType specialEvent = new EventType(800);
		driverBgHelpList.setSpecialEventOnGridSelection(true, specialEvent);
		driverBgHelpList.getHelpList().addListener(specialEvent, new Listener<BaseEvent>() {

			public void handleEvent(BaseEvent be) {
				mediator.searchDriverBackground((Integer) driverBgHelpList.getModelValue().get("Driver_Id"));
			}
		});

		ToolBar toolBar = new ToolBar();

		toolBar.add(driverBgHelpList);
		toolBar.add(new FillToolItem());

		toolBar.add(saveBackgroundCheckButton);
		// buttonBar.add(saveBackgroundCheckButton);
		// toolBar.add(new ToolButton(ToolButton.REFRESH));
		verticalPanel.add(toolBar);

		identCodeTextField = new TextField();
		maritalStatusTextField = new TextField();
		passportNoTextField = new TextField();
		panNoTextField = new TextField();

		HorizontalLayoutContainer bgCheckPanel = new HorizontalLayoutContainer();
		Margins margins = new Margins(0, 5, 0, 0);
		HorizontalLayoutData horizontalLayoutData = new HorizontalLayoutData(100, 100, margins);
		bgCheckPanel.add(createTopFieldLabel(identCodeTextField, "Identification Code"), new HorizontalLayoutData(150, 100, margins));
		bgCheckPanel.add(createTopFieldLabel(maritalStatusTextField, "Marital Status"), horizontalLayoutData);
		bgCheckPanel.add(createTopFieldLabel(passportNoTextField, "Passport No."), horizontalLayoutData);
		bgCheckPanel.add(createTopFieldLabel(panNoTextField, "PAN No."), horizontalLayoutData);

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
		refCheckPanel.add(createTopFieldLabel(trafficViolationCheckBox, "Traffic Violation"), horizontalLayoutData);
		refCheckPanel.add(createTopFieldLabel(empGapCheckBox, "Employment Gap"), horizontalLayoutData);
		refCheckPanel.add(createTopFieldLabel(finRegCheckBox, "Financial Regulatory Check"), new HorizontalLayoutData(200, 100, margins));

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
		driverRatingPanel.add(createTopFieldLabel(ratingSlider, "1-5"), horizontalLayoutData);
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
		driverContactFB = new DriverContactFB(mediator);
		horizontalPanel.add(driverContactFB.getAdkFormBinding());

		driverAddressFB = new DriverAddressFB(mediator);
		horizontalPanel.add(driverAddressFB.getAdkFormBinding());

		driverEducationFB = new DriverEducationFB(mediator);
		horizontalPanel.add(driverEducationFB.getAdkFormBinding());
		verticalPanel.add(horizontalPanel);

		horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		driverEmploymentFB = new DriverEmploymentFB(mediator);
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

	public SaveDriverBackgroundCheckInput getBackgroundCheckFormData() {
		SaveDriverBackgroundCheckInput input = new SaveDriverBackgroundCheckInput();

		DriverBackgroundCheckClientDto backgroundCheckClientDto = new DriverBackgroundCheckClientDto();
		backgroundCheckClientDto.setIdentificationCode(identCodeTextField.getValue());
		backgroundCheckClientDto.setMaritalStatus(maritalStatusTextField.getValue());

		backgroundCheckClientDto.setPassportNo(passportNoTextField.getValue());
		backgroundCheckClientDto.setPanNo(panNoTextField.getValue());
		backgroundCheckClientDto.setTrafficViolation(trafficViolationCheckBox.getValue());
		backgroundCheckClientDto.setEmploymentGap(empGapCheckBox.getValue());
		backgroundCheckClientDto.setFinancialRegCheck(finRegCheckBox.getValue());

		input.addDriverContactList(driverContactFB.getAdkFormBinding().getDataAdded());
		input.addDriverContactList(driverContactFB.getAdkFormBinding().getDataUpdated());

		input.addDriverAddressList(driverAddressFB.getAdkFormBinding().getDataAdded());
		input.addDriverAddressList(driverAddressFB.getAdkFormBinding().getDataUpdated());

		input.addDriverEducationList(driverEducationFB.getAdkFormBinding().getDataAdded());
		input.addDriverEducationList(driverEducationFB.getAdkFormBinding().getDataUpdated());

		input.addDriverEmploymentList(driverEmploymentFB.getAdkFormBinding().getDataAdded());
		input.addDriverEmploymentList(driverEmploymentFB.getAdkFormBinding().getDataUpdated());
		return input;
	}

	public void populateBackgroundCheckFormData(List<DriverContactModelDto> contacts, List<DriverAddressModelDto> addresses,
			List<DriverEducationModelDto> educations, List<DriverEmploymentModelDto> employments) {

		driverContactFB.resetContactsFormBinding();
		for (DriverContactModelDto contact : contacts) {
			driverContactFB.getAdkFormBinding().addGridExistingItem(contact, true);
		}
		driverContactFB.getAdkFormBinding().refresh();

		driverAddressFB.resetAddressesFormBinding();
		for (DriverAddressModelDto address : addresses) {
			driverAddressFB.getAdkFormBinding().addGridExistingItem(address, true);
		}

		driverEducationFB.resetEducationsFormBinding();
		for (DriverEducationModelDto education : educations) {
			driverEducationFB.getAdkFormBinding().addGridExistingItem(education, true);
		}

		driverEmploymentFB.resetEmploymentsFormBinding();
		for (DriverEmploymentModelDto employment : employments) {
			driverEmploymentFB.getAdkFormBinding().addGridExistingItem(employment, true);
		}

	}

	private FieldLabel createTopFieldLabel(Widget widget, String label) {
		FieldLabel fieldLabel = new FieldLabel(widget, label);
		fieldLabel.setLabelAlign(LabelAlign.TOP);

		return fieldLabel;
	}
}