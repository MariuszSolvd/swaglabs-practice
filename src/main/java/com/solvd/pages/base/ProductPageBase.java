package com.solvd.pages.base;

import com.solvd.pages.base.elements.SortBoxBase;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends CommonPageBase {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SortBoxBase clickOnSortButton();

    public abstract int getProductCount();
}
