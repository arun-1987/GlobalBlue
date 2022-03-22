package TestDataReader;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "TestData")
    public static Object[][] fetchData(Method method) throws Exception {
        Object rowID, description;
        Object result[][] = null;
        String testCaseName = method.getName();
        JSONArray testData = (JSONArray) extractData_JSON("src/main/resources/testdata.json").get(method.getName());
        List<JSONObject> testDataList = new ArrayList<JSONObject>();
        for (int i = 0; i < testData.size(); i++) {
            testDataList.add((JSONObject) testData.get(i));
        }
        result = new Object[testDataList.size()][testDataList.get(0).size()];
        for (int i = 0; i < testDataList.size(); i++) {
            rowID = testDataList.get(i).get("rowID");
            description = testDataList.get(i).get("description");
            result[i] = new Object[]{rowID, description,
                    testDataList.get(i)};
        }
        return result;

    }

    /**
     * extractData_JSON - method to extract JSON data from a file
     *
     * @param file (including path)
     * @return JSONObject
     * @throws Exception
     */
    public static JSONObject extractData_JSON(String file) throws Exception {
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(reader);
    }


}
