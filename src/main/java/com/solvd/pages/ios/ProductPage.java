package com.solvd.pages.ios;

import com.solvd.pages.base.ProductPageBase;
import com.solvd.pages.base.elements.SortBase;
import com.solvd.pages.ios.elements.Product;
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
    private List<Product> products;

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
    public SortBase clickOnSortButton() {
        sortButton.click();
        return initPage(SortBase.class);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

}
