package com.company.application.carrental.client.view.mediators;

import static com.company.application.carrental.client.util.MessageResourceFactory.carRentalErrorMessages;
import static com.company.application.carrental.client.util.MessageResourceFactory.carRentalLabels;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.mediator.Mediator;
import org.puremvc4gwt.client.patterns.observer.Notification;

import com.company.application.carrental.client.CarRentalApplication;
import com.company.application.carrental.client.CarRentalEvents;
import com.company.application.carrental.client.CarRentalFacade;
import com.company.application.carrental.client.ui.DisplayComponent;
import com.company.application.carrental.client.view.screens.MainScreen;
import com.company.gui.adkwidgets.client.ui.panel.ADKPanel;
import com.extjs.gxt.ui.client.widget.Composite;

public class MainScreenMediator extends Mediator {

	public static final String NAME = "MainScreenMediator";

	private MainScreen mainScreen;

	public MainScreenMediator() {
		super(NAME, null);
	}

	private MainScreen getMainScreen() {
		if (mainScreen == null) {
			mainScreen = new MainScreen(this);
		}

		return mainScreen;
	}

	public void exit() {
		CarRentalApplication.closeApplication();
	}

	@Override
	public String[] listNotificationInterests() {
		return new String[] { CarRentalEvents.DISPLAY_MAIN_SCREEN, CarRentalEvents.LOAD_MASTER_DATA_SUCCESSFUL,
				CarRentalEvents.LOAD_MASTER_DATA_FAILED, CarRentalEvents.DISPLAY };
	}

	@Override
	public void handleNotification(INotification note) {
		super.handleNotification(note);

		if (CarRentalEvents.DISPLAY_MAIN_SCREEN.equals(note.getName())) {
			getMainScreen();
			loadMasterData();

		} else if (CarRentalEvents.LOAD_MASTER_DATA_SUCCESSFUL.equals(note.getName())) {
			closeMessageBox();

		} else if (CarRentalEvents.LOAD_MASTER_DATA_FAILED.equals(note.getName())) {
			closeMessageBox();
			showErrorBox(carRentalErrorMessages.LOAD_CONFIG_ERROR());

		} else if (CarRentalEvents.DISPLAY.equals(note.getName())) {
			DisplayComponent displayComponent = (DisplayComponent) note.getBody();
			display(displayComponent);
		}
	}

	public void loadMasterData() {
		sendNotification(CarRentalEvents.LOAD_MASTER_DATA, null);
		showProgressBar(carRentalLabels.MESSAGE_INITIALIZING());
	}

	public void display(DisplayComponent displayComponent) {
		switch (displayComponent.getComponentDirection()) {
		case NORTH :
			break;

		case EAST :
			break;

		case SOUTH :
			break;

		case WEST :
			loadWestPanel(displayComponent.getComposite());
			break;

		case CENTER :
			loadCenterPanel(displayComponent.getComposite());
			break;
		}
	}

	public void loadWestPanel(Composite composite) {
		ADKPanel westPanel = CarRentalFacade.getApplication().getMainPanel().getWestPanel();
		westPanel.clear();
		westPanel.add(composite);
		westPanel.expand();
		// westPanel.layout();
		westPanel.show();
	}

	public void loadCenterPanel(Composite composite) {
		ADKPanel centerPanel = CarRentalFacade.getApplication().getMainPanel().getCenterPanel();
		centerPanel.clear();
		centerPanel.add(composite);
		centerPanel.layout();
	}

	public void sendNotification(String notificationName, Object notificationBody) {
		facade.notifyObservers(new Notification(notificationName, notificationBody, null));
	}

	private void showProgressBar(String message) {
		CarRentalApplication.showProgressBar(message);
	}

	private void closeMessageBox() {
		CarRentalApplication.closeProgressBar();
	}

	private void showErrorBox(String message) {
		CarRentalApplication.showErrorMessage(message);
	}
}