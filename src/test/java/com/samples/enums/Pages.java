package com.samples.enums;

import com.samples.steps.BaseSteps;
import com.samples.pages.BasePage;
import com.samples.pages.LoginPage;

public enum Pages {

    LOGIN_PAGE(){
        @Override
        public BasePage getPage(BaseSteps baseSteps) {
            return new LoginPage(baseSteps);
        }
    };

    public abstract BasePage getPage(BaseSteps baseSteps);
}
