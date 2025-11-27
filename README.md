# 🚀 ISRTC Automation Framework

A complete **Java + Selenium + TestNG** automation framework designed for UI test automation.  
This project follows **Page Object Model (POM)**, supports **parallel execution**, **retry logic**, **screenshot capture**, and integrates with **Allure / Extent reports**.

---

## 📌 Tech Stack
- Java 17  
- Selenium WebDriver 4.x  
- TestNG  
- Maven  
- Page Object Model (POM)  
- Extent Reports  
- Allure Reports  
- ThreadLocal WebDriver  

---

## 📁 Project Structure
```
ISRTC-Automation-Framework
│
├── src
│   ├── main
│   │   ├── java
│   │   ├── resources
│   ├── test
│       ├── java
│       ├── resources
│
├── screenshots/
├── extent-report/
│
├── testng.xml
├── pom.xml
└── README.md
```

---

## 🚀 Features
✔ POM-based automation  
✔ Thread-safe WebDriver  
✔ Automatic screenshots on failure  
✔ TestNG Listeners  
✔ Retry failed tests  
✔ Parallel execution  
✔ TestNG Groups (sanity, regression)  
✔ Extent / Allure Reporting  

---

## 🧪 How to Run Tests
### Run full suite
```bash
mvn clean test
```

### Run group (example: regression)
```bash
mvn clean test -Dgroups=regression
```

---

## 📄 TestNG Suite (testng.xml)
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="ISRTC Suite" parallel="false">

	<listeners>
		<listener class-name="com.isrtc.listeners.TestListener" />
	</listeners>


	<test name="Sanity Tests">
		<groups>
			<run>
				<include name="sanity" />
			</run>
		</groups>
		<classes>
			<class name="com.isrtc.tests.TC001_SearchWithValidData" />
			<class name="com.isrtc.tests.TC002_BoardingAndDropping_Selection" />
			<class name="com.isrtc.tests.TC003_ContactDetails_ValidData" />
		</classes>
	</test>

	<test name="Regression Tests">
		<groups>
			<run>
				<include name="regression" />
			</run>
		</groups>
		<classes>
			<class name="com.isrtc.tests.TC004_CompleteFlow_OneWayBooking" />
		</classes>
	</test>

</suite>

```

---

## 📸 Screenshots
Failure screenshots will appear inside:

```
/screenshots/
```

---

## 📊 Reports

### Extent Report
```
/extent-report/AutomationReport.html
```

---

## 🏆 Badges

```
![Java](https://img.shields.io/badge/Java-17-blue)
![Selenium](https://img.shields.io/badge/Selenium-Automation-green)
![TestNG](https://img.shields.io/badge/TestNG-Testing-orange)
![Maven](https://img.shields.io/badge/Maven-Build-red)
```

---

## 🏗 Project Description for Portfolio

This framework is built using **Java, Selenium, TestNG, Maven**, and follows the **POM design pattern**.  
It supports:
- Parallel execution using ThreadLocal  
- Screenshot capture on failures  
- Retry mechanism for flaky tests  
- Beautiful Extent reports  
- Well-structured TestNG suites with groups  

