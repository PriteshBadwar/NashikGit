package com.selenium.demo;

import org.openqa.selenium.WebElement;
import java.io.File;
import java.util.List;

/**
 * Example class to test the local HTML test page
 */
public class LocalTestExample {
    
    private TextBoxHandler handler;
    private TextBoxUtils utils;
    
    public LocalTestExample() {
        this.handler = new TextBoxHandler();
        this.utils = new TextBoxUtils(handler.getDriver());
    }
    
    /**
     * Test the local HTML file with multiple text boxes
     */
    public void testLocalHTMLFile() {
        System.out.println("=== TESTING LOCAL HTML FILE ===\n");
        
        try {
            // Get the absolute path to the test HTML file
            String currentDir = System.getProperty("user.dir");
            String htmlFilePath = currentDir + "/test-page.html";
            File htmlFile = new File(htmlFilePath);
            
            if (!htmlFile.exists()) {
                System.err.println("Test HTML file not found at: " + htmlFilePath);
                System.out.println("Please ensure the test-page.html file is in the project root directory.");
                return;
            }
            
            // Convert to file:// URL
            String fileUrl = "file://" + htmlFile.getAbsolutePath();
            System.out.println("Loading local HTML file: " + fileUrl);
            
            // Navigate to the local HTML file
            handler.navigateToWebsite(fileUrl);
            Thread.sleep(2000); // Wait for page to load
            
            // Find all text boxes
            System.out.println("\nFinding all text boxes...");
            List<WebElement> textBoxes = handler.findTextBoxes();
            
            if (textBoxes == null || textBoxes.isEmpty()) {
                System.out.println("No text boxes found on the local page.");
                return;
            }
            
            System.out.println("Found " + textBoxes.size() + " text boxes on the local page.");
            
            // Display detailed information about each text box
            System.out.println("\n=== TEXT BOX DETAILS ===");
            for (int i = 0; i < textBoxes.size(); i++) {
                WebElement textBox = textBoxes.get(i);
                utils.printTextBoxProperties(textBox, i);
            }
            
            // Populate each text box with sample data
            System.out.println("\n=== POPULATING TEXT BOXES ===");
            String[] sampleData = {
                "John",
                "Doe",
                "john.doe@example.com",
                "+1-555-123-4567",
                "123 Main Street",
                "New York",
                "NY",
                "This is a test note for the textarea field."
            };
            
            for (int i = 0; i < textBoxes.size() && i < sampleData.length; i++) {
                System.out.println("Populating text box at index " + i + " with: '" + sampleData[i] + "'");
                handler.populateTextBoxByIndex(textBoxes, i, sampleData[i]);
                
                // Verify the text was entered
                String currentValue = handler.getTextBoxValue(textBoxes, i);
                boolean success = sampleData[i].equals(currentValue);
                System.out.println("  ✓ Text entered successfully: " + success);
                
                Thread.sleep(500); // Small delay between operations
            }
            
            // Show final states
            System.out.println("\n=== FINAL TEXT BOX STATES ===");
            handler.printTextBoxStates(textBoxes);
            
            // Demonstrate validation
            System.out.println("\n=== INPUT VALIDATION ===");
            for (int i = 0; i < textBoxes.size(); i++) {
                WebElement textBox = textBoxes.get(i);
                String currentValue = handler.getTextBoxValue(textBoxes, i);
                
                if (currentValue != null && !currentValue.isEmpty()) {
                    System.out.println("Text Box " + i + " validation:");
                    System.out.println("  - Value: '" + currentValue + "'");
                    System.out.println("  - Is Empty: " + utils.isTextBoxEmpty(textBox));
                    System.out.println("  - Text Length: " + utils.getTextBoxTextLength(textBox));
                    
                    // Validate email format for index 2 (email field)
                    if (i == 2) {
                        boolean isValidEmail = utils.validateTextBoxInput(textBox, "email");
                        System.out.println("  - Email Format Valid: " + isValidEmail);
                    }
                    
                    // Validate if it's required (non-empty)
                    boolean isRequired = utils.validateTextBoxInput(textBox, "required");
                    System.out.println("  - Required Field Valid: " + isRequired);
                }
            }
            
            // Wait to see the results
            System.out.println("\nWaiting 5 seconds to show the populated form...");
            Thread.sleep(5000);
            
            // Clear all text boxes
            System.out.println("\n=== CLEARING ALL TEXT BOXES ===");
            utils.clearAllTextBoxes(textBoxes);
            
            // Verify clearing
            System.out.println("\n=== VERIFYING CLEARED STATE ===");
            handler.printTextBoxStates(textBoxes);
            
            System.out.println("\n=== LOCAL HTML TEST COMPLETED SUCCESSFULLY ===");
            
        } catch (Exception e) {
            System.err.println("Error testing local HTML file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up resources
            handler.cleanup();
        }
    }
    
    /**
     * Main method to run the local test
     */
    public static void main(String[] args) {
        LocalTestExample localTest = new LocalTestExample();
        localTest.testLocalHTMLFile();
    }
}