package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Report.TestListener.class)
public class BaseTest {

    static WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }


}
