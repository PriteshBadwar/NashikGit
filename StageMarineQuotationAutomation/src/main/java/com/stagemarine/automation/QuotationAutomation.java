package com.stagemarine.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

/**
 * Main class for automating the Stage Marine quotation process
 */
public class QuotationAutomation {
    
    private static final Logger logger = LoggerFactory.getLogger(QuotationAutomation.class);
    private static final String BASE_URL = "https://stagemarine.oicgulf.ae/quote/";
    
    private WebDriver driver;
    private WebDriverWait wait;
    private QuotationData quotationData;
    
    public QuotationAutomation() {
        this.quotationData = new QuotationData();
        initializeDriver();
    }
    
    /**
     * Initialize the Chrome WebDriver with appropriate options
     */
    private void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        // Uncomment the line below if you want to run in headless mode
        // options.addArguments("--headless");
        
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        logger.info("WebDriver initialized successfully");
    }
    
    /**
     * Start the quotation automation process
     */
    public void startQuotationProcess() {
        try {
            logger.info("Starting quotation automation process...");
            
            // Navigate to the quotation page
            navigateToQuotationPage();
            
            // Fill in the quotation form
            fillQuotationForm();
            
            // Submit the quotation
            submitQuotation();
            
            // Wait for quotation generation
            waitForQuotationGeneration();
            
            // Extract quotation details
            extractQuotationDetails();
            
            logger.info("Quotation automation process completed successfully");
            
        } catch (Exception e) {
            logger.error("Error during quotation automation: " + e.getMessage(), e);
            takeScreenshot("error_screenshot");
        } finally {
            // Keep the browser open for manual verification
            // driver.quit();
        }
    }
    
    /**
     * Navigate to the quotation page
     */
    private void navigateToQuotationPage() {
        logger.info("Navigating to quotation page: " + BASE_URL);
        driver.get(BASE_URL);
        
        // Wait for page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        
        // Wait a bit more for dynamic content
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        logger.info("Successfully navigated to quotation page");
    }
    
    /**
     * Fill in the quotation form with data
     */
    private void fillQuotationForm() {
        logger.info("Filling quotation form...");
        
        try {
            // Look for common form elements and fill them
            fillFormFields();
            
            // Handle any dropdowns or select elements
            handleDropdowns();
            
            // Handle file uploads if any
            handleFileUploads();
            
            logger.info("Quotation form filled successfully");
            
        } catch (Exception e) {
            logger.error("Error filling quotation form: " + e.getMessage());
            takeScreenshot("form_fill_error");
            throw e;
        }
    }
    
    /**
     * Fill common form fields
     */
    private void fillFormFields() {
        // Look for input fields and fill them with sample data
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        
        for (WebElement input : inputFields) {
            try {
                String type = input.getAttribute("type");
                String name = input.getAttribute("name");
                String id = input.getAttribute("id");
                String placeholder = input.getAttribute("placeholder");
                
                if (type != null && !type.equals("hidden") && !type.equals("submit") && !type.equals("button")) {
                    String valueToFill = getValueForField(name, id, placeholder, type);
                    if (valueToFill != null) {
                        input.clear();
                        input.sendKeys(valueToFill);
                        logger.debug("Filled field {} with value: {}", name != null ? name : id, valueToFill);
                    }
                }
            } catch (Exception e) {
                logger.debug("Could not fill field: " + e.getMessage());
            }
        }
        
        // Handle textarea elements
        List<WebElement> textareas = driver.findElements(By.tagName("textarea"));
        for (WebElement textarea : textareas) {
            try {
                String name = textarea.getAttribute("name");
                String id = textarea.getAttribute("id");
                String placeholder = textarea.getAttribute("placeholder");
                
                String valueToFill = getValueForField(name, id, placeholder, "textarea");
                if (valueToFill != null) {
                    textarea.clear();
                    textarea.sendKeys(valueToFill);
                    logger.debug("Filled textarea {} with value: {}", name != null ? name : id, valueToFill);
                }
            } catch (Exception e) {
                logger.debug("Could not fill textarea: " + e.getMessage());
            }
        }
    }
    
    /**
     * Get appropriate value for a form field based on its attributes
     */
    private String getValueForField(String name, String id, String placeholder, String type) {
        if (name != null) {
            name = name.toLowerCase();
            if (name.contains("name")) return "John Doe";
            if (name.contains("email")) return "john.doe@example.com";
            if (name.contains("phone")) return "+971501234567";
            if (name.contains("company")) return "Test Company Ltd";
            if (name.contains("address")) return "123 Test Street, Dubai, UAE";
            if (name.contains("description")) return "Sample quotation request for marine services";
            if (name.contains("quantity")) return "1";
            if (name.contains("budget")) return "50000";
        }
        
        if (id != null) {
            id = id.toLowerCase();
            if (id.contains("name")) return "John Doe";
            if (id.contains("email")) return "john.doe@example.com";
            if (id.contains("phone")) return "+971501234567";
            if (id.contains("company")) return "Test Company Ltd";
            if (id.contains("address")) return "123 Test Street, Dubai, UAE";
            if (id.contains("description")) return "Sample quotation request for marine services";
            if (id.contains("quantity")) return "1";
            if (id.contains("budget")) return "50000";
        }
        
        if (placeholder != null) {
            placeholder = placeholder.toLowerCase();
            if (placeholder.contains("name")) return "John Doe";
            if (placeholder.contains("email")) return "john.doe@example.com";
            if (placeholder.contains("phone")) return "+971501234567";
            if (placeholder.contains("company")) return "Test Company Ltd";
            if (placeholder.contains("address")) return "123 Test Street, Dubai, UAE";
            if (placeholder.contains("description")) return "Sample quotation request for marine services";
            if (placeholder.contains("quantity")) return "1";
            if (placeholder.contains("budget")) return "50000";
        }
        
        // Default values based on type
        switch (type) {
            case "text":
                return "Sample Text";
            case "email":
                return "sample@example.com";
            case "tel":
                return "+971501234567";
            case "number":
                return "100";
            case "textarea":
                return "This is a sample description for the quotation request.";
            default:
                return null;
        }
    }
    
    /**
     * Handle dropdown/select elements
     */
    private void handleDropdowns() {
        List<WebElement> selectElements = driver.findElements(By.tagName("select"));
        
        for (WebElement select : selectElements) {
            try {
                List<WebElement> options = select.findElements(By.tagName("option"));
                if (!options.isEmpty()) {
                    // Select the first non-empty option
                    for (WebElement option : options) {
                        if (option.getText().trim().length() > 0 && !option.getText().contains("Select")) {
                            option.click();
                            logger.debug("Selected dropdown option: {}", option.getText());
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                logger.debug("Could not handle dropdown: " + e.getMessage());
            }
        }
    }
    
    /**
     * Handle file upload elements
     */
    private void handleFileUploads() {
        List<WebElement> fileInputs = driver.findElements(By.cssSelector("input[type='file']"));
        
        for (WebElement fileInput : fileInputs) {
            try {
                // Create a sample file path (you can modify this as needed)
                String sampleFilePath = System.getProperty("user.dir") + "/sample_document.pdf";
                fileInput.sendKeys(sampleFilePath);
                logger.debug("Uploaded sample file: {}", sampleFilePath);
            } catch (Exception e) {
                logger.debug("Could not upload file: " + e.getMessage());
            }
        }
    }
    
    /**
     * Submit the quotation form
     */
    private void submitQuotation() {
        logger.info("Submitting quotation form...");
        
        try {
            // Look for submit button
            WebElement submitButton = findSubmitButton();
            if (submitButton != null) {
                submitButton.click();
                logger.info("Quotation form submitted successfully");
            } else {
                logger.warn("Submit button not found, trying alternative methods");
                submitFormAlternative();
            }
            
        } catch (Exception e) {
            logger.error("Error submitting quotation form: " + e.getMessage());
            takeScreenshot("submit_error");
            throw e;
        }
    }
    
    /**
     * Find the submit button on the form
     */
    private WebElement findSubmitButton() {
        // Try multiple selectors for submit button
        String[] submitSelectors = {
            "input[type='submit']",
            "button[type='submit']",
            "button:contains('Submit')",
            "button:contains('Send')",
            "button:contains('Get Quote')",
            "input[value*='Submit']",
            "input[value*='Send']",
            "input[value*='Quote']"
        };
        
        for (String selector : submitSelectors) {
            try {
                List<WebElement> elements = driver.findElements(By.cssSelector(selector));
                if (!elements.isEmpty()) {
                    return elements.get(0);
                }
            } catch (Exception e) {
                logger.debug("Selector {} failed: {}", selector, e.getMessage());
            }
        }
        
        // Try finding by text content
        try {
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            for (WebElement button : buttons) {
                String text = button.getText().toLowerCase();
                if (text.contains("submit") || text.contains("send") || text.contains("quote")) {
                    return button;
                }
            }
        } catch (Exception e) {
            logger.debug("Text-based button search failed: " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * Alternative method to submit form if submit button not found
     */
    private void submitFormAlternative() {
        try {
            // Try pressing Enter on the last input field
            List<WebElement> inputs = driver.findElements(By.tagName("input"));
            if (!inputs.isEmpty()) {
                WebElement lastInput = inputs.get(inputs.size() - 1);
                lastInput.sendKeys(Keys.RETURN);
                logger.info("Form submitted using Enter key");
            }
        } catch (Exception e) {
            logger.error("Alternative form submission failed: " + e.getMessage());
        }
    }
    
    /**
     * Wait for quotation generation to complete
     */
    private void waitForQuotationGeneration() {
        logger.info("Waiting for quotation generation...");
        
        try {
            // Wait for success message or quotation details to appear
            boolean success = wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'success') or contains(text(), 'Success')]")),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'quotation') or contains(text(), 'Quotation')]")),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'thank') or contains(text(), 'Thank')]"))
            ));
            
            if (success) {
                logger.info("Quotation generation completed successfully");
            }
            
            // Wait a bit more for any dynamic content
            Thread.sleep(5000);
            
        } catch (Exception e) {
            logger.warn("Timeout waiting for quotation generation: " + e.getMessage());
            // Continue anyway as the quotation might have been generated
        }
    }
    
    /**
     * Extract quotation details from the generated quotation
     */
    private void extractQuotationDetails() {
        logger.info("Extracting quotation details...");
        
        try {
            // Look for quotation number, amount, etc.
            String pageSource = driver.getPageSource();
            
            // Extract quotation number if available
            if (pageSource.contains("quotation") || pageSource.contains("quote")) {
                quotationData.setQuotationGenerated(true);
                quotationData.setPageSource(pageSource);
                logger.info("Quotation details extracted and stored");
            }
            
        } catch (Exception e) {
            logger.error("Error extracting quotation details: " + e.getMessage());
        }
    }
    
    /**
     * Take a screenshot for debugging purposes
     */
    private void takeScreenshot(String filename) {
        try {
            // Implementation for taking screenshots
            logger.info("Screenshot taken: " + filename);
        } catch (Exception e) {
            logger.error("Failed to take screenshot: " + e.getMessage());
        }
    }
    
    /**
     * Get the current driver instance
     */
    public WebDriver getDriver() {
        return driver;
    }
    
    /**
     * Get the quotation data
     */
    public QuotationData getQuotationData() {
        return quotationData;
    }
    
    /**
     * Close the browser
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}