package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.company.application.carrental.client.model.vo.DriverContactModelDto;
import com.company.gui.adkwidgets.client.ui.choice.ADKCheckBoxField;
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
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.RowNumberer;

public class DriverContactFB {

	private ADKFormBinding<DriverContactModelDto> adkFormBinding;
	private ADKFormPanel driverControlPanel;

	public DriverContactFB() {
		super();

		buildUI();
	}

	public void buildUI() {
		driverControlPanel = new ADKFormPanel("driverCtrlPanel");
		driverControlPanel.setLabelWidth(50);

		ADKHorizontalPanel row1Panel = new ADKHorizontalPanel("row1Panel");
		row1Panel.setSpacing(5);

		ADKTextField contactType = new ADKTextField(DriverContactModelDto.CONTACT_TYPE, "Contact Type", 150, 100, true);
		row1Panel.add(contactType);

		driverControlPanel.add(row1Panel);

		ADKHorizontalPanel row2Panel = new ADKHorizontalPanel("row2Panel");
		row2Panel.setSpacing(5);

		ADKTextField contactNumber = new ADKTextField(DriverContactModelDto.CONTACT_NUMBER, "Contact Number", 150, 100, true);
		row2Panel.add(contactNumber);

		driverControlPanel.add(row2Panel);

		ADKHorizontalPanel row3Panel = new ADKHorizontalPanel("row3Panel");
		row3Panel.setSpacing(5);

		List<String> values = new ArrayList<String>();
		values.add("");

		ADKCheckBoxField isPrimary = new ADKCheckBoxField(DriverContactModelDto.IS_PRIMARY, "Is Primary", 150, 100);
		row3Panel.add(isPrimary);

		driverControlPanel.add(row3Panel);

		RowNumberer numberer = new RowNumberer();

		List<DriverContactModelDto> driverContactList = new ArrayList<DriverContactModelDto>();
		adkFormBinding =
				new ADKFormBinding<DriverContactModelDto>("driverContactAdkFormBinding", "Driver Contact", 300, -1, 150, driverContactList,
						getDriverContactGridColumns(numberer), driverControlPanel, false);

		adkFormBinding.getButtonUpdate().removeAllListeners();
		adkFormBinding.getButtonUpdate().addSelectionListener(new DriverContactUpdateListener());
		adkFormBinding.getButtonUpdate().setToolTip("Update");

		adkFormBinding.setAddListener(new SelectionListener<IconButtonEvent>() {

			@Override
			public void componentSelected(IconButtonEvent ce) {
				addDriverContact();
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

	private ADKColumnList getDriverContactGridColumns(RowNumberer numberer) {
		ADKColumnList<ColumnConfig> columns = new ADKColumnList<ColumnConfig>();
		columns.add(numberer);

		ADKColumnConfig column = new ADKColumnConfig(DriverContactModelDto.CONTACT_TYPE, "Contact Type", 100, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverContactModelDto.CONTACT_NUMBER, "Contact Number", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		CheckColumnConfig checkColumn = new CheckColumnConfig(DriverContactModelDto.IS_PRIMARY, "Primary", 80);
		columns.add(checkColumn);

		return columns;
	}

	private void addDriverContact() {
		if (!driverControlPanel.isValid()) {
			return;
		}

		DriverContactModelDto driverContactModelDto = new DriverContactModelDto();
		ModelData m = adkFormBinding.getCurrentFormModelData();
		driverContactModelDto.setProperties(m.getProperties());
		driverContactModelDto.setDriverId(DriverScreen.getGlobalDriverClientDto().getDriverId());
		// setDisplayValues(actionsStepsModelDto);

		// if (!validateStepSprintDates()) {
		// return;
		// }

		adkFormBinding.addGridItem(driverContactModelDto, true);
		// refreshViewActionStepGrid(false);
	}

	public ADKFormBinding<DriverContactModelDto> getAdkFormBinding() {
		return adkFormBinding;
	}

	public DriverContactModelDto getSelectedDriverContact() {
		DriverContactModelDto driverContactModelDto = adkFormBinding.getGrid().getSelectionModel().getSelectedItem();
		return driverContactModelDto;
	}

	class DriverContactUpdateListener extends SelectionListener<IconButtonEvent> {

		@Override
		public void componentSelected(IconButtonEvent ce) {
			if (!driverControlPanel.isValid()) {
				return;
			}

			DriverContactModelDto driverContactModelDto = getSelectedDriverContact();
			Map<String, Object> oldProperties = driverContactModelDto.getProperties();

			driverContactModelDto.setProperties(adkFormBinding.getCurrentFormModelData().getProperties());

			// if (!validateStepSprintDates()) {
			// driverContactModelDto.setProperties(oldProperties);
			// return;
			// }

			adkFormBinding.updateM();
		}
	}
}