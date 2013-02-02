package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.ICommand;
import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.service.callback.CustomHelpListAsyncHandler;
import com.company.application.carrental.client.service.proxy.CarRentalServiceProxy;
import com.company.application.carrental.client.view.mediators.CustomHelpListMediator;

public class GetGenericResultCommand extends SimpleCommand implements ICommand {

	@SuppressWarnings("unchecked")
	public void execute(INotification notification) {
		Object[] args = (Object[]) notification.getBody();
		if (args != null) {
			String value = (String) args[0];
			int maxResult = (Integer) args[1];
			CustomHelpListMediator mediator = (CustomHelpListMediator) args[2];
			String database = (String) args[3];
			String tableName = (String) args[4];
			String prefixField = (String) args[5];
			CarRentalServiceProxy.getInstance().getGenericResult(database, tableName, prefixField, value, maxResult,
					new CustomHelpListAsyncHandler(mediator));
		}
	}
}