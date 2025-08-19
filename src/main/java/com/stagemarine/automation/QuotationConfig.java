package com.stagemarine.automation;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for quotation automation
 */
public class QuotationConfig {
    
    // Different quotation scenarios
    public enum QuotationType {
        MARINE_SERVICES("Marine Services"),
        EQUIPMENT_RENTAL("Equipment Rental"),
        CONSULTING("Consulting Services"),
        MAINTENANCE("Maintenance Services"),
        TRANSPORT("Transport Services");
        
        private final String displayName;
        
        QuotationType(String displayName) {
            this.displayName = displayName;
        }
        
        public String getDisplayName() {
            return displayName;
        }
    }
    
    // Form field mappings for different scenarios
    private static final Map<QuotationType, Map<String, String>> FIELD_MAPPINGS = new HashMap<>();
    
    static {
        // Marine Services
        Map<String, String> marineServices = new HashMap<>();
        marineServices.put("service_type", "Marine Services");
        marineServices.put("description", "Comprehensive marine services including vessel maintenance, safety inspections, and operational support");
        marineServices.put("budget", "75000");
        marineServices.put("duration", "3 months");
        marineServices.put("location", "Dubai Port");
        FIELD_MAPPINGS.put(QuotationType.MARINE_SERVICES, marineServices);
        
        // Equipment Rental
        Map<String, String> equipmentRental = new HashMap<>();
        equipmentRental.put("service_type", "Equipment Rental");
        equipmentRental.put("description", "Rental of marine equipment including cranes, winches, and safety equipment");
        equipmentRental.put("budget", "25000");
        equipmentRental.put("duration", "1 month");
        equipmentRental.put("equipment_list", "Crane, Winch, Safety Equipment");
        FIELD_MAPPINGS.put(QuotationType.EQUIPMENT_RENTAL, equipmentRental);
        
        // Consulting
        Map<String, String> consulting = new HashMap<>();
        consulting.put("service_type", "Consulting Services");
        consulting.put("description", "Marine industry consulting including regulatory compliance, safety protocols, and operational efficiency");
        consulting.put("budget", "15000");
        consulting.put("duration", "2 weeks");
        consulting.put("consultant_level", "Senior");
        FIELD_MAPPINGS.put(QuotationType.CONSULTING, consulting);
        
        // Maintenance
        Map<String, String> maintenance = new HashMap<>();
        maintenance.put("service_type", "Maintenance Services");
        maintenance.put("description", "Preventive and corrective maintenance for marine vessels and equipment");
        maintenance.put("budget", "45000");
        maintenance.put("duration", "6 months");
        maintenance.put("maintenance_type", "Preventive");
        FIELD_MAPPINGS.put(QuotationType.MAINTENANCE, maintenance);
        
        // Transport
        Map<String, String> transport = new HashMap<>();
        transport.put("service_type", "Transport Services");
        transport.put("description", "Marine transport services including cargo handling and vessel movement");
        transport.put("budget", "60000");
        transport.put("duration", "4 months");
        transport.put("cargo_type", "General Cargo");
        FIELD_MAPPINGS.put(QuotationType.TRANSPORT, transport);
    }
    
    // Customer information templates
    private static final Map<String, String> CUSTOMER_TEMPLATES = new HashMap<>();
    
    static {
        CUSTOMER_TEMPLATES.put("individual", "John Doe");
        CUSTOMER_TEMPLATES.put("company", "Test Company Ltd");
        CUSTOMER_TEMPLATES.put("email", "john.doe@example.com");
        CUSTOMER_TEMPLATES.put("phone", "+971501234567");
        CUSTOMER_TEMPLATES.put("address", "123 Test Street, Dubai, UAE");
        CUSTOMER_TEMPLATES.put("country", "UAE");
        CUSTOMER_TEMPLATES.put("city", "Dubai");
        CUSTOMER_TEMPLATES.put("postal_code", "12345");
    }
    
    // Form field selectors for common elements
    private static final Map<String, String> FORM_SELECTORS = new HashMap<>();
    
    static {
        FORM_SELECTORS.put("name_input", "input[name*='name'], input[id*='name'], input[placeholder*='name']");
        FORM_SELECTORS.put("email_input", "input[type='email'], input[name*='email'], input[id*='email']");
        FORM_SELECTORS.put("phone_input", "input[type='tel'], input[name*='phone'], input[id*='phone']");
        FORM_SELECTORS.put("company_input", "input[name*='company'], input[id*='company'], input[placeholder*='company']");
        FORM_SELECTORS.put("address_input", "input[name*='address'], textarea[name*='address'], input[id*='address']");
        FORM_SELECTORS.put("description_input", "textarea[name*='description'], textarea[id*='description'], input[name*='description']");
        FORM_SELECTORS.put("budget_input", "input[type='number'], input[name*='budget'], input[id*='budget']");
        FORM_SELECTORS.put("submit_button", "input[type='submit'], button[type='submit'], button:contains('Submit'), button:contains('Send')");
    }
    
