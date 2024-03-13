package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Utils;

import java.time.Duration;

public class DashboardPage extends Utils {
    private WebDriver driver;
    private WebDriverWait wait;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    //Objects--------------

    private WebElement hdr_user_dashboard(){
        return driver.findElement(By.xpath("//p[normalize-space()='My Dashboard']"));
    };

    //email
    //span[@class='ml-3 w-full'] aries.rj@gmail.com
    private WebElement txt_email(){
        return driver.findElement(By.xpath("//span[@class='ml-3 w-full']"));
    };
    //date
    //div[normalize-space()='Since 24 Feb 2024']
    private WebElement txt_date(){
        return driver.findElement(By.xpath("//div[normalize-space()='Since 24 Feb 2024']"));
    };

    //email at top
    //div[@class='jss13 jss55 jss14 jss56']aries.rj@gmail.com

    private WebElement txt_email_header(){
        return driver.findElement(By.xpath("//div[@class='jss13 jss55 jss14 jss56']"));
    };
    //dashboard content
    //div[@class='pd-MuiListItemText-root']//span[contains(text(),'My Ads')]
    private WebElement tab_published_ads(){
        return driver.findElement(By.xpath("//div[@class='pd-MuiListItemText-root']//span[contains(text(),'My Ads')]"));
    };
    //proniaga account type
    //business name
    //a[normalize-space()='Diamond']
    private WebElement txt_business_name(){
        return driver.findElement(By.xpath("//a[normalize-space()='Diamond']"));
    };
    //dashboard
    //div[@class='Desktop__TabActive-sc-122k4l2-8 cnpjhY']
    //email
    //div[@class='jss13 jss55 jss14 jss56'] selitest21@gmail.com  (superadmin)  (kena normalize space)

    private WebElement txt_username_dashboard(){
        return driver.findElement(By.xpath("//div[normalize-space()='Diamond']/following-sibling::div"));
    };

    private WebElement txt_private_username(){
        return driver.findElement(By.xpath("//div[@class='pd-MuiGrid-root pd-MuiGrid-item pd-MuiGrid-grid-md-3 pd-MuiGrid-grid-lg-3']/div/div/div/following-sibling::div"));
    };

    //div[@class='pd-MuiGrid-root pd-MuiGrid-item pd-MuiGrid-grid-md-3 pd-MuiGrid-grid-lg-3']//div[contains (text(), 'selitest23@gmail.com')]

    private WebElement btn_ok(){
        return driver.findElement(By.xpath("//span[contains(text(), 'OK')]"));

    };

    private WebElement tab_top_header(String tabName){
        return driver.findElement(By.xpath(String.format("//div[@class='jss79']//parent::*[contains(text(), '%s')]", tabName)));
    };

    private WebElement btn_close(){
        return driver.findElement(By.xpath("//div[@class='rd4 rd404 Close']"));
    };

    private WebElement lbl_my_ads(){
        return driver.findElement(By.xpath("//div[@class='pd-MuiListItemText-root']//span[contains(text(),'My Ads')]"));

    };




    //--------------------


    //Methods-------------

    public void validateProDashboard(){
        //More components can be validated in the dashboard but not added due to time constraint
        btn_ok().click();
        validateHeaderTabs();
        Assert.assertTrue((txt_username_dashboard().getText()).contains("selitest21@gmail.com"), "Substring not found");
    };

    private void validateHeaderTabs(){
        String[] headerName = {"My Profile", "My Ads", "Store Type", "Deals", "My Gallery", "Users", "Credits", "Support"};
        for (String header : headerName) {
            int attempts = 0;
            while (attempts < 3) {
                try {
                    wait.until(ExpectedConditions.visibilityOf(tab_top_header(header))).isDisplayed();
                    break;
                } catch (StaleElementReferenceException e) {
                    driver.navigate().refresh();
                    attempts++;
                }
            }
        }
    };

    public  void validatePrivateDashboard(){
        //More components can be validated in the dashboard but not added due to time constraint
        Assert.assertTrue((txt_private_username().getText()).contains("selitest23@gmail.com"), "Email not found");
        WebElement dashboardHeader = retryUntilFound(this::hdr_user_dashboard, 3);
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header not displayed");
        wait.until(ExpectedConditions.visibilityOf(lbl_my_ads())).isDisplayed();
    };


    //--------------------
};
