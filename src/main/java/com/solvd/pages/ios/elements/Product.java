package com.solvd.pages.ios.elements;

import com.solvd.pages.base.elements.ProductBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductBase.class)
public class Product extends ProductBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage")
    private ExtendedWebElement image;

    @ExtendedFindBy(iosPredicate = "name == \"test-Item title\"")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosPredicate = "name == \"test-Price\"")
    private ExtendedWebElement price;

    @ExtendedFindBy(iosPredicate = "name == \"ADD TO CART\"")
    private ExtendedWebElement addToCartButton;

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
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
