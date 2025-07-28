# E-Commerce Automation Testing Project

A comprehensive Selenium WebDriver automation framework for testing the nopCommerce demo website using Java, TestNG, and the Page Object Model design pattern.

## 🚀 Project Overview

This project automates end-to-end testing scenarios for an e-commerce application, covering user registration, login, product search, wishlist functionality, currency selection, and social media integrations.

**Test Site:** [nopCommerce Demo](https://demo.nopcommerce.com/)

## 🛠️ Technology Stack

- **Programming Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Testing Framework:** TestNG
- **Design Pattern:** Page Object Model (POM)
- **Build Tool:** Maven (implied)
- **WebDriver Management:** WebDriverManager

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
└── testng.xml                         # TestNG suite configuration
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

## 🚦 Getting Started

### Prerequisites
- Java 8 or higher
- Maven
- Chrome browser (primary)
- IDE (IntelliJ IDEA/Eclipse recommended)

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

## 📋 Test Scenarios

| Test Suite | Description | Test Cases |
|------------|-------------|------------|
| **Registration** | User account creation | Valid registration with confirmation |
| **Login** | User authentication | Valid/Invalid login scenarios |
| **Search** | Product discovery | Search by name, Search by SKU |
| **Wishlist** | Product saving | Add to wishlist, Verify wishlist content |
| **Currency** | Internationalization | Euro symbol validation |
| **Social Media** | External integrations | Facebook, Twitter, YouTube, RSS links |
| **UI Components** | Interactive elements | Homepage slider navigation |

## 📊 Test Execution Flow

1. **Registration Tests** - Create new user accounts
2. **Login Tests** - Authenticate existing users
3. **Currency Tests** - Validate currency switching functionality
4. **Social Media Tests** - Verify external link integrations
5. **Search Tests** - Test product search capabilities
6. **Slider Tests** - Validate homepage UI components
7. **Wishlist Tests** - Test product wishlist features

## 🔧 Customization

### Adding New Tests
1. Create test class in appropriate package (`Home/`, `Login/`, `Register/`)
2. Add the class to `testng.xml` in desired execution order
3. Follow the existing Page Object Model pattern

### Modifying Execution Order
Edit the `testng.xml` file to rearrange the `<class>` elements in your preferred sequence.

### Parallel Execution
To enable parallel execution, change `parallel="false"` to `parallel="classes"` or `parallel="methods"` in the suite configuration.
