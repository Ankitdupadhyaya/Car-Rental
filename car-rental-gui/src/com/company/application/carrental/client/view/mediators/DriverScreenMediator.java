package com.company.application.carrental.client.view.mediators;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.mediator.Mediator;

import com.company.application.carrental.client.CarRentalEvents;
import com.company.application.carrental.client.CarRentalFacade;
import com.company.application.carrental.client.model.vo.DriverMasterClientDto;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckInput;
import com.company.application.carrental.client.model.vo.SearchDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SearchDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SearchDriverBackgroundCheckInput;
import com.company.application.carrental.client.model.vo.SearchDriverBackgroundCheckOutput;
import com.company.application.carrental.client.ui.DisplayComponentDirection;
import com.company.application.carrental.client.view.screens.DriverScreen;
import com.extjs.gxt.ui.client.widget.Info;

public class DriverScreenMediator extends Mediator {

	public static final String NAME = "DriverScreenMediator";

	private DriverScreen driverScreen;
	private DriverMasterClientDto globalDriverClientDto;

	public DriverScreenMediator() {
		super(NAME, null);
	}

	private DriverScreen getDriverScreen() {
		if (driverScreen == null) {
			driverScreen = new DriverScreen(this);
		}

		return driverScreen;
	}

	@Override
	public String[] listNotificationInterests() {
		return new String[] { CarRentalEvents.DISPLAY_DRIVER_SCREEN, CarRentalEvents.LOAD_MASTER_DATA_SUCCESSFUL,
				CarRentalEvents.LOAD_MASTER_DATA_FAILED, CarRentalEvents.DISPLAY, CarRentalEvents.SAVE_DRIVER_APPLICATION_SUCCESSFUL,
				CarRentalEvents.SAVE_DRIVER_APPLICATION_FAILED, CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK_SUCCESSFUL,
				CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK_FAILED, CarRentalEvents.SEARCH_DRIVER_APPLICATION_SUCCESSFUL,
				CarRentalEvents.SEARCH_DRIVER_APPLICATION_FAILED, CarRentalEvents.SEARCH_DRIVER_BACKGROUND_SUCCESSFUL,
				CarRentalEvents.SEARCH_DRIVER_BACKGROUND_FAILED };
	}

	@Override
	public void handleNotification(INotification note) {
		super.handleNotification(note);

		if (CarRentalEvents.DISPLAY_DRIVER_SCREEN.equals(note.getName())) {
			CarRentalFacade.getApplication().getMainPanel().getCenterPanel().add(getDriverScreen());

		} else if (CarRentalEvents.SAVE_DRIVER_APPLICATION_SUCCESSFUL.equals(note.getName())) {
			SaveDriverApplicationOutput output = (SaveDriverApplicationOutput) note.getBody();
			setGlobalDriverClientDto(output.getDriverMasterClientDto());
			getDriverScreen().populateApplicationFormData();
			Info.display("Save Driver", "Driver saved successfully");

		} else if (CarRentalEvents.SAVE_DRIVER_APPLICATION_FAILED.equals(note.getName())) {

		} else if (CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK_SUCCESSFUL.equals(note.getName())) {
			Info.display("Save Driver Background", "Driver details saved successfully");

		} else if (CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK_FAILED.equals(note.getName())) {

		} else if (CarRentalEvents.SEARCH_DRIVER_APPLICATION_SUCCESSFUL.equals(note.getName())) {
			SearchDriverApplicationOutput output = (SearchDriverApplicationOutput) note.getBody();
			setGlobalDriverClientDto(output.getDriverMasterClientDto());
			getDriverScreen().populateApplicationFormData();
			Info.display("Search Driver Application", "Driver found!");

			displayDriverScreen();

		} else if (CarRentalEvents.SEARCH_DRIVER_BACKGROUND_SUCCESSFUL.equals(note.getName())) {
			SearchDriverBackgroundCheckOutput output = (SearchDriverBackgroundCheckOutput) note.getBody();
			setGlobalDriverClientDto(new DriverMasterClientDto(output.getDriverId()));
			getDriverScreen().populateBackgroundCheckFormData(output);

			Info.display("Search Driver Background", "Driver found!");

			displayDriverScreen();
		}
	}

	private void displayDriverScreen() {
		CarRentalFacade.getApplication().displayScreen(getDriverScreen(), DisplayComponentDirection.CENTER);
	}

	public void saveDriverApplication(DriverMasterClientDto driverMasterClientDto) {
		SaveDriverApplicationInput input = new SaveDriverApplicationInput(driverMasterClientDto);
		sendNotification(CarRentalEvents.SAVE_DRIVER_APPLICATION, input, null);
	}

	public void searchDriverApplication(Integer driverId) {
		SearchDriverApplicationInput input = new SearchDriverApplicationInput(driverId);
		sendNotification(CarRentalEvents.SEARCH_DRIVER_APPLICATION, input, null);
	}

	public void searchDriverBackground(Integer driverId) {
		SearchDriverBackgroundCheckInput input = new SearchDriverBackgroundCheckInput(driverId);
		sendNotification(CarRentalEvents.SEARCH_DRIVER_BACKGROUND, input, null);
	}

	public void saveDriverBackgroundCheck(SaveDriverBackgroundCheckInput input) {
		sendNotification(CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK, input, null);
	}

	public DriverMasterClientDto getGlobalDriverClientDto() {
		return globalDriverClientDto;
	}

	public void setGlobalDriverClientDto(DriverMasterClientDto globalDriverClientDto) {
		this.globalDriverClientDto = globalDriverClientDto;
	}
}