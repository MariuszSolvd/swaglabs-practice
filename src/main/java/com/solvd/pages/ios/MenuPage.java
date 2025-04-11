package com.solvd.pages.ios;

import com.solvd.pages.base.DrawingPageBase;
import com.solvd.pages.base.LoginPageBase;
import com.solvd.pages.base.MenuPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    @ExtendedFindBy(accessibilityId = "test-DRAWING")
    private ExtendedWebElement drawingButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return isOpened(IS_OPENED_DEFAULT_TIMEOUT);
    }

    @Override
    public boolean isOpened(int timeout) {
        return logoutButton.isElementPresent(timeout);
    }

    @Override
    public LoginPageBase clickLogoutButton() {
        logoutButton.click();
        return initPage(LoginPageBase.class);
    }

    @Override
    public DrawingPageBase clickDrawingButton() {
        drawingButton.click();
        return initPage(DrawingPageBase.class);
    }
}
