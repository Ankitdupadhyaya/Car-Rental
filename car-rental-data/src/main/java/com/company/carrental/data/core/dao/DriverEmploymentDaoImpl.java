package com.company.carrental.data.core.dao;


import java.util.ArrayList;
import java.util.List;

import com.company.carrental.data.api.dao.DriverEmploymentDao;
import com.company.carrental.data.pojo.DriverEmployment;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.database.framework.criteria.data.criteria.PropertyValue;
import com.company.database.framework.criteria.data.criteria.PropertyValueImpl;
import com.company.database.framework.criteria.data.dao.GenericDaoHibernate;
import com.company.database.framework.criteria.operation.Equal;
import com.company.database.framework.criteria.operation.Operation;

public class DriverEmploymentDaoImpl extends GenericDaoHibernate<DriverEmployment, Integer> implements DriverEmploymentDao{

    public DriverEmploymentDaoImpl() {
        super(DriverEmployment.class);
    }
    
    public List<DriverEmployment> searchDriverEmployment(Integer driverId){
        
        PropertyValue driver = new PropertyValueImpl("driverMaster", new DriverMaster(driverId));
        
        Equal equalDriverId = new Equal();
        equalDriverId.setParameter(driver);
        
        List<Operation> operations = new ArrayList<Operation>();
        operations.add(equalDriverId);
        
        List<DriverEmployment> driverEmployments = super.findByRestrictions(operations);
        
        return driverEmployments;
        
        }
    
}
