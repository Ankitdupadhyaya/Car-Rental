package com.company.application.carrental.client.model.vo;

import static com.company.application.carrental.client.util.MessageResourceFactory.carRentalLabels;

public enum SearchPerimeters {

	BRANCHES(carRentalLabels.BRANCHES()), PORTFOLIOS(carRentalLabels.PORTFOLIOS()), FOLDERS(carRentalLabels.FOLDERS()), FOLDERSGRP(carRentalLabels.FOLDERSGRP());

	private String value;

	SearchPerimeters(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public boolean equals(String value) {
		return this.value.equals(value);
	}

	public static boolean is_Branch(String perimeter) {
		if (BRANCHES.equals(perimeter)) {
			return true;
		}

		return false;
	}

	public static boolean is_Portfolios(String perimeter) {
		if (PORTFOLIOS.equals(perimeter)) {
			return true;
		}

		return false;
	}

	public static boolean is_Folders(String perimeter) {
		if (FOLDERS.equals(perimeter)) {
			return true;
		}

		return false;
	}

	public static boolean is_FoldersGrp(String perimeter) {
		if (FOLDERSGRP.equals(perimeter)) {
			return true;
		}

		return false;
	}
}