    // Wait timeouts
    public static final int PAGE_LOAD_TIMEOUT = 30;
    public static final int ELEMENT_WAIT_TIMEOUT = 20;
    public static final int SHORT_WAIT = 5;
    
    // Retry attempts
    public static final int MAX_RETRY_ATTEMPTS = 3;
    public static final int RETRY_DELAY_MS = 1000;
    
    /**
     * Get field mappings for a specific quotation type
     */
    public static Map<String, String> getFieldMappings(QuotationType type) {
        return FIELD_MAPPINGS.getOrDefault(type, new HashMap<>());
    }
    
    /**
     * Get customer template information
     */
    public static Map<String, String> getCustomerTemplates() {
        return new HashMap<>(CUSTOMER_TEMPLATES);
    }
    
    /**
     * Get form selectors
     */
    public static Map<String, String> getFormSelectors() {
        return new HashMap<>(FORM_SELECTORS);
    }
    
    /**
     * Get a specific form selector
     */
    public static String getFormSelector(String key) {
        return FORM_SELECTORS.get(key);
    }
    
    /**
     * Get all quotation types
     */
    public static QuotationType[] getAllQuotationTypes() {
        return QuotationType.values();
    }
    
    /**
     * Get quotation type by display name
     */
    public static QuotationType getQuotationTypeByDisplayName(String displayName) {
        for (QuotationType type : QuotationType.values()) {
            if (type.getDisplayName().equalsIgnoreCase(displayName)) {
                return type;
            }
        }
        return QuotationType.MARINE_SERVICES; // Default
    }
    
    /**
     * Get default quotation type
     */
    public static QuotationType getDefaultQuotationType() {
        return QuotationType.MARINE_SERVICES;
    }
    
    /**
     * Check if a field should be filled based on its attributes
     */
    public static boolean shouldFillField(String fieldName, String fieldId, String fieldType) {
        if (fieldName == null && fieldId == null) {
            return false;
        }
        
        String field = (fieldName != null) ? fieldName.toLowerCase() : fieldId.toLowerCase();
        
        // Skip hidden fields, submit buttons, etc.
        if (fieldType != null) {
            if (fieldType.equals("hidden") || fieldType.equals("submit") || fieldType.equals("button")) {
                return false;
            }
        }
        
        // Skip fields that are typically not user-filled
        String[] skipFields = {"csrf", "token", "captcha", "recaptcha", "g-recaptcha"};
        for (String skipField : skipFields) {
            if (field.contains(skipField)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Get appropriate value for a field based on quotation type
     */
    public static String getFieldValue(QuotationType quotationType, String fieldName, String fieldId) {
        Map<String, String> mappings = getFieldMappings(quotationType);
        
        // First try to get from quotation type specific mappings
        if (fieldName != null && mappings.containsKey(fieldName)) {
            return mappings.get(fieldName);
        }
        
        if (fieldId != null && mappings.containsKey(fieldId)) {
            return mappings.get(fieldId);
        }
        
        // Fall back to customer templates
        Map<String, String> customerTemplates = getCustomerTemplates();
        if (fieldName != null) {
            String lowerFieldName = fieldName.toLowerCase();
            for (String templateKey : customerTemplates.keySet()) {
                if (lowerFieldName.contains(templateKey)) {
                    return customerTemplates.get(templateKey);
                }
            }
        }
        
        if (fieldId != null) {
            String lowerFieldId = fieldId.toLowerCase();
            for (String templateKey : customerTemplates.keySet()) {
                if (lowerFieldId.contains(templateKey)) {
                    return customerTemplates.get(templateKey);
                }
            }
        }
        
        // Default values
        return getDefaultValue(fieldName, fieldId);
    }
    
    /**
     * Get default value for a field
     */
    private static String getDefaultValue(String fieldName, String fieldId) {
        if (fieldName != null) {
            String lowerFieldName = fieldName.toLowerCase();
            if (lowerFieldName.contains("quantity")) return "1";
            if (lowerFieldName.contains("amount")) return "1000";
            if (lowerFieldName.contains("duration")) return "1 month";
            if (lowerFieldName.contains("priority")) return "Medium";
        }
        
        if (fieldId != null) {
            String lowerFieldId = fieldId.toLowerCase();
            if (lowerFieldId.contains("quantity")) return "1";
            if (lowerFieldId.contains("amount")) return "1000";
            if (lowerFieldId.contains("duration")) return "1 month";
            if (lowerFieldId.contains("priority")) return "Medium";
        }
        
        return "Sample Data";
    }
}