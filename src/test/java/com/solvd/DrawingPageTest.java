package com.solvd;

import com.solvd.pages.base.DrawingPageBase;
import com.solvd.pages.base.MenuPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.solvd.pages.base.elements.HeaderBase;
import com.zebrunner.carina.webdriver.Screenshot;
import com.zebrunner.carina.webdriver.ScreenshotType;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.assertTrue;

public class DrawingPageTest extends BaseMobileTest {

    @Test
    public void drawingTest() {
        ProductPageBase productPage = loginService.loginToApp();
        assertTrue(productPage.isOpened(), "Product page is not open after login!");
        HeaderBase header = initPage(HeaderBase.class);
        MenuPageBase menuPage = header.clickHamburgerButton();
        DrawingPageBase drawingPage = menuPage.clickDrawingButton();
        assertTrue(drawingPage.isOpened(), "Drawing Page is not open");
        assertTrue(drawingPage.isDrawingScreenVisible(), "Drawing Screen did not load up correctly");
        Path drawingScreenshotBefore = Screenshot
                .capture(getDriver(),
                ScreenshotType.EXPLICIT_FULL_SIZE,
                "drawing screen")
                .get();
        drawingPage.drawLine(200, 300, 800, 300);
        Screenshot.capture(getDriver(), ScreenshotType.EXPLICIT_FULL_SIZE, "drawing line");

    }
}
