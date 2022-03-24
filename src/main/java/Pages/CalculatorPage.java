package Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CalculatorPage extends BasePage {

    By COUNTRY_DD = By.xpath("//select[@name='Country']");
    String VATRATE = "//label[@for='VAT_VALUE']";
    By ACCEPTCOOKIES = By.xpath("//a[.='I Accept!']");
    By PRICEWITHOUTVAT = By.xpath("//input[@id='NetPrice']");
    By VALUEADDEDTAX = By.xpath("//input[@id='VATsum']");
    By PRICEWITHOUTVAT_LABEL = By.xpath("//label[.='Price without VAT']");
    By PRICEINCLVAT = By.xpath("//input[@id='Price']");

    public void launchApplication(String url){
        driver.get(url);
        driver.manage().window().maximize();
        click(ACCEPTCOOKIES,"Accept cookies");
    }


    public void selectCountry(String countryName){
        selectByVisibleText(COUNTRY_DD,countryName);
    }

    public void selectVATRate(String rate){
        click(By.xpath(VATRATE.replace("VALUE",rate)),rate+" as VAT");
    }

    public void setPriceWithoutVAT(String userInput){
        click(PRICEWITHOUTVAT_LABEL,"price without vat");
        enter(PRICEWITHOUTVAT,userInput);
        hardDelay();
    }

    public void setValueAddedTax(String userInput){
        enter(PRICEWITHOUTVAT,userInput);
    }

    public void verifyValueAddedAndPriceIncl(){
        String valueAddedTax = getAttribute(VALUEADDEDTAX);
        String priceInclVat = getAttribute(PRICEINCLVAT);
        Assert.assertEquals(valueAddedTax,"5.00");
        Assert.assertEquals(priceInclVat,"105.00");
    }


}
