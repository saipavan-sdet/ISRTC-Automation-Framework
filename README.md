# ISRTC Automation Framework

A professional end-to-end automation framework for ISRTC ticket booking, built using **Selenium**, **Java**, **TestNG**, and **Page Object Model (POM)**.  
This project demonstrates real-world UI automation skills aligned with SDET interview expectations.

---

## 🎯 Project Objective

To automate the core user journey of the ISRTC application:

✅ Launch application  
✅ Search buses  
✅ Apply filters  
✅ Select seat  
✅ Enter passenger details  
✅ Proceed to booking confirmation  

This project showcases practical automation capabilities used in modern testing teams.

---

## 🧰 Tech Stack

| Category | Tools / Technologies |
|----------|---------------------|
| Programming | Java |
| UI Automation | Selenium WebDriver |
| Test Framework | TestNG |
| Design Pattern | Page Object Model (POM) |
| Build Tool | Maven |
| Reporting | Extent Report / Allure (Upcoming) |
| Language Level | Java 8+ |

---

## ✅ Framework Highlights

✔ Page Object Model with page classes  
✔ TestNG test management  
✔ Centralized driver management  
✔ Reusable utility methods  
✔ Config-driven execution  
✔ Maven dependency handling  
✔ Assertions & validations  
✔ Structured test data handling  

---

## 📂 Framework Structure

```
ISRTC-Automation-Framework
│
├── src/test/java
│   ├── tests          # TestNG test classes
│   ├── pages          # Page Object classes
│   ├── utils          # Helpers & utilities
│
├── src/main/resources
│   └── config.properties  # Environment config
│
├── pom.xml               # Maven dependencies
├── testng.xml            # Test execution suite
└── README.md
```

---

## 🚀 How to Run Tests

### 1️⃣ Clone the repository
```bash
git clone https://github.com/saipavan-sdet/ISRTC-Automation-Framework.git
```

### 2️⃣ Install dependencies
```bash
mvn clean install
```

### 3️⃣ Execute test suite
```bash
mvn test
```

---

## 📊 Test Reports

Reports will be available after execution under:

```
/test-output
```

Upcoming:

✅ Extent Report  
✅ Allure Report  

---

## 🔐 Test Data & Configurations

Configurable via:

```
/src/main/resources/config.properties
```

Includes:

✅ Base URL  
✅ Browser  
✅ Wait timeouts  

---

## 🧪 Sample Validations Performed

✅ Page title verification  
✅ Element presence and visibility  
✅ Dropdown and filter behavior  
✅ Error handling scenarios  

---

## 🏗 Upcoming Enhancements

🔹 Parallel execution  
🔹 Cross-browser execution  
🔹 Jenkins CI pipeline integration  
🔹 Screenshot attachment in reports  
🔹 Retry mechanism for flaky tests  
🔹 Logging with Log4j  

---

## 🙋‍♂️ Author

**Sai Pavan – SDET | Automation Engineer**

🔗 LinkedIn: https://www.linkedin.com/in/saipavan-emmadi-468a59258/  
📧 Email: saipavanemmadi28@gmail.com  

---

## ⭐ Contribution & Feedback

If you are a recruiter, interviewer, or collaborator —  
feedback and suggestions are welcome!
