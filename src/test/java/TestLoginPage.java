import com.solvd.pages.base.LoginPage;
import com.solvd.pages.base.ProductPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestLoginPage extends AbstractTest {

    @Test
    public void shouldLogin() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");
        assertTrue(productPage.isPageOpened());
    }
}

