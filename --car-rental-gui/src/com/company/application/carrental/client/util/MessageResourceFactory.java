package com.company.application.carrental.client.util;

import com.google.gwt.core.client.GWT;

public final class MessageResourceFactory {

	public static final CarRentalErrorMessages carRentalErrorMessages = (CarRentalErrorMessages) GWT
			.create(CarRentalErrorMessages.class);

	public static final CarRentalLabels carRentalLabels = (CarRentalLabels) GWT
			.create(CarRentalLabels.class);

	private MessageResourceFactory() {
	}
}