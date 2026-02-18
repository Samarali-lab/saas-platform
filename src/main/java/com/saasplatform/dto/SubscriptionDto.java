package com.saasplatform.dto;

public class SubscriptionDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer billingCycleDays;
    private String planType;
    private Integer maxUsers;
    private Integer maxProjects;
    private Integer storageGB;
    private Boolean apiAccess;
    private Boolean prioritySupport;
    private Boolean customDomain;
    private String status;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBillingCycleDays() {
        return billingCycleDays;
    }

    public void setBillingCycleDays(Integer billingCycleDays) {
        this.billingCycleDays = billingCycleDays;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getMaxProjects() {
        return maxProjects;
    }

    public void setMaxProjects(Integer maxProjects) {
        this.maxProjects = maxProjects;
    }

    public Integer getStorageGB() {
        return storageGB;
    }

    public void setStorageGB(Integer storageGB) {
        this.storageGB = storageGB;
    }

    public Boolean getApiAccess() {
        return apiAccess;
    }

    public void setApiAccess(Boolean apiAccess) {
        this.apiAccess = apiAccess;
    }

    public Boolean getPrioritySupport() {
        return prioritySupport;
    }

    public void setPrioritySupport(Boolean prioritySupport) {
        this.prioritySupport = prioritySupport;
    }

    public Boolean getCustomDomain() {
        return customDomain;
    }

    public void setCustomDomain(Boolean customDomain) {
        this.customDomain = customDomain;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}