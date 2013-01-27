package com.company.carrental.data.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.company.carrental.data.pojo.DriverMaster;


public class HibernateUtil {

	static SessionFactory factory;
	
	public static SessionFactory getSessionFactory(){
		try {
			if(factory==null){
				Configuration cfg = new Configuration();
				cfg.setInterceptor(new SimpleLogInterecptor());
				
				factory = cfg.configure("hibernate.cfg.xml")
						.buildSessionFactory();
			}
			System.out.println("Factory Created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factory;
	}
	
	static SessionFactory cachefactory;
	
	public static SessionFactory getCacheSessionFactory(){
		try {
			if(cachefactory==null){
				Configuration cfg = new Configuration();
				
				cachefactory = cfg.configure(
						"hibernate-cache.cfg.xml")
						.buildSessionFactory();
			}
			System.out.println("Factory Created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cachefactory;
	}
	
	
	
	static SessionFactory anFactory;
	
	public static SessionFactory getAnnotatedSessionFactory(){
		try {
			if(anFactory==null){
				AnnotationConfiguration ancfg =
						new AnnotationConfiguration();
				
//				ancfg.addAnnotatedClass(DriverMaster.class);
//				ancfg.addAnnotatedClass(Category.class);
//				ancfg.addAnnotatedClass(Ingredient.class);
				
				anFactory = ancfg.configure("hibernate.cfg.xml")
						.buildSessionFactory();
				System.out.println("Annotated Factory Created");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return anFactory;
	}
	
}
