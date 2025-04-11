package com.solvd.pages.ios.elements;

import com.solvd.pages.base.MenuPageBase;
import com.solvd.pages.base.elements.HeaderBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HeaderBase.class)
public class Header extends HeaderBase {

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement hamburgerButton;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartButton;


    public Header(WebDriver driver) {
        super(driver);
    }

    @Override
    public MenuPageBase clickHamburgerButton() {
        clickButton(hamburgerButton);
        return initPage(MenuPageBase.class);
    }

    @Override
    public void clickCartButton() {
        cartButton.click();
    }

    /*
    A custom click method was used because the default click() method clicks below the intended clickable location,
    so an adjustment was necessary.
    */
    private void clickButton(ExtendedWebElement element) {
        Point point = element.getLocation();
        Dimension dimension = element.getSize();
        tap(point.getX() + dimension.getWidth() / 2, point.getY() + dimension.getHeight() / 2 + 6);
    }
}
