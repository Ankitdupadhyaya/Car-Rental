package com.company.application.carrental.client.view.screens;

import com.company.application.carrental.client.CarRentalFacade;
import com.company.application.carrental.client.view.mediators.DriverScreenMediator;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;

public class CarRentalTabPanel extends TabPanel {

	private static final String ADMIN_TAB = "Admin";
	private static final String REQUEST_TAB = "Request";
	private static final String APPLICATION_TAB = "Application";
	private static final String DRIVER_TAB = "Driver";

	public CarRentalTabPanel() {
		buildTabs();
	}

	private void buildTabs() {

		// addTab(DRIVER_TAB);
		add(new DriverScreen((DriverScreenMediator) CarRentalFacade.getInstance().retrieveMediator(DriverScreenMediator.NAME)), new TabItemConfig(
				DRIVER_TAB));

		// addTab(APPLICATION_TAB);
		// addTab(REQUEST_TAB);
		// addTab(ADMIN_TAB);

		addSelectionHandler(handler);
	}

	private void addTab(String tabLabel) {
		Label item = new Label(tabLabel);
		add(item, new TabItemConfig(tabLabel));
	}

	SelectionHandler<Widget> handler = new SelectionHandler<Widget>() {

		public void onSelection(SelectionEvent<Widget> event) {
			TabPanel panel = (TabPanel) event.getSource();
			Widget w = event.getSelectedItem();
			TabItemConfig config = panel.getConfig(w);

			if (DRIVER_TAB.equalsIgnoreCase(config.getText())) {
				// CarRentalFacade.getInstance().sendNotification(CarRentalEvents.DISPLAY_DRIVER_SCREEN, null, null);
			}
		}
	};
}