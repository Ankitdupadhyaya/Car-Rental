
package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.model.vo.SearchDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SearchDriverBackgroundCheckInput;
import com.company.application.carrental.client.model.vo.SearchDriverInput;
import com.company.application.carrental.client.service.callback.SearchDriverApplicationAsyncHandler;
import com.company.application.carrental.client.service.callback.SearchDriverBackgroundCheckAsyncHandler;
import com.company.application.carrental.client.service.proxy.CarRentalServiceProxy;

public class SearchDriverBackgroundCheckCommand extends SimpleCommand {

	public void execute(INotification notification) {
		SearchDriverBackgroundCheckInput input = (SearchDriverBackgroundCheckInput) notification.getBody();

		CarRentalServiceProxy.getInstance().searchDriverBackground(input, new SearchDriverBackgroundCheckAsyncHandler());
	}
}