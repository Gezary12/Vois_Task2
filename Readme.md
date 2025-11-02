# Automation Project

## Table of Contents
- [Introduction](#introduction)
- [Scenario](#scenario)
- [Components](#components)
- [Features](#features)
- [How Solution Works](#how-solution-works)
- [Tools](#tools)
- [Reporting](#reporting)

---

## Introduction
This project automates the KSRTC Bus Booking flow using **Selenium WebDriver + Java + TestNG + Maven**.  
It is built following the **Page Object Model (POM)** for better maintainability and reusability.  
The framework includes **Allure Reporting** for detailed execution reports.

---

## Scenario

### Task 2 – KSRTC Bus Booking
- Open the website: `https://ksrtc.in/oprs-web/guest/home.do?h=1`
- Select the route **from "CHIKKAMAGALURU" to "BENGALURU"** from the popular routes section
- Choose the **arrival date only**
- Click on **“Search for bus”**
- Select an available **seat**
- Choose the **boarding point** and **dropping point**
- Fill in **Customer** and **Passenger** details  
  *(use phone number: `6789125987`)*
- Click **“Make Payment”**
- Fill all fields in the payment section **without submitting the payment**

---

## Components

The project follows the **Page Object Model (POM)** with a clean separation between tests, pages, and utilities.

### Main Package (`src/main/java`)
- **pages** → Page classes for each application page (BookingPage, PaymentPage, etc.)
- **utilities** → Common utility functions such as Excel reading and waits

### Test Package (`src/test/java`)
- **BaseTest** → Handles WebDriver setup, manages window resolution, and teardown
- **Test Classes** → Contain the actual automation scenarios (e.g., `ReservationTest`)
- **TestData** → Contains Excel test data files used for inputs

---

## Features
- **Maven Project Structure**
- **Page Object Model (POM)** implemented
- **Reusable Utility Methods** for Excel and waits
- **TestNG** for assertions, grouping, and reporting
- **Allure Reports** integration for detailed results
- **Expilict Waits** and synchronization for stable tests
- **Assertions** to verify that user details are filled correctly before payment

---

## How Solution Works
1. Open the project in **IntelliJ IDEA**
2. **BaseTest** initializes the browser and opens the KSRTC website
3. **Page Classes** handle element locators and interaction logic (clicks, sendKeys, selects)
4. **Test Classes** call page methods to perform the full booking workflow
5. After execution, **Allure Results** are generated automatically

---

## Tools

| Tool | Usage |
|------|--------|
| **Java** | Programming language |
| **Maven** | Build & dependency manager |
| **Selenium WebDriver** | Browser automation |
| **WebDriverManager** | Automatic driver management |
| **TestNG** | Test runner and assertions |
| **Allure Reports** | Rich reporting with screenshots |
| **IntelliJ IDEA** | IDE for development and execution |

---

## Reporting
Project uses **Allure Reports** to generate detailed execution reports including each step performed.

### To generate and view the Allure Report:
```sh
allure serve "allure-results"
