package com.company.application.carrental.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

public abstract class ADKApplication1 extends Viewport {

	private static final String ID_MAIN_PANEL = "mainPanel";
	private static final String ID_HEADER_PANEL = "headerPanel";

	// Title displayed into the header
	private static String appTitle;

	private static char dateFormat; // = ADKDateField.EU_DATEFORMAT_CHAR;

	// Boolean true if the appli contains a menu
	private static boolean isMenu = true;

	private ContentPanel northPanel;
	private ADKMainPanel1 mainPanel;
	private Image image;
	private ToolBar toolbar;
	// private ADKLabel infos;

	// private final static LabelProperties LABEL = GWT
	// .create(LabelProperties.class);

	// User authenticated
	// protected static UserConnectedDto user;
	// App id, name and version into KALM DB
	// protected static ApplicationDto app;
	// Application name
	protected static String appName;

	/**
	 * Constructor
	 * 
	 * @param title : title displayed on top of the application
	 */
	protected ADKApplication1(String title) {

		// appTitle = LABEL.APP_TITLE() + " " + title;

		// final BorderLayout layout = new BorderLayout();
		// setLayout(layout);
		initCustom();
	}

	/**
	 * Constructor
	 * 
	 * @param title : title displayed on top of the application
	 * @param isMenuBar : will it use a menuBar(default true)
	 */
	protected ADKApplication1(String title, boolean isMenuBar) {
		this(title);
		isMenu = isMenuBar;
	}

	/**
	 * Constructor
	 * 
	 * @param title : title displayed on top of the application
	 * @param isMenuBar : will it use a menuBar(default true)
	 * @param customPAnel : Customised ADKMainPanel
	 */
	protected ADKApplication1(String title, boolean isMenuBar, ADKMainPanel1 customMainPanel) {
		this(title);
		isMenu = isMenuBar;
		mainPanel = customMainPanel;
	}

	/**
	 * @param appVersion
	 * @param headerInfos
	 */
	public void initGen(String appVersion, String headerInfos) {

		/*
		 * NORTH PANEL Contains : Image + ToolBar with Menu + Informations
		 */
		northPanel = new ContentPanel();
		northPanel.setId(ID_HEADER_PANEL);

		image = new Image();
		// image.setTitle(LABEL.LOGO_NAME());
		// image.setUrl(GWT.getModuleBaseURL() + LABEL.LOGO_URL());
		image.setWidth("346");

		BorderLayoutData northData;
		if (isMenu) {
			northData = new BorderLayoutData(110);
		} else {
			northData = new BorderLayoutData(85);
		}

		northData.setCollapsible(true);
		northData.setSplit(true);
		northData.setMargins(new Margins(5, 5, 0, 5));

		add(northPanel, northData);

		/*
		 * MAIN PANEL Contains : Default Centre Panel (Optional West, East, South and North Panel)
		 */
		if (mainPanel == null) {
			mainPanel = new ADKMainPanel1(ID_MAIN_PANEL);
		}
		// mainPanel.setScrollMode(Scroll.AUTOX);
		// mainPanel.setHeaderVisible(false);

		BorderLayoutData centerData = new BorderLayoutData();
		centerData.setMargins(new Margins(5, 0, 5, 0));

		add(mainPanel, centerData);

		// LayoutContainer layoutLogo = new LayoutContainer();
		//
		// northPanel.setHeading(appTitle + " " + appVersion);
		// infos = new ADKLabel("headerInfos", headerInfos);
		// northPanel.getHeader().addTool(infos);
		//
		// layoutLogo.setStyleName("logo-cib-bar");
		// layoutLogo.add(image);
		// northPanel.add(layoutLogo);
		//
		// if (headerInfos != null) {
		// infos.setStyleName("adk-label-mandatory");
		// } else {
		// infos.setStyleName("adk-label-mandatory-8pt");
		// }

		addWindowCloseHandler();

		// Custom initialisation for each application
		init();
		display();
	}

