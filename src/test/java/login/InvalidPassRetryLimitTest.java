package login;

import base.BaseTest;
import data.LoginData;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidPassRetryLimitTest extends BaseTest {

    @Test(dataProviderClass = LoginData.class,dataProvider = "private-retry-password-provider")
    public void invPassRetry(String email, String password) {
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.validateRetryPassLimit(email, password);

    }
}
