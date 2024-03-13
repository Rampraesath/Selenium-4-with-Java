package login;

import base.BaseTest;
import data.LoginData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

public class PrivateAccLoginTest extends BaseTest {

    @Test(dataProviderClass = LoginData.class,dataProvider = "private-login-provider")
    public void privAccLogin(String email, String password) {

        LoginPage loginPage = homePage.clickSignIn();
        loginPage.selectAccount("private");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        DashboardPage dashboardPage = loginPage.clickSubmit();
        dashboardPage.validatePrivateDashboard();
    }
}
