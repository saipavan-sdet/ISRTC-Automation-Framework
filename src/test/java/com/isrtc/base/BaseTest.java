package com.isrtc.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Properties prop;
    

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        // Load config
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);

        // Read browser
        String browser = prop.getProperty("browser").trim();

        // Initialize driver through DriverFactory (ThreadLocal inside DriverFactory)
        DriverFactory.initDriver(browser);

        // Maximize if enabled
        if (prop.getProperty("maximize").equalsIgnoreCase("true")) {
            DriverFactory.getDriver().manage().window().maximize();
        }

        // Implicit wait
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate
        DriverFactory.getDriver().get(prop.getProperty("baseUrl").trim());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
