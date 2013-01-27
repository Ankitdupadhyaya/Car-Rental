package com.company.carrental.data.client;

import org.hibernate.Session;

import com.company.carrental.data.util.HibernateUtil;



public class UserClient {
    
    public static void main(String[] args) {
        Session session = HibernateUtil.getAnnotatedSessionFactory().openSession();

        session.beginTransaction();
//        User user = new User();
//       // user.setUserId(001);
//        user.setUserFName("Brinal");
//        user.setUserLName("colaco");
//        user.setUserFullName("brinal colaco");
//        user.setEmployeeId("B001");
//        user.setUserContactNo(90082085);
//        user.setEmailId("brinal15@yahoo.com");
        
//        session.persist(user);
//        session.getTransaction().commit();
//        session.close();
        
}
}
