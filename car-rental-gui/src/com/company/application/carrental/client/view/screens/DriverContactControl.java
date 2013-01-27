package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverContact;
import com.company.application.carrental.client.model.vo.properties.DriverContactProperties;
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
public class DriverContactControl implements IsWidget, Editor<DriverContactCollection> {

	private ToolBar toolBar;

	interface DriverContactCollectionDriver extends SimpleBeanEditorDriver<DriverContactCollection, DriverContactControl> {
	}

	interface DriverContactDriver extends SimpleBeanEditorDriver<DriverContact, DriverContactEditor> {
	}

	private DriverContactCollectionDriver driverContactCollectionDriver = GWT.create(DriverContactCollectionDriver.class);
	private DriverContactDriver driverContactDriver = GWT.create(DriverContactDriver.class);

	private Portlet panel;
	private Grid<DriverContact> driverContactGrid;
	private DriverContactEditor driverContactEditor;

	public Widget asWidget() {
		if (panel == null) {
			panel = new Portlet();
			panel.setHeadingText("Contact");
			panel.setPixelSize(300, 300);
			panel.setBodyBorder(false);

			panel.addStyleName("margin-10");

			VerticalLayoutContainer container = new VerticalLayoutContainer();

			final DriverContactProperties props = GWT.create(DriverContactProperties.class);

			List<ColumnConfig<DriverContact, ?>> columns = new ArrayList<ColumnConfig<DriverContact, ?>>();
			columns.add(new ColumnConfig<DriverContact, String>(props.contactType(), 100, "Contact Type"));
			columns.add(new ColumnConfig<DriverContact, String>(props.contactNumber(), 100, "Contact Number"));
			columns.add(new ColumnConfig<DriverContact, Boolean>(props.isPrimary(), 80, "Primary"));

			driverContactGrid = new Grid<DriverContact>(new ListStore<DriverContact>(props.key()), new ColumnModel<DriverContact>(columns));
			driverContactGrid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			driverContactGrid.setBorders(true);

			// container.add(driverContactGrid, new VerticalLayoutData(1, .6));
			driverContactGrid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<DriverContact>() {

				public void onSelectionChanged(SelectionChangedEvent<DriverContact> event) {
					if (event.getSelection().size() > 0) {
						edit(event.getSelection().get(0));
					} else {
						driverContactEditor.setSaveEnabled(false);
					}
				}
			});

			driverContactEditor = new DriverContactEditor();

			driverContactEditor.getSaveButton().addSelectHandler(new SelectHandler() {

				public void onSelect(SelectEvent event) {
					saveCurrentStock();

				}
			});

			container.add(driverContactEditor, new VerticalLayoutData(1, .3, new Margins(5)));
			toolBar = new GridToolbar<DriverContact>(driverContactGrid);
			container.add(toolBar, new VerticalLayoutData(1, .15));
			container.add(driverContactGrid, new VerticalLayoutData(1, .55));
			panel.add(container);

			driverContactDriver.initialize(driverContactEditor);
			driverContactCollectionDriver.initialize(this);
		}

		driverContactCollectionDriver.edit(new DriverContactCollection());
		return panel;
	}

	protected void edit(DriverContact stock) {
		driverContactDriver.edit(stock);
		driverContactEditor.setSaveEnabled(true);
	}

	protected void saveCurrentStock() {
		DriverContact edited = driverContactDriver.flush();
		if (!driverContactDriver.hasErrors()) {
			driverContactEditor.setSaveEnabled(false);

			driverContactGrid.getStore().update(edited);
		}
	}
}

class DriverContactCollection {

	private List<DriverContact> driverContacts = new ArrayList<DriverContact>();

	public List<DriverContact> getDriverContacts() {
		return driverContacts;
	}

	public void setDriverContacts(List<DriverContact> driverContacts) {
		this.driverContacts = driverContacts;
	}
}