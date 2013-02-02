package com.company.application.carrental.client.service.callback;

import java.util.List;

import com.company.application.carrental.client.CarRentalEvents;
import com.company.application.carrental.client.model.vo.HelpListOutputModelDto;
import com.company.application.carrental.client.view.mediators.CustomHelpListMediator;
import com.company.gui.adkwidgets.client.ApplicationFacade;
import com.company.gui.adkwidgets.client.ui.util.callback.ADKAsyncHandler;
import com.google.gwt.core.client.GWT;

public class HelpListAsyncHandler extends ADKAsyncHandler {

	private CustomHelpListMediator mediator;

	public HelpListAsyncHandler(CustomHelpListMediator mediator) {
		super();
		this.mediator = mediator;
	}

	/**
	 * @param caught : error
	 */
	@Override
	public void handleFailure(Throwable caught) {
		GWT.log("FAIL HelpListAsyncHandler : " + caught.getMessage(), caught);
		ApplicationFacade.getInst().sendNotification(CarRentalEvents.ERROR, caught.getMessage(), null);
	}

	/**
	 * @param result : result of the service
	 */
	@Override
	public void handleSuccess(Object result) {
		if (result != null) {
			GWT.log("Generic Custom results retrieved");
			// ApplicationFacade.getInst().sendNotification(KondorApplicationEvents.GET_CUSTOM_GENERIC_RESULT_SUCCESS, result, null);
			mediator.getCustomGenericResultSuccessAction((List<HelpListOutputModelDto>) result);
		}
	}
}