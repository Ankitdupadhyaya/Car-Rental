package com.company.application.carrental.client.view.screens;

import java.util.List;

import com.sencha.gxt.widget.core.client.button.IconButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public class GridToolbar<M extends Object> extends ToolBar {

	private Grid grid;
	private IconButton buttonAdd;
	private IconButton buttonUpdate;
	private IconButton buttonClear;
	private IconButton buttonDelete;

	public GridToolbar(Grid grid) {
		super();

		this.grid = grid;
		setHorizontalSpacing(20);
		buttonsCreations();
	}

	private void buttonsCreations() {
		buttonAdd = new IconButton("icon-add");
		buttonAdd.setToolTip("Add the formulary's item to the grid");

		buttonUpdate = new IconButton("icon-table-edit");
		buttonUpdate.setToolTip("Update the current item selected");
		// buttonUpdate.hide();

		buttonUpdate.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				// updateM();
			}
		});

		buttonClear = new IconButton("icon-switch");
		buttonClear.setToolTip("Clear the formulary");
		buttonClear.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				grid.getSelectionModel().deselectAll();
				// clearFormData();
				buttonAdd.show();
				buttonUpdate.hide();
				grid.getView().refresh(false);
			}
		});

		buttonDelete = new IconButton("icon-delete");
		buttonDelete.setToolTip("Remove the selection");
		buttonDelete.addSelectHandler(new SelectHandler() {

			public void onSelect(SelectEvent event) {
				List<M> selectedItems = grid.getSelectionModel().getSelectedItems();
				for (M m : selectedItems) {
					// removeM(m);
				}
				grid.getView().refresh(false);
			}
		});

		add(buttonUpdate);
		// add(new SeparatorToolItem());
		add(buttonClear);
		// add(new SeparatorToolItem());
		// buttonAdd.setVisible(false);
		add(buttonAdd);
		// add(new SeparatorToolItem());
		add(buttonDelete);
	}
}