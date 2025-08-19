package com.stagemarine.automation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Data class to store quotation information and results
 */
public class QuotationData {
    
    private String quotationNumber;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String companyName;
    private String serviceType;
    private String description;
    private Double amount;
    private String currency;
    private LocalDateTime quotationDate;
    private LocalDateTime expiryDate;
    private String status;
    private boolean quotationGenerated;
    private String pageSource;
    private Map<String, String> additionalFields;
    private String errorMessage;
    
    public QuotationData() {
        this.additionalFields = new HashMap<>();
        this.quotationDate = LocalDateTime.now();
        this.quotationGenerated = false;
    }
    
    // Getters and Setters
    public String getQuotationNumber() {
        return quotationNumber;
    }
    
    public void setQuotationNumber(String quotationNumber) {
        this.quotationNumber = quotationNumber;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerEmail() {
        return customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    public String getCustomerPhone() {
        return customerPhone;
    }
    
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getServiceType() {
        return serviceType;
    }
    
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public LocalDateTime getQuotationDate() {
        return quotationDate;
    }
    
    public void setQuotationDate(LocalDateTime quotationDate) {
        this.quotationDate = quotationDate;
    }
    
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean isQuotationGenerated() {
        return quotationGenerated;
    }
    
    public void setQuotationGenerated(boolean quotationGenerated) {
        this.quotationGenerated = quotationGenerated;
    }
    
    public String getPageSource() {
        return pageSource;
    }
    
    public void setPageSource(String pageSource) {
        this.pageSource = pageSource;
    }
    
    public Map<String, String> getAdditionalFields() {
        return additionalFields;
    }
    
    public void setAdditionalFields(Map<String, String> additionalFields) {
        this.additionalFields = additionalFields;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    /**
     * Add an additional field to the quotation data
     */
    public void addAdditionalField(String key, String value) {
        this.additionalFields.put(key, value);
    }
    
    /**
     * Get an additional field value
     */
    public String getAdditionalField(String key) {
        return this.additionalFields.get(key);
    }
    
    /**
     * Check if quotation data is complete
     */
    public boolean isComplete() {
        return quotationNumber != null && 
               customerName != null && 
               customerEmail != null && 
               amount != null;
    }
    
    /**
     * Generate a summary of the quotation data
     */
    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Quotation Summary:\n");
        summary.append("================\n");
        
        if (quotationNumber != null) {
            summary.append("Quotation Number: ").append(quotationNumber).append("\n");
        }
        
        if (customerName != null) {
            summary.append("Customer Name: ").append(customerName).append("\n");
        }
        
        if (customerEmail != null) {
            summary.append("Customer Email: ").append(customerEmail).append("\n");
        }
        
        if (companyName != null) {
            summary.append("Company: ").append(companyName).append("\n");
        }
        
        if (serviceType != null) {
            summary.append("Service Type: ").append(serviceType).append("\n");
        }
        
        if (amount != null) {
            summary.append("Amount: ").append(amount);
            if (currency != null) {
                summary.append(" ").append(currency);
            }
            summary.append("\n");
        }
        
        if (quotationDate != null) {
            summary.append("Quotation Date: ").append(quotationDate).append("\n");
        }
        
        if (status != null) {
            summary.append("Status: ").append(status).append("\n");
        }
        
        summary.append("Quotation Generated: ").append(quotationGenerated ? "Yes" : "No").append("\n");
        
        if (errorMessage != null) {
            summary.append("Error: ").append(errorMessage).append("\n");
        }
        
        return summary.toString();
    }
    
    @Override
    public String toString() {
        return getSummary();
    }
}