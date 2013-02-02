package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.company.application.carrental.client.model.vo.DriverEmploymentModelDto;
import com.company.application.carrental.client.ui.CarRentalConstants;
import com.company.gui.adkwidgets.client.ui.choice.ADKCheckBoxField;
import com.company.gui.adkwidgets.client.ui.field.ADKDateField;
import com.company.gui.adkwidgets.client.ui.field.ADKTextField;
import com.company.gui.adkwidgets.client.ui.form.ADKFormBinding;
import com.company.gui.adkwidgets.client.ui.grid.ADKCheckColumnConfig;
import com.company.gui.adkwidgets.client.ui.grid.ADKColumnConfig;
import com.company.gui.adkwidgets.client.ui.grid.ADKColumnList;
import com.company.gui.adkwidgets.client.ui.panel.ADKFormPanel;
import com.company.gui.adkwidgets.client.ui.panel.ADKHorizontalPanel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;

public class DriverEmploymentFB {

	private ADKFormBinding<DriverEmploymentModelDto> adkFormBinding;
	private ADKFormPanel driverControlPanel;

	public DriverEmploymentFB() {
		super();

		buildUI();
	}

	public void buildUI() {
		driverControlPanel = new ADKFormPanel("driverCtrlPanel");
		driverControlPanel.setLabelWidth(50);

		ADKHorizontalPanel row1Panel = new ADKHorizontalPanel("row1Panel");
		row1Panel.setSpacing(5);
		driverControlPanel.add(row1Panel);

		ADKTextField employmentType = new ADKTextField(DriverEmploymentModelDto.EMPLOYMENT_TYPE, "Employment Type", 150, 115, true);
		row1Panel.add(employmentType);

		ADKDateField beginDate = new ADKDateField(DriverEmploymentModelDto.BEGIN_DATE, "Begin Date", 150, 100, true);
		row1Panel.add(beginDate);

		ADKDateField endDate = new ADKDateField(DriverEmploymentModelDto.END_DATE, "End Date", 150, 100, true);
		row1Panel.add(endDate);

		ADKHorizontalPanel row2Panel = new ADKHorizontalPanel("row2Panel");
		row2Panel.setSpacing(5);
		driverControlPanel.add(row2Panel);

		ADKTextField employerName = new ADKTextField(DriverEmploymentModelDto.EMPLOYER_NAME, "Employer Name", 150, 115, true);
		row2Panel.add(employerName);

		ADKTextField companyName = new ADKTextField(DriverEmploymentModelDto.COMPANY_NAME, "Company Name", 150, 100, true);
		row2Panel.add(companyName);

		ADKTextField employerAddress = new ADKTextField(DriverEmploymentModelDto.EMPLOYER_ADDRESS, "Employer Address", 150, 100, false);
		row2Panel.add(employerAddress);

		ADKTextField employerContact = new ADKTextField(DriverEmploymentModelDto.EMPLOYER_CONTACT_NO, "Employer Contact", 150, 110, false);
		row2Panel.add(employerContact);

		ADKHorizontalPanel row3Panel = new ADKHorizontalPanel("row3Panel");
		row3Panel.setSpacing(5);
		driverControlPanel.add(row3Panel);

		ADKTextField reasonForLeaving = new ADKTextField(DriverEmploymentModelDto.REASON_FOR_LEAVING, "Reason For Leaving", 150, 115, false);
		row3Panel.add(reasonForLeaving);

		ADKTextField salary = new ADKTextField(DriverEmploymentModelDto.SALARY, "Salary", 150, 100, false);
		row3Panel.add(salary);

		ADKCheckBoxField referenceAllowed = new ADKCheckBoxField(DriverEmploymentModelDto.REFERENCE_ALLOWED, "Reference Allowed", 150, 100);
		row3Panel.add(referenceAllowed);

		RowNumberer numberer = new RowNumberer();

		List<DriverEmploymentModelDto> driverEmploymentList = new ArrayList<DriverEmploymentModelDto>();
		adkFormBinding =
				new ADKFormBinding<DriverEmploymentModelDto>("driverEmploymentAdkFormBinding", "Driver Employment", 1100, -1, 150,
						driverEmploymentList, getDriverEmploymentGridColumns(numberer), driverControlPanel, false);

		adkFormBinding.getButtonUpdate().removeAllListeners();
		adkFormBinding.getButtonUpdate().addSelectionListener(new DriverEmploymentUpdateListener());
		adkFormBinding.getButtonUpdate().setToolTip("Update");

		adkFormBinding.setAddListener(new SelectionListener<IconButtonEvent>() {

			@Override
			public void componentSelected(IconButtonEvent ce) {
				addDriverEmployment();
			}
		});

		adkFormBinding.getGrid().getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent>() {

			public void handleEvent(SelectionChangedEvent be) {

			}
		});

