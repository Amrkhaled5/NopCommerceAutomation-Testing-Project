# E-Commerce Automation Testing Project

A comprehensive Selenium WebDriver automation framework for testing the nopCommerce demo website using Java, TestNG, Page Object Model design pattern, and Allure reporting.

## 🚀 Project Overview

This project automates end-to-end testing scenarios for an e-commerce application, covering user registration, login, product search, wishlist functionality, currency selection, and social media integrations with comprehensive test reporting.

**Test Site:** [nopCommerce Demo](https://demo.nopcommerce.com/)

## 🛠️ Technology Stack

- **Programming Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Testing Framework:** TestNG
- **Design Pattern:** Page Object Model (POM)
- **Build Tool:** Maven
- **WebDriver Management:** WebDriverManager
- **Reporting:** Allure Framework
- **Test Results:** JSON, XML, and HTML reports

## 📁 Project Structure

```
src/
├── main/java/
│   └── Pages/
│       ├── BasePage.java              # Base page with common utilities
│       ├── HomePage.java              # Home page interactions
│       ├── LoginPage.java             # Login functionality
│       ├── RegisterPage.java          # User registration
│       ├── RegisterResultPage.java    # Registration confirmation
│       ├── SearchResultPage.java      # Search results handling
│       ├── ProductPage.java           # Individual product page
│       └── WishListPage.java          # Wishlist functionality
│
├── test/java/
│   ├── base/
│   │   └── BaseTest.java              # Base test configuration
│   ├── Home/
│   │   ├── CurrenciesTest.java        # Currency switching tests
│   │   ├── FollowUsTest.java          # Social media links tests
│   │   ├── SearchTest.java            # Product search tests
│   │   ├── SliderTest.java            # Homepage slider tests
│   │   └── WishlistTest.java          # Wishlist functionality tests
│   ├── Login/
│   │   └── LoginTest.java             # User authentication tests
│   └── Register/
│       └── RegisterTest.java          # User registration tests
│
├── testng.xml                         # TestNG suite configuration
└── allure-results/                    # Generated test results (auto-created)
```

## ✨ Key Features

### 🎯 Test Coverage
- **User Management:** Registration, Login/Logout
- **Product Search:** By name and SKU
- **E-commerce Features:** Wishlist, Currency selection
- **UI Elements:** Sliders, Social media links
- **Validation:** Message content, colors, URL verification

### 🏗️ Framework Features
- **Page Object Model:** Clean separation of page logic and tests
- **Base Classes:** Reusable components for pages and tests
- **Wait Strategies:** Explicit waits for stable test execution
- **Assertions:** Both hard and soft assertions using TestNG
- **Sequential Test Execution:** Organized test suite with TestNG XML configuration
- **Rich Reporting:** Allure framework integration with detailed test reports
- **Screenshot Capture:** Automatic screenshot capture on test failures
- **Test Analytics:** Comprehensive test metrics and trends

## 📈 Report Analysis

### Understanding Allure Reports

**🟢 Passed Tests**
- All assertions successful
- No exceptions thrown
- Expected behavior verified

**🔴 Failed Tests**
- Contains failure screenshots
- Detailed error messages
- Stack trace information
- Reproduction steps

**🟡 Broken Tests**
- Infrastructure issues
- Setup/teardown problems
- Environment configuration errors

**⏸️ Skipped Tests**
- Dependency failures
- Conditional execution
- Configuration issues

## 🚦 Getting Started

### Prerequisites
- Java 8 or higher
- Maven 3.6 or higher
- Chrome browser (primary)
- IDE (IntelliJ IDEA/Eclipse recommended)
- Allure Command Line Tool (for report generation)


## 📊 Allure Reporting Features

### 📈 Dashboard Overview
- **Test execution summary** with pass/fail statistics
- **Trend charts** showing test results over time
- **Test duration** and performance metrics
- **Flaky tests** identification and tracking

### 📋 Detailed Test Reports
- **Step-by-step execution** details
- **Screenshots** for failed test cases
- **Browser logs** and console outputs
- **Test categories** and severity levels
- **Environment information** and test configuration

### 🔍 Advanced Analytics
- **Test suites breakdown** by categories
- **Execution timeline** with detailed timing
- **Historical data** and trend analysis
- **Custom labels** and test organization

## 📄 TestNG Configuration

The project includes a `testng.xml` file that orchestrates the execution of all test packages in a sequential manner:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="FullSuite" parallel="false">
    <test name="SequentialTests">
        <classes>
            <!-- Register tests -->
            <class name="Register.RegisterTest"/>

            <!-- Login tests -->
            <class name="Login.LoginTest"/>

            <!-- Home page tests -->
            <class name="Home.CurrenciesTest"/>
            <class name="Home.FollowUsTest"/>
            <class name="Home.SearchTest"/>
            <class name="Home.SliderTest"/>
            <class name="Home.WishlistTest"/>
        </classes>
    </test>
</suite>
```

### Suite Configuration Details
- **Sequential Execution:** `parallel="false"` ensures tests run one after another
- **Organized Flow:** Tests are arranged logically starting with user registration, then login, followed by feature tests
- **Complete Coverage:** All test classes are included in a single executable suite
- **Allure Integration:** Automatic result generation during test execution

## 📋 Test Scenarios

| Test Suite | Description | Test Cases | Report Category |
|------------|-------------|------------|-----------------|
| **Registration** | User account creation | Valid registration with confirmation | User Management |
| **Login** | User authentication | Valid/Invalid login scenarios | Authentication |
| **Search** | Product discovery | Search by name, Search by SKU | Product Features |
| **Wishlist** | Product saving | Add to wishlist, Verify wishlist content | E-commerce |
| **Currency** | Internationalization | Euro symbol validation | Localization |
| **Social Media** | External integrations | Facebook, Twitter, YouTube, RSS links | External Links |
| **UI Components** | Interactive elements | Homepage slider navigation | UI/UX |

## 📊 Test Execution Flow

1. **Registration Tests** - Create new user accounts
2. **Login Tests** - Authenticate existing users
3. **Currency Tests** - Validate currency switching functionality
4. **Social Media Tests** - Verify external link integrations
5. **Search Tests** - Test product search capabilities
6. **Slider Tests** - Validate homepage UI components
7. **Wishlist Tests** - Test product wishlist features

Each step is documented in the Allure report with detailed execution information.



