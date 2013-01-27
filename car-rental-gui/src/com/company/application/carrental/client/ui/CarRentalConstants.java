package com.company.application.carrental.client.ui;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;

public class CarRentalConstants {

	protected CarRentalConstants() {
		super();
	}

	public static final String ALL = "ALL";

	public static final Integer GRID_RECORDS_PER_PAGE = 10;

	public static final String NEW_LINE = "<br>";
	public static final String HORIZONTAL_LINE = "<hr>";

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final DateTimePropertyEditor DATE_TIME_PROPERTY_EDITOR = new DateTimePropertyEditor(DATE_FORMAT);
	public static final DateTimeFormat DATE_DD_MM_YY = DateTimeFormat.getFormat(DATE_FORMAT);
}