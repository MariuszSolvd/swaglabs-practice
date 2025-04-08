import com.solvd.pages.base.LoginPageBase;
import com.solvd.pages.base.ProductPageBase;
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
                "Username and password do not match any user in this service.",
                "'Username and password do not match any user in this service.', Error message is not shown");
    }

    @Test
    public void missingUsernameTest() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not open");
        loginPage.typePassword(R.TESTDATA.get("correct_password"));
        assertEquals(loginPage.getErrorMessage(),
                "Username is required",
                "'Username is required', Error message is not shown");
    }

    @Test
    public void missingPasswordTest() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not open");
        loginPage.typePassword(R.TESTDATA.get("standard_user"));
        assertEquals(loginPage.getErrorMessage(),
                "Password is required",
                "'Password is required', Error message is not shown");
    }

    @Test
    public void lockedUserTest() {
        LoginPageBase loginPage = initPage(LoginPageBase.class);
        assertTrue(loginPage.isOpened(), "Login page is not open");
        loginPage.login(R.TESTDATA.get("locked_user"), R.TESTDATA.get("correct_password"));
        assertEquals(loginPage.getErrorMessage(),
                "Sorry, this user has been locked out.",
                "'Sorry, this user has been locked out.', Error message is not shown");
    }
}

