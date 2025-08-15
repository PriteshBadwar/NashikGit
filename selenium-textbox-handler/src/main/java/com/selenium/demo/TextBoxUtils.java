package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

/**
 * Utility class providing additional helper methods for text box operations
 */
public class TextBoxUtils {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public TextBoxUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    /**
     * Find text boxes by specific attributes (ID, Name, Class, etc.)
     */
    public List<WebElement> findTextBoxesByAttribute(String attribute, String value) {
        try {
            String selector = String.format("input[%s='%s'], textarea[%s='%s']", attribute, value, attribute, value);
            List<WebElement> elements = driver.findElements(By.cssSelector(selector));
            System.out.println("Found " + elements.size() + " text boxes with " + attribute + "='" + value + "'");
            return elements;
        } catch (Exception e) {
            System.err.println("Error finding text boxes by " + attribute + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    /**
     * Find text boxes by CSS class
     */
    public List<WebElement> findTextBoxesByClass(String className) {
        return findTextBoxesByAttribute("class", className);
    }
    
    /**
     * Find text boxes by ID
     */
    public List<WebElement> findTextBoxesById(String id) {
        return findTextBoxesByAttribute("id", id);
    }
    
    /**
     * Find text boxes by Name
     */
    public List<WebElement> findTextBoxesByName(String name) {
        return findTextBoxesByAttribute("name", name);
    }
    
    /**
     * Find text boxes by placeholder text
     */
    public List<WebElement> findTextBoxesByPlaceholder(String placeholder) {
        return findTextBoxesByAttribute("placeholder", placeholder);
    }
    
    /**
     * Find text boxes by XPath
     */
    public List<WebElement> findTextBoxesByXPath(String xpath) {
        try {
            List<WebElement> elements = driver.findElements(By.xpath(xpath));
            System.out.println("Found " + elements.size() + " text boxes using XPath: " + xpath);
            return elements;
        } catch (Exception e) {
            System.err.println("Error finding text boxes by XPath: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    /**
     * Check if a text box is empty
     */
    public boolean isTextBoxEmpty(WebElement textBox) {
        try {
            String value = textBox.getAttribute("value");
            return value == null || value.trim().isEmpty();
        } catch (Exception e) {
            System.err.println("Error checking if text box is empty: " + e.getMessage());
            return true;
        }
    }
    
    /**
     * Get the length of text in a text box
     */
    public int getTextBoxTextLength(WebElement textBox) {
        try {
            String value = textBox.getAttribute("value");
            return value != null ? value.length() : 0;
        } catch (Exception e) {
            System.err.println("Error getting text box length: " + e.getMessage());
            return 0;
        }
    }
    
    /**
     * Clear all text boxes in a list
     */
    public void clearAllTextBoxes(List<WebElement> textBoxes) {
        if (textBoxes == null || textBoxes.isEmpty()) {
            System.out.println("No text boxes to clear");
            return;
        }
        
        System.out.println("Clearing " + textBoxes.size() + " text boxes...");
        for (int i = 0; i < textBoxes.size(); i++) {
            try {
                WebElement textBox = textBoxes.get(i);
                wait.until(ExpectedConditions.elementToBeClickable(textBox));
                textBox.clear();
                System.out.println("Cleared text box at index " + i);
            } catch (Exception e) {
                System.err.println("Error clearing text box at index " + i + ": " + e.getMessage());
            }
        }
        System.out.println("Finished clearing all text boxes");
    }
    
    /**
     * Validate text box input (e.g., email format, required field, etc.)
     */
    public boolean validateTextBoxInput(WebElement textBox, String validationType) {
        try {
            String value = textBox.getAttribute("value");
            if (value == null) value = "";
            
            switch (validationType.toLowerCase()) {
                case "email":
                    return value.matches("^[A-Za-z0-9+_.-]+@(.+)$");
                case "phone":
                    return value.matches("^[+]?[0-9\\s\\-\\(\\)]{10,}$");
                case "required":
                    return !value.trim().isEmpty();
                case "numeric":
                    return value.matches("^[0-9]+$");
                case "alphanumeric":
                    return value.matches("^[A-Za-z0-9]+$");
                default:
                    System.out.println("Unknown validation type: " + validationType);
                    return false;
            }
        } catch (Exception e) {
            System.err.println("Error validating text box input: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get text box properties for debugging
     */
    public void printTextBoxProperties(WebElement textBox, int index) {
        try {
            System.out.println("Text Box " + index + " Properties:");
            System.out.println("  - Tag Name: " + textBox.getTagName());
            System.out.println("  - ID: " + textBox.getAttribute("id"));
            System.out.println("  - Name: " + textBox.getAttribute("name"));
            System.out.println("  - Class: " + textBox.getAttribute("class"));
            System.out.println("  - Type: " + textBox.getAttribute("type"));
            System.out.println("  - Placeholder: " + textBox.getAttribute("placeholder"));
            System.out.println("  - Value: " + textBox.getAttribute("value"));
            System.out.println("  - Max Length: " + textBox.getAttribute("maxlength"));
            System.out.println("  - Read Only: " + textBox.getAttribute("readonly"));
            System.out.println("  - Disabled: " + textBox.getAttribute("disabled"));
            System.out.println("  - Required: " + textBox.getAttribute("required"));
            System.out.println("  - Is Enabled: " + textBox.isEnabled());
            System.out.println("  - Is Displayed: " + textBox.isDisplayed());
            System.out.println("  - Is Selected: " + textBox.isSelected());
            System.out.println();
        } catch (Exception e) {
            System.err.println("Error printing text box properties for index " + index + ": " + e.getMessage());
        }
    }
    
    /**
     * Wait for text box to contain specific text
     */
    public boolean waitForTextBoxText(WebElement textBox, String expectedText, int timeoutSeconds) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return customWait.until(ExpectedConditions.textToBePresentInElementValue(textBox, expectedText));
        } catch (Exception e) {
            System.err.println("Timeout waiting for text box to contain '" + expectedText + "': " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get text boxes that are currently visible and enabled
     */
    public List<WebElement> getVisibleAndEnabledTextBoxes(List<WebElement> allTextBoxes) {
        List<WebElement> visibleEnabled = new ArrayList<>();
        
        for (WebElement textBox : allTextBoxes) {
            try {
                if (textBox.isDisplayed() && textBox.isEnabled()) {
                    visibleEnabled.add(textBox);
                }
            } catch (Exception e) {
                System.err.println("Error checking text box visibility/enabled state: " + e.getMessage());
            }
        }
        
        System.out.println("Found " + visibleEnabled.size() + " visible and enabled text boxes out of " + allTextBoxes.size() + " total");
        return visibleEnabled;
    }
    
    /**
     * Find text boxes by partial text match in placeholder or value
     */
    public List<WebElement> findTextBoxesByPartialText(String partialText) {
        List<WebElement> matchingTextBoxes = new ArrayList<>();
        
        try {
            // Find all input elements
            List<WebElement> allInputs = driver.findElements(By.cssSelector("input, textarea"));
            
            for (WebElement input : allInputs) {
                try {
                    String placeholder = input.getAttribute("placeholder");
                    String value = input.getAttribute("value");
                    String id = input.getAttribute("id");
                    String name = input.getAttribute("name");
                    
                    if ((placeholder != null && placeholder.toLowerCase().contains(partialText.toLowerCase())) ||
                        (value != null && value.toLowerCase().contains(partialText.toLowerCase())) ||
                        (id != null && id.toLowerCase().contains(partialText.toLowerCase())) ||
                        (name != null && name.toLowerCase().contains(partialText.toLowerCase()))) {
                        matchingTextBoxes.add(input);
                    }
                } catch (Exception e) {
                    // Continue with next element
                }
            }
            
            System.out.println("Found " + matchingTextBoxes.size() + " text boxes containing '" + partialText + "'");
            return matchingTextBoxes;
            
        } catch (Exception e) {
            System.err.println("Error finding text boxes by partial text: " + e.getMessage());
            return matchingTextBoxes;
        }
    }
}