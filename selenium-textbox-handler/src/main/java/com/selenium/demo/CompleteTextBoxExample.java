package com.selenium.demo;

import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Complete example demonstrating the full workflow of finding text boxes by indexing
 * and populating them individually using Selenium WebDriver
 */
public class CompleteTextBoxExample {
    
    private TextBoxHandler handler;
    private TextBoxUtils utils;
    
    /**
     * Constructor to initialize the handler and utilities
     */
    public CompleteTextBoxExample() {
        this.handler = new TextBoxHandler();
        this.utils = new TextBoxUtils(handler.getDriver());
    }
    
    /**
     * Complete workflow demonstration
     */
    public void demonstrateCompleteWorkflow() {
        System.out.println("=== COMPLETE TEXT BOX WORKFLOW DEMONSTRATION ===\n");
        
        try {
            // Step 1: Navigate to the target website
            System.out.println("Step 1: Navigating to website...");
            handler.navigateToWebsite("https://www.google.com");
            Thread.sleep(2000);
            
            // Step 2: Find all text boxes and get their indexing
            System.out.println("\nStep 2: Finding all text boxes and getting indexing...");
            List<WebElement> allTextBoxes = handler.findTextBoxes();
            
            if (allTextBoxes == null || allTextBoxes.isEmpty()) {
                System.out.println("No text boxes found on the page. Exiting...");
                return;
            }
            
            // Step 3: Display detailed information about each text box
            System.out.println("\nStep 3: Displaying detailed text box information...");
            for (int i = 0; i < allTextBoxes.size(); i++) {
                WebElement textBox = allTextBoxes.get(i);
                utils.printTextBoxProperties(textBox, i);
            }
            
            // Step 4: Get only visible and enabled text boxes
            System.out.println("\nStep 4: Filtering visible and enabled text boxes...");
            List<WebElement> visibleTextBoxes = utils.getVisibleAndEnabledTextBoxes(allTextBoxes);
            
            if (visibleTextBoxes.isEmpty()) {
                System.out.println("No visible and enabled text boxes found. Exiting...");
                return;
            }
            
            // Step 5: Populate each text box individually by index
            System.out.println("\nStep 5: Populating text boxes individually by index...");
            String[] sampleData = {
                "First Name: John",
                "Last Name: Doe",
                "Email: john.doe@example.com",
                "Phone: +1-555-123-4567",
                "Address: 123 Main Street",
                "City: New York",
                "State: NY",
                "Zip Code: 10001"
            };
            
            for (int i = 0; i < visibleTextBoxes.size() && i < sampleData.length; i++) {
                System.out.println("Populating text box at index " + i + "...");
                handler.populateTextBoxByIndex(visibleTextBoxes, i, sampleData[i]);
                
                // Verify the text was entered
                String currentValue = handler.getTextBoxValue(visibleTextBoxes, i);
                System.out.println("  - Entered: '" + sampleData[i] + "'");
                System.out.println("  - Current value: '" + currentValue + "'");
                System.out.println("  - Verification: " + (sampleData[i].equals(currentValue) ? "✓ PASS" : "✗ FAIL"));
                
                Thread.sleep(1000); // Wait between operations
            }
            
            // Step 6: Display final states
            System.out.println("\nStep 6: Final text box states...");
            handler.printTextBoxStates(visibleTextBoxes);
            
            // Step 7: Demonstrate validation
            System.out.println("\nStep 7: Demonstrating input validation...");
            for (int i = 0; i < visibleTextBoxes.size(); i++) {
                WebElement textBox = visibleTextBoxes.get(i);
                String currentValue = handler.getTextBoxValue(visibleTextBoxes, i);
                
                if (currentValue != null && !currentValue.isEmpty()) {
                    System.out.println("Text Box " + i + " validation:");
                    System.out.println("  - Value: '" + currentValue + "'");
                    System.out.println("  - Is Empty: " + utils.isTextBoxEmpty(textBox));
                    System.out.println("  - Text Length: " + utils.getTextBoxTextLength(textBox));
                    
                    // Validate email format if the text contains "@"
                    if (currentValue.contains("@")) {
                        System.out.println("  - Email Format Valid: " + utils.validateTextBoxInput(textBox, "email"));
                    }
                    
                    // Validate if it's required (non-empty)
                    System.out.println("  - Required Field Valid: " + utils.validateTextBoxInput(textBox, "required"));
                }
            }
            
            // Step 8: Demonstrate clearing functionality
            System.out.println("\nStep 8: Demonstrating text box clearing...");
            System.out.println("Clearing all text boxes...");
            utils.clearAllTextBoxes(visibleTextBoxes);
            
            // Step 9: Verify all text boxes are cleared
            System.out.println("\nStep 9: Verifying all text boxes are cleared...");
            handler.printTextBoxStates(visibleTextBoxes);
            
            // Step 10: Demonstrate finding text boxes by different methods
            System.out.println("\nStep 10: Demonstrating different text box finding methods...");
            
            // Find by partial text (if any text boxes have placeholders)
            List<WebElement> searchResults = utils.findTextBoxesByPartialText("search");
            if (!searchResults.isEmpty()) {
                System.out.println("Found " + searchResults.size() + " text boxes containing 'search'");
            }
            
            // Find by XPath
            List<WebElement> xpathResults = utils.findTextBoxesByXPath("//input[@type='text']");
            System.out.println("Found " + xpathResults.size() + " text boxes using XPath");
            
            // Wait a bit to see the final results
            System.out.println("\nWaiting 3 seconds to show final results...");
            Thread.sleep(3000);
            
            System.out.println("\n=== WORKFLOW COMPLETED SUCCESSFULLY ===");
            
        } catch (Exception e) {
            System.err.println("Error in complete workflow: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up resources
            handler.cleanup();
        }
    }
    
    /**
     * Demonstrate advanced text box operations
     */
    public void demonstrateAdvancedOperations() {
        System.out.println("=== ADVANCED TEXT BOX OPERATIONS ===\n");
        
        try {
            handler.navigateToWebsite("https://www.google.com");
            Thread.sleep(2000);
            
            List<WebElement> textBoxes = handler.findTextBoxes();
            
            if (textBoxes != null && !textBoxes.isEmpty()) {
                // Demonstrate waiting for specific text
                System.out.println("Demonstrating wait for text functionality...");
                WebElement firstTextBox = textBoxes.get(0);
                
                // Enter text
                handler.populateTextBoxByIndex(textBoxes, 0, "Waiting for this text");
                
                // Wait for the text to appear
                boolean textAppeared = utils.waitForTextBoxText(firstTextBox, "Waiting for this text", 5);
                System.out.println("Text appeared within timeout: " + textAppeared);
                
                // Demonstrate finding by different attributes
                System.out.println("\nDemonstrating attribute-based finding...");
                
                // Find by class (if any exist)
                List<WebElement> classResults = utils.findTextBoxesByClass("gLFyf");
                if (!classResults.isEmpty()) {
                    System.out.println("Found text boxes by class 'gLFyf': " + classResults.size());
                }
                
                // Find by name (if any exist)
                List<WebElement> nameResults = utils.findTextBoxesByName("q");
                if (!nameResults.isEmpty()) {
                    System.out.println("Found text boxes by name 'q': " + nameResults.size());
                }
                
                Thread.sleep(2000);
            }
            
        } catch (Exception e) {
            System.err.println("Error in advanced operations: " + e.getMessage());
        } finally {
            handler.cleanup();
        }
    }
    
    /**
     * Main method to run the complete example
     */
    public static void main(String[] args) {
        CompleteTextBoxExample example = new CompleteTextBoxExample();
        
        try {
            // Run the complete workflow
            example.demonstrateCompleteWorkflow();
            
            // Wait a bit between demonstrations
            Thread.sleep(2000);
            
            // Run advanced operations
            example.demonstrateAdvancedOperations();
            
        } catch (Exception e) {
            System.err.println("Error running complete example: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\nAll demonstrations completed!");
    }
}