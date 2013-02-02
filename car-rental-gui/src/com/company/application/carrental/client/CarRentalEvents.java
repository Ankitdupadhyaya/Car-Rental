package com.company.application.carrental.client;

public class CarRentalEvents {

	public static final String STARTUP = "startupParent";
	public static final String ERROR = "error";

	public static final String LOAD_MASTER_DATA = "loadMasterData";
	public static final String LOAD_MASTER_DATA_SUCCESSFUL = "loadMasterDataSuccessful";
	public static final String LOAD_MASTER_DATA_FAILED = "loadMasterDataFailed";

	public static final String DISPLAY = "display";
	public static final String DISPLAY_MAIN_SCREEN = "displayMainScreen";
	public static final String DISPLAY_DRIVER_SCREEN = "displayDriverScreen";

	public static final String SAVE_DRIVER_APPLICATION = "saveDriverApplication";
	public static final String SAVE_DRIVER_APPLICATION_SUCCESSFUL = "saveDriverApplicationSuccessful";
	public static final String SAVE_DRIVER_APPLICATION_FAILED = "saveDriverApplicationFailed";

	public static final String SAVE_DRIVER_BACKGROUND_CHECK = "saveDriverBackgroundCheck";
	public static final String SAVE_DRIVER_BACKGROUND_CHECK_SUCCESSFUL = "saveDriverBackgroundCheckSuccessful";
	public static final String SAVE_DRIVER_BACKGROUND_CHECK_FAILED = "saveDriverBackgroundCheckFailed";

	public static final String SEARCH_DRIVER_APPLICATION = "searchDriverApplication";
	public static final String SEARCH_DRIVER_APPLICATION_SUCCESSFUL = "searchDriverApplicationSuccessful";
	public static final String SEARCH_DRIVER_APPLICATION_FAILED = "searchDriverApplicationFailed";
	
	public static final String SEARCH_DRIVER_BACKGROUND = "searchDriverBackground";
	public static final String SEARCH_DRIVER_BACKGROUND_SUCCESSFUL = "searchDriverBackgroundSuccessful";
	public static final String SEARCH_DRIVER_BACKGROUND_FAILED = "searchDriverBackgroundFailed";

	public static final String GET_GENERIC_RESULT = "genericResult";
	public static final String GET_GENERIC_RESULT_SUCCESS = "genericResultSuccess";
	public static final String GET_CUSTOM_GENERIC_RESULT = "customGenericResult";
	public static final String GET_CUSTOM_GENERIC_RESULT_SUCCESS = "customGenericResultSuccess";
}