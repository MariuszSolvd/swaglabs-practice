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
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        ProductPageBase productPage = loginPageBase.login(R.TESTDATA.get("standard_user"), R.TESTDATA.get("correct_password"));
        assertTrue(productPage.isPageOpened(),"Did not login to App");
    }

    @Test
    public void wrongCredentialTest() {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        loginPageBase.login("no_user", "no_password");
        assertEquals(loginPageBase.getErrorMessage(),
                "Username and password do not match any user in this service.");
    }

    @Test
    public void missingUsernameTest() {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        loginPageBase.login("", R.TESTDATA.get("correct_password"));
        assertEquals(loginPageBase.getErrorMessage(), "Username is required");
    }

    @Test
    public void missingPasswordTest() {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        loginPageBase.login(R.TESTDATA.get("standard_user"), "");
        assertEquals(loginPageBase.getErrorMessage(), "Password is required");
    }

    @Test
    public void lockedUserTest() {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        loginPageBase.login(R.TESTDATA.get("locked_user"), R.TESTDATA.get("correct_password"));
        assertEquals(loginPageBase.getErrorMessage(), "Sorry, this user has been locked out.");
    }
}

