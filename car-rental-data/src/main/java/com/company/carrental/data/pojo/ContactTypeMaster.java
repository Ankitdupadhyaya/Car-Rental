package com.company.carrental.data.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.org.apache.xpath.internal.axes.ChildTestIterator;

@Entity
@Table(name = "Contact_Type_Master")
public class ContactTypeMaster {
    
    private Integer contactTypeId;
    private String contactTypeName;
    
    private List<DriverContact> driverContacts;
    
    public ContactTypeMaster(){
        
    }
    
    public ContactTypeMaster(Integer contactTypeId){
        this.contactTypeId = contactTypeId;
    }
    
    @Id
    @Column(name = "Contact_Type_Id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getContactTypeId() {
        return contactTypeId;
    }
    public void setContactTypeId(Integer contactTypeId) {
        this.contactTypeId = contactTypeId;
    }
    
    @Column(name= "Contact_Type_Name",nullable=false)
    public String getContactTypeName() {
        return contactTypeName;
    }
    public void setContactTypeName(String contactTypeName) {
        this.contactTypeName = contactTypeName;
    }

    @OneToMany(mappedBy = "contactTypeMaster")
    @Cascade(value = CascadeType.ALL)
    public List<DriverContact> getDriverContacts() {
        return driverContacts;
    }

    public void setDriverContacts(List<DriverContact> driverContacts) {
        this.driverContacts = driverContacts;
    }
    
    
}