		adkFormBinding.setConfirmDeleteRequired(true);
		adkFormBinding.hideDeleteButton(true);
		adkFormBinding.getGrid().getView().setAdjustForHScroll(true);
		adkFormBinding.getGrid().getView().setAutoFill(true);
		adkFormBinding.getGrid().getGrid().setStripeRows(true);
		adkFormBinding.getGrid().getGrid().addPlugin(numberer);
	}

	private ADKColumnList getDriverEmploymentGridColumns(RowNumberer numberer) {
		ADKColumnList<ColumnConfig> columns = new ADKColumnList<ColumnConfig>();
		columns.add(numberer);

		ADKColumnConfig column = new ADKColumnConfig(DriverEmploymentModelDto.EMPLOYMENT_TYPE, "Employment Type", 100, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEmploymentModelDto.BEGIN_DATE, "Begin Date", 70, ADKColumnConfig.TEXT);
		column.setDateTimeFormat(CarRentalConstants.DATE_DD_MM_YY);
		columns.add(column);

		column = new ADKColumnConfig(DriverEmploymentModelDto.END_DATE, "End Date", 70, ADKColumnConfig.TEXT);
		column.setDateTimeFormat(CarRentalConstants.DATE_DD_MM_YY);
		columns.add(column);

		column = new ADKColumnConfig(DriverEmploymentModelDto.EMPLOYER_NAME, "Employer Name", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEmploymentModelDto.COMPANY_NAME, "Company Name", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEmploymentModelDto.EMPLOYER_ADDRESS, "Employer Address", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEmploymentModelDto.EMPLOYER_CONTACT_NO, "Employer Contact", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEmploymentModelDto.REASON_FOR_LEAVING, "Reason For Leaving", 120, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEmploymentModelDto.SALARY, "Salary", 70, ADKColumnConfig.TEXT);
		columns.add(column);

		ADKCheckColumnConfig checkColumn = new ADKCheckColumnConfig(DriverEmploymentModelDto.REFERENCE_ALLOWED, "Reference Allowed", 110);
		columns.add(checkColumn);

		return columns;
	}

	private void addDriverEmployment() {
		if (!driverControlPanel.isValid()) {
			return;
		}

		DriverEmploymentModelDto driverEmploymentModelDto = new DriverEmploymentModelDto();
		ModelData m = adkFormBinding.getCurrentFormModelData();
		driverEmploymentModelDto.setProperties(m.getProperties());
		driverEmploymentModelDto.setDriverId(DriverScreen.getGlobalDriverClientDto().getDriverId());
		// setDisplayValues(actionsStepsModelDto);

		// if (!validateStepSprintDates()) {
		// return;
		// }

		adkFormBinding.addGridItem(driverEmploymentModelDto, true);
		// refreshViewActionStepGrid(false);
	}

	public ADKFormBinding<DriverEmploymentModelDto> getAdkFormBinding() {
		return adkFormBinding;
	}

	public DriverEmploymentModelDto getSelectedDriverEmployment() {
		DriverEmploymentModelDto driverEmploymentModelDto = adkFormBinding.getGrid().getSelectionModel().getSelectedItem();
		return driverEmploymentModelDto;
	}

	class DriverEmploymentUpdateListener extends SelectionListener<IconButtonEvent> {

		@Override
		public void componentSelected(IconButtonEvent ce) {
			if (!driverControlPanel.isValid()) {
				return;
			}

			DriverEmploymentModelDto driverEmploymentModelDto = getSelectedDriverEmployment();
			Map<String, Object> oldProperties = driverEmploymentModelDto.getProperties();

			driverEmploymentModelDto.setProperties(adkFormBinding.getCurrentFormModelData().getProperties());

			// if (!validateStepSprintDates()) {
			// driverEmploymentModelDto.setProperties(oldProperties);
			// return;
			// }

			adkFormBinding.updateM();
		}
	}
}