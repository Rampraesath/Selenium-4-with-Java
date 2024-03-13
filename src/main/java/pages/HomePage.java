package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Objects--------------
    private WebElement lnk_sign_in() {
        return driver.findElement(By.xpath("//a[contains(text(), 'Sign In')]"));
    }
    //---------------------

    //Methods---------------
    public LoginPage clickSignIn(){

        lnk_sign_in().click();
        return new LoginPage(driver);

    }

    //----------------------
}
