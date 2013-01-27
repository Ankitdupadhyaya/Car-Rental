package com.company.application.carrental.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.puremvc4gwt.client.interfaces.ICommand;
import org.puremvc4gwt.client.patterns.command.MacroCommand;

import com.company.application.carrental.client.CarRentalEvents;
import com.company.gui.adkwidgets.client.controller.MyCommandProvider;
import com.company.gui.adkwidgets.client.controller.PrepModelCommand;
import com.company.gui.adkwidgets.client.controller.PrepViewCommand;

public class CarRentalCommandProvider extends MyCommandProvider {

	public ICommand getCommand(String command) {
		ICommand commandToBeReturned = null;

		if (CarRentalEvents.STARTUP.equals(command)) {
			commandToBeReturned = new StartupCommand();

		} else if (CarRentalEvents.LOAD_MASTER_DATA.equals(command)) {
			commandToBeReturned = new LoadMasterDataCommand();

		} else if (CarRentalEvents.SAVE_DRIVER_APPLICATION.equals(command)) {
			commandToBeReturned = new SaveDriverApplicationCommand();

		} else if (CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK.equals(command)) {
			commandToBeReturned = new SaveDriverBackgroundCheckCommand();

		} else if (CarRentalEvents.SEARCH_DRIVER_APPLICATION.equals(command)) {
			commandToBeReturned = new SearchDriverApplicationCommand();

		} else if (CarRentalEvents.GET_GENERIC_RESULT.equals(command)) {
			commandToBeReturned = new GetGenericResultCommand();

		} else if (CarRentalEvents.GET_CUSTOM_GENERIC_RESULT.equals(command)) {
			commandToBeReturned = new GetCustomGenericResultCommand();
		}

		return commandToBeReturned;
	}

	public List<ICommand> getSubCommandList(Class<? extends MacroCommand> commandClass) {

		List<ICommand> subCommandList = new ArrayList<ICommand>();

		if (commandClass.getName().equals(StartupCommand.class.getName())) {
			subCommandList.add(new CarRentalModelCommand());
			subCommandList.add(new CarRentalViewCommand());
			subCommandList.add(new PrepViewCommand());
			subCommandList.add(new PrepModelCommand());

			// subCommandList.addAll(super.getSubCommandList(ApplicationStartUpCommand.class));
		}

		return subCommandList;
	}
}