package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends CommonPageBase {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase login(String username, String password);

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract ProductPageBase clickLoginButton();

    public abstract String getErrorMessage();
}
