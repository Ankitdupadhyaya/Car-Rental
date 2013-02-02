package com.company.application.carrental.client.util;

import com.google.gwt.i18n.client.Messages;

public interface CarRentalErrorMessages extends Messages {

	String ERROR_TITLE();

	String CONFIG_ERROR();

	String LOAD_CONFIG_ERROR();

	String NO_RESULTS_FOUND();

	String USER_CODIFIER_UNASSIGNED(String userShortName, String codifierShortName);

	String MANDATORY(String fieldName);

	String INVALID_DATE(String fieldName, String format);

	String MIN_DATE(String fieldName, String minDate);

	String MAX_DATE(String fieldName, String maxDate);

	String GREATER_OR_EQUAL_TO_CURRENT_DATE(String fieldName);

	String GREATER_OR_EQUAL_TO_DATE(String fromDate, String toDate);

	String SAME_MONTH_AND_YEAR(String fromDate, String toDate);

	String NO_REPORT_DATA();

	String NO_DATA_TO_EXPORT();
}