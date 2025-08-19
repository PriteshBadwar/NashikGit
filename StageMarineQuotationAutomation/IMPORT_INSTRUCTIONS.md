# 📥 Eclipse Import Instructions

## 🎯 Complete Eclipse Project Ready to Import

This folder contains a **complete, ready-to-run Eclipse project** for Stage Marine quotation automation.

## 📋 What You Get

✅ **Complete Java Source Code** - All automation logic  
✅ **Maven Configuration** - Dependencies automatically managed  
✅ **Eclipse Project Files** - Ready to import  
✅ **TestNG Tests** - Comprehensive testing framework  
✅ **Logging Configuration** - Professional logging setup  
✅ **Documentation** - Complete usage guides  

## 🚀 Import Steps

### 1. Open Eclipse
- Launch Eclipse IDE
- Ensure you have Java 11+ installed

### 2. Import Project
```
File → Import → Maven → Existing Maven Projects
Browse to: [this folder path]
Select the project → Finish
```

### 3. Wait for Maven
- Eclipse will download all dependencies
- Watch progress bar at bottom-right
- Wait for "Build Successful"

### 4. Run Automation
```
Right-click Main.java → Run As → Java Application
```

## 📁 Project Structure

```
StageMarineQuotationAutomation/
├── 📁 src/main/java/com/stagemarine/automation/
│   ├── 🚀 Main.java                    # START HERE - Run this!
│   ├── 🤖 QuotationAutomation.java     # Core automation engine
│   ├── 📊 QuotationData.java           # Data model
│   └── ⚙️ QuotationConfig.java         # Configuration & customization
├── 📁 src/main/resources/
│   └── 📝 logback.xml                  # Logging configuration
├── 📁 src/test/java/com/stagemarine/automation/
│   └── 🧪 QuotationAutomationTest.java # TestNG test suite
├── 📄 pom.xml                          # Maven dependencies
├── 📄 testng.xml                       # Test configuration
├── 📄 .classpath                       # Eclipse classpath
├── 📄 .project                         # Eclipse project file
├── 📖 README.md                        # Complete documentation
└── 🚀 ECLIPSE_QUICK_START.md          # Quick start guide
```

## 🔧 Prerequisites

- **Eclipse IDE** (2021-12 or later)
- **Java 11+** (OpenJDK or Oracle JDK)
- **Chrome Browser** installed
- **Internet Connection** (for website access)

## 🎯 What It Does

1. **Opens Chrome** automatically
2. **Navigates** to Stage Marine quotation page
3. **Detects** form fields intelligently
4. **Fills** form with appropriate data
5. **Submits** quotation automatically
6. **Waits** for quotation generation
7. **Displays** results in console

## 🛠️ Customization

Edit `QuotationConfig.java` to modify:
- Customer information
- Quotation types
- Service descriptions
- Budget amounts
- Field mappings

## 🧪 Testing

Run tests with:
```
Right-click QuotationAutomationTest.java → Run As → TestNG Test
```

## 📝 Logs

- **Console**: Real-time output in Eclipse
- **File**: `logs/quotation-automation.log`
- **Level**: DEBUG for detailed information

## 🆘 Troubleshooting

### Common Issues:
1. **Maven Dependencies**: Right-click → Maven → Update Project
2. **Java Version**: Properties → Java Compiler → Set to 11+
3. **Build Errors**: Project → Clean...
4. **Chrome Issues**: Ensure Chrome is installed

### Debug Mode:
- Add breakpoints in code
- Right-click → Debug As → Java Application
- Use Debug Perspective

## 🎉 Success Indicators

After running `Main.java`, you should see:
- Chrome browser opens
- Form gets filled automatically
- Console shows progress
- Final quotation summary displayed

## 📞 Support

If you encounter issues:
1. Check console output for errors
2. Verify Java version (11+)
3. Ensure Chrome browser is installed
4. Check internet connectivity

---

## 🚀 **Ready to Go!**

**Import this project into Eclipse and run `Main.java` to see the automation in action!**

The project is **100% complete** and **ready to run** - no additional setup required beyond importing into Eclipse.