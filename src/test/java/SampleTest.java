import Pages.BaseTest;
import Pages.CalculatorPage;
import Pages.BasePage;
import TestDataReader.TestDataProvider;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SampleTest extends BaseTest {



        @Test(dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
        public void TC001_VerifyValueAddedTaxAndPriceIncl(String rowID, String description, JSONObject data)
        {
              try {
                      CalculatorPage calculatorPage = new CalculatorPage();
                      calculatorPage.launchApplication("https://www.calkoo.com/en/vat-calculator");
                      calculatorPage.selectCountry(data.get("country").toString());
                      calculatorPage.selectVATRate(data.get("vatRate").toString());
                      calculatorPage.setPriceWithoutVAT(data.get("priceWithoutVat").toString());
                      calculatorPage.verifyValueAddedAndPriceIncl();
                      calculatorPage.setValueAddedTax(data.get("valueAddedTax").toString());
                      calculatorPage.verifyPriceWithoutVATAndPriceInclVAT();
                      calculatorPage.setPriceInclVAT(data.get("priceInclVat").toString());
                      calculatorPage.verifyPriceWithoutVATAndValueAdded();
              }catch (Exception e){
                      Assert.assertTrue("Test failed due to "+e.getLocalizedMessage(),false);
              }
        }

        @Test(dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
        public void TC002_VerifyVATForTopTouristCountries(String rowID, String description, JSONObject data)
        {
                try {
                        CalculatorPage calculatorPage = new CalculatorPage();
                        calculatorPage.launchApplication("https://www.calkoo.com/en/vat-calculator");
                        String[] countries = data.get("country").toString().split(",");
                        for (String country : countries) {
                                calculatorPage.validateVATPercent(country,data);
                        }

                }catch (Exception e){
                        Assert.assertTrue("Test failed due to "+e.getLocalizedMessage(),false);
                }
        }


}
