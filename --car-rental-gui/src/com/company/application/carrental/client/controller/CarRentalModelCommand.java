package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.model.proxy.CurrenciesProxy;

public class CarRentalModelCommand extends SimpleCommand {

	@Override
	public void execute(INotification notification) {
		super.execute(notification);

		this.facade.registerProxy(new CurrenciesProxy());
	}
}