package com.stagemarine.automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestNG test class for quotation automation
 */
public class QuotationAutomationTest {
    
    private static final Logger logger = LoggerFactory.getLogger(QuotationAutomationTest.class);
    private QuotationAutomation automation;
    
    @BeforeMethod
    public void setUp() {
        logger.info("Setting up quotation automation test...");
        automation = new QuotationAutomation();
    }
    
    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down quotation automation test...");
        if (automation != null) {
            automation.closeBrowser();
        }
    }
    
    @Test(description = "Test complete quotation automation process")
    public void testCompleteQuotationProcess() {
        logger.info("Starting complete quotation automation test...");
        
        try {
            // Start the quotation process
            automation.startQuotationProcess();
            
            // Get the results
            QuotationData results = automation.getQuotationData();
            
            // Verify that the process completed
            Assert.assertNotNull(results, "Quotation data should not be null");
            
            // Log the results
            logger.info("Quotation automation test completed successfully");
            logger.info("Results: {}", results.getSummary());
            
            // Basic assertions
            Assert.assertTrue(results.getQuotationDate() != null, "Quotation date should be set");
            
        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage(), e);
            Assert.fail("Quotation automation test failed: " + e.getMessage());
        }
    }
    
    @Test(description = "Test quotation form filling")
    public void testQuotationFormFilling() {
        logger.info("Starting quotation form filling test...");
        
        try {
            // Navigate to the page
            automation.getDriver().get("https://stagemarine.oicgulf.ae/quote/");
            
            // Wait for page to load
            Thread.sleep(3000);
            
            // Check if page loaded successfully
            String pageTitle = automation.getDriver().getTitle();
            Assert.assertNotNull(pageTitle, "Page title should not be null");
            
            logger.info("Page loaded successfully with title: {}", pageTitle);
            
        } catch (Exception e) {
            logger.error("Form filling test failed: " + e.getMessage(), e);
            Assert.fail("Form filling test failed: " + e.getMessage());
        }
    }
    
    @Test(description = "Test different quotation types")
    public void testDifferentQuotationTypes() {
        logger.info("Starting different quotation types test...");
        
        try {
            QuotationConfig.QuotationType[] types = QuotationConfig.getAllQuotationTypes();
            
            for (QuotationConfig.QuotationType type : types) {
                logger.info("Testing quotation type: {}", type.getDisplayName());
                
                // Get field mappings for this type
                var mappings = QuotationConfig.getFieldMappings(type);
                Assert.assertFalse(mappings.isEmpty(), "Field mappings should not be empty for " + type);
                
                logger.info("Field mappings for {}: {}", type.getDisplayName(), mappings);
            }
            
            logger.info("Different quotation types test completed successfully");
            
        } catch (Exception e) {
            logger.error("Different quotation types test failed: " + e.getMessage(), e);
            Assert.fail("Different quotation types test failed: " + e.getMessage());
        }
    }
    
    @Test(description = "Test customer template data")
    public void testCustomerTemplateData() {
        logger.info("Starting customer template data test...");
        
        try {
            var templates = QuotationConfig.getCustomerTemplates();
            Assert.assertFalse(templates.isEmpty(), "Customer templates should not be empty");
            
            // Verify key templates exist
            Assert.assertTrue(templates.containsKey("name"), "Name template should exist");
            Assert.assertTrue(templates.containsKey("email"), "Email template should exist");
            Assert.assertTrue(templates.containsKey("phone"), "Phone template should exist");
            
            logger.info("Customer template data test completed successfully");
            logger.info("Available templates: {}", templates.keySet());
            
        } catch (Exception e) {
            logger.error("Customer template data test failed: " + e.getMessage(), e);
            Assert.fail("Customer template data test failed: " + e.getMessage());
        }
    }
}