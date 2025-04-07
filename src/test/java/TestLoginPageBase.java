import com.solvd.pages.base.LoginPageBase;
import com.solvd.pages.base.ProductPageBase;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class TestLoginPageBase extends AbstractTest {

    @Test
    public void shouldLogin() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPageBase.login(R.TESTDATA.get("standard_user"), R.TESTDATA.get("correct_password"));
        assertTrue(productPage.isPageOpened());
    }

    @Test
    public void shouldNotLoginWrongCredential() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.login("no_user", "no_password");
        assertEquals(loginPageBase.getErrorMessage(),
                "Username and password do not match any user in this service.");
    }

    @Test
    public void shouldNotLoginMissingUsername() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.login("", R.TESTDATA.get("correct_password"));
        assertEquals(loginPageBase.getErrorMessage(), "Username is required");
    }

    @Test
    public void shouldNotLoginMissingPassword() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.login(R.TESTDATA.get("standard_user"), "");
        assertEquals(loginPageBase.getErrorMessage(), "Password is required");
    }

    @Test
    public void shouldNotLoginLockedUser() {
        LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
        loginPageBase.login(R.TESTDATA.get("locked_user"), R.TESTDATA.get("correct_password"));
        assertEquals(loginPageBase.getErrorMessage(), "Sorry, this user has been locked out.");
    }
}

