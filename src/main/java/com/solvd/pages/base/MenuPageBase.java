package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends CommonPageBase{

    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickLogoutButton();
}
