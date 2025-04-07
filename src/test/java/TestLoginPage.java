import com.solvd.pages.base.LoginPage;
import com.solvd.pages.base.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class TestLoginPage extends AbstractTest {

    @Test
    public void shouldLogin() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        ProductPage productPage = loginPage.login("standard_user", R.TESTDATA.get("correct_password"));
        assertTrue(productPage.isPageOpened());
    }

    @Test
    public void shouldNotLoginWrongCredential() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login("no_user", "no_password");
        assertEquals(loginPage.getErrorMessage(),
                "Username and password do not match any user in this service.");
    }

    @Test
    public void shouldNotLoginMissingUsername() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login("", R.TESTDATA.get("correct_password"));
        assertEquals(loginPage.getErrorMessage(), "Username is required");
    }
}

