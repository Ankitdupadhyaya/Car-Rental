package com.company.application.carrental.client.ui;

import java.util.Date;

import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;

public class CarRentalDateTimeFormatter {

	private static final String DATE_FORMAT = "dd/MM/y";
	private static final DateTimePropertyEditor DATE_TIME_PROPERTY_EDITOR = new DateTimePropertyEditor(
			DATE_FORMAT);

	private static final String EXCEL_DATE_FORMAT = "dd-MM-y";
	private static final DateTimePropertyEditor EXCEL_DATE_TIME_PROPERTY_EDITOR = new DateTimePropertyEditor(
			EXCEL_DATE_FORMAT);

	private CarRentalDateTimeFormatter() {
	}

	public static String format(Date date) {
		return DATE_TIME_PROPERTY_EDITOR.render(date);
	}

	public static String excelFormat(Date date) {
		return EXCEL_DATE_TIME_PROPERTY_EDITOR.render(date);
	}
}