package com.company.application.carrental.client.controller;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

public class LoadMasterDataCommand extends SimpleCommand {

	public void execute(INotification notification) {
		// WMIWebReportingServiceProxy.getInstance().getMasterData(new
		// LoadMasterDataAsyncHandler());
	}
}