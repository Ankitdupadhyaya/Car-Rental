package com.company.application.carrental.client.service.interfaces;

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
import com.company.application.carrental.client.model.vo.SearchDriverBackgroundCheckInput;
import com.company.application.carrental.client.model.vo.SearchDriverBackgroundCheckOutput;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CarRentalServiceAsync {

	public void getMasterData(AsyncCallback<MasterDataVO> callback);

	public void saveDriverApplication(SaveDriverApplicationInput input, AsyncCallback<SaveDriverApplicationOutput> callback);

	public void saveDriverBackgroundCheck(SaveDriverBackgroundCheckInput input, AsyncCallback<SaveDriverBackgroundCheckOutput> callback);

	 public void searchDriverApplication(SearchDriverApplicationInput input, AsyncCallback<SearchDriverApplicationOutput> callback);
	 
	 public void searchDriverBackground(SearchDriverBackgroundCheckInput input, AsyncCallback<SearchDriverBackgroundCheckOutput> callback);

	public void getGenericResult(String database, String tableName, String prefixField, String value, int maxResult,
			AsyncCallback<List<GenericResultModelDto>> callback);

	public void getCustomGenericResult(HelpListInputDto helpListInputDto, AsyncCallback<List<HelpListOutputModelDto>> callback);
}