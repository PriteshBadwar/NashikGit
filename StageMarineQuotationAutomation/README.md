# Stage Marine Quotation Automation - Eclipse Project

This is a complete Eclipse project that automates the quotation process for the Stage Marine website (https://stagemarine.oicgulf.ae/quote/).

## 🚀 Quick Start for Eclipse

### 1. Import the Project
1. **File** → **Import** → **Existing Maven Projects**
2. **Browse** to the `StageMarineQuotationAutomation` folder
3. **Select** the project and click **Finish**

### 2. Run the Automation
- **Right-click** on `Main.java` → **Run As** → **Java Application**
- **Or** right-click on `QuotationAutomationTest.java` → **Run As** → **TestNG Test**

### 3. What Happens
1. Chrome browser opens automatically
2. Navigates to the Stage Marine quotation page
3. Fills out the form with sample data
4. Submits the quotation
5. Waits for quotation generation
6. Displays results in console

## 📁 Project Structure

```
StageMarineQuotationAutomation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/stagemarine/automation/
│   │   │       ├── Main.java                    # Main application
│   │   │       ├── QuotationAutomation.java     # Core automation logic
│   │   │       ├── QuotationData.java           # Data model
│   │   │       └── QuotationConfig.java         # Configuration
│   │   └── resources/
│   │       └── logback.xml                      # Logging configuration
│   └── test/
│       └── java/
│           └── com/stagemarine/automation/
│               └── QuotationAutomationTest.java # TestNG tests
├── pom.xml                                      # Maven configuration
├── testng.xml                                   # TestNG test suite
├── .classpath                                   # Eclipse classpath
└── .project                                     # Eclipse project file
```

## 🔧 Prerequisites

- **Eclipse IDE** (Eclipse 2021-12 or later recommended)
- **Java 11+** (OpenJDK or Oracle JDK)
- **Maven** (built into Eclipse with m2e plugin)
- **Chrome browser** installed
- **Internet connection**

## 📋 Features

- ✅ **Automated Form Detection**: Intelligently finds and fills form fields
- ✅ **Multiple Quotation Types**: Marine Services, Equipment Rental, Consulting, etc.
- ✅ **Smart Data Mapping**: Automatically maps field names to appropriate values
- ✅ **Error Handling**: Comprehensive error handling with logging
- ✅ **Test Framework**: TestNG tests for validation
- ✅ **Logging**: Detailed logging with Logback

## 🎯 How to Use

### Run Main Application
```java
// Right-click Main.java → Run As → Java Application
// The automation will start automatically
```

### Run Tests
```java
// Right-click QuotationAutomationTest.java → Run As → TestNG Test
// All tests will run and show results
```

### Customize Data
Edit `QuotationConfig.java` to modify:
- Customer information
- Quotation types
- Field mappings
- Default values

## 🛠️ Troubleshooting

### Common Issues

1. **Maven Dependencies Not Downloaded**
   - Right-click project → **Maven** → **Update Project**
   - Check **Force Update of Snapshots/Releases**

2. **Java Version Issues**
   - Right-click project → **Properties** → **Java Compiler**
   - Set compliance level to **11** or higher

3. **Chrome Driver Issues**
   - Ensure Chrome browser is installed
   - The automation automatically downloads the correct driver

4. **Build Errors**
   - **Project** → **Clean...** → Select project → **Clean**
   - **Maven** → **Update Project**

### Debug Mode
- Add breakpoints in the code
- Right-click → **Debug As** → **Java Application**
- Use **Debug Perspective** to step through code

## 📊 Expected Output

After successful automation:
```
Quotation Summary:
================
Customer Name: John Doe
Customer Email: john.doe@example.com
Company: Test Company Ltd
Service Type: Marine Services
Amount: 50000
Quotation Date: 2024-01-15T10:30:00
Status: Generated
Quotation Generated: Yes
```

## 🔍 Customization

### Add New Quotation Type
```java
// In QuotationConfig.java
public enum QuotationType {
    // ... existing types ...
    CUSTOM_SERVICE("Custom Service");
    
    // Add field mappings
    Map<String, String> customService = new HashMap<>();
    customService.put("service_type", "Custom Service");
    customService.put("description", "Your description");
    FIELD_MAPPINGS.put(QuotationType.CUSTOM_SERVICE, customService);
}
```

### Modify Customer Data
```java
// In QuotationConfig.java
CUSTOMER_TEMPLATES.put("company", "Your Company Name");
CUSTOMER_TEMPLATES.put("email", "your.email@company.com");
```

## 📝 Logs

- **Console**: Real-time output in Eclipse console
- **File**: Check `logs/quotation-automation.log` in project root
- **Eclipse Console**: View → Console

## 🚀 Advanced Usage

### Headless Mode
Uncomment in `QuotationAutomation.java`:
```java
options.addArguments("--headless");
```

### Custom Field Handling
Add your logic in `QuotationAutomation.java`:
```java
private void handleCustomFields() {
    // Your custom field handling code
}
```

## 📞 Support

For issues:
1. Check the console output for error messages
2. Review the logs in `logs/` directory
3. Verify website accessibility
4. Check Chrome browser compatibility

---

**Ready to automate?** Import the project and run `Main.java`! 🎯