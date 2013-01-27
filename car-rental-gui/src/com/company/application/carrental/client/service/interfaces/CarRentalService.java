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
import com.google.gwt.user.client.rpc.RemoteService;

public interface CarRentalService extends RemoteService {

	MasterDataVO getMasterData() throws Throwable;

	SaveDriverApplicationOutput saveDriverApplication(
			SaveDriverApplicationInput input);

	SaveDriverBackgroundCheckOutput saveDriverBackgroundCheck(
			SaveDriverBackgroundCheckInput input);

	SearchDriverApplicationOutput searchDriverApplication(SearchDriverApplicationInput input);

	List<GenericResultModelDto> getGenericResult(String database,
			String tableName, String prefixField, String value, int maxResult)
			throws Throwable;

	List<HelpListOutputModelDto> getCustomGenericResult(
			HelpListInputDto helpListInputDto) throws Throwable;
}
