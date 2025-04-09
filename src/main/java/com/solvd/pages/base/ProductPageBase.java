package com.solvd.pages.base;

import com.solvd.pages.base.elements.ProductBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductPageBase extends CommonPageBase {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<? extends ProductBase> getProducts();
}
