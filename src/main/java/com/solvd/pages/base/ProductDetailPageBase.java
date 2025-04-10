package com.solvd.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class ProductDetailPageBase extends CommonPageBase {

    public ProductDetailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase clickBackToProductsButton();

    public abstract String getImageUrl();

    public abstract String getTitleLabel();

    public abstract double getPriceLabel();

    public abstract boolean isAddToCartButtonPresent();

    public abstract void clickAddToCartButton();

    public abstract boolean isRemoveFromCartButtonPresent();

    public abstract void clickRemoveFromCartButton();
}
