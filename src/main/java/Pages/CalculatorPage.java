package Pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CalculatorPage extends BasePage {

    By COUNTRY_DD = By.xpath("//select[@name='Country']");
    String VATRATE = "//label[@for='VAT_VALUE']";
    By ACCEPTCOOKIES = By.xpath("//a[.='I Accept!']");
    By PRICEWITHOUTVAT = By.xpath("//input[@id='NetPrice']");
    By VALUEADDEDTAX = By.xpath("//input[@id='VATsum']");
    By VALUEADDEDTAX_LABEL = By.xpath("//label[.='Value-Added Tax']");
    By PRICEWITHOUTVAT_LABEL = By.xpath("//label[.='Price without VAT']");
    By PRICEINCLVAT_LABEL = By.xpath("//label[.='Price incl. VAT']");
    By PRICEINCLVAT = By.xpath("//input[@id='Price']");

    public void launchApplication(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }


    public void selectCountry(String countryName){
        selectByVisibleText(COUNTRY_DD,countryName);
    }

    public void selectVATRate(String rate){
        click(By.xpath(VATRATE.replace("VALUE",rate)),rate+" as VAT");
    }

    public void setPriceWithoutVAT(String userInput){
        hardDelay();
        click(PRICEWITHOUTVAT_LABEL,"price without vat");
        enter(PRICEWITHOUTVAT,userInput);
    }

    public void setValueAddedTax(String userInput){
        hardDelay();
        click(VALUEADDEDTAX_LABEL,"value added tax");
        enter(VALUEADDEDTAX,userInput);
    }

    public void setPriceInclVAT(String userInput){
        hardDelay();
        click(PRICEINCLVAT_LABEL,"price incl vat");
        enter(PRICEINCLVAT,userInput);
    }

    public void verifyValueAddedAndPriceIncl(){
        String valueAddedTax = getAttribute(VALUEADDEDTAX);
        String priceInclVat = getAttribute(PRICEINCLVAT);
        Assert.assertEquals(valueAddedTax,"5.00");
        Assert.assertEquals(priceInclVat,"105.00");
    }

    public void verifyPriceWithoutVATAndPriceInclVAT(){
        String valueAddedTax = getAttribute(PRICEWITHOUTVAT);
        String priceInclVat = getAttribute(PRICEINCLVAT);
        Assert.assertEquals(valueAddedTax,"100.00");
        Assert.assertEquals(priceInclVat,"105.00");
    }


    public void verifyPriceWithoutVATAndValueAdded(){
        String valueAddedTax = getAttribute(VALUEADDEDTAX);
        String priceWithOutVat = getAttribute(PRICEWITHOUTVAT);
        Assert.assertEquals(valueAddedTax,"5.00");
        Assert.assertEquals(priceWithOutVat,"100.00");
    }

    public void validateVATPercent(String countryName, JSONObject data){
        selectCountry(countryName);
        String[] vats = data.get(countryName).toString().split(",");
        for (String vat : vats){
            checkIfDisplayed(By.xpath("//input[@name='VAT']/following-sibling::label[contains(.,'"+vat+"')]"));
        }

    }

}
