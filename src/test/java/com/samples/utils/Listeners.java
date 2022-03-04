package com.samples.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.samples.tests.TestSetup;

public class Listeners implements ITestListener {

    private static final Logger log = LoggerFactory.getLogger(Listeners.class);

    @Override
    public void onTestFailure(ITestResult result){
       log.info(String.format("test %s was failed", result.getName()));
        TestSetup testSetup = (TestSetup) result.getInstance();
        WebDriver driver = testSetup.getBaseSteps().getDriver();
        if(driver != null){
            takeScreenshot(driver);
            saveTextLog(String.format("current URL is: %s", driver.getCurrentUrl()));
        }
    }

    @Attachment(value = "failure in method {0}", type = "image/png")
    private byte[] takeScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "{0}", type = "text/plain")
    private String saveTextLog(String message) {return message; }
}
