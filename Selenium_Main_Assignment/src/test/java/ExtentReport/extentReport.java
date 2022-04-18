package ExtentReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class extentReport {


    static ExtentTest Test1;
    static com.relevantcodes.extentreports.ExtentReports report;

    @BeforeTest
    public void initializeReport() {
        report = new ExtentReports(System.getProperty("Selenium_Main_Assignment.dir")+"Report.html");
        Test1 = report.startTest("AutomationPages");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {

            Test1.log(LogStatus.FAIL, (result.getName() + " Failed"));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Test1.log(LogStatus.PASS, (result.getName() + " Successful"));
        } else {
            Test1.log(LogStatus.SKIP, (result.getName() + " Skipped"));
        }
    }

    @AfterClass
    public static void endTest() {
        report.endTest(Test1);
        report.flush();
    }
}
