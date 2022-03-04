package com.samples.driver;

import com.samples.enums.Environments;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static synchronized WebDriver getDriver(Environments environment, MutableCapabilities options){
        switch (environment){
            case LOCAL_CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = (ChromeOptions) options;
                return new ChromeDriver(chromeOptions);
            case LOCAL_FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = (FirefoxOptions) options;
                return new FirefoxDriver(firefoxOptions);
            default: throw new RuntimeException("driver not created!");
        }
    }

    public static synchronized WebDriver getRemoteDriver(String remoteUrl, MutableCapabilities options){
        URL url = getUrl(remoteUrl);
        return new RemoteWebDriver(url, options);
    }

    private static URL getUrl(String remoteUrl) {
        URL url = null;
        try {
            url = new URL(remoteUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
