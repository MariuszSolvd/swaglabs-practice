package com.solvd.pages.ios;

import com.solvd.pages.base.ProductDetailPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailPageBase.class)
public class ProductDetailPage extends ProductDetailPageBase {

    @ExtendedFindBy(iosPredicate = "name == \"test-BACK TO PRODUCTS\"")
    private ExtendedWebElement backToProductsButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Image Container\"`]/*[1]/XCUIElementTypeImage")
    private ExtendedWebElement image;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Description\"`]/*[1]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosPredicate = "name == \"test-Price\"")
    private ExtendedWebElement price;

    @ExtendedFindBy(iosPredicate = "name == \"ADD TO CART\"")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosPredicate = "name == \"test-REMOVE\"")
    private ExtendedWebElement removeFromCartButton;


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return isOpened(IS_OPENED_DEFAULT_TIMEOUT);
    }

    @Override
    public boolean isOpened(int timeout) {
        return backToProductsButton.isElementPresent(timeout);
    }

    @Override
    public ProductPageBase clickBackToProductsButton() {
        backToProductsButton.click();
        return initPage(ProductPageBase.class);
    }

    @Override
    public String getImage() {
        return image.getAttribute("name");
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    @Override
    public double getPrice() {
        return Double.parseDouble(price.getText().replace("$", ""));
    }

    @Override
    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    @Override
    public void clickRemoveFromCartButton() {
        removeFromCartButton.click();
    }


}
