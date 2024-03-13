package login;

import base.BaseTest;
import data.LoginData;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class ProNiagaLoginTest extends BaseTest {

    @Test(dataProviderClass = LoginData.class,dataProvider = "pro-valid-login-provider")
    public void proNiagaLogin(String email, String password) {
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.selectAccount("pro");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        DashboardPage dashboardPage = loginPage.clickSubmit();
        dashboardPage.validateProDashboard();
    }
}
