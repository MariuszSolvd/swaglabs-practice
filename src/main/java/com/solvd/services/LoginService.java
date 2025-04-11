package com.solvd.services;

import com.solvd.pages.base.LoginPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class LoginService implements ICustomTypePageFactory {

    public ProductPageBase loginToApp(String username, String password) {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        return loginPage.login(username, password);
    }

    public ProductPageBase loginToApp() {
        return loginToApp(R.TESTDATA.get("standard_user"), R.TESTDATA.get("correct_password"));
    }
}
