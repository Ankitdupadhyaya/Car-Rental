
package com.company.carrental.data.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Area_Master")
public class AreaMaster {
    
    private Integer areaId;
    private String areaName;
    private Integer pinCode;
    
    private Set<AreaMaster> nearestAreas = new HashSet<AreaMaster>(); 
    private Set<DriverAddress> driverAddresses = new HashSet<DriverAddress>();
    
    public AreaMaster(){}
    
    public AreaMaster(Integer areaId){
        this.areaId = areaId;
    }
         
    @Id
    @Column(name = "Area_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getAreaId() {
        return areaId;
    }
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
    
    @Column(name= "Area_Name",nullable=false)
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
    @Column(name= "Pin_Code",nullable=false)
    public Integer getPinCode() {
        return pinCode;
    }
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
    
    @ManyToMany
    @JoinTable(name="Nearest_Areas",
                    joinColumns=@JoinColumn(name="Area_Id"),
                    inverseJoinColumns=@JoinColumn(name="Nearest_Area_Id")
    )
    public Set<AreaMaster> getNearestAreas(){
        return this.nearestAreas;
    }
    
    public void setNearestAreas(Set<AreaMaster> nearestAreas){
        this.nearestAreas = nearestAreas;
    }
    
    @OneToMany(mappedBy = "areaMaster")
    @Cascade(value = CascadeType.ALL)
    public Set<DriverAddress> getDriverAddresses() {
        return driverAddresses;
    }
    public void setDriverAddresses(Set<DriverAddress> driverAddresses) {
        this.driverAddresses = driverAddresses;
    }
    
    
    
//    @OneToOne
//    @JoinTable(name = "Nearest_Areas" , joinColumns=@JoinColumn(name="Nearest_Area_Id"),
//                    inverseJoinColumns=@JoinColumn(name="Area_Id")
//                    )
//                    public AreaMaster

}
