package com.samples.steps;

import com.samples.enums.Environments;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxSteps extends BaseSteps{

    protected FirefoxSteps(Environments environment) {
        super(environment);
    }

    @Override
    protected MutableCapabilities initCapabilities() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--window-size=1920,1200");
        return options;
    }

    @Override
    public void simulateSlowNetworkConnection() {

    }
}
