package com.company.application.carrental.client.controller;

import java.util.List;

import org.puremvc4gwt.client.interfaces.ICommand;
import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.command.SimpleCommand;

import com.company.application.carrental.client.model.vo.HelpListInputDto;
import com.company.application.carrental.client.service.callback.HelpListAsyncHandler;
import com.company.application.carrental.client.service.proxy.CarRentalServiceProxy;
import com.company.application.carrental.client.view.mediators.CustomHelpListMediator;

public class GetCustomGenericResultCommand extends SimpleCommand implements ICommand {

	@SuppressWarnings("unchecked")
	public void execute(INotification notification) {
		Object[] args = (Object[]) notification.getBody();
		if (args != null) {
			HelpListInputDto helpListInputDto = new HelpListInputDto();
			helpListInputDto.setValue((String) args[0]);
			helpListInputDto.setMaxResult((Integer) args[1]);
			helpListInputDto.setDatabase((String) args[3]);
			helpListInputDto.setTableName((String) args[4]);
			helpListInputDto.setInputColumn((String) args[5]);
			helpListInputDto.setOutputColumns((List) args[6]);

			CarRentalServiceProxy.getInstance().getCustomGenericResult(helpListInputDto,
					new HelpListAsyncHandler((CustomHelpListMediator) args[2]));
		}
	}
}