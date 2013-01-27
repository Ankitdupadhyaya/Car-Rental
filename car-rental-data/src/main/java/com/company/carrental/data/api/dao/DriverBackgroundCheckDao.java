package com.company.carrental.data.api.dao;

import java.util.List;

import com.company.carrental.data.pojo.DriverBackgroundCheck;
import com.company.database.framework.criteria.data.dao.GenericDao;

public interface DriverBackgroundCheckDao extends GenericDao<DriverBackgroundCheck, Integer> {

    public List<DriverBackgroundCheck> searchDriverBackgroundCheck(Integer driverId);
}
