@echo off
REM Stage Marine Quotation Automation Runner for Windows
REM This script runs the quotation automation process

echo ==========================================
echo Stage Marine Quotation Automation
echo ==========================================

REM Check if Java is installed
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Error: Java is not installed or not in PATH
    echo Please install Java 11 or higher
    pause
    exit /b 1
)

REM Check if Maven is installed
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Error: Maven is not installed or not in PATH
    echo Please install Maven 3.6 or higher
    pause
    exit /b 1
)

echo Java version:
java -version 2>&1 | findstr "version"
echo.
echo Maven version:
mvn -version 2>&1 | findstr "Apache Maven"
echo.

REM Clean and compile the project
echo Building the project...
mvn clean compile

if %errorlevel% neq 0 (
    echo Error: Build failed
    pause
    exit /b 1
)

echo Build successful!
echo.

REM Run the automation
echo Starting quotation automation...
echo The browser will open and automatically fill the quotation form.
echo Please wait for the process to complete...
echo.

mvn exec:java -Dexec.mainClass="com.stagemarine.automation.Main"

echo.
echo Automation completed!
echo Check the logs directory for detailed information.
pause