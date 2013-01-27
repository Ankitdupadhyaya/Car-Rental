package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckInput;
import com.company.application.carrental.client.service.callback.SaveDriverBackgroundCheckAsyncHandler;
import com.company.application.carrental.client.service.proxy.CarRentalServiceProxy;

public class SaveDriverBackgroundCheckCommand extends SimpleCommand {

	public void execute(INotification notification) {
		SaveDriverBackgroundCheckInput input = (SaveDriverBackgroundCheckInput) notification.getBody();

		CarRentalServiceProxy.getInstance().saveDriverBackgroundCheck(input, new SaveDriverBackgroundCheckAsyncHandler());
	}
}