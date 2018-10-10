package com.mortgagekaki.loanapi.models;

import java.math.BigDecimal;
import java.util.List;

public class LoanEnquiry {

    private String name;

    private String email;

    private String mobile;

    private String packageName;

    private String currentBank;

    private List<BigDecimal> interests;

    private BigDecimal purchasePrice;

    private int duration;

    private String lockIn;

    private LoanType loanType;

    private PackageType type;

    private String propertyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getCurrentBank() {
        return currentBank;
    }

    public void setCurrentBank(String currentBank) {
        this.currentBank = currentBank;
    }

    public List<BigDecimal> getInterests() {
        return interests;
    }

    public void setInterests(List<BigDecimal> interests) {
        this.interests = interests;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLockIn() {
        return lockIn;
    }

    public void setLockIn(String lockIn) {
        this.lockIn = lockIn;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public PackageType getType() {
        return type;
    }

    public void setType(PackageType type) {
        this.type = type;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

}
