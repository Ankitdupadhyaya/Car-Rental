package com.company.application.carrental.client.service.callback;

import java.util.List;

import com.company.application.carrental.client.CarRentalEvents;
import com.company.application.carrental.client.model.vo.GenericResultModelDto;
import com.company.application.carrental.client.view.mediators.CustomHelpListMediator;
import com.company.gui.adkwidgets.client.ApplicationFacade;
import com.company.gui.adkwidgets.client.ui.util.callback.ADKAsyncHandler;
import com.google.gwt.core.client.GWT;

public class CustomHelpListAsyncHandler extends ADKAsyncHandler {

	private CustomHelpListMediator mediator;

	public CustomHelpListAsyncHandler(CustomHelpListMediator mediator) {
		super();
		this.mediator = mediator;
	}

	/**
	 * @param caught : error
	 */
	@Override
	public void handleFailure(Throwable caught) {
		GWT.log("FAIL CustomHelpListAsyncHandler : " + caught.getMessage(), caught);
		ApplicationFacade.getInst().sendNotification(CarRentalEvents.ERROR, caught.getMessage(), null);
	}

	/**
	 * @param result : result of the service
	 */
	@Override
	public void handleSuccess(Object result) {
		if (result != null) {
			GWT.log("Generic Custom results retrieved");
			mediator.getGenericResultSuccessAction((List<GenericResultModelDto>) result);
		}
	}

}