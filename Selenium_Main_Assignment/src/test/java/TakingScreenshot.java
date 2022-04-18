import AutomationPages.StartApplication;
import Library.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TakingScreenshot  {
    WebDriver driver;

    @Test
    public void captureScreenshot() throws Exception {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://weathershopper.pythonanywhere.com/");
        //Utility.captureScreenshot(driver, "BrowseStarted");

       // driver.findElement(By.xpath("/html/body/div/div[1]/span"));
        //Utility.captureScreenshot(driver,"TypeName");

        List<WebElement> Almond_products = driver.findElements(By.xpath("//*[contains(text(),'Almond') or contains(text(), 'almond') ]"));
        Utility.captureScreenshot(driver,"SS1");

    }



    @AfterMethod
    public void tearDown(ITestResult result) {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        if (ITestResult.FAILURE == result.getStatus()) {
            Utility.captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }
}

