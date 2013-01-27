package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverAddress;
import com.company.application.carrental.client.model.vo.properties.DriverAddressProperties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.Portlet;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent.SelectionChangedHandler;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

/**
 * Demonstrates using the ListStoreEditor, and some concept of building multiple editors. Note that as currently written, when a Stock object is
 * saved, it will modify the StockExchange's instances, instead of cloning models before editing them.
 */
public class DriverAddressControl implements IsWidget, Editor<DriverAddressCollection> {

	private ToolBar toolBar;

	interface DriverAddressCollectionDriver extends SimpleBeanEditorDriver<DriverAddressCollection, DriverAddressControl> {
	}

	interface DriverAddressDriver extends SimpleBeanEditorDriver<DriverAddress, DriverAddressEditor> {
	}

	private DriverAddressCollectionDriver driverAddressCollectionDriver = GWT.create(DriverAddressCollectionDriver.class);
	private DriverAddressDriver driverAddressDriver = GWT.create(DriverAddressDriver.class);

	private Portlet panel;
	private Grid<DriverAddress> driverAddressGrid;
	private DriverAddressEditor driverAddressEditor;

	public Widget asWidget() {
		if (panel == null) {
			panel = new Portlet();
			panel.setHeadingText("Address");
			panel.setPixelSize(450, 300);
			panel.setBodyBorder(false);

			panel.addStyleName("margin-10");

			VerticalLayoutContainer container = new VerticalLayoutContainer();

			final DriverAddressProperties props = GWT.create(DriverAddressProperties.class);

			List<ColumnConfig<DriverAddress, ?>> columns = new ArrayList<ColumnConfig<DriverAddress, ?>>();
			columns.add(new ColumnConfig<DriverAddress, String>(props.addressType(), 100, "Address Type"));
			columns.add(new ColumnConfig<DriverAddress, String>(props.address(), 250, "Address"));
			columns.add(new ColumnConfig<DriverAddress, String>(props.landmark(), 80, "Landmark"));

			driverAddressGrid = new Grid<DriverAddress>(new ListStore<DriverAddress>(props.key()), new ColumnModel<DriverAddress>(columns));
			driverAddressGrid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			driverAddressGrid.setBorders(true);

			List<DriverAddress> driverAddressList = new ArrayList<DriverAddress>();
			driverAddressGrid.getStore().add(new DriverAddress(1, "1", "1", "1"));
			driverAddressGrid.getStore().add(new DriverAddress(2, "21", "22", "23"));

			driverAddressGrid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<DriverAddress>() {

				public void onSelectionChanged(SelectionChangedEvent<DriverAddress> event) {
					if (event.getSelection().size() > 0) {
						edit(event.getSelection().get(0));
					} else {
						driverAddressEditor.setSaveEnabled(false);
					}
				}
			});

			driverAddressEditor = new DriverAddressEditor();

			driverAddressEditor.getSaveButton().addSelectHandler(new SelectHandler() {

				public void onSelect(SelectEvent event) {
					saveCurrentStock();

				}
			});
			container.add(driverAddressEditor, new VerticalLayoutData(1, .35, new Margins(5)));
			toolBar = new GridToolbar<DriverAddress>(driverAddressGrid);
			container.add(toolBar, new VerticalLayoutData(1, .15));
			container.add(driverAddressGrid, new VerticalLayoutData(1, .5));
			panel.add(container);

			driverAddressDriver.initialize(driverAddressEditor);
			driverAddressCollectionDriver.initialize(this);
		}

		driverAddressCollectionDriver.edit(new DriverAddressCollection());
		return panel;
	}

	protected void edit(DriverAddress stock) {
		driverAddressDriver.edit(stock);
		driverAddressEditor.setSaveEnabled(true);
	}

	protected void saveCurrentStock() {
		DriverAddress edited = driverAddressDriver.flush();
		if (!driverAddressDriver.hasErrors()) {
			driverAddressEditor.setSaveEnabled(false);

			driverAddressGrid.getStore().update(edited);
		}
	}
}

class DriverAddressCollection {

	private List<DriverAddress> driverAddresss = new ArrayList<DriverAddress>();

	public List<DriverAddress> getDriverAddresss() {
		return driverAddresss;
	}

	public void setDriverAddresss(List<DriverAddress> driverAddresss) {
		this.driverAddresss = driverAddresss;
	}
}