package com.solvd.pages.base.elements;

import com.solvd.pages.base.CommonPageBase;
import com.solvd.pages.base.ProductPageBase;
import org.openqa.selenium.WebDriver;

public abstract class SortBoxBase extends CommonPageBase {

    public SortBoxBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase clickSortNameAToZ();

    public abstract ProductPageBase clickSortNameZToA();

    public abstract ProductPageBase clickSortPriceLowToHigh();

    public abstract ProductPageBase clickSortPriceHighToLow();

}
