package login;

import base.BaseTest;
import data.LoginData;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidEmailCharTest extends BaseTest {

    @Test(dataProviderClass = LoginData.class,dataProvider = "private-invalid-email-provider")
    public void invEmailChar(String email, String password) {
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.selectAccount("private");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSubmit();
        loginPage.validateEmailError();

    }
}
