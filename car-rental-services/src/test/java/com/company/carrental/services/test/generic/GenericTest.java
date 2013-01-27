package com.company.carrental.services.test.generic;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.company.carrental.services.api.service.ServiceAccessWSProxy;
import com.company.carrental.services.api.service.generic.CarRentalServiceFactory;
import com.company.carrental.services.car_rental_services.DriverServiceTest;


public class GenericTest extends TestCase {

	private static ServiceAccessWSProxy proxy;

	public GenericTest() {
		super();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		proxy = ServiceAccessWSProxy.getInstance(CarRentalServiceFactory.PERSISTENCE_CONTEXT_PATH);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		proxy = null;
	}

	/**
	 * @return the proxy
	 */
	public static ServiceAccessWSProxy getServiceAccessProxy() {
		return proxy;
	}

	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(DriverServiceTest.class);

		return testSuite;
	}
}