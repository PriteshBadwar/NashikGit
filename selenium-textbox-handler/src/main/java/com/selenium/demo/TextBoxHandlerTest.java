package com.selenium.demo;

import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Test class to demonstrate different scenarios of using TextBoxHandler
 */
public class TextBoxHandlerTest {
    
    /**
     * Test method to demonstrate finding and populating text boxes on a specific website
     */
    public static void testSpecificWebsite() {
        System.out.println("=== Testing Specific Website ===");
        TextBoxHandler handler = new TextBoxHandler();
        
        try {
            // Navigate to a website with multiple text boxes
            handler.navigateToWebsite("https://www.google.com");
            
            // Find all text boxes
            List<WebElement> textBoxes = handler.findTextBoxes();
            
            if (textBoxes != null && !textBoxes.isEmpty()) {
                // Populate first text box
                handler.populateTextBoxByIndex(textBoxes, 0, "Selenium WebDriver Test");
                
                // Wait a moment
                Thread.sleep(2000);
                
                // Populate second text box if it exists
                if (textBoxes.size() > 1) {
                    handler.populateTextBoxByIndex(textBoxes, 1, "Second Text Box");
                }
                
                // Show final states
                handler.printTextBoxStates(textBoxes);
                
                Thread.sleep(2000);
            }
            
        } catch (Exception e) {
            System.err.println("Error in testSpecificWebsite: " + e.getMessage());
        } finally {
            handler.cleanup();
        }
    }
    
    /**
     * Test method to demonstrate populating text boxes with form data
     */
    public static void testFormDataPopulation() {
        System.out.println("=== Testing Form Data Population ===");
        TextBoxHandler handler = new TextBoxHandler();
        
        try {
            // Navigate to a form page (you can change this URL)
            handler.navigateToWebsite("https://www.google.com");
            
            List<WebElement> textBoxes = handler.findTextBoxes();
            
            if (textBoxes != null && !textBoxes.isEmpty()) {
                // Define form data
                String[] formData = {
                    "John Doe",
                    "john.doe@email.com",
                    "Software Engineer",
                    "123 Main Street"
                };
                
                // Populate each text box with form data
                for (int i = 0; i < textBoxes.size() && i < formData.length; i++) {
                    handler.populateTextBoxByIndex(textBoxes, i, formData[i]);
                    Thread.sleep(1000); // Wait between each population
                }
                
                // Verify all data was entered correctly
                System.out.println("\n=== Form Data Verification ===");
                for (int i = 0; i < textBoxes.size() && i < formData.length; i++) {
                    String currentValue = handler.getTextBoxValue(textBoxes, i);
                    String expectedValue = formData[i];
                    
                    if (expectedValue.equals(currentValue)) {
                        System.out.println("✓ Index " + i + ": Data verified successfully");
                    } else {
                        System.out.println("✗ Index " + i + ": Data verification failed");
                        System.out.println("  Expected: '" + expectedValue + "'");
                        System.out.println("  Got: '" + currentValue + "'");
                    }
                }
                
                Thread.sleep(3000);
            }
            
        } catch (Exception e) {
            System.err.println("Error in testFormDataPopulation: " + e.getMessage());
        } finally {
            handler.cleanup();
        }
    }
    
    /**
     * Test method to demonstrate error handling and edge cases
     */
    public static void testErrorHandling() {
        System.out.println("=== Testing Error Handling ===");
        TextBoxHandler handler = new TextBoxHandler();
        
        try {
            handler.navigateToWebsite("https://www.google.com");
            List<WebElement> textBoxes = handler.findTextBoxes();
            
            if (textBoxes != null && !textBoxes.isEmpty()) {
                // Test invalid index
                handler.populateTextBoxByIndex(textBoxes, -1, "Invalid Index");
                handler.populateTextBoxByIndex(textBoxes, 999, "Out of Range Index");
                
                // Test null text
                handler.populateTextBoxByIndex(textBoxes, 0, null);
                
                // Test empty text
                handler.populateTextBoxByIndex(textBoxes, 0, "");
                
                // Test special characters
                handler.populateTextBoxByIndex(textBoxes, 0, "Special chars: !@#$%^&*()_+-=[]{}|;':\",./<>?");
                
                Thread.sleep(2000);
            }
            
        } catch (Exception e) {
            System.err.println("Error in testErrorHandling: " + e.getMessage());
        } finally {
            handler.cleanup();
        }
    }
    
    /**
     * Test method to demonstrate batch operations
     */
    public static void testBatchOperations() {
        System.out.println("=== Testing Batch Operations ===");
        TextBoxHandler handler = new TextBoxHandler();
        
        try {
            handler.navigateToWebsite("https://www.google.com");
            List<WebElement> textBoxes = handler.findTextBoxes();
            
            if (textBoxes != null && !textBoxes.isEmpty()) {
                // Populate all text boxes at once
                handler.populateAllTextBoxes(textBoxes);
                
                // Show the results
                handler.printTextBoxStates(textBoxes);
                
                Thread.sleep(3000);
            }
            
        } catch (Exception e) {
            System.err.println("Error in testBatchOperations: " + e.getMessage());
        } finally {
            handler.cleanup();
        }
    }
    
    /**
     * Main method to run all tests
     */
    public static void main(String[] args) {
        System.out.println("Starting TextBoxHandler Tests...\n");
        
        try {
            // Run different test scenarios
            testSpecificWebsite();
            Thread.sleep(1000);
            
            testFormDataPopulation();
            Thread.sleep(1000);
            
            testErrorHandling();
            Thread.sleep(1000);
            
            testBatchOperations();
            
        } catch (Exception e) {
            System.err.println("Error running tests: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\nAll tests completed!");
    }
}