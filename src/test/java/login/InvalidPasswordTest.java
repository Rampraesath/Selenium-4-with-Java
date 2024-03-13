package login;

import base.BaseTest;
import data.LoginData;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidPasswordTest extends BaseTest {

    @Test(dataProviderClass = LoginData.class,dataProvider = "private-invalid-password-provider")
    public void invPass(String email, String password) {
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.selectAccount("private");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSubmit();
        loginPage.validatePasswordError();

    }
}
