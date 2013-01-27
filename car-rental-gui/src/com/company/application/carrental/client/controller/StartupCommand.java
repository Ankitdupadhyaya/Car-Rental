package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.patterns.command.MacroCommand;

public class StartupCommand extends MacroCommand {

	protected void initializeMacroCommand() {
		super.initializeMacroCommand();

		addSubCommand(CarRentalModelCommand.class);
		addSubCommand(CarRentalViewCommand.class);
	}
}