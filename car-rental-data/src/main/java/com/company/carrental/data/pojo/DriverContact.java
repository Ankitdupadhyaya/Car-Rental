package com.company.carrental.data.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Driver_Contact")
public class DriverContact {
    private Integer driverContactId;
//     private Integer contactType;
    private String contactNumber;
    private Boolean isPrimary;
    private ContactTypeMaster contactTypeMaster;
    private DriverMaster driverMaster;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Driver_Contact_Id", nullable = false)
    public Integer getDriverContactId() {
        return driverContactId;
    }

    public void setDriverContactId(Integer driverContactId) {
        this.driverContactId = driverContactId;
    }

//     @Column(name = "Contact_Type")
//     public Integer getContactType() {
//     return contactType;
//     }
//    
//     public void setContactType(Integer contactType) {
//     this.contactType = contactType;
//     }

    @Column(name = "Contact_Number")
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Column(name = "Is_Primary")
    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

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
    @JoinColumn(name = "Contact_Type_Id", nullable = false)
    public ContactTypeMaster getContactTypeMaster() {
        return contactTypeMaster;
    }

    public void setContactTypeMaster(ContactTypeMaster contactTypeMaster) {
        this.contactTypeMaster = contactTypeMaster;
    }

}
