package com.company.application.carrental.client.util;

import com.google.gwt.i18n.client.Messages;

public interface CarRentalLabels extends Messages {

	String INFO();

	/* Buttons */
	String SEARCH();

	String OK();

	String LOGOUT();

	String SAVE();

	String RESET();

	String GENERATE();

	String EXPAND_ALL();

	String COLLAPSE_ALL();

	// Common Labels
	String SESSION_EXPIRED();

	String SELECT();

	String ALL();

	String EXPORT_EXCEL();

	// Menu Labels
	String FLOW_REPORTING();

	String STOCK_REPORTING();

	String CONFIGURATION();

	String CURRENCY_ORDER();

	String CURRENCY_GROUP();

	String FLOW_REPORT();

	String STOCK_REPORT();

	// Search Panel Labels
	String BRANCHES();

	String PORTFOLIOS();

	String BRANCH();

	String PORTFOLIO();

	String FOLDER();

	String FOLDERSGRP();

	String K_TYPE_OF_INSTRUMENT();

	String CURRENCY();

	String CURRENCY_SHORTNAME();

	String CURRENCY_NAME();

	String AVAILABLE_CURRENCIES();

	String APPLICATION_CURRENCY_GROUP();

	String SORT_ORDER();

	String MONTH();

	String YEAR();

	String START_DATE();

	String END_DATE();

	//
	String SITE();

	String DEAL_ID();

	String FOLDERS();

	String INSTRUMENT();

	String MATURITY();

	String TRADE_DATE();

	String VALUE_DATE();

	String MATURITY_DATE();

	String AMOUNT();

	String BP();

	String DAY_NUMBER();

	String TREASURY_RATE();

	String LIQUIDITY_MARGIN();

	String MIN_COMMERCIAL_MARGIN();

	String CLIENT_RATE();

	String BOR_RATE();

	String FTP();

	String RM_RATE();

	String AVERAGE_AMOUNT();

	String HARD_MARGIN();

	String COMMERCIAL_MARGIN();

	String MARGIN_TO_BOR();

	String TOTAL_MARGIN();

	String TRESO_TO_BOR_MARGIN();

	String STOCK_REPORT_HEADER(String startDate);

	String EXCEL_STOCK_REPORT_HEADER(String startDate);

	String FLOW_REPORT_HEADER(String startDate, String endDate);

	String EXCEL_FLOW_REPORT_HEADER(String startDate, String endDate);

	String MOVE_UP();

	String MOVE_ALL_RIGHT();

	String MOVE_RIGHT();

	String MOVE_ALL_LEFT();

	String MOVE_LEFT();

	String MOVE_DOWN();

	String ERROR();

	String WARNING();

	String MESSAGE_INITIALIZING();

	String MESSAGE_FLOW_REPORT();

	String MESSAGE_STOCK_REPORT();

	String MESSAGE_GET_CURRENCY_GROUP_LIST();

	String MESSAGE_SAVE_CURRENCY_GROUP_LIST();
}