# Stage Marine Quotation Automation

This project automates the quotation process for the Stage Marine website (https://stagemarine.oicgulf.ae/quote/). It uses Selenium WebDriver to automatically fill out quotation forms and generate quotations.

## Features

- **Automated Form Filling**: Automatically detects and fills form fields with appropriate data
- **Multiple Quotation Types**: Supports different types of marine services quotations
- **Smart Field Detection**: Uses multiple strategies to identify form fields
- **Configurable Data**: Easy to customize quotation data and customer information
- **Error Handling**: Comprehensive error handling and logging
- **Screenshot Support**: Takes screenshots on errors for debugging
- **Test Framework**: Includes TestNG tests for validation

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Chrome browser installed
- Internet connection to access the Stage Marine website

## Installation

1. Clone or download this project
2. Navigate to the project directory
3. Install dependencies:

```bash
mvn clean install
```

## Usage

### Running the Main Application

To run the quotation automation directly:

```bash
mvn exec:java -Dexec.mainClass="com.stagemarine.automation.Main"
```

### Running Tests

To run all tests:

```bash
mvn test
```

To run a specific test:

```bash
mvn test -Dtest=QuotationAutomationTest#testCompleteQuotationProcess
```

### Running with TestNG

```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Configuration

### Quotation Types

The automation supports several quotation types:

- **Marine Services**: Comprehensive marine services
- **Equipment Rental**: Marine equipment rental
- **Consulting**: Marine industry consulting
- **Maintenance**: Vessel and equipment maintenance
- **Transport**: Marine transport services

### Customizing Data

You can customize the quotation data by modifying the `QuotationConfig.java` file:

1. **Customer Information**: Update customer templates in `CUSTOMER_TEMPLATES`
2. **Service Details**: Modify field mappings in `FIELD_MAPPINGS`
3. **Form Selectors**: Adjust CSS selectors in `FORM_SELECTORS`

### Example Customization

```java
// Add a new quotation type
Map<String, String> customService = new HashMap<>();
customService.put("service_type", "Custom Service");
customService.put("description", "Your custom description");
customService.put("budget", "100000");
FIELD_MAPPINGS.put(QuotationType.CUSTOM, customService);

// Update customer information
CUSTOMER_TEMPLATES.put("company", "Your Company Name");
CUSTOMER_TEMPLATES.put("email", "your.email@company.com");
```

## Project Structure

```
src/
├── main/java/com/stagemarine/automation/
│   ├── Main.java                    # Main application entry point
│   ├── QuotationAutomation.java     # Core automation logic
│   ├── QuotationData.java           # Data model for quotations
│   └── QuotationConfig.java         # Configuration and constants
├── test/java/com/stagemarine/automation/
│   └── QuotationAutomationTest.java # TestNG test cases
└── testng.xml                       # TestNG configuration
```

## How It Works

1. **Initialization**: Sets up Chrome WebDriver with appropriate options
2. **Navigation**: Navigates to the Stage Marine quotation page
3. **Form Detection**: Automatically detects form fields using multiple strategies
4. **Data Filling**: Fills form fields with appropriate data based on quotation type
5. **Form Submission**: Submits the form and waits for quotation generation
6. **Result Extraction**: Extracts and stores quotation details
7. **Verification**: Keeps browser open for manual verification

## Field Detection Strategies

The automation uses multiple strategies to identify form fields:

1. **CSS Selectors**: Uses predefined CSS selectors for common elements
2. **Attribute Matching**: Matches field names, IDs, and placeholders
3. **Type Detection**: Identifies input types (text, email, tel, etc.)
4. **Fallback Values**: Provides sensible defaults for unidentified fields

## Error Handling

- **Screenshot Capture**: Takes screenshots on errors for debugging
- **Comprehensive Logging**: Detailed logging using SLF4J and Logback
- **Graceful Degradation**: Continues processing even if some fields fail
- **Exception Recovery**: Handles common web automation exceptions

## Troubleshooting

### Common Issues

1. **Chrome Driver Issues**
   - Ensure Chrome browser is installed
   - Update Chrome to the latest version
   - Check if ChromeDriver is compatible

2. **Form Detection Problems**
   - Verify the website structure hasn't changed
   - Check if new fields have been added
   - Review the form selectors in `QuotationConfig.java`

3. **Network Issues**
   - Check internet connection
   - Verify the website is accessible
   - Check for any firewall restrictions

### Debug Mode

To run in debug mode with more detailed logging:

```bash
mvn exec:java -Dexec.mainClass="com.stagemarine.automation.Main" -Dlogback.configurationFile=logback-debug.xml
```

### Headless Mode

To run without opening a browser window, uncomment this line in `QuotationAutomation.java`:

```java
options.addArguments("--headless");
```

## Customization Examples

### Adding New Quotation Types

```java
// In QuotationConfig.java
public enum QuotationType {
    // ... existing types ...
    CUSTOM_SERVICE("Custom Service");
    
    // Add field mappings
    Map<String, String> customService = new HashMap<>();
    customService.put("service_type", "Custom Service");
    customService.put("description", "Your custom description");
    FIELD_MAPPINGS.put(QuotationType.CUSTOM_SERVICE, customService);
}
```

### Custom Form Field Handling

```java
// In QuotationAutomation.java
private void handleCustomFields() {
    // Add your custom field handling logic here
    WebElement customField = driver.findElement(By.id("custom-field"));
    customField.sendKeys("Custom Value");
}
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

This project is provided as-is for educational and automation purposes.

## Support

For issues or questions:
1. Check the troubleshooting section
2. Review the logs for error details
3. Verify the website structure hasn't changed
4. Check browser compatibility

## Security Notes

- The automation uses test data and should not be used with real customer information
- Always review the data being submitted before running in production
- Consider implementing additional validation for production use
- Be aware of website terms of service regarding automated submissions

## Performance Considerations

- The automation includes appropriate waits for page loading
- Screenshots are only taken on errors to minimize overhead
- Browser options are optimized for automation performance
- Consider running in headless mode for better performance in CI/CD environments