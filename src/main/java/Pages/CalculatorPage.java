package Pages;

import org.openqa.selenium.By;

public class CalculatorPage extends BasePage {

    By COUNTRY_DD = By.xpath("//select[@name='Country']");
    String VATRATE = "//label[@for='VAT_VALUE']";

    public void launchApplication(String url){
        driver.get(url);
    }


    public void selectCountry(String countryName){
        selectByVisibleText(COUNTRY_DD,countryName);
        hardDelay();
    }

    public void selectVATRate(String rate){
        click(By.xpath(VATRATE.replace("VALUE",rate)));
        hardDelay();
    }

}
