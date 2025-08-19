#!/bin/bash

# Stage Marine Quotation Automation Runner
# This script runs the quotation automation process

echo "=========================================="
echo "Stage Marine Quotation Automation"
echo "=========================================="

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "Error: Java is not installed or not in PATH"
    echo "Please install Java 11 or higher"
    exit 1
fi

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "Error: Maven is not installed or not in PATH"
    echo "Please install Maven 3.6 or higher"
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 11 ]; then
    echo "Error: Java 11 or higher is required. Current version: $JAVA_VERSION"
    exit 1
fi

echo "Java version: $(java -version 2>&1 | head -n 1)"
echo "Maven version: $(mvn -version 2>&1 | head -n 1)"
echo ""

# Clean and compile the project
echo "Building the project..."
mvn clean compile

if [ $? -ne 0 ]; then
    echo "Error: Build failed"
    exit 1
fi

echo "Build successful!"
echo ""

# Run the automation
echo "Starting quotation automation..."
echo "The browser will open and automatically fill the quotation form."
echo "Please wait for the process to complete..."
echo ""

mvn exec:java -Dexec.mainClass="com.stagemarine.automation.Main"

echo ""
echo "Automation completed!"
echo "Check the logs directory for detailed information."