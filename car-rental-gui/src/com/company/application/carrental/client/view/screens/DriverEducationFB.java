package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.company.application.carrental.client.model.vo.DriverEducationModelDto;
import com.company.application.carrental.client.view.mediators.DriverScreenMediator;
import com.company.gui.adkwidgets.client.ui.field.ADKTextField;
import com.company.gui.adkwidgets.client.ui.form.ADKFormBinding;
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

public class DriverEducationFB {

	private DriverScreenMediator mediator;
	private ADKFormBinding<DriverEducationModelDto> adkFormBinding;
	private ADKFormPanel driverControlPanel;

	public DriverEducationFB(DriverScreenMediator mediator) {
		super();

		this.mediator = mediator;

		buildUI();
	}

	public void buildUI() {
		driverControlPanel = new ADKFormPanel("driverCtrlPanel");
		// driverControlPanel.setLabelWidth(50);

		ADKHorizontalPanel row1Panel = new ADKHorizontalPanel("row1Panel");
		row1Panel.setSpacing(5);

		ADKTextField educationType = new ADKTextField(DriverEducationModelDto.EDUCATION_TYPE, "Education Type", 150, 100, true);
		row1Panel.add(educationType);

		ADKTextField yearofPassing = new ADKTextField(DriverEducationModelDto.YEAR_OF_PASSING, "Year of Passing", 150, 100, true);
		row1Panel.add(yearofPassing);

		driverControlPanel.add(row1Panel);

		ADKHorizontalPanel row2Panel = new ADKHorizontalPanel("row2Panel");
		row2Panel.setSpacing(5);

		ADKTextField university = new ADKTextField(DriverEducationModelDto.UNIVERSITY, "University", 150, 100, false);
		row2Panel.add(university);

		ADKTextField school_college = new ADKTextField(DriverEducationModelDto.SCHOOL_OR_COLLEGE, "School/College", 150, 100, false);
		row2Panel.add(school_college);

		driverControlPanel.add(row2Panel);

		ADKHorizontalPanel row3Panel = new ADKHorizontalPanel("row3Panel");
		row3Panel.setSpacing(5);

		ADKTextField remarks = new ADKTextField(DriverEducationModelDto.REMARKS, "Remarks", 250, 100, false);
		row3Panel.add(remarks);

		driverControlPanel.add(row3Panel);

		RowNumberer numberer = new RowNumberer();

		List<DriverEducationModelDto> driverEducationList = new ArrayList<DriverEducationModelDto>();
		adkFormBinding =
				new ADKFormBinding<DriverEducationModelDto>("driverEducationAdkFormBinding", "Driver Education", 560, -1, 150,
						driverEducationList, getDriverEducationGridColumns(numberer), driverControlPanel, false);

		adkFormBinding.getButtonUpdate().removeAllListeners();
		adkFormBinding.getButtonUpdate().addSelectionListener(new DriverEducationUpdateListener());
		adkFormBinding.getButtonUpdate().setToolTip("Update");

		adkFormBinding.setAddListener(new SelectionListener<IconButtonEvent>() {

			@Override
			public void componentSelected(IconButtonEvent ce) {
				addDriverEducation();
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

	private ADKColumnList getDriverEducationGridColumns(RowNumberer numberer) {
		ADKColumnList<ColumnConfig> columns = new ADKColumnList<ColumnConfig>();
		columns.add(numberer);

		ADKColumnConfig column = new ADKColumnConfig(DriverEducationModelDto.EDUCATION_TYPE, "Education Type", 120, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEducationModelDto.YEAR_OF_PASSING, "Year of Passing", 150, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEducationModelDto.UNIVERSITY, "University", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEducationModelDto.SCHOOL_OR_COLLEGE, "School/College", 130, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverEducationModelDto.REMARKS, "Remarks", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		return columns;
	}

	private void addDriverEducation() {
		if (!driverControlPanel.isValid()) {
			return;
		}

		DriverEducationModelDto driverEducationModelDto = new DriverEducationModelDto();
		ModelData m = adkFormBinding.getCurrentFormModelData();
		driverEducationModelDto.setProperties(m.getProperties());
		driverEducationModelDto.setDriverId(mediator.getGlobalDriverClientDto().getDriverId());
		// setDisplayValues(actionsStepsModelDto);

		// if (!validateStepSprintDates()) {
		// return;
		// }

		adkFormBinding.addGridItem(driverEducationModelDto, true);
		// refreshViewActionStepGrid(false);
	}

	public ADKFormBinding<DriverEducationModelDto> getAdkFormBinding() {
		return adkFormBinding;
	}

	public void resetEducationsFormBinding() {
		adkFormBinding.clearFormData();
		adkFormBinding.cleanAllDatas();
	}

	public DriverEducationModelDto getSelectedDriverEducation() {
		DriverEducationModelDto driverEducationModelDto = adkFormBinding.getGrid().getSelectionModel().getSelectedItem();
		return driverEducationModelDto;
	}

	class DriverEducationUpdateListener extends SelectionListener<IconButtonEvent> {

		@Override
		public void componentSelected(IconButtonEvent ce) {
			if (!driverControlPanel.isValid()) {
				return;
			}

			DriverEducationModelDto driverEducationModelDto = getSelectedDriverEducation();
			Map<String, Object> oldProperties = driverEducationModelDto.getProperties();

			driverEducationModelDto.setProperties(adkFormBinding.getCurrentFormModelData().getProperties());

			// if (!validateStepSprintDates()) {
			// driverEducationModelDto.setProperties(oldProperties);
			// return;
			// }

			adkFormBinding.updateM();
		}
	}
}