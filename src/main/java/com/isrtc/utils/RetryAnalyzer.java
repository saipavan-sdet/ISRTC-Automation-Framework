package com.isrtc.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetryCount = 2;  // retry 2 times (total 3 attempts)

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("🔁 Retrying test: " + result.getName() + " | Attempt: " + retryCount);
            return true;
        }

        return false;
    }
}
