/*
 * Copyright(c) 2008 Jari Kemppinen <jari@viddem.com> This example was built
 * upon the PureMVC Framework by Cliff Hall. http://www.puremvc.org This example
 * uses the Java PureMVC Framework Version 0.2 Please contribute to the PureMVC
 * community. License ------- Your reuse is governed by the Creative Commons
 * Attribution 3.0 license.
 */

package com.company.application.carrental.client.view.mediators;

import java.util.List;

import org.puremvc4gwt.client.interfaces.INotification;
import org.puremvc4gwt.client.patterns.mediator.Mediator;

import com.company.application.carrental.client.CarRentalEvents;
import com.company.application.carrental.client.model.vo.GenericResultModelDto;
import com.company.application.carrental.client.model.vo.HelpListOutputModelDto;
import com.company.application.carrental.client.ui.ADKCustomHelpList;
import com.company.gui.adkwidgets.client.ApplicationFacade;

/**
 * This class acts as a mediator for ADKCustomHelpList related actions
 * 
 * @author g_lect
 * 
 */
public class CustomHelpListMediator extends Mediator {

	public static final String NAME = "CustomHelpListMediator";

	private ADKCustomHelpList helpList = null;

	public CustomHelpListMediator() {
		super(NAME, null);
	}

	public String[] listNotificationInterests() {
		return new String[] { CarRentalEvents.GET_CUSTOM_GENERIC_RESULT_SUCCESS };
	}

	public void handleNotification(INotification note) {
		if (note.getName().equals(CarRentalEvents.GET_CUSTOM_GENERIC_RESULT_SUCCESS)) {
			getCustomGenericResultSuccessAction((List<HelpListOutputModelDto>) note.getBody());

		}
	}

	private ADKCustomHelpList getCustomHelpListWidget() {
		if (helpList == null) {
			helpList = (ADKCustomHelpList) getViewComponent();
		}
		return helpList;
	}

	public void getGenericResultSuccessAction(List<GenericResultModelDto> results) {
		getCustomHelpListWidget().getGenericResultSuccessAction(results);
	}

	public void getCustomGenericResultSuccessAction(List<HelpListOutputModelDto> results) {
		getCustomHelpListWidget().getCustomGenericResultSuccessAction(results);
	}

	public void getGenericResult(String value, int maxResult) {
		Object args[] = new Object[6];
		args[0] = value;
		args[1] = maxResult;
		args[2] = this;
		args[3] = getCustomHelpListWidget().getDatabaseName();
		args[4] = getCustomHelpListWidget().getTableName();
		args[5] = getCustomHelpListWidget().getPrefixField();
		ApplicationFacade.getInst().sendNotification(CarRentalEvents.GET_GENERIC_RESULT, args, null);
	}

	public void getCustomGenericResult(String value, List<String> outputColumns, int maxResult) {
		Object args[] = new Object[7];
		args[0] = value;
		args[1] = maxResult;
		args[2] = this;
		args[3] = getCustomHelpListWidget().getDatabaseName();
		args[4] = getCustomHelpListWidget().getTableName();
		args[5] = getCustomHelpListWidget().getSearchFields().get(0);
		args[6] = outputColumns;
		ApplicationFacade.getInst().sendNotification(CarRentalEvents.GET_CUSTOM_GENERIC_RESULT, args, null);
	}
}