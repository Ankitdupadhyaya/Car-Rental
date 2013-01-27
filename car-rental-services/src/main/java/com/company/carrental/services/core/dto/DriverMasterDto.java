package com.company.carrental.services.core.dto;

// default package
// Generated 17 Nov, 2012 7:41:40 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.Set;

import com.company.carrental.data.pojo.DriverContact;

/**
 * DriverMaster generated by hbm2java
 */
public class DriverMasterDto implements java.io.Serializable {

    private Integer driverId;
    private String driverFullName;
    private char gender;
    private Date dob;
    private Float totalExperience;
    private String primaryContactNumber;
    private Integer currentAreaId;
    private String licenceNo;
    private String licenceType;
    private Date licenceExpiryDate;
    private Character jobPrefIndividual;
    private Character jobPrefCorporate;
    private Character jobPrefTemporary;
    private Character jobPrefPermanent;
    private Character jobPrefAdhoc;
    private Character carTypeAutomatic;
    private Character carTypeManual;
    private Integer ratingId;
    private String referenceName;
    private String referenceNumber;
    private String medicalHistory;
    private String accidentHistory;
    private String eyeSight;
    private String Diabetes;


    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverFullName() {
        return driverFullName;
    }

    public void setDriverFullName(String driverFullName) {
        this.driverFullName = driverFullName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Float getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Float totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getPrimaryContactNumber() {
        return primaryContactNumber;
    }

    public void setPrimaryContactNumber(String primaryContactNumber) {
        this.primaryContactNumber = primaryContactNumber;
    }

    public Integer getCurrentAreaId() {
        return currentAreaId;
    }

    public void setCurrentAreaId(Integer currentAreaId) {
        this.currentAreaId = currentAreaId;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public Date getLicenceExpiryDate() {
        return licenceExpiryDate;
    }

    public void setLicenceExpiryDate(Date licenceExpiryDate) {
        this.licenceExpiryDate = licenceExpiryDate;
    }

    public Character getJobPrefIndividual() {
        return jobPrefIndividual;
    }

    public void setJobPrefIndividual(Character jobPrefIndividual) {
        this.jobPrefIndividual = jobPrefIndividual;
    }

    public Character getJobPrefCorporate() {
        return jobPrefCorporate;
    }

    public void setJobPrefCorporate(Character jobPrefCorporate) {
        this.jobPrefCorporate = jobPrefCorporate;
    }

    public Character getJobPrefTemporary() {
        return jobPrefTemporary;
    }

    public void setJobPrefTemporary(Character jobPrefTemporary) {
        this.jobPrefTemporary = jobPrefTemporary;
    }

    public Character getJobPrefPermanent() {
        return jobPrefPermanent;
    }

    public void setJobPrefPermanent(Character jobPrefPermanent) {
        this.jobPrefPermanent = jobPrefPermanent;
    }

    public Character getJobPrefAdhoc() {
        return jobPrefAdhoc;
    }

    public void setJobPrefAdhoc(Character jobPrefAdhoc) {
        this.jobPrefAdhoc = jobPrefAdhoc;
    }

    public Character getCarTypeAutomatic() {
        return carTypeAutomatic;
    }

    public void setCarTypeAutomatic(Character carTypeAutomatic) {
        this.carTypeAutomatic = carTypeAutomatic;
    }

    public Character getCarTypeManual() {
        return carTypeManual;
    }

    public void setCarTypeManual(Character carTypeManual) {
        this.carTypeManual = carTypeManual;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAccidentHistory() {
        return accidentHistory;
    }

    public void setAccidentHistory(String accidentHistory) {
        this.accidentHistory = accidentHistory;
    }

   public String getEyeSight() {
        return eyeSight;
    }

    public void setEyeSight(String eyeSight) {
        this.eyeSight = eyeSight;
    }

    public String getDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(String diabetes) {
        Diabetes = diabetes;
    }
    
}
