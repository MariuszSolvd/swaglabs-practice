package com.solvd.pages.base;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailPageBase extends CommonPageBase {

    public ProductDetailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase clickBackToProductsButton();

    public abstract String getImage();

    public abstract String getTitle();

    public abstract double getPrice();

    public abstract ExtendedWebElement getAddToCartButton();

    public abstract void clickAddToCartButton();

    public abstract ExtendedWebElement getRemoveFromCartButton();

    public abstract void clickRemoveFromCartButton();
}
