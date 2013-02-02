package com.company.application.carrental.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;

public class CarRental implements EntryPoint {

	private static final String APPLICATION_TITLE = "WMI Web Reporting";
	private static final String APPLICATION_NAME = "WMIWebReporting";

	private static final String APPLICATION_CODIFIER = "WMIWREP";
	private static final String APPLICATION_CODIFIER_YES = "Y";

	public static final String APPLICATION_CODIFIER_WMIWLM = "WMIWLM";
	public static final String APPLICATION_CODE_ALL = "ALL";

	private static final List<String> LIST_APPLICATION_CODES = new ArrayList<String>();
	static {
		LIST_APPLICATION_CODES.add(APPLICATION_CODIFIER_YES);
	};

	private static CarRentalApplication application = new CarRentalApplication(APPLICATION_TITLE, APPLICATION_CODIFIER, LIST_APPLICATION_CODES,
			APPLICATION_NAME);

	/**
	 * Private constructor not to be called
	 */
	private CarRental() {

	}

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
	}

	/**
	 * @return TelAvivCBLReportApplication
	 */
	public static CarRentalApplication getApplication() {
		return application;
	}
}