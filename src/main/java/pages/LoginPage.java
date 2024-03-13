package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Objects----------


    private WebElement btn_private_signin(){
       return driver.findElement(By.xpath("//button[@class='nuw47 nuw18 nuw20 w-full css-srocrv']//span[@class='css-1jpl70b'][normalize-space()='Sign In']"));
    };
    private WebElement inp_email(){
        return driver.findElement(By.xpath("//input[@name='email']"));
    };
    private WebElement inp_password(){
        return driver.findElement(By.xpath("//input[@name='password']"));
    };
    private WebElement btn_submit(){
        return driver.findElement(By.xpath("//button[@type='submit']//span[@class='app-MuiButton-label']"));
    };
    private WebElement hdr_pvt_acc(){
        return driver.findElement(By.xpath("//h1[normalize-space()='Sign in as Private Account']"));
    };

    private WebElement err_email_req(){
        return driver.findElement(By.xpath("//p[normalize-space()='Email is required.']"));
    };

    private WebElement err_pass_req(){
        return driver.findElement(By.xpath("//p[normalize-space()='Please enter your password.']"));
    };

    private WebElement err_email_invalid(){
        return driver.findElement(By.xpath("//p[normalize-space()='Please enter a valid email address.']"));
    };

    private WebElement err_invalid_cred(){
        return driver.findElement(By.xpath("//div[contains(text(),'Email is email')]"));
    };

    private WebElement btn_pro_signin(){
        return driver.findElement(By.xpath("//button[@class='nuw47 nuw18 nuw20 w-full css-1lfuqcq']//span[@class='nuw19'][normalize-space()='Sign In']"));
    }

    private WebElement hdr_pro_niaga(){
        return driver.findElement(By.xpath("//h1[normalize-space()='Sign in as PRO Niaga Account']"));
    };

    private WebElement err_pass_incorrect(){
        return driver.findElement(By.xpath("//div[contains(text(),'The password is incorrect.')]"));
    };

    private WebElement err_retry_limit(){
        return driver.findElement(By.xpath("//div[contains(text(),'It seems that you have reached the maximum number ')]"));
    };

    private WebElement btn_close_signin(){
        return driver.findElement(By.xpath("//button[@class='app-MuiButtonBase-root app-MuiIconButton-root absolute css-z9n28a app-MuiIconButton-sizeSmall']"));
    };





    //---------------




    //Methods--------------

    public void selectAccount(String account) {
        switch (account.toLowerCase()) {
            case "private":
                wait.until(ExpectedConditions.visibilityOf(btn_private_signin())).click();
                wait.until(ExpectedConditions.visibilityOf(hdr_pvt_acc())).isDisplayed();
                break;
            case "pro":
                wait.until(ExpectedConditions.visibilityOf(btn_pro_signin())).click();
                wait.until(ExpectedConditions.visibilityOf(hdr_pro_niaga())).isDisplayed();
                break;
        }
    }




    public void setEmail(String email){
        inp_email().click();
        inp_email().sendKeys(email);
    }

    public void setPassword(String password){
        inp_password().click();
        inp_password().sendKeys(password);
    }

    public DashboardPage clickSubmit(){
        btn_submit().click();
        return new DashboardPage(driver);
    }

    public void validateEmailError(){
        wait.until(ExpectedConditions.visibilityOf(err_email_invalid())).isDisplayed();
    };

    public void validatePasswordError(){
        wait.until(ExpectedConditions.visibilityOf(err_pass_incorrect())).isDisplayed();
    };

    public void validateRetryPassLimit(String email, String password){
        for (int i = 0; i < 7; i++) {
            repeatLogin(email, password);
            btn_close_signin().click();
        }
        //gets triggered at 7th trial
        repeatLogin(email, password);
        wait.until(ExpectedConditions.visibilityOf(err_retry_limit())).isDisplayed();
    };

    private void repeatLogin(String email, String password){
        selectAccount("private");
        setEmail(email);
        setPassword(password);
        clickSubmit();
    }

    //---------------------
}
