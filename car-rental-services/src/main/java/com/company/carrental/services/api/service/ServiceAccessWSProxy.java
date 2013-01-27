package com.company.carrental.services.api.service;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * @author Vishwajeet Nambiar
 */
public class ServiceAccessWSProxy{// extends ContextLoaderListener {

//	private final static Logger LOG = Logger.getLogger(ServiceAccessWSProxy.class);

	private static ApplicationContext appContext;
	private static ServiceAccessWSProxy instance;

	private static String PersistenceContextPath = "./CarRentalPersistenceContext.xml";

//	private ServletContext servletContext;

	/**
	 * Not use this constructor
	 */
	@Deprecated
	public ServiceAccessWSProxy() {
		super();
		instance = this;
	}

	/**
	 * @param ctxFiles
	 */
	private ServiceAccessWSProxy(String[] ctxFiles) {
		super();
		if (appContext == null) {
			this.appContext = initializeApplicationContext(ctxFiles);
		}
	}

	/**
	 * @param contextFiles
	 * @return ApplicationContext
	 */
	protected ApplicationContext initializeApplicationContext(String[] contextFiles) {
		if (appContext == null) {
			// ADD PROPERTIES MECANIC HERE
			appContext = new ClassPathXmlApplicationContext(contextFiles);
			// appContext = new ClassPathXmlApplicationContext();
		}
		return appContext;
	}

	/**
	 * @param event
	 */
//	public void contextInitialized(ServletContextEvent event) {
//		super.contextInitialized(event);
//		this.servletContext = event.getServletContext();
//		this.appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.servletContext);
//	}

	/**
	 * @return ServiceAccessWSProxy
	 */
	public static synchronized ServiceAccessWSProxy getInstance() {
		return getInstance(PersistenceContextPath);
	}

	/**
	 * @return ServiceAccessWSProxy
	 */
	public static synchronized ServiceAccessWSProxy getInstance(String contextPath) {
		if (instance == null) {
			String[] contextFiles = new String[] { contextPath };
			instance = new ServiceAccessWSProxy(contextFiles);
		}

		return instance;
	}

	public static void setContextPath(String contextPath) {
		PersistenceContextPath = contextPath;
	}

	public Object getService(String serviceName) {
		return getApplicationContext().getBean(serviceName);
	}

	/**
	 * @return ApplicationContext
	 */
	public ApplicationContext getApplicationContext() {
		return appContext;
	}

	/**
	 * @return GridPropertiesWSService
	 */
//	public GridPropertiesWSService getGridPropertiesService() {
//		LOG.info("getApplicationContext GRID" + getApplicationContext());
//		LOG.info("getApplicationContext.getBean " + getApplicationContext().getBean("GridPropertiesWSService"));
//		return (GridPropertiesWSService) getApplicationContext().getBean("GridPropertiesWSService");
//	}

	// /**
	// * @return ConfigManagerService
	// */
	// public ConfigMgrService getConfigManagerService() {
	// return (ConfigMgrService) getApplicationContext().getBean("ConfigMgrService");
	// }

	/**
	 * @return ApplicationWSService
	 */
//	public ApplicationWSService getApplicationWSService() {
//
//		LOG.debug("getApplicationContext APP");
//		return (ApplicationWSService) getApplicationContext().getBean("ApplicationWSService");
//
//	}

	/**
	 * @return UserWSService
	 */
//	public UserWSService getUserWSService() {
//		return (UserWSService) getApplicationContext().getBean("UserWSService");
//		// return null;
//	}
}