	/**
	 * To be implemented in each application
	 */
	public abstract void init();

	/**
	 * To be implemented in the app type (Kondor, Dex, ...)
	 */
	protected abstract void initCustom();

	/**
	 * Display the application
	 */
	public void display() {

		RootPanel.get().add(this);
	}

	/**
	 * @return MainPanel
	 */
	public ADKMainPanel1 getMainPanel() {
		return mainPanel;
	}

	/**
	 * Add a menuBar
	 */
	public void addMenuBar() {
		toolbar = new ToolBar();
		// toolbar.setAutoWidth(true);
		// toolbar.setAutoHeight(true);
		northPanel.add(toolbar);
	}

	/**
	 * @return MenuBar
	 */
	public ToolBar getMenuBar() {
		return toolbar;
	}

	/**
	 * Add a Home item with a listener to the menu bar
	 * 
	 * @param listener : defines what happens when clicking on the HOME item
	 */
	// public void addHomeItem(ADKButtonListener listener) {
	// toolbar.addHomeItem(listener);
	// }

	/**
	 * Close the application and the window
	 */
	public static native void closeApplication()/*-{       
												$wnd.opener = top;
												$wnd.close(); 
												}-*/;

	/**
	 * Redirection
	 * 
	 * @param url
	 */
	public static native void redirect(String url)/*-{
													$wnd.location = url;
													}-*/;

	/**
	 * @return dateFormat
	 */
	public static char getDateFormat() {
		return dateFormat;
	}

	/**
	 * @param dateFormat
	 */
	public static void setDateFormat(char format) {
		dateFormat = format;
	}

	/**
	 * @param headerInfos
	 */
	public void setHeaderInfos(String headerInfos) {
		// infos.setStyleName("adk-label-mandatory");
		// infos.setText(headerInfos);
	}

	// Shifted from KondorADKApplication
	/**
	 * @return UserConnectedDto
	 */
	// public static UserConnectedDto getUser() {
	// return user;
	// }

	/**
	 * @param userConnected : user
	 */
	// public static void setUser(UserConnectedDto userConnected) {
	// user = userConnected;
	// }

	/**
	 * 
	 * @return app
	 */
	// public static ApplicationDto getApp() {
	// return app;
	// }

	/**
	 * 
	 * @param app
	 */
	// public static void setApp(ApplicationDto app) {
	// ADKApplication.app = app;
	// }

	/**
	 * 
	 * @return appName
	 */
	public static String getAppName() {
		return appName;
	}

	/**
	 * @return int
	 */
	// public static int getAppId() {
	// return app.getId();
	// }

	/**
	 * @return int user id
	 */
	// public int getUserId() {
	// return user.getId();
	// }

	// /**
	// * Specify the path where the files will be generated
	// *
	// * @param generationPath
	// * : ex "C:\\MyPath\\MyFolder\\"
	// */
	// public static void setGenerationExportFolderPath(String generationPath) {
	// ReportExportServiceFmkProxy.getInstance().setGenerationFolderPath(
	// generationPath);
	// }

	public void enableLoadingMask(String text) {
		// El.fly(RootPanel.getBodyElement()).mask(text);
	}

	public void disableLoadingMask() {
		// El.fly(RootPanel.getBodyElement()).unmask();
	}

	private void addWindowCloseHandler() {
		// CloseHandler<Window> closedHandler = new CloseHandler<Window>() {
		//
		// public void onClose(CloseEvent<Window> event) {
		// ApplicationFacade.getInst().sendNotification(
		// ApplicationEvents.DISCONNECT, "", null);
		// }
		// };
		// Window.addCloseHandler(closedHandler);
		//
		// Window.ClosingHandler closingHandler = new Window.ClosingHandler() {
		//
		// public void onWindowClosing(Window.ClosingEvent event) {
		// event.setMessage(LABEL.EXIT_APPLICATION(getAppName()));
		// }
		// };
		// Window.addWindowClosingHandler(closingHandler);
	}
}