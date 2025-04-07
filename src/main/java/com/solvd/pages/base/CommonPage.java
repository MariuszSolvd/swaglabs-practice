package com.solvd.pages.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommonPage extends AbstractPage {

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    //todo: Header/Footer
}
