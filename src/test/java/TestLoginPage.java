import com.solvd.pages.base.LoginPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.solvd.utilis.AuthError;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class TestLoginPage extends AbstractTest {

    @Test
    public void loginTest() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not open");
        ProductPageBase productPage = loginPage.login(R.TESTDATA.get("standard_user"), R.TESTDATA.get("correct_password"));
        assertTrue(productPage.isOpened(),"Product page is not Open");
    }

    @Test
    public void wrongCredentialTest() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not open");
        loginPage.login("no_user", "no_password");
        assertEquals(loginPage.getErrorMessage(),
                AuthError.DO_NOT_MATCH_SERVICE.getMessage(),
                "'Username and password do not match any user in this service.', Error message is not shown");
    }

    @Test
    public void missingUsernameTest() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not open");
        loginPage.typePassword(R.TESTDATA.get("correct_password"));
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorMessage(),
                AuthError.USERNAME_REQUIRED.getMessage(),
                "'Username is required', Error message is not shown");
    }

    @Test
    public void missingPasswordTest() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not open");
        loginPage.typeUsername(R.TESTDATA.get("standard_user"));
        loginPage.clickLoginButton();
        assertEquals(loginPage.getErrorMessage(),
                AuthError.PASSWORD_REQUIRED.getMessage(),
                "'Password is required', Error message is not shown");
    }

    @Test
    public void lockedUserTest() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not open");
        loginPage.login(R.TESTDATA.get("locked_user"), R.TESTDATA.get("correct_password"));
        assertEquals(loginPage.getErrorMessage(),
                AuthError.LOCKED_USER.getMessage(),
                "'Sorry, this user has been locked out.', Error message is not shown");
    }
}

