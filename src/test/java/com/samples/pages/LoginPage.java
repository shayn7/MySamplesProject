package com.samples.pages;

import com.samples.steps.BaseSteps;

public class LoginPage extends BasePage{

    public LoginPage(BaseSteps baseSteps) {
        super(baseSteps);
    }

    @Override
    public boolean verifyPage() {
        return false;
    }
}
