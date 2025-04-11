package com.solvd.pages.ios.elements;

import com.solvd.pages.base.elements.SortBoxBase;
import com.solvd.utilis.enums.Sorter;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SortBoxBase.class)
public class SortBox extends SortBoxBase {

    @ExtendedFindBy(iosPredicate = "name == \"%s\"")
    private ExtendedWebElement sortButton;

    public SortBox(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isOpened() {
        return isOpened(IS_OPENED_DEFAULT_TIMEOUT);
    }

    @Override
    public boolean isOpened(int timeout) {

        return sortButton.format(Sorter.A_TO_Z.getName()).isElementPresent(timeout);
    }

    @Override
    public void clickSortButton(Sorter sorter) {
        switch (sorter) {
            case A_TO_Z, Z_TO_A, LOW_TO_HIGH, HIGH_TO_LOW -> sortButton.format(sorter.getName()).click();
        }
    }
}
