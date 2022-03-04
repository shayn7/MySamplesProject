package com.samples.tests;

import com.samples.configuration.E2EContextConfiguration;
import com.samples.steps.BaseSteps;
import com.samples.steps.EnvironmentFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({com.samples.utils.Listeners.class})
@ContextConfiguration(classes = E2EContextConfiguration.class)
public class TestSetup extends AbstractTestNGSpringContextTests {

    protected BaseSteps baseSteps;
    protected String endpoint;
    protected static final String LOGIN_URL = "www.rovers.co.uk";

    public BaseSteps getBaseSteps(){
        return baseSteps;
    }

    @BeforeSuite
    public void setData() throws Exception {
        super.springTestContextPrepareTestInstance();
        endpoint = System.getProperty("endpoint", "www.amazon.com");
    }

    @BeforeMethod
    public void setup(){
        String environmentToUse = System.getProperty("environment", "local_chrome");
        this.baseSteps = EnvironmentFactory.getEnvironment(environmentToUse);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (baseSteps != null) this.baseSteps.tearDown();
    }

    /*
    maven command: mvn clean test -Dendpoint=${endpoint} -DsuiteXmlFile=${suiteXmlFile} -Denvironment=${environment} -Dhub=${hub}
    allure report command: allure serve allure-results
     */
}
