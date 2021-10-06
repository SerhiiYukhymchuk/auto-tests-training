package com.afj.solution.qa.auto.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author Tomash Gombosh
 */
@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(final ITestResult iTestResult) {
        //On Start test method
    }

    @Override
    public void onTestSuccess(final ITestResult iTestResult) {
        //On Success test method
    }

    @Override
    public void onTestFailure(final ITestResult iTestResult) {
        //On Failure test method
    }

    @Override
    public void onTestSkipped(final ITestResult iTestResult) {
        //On Skipped test method
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult iTestResult) {
        //On onTestFailedButWithinSuccessPercentage test method
    }

    @Override
    public void onStart(final ITestContext iTestContext) {
        log.info("Start tests {}", iTestContext.getCurrentXmlTest().getName());
    }

    @Override
    public void onFinish(final ITestContext iTestContext) {
        log.info("Finish tests {}", iTestContext.getCurrentXmlTest().getName());
    }
}
