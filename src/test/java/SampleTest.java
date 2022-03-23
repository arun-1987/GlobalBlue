import Pages.BaseTest;
import Pages.CalculatorPage;
import Pages.BasePage;
import TestDataReader.TestDataProvider;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {



        @Test(dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
        public void checkCalculator(String rowID, String description, JSONObject data)
        {
        CalculatorPage calculatorPage = new CalculatorPage();
        calculatorPage.launchApplication("https://www.calkoo.com/en/vat-calculator");
        calculatorPage.selectCountry(data.get("country").toString());
        calculatorPage.selectVATRate(data.get("vatRate").toString());
        calculatorPage.setPriceWithoutVAT(data.get("priceWithoutVat").toString());
        calculatorPage.verifyValueAddedAndPriceIncl();
        }



}
