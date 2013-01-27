package com.company.carrental.data.api.dao;

import java.util.List;

import com.company.carrental.data.pojo.DriverEmployment;
import com.company.database.framework.criteria.data.dao.GenericDao;

public interface DriverEmploymentDao extends GenericDao<DriverEmployment, Integer> {

    public List<DriverEmployment> searchDriverEmployment(Integer driverId);
}
