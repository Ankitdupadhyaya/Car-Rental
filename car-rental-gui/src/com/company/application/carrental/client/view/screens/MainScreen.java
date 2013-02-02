package com.company.application.carrental.client.view.screens;

import com.company.application.carrental.client.CarRentalFacade;
import com.company.application.carrental.client.view.mediators.MainScreenMediator;
import com.company.gui.adkwidgets.client.ui.ADKApplication;
import com.company.gui.adkwidgets.client.ui.ADKMainPanel;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;

public class MainScreen {

	private MainScreenMediator mediator;
	private CarRentalTabPanel tabPanel;

	public MainScreen(MainScreenMediator mediator) {
		setMediator(mediator);

		ADKApplication app = CarRentalFacade.getApplication();

		ADKMainPanel mainPanel = app.getMainPanel();

		buildUI();

		// ADKPanel center = mainPanel.getCenterPanel();
		// center.clear();
	}

	private void buildUI() {
		tabPanel = new CarRentalTabPanel();

		BorderLayoutData westData = new BorderLayoutData();
		// westData.setSplit(true);
		westData.setCollapsible(true);
		westData.setMargins(new Margins(5));

		// CarRentalFacade.getApplication().getMainPanel().addWestPanel("");
		displayCenterPanel();
	}

	public void displayCenterPanel() {
		CarRentalFacade.getApplication().getMainPanel().getCenterPanel().clear();
		CarRentalFacade.getApplication().getMainPanel().getCenterPanel().add(tabPanel);
		CarRentalFacade.getApplication().getMainPanel().getCenterPanel().layout();
	}

	public MainScreenMediator getMediator() {
		return mediator;
	}

	private void setMediator(MainScreenMediator mediator) {
		this.mediator = mediator;
	}
}