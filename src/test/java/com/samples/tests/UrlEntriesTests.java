package com.samples.tests;

import com.samples.enums.Pages;
import com.samples.enums.VisualElements;
import com.samples.pages.LoginPage;
import org.testng.annotations.Test;

public class UrlEntriesTests extends TestSetup{

    @Test(priority = 1, description = "a logged in user log from another tab")
    public void userLoggedOutFromAnotherTab(){
        baseSteps.startSession();
        baseSteps.getUrl(LOGIN_URL);
        baseSteps.iShouldBeOnPage(Pages.LOGIN_PAGE);
        baseSteps.openNewWindow();
        baseSteps.switchWindow();
        baseSteps.getUrl("www.nba.com");
        LoginPage page = baseSteps.getExpectedPage();
        page.verifyAppearanceOfU(VisualElements.ERROR_MESSAGE);
        baseSteps.closeWindow();
        baseSteps.switchToParentWindow(baseSteps.getParentWindow());
        //....... just an example
    }
}
