# 🚀 Eclipse Quick Start Guide

## ⚡ Get Running in 3 Steps

### Step 1: Import Project
1. **File** → **Import...**
2. **Maven** → **Existing Maven Projects**
3. **Browse** to `StageMarineQuotationAutomation` folder
4. **Select** the project and click **Finish**

### Step 2: Wait for Maven
- Eclipse will automatically download dependencies
- Watch the progress bar at bottom-right
- Wait for "Build Successful" message

### Step 3: Run Automation
- **Right-click** `Main.java` in Package Explorer
- **Run As** → **Java Application**
- Watch Chrome open and automate the form!

## 🎯 What You'll See

1. **Console Output**: Real-time automation progress
2. **Chrome Browser**: Opens automatically
3. **Form Filling**: Fields get populated automatically
4. **Form Submission**: Quotation gets submitted
5. **Results**: Summary displayed in console

## 🔧 If Something Goes Wrong

### Maven Issues
```
Right-click project → Maven → Update Project
Check "Force Update of Snapshots/Releases"
```

### Java Version Issues
```
Right-click project → Properties → Java Compiler
Set compliance level to 11 or higher
```

### Build Errors
```
Project → Clean... → Select project → Clean
```

## 📁 Key Files

- **`Main.java`** → Run this to start automation
- **`QuotationConfig.java`** → Customize data here
- **`pom.xml`** → Maven dependencies
- **`testng.xml`** → Test configuration

## 🧪 Run Tests

- **Right-click** `QuotationAutomationTest.java`
- **Run As** → **TestNG Test**
- View results in TestNG Results view

## 📝 Customize

Edit `QuotationConfig.java` to change:
- Customer names and details
- Quotation types and descriptions
- Budget amounts and durations

## 🆘 Need Help?

1. **Check Console**: Look for error messages
2. **Maven Update**: Right-click → Maven → Update Project
3. **Clean Build**: Project → Clean...
4. **Check Java Version**: Ensure Java 11+ is installed

---

**That's it!** Import, wait for Maven, and run `Main.java`! 🎯