package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.view.mediators.DriverScreenMediator;
import com.company.application.carrental.client.view.mediators.MainScreenMediator;

public class CarRentalViewCommand extends SimpleCommand {

	@Override
	public void execute(INotification notification) {
		super.execute(notification);

		this.facade.registerMediator(new MainScreenMediator());
		this.facade.registerMediator(new DriverScreenMediator());
	}
}