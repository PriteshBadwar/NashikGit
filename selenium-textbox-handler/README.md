# Selenium TextBox Handler

A comprehensive Java Selenium WebDriver project that demonstrates how to find text boxes on a website by indexing and populate them individually.

## Project Overview

This project provides a complete solution for:
- Finding all text boxes on a webpage
- Getting their indexing values (0, 1, 2, 3, etc.)
- Populating each text box individually by its index
- Advanced text box operations and utilities

## Features

### Core Functionality
- **TextBoxHandler**: Main class for basic text box operations
- **TextBoxUtils**: Utility class with advanced text box methods
- **CompleteTextBoxExample**: Comprehensive demonstration of the workflow
- **TextBoxHandlerTest**: Various test scenarios

### Key Capabilities
- Find text boxes using multiple selectors (CSS, XPath, attributes)
- Get detailed information about each text box (ID, name, class, etc.)
- Populate text boxes individually by index
- Validate text box input (email, phone, required fields, etc.)
- Clear all text boxes at once
- Wait for specific text to appear in text boxes
- Filter text boxes by visibility and enabled state
- Handle errors gracefully with comprehensive logging

## Project Structure

```
selenium-textbox-handler/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── selenium/
│                   └── demo/
│                       ├── TextBoxHandler.java          # Main handler class
│                       ├── TextBoxUtils.java            # Utility methods
│                       ├── CompleteTextBoxExample.java  # Complete workflow demo
│                       └── TextBoxHandlerTest.java      # Test scenarios
├── pom.xml                                              # Maven dependencies
└── README.md                                            # This file
```

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Chrome browser (for ChromeDriver)
- Internet connection (to download dependencies and access test websites)

## Installation

1. **Clone or download the project** to your local machine
2. **Navigate to the project directory**:
   ```bash
   cd selenium-textbox-handler
   ```
3. **Install dependencies**:
   ```bash
   mvn clean install
   ```

## Usage

### Basic Usage

The simplest way to use the project is to run the main class:

```bash
mvn exec:java -Dexec.mainClass="com.selenium.demo.TextBoxHandler"
```

### Advanced Usage

For a complete demonstration of all features:

```bash
mvn exec:java -Dexec.mainClass="com.selenium.demo.CompleteTextBoxExample"
```

### Running Tests

To run the test scenarios:

```bash
mvn exec:java -Dexec.mainClass="com.selenium.demo.TextBoxHandlerTest"
```

## Code Examples

### 1. Basic Text Box Finding and Population

```java
TextBoxHandler handler = new TextBoxHandler();

// Navigate to website
handler.navigateToWebsite("https://example.com");

// Find all text boxes
List<WebElement> textBoxes = handler.findTextBoxes();

// Populate text box at index 0
handler.populateTextBoxByIndex(textBoxes, 0, "First Name");

// Populate text box at index 1
handler.populateTextBoxByIndex(textBoxes, 1, "Last Name");

// Clean up
handler.cleanup();
```

### 2. Using Utility Methods

```java
TextBoxHandler handler = new TextBoxHandler();
TextBoxUtils utils = new TextBoxUtils(handler.getDriver());

// Find text boxes by specific attributes
List<WebElement> emailBoxes = utils.findTextBoxesByAttribute("type", "email");
List<WebElement> nameBoxes = utils.findTextBoxesByName("username");

// Validate input
boolean isValidEmail = utils.validateTextBoxInput(emailBoxes.get(0), "email");
boolean isRequired = utils.validateTextBoxInput(nameBoxes.get(0), "required");

// Clear all text boxes
utils.clearAllTextBoxes(textBoxes);
```

### 3. Complete Workflow Example

```java
CompleteTextBoxExample example = new CompleteTextBoxExample();
example.demonstrateCompleteWorkflow();
```

## Key Methods

### TextBoxHandler Class

- `findTextBoxes()`: Find all text boxes and display indexing information
- `populateTextBoxByIndex()`: Populate a specific text box by its index
- `populateAllTextBoxes()`: Populate all text boxes with sample data
- `getTextBoxValue()`: Get the current value of a text box
- `printTextBoxStates()`: Display the current state of all text boxes

### TextBoxUtils Class

- `findTextBoxesByAttribute()`: Find text boxes by specific attributes
- `findTextBoxesByClass()`: Find text boxes by CSS class
- `findTextBoxesById()`: Find text boxes by ID
- `findTextBoxesByName()`: Find text boxes by name
- `validateTextBoxInput()`: Validate text box input (email, phone, etc.)
- `clearAllTextBoxes()`: Clear all text boxes at once
- `waitForTextBoxText()`: Wait for specific text to appear

## Supported Text Box Types

The project can handle various types of text input elements:
- `<input type="text">`
- `<input>` (without type attribute)
- `<textarea>`
- Hidden input fields
- Read-only text boxes
- Disabled text boxes

## Error Handling

The project includes comprehensive error handling for:
- Invalid indices
- Missing text boxes
- Network errors
- Element not found exceptions
- Timeout exceptions
- Invalid input validation

## Customization

### Changing Target Website

Modify the URL in any of the example classes:

```java
handler.navigateToWebsite("https://your-website.com");
```

### Custom Text Data

Modify the sample data arrays in the example classes:

```java
String[] customData = {
    "Your Custom Text 1",
    "Your Custom Text 2",
    "Your Custom Text 3"
};
```

### Custom Validation Rules

Add new validation types in the `TextBoxUtils.validateTextBoxInput()` method:

```java
case "custom":
    return value.matches("your-regex-pattern");
```

## Troubleshooting

### Common Issues

1. **ChromeDriver not found**: The project uses WebDriverManager to automatically download and manage drivers
2. **No text boxes found**: Ensure the website has loaded completely and contains text input elements
3. **Element not clickable**: The project includes wait conditions, but some websites may require additional time
4. **Permission denied**: Ensure you have write permissions in the project directory

### Debug Mode

Enable detailed logging by modifying the WebDriverWait timeout:

```java
this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increase timeout
```

## Dependencies

- **Selenium WebDriver 4.15.0**: Core automation framework
- **WebDriverManager 5.6.2**: Automatic driver management
- **JUnit 5.9.2**: Testing framework
- **TestNG 7.7.1**: Alternative testing framework

## Browser Support

Currently supports:
- Chrome (primary)
- Other browsers can be added by modifying the WebDriver initialization

## Contributing

Feel free to extend the project with:
- Additional browser support
- More validation types
- Enhanced error handling
- Additional utility methods
- Performance optimizations

## License

This project is provided as-is for educational and demonstration purposes.

## Support

For issues or questions:
1. Check the console output for detailed error messages
2. Verify your Java and Maven versions
3. Ensure you have internet connectivity for dependency downloads
4. Check that the target website is accessible

---

**Note**: This project is designed for educational purposes and demonstrates best practices for Selenium WebDriver automation. Always respect website terms of service and use responsibly.