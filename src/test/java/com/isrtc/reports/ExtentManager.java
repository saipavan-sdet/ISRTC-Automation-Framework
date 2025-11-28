package com.isrtc.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {

            // Create reporter (overwrites existing report by default)
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");

            // Initialize ExtentReports
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // System info
            extent.setSystemInfo("Project", "ISRTC Automation");
            extent.setSystemInfo("Tester", "Saipavan");
            extent.setSystemInfo("Environment", "QA");

            // Customize report
            spark.config().setDocumentTitle("ISRTC Automation Report");
            spark.config().setReportName("ISRTC Test Execution Report");
            spark.config().setTheme(Theme.STANDARD);
        }

        return extent;
    }
}
