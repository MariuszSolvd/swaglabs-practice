import com.solvd.pages.base.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

public class TestLoginPage extends AbstractTest {

    @Test
    public void shouldLogin() {
        LoginPage loginPage = initPage(getDriver(), LoginPage.class);
        loginPage.login("standard_user", "secret_sauce");
        //todo:assert + new page
    }
}
