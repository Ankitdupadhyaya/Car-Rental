package com.company.carrental.services.api.service.generic;

import com.company.carrental.services.api.service.DriverService;
import com.company.carrental.services.api.service.ServiceAccessWSProxy;


public class CarRentalServiceFactory {

	public static final String PERSISTENCE_CONTEXT_PATH = "./CarRentalPersistenceContext.xml";

	private static synchronized ServiceAccessWSProxy getProxy() {
		return ServiceAccessWSProxy.getInstance(PERSISTENCE_CONTEXT_PATH);
	}

	public static DriverService getDriverService() {
		return (DriverService) getProxy().getService("DriverService");
	}
	
}