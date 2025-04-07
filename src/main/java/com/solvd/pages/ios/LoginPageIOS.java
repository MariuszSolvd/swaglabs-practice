package com.solvd.pages.ios;

import com.solvd.pages.base.LoginPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPage.class)
public class LoginPageIOS extends LoginPage{

    @ExtendedFindBy(accessibilityId = "test-Username")
    ExtendedWebElement loginForm;
    @ExtendedFindBy(accessibilityId = "test-Password")
    ExtendedWebElement passwordForm;
    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    ExtendedWebElement loginButton;

    public LoginPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginForm);
    }

    @Override
    public void login(String username, String password) {
        loginForm.type(username);
        passwordForm.type(password);
        loginButton.click();
        //todo: Return next page


    }


}
