package com.solvd.pages.base;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommonPageBase extends AbstractPage {

    public CommonPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        throw new UnsupportedOperationException("Method 'isOpened' isn't implemented for current page");
    }

    public boolean isOpened(int timeout) {
        throw new UnsupportedOperationException("Method 'isOpened' isn't implemented for current page");
    }
}
