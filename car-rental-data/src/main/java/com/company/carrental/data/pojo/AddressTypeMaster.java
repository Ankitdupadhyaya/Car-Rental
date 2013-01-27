package com.company.carrental.data.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Address_Type_Master")
public class AddressTypeMaster {

    
    private Integer addressTypeId;
    private String addressTypeName;
    
    private Set<DriverAddress> driverAddresses;
    
    public AddressTypeMaster(){
        
    }
    
    public AddressTypeMaster(Integer addressTypeId){
        this.addressTypeId = addressTypeId;
    }
    
    @Id
    @Column(name = "Address_Type_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getAddressTypeId() {
        return addressTypeId;
    }
    public void setAddressTypeId(Integer addressTypeId) {
        this.addressTypeId = addressTypeId;
    }
    
    @Column(name= "Address_Type_Name",nullable=false)
    public String getAddressTypeName() {
        return addressTypeName;
    }
    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }
    
    @OneToMany(mappedBy = "addressTypeMaster")
    @Cascade(value = CascadeType.ALL)
    public Set<DriverAddress> getDriverAddresses() {
        return driverAddresses;
    }
    public void setDriverAddresses(Set<DriverAddress> driverAddresses) {
        this.driverAddresses = driverAddresses;
    }
    
    

}
