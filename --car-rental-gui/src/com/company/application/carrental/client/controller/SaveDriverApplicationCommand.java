package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.application.carrental.client.service.callback.SaveDriverApplicationAsyncHandler;
import com.company.application.carrental.client.service.proxy.CarRentalServiceProxy;

public class SaveDriverApplicationCommand extends SimpleCommand {

	public void execute(INotification notification) {
		SaveDriverApplicationInput input = (SaveDriverApplicationInput) notification.getBody();

		CarRentalServiceProxy.getInstance().saveDriverApplication(input, new SaveDriverApplicationAsyncHandler());
	}
}