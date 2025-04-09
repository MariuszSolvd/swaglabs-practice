package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class ProductDetailPageBase extends CommonPageBase {

    public ProductDetailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase clickBackToProductsButton();

    public abstract String getImage();

    public abstract String getTitle();

    public abstract double getPrice();

    public abstract void clickAddToCartButton();
}
