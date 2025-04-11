package com.solvd.pages.ios.elements;

import com.solvd.pages.base.elements.SortBoxBase;
import com.solvd.utilis.enums.Sorter;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SortBoxBase.class)
public class SortBox extends SortBoxBase {

    @ExtendedFindBy(iosPredicate = "name == \"Name (A to Z)\"")
    private ExtendedWebElement sortNameAToZButton;

    @ExtendedFindBy(iosPredicate = "name == \"Name (Z to A)\"")
    private ExtendedWebElement sortNameZToAButton;

    @ExtendedFindBy(iosPredicate = "name == \"Price (low to high)\"")
    private ExtendedWebElement sortPriceLowToHighButton;

    @ExtendedFindBy(iosPredicate = "name == \"Price (high to low)\"")
    private ExtendedWebElement sortPriceHighToLowButton;

    public SortBox(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isOpened() {
        return isOpened(IS_OPENED_DEFAULT_TIMEOUT);
    }

    @Override
    public boolean isOpened(int timeout) {
        return sortNameAToZButton.isElementPresent(timeout);
    }

    @Override
    public void clickSortButton(Sorter sorter) {
        switch (sorter) {
            case A_TO_Z -> sortNameAToZButton.click();
            case Z_TO_A -> sortNameZToAButton.click();
            case LOW_TO_HIGH -> sortPriceLowToHighButton.click();
            case HIGH_TO_LOW -> sortPriceHighToLowButton.click();
        }
    }
}
