package com.company.application.carrental.client.service.callback;

import com.company.application.carrental.client.CarRentalEvents;
import com.company.application.carrental.client.CarRentalFacade;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SearchDriverApplicationAsyncHandler implements AsyncCallback {

	public SearchDriverApplicationAsyncHandler() {
		super();
	}

	public void onFailure(Throwable caught) {
		GWT.log("FAIL SearchDriverAsyncHandler : " + caught.getMessage(), caught);
		sendNotification(CarRentalEvents.SEARCH_DRIVER_APPLICATION_FAILED, caught.getMessage(), null);
	}

	public void onSuccess(Object result) {
		if (result != null) {
			sendNotification(CarRentalEvents.SEARCH_DRIVER_APPLICATION_SUCCESSFUL, result, null);

		} else {
			sendNotification(CarRentalEvents.SEARCH_DRIVER_APPLICATION_FAILED, null, null);
		}
	}

	private void sendNotification(String notificationName, Object notificationBody, String notificationType) {
		CarRentalFacade.getInstance().sendNotification(notificationName, notificationBody, notificationType);
	}
}