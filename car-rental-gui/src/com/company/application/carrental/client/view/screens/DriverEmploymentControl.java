package com.company.application.carrental.client.view.screens;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverEducation;
import com.company.application.carrental.client.model.vo.DriverEmploymentModelDto;
import com.company.application.carrental.client.model.vo.properties.DriverEmploymentProperties;
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
public class DriverEmploymentControl implements IsWidget, Editor<DriverEmploymentCollection> {

	private ToolBar toolBar;

	interface DriverEmploymentCollectionDriver extends SimpleBeanEditorDriver<DriverEmploymentCollection, DriverEmploymentControl> {
	}

	interface DriverEmploymentDriver extends SimpleBeanEditorDriver<DriverEmploymentModelDto, DriverEmploymentEditor> {
	}

	private DriverEmploymentCollectionDriver driverEmploymentCollectionDriver = GWT.create(DriverEmploymentCollectionDriver.class);
	private DriverEmploymentDriver driverEmploymentDriver = GWT.create(DriverEmploymentDriver.class);

	private Portlet panel;
	private Grid<DriverEmploymentModelDto> driverEmploymentGrid;
	private DriverEmploymentEditor driverEmploymentEditor;

	public Widget asWidget() {
		if (panel == null) {
			panel = new Portlet();
			panel.setHeadingText("Employment");
			panel.setPixelSize(900, 700);
			panel.setBodyBorder(false);

			panel.addStyleName("margin-10");

			VerticalLayoutContainer container = new VerticalLayoutContainer();

			final DriverEmploymentProperties props = GWT.create(DriverEmploymentProperties.class);

			List<ColumnConfig<DriverEmploymentModelDto, ?>> columns = new ArrayList<ColumnConfig<DriverEmploymentModelDto, ?>>();
			columns.add(new ColumnConfig<DriverEmploymentModelDto, String>(props.employmentType(), 100, "Employment Type"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, Date>(props.beginDate(), 60, "Begin Date"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, Date>(props.endDate(), 50, "End Date"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, String>(props.employerName(), 80, "Employer Name"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, String>(props.companyName(), 100, "Company Name"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, String>(props.employerAddress(), 100, "Employer Address"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, String>(props.employerContactNo(), 100, "Employer Contact"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, String>(props.reasonForLeaving(), 110, "Reason For Leaving"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, Double>(props.salary(), 70, "Salary"));
			columns.add(new ColumnConfig<DriverEmploymentModelDto, Character>(props.referenceAllowed(), 100, "Reference Allowed"));

			driverEmploymentGrid =
					new Grid<DriverEmploymentModelDto>(new ListStore<DriverEmploymentModelDto>(props.key()), new ColumnModel<DriverEmploymentModelDto>(columns));
			driverEmploymentGrid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			driverEmploymentGrid.setBorders(true);

			driverEmploymentGrid.getSelectionModel().addSelectionChangedHandler(new SelectionChangedHandler<DriverEmploymentModelDto>() {

				public void onSelectionChanged(SelectionChangedEvent<DriverEmploymentModelDto> event) {
					if (event.getSelection().size() > 0) {
						edit(event.getSelection().get(0));
					} else {
						driverEmploymentEditor.setSaveEnabled(false);
					}
				}
			});

			driverEmploymentEditor = new DriverEmploymentEditor();

			driverEmploymentEditor.getSaveButton().addSelectHandler(new SelectHandler() {

				public void onSelect(SelectEvent event) {
					saveCurrentStock();

				}
			});
			container.add(driverEmploymentEditor, new VerticalLayoutData(1, .45, new Margins(5)));
			toolBar = new GridToolbar<DriverEducation>(driverEmploymentGrid);
			container.add(toolBar, new VerticalLayoutData(1, .05));
			container.add(driverEmploymentGrid, new VerticalLayoutData(1, .5));

			panel.add(container);

			driverEmploymentDriver.initialize(driverEmploymentEditor);
			driverEmploymentCollectionDriver.initialize(this);
		}

		driverEmploymentCollectionDriver.edit(new DriverEmploymentCollection());
		return panel;
	}

	protected void edit(DriverEmploymentModelDto stock) {
		driverEmploymentDriver.edit(stock);
		driverEmploymentEditor.setSaveEnabled(true);
	}

	protected void saveCurrentStock() {
		DriverEmploymentModelDto edited = driverEmploymentDriver.flush();
		if (!driverEmploymentDriver.hasErrors()) {
			driverEmploymentEditor.setSaveEnabled(false);

			driverEmploymentGrid.getStore().update(edited);
		}
	}
}

class DriverEmploymentCollection {

	private List<DriverEmploymentModelDto> driverEmployments = new ArrayList<DriverEmploymentModelDto>();

	public List<DriverEmploymentModelDto> getDriverEmployments() {
		return driverEmployments;
	}

	public void setDriverEmployments(List<DriverEmploymentModelDto> driverEmployments) {
		this.driverEmployments = driverEmployments;
	}
}