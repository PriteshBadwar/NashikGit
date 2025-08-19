package com.stagemarine.automation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class to run the Stage Marine quotation automation
 */
public class Main {
    
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        logger.info("Starting Stage Marine Quotation Automation...");
        
        try {
            // Create and run the automation
            QuotationAutomation automation = new QuotationAutomation();
            
            // Start the quotation process
            automation.startQuotationProcess();
            
            // Get the results
            QuotationData results = automation.getQuotationData();
            
            // Display results
            System.out.println("\n" + results.getSummary());
            
            // Keep browser open for manual verification
            logger.info("Automation completed. Browser will remain open for manual verification.");
            logger.info("Press Enter to close the browser...");
            
            // Wait for user input before closing
            System.in.read();
            
            // Close the browser
            automation.closeBrowser();
            
        } catch (Exception e) {
            logger.error("Error in main method: " + e.getMessage(), e);
            System.err.println("Automation failed: " + e.getMessage());
        }
        
        logger.info("Stage Marine Quotation Automation completed.");
    }
}