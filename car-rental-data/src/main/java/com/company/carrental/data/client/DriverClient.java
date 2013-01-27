package com.company.carrental.data.client;

import java.util.Date;

import org.hibernate.Session;

import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.data.util.HibernateUtil;



public class DriverClient {
    
    public static void main(String[] args) {
        Session session = HibernateUtil.getAnnotatedSessionFactory().openSession();

        session.beginTransaction();
        DriverMaster dm = new DriverMaster();

        dm.setDriverFullName("Ankit Upadhyaya");
        dm.setGender('M');
        dm.setTotalExperience(2.5f);
        dm.setDob(new Date());
        dm.setPrimaryContactNumber("55459");
        dm.setCarTypeAutomatic('N');
        dm.setCarTypeManual('Y');
        session.persist(dm);
        session.getTransaction().commit();
        session.close();
        
}
}
