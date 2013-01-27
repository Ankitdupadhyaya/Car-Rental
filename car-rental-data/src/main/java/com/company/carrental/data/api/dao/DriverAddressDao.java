package com.company.carrental.data.api.dao;

import java.util.List;

import com.company.carrental.data.pojo.DriverAddress;
import com.company.database.framework.criteria.data.dao.GenericDao;

public interface DriverAddressDao extends GenericDao<DriverAddress, Integer> {

    public List<DriverAddress> searchDriverAdddresses(Integer driverId);
}
