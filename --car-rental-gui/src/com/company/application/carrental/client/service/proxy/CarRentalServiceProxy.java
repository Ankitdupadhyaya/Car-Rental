package com.company.application.carrental.client.service.proxy;

import java.util.List;

import com.company.application.carrental.client.model.vo.GenericResultModelDto;
import com.company.application.carrental.client.model.vo.HelpListInputDto;
import com.company.application.carrental.client.model.vo.HelpListOutputModelDto;
import com.company.application.carrental.client.model.vo.MasterDataVO;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckInput;
import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckOutput;
import com.company.application.carrental.client.model.vo.SearchDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SearchDriverApplicationOutput;
import com.company.application.carrental.client.service.interfaces.CarRentalService;
import com.company.application.carrental.client.service.interfaces.CarRentalServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public final class CarRentalServiceProxy {

	public static final String SERVICE_NAME = "car-rental-service";
	private static CarRentalServiceProxy instance;
	private CarRentalServiceAsync proxy;

	/**
	 * Proxy instantiation
	 */
	private CarRentalServiceProxy() {
		proxy = (CarRentalServiceAsync) GWT.create(CarRentalService.class);
		((ServiceDefTarget) proxy).setServiceEntryPoint(GWT.getModuleBaseURL() + SERVICE_NAME);
	}

	public static synchronized CarRentalServiceProxy getInstance() {
		if (instance == null) {
			instance = new CarRentalServiceProxy();
		}

		return instance;
	}

	public void getMasterData(AsyncCallback<MasterDataVO> callback) {
		proxy.getMasterData(callback);
	}

	public void saveDriverApplication(SaveDriverApplicationInput input, AsyncCallback<SaveDriverApplicationOutput> callback) {
		proxy.saveDriverApplication(input, callback);
	}

	public void saveDriverBackgroundCheck(SaveDriverBackgroundCheckInput input, AsyncCallback<SaveDriverBackgroundCheckOutput> callback) {
		proxy.saveDriverBackgroundCheck(input, callback);
	}

	 public void searchDriverApplication(SearchDriverApplicationInput input, AsyncCallback<SearchDriverApplicationOutput> callback) {
	 proxy.searchDriverApplication(input, callback);
	 }

	public void getGenericResult(String database, String tableName, String prefixField, String value, int maxResult,
			AsyncCallback<List<GenericResultModelDto>> callback) {
		proxy.getGenericResult(database, tableName, prefixField, value, maxResult, callback);
	}

	public void getCustomGenericResult(HelpListInputDto helpListInputDto, AsyncCallback<List<HelpListOutputModelDto>> callback) {
		proxy.getCustomGenericResult(helpListInputDto, callback);
	}
}