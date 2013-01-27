package com.company.application.carrental.client.model.proxy;

import org.puremvc4gwt.client.patterns.proxy.Proxy;

public class CurrenciesProxy extends Proxy {

	public static final String NAME = "CurrenciesProxy";

	public CurrenciesProxy() {
		super(NAME, null);
	}

	// public List<CurrencyModelDto> getCurrencies() {
	// return (List<CurrencyModelDto>) getData();
	// }
	//
	// public void setCurrencies(List<CurrencyModelDto> currencies) {
	// setData(currencies);
	// }
	//
	// public boolean currencyExists(String currencyShortName) {
	// boolean currencyExists = false;
	//
	// if (getCurrencies() != null) {
	// for (CurrencyModelDto currencyModelDto : getCurrencies()) {
	// if (currencyModelDto.getCurrenciesShortName().equals(currencyShortName))
	// {
	// currencyExists = true;
	// break;
	// }
	// }
	// }
	//
	// return currencyExists;
	// }
	//
	// public Integer getCurrencyId(String currencyShortName) {
	// Integer currencyId = null;
	//
	// if (getCurrencies() != null) {
	// for (CurrencyModelDto currencyModelDto : getCurrencies()) {
	// if (currencyModelDto.getCurrenciesShortName().equals(currencyShortName))
	// {
	// currencyId = currencyModelDto.getCurrenciesId();
	// break;
	// }
	// }
	// }
	//
	// return currencyId;
	// }
}