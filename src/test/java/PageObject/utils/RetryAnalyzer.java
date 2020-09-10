package test.java.PageObject.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private final int MAX_RETRY = 2;
    private int count_retry = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count_retry < MAX_RETRY) {
            count_retry++;
            return true;
        }
        return false;
    }
}
