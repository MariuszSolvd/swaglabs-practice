package com.solvd.pages.ios.elements;

import com.solvd.pages.base.ProductDetailPageBase;
import com.solvd.pages.base.elements.ProductBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductBase.class)
public class Product extends ProductBase {

    private final String FRAME_LOCATOR = "**/XCUIElementTypeOther[`name == \"test-Item\"`][%d]/";

    @ExtendedFindBy(iosClassChain = FRAME_LOCATOR + "**/XCUIElementTypeImage")
    private ExtendedWebElement image;

    @ExtendedFindBy(iosClassChain = FRAME_LOCATOR + "**/XCUIElementTypeStaticText[`name == \"test-Item title\"`]")
    private ExtendedWebElement titleLabel;

    @ExtendedFindBy(iosClassChain = FRAME_LOCATOR + "**/XCUIElementTypeStaticText[`name == \"test-Price\"`]")
    private ExtendedWebElement priceLabel;

    @ExtendedFindBy(iosClassChain = FRAME_LOCATOR + "**/XCUIElementTypeOther[`name == \"ADD TO CART\"`]")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosClassChain = FRAME_LOCATOR + "**/XCUIElementTypeOther[`name == \"test-REMOVE\"`]")
    private ExtendedWebElement removeFromCartButton;

    public Product(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductDetailPageBase clickOnProduct(int index) {
        image.format(index).click();
        return initPage(ProductDetailPageBase.class);
    }

    @Override
    public String getImageUrl(int index) {
        return image.format(index).getAttribute("name");
    }

    @Override
    public String getTitle(int index) {
        return titleLabel.format(index).getText();
    }

    @Override
    public double getPrice(int index) {
        return Double.parseDouble(priceLabel.format(index).getText().replace("$", ""));
    }

    @Override
    public void clickAddToCartButton(int index) {
        addToCartButton.format(index).click();
    }

    @Override
    public void clickRemoveFromCartButton(int index) {
        removeFromCartButton.format(index).click();
    }

}
