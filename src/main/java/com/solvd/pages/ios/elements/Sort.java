package com.solvd.pages.ios.elements;

import com.solvd.pages.base.ProductPageBase;
import com.solvd.pages.base.elements.SortBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SortBase.class)
public class Sort extends SortBase {

    @ExtendedFindBy(iosPredicate = "name == \"Name (A to Z)\"")
    private ExtendedWebElement sortNameAToZButton;

    @ExtendedFindBy(iosPredicate = "name == \"Name (Z to A)\"")
    private ExtendedWebElement sortNameZToAButton;

    @ExtendedFindBy(iosPredicate = "name == \"Price (low to high)\"")
    private ExtendedWebElement sortPriceLowToHighButton;

    @ExtendedFindBy(iosPredicate = "name == \"Price (high to low)\"")
    private ExtendedWebElement sortPriceHighToLowButton;

    public Sort(WebDriver driver) {
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
    public ProductPageBase clickSortNameAToZ() {
        return clickOnSortButton(sortNameAToZButton);
    }

    @Override
    public ProductPageBase clickSortNameZToA() {
        return clickOnSortButton(sortNameZToAButton);
    }

    @Override
    public ProductPageBase clickSortPriceLowToHigh() {
        return clickOnSortButton(sortPriceLowToHighButton);
    }

    @Override
    public ProductPageBase clickSortPriceHighToLow() {
        return clickOnSortButton(sortPriceHighToLowButton);
    }

    private ProductPageBase clickOnSortButton(ExtendedWebElement element) {
        element.click();
        return initPage(ProductPageBase.class);
    }
}
