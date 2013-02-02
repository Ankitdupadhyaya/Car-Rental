package com.company.application.carrental.client;

import org.puremvc4gwt.client.patterns.observer.Notification;

import com.company.application.carrental.client.controller.CarRentalCommandProvider;
import com.company.application.carrental.client.controller.GetCustomGenericResultCommand;
import com.company.application.carrental.client.controller.GetGenericResultCommand;
import com.company.application.carrental.client.controller.LoadMasterDataCommand;
import com.company.application.carrental.client.controller.SaveDriverApplicationCommand;
import com.company.application.carrental.client.controller.SaveDriverBackgroundCheckCommand;
import com.company.application.carrental.client.controller.SearchDriverApplicationCommand;
import com.company.application.carrental.client.controller.SearchDriverBackgroundCheckCommand;
import com.company.application.carrental.client.controller.StartupCommand;
import com.company.gui.adkwidgets.client.ApplicationFacade;
import com.google.gwt.core.client.GWT;

public final class CarRentalFacade extends ApplicationFacade {

	private CarRentalFacade() {
	}

	// public static CarRentalApplication application;

	public static synchronized CarRentalFacade getInstance() {
		if (instance == null) {
			instance = new CarRentalFacade();
			instance.registerCommandProvider(new CarRentalCommandProvider());
		}

		return (CarRentalFacade) instance;
	}

	@Override
	protected void initializeController() {

		GWT.log("CarRentalFacade initializeController Entry");

		super.initializeController();
		registerCommand(CarRentalEvents.STARTUP, StartupCommand.class);
		registerCommand(CarRentalEvents.LOAD_MASTER_DATA, LoadMasterDataCommand.class);
		registerCommand(CarRentalEvents.SAVE_DRIVER_APPLICATION, SaveDriverApplicationCommand.class);
		registerCommand(CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK, SaveDriverBackgroundCheckCommand.class);
		registerCommand(CarRentalEvents.SEARCH_DRIVER_APPLICATION, SearchDriverApplicationCommand.class);
		registerCommand(CarRentalEvents.SEARCH_DRIVER_BACKGROUND, SearchDriverBackgroundCheckCommand.class);

		registerCommand(CarRentalEvents.GET_GENERIC_RESULT, GetGenericResultCommand.class);
		registerCommand(CarRentalEvents.GET_CUSTOM_GENERIC_RESULT, GetCustomGenericResultCommand.class);

	}

	public static CarRentalApplication getApplication() {
		return (CarRentalApplication) application;
	}

	public static void setApplication(CarRentalApplication application) {
		CarRentalFacade.application = application;
	}

	public void start(CarRentalApplication projectTracker) {
		setApplication(projectTracker);
		notifyObservers(new Notification(CarRentalEvents.STARTUP, application, null));
	}
}