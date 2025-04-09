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


    public ProductDetailPage(WebDriver driver) {
        super(driver);
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
    public String getPrice() {
        return price.getText();
    }

    @Override
    public void clickAddToCartButton() {
        addToCartButton.click();
    }


}
