# Quick Start Guide - Stage Marine Quotation Automation

## 🚀 Get Started in 5 Minutes

### 1. Prerequisites Check
Make sure you have:
- ✅ Java 11+ installed
- ✅ Maven 3.6+ installed  
- ✅ Chrome browser installed
- ✅ Internet connection

### 2. Run the Automation

#### On Linux/Mac:
```bash
./run-automation.sh
```

#### On Windows:
```cmd
run-automation.bat
```

#### Manual Maven Command:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.stagemarine.automation.Main"
```

### 3. What Happens Next?

1. **Browser Opens**: Chrome will automatically open
2. **Navigation**: Goes to https://stagemarine.oicgulf.ae/quote/
3. **Form Filling**: Automatically detects and fills form fields
4. **Submission**: Submits the quotation form
5. **Verification**: Waits for quotation generation
6. **Results**: Displays quotation summary

### 4. Customization

#### Change Customer Information:
Edit `src/main/java/com/stagemarine/automation/QuotationConfig.java`:

```java
CUSTOMER_TEMPLATES.put("company", "Your Company Name");
CUSTOMER_TEMPLATES.put("email", "your.email@company.com");
```

#### Change Quotation Type:
Modify the `QuotationType` enum in `QuotationConfig.java`

#### Add New Fields:
Update the `FIELD_MAPPINGS` in `QuotationConfig.java`

### 5. Troubleshooting

#### Common Issues:

**Chrome Driver Error:**
```bash
# Update Chrome browser
# The automation will automatically download the correct driver
```

**Form Not Detected:**
- Check if website structure changed
- Review form selectors in `QuotationConfig.java`
- Check browser console for errors

**Build Errors:**
```bash
# Clean and rebuild
mvn clean install
```

### 6. Test the Automation

Run tests to verify everything works:

```bash
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=QuotationAutomationTest#testCompleteQuotationProcess
```

### 7. Monitor and Debug

- **Logs**: Check `logs/quotation-automation.log`
- **Screenshots**: Taken automatically on errors
- **Console Output**: Real-time progress information

### 8. Advanced Usage

#### Headless Mode:
Uncomment in `QuotationAutomation.java`:
```java
options.addArguments("--headless");
```

#### Custom Data Source:
Modify `QuotationData.java` to integrate with your data systems

#### CI/CD Integration:
Use the TestNG tests in your CI/CD pipeline

## 📁 Project Structure

```
├── src/main/java/com/stagemarine/automation/
│   ├── Main.java                    # Run automation
│   ├── QuotationAutomation.java     # Core logic
│   ├── QuotationData.java           # Data model
│   └── QuotationConfig.java         # Configuration
├── src/test/java/                   # Test cases
├── run-automation.sh                # Linux/Mac runner
├── run-automation.bat               # Windows runner
├── pom.xml                          # Maven config
└── README.md                        # Full documentation
```

## 🔧 Configuration Options

### Automation Settings:
- `headless`: Run without browser window
- `screenshotOnError`: Capture screenshots on failures
- `waitTimeout`: Page load timeout (seconds)
- `retryAttempts`: Number of retry attempts
- `keepBrowserOpen`: Keep browser open after completion

### Quotation Types:
- Marine Services
- Equipment Rental
- Consulting Services
- Maintenance Services
- Transport Services

## 📊 Expected Results

After successful automation, you should see:

```
Quotation Summary:
================
Customer Name: John Doe
Customer Email: john.doe@example.com
Company: Test Company Ltd
Service Type: Marine Services
Amount: 75000
Quotation Date: 2024-01-15T10:30:00
Status: Generated
Quotation Generated: Yes
```

## 🆘 Need Help?

1. **Check logs**: `logs/quotation-automation.log`
2. **Review README.md**: Full documentation
3. **Run tests**: `mvn test` to verify setup
4. **Check website**: Ensure https://stagemarine.oicgulf.ae/quote/ is accessible

## ⚡ Performance Tips

- Use headless mode for faster execution
- Adjust wait timeouts based on website performance
- Run during off-peak hours for better response times
- Consider running multiple instances for bulk quotations

---

**Ready to automate?** Run `./run-automation.sh` (Linux/Mac) or `run-automation.bat` (Windows) and watch the magic happen! 🎯