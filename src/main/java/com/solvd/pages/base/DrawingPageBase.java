package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends CommonPageBase{

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDrawingScreenVisible();

    public abstract void drawLine(int startX, int starY, int endX, int endY);
}
