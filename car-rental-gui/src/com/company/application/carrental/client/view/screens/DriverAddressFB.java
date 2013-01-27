package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.company.application.carrental.client.model.vo.DriverAddressModelDto;
import com.company.gui.adkwidgets.client.ui.field.ADKTextArea;
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

public class DriverAddressFB {

	private ADKFormBinding<DriverAddressModelDto> adkFormBinding;
	private ADKFormPanel driverControlPanel;

	public DriverAddressFB() {
		super();

		buildUI();
	}

	public void buildUI() {
		driverControlPanel = new ADKFormPanel("driverCtrlPanel");
		driverControlPanel.setLabelWidth(50);

		ADKHorizontalPanel row1Panel = new ADKHorizontalPanel("row1Panel");
		row1Panel.setSpacing(4);

		ADKTextField addressType = new ADKTextField(DriverAddressModelDto.ADDRESS_TYPE, "Address Type", 150, 100, true);
		row1Panel.add(addressType);

		driverControlPanel.add(row1Panel);

		ADKHorizontalPanel row2Panel = new ADKHorizontalPanel("row2Panel");
		row2Panel.setSpacing(0);

		ADKTextArea address = new ADKTextArea(DriverAddressModelDto.ADDRESS, "Address", true, 230, 35);
		address.setLabelWidth(100);
		row2Panel.add(address);

		driverControlPanel.add(row2Panel);

		ADKHorizontalPanel row3Panel = new ADKHorizontalPanel("row3Panel");
		row3Panel.setSpacing(3);

		ADKTextField landmark = new ADKTextField(DriverAddressModelDto.LANDMARK, "Landmark", 200, 100, true);
		row3Panel.add(landmark);

		driverControlPanel.add(row3Panel);

		RowNumberer numberer = new RowNumberer();

		List<DriverAddressModelDto> driverAddressList = new ArrayList<DriverAddressModelDto>();
		adkFormBinding =
				new ADKFormBinding<DriverAddressModelDto>("driverAddressAdkFormBinding", "Driver Address", 400, -1, 150, driverAddressList,
						getDriverAddressGridColumns(numberer), driverControlPanel, false);

		adkFormBinding.getButtonUpdate().removeAllListeners();
		adkFormBinding.getButtonUpdate().addSelectionListener(new DriverAddressUpdateListener());
		adkFormBinding.getButtonUpdate().setToolTip("Update");

		adkFormBinding.setAddListener(new SelectionListener<IconButtonEvent>() {

			@Override
			public void componentSelected(IconButtonEvent ce) {
				addDriverAddress();
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

	private ADKColumnList getDriverAddressGridColumns(RowNumberer numberer) {
		ADKColumnList<ColumnConfig> columns = new ADKColumnList<ColumnConfig>();
		columns.add(numberer);

		ADKColumnConfig column = new ADKColumnConfig(DriverAddressModelDto.ADDRESS_TYPE, "Address Type", 100, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverAddressModelDto.ADDRESS, "Address", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		column = new ADKColumnConfig(DriverAddressModelDto.LANDMARK, "Landmark", 110, ADKColumnConfig.TEXT);
		columns.add(column);

		return columns;
	}

	private void addDriverAddress() {
		if (!driverControlPanel.isValid()) {
			return;
		}

		DriverAddressModelDto driverAddressModelDto = new DriverAddressModelDto();
		ModelData m = adkFormBinding.getCurrentFormModelData();
		driverAddressModelDto.setProperties(m.getProperties());
		driverAddressModelDto.setDriverId(DriverScreen.getGlobalDriverClientDto().getDriverId());
		// setDisplayValues(actionsStepsModelDto);

		// if (!validateStepSprintDates()) {
		// return;
		// }

		adkFormBinding.addGridItem(driverAddressModelDto, true);
		// refreshViewActionStepGrid(false);
	}

	public ADKFormBinding<DriverAddressModelDto> getAdkFormBinding() {
		return adkFormBinding;
	}

	public ADKFormPanel getDriverControlPanel() {
		return driverControlPanel;
	}

	public DriverAddressModelDto getSelectedDriverAddress() {
		DriverAddressModelDto driverAddressModelDto = adkFormBinding.getGrid().getSelectionModel().getSelectedItem();
		return driverAddressModelDto;
	}

	class DriverAddressUpdateListener extends SelectionListener<IconButtonEvent> {

		@Override
		public void componentSelected(IconButtonEvent ce) {
			if (!driverControlPanel.isValid()) {
				return;
			}

			DriverAddressModelDto driverAddressModelDto = getSelectedDriverAddress();
			Map<String, Object> oldProperties = driverAddressModelDto.getProperties();

			driverAddressModelDto.setProperties(adkFormBinding.getCurrentFormModelData().getProperties());

			// if (!validateStepSprintDates()) {
			// driverAddressModelDto.setProperties(oldProperties);
			// return;
			// }

			adkFormBinding.updateM();
		}
	}
}