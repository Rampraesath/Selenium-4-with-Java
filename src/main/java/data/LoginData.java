package data;

import org.testng.annotations.DataProvider;
import utilities.Utils;

public class LoginData {

    @DataProvider(name="login-provider", parallel = true)
    public static Object [] [] signInData(){
        Object [] [] data = new Object [10] [3];
        //Email                                   //Password                        //Criteria
        data[0][0] = "selitest23@gmail.com";      data[0][1] = "Nescafe21!@";       data[0][2] = "pvt cred";
        data[1][0] = "elephantcowdogcatmeow";     data[1][1] = "Nescafe21!@";       data[1][2] = "pvt invalid email";
        data[2][0] = "123253645758677897054";     data[2][1] = "Nescafe21!@";       data[2][2] = "pvt invalid email";
        data[3][0] = "@#$&&^%$^^$#$%#%@(*&(*";    data[3][1] = "Nescafe21!@";       data[3][2] = "pvt invalid email";
        data[4][0] = "selitest21@gmail.com";      data[4][1] = "Nescafe21!@";       data[4][2] = "pro valid cred";
        data[5][0] = "SELECT * FROM USERS;";      data[5][1] = "Nescafe21!@";       data[5][2] = "pvt invalid email";
        data[6][0] = "selitest23@gmail.com";      data[6][1] = "^$^R&^T(*(&";       data[6][2] = "pvt invalid password";
        data[7][0] = "selitest23@gmail.com";      data[7][1] = "sdcsdcsdfad";       data[7][2] = "pvt invalid password";
        data[8][0] = "selitest23@gmail.com";      data[8][1] = "w34534543423";      data[8][2] = "pvt invalid password";
        data[9][0] = "selitest23@gmail.com";      data[9][1] = "w34534543423";      data[9][2] = "pvt retry";

        return data;
    }


    @DataProvider(name = "private-invalid-email-provider", parallel = true)
    public static Object[][] invalidEmailSignInData() {
        Object[][] allData = signInData();
        return Utils.filterDataByCredential(allData, "pvt invalid email");
    }

    @DataProvider(name = "pro-valid-login-provider", parallel = true)
    public static Object[][] proValidSignInData() {
        Object[][] allData = signInData();
        return Utils.filterDataByCredential(allData, "pro valid cred");
    }

    @DataProvider(name = "private-invalid-password-provider", parallel = true)
    public static Object[][] invalidPassSignInData() {
        Object[][] allData = signInData();
        return Utils.filterDataByCredential(allData, "pvt invalid password");
    }

    @DataProvider(name = "private-retry-password-provider", parallel = false)
    public static Object[][] invalidPassRetrySignInData() {
        Object[][] allData = signInData();
        return Utils.filterDataByCredential(allData, "pvt retry");
    }


    @DataProvider(name = "private-login-provider", parallel = true)
    public static Object[][] privateSignInDataN() {
        Object[][] allData = signInData();
        return Utils.filterDataByCredential(allData, "pvt cred");
    }
}
