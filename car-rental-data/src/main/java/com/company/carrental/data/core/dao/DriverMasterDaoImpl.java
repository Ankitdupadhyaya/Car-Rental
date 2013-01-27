package com.company.carrental.data.core.dao;


import com.company.carrental.data.api.dao.DriverMasterDao;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.database.framework.criteria.data.dao.GenericDaoHibernate;

public class DriverMasterDaoImpl extends GenericDaoHibernate<DriverMaster, Integer> implements DriverMasterDao{

    public DriverMasterDaoImpl() {
        super(DriverMaster.class);
    }
    
}
