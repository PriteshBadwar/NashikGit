package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

/**
 * TextBoxHandler class to demonstrate finding text boxes by indexing
 * and populating them individually using Selenium WebDriver
 */
public class TextBoxHandler {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    /**
     * Constructor to initialize WebDriver and WebDriverWait
     */
    public TextBoxHandler() {
        // Setup Chrome WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Maximize browser window
        driver.manage().window().maximize();
    }
    
    /**
     * Navigate to the target website
     * @param url The URL to navigate to
     */
    public void navigateToWebsite(String url) {
        try {
            driver.get(url);
            System.out.println("Successfully navigated to: " + url);
        } catch (Exception e) {
            System.err.println("Error navigating to website: " + e.getMessage());
        }
    }
    
    /**
     * Find all text boxes on the page and get their indexing values
     * @return List of WebElements representing text boxes
     */
    public List<WebElement> findTextBoxes() {
        try {
            // Wait for page to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            
            // Find all input elements that are text boxes
            List<WebElement> textBoxes = driver.findElements(By.cssSelector("input[type='text'], input:not([type]), textarea"));
            
            System.out.println("Found " + textBoxes.size() + " text boxes on the page");
            
            // Print indexing information for each text box
            for (int i = 0; i < textBoxes.size(); i++) {
                WebElement textBox = textBoxes.get(i);
                String id = textBox.getAttribute("id");
                String name = textBox.getAttribute("name");
                String placeholder = textBox.getAttribute("placeholder");
                
                System.out.println("Text Box Index " + i + ":");
                System.out.println("  - ID: " + (id != null ? id : "Not specified"));
                System.out.println("  - Name: " + (name != null ? name : "Not specified"));
                System.out.println("  - Placeholder: " + (placeholder != null ? placeholder : "Not specified"));
                System.out.println("  - Tag Name: " + textBox.getTagName());
                System.out.println("  - Is Enabled: " + textBox.isEnabled());
                System.out.println("  - Is Displayed: " + textBox.isDisplayed());
                System.out.println();
            }
            
            return textBoxes;
            
        } catch (Exception e) {
            System.err.println("Error finding text boxes: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Populate a specific text box by its index
     * @param textBoxes List of all text boxes
     * @param index Index of the text box to populate
     * @param text Text to enter into the text box
     */
    public void populateTextBoxByIndex(List<WebElement> textBoxes, int index, String text) {
        try {
            if (textBoxes == null || textBoxes.isEmpty()) {
                System.err.println("No text boxes found to populate");
                return;
            }
            
            if (index < 0 || index >= textBoxes.size()) {
                System.err.println("Invalid index: " + index + ". Valid range is 0 to " + (textBoxes.size() - 1));
                return;
            }
            
            WebElement targetTextBox = textBoxes.get(index);
            
            // Wait for the text box to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(targetTextBox));
            
            // Clear existing text and enter new text
            targetTextBox.clear();
            targetTextBox.sendKeys(text);
            
            System.out.println("Successfully populated text box at index " + index + " with text: '" + text + "'");
            
            // Verify the text was entered correctly
            String enteredText = targetTextBox.getAttribute("value");
            if (enteredText != null && enteredText.equals(text)) {
                System.out.println("Text verification successful for index " + index);
            } else {
                System.out.println("Text verification failed for index " + index + ". Expected: '" + text + "', Got: '" + enteredText + "'");
            }
            
        } catch (Exception e) {
            System.err.println("Error populating text box at index " + index + ": " + e.getMessage());
        }
    }
    
    /**
     * Populate all text boxes with different sample data
     * @param textBoxes List of all text boxes
     */
    public void populateAllTextBoxes(List<WebElement> textBoxes) {
        if (textBoxes == null || textBoxes.isEmpty()) {
            System.err.println("No text boxes found to populate");
            return;
        }
        
        System.out.println("Populating all " + textBoxes.size() + " text boxes with sample data...");
        
        String[] sampleData = {
            "First Name: John",
            "Last Name: Doe", 
            "Email: john.doe@example.com",
            "Phone: +1-555-123-4567"
        };
        
        for (int i = 0; i < textBoxes.size() && i < sampleData.length; i++) {
            populateTextBoxByIndex(textBoxes, i, sampleData[i]);
            
            // Add a small delay between operations
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Finished populating all text boxes");
    }
    
    /**
     * Get the current value of a text box by index
     * @param textBoxes List of all text boxes
     * @param index Index of the text box
     * @return Current value of the text box
     */
    public String getTextBoxValue(List<WebElement> textBoxes, int index) {
        try {
            if (textBoxes == null || textBoxes.isEmpty() || index < 0 || index >= textBoxes.size()) {
                return null;
            }
            
            WebElement textBox = textBoxes.get(index);
            return textBox.getAttribute("value");
            
        } catch (Exception e) {
            System.err.println("Error getting text box value at index " + index + ": " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Print the current state of all text boxes
     * @param textBoxes List of all text boxes
     */
    public void printTextBoxStates(List<WebElement> textBoxes) {
        if (textBoxes == null || textBoxes.isEmpty()) {
            System.out.println("No text boxes to display");
            return;
        }
        
        System.out.println("\n=== Current Text Box States ===");
        for (int i = 0; i < textBoxes.size(); i++) {
            String value = getTextBoxValue(textBoxes, i);
            System.out.println("Index " + i + ": '" + (value != null ? value : "") + "'");
        }
        System.out.println("==============================\n");
    }
    
    /**
     * Get the WebDriver instance
     * @return WebDriver instance
     */
    public WebDriver getDriver() {
        return this.driver;
    }
    
    /**
     * Close the browser and clean up resources
     */
    public void cleanup() {
        try {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed successfully");
            }
        } catch (Exception e) {
            System.err.println("Error closing browser: " + e.getMessage());
        }
    }
    
    /**
     * Main method to demonstrate the functionality
     */
    public static void main(String[] args) {
        TextBoxHandler handler = new TextBoxHandler();
        
        try {
            // Navigate to a test website (you can change this URL)
            // For demonstration, using a simple HTML page
            handler.navigateToWebsite("https://www.google.com");
            
            // Find all text boxes
            List<WebElement> textBoxes = handler.findTextBoxes();
            
            if (textBoxes != null && !textBoxes.isEmpty()) {
                // Populate text boxes individually
                handler.populateTextBoxByIndex(textBoxes, 0, "Sample Text 1");
                handler.populateTextBoxByIndex(textBoxes, 1, "Sample Text 2");
                
                // Print current states
                handler.printTextBoxStates(textBoxes);
                
                // Populate all text boxes with sample data
                handler.populateAllTextBoxes(textBoxes);
                
                // Print final states
                handler.printTextBoxStates(textBoxes);
                
                // Wait a bit to see the results
                Thread.sleep(3000);
            } else {
                System.out.println("No text boxes found on the page");
            }
            
        } catch (Exception e) {
            System.err.println("Error in main method: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up resources
            handler.cleanup();
        }
    }
}