package com.solvd.pages.ios;

import com.solvd.pages.base.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {

    @ExtendedFindBy(iosPredicate = "value == \"DRAWING\"")
    private ExtendedWebElement drawingTitleLabel;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWebView[$type == 'XCUIElementTypeOther' AND name == 'Signature Pad demo'$][-1]")
    private ExtendedWebElement drawingScreen;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDrawingScreenVisible() {
        return drawingScreen.isElementPresent(5);
    }

    @Override
    public boolean isOpened() {
        return isOpened(IS_OPENED_DEFAULT_TIMEOUT);
    }

    @Override
    public boolean isOpened(int timeout) {
        return drawingTitleLabel.isElementPresent(timeout);
    }

    @Override
    public void drawLine(int startX, int starY, int endX, int endY) {
        swipe(startX, starY, endX, endY, 100);
    }

}
