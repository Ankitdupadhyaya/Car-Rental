package com.company.application.carrental.client.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class DriverMasterClientDto implements Serializable {

    private static final long serialVersionUID = 3899294987247027068L;

    private Integer applicationId;
    private String applicationNo;
    private Date applicationDate;
    private Integer applicationStatusId;
    private String applicationStatusName;
    private String applicationRemarks;
    private Integer userId;
    private String userName;

    private Integer driverId;
    private String driverFullName;
    private String primaryContactNumber;
    private Integer currentAreaId;
    private char gender;
    private Date dob;
    private String maritalStatus; // bc

    private String licenceNo;
    private String licenceType;
    private Date licenceExpiryDate;

    private boolean jobPrefIndividualTemp;
    private boolean jobPrefIndividualPerm;
    private boolean jobPrefIndividualAdhoc;
    private boolean jobPrefCorporateTemp;
    private boolean jobPrefCorporatePerm;
    private boolean jobPrefCorporateAdhoc;

    private Float totalExperience;
    private Float currentSalary; // app
    private Float expectedSalary; // app

    private String medicalHistory;
    private String eyeSight;
    private String diabetes;
    private String accidentHistory;

    private Character carTypeAutomatic;
    private Character carTypeManual;

    private Integer ratingId;

    private String referenceName;
    private String referenceNumber;

    private Set<DriverContact> driverContacts;
    private Set<DriverAddress> driverAddress;
    private Set<DriverEducation> driverEducation;
    private Set<DriverEducation> driverEmployment;

    public DriverMasterClientDto(){
    	super();
    }
    
    public DriverMasterClientDto(Integer driverId){
    	this.driverId = driverId;
    }
    
    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getApplicationStatusId() {
        return applicationStatusId;
    }

    public void setApplicationStatusId(Integer applicationStatusId) {
        this.applicationStatusId = applicationStatusId;
    }

    public String getApplicationStatusName() {
        return applicationStatusName;
    }

    public void setApplicationStatusName(String applicationStatusName) {
        this.applicationStatusName = applicationStatusName;
    }

    public String getApplicationRemarks() {
        return applicationRemarks;
    }

    public void setApplicationRemarks(String applicationRemarks) {
        this.applicationRemarks = applicationRemarks;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
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

    public boolean isJobPrefIndividualTemp() {
        return jobPrefIndividualTemp;
    }

    public void setJobPrefIndividualTemp(boolean jobPrefIndividualTemp) {
        this.jobPrefIndividualTemp = jobPrefIndividualTemp;
    }

    public boolean isJobPrefIndividualPerm() {
        return jobPrefIndividualPerm;
    }

    public void setJobPrefIndividualPerm(boolean jobPrefIndividualPerm) {
        this.jobPrefIndividualPerm = jobPrefIndividualPerm;
    }

    public boolean isJobPrefIndividualAdhoc() {
        return jobPrefIndividualAdhoc;
    }

    public void setJobPrefIndividualAdhoc(boolean jobPrefIndividualAdhoc) {
        this.jobPrefIndividualAdhoc = jobPrefIndividualAdhoc;
    }

    public boolean isJobPrefCorporateTemp() {
        return jobPrefCorporateTemp;
    }

    public void setJobPrefCorporateTemp(boolean jobPrefCorporateTemp) {
        this.jobPrefCorporateTemp = jobPrefCorporateTemp;
    }

    public boolean isJobPrefCorporatePerm() {
        return jobPrefCorporatePerm;
    }

    public void setJobPrefCorporatePerm(boolean jobPrefCorporatePerm) {
        this.jobPrefCorporatePerm = jobPrefCorporatePerm;
    }

    public boolean isJobPrefCorporateAdhoc() {
        return jobPrefCorporateAdhoc;
    }

    public void setJobPrefCorporateAdhoc(boolean jobPrefCorporateAdhoc) {
        this.jobPrefCorporateAdhoc = jobPrefCorporateAdhoc;
    }

    public Float getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Float totalExperience) {
        this.totalExperience = totalExperience;
    }

    public Float getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(Float currentSalary) {
        this.currentSalary = currentSalary;
    }

    public Float getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(Float expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getEyeSight() {
        return eyeSight;
    }

    public void setEyeSight(String eyeSight) {
        this.eyeSight = eyeSight;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public String getAccidentHistory() {
        return accidentHistory;
    }

    public void setAccidentHistory(String accidentHistory) {
        this.accidentHistory = accidentHistory;
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

    public Set<DriverContact> getDriverContacts() {
        return driverContacts;
    }

    public void setDriverContacts(Set<DriverContact> driverContacts) {
        this.driverContacts = driverContacts;
    }

    public Set<DriverAddress> getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(Set<DriverAddress> driverAddress) {
        this.driverAddress = driverAddress;
    }

    public Set<DriverEducation> getDriverEducation() {
        return driverEducation;
    }

    public void setDriverEducation(Set<DriverEducation> driverEducation) {
        this.driverEducation = driverEducation;
    }

    public Set<DriverEducation> getDriverEmployment() {
        return driverEmployment;
    }

    public void setDriverEmployment(Set<DriverEducation> driverEmployment) {
        this.driverEmployment = driverEmployment;
    }

    // private Set<DriverCarTypes> driverCarTypes;
    //
    // private Set<DriverDocumentsList> driverDocumentsLists;
}