package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListerner implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Testcases failed and TestCase details are " + result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Testcases Skipped and TestCase details are " + result.getName());
    }
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Testcases Started and TestCase details are " + result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Testcases Success Huryy and TestCase details are " + result.getName());

    }


}
