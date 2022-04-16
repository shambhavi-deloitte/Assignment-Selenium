package AutomationTest;
import AutomationPages.StartApplication;
import org.checkerframework.checker.units.qual.Temperature;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
@Test(priority = 1)
public class GetTemperature extends StartApplication {
    boolean moisturizer = false;
    boolean sunscreen = false;
    int GetTempinInt;

    public void Temp() {
        String GetTemp = driver.findElement(By.xpath("//*[@id=\"temperature\"]")).getText();
        System.out.println(GetTemp);
        GetTemp = GetTemp.replaceAll("[^\\d.]", "");
        GetTempinInt = Integer.parseInt(GetTemp);
        System.out.println(GetTemp);
        //return GetTempinInt;
    }

    @Test(priority = 2)
    public void choice() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div[1]/span")).click();
        TimeUnit.MILLISECONDS.sleep(5000);

        // int temperature = Integer.parseInt(GetTemp);
        if (GetTempinInt < 19)
            moisturizer = true;
        else if (GetTempinInt > 34)
            sunscreen = true;
        else {
            driver.navigate().refresh();

            Temp();
            choice();
        }
    }

    @Test(priority = 3)
    public void chooseMoisturizer() throws InterruptedException {
        if (moisturizer) {
            driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
            TimeUnit.MILLISECONDS.sleep(5000);
        } else {
            System.out.println("Temperature is less than 19");
        }
    }

    @Test(priority = 3)
    public void chooseSunscreen() throws InterruptedException {
        if (sunscreen) {
            driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/a/button")).click();
            TimeUnit.MILLISECONDS.sleep(5000);
        } else {
            System.out.println("Temperature is greater than 34");
        }
    }
}



