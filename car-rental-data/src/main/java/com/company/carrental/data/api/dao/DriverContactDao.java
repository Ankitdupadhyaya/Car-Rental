package com.company.carrental.data.api.dao;

import java.util.List;

import com.company.carrental.data.pojo.DriverContact;
import com.company.database.framework.criteria.data.dao.GenericDao;

public interface DriverContactDao extends GenericDao<DriverContact, Integer> {
    
    public List<DriverContact> searchDriverContacts(Integer driverId);

}
