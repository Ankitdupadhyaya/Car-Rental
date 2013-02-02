package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckOutput;
import com.company.application.carrental.client.model.vo.SearchDriverBackgroundCheckOutput;
import com.company.application.carrental.client.view.mediators.DriverScreenMediator;
import com.company.gui.adkwidgets.client.ui.panel.ADKTabPanel;
import com.extjs.gxt.ui.client.widget.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;

public class DriverScreen extends Composite {

	private DriverScreenMediator mediator;
	private DriverApplicationTab driverAppTabItem;
	private DriverBgCheckTab driverBgCheckTabItem;

	public DriverScreen(DriverScreenMediator mediator) {
		setMediator(mediator);

		buildUI();
	}

	private void buildUI() {

		ADKTabPanel driverTabPanel = new ADKTabPanel("driverTabPanel");

		driverAppTabItem = new DriverApplicationTab(getMediator());
		driverTabPanel.add(driverAppTabItem);

		driverBgCheckTabItem = new DriverBgCheckTab(getMediator());
		driverTabPanel.add(driverBgCheckTabItem);

		initComponent(driverTabPanel);
	}

	private List<String> getDriverHelplistColumns() {
		List<String> outputColumns = new ArrayList<String>();
		outputColumns.add("Driver_Id");
		outputColumns.add("Driver_FullName");
		outputColumns.add("Licence_No");

		return outputColumns;
	}

	private FieldLabel createTopFieldLabel(Widget widget, String label) {
		FieldLabel fieldLabel = new FieldLabel(widget, label);
		fieldLabel.setLabelAlign(LabelAlign.TOP);

		return fieldLabel;
	}

	public DriverScreenMediator getMediator() {
		return mediator;
	}

	private void setMediator(DriverScreenMediator mediator) {
		this.mediator = mediator;
	}

	public void populateApplicationFormData() {
		driverAppTabItem.populateApplicationFormData();
	}

	public void populateBackgroundCheckFormData(SaveDriverBackgroundCheckOutput output) {
		driverBgCheckTabItem.populateBackgroundCheckFormData(output.getDriverContactModelDtos(), output.getDriverAddressModelDtos(),
				output.getDriverEducationModelDtos(), output.getDriverEmploymentModelDtos());
	}

	public void populateBackgroundCheckFormData(SearchDriverBackgroundCheckOutput output) {
		driverBgCheckTabItem.populateBackgroundCheckFormData(output.getDriverContactModelDtos(), output.getDriverAddressModelDtos(),
				output.getDriverEducationModelDtos(), output.getDriverEmploymentModelDtos());
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

}