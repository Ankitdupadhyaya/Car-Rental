package com.company.carrental.data.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Driver_Address")
public class DriverAddress {
    private Integer driverAddressId;
//    private String addressType;
    private String address;
//    private Integer areaId;
    private AreaMaster areaMaster;    
    private DriverMaster driverMaster;
    private String landmark;
	private AddressTypeMaster addressTypeMaster;
    

    @Id
    @Column(name="Driver_Address_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getDriverAddressId() {
        return driverAddressId;
    }
    public void setDriverAddressId(Integer driverAddressId) {
        this.driverAddressId = driverAddressId;
    }
//    @Column(name= "Address_Type",nullable=false)
//    public String getAddressType() {
//        return addressType;
//    }
//    public void setAddressType(String addressType) {
//        this.addressType = addressType;
//    }
    
    @Column(name= "Address",nullable=false)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name= "Landmark",nullable = true)
    public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
    
//    @Column(name= "Area_Id",nullable=false)
//    public Integer getAreaId() {
//        return areaId;
//    }
//    public void setAreaId(Integer areaId) {
//        this.areaId = areaId;
//    }
    
    @ManyToOne
    @JoinColumn(name = "Driver_Id", nullable = false)
    @Cascade(value = CascadeType.DELETE_ORPHAN)
    public DriverMaster getDriverMaster() {
        return driverMaster;
    }
    
    public void setDriverMaster(DriverMaster driverMaster) {
        this.driverMaster = driverMaster;
    }
    
    @ManyToOne
    @JoinColumn(name = "Address_Type_Id", nullable = false)
    public AddressTypeMaster getAddressTypeMaster() {
        return addressTypeMaster;
    }
    public void setAddressTypeMaster(AddressTypeMaster addressTypeMaster) {
        this.addressTypeMaster = addressTypeMaster;
    }
  
    @ManyToOne
    @JoinColumn(name = "Area_Id", nullable = false)
    public AreaMaster getAreaMaster() {
        return areaMaster;
    }
    public void setAreaMaster(AreaMaster areaMaster) {
        this.areaMaster = areaMaster;
    }

}
