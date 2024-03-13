package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected HomePage homePage;
    public ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    String url = "https://www.mudah.my/";
    Integer wait = 30;


    @AfterMethod
    public void tearDown(){
        getDriver().quit();
        webDriverThreadLocal.remove();

    }
    public void setDriver(WebDriver driver){
      this.webDriverThreadLocal.set(driver);
    };

    public WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }
    @BeforeMethod
    @Parameters("browser")
    public void initializeDriver(@Optional("chrome")String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
                driverSettings();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                setDriver(new FirefoxDriver());
                driverSettings();
                break;
            default:
                System.out.println("Invalid "+browser+". System will default to Chrome browser.");
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
                driverSettings();

        }


        homePage = new HomePage(getDriver());

    }

    private void driverSettings(){
        getDriver().get(url);
        getDriver().manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    };



}
