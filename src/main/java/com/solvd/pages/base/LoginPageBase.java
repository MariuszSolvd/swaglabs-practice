package com.solvd.pages.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public ProductPageBase login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLogin();
        return initPage(getDriver(), ProductPageBase.class);
    }

    public abstract void typeUsername(String username);

    public abstract void typePassword(String password);

    public abstract void clickLogin();

    public abstract String getErrorMessage();
}
