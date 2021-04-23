/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Child;

import java.util.Date;

/**
 *
 * @author Kunjan
 */
public class Child {

    int childId;
    String name;
    int childAge;
    String status;
    String imageDetails;
    String identificationMark;
    String gender;
    private static int count = 1;
    Date registrationDate;
    String medicalStatus;
    private double BP;
    private double pulseRate;
    private double respirationRate;
    private double bodytemp;
    private boolean financialHelp;
    private String amt;
    private boolean medicalHelp;
    private boolean isSpecialChild;

    public double getBP() {
        return BP;
    }

    public void setBP(double BP) {
        this.BP = BP;
    }

    public double getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(double pulseRate) {
        this.pulseRate = pulseRate;
    }

    public double getRespirationRate() {
        return respirationRate;
    }

    public void setRespirationRate(double respirationRate) {
        this.respirationRate = respirationRate;
    }

    public double getBodytemp() {
        return bodytemp;
    }

    public void setBodytemp(double bodytemp) {
        this.bodytemp = bodytemp;
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Child.count = count;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getIdentificationMark() {
        return identificationMark;
    }

    public void setIdentificationMark(String identificationMark) {
        this.identificationMark = identificationMark;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildAge() {
        return childAge;
    }

    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageDetails() {
        return imageDetails;
    }

    public void setImageDetails(String imageDetails) {
        this.imageDetails = imageDetails;
    }

    public boolean isFinancialHelp() {
        return financialHelp;
    }

    public void setFinancialHelp(boolean financialHelp) {
        this.financialHelp = financialHelp;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public boolean isMedicalHelp() {
        return medicalHelp;
    }

    public void setMedicalHelp(boolean medicalHelp) {
        this.medicalHelp = medicalHelp;
    }

    public boolean isIsSpecialChild() {
        return isSpecialChild;
    }

    public void setIsSpecialChild(boolean isSpecialChild) {
        this.isSpecialChild = isSpecialChild;
    }

    @Override
    public String toString() {
        return String.valueOf(childId);
    }
}
