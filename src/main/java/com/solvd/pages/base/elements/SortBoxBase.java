package com.solvd.pages.base.elements;

import com.solvd.pages.base.CommonPageBase;
import com.solvd.utilis.enums.Sorter;
import org.openqa.selenium.WebDriver;

public abstract class SortBoxBase extends CommonPageBase {

    public SortBoxBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickSortButton(Sorter sorter);

}
