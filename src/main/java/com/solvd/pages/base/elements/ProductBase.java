package com.solvd.pages.base.elements;

import com.solvd.pages.base.ProductDetailPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public abstract class ProductBase extends AbstractUIObject {

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ProductDetailPageBase clickOnProduct();

    public abstract String getImage();

    public abstract String getTitle();

    public abstract String getPrice();

    public abstract void clickAddToCartButton();
}
