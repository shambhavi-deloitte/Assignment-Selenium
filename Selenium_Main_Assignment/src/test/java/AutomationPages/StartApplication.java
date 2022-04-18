package AutomationPages;

import ExtentReport.extentReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class StartApplication extends extentReport {
    public WebDriver driver;
    @BeforeTest
    public void setup()  {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://weathershopper.pythonanywhere.com/");

    }
 /* @AfterTest
    public void AppQuit(){

       driver.close();
   } */
}