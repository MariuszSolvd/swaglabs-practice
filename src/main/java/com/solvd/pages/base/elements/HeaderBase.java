package com.solvd.pages.base.elements;

import com.solvd.pages.base.CommonPageBase;
import com.solvd.pages.base.MenuPageBase;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends CommonPageBase {

    public HeaderBase(WebDriver driver) {
        super(driver);
    }

    public abstract MenuPageBase clickHamburgerButton();

    public abstract void clickCartButton();

}
