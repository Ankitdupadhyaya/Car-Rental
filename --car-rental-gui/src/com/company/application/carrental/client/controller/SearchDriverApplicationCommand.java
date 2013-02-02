package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.model.vo.SearchDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SearchDriverInput;
import com.company.application.carrental.client.service.callback.SearchDriverApplicationAsyncHandler;
import com.company.application.carrental.client.service.proxy.CarRentalServiceProxy;

public class SearchDriverApplicationCommand extends SimpleCommand {

	public void execute(INotification notification) {
		SearchDriverApplicationInput input = (SearchDriverApplicationInput) notification.getBody();

		CarRentalServiceProxy.getInstance().searchDriverApplication(input, new SearchDriverApplicationAsyncHandler());
	}
}