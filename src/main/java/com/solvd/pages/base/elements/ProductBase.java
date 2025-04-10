package com.solvd.pages.base.elements;

import com.solvd.pages.base.ProductDetailPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class ProductBase extends AbstractPage {

    public ProductBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductDetailPageBase clickOnProduct(int index);

    public abstract String getImageUrl(int index);

    public abstract String getTitle(int index);

    public abstract double getPrice(int index);

    public abstract void clickAddToCartButton(int index);

    public abstract void clickRemoveFromCartButton(int index);

    public abstract boolean isProductPresent(int index);

}
