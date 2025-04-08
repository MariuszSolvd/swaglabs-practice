package com.solvd.pages.ios;

import com.solvd.pages.base.LoginPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement loginInput;
    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordInput;
    @ExtendedFindBy(iosPredicate = "name == \"test-Error message\"")
    private ExtendedWebElement errorMessage;
    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginInput);
    }

    @Override
    public ProductPageBase login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return clickLoginButton();
    }

    @Override
    public void typeUsername(String username) {
        loginInput.type(username);
    }

    @Override
    public void typePassword(String password) {
        passwordInput.type(password);
    }

    @Override
    public ProductPageBase clickLoginButton() {
        loginButton.click();
        return initPage(ProductPageBase.class);
    }

    @Override
    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
