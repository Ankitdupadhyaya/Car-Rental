package com.company.application.carrental.client;

import java.util.List;

import com.company.application.carrental.client.ui.DisplayComponent;
import com.company.application.carrental.client.ui.DisplayComponentDirection;
import com.extjs.gxt.ui.client.widget.Composite;

public class CarRentalApplication extends com.company.gui.adkwidgets.client.ui.ADKApplication {

	private String userSite;
	private boolean isUserAdmin;

	// private static UserModelDto loggedInUser;

	/**
	 * 
	 * @param title : title displayed for the application
	 * @param codifier : codifier to check for the application
	 */
	public CarRentalApplication(final String title, String codifier, List<String> codes, String name) {
		// super(title, codifier, codes, name, true, true);
		super(title);

		initCustom();
	}

	@Override
	public void initCustom() {
		CarRentalFacade facade = CarRentalFacade.getInstance();
		facade.start(this);

		initGen("", "");
	}

	/**
	 * Write the init method of your application : Define the menu bar, center panel and west, east or/and south panel
	 */
	@Override
	public void init() {
		CarRentalFacade.getInstance().sendNotification(CarRentalEvents.DISPLAY_MAIN_SCREEN, null, null);
	}

	public static void showProgressBar(String operationMsg) {
		closeProgressBar();
		// WMIWebReportingFacade.getApplication().enableLoadingMask(operationMsg);
	}

	public static void closeProgressBar() {
		// WMIWebReportingFacade.getApplication().disableLoadingMask();
	}

	public static void showErrorMessage(String errorMessage) {
		// MessageBox.alert(wmiWRErrorMessages.ERROR_TITLE(), errorMessage,
		// null);
	}

	public static void showMessage(String message) {
		// Info.display(wmiWRLabels.INFO(), message);
	}

	public static void redirectToLogin() {
		redirect("/authentication/login.jsp?url=wmi-web-reporting&amp;label=WMI Web Reporting");
	}

	public static native void redirect(String url)
	/*-{
		$wnd.location = url;
	}-*/;

	public void displayScreen(Composite composite, DisplayComponentDirection componentDirection) {
		DisplayComponent displayComponent = new DisplayComponent(composite, componentDirection);
		CarRentalFacade.getInstance().sendNotification(CarRentalEvents.DISPLAY, displayComponent, null);
	}

	// private void checkUserSite() {
	// KondorUserConnectedDto user = (KondorUserConnectedDto)
	// WMIWebReportingApplication.getUser();
	// List<CodifierModelDto> codifierList = user.getCodifierList();
	// for (CodifierModelDto codifier : codifierList) {
	// if
	// (WMIWebReporting.APPLICATION_CODIFIER_WMIWLM.equalsIgnoreCase(codifier.getCodifierShortName()))
	// {
	// userSite = codifier.getCode();
	// break;
	// }
	// }
	//
	// StringBuffer header = new StringBuffer();
	// header.append(user.getName() + "  -  " + user.getUserGrp() +
	// KondorADKApplication.getDbServer());
	//
	// if (userSite != null) {
	// setUserAdmin(WMIWebReporting.APPLICATION_CODE_ALL.equals(userSite));
	// header.append(", Site - " + userSite);
	//
	// } else {
	// showErrorMessage(wmiWRErrorMessages.USER_CODIFIER_UNASSIGNED(user.getName(),
	// WMIWebReporting.APPLICATION_CODIFIER_WMIWLM));
	// }
	//
	// setHeaderInfos(header.toString());
	// }

	public String getUserSite() {
		return userSite;
	}

	public boolean isUserNonAdmin() {
		return !isUserAdmin;
	}

	public boolean isUserAdmin() {
		return isUserAdmin;
	}

	private void setUserAdmin(boolean isUserAdmin) {
		this.isUserAdmin = isUserAdmin;
	}

	// public static UserModelDto getLoggedInUser() {
	// if (loggedInUser == null) {
	// loggedInUser = new UserModelDto();
	// loggedInUser.setUserId(WMIWebReportingApplication.getUser().getId());
	// loggedInUser.setUserName(WMIWebReportingApplication.getUser().getName());
	// loggedInUser.setUserShortName(WMIWebReportingApplication.getUser().getShortName());
	// }
	//
	// return loggedInUser;
	// }

	// public void collapseWestPanel() {
	// getMainPanel().getWestPanel().collapse();
	// }
}