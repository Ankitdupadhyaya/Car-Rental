package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverEducation;
import com.company.application.carrental.client.model.vo.properties.DriverEducationProperties;
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
public class DriverEducationControl implements IsWidget, Editor<DriverEducationCollection> {

	private ToolBar toolBar;

	interface DriverEducationCollectionDriver extends SimpleBeanEditorDriver<DriverEducationCollection, DriverEducationControl> {
	}

	interface DriverEducationDriver extends SimpleBeanEditorDriver<DriverEducation, DriverEducationEditor> {
	}

	private DriverEducationCollectionDriver driverEducationCollectionDriver = GWT.create(DriverEducationCollectionDriver.class);
	private DriverEducationDriver driverEducationDriver = GWT.create(DriverEducationDriver.class);

	private Portlet panel;
	private Grid<DriverEducation> driverEducationGrid;
	private DriverEducationEditor driverEducationEditor;

	public Widget asWidget() {
		if (panel == null) {
			panel = new Portlet();
			panel.setHeadingText("Education");
			panel.setPixelSize(500, 350);
			panel.setBodyBorder(false);

			panel.addStyleName("margin-10");

			VerticalLayoutContainer container = new VerticalLayoutContainer();

			final DriverEducationProperties props = GWT.create(DriverEducationProperties.class);

			List<ColumnConfig<DriverEducation, ?>> columns = new ArrayList<ColumnConfig<DriverEducation, ?>>();
			columns.add(new ColumnConfig<DriverEducation, String>(props.educationType(), 100, "Education Type"));
			columns.add(new ColumnConfig<DriverEducation, String>(props.yearofPassing(), 90, "Year of Passing"));
			columns.add(new ColumnConfig<DriverEducation, String>(props.university(), 80, "University"));
			columns.add(new ColumnConfig<DriverEducation, String>(props.school_college(), 80, "School/College"));
			columns.add(new ColumnConfig<DriverEducation, String>(props.university(), 100, "Remarks"));

			driverEducationGrid =
					new Grid<DriverEducation>(new ListStore<DriverEducation>(props.key()), new ColumnModel<DriverEducation>(columns));
			driverEducationGrid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			driverEducationGrid.setBorders(true);

			driverEducationGrid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<DriverEducation>() {

				public void onSelectionChanged(SelectionChangedEvent<DriverEducation> event) {
					if (event.getSelection().size() > 0) {
						edit(event.getSelection().get(0));
					} else {
						driverEducationEditor.setSaveEnabled(false);
					}
				}
			});

			driverEducationEditor = new DriverEducationEditor();

			driverEducationEditor.getSaveButton().addSelectHandler(new SelectHandler() {

				public void onSelect(SelectEvent event) {
					saveCurrentStock();

				}
			});
			container.add(driverEducationEditor, new VerticalLayoutData(1, .45, new Margins(5)));
			toolBar = new GridToolbar<DriverEducation>(driverEducationGrid);
			container.add(toolBar, new VerticalLayoutData(1, .1));
			container.add(driverEducationGrid, new VerticalLayoutData(1, .45));

			panel.add(container);

			driverEducationDriver.initialize(driverEducationEditor);
			driverEducationCollectionDriver.initialize(this);
		}

		driverEducationCollectionDriver.edit(new DriverEducationCollection());
		return panel;
	}

	protected void edit(DriverEducation stock) {
		driverEducationDriver.edit(stock);
		driverEducationEditor.setSaveEnabled(true);
	}

	protected void saveCurrentStock() {
		DriverEducation edited = driverEducationDriver.flush();
		if (!driverEducationDriver.hasErrors()) {
			driverEducationEditor.setSaveEnabled(false);

			driverEducationGrid.getStore().update(edited);
		}
	}
}

class DriverEducationCollection {

	private List<DriverEducation> driverEducations = new ArrayList<DriverEducation>();

	public List<DriverEducation> getDriverEducations() {
		return driverEducations;
	}

	public void setDriverEducations(List<DriverEducation> driverEducations) {
		this.driverEducations = driverEducations;
	}
}