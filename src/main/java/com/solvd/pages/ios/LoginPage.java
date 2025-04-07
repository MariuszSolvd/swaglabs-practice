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
    private ExtendedWebElement loginForm;
    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordForm;
    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-Error message\"")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginForm);
    }

    @Override
    public ProductPageBase login(String username, String password) {
        loginForm.type(username);
        passwordForm.type(password);
        loginButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
