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
- **Browser Support:** Chrome (primary), Firefox, Edge

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
- **Cross-browser Support:** Chrome, Firefox, Edge
- **Assertions:** Both hard and soft assertions using TestNG

## 🚦 Getting Started

### Prerequisites
- Java 8 or higher
- Maven
- Chrome browser (primary)
- IDE (IntelliJ IDEA/Eclipse recommended)

### Installation

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd selenium-automation-project
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

3. **Run all tests:**
   ```bash
   mvn test
   ```

4. **Run specific test class:**
   ```bash
   mvn test -Dtest=LoginTest
   ```

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

