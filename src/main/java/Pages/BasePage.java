package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
   public BasePage(){
       this.driver = BaseTest.getDriver();
       this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(45));
   }

    public void click(By locator,String desc){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        Reporter.log("Clicked "+desc);
    }

    public void enter(By locator,String value){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
        Reporter.log("Entered "+value);
    }


    public void selectByVisibleText(By locator,String value){
       WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
       Select select = new Select(element);
       select.selectByVisibleText(value);
       Reporter.log("Selected the value from drop down : "+value);
    }

    public String getAttribute(By locator){
      return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getAttribute("value");
    }

    public void checkIfDisplayed(By locator){
       try {
           wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
       }catch (Exception e){
           Assert.assertTrue(false,"Test Failed in checkIfDisplayed" + e.getLocalizedMessage());
       }
    }

    public void scrollToElement(By locator){
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void hardDelay(){
       try{
           Thread.sleep(1000);
       }catch (Exception e){

       }
    }

}
