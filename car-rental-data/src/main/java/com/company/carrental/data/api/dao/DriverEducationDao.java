package com.company.carrental.data.api.dao;

import java.util.List;

import com.company.carrental.data.pojo.DriverEducation;
import com.company.database.framework.criteria.data.dao.GenericDao;

public interface DriverEducationDao extends GenericDao<DriverEducation, Integer> {

    public List<DriverEducation> searchDriverEducation(Integer driverId);
}
