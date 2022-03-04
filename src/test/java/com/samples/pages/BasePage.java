package com.samples.pages;

import com.samples.enums.VisualElements;
import com.samples.steps.BaseSteps;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {

    protected BaseSteps baseSteps;

    public BasePage(BaseSteps baseSteps){
        this.baseSteps = baseSteps;
        PageFactory.initElements(baseSteps.getDriver(), this);
    }

    public void verifyAppearanceOfU(VisualElements elements){
        boolean isEqual = baseSteps.compareScreenshots("screenshots/" + elements.getValue() + ".png");
        Assert.assertTrue(isEqual, String.format("%s ui appearance is not as expected", elements));
    }

    public abstract boolean verifyPage();
}
