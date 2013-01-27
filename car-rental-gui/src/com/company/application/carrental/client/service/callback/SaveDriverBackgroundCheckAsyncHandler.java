package com.company.application.carrental.client.service.callback;

import com.company.application.carrental.client.CarRentalEvents;
import com.company.application.carrental.client.CarRentalFacade;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SaveDriverBackgroundCheckAsyncHandler implements AsyncCallback {

	public SaveDriverBackgroundCheckAsyncHandler() {
		super();
	}

	public void onFailure(Throwable caught) {
		GWT.log("FAIL SaveDriverBackgroundCheckAsyncHandler : " + caught.getMessage(), caught);
		sendNotification(CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK_FAILED, caught.getMessage(), null);
	}

	public void onSuccess(Object result) {
		if (result != null) {
			sendNotification(CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK_SUCCESSFUL, result, null);

		} else {
			sendNotification(CarRentalEvents.SAVE_DRIVER_BACKGROUND_CHECK_FAILED, null, null);
		}
	}

	private void sendNotification(String notificationName, Object notificationBody, String notificationType) {
		CarRentalFacade.getInstance().sendNotification(notificationName, notificationBody, notificationType);
	}
}