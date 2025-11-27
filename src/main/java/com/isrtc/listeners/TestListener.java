package com.isrtc.listeners;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.isrtc.base.DriverFactory;
import com.isrtc.reports.ExtentManager;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        System.out.println("▶ Starting Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
        System.out.println("✔ PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        // Capture screenshot and attach to report
        String path = takeScreenshot(result.getName());
        if (path != null) {
            try {
                test.get().addScreenCaptureFromPath(path);
            } catch (Exception e) {
                System.out.println("Failed to attach screenshot to report: " + e.getMessage());
            }
        }

        System.out.println("❌ FAILED: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
        System.out.println("⚠ SKIPPED: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();  // Write everything to report
    }

    private String takeScreenshot(String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
            File src = ts.getScreenshotAs(OutputType.FILE);

            // Override file each time by removing timestamp
            String path = "screenshots/" + testName + ".png";
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("📸 Screenshot captured: " + dest.getAbsolutePath());
            return path;
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
}
