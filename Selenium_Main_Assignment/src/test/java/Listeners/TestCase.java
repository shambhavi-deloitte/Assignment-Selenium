package Listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNgListerner.class)
public class TestCase
{
    @Test
    public void TitleVerify(){
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://weathershopper.pythonanywhere.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void getTitle(){
        System.out.println("Test");
        Assert.assertTrue(false);
    }
}
