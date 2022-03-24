package Report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext Result)
    {

    }

    @Override
    public void onStart(ITestContext Result)
    {
        Reporter.log(Result.getName()+ "test is initiated");
    }


    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result)
    {
        Reporter.log(Result.getName()+ "test is failed");
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result)
    {
        System.out.println("The name of the testcase Skipped is :"+Result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result)
    {

    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result)
    {
        Reporter.log(Result.getName()+ "test is Successful");
    }


}
