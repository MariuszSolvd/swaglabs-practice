package com.solvd.pages.ios;

import com.solvd.pages.base.ProductPageBase;
import com.solvd.pages.base.elements.SortBoxBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"PRODUCTS\"`]")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(iosPredicate = "name == \"test-Modal Selector Button\"")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    private List<ExtendedWebElement> productContainer;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return isOpened(IS_OPENED_DEFAULT_TIMEOUT);
    }

    @Override
    public boolean isOpened(int timeout) {
        return pageTitle.isElementPresent(timeout);
    }

    @Override
    public SortBoxBase clickOnSortButton() {
        sortButton.click();
        return initPage(SortBoxBase.class);
    }

    @Override
    public int getProductCount() {
        return productContainer.size() + 1;
    }

}
