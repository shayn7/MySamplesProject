package com.samples.steps;

import com.samples.enums.Environments;

public class EnvironmentFactory {

    public static synchronized BaseSteps getEnvironment(String environment){
        switch (environment){
            case "local_chrome":
                return new ChromeSteps(Environments.LOCAL_CHROME);
            case "local_firefox":
                return new FirefoxSteps(Environments.LOCAL_FIREFOX);
            case "remote":
                return new ChromeSteps(Environments.REMOTE);
            default: throw new RuntimeException("environment not supported!!");
        }
    }
}
