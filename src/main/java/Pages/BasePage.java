package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
   public BasePage(){
       this.driver = BaseTest.getDriver();
       this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(45));
   }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void enter(By locator,String value){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(value);
    }

    public void selectByVisibleText(By locator,String value){
       WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
       Select select = new Select(element);
       select.selectByVisibleText(value);
    }

    public void hardDelay(){
       try{
           Thread.sleep(5000);
       }catch (Exception e){

       }
    }

}
