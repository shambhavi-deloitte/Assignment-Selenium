package AutomationTest;
import AutomationPages.StartApplication;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Test(priority = 1)
public class TemperatureAndProduct extends StartApplication
{
    public static Logger Log = LogManager.getLogger(TemperatureAndProduct.class);
    boolean moisturizer = false;
    boolean sunscreen = false;
    int GetTempinInt;

    // -----------------------------------GETTING VALUE OF TEMPERTURE--------------------------------------------------------------
    public void Temp()
    {
        String GetTemp = driver.findElement(By.xpath("//*[@id=\"temperature\"]")).getText();
        System.out.println(GetTemp);
        Log.info("checking Temperature");
        GetTemp = GetTemp.replaceAll("[^\\d.]", "");
        GetTempinInt = Integer.parseInt(GetTemp);
        System.out.println(GetTemp);
    }
    //-------------------------------------------------CHOICE OF PRODUCTS----------------------------------------------------------
    @Test(priority = 2)
    public void choice() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div/div[1]/span")).click();
        TimeUnit.MILLISECONDS.sleep(5000);
        if (GetTempinInt < 19)
            moisturizer = true;
        else if (GetTempinInt > 34)
            sunscreen = true;
        else
        {
            driver.navigate().refresh();
            Temp();
            choice();
        }
    }
//------------------------------------------MOISTURIZER PRODUCTS-----------------------------------------------------------------------
    @Test(priority = 3)
    public void chooseMoisturizer() throws InterruptedException
    {
        if (moisturizer)
        {
            driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
            TimeUnit.MILLISECONDS.sleep(5000);
            List<WebElement> Almond_products = driver.findElements(By.xpath("//*[contains(text(),'Almond') or contains(text(), 'almond') ]"));

            String storingElements;
            for (WebElement Almondproducts : Almond_products)
            {
                storingElements = Almondproducts.getText();
                System.out.println(storingElements);
            }

            //priceofAlmond
            ArrayList<String> almondList = new ArrayList<>();
            List<WebElement> price = driver.findElements(By.xpath("//p[contains(text(),'Almond') or contains(text(), 'almond') ]//following-sibling::p"));
            Thread.sleep(2000);
            for (WebElement webElement : price)
            {
                almondList.add(webElement.getText());
            }
            //System.out.println(almondList);

            //sortingPrice
            Collections.replaceAll(almondList, "Rs.", "");
            Collections.sort(almondList);
            System.out.println(almondList);
            String lowPrice = almondList.get(0);
            System.out.println("lowprice is " + lowPrice);
            driver.findElement(By.xpath("//p[contains(text(),'Almond') or contains(text(), 'almond') ]//following-sibling::p//following-sibling::button")).click();

            //Aloe
            List<WebElement> Aloe_products = driver.findElements(By.xpath("//*[contains(text(),'Aloe') or contains(text(), 'aloe') ]"));
            String storingAloeElements;
            for (WebElement Aloeproducts : Aloe_products)
            {
                storingAloeElements = Aloeproducts.getText();
                System.out.println(storingAloeElements);
            }

            //PriceofAloe
            ArrayList<String> aloeList = new ArrayList<>();
            List<WebElement> aloeprice = driver.findElements(By.xpath("//p[contains(text(),'Aloe') or contains(text(), 'aloe') ]//following-sibling::p"));
            Thread.sleep(2000);
            for (WebElement webElement : aloeprice)
            {
                aloeList.add(webElement.getText());
            }
            //System.out.println(aloeList);
            //sortingPriceofAloe
            Collections.replaceAll(aloeList, "Rs.", "");
            Collections.sort(aloeList);
            System.out.println(aloeList);
            String aloeLowPrice = aloeList.get(0);
            System.out.println("lowprice is " + aloeLowPrice);

            //ADD
            driver.findElement(By.xpath("//p[contains(text(),'Aloe') or contains(text(), 'aloe') ]//following-sibling::p//following-sibling::button")).click();
            //GotoCart
            driver.findElement(By.xpath("//button[@onclick='goToCart()']")).click();
            //paywithCard
            driver.findElement(By.xpath("//span[text()='Pay with Card']")).click();
        }
        else
        {
            System.out.println("Temperature is greater than 34");
        }
    }

    // --------------------------------------SUNSCREEN PRODUCTS-------------------------------------------------------------------
    @Test(priority = 3)
    public void chooseSunscreen() throws InterruptedException {
        if (sunscreen)
        {
            driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/a/button")).click();
            TimeUnit.MILLISECONDS.sleep(5000);

            //SPF-30 PRODUCTS
            List<WebElement> spf_30_products = driver.findElements(By.xpath("//*[contains(text(),'SPF-30') or contains(text(), 'spf-30') ]"));
            String storingElements;
            for (WebElement spf30Product : spf_30_products)
            {
                storingElements = spf30Product.getText();
                System.out.println(storingElements);
            }
            //PriceList of spf-30
            ArrayList<String> spf30List = new ArrayList<>();
            List<WebElement> price = driver.findElements(By.xpath("//p[contains(text(),'SPF-30') or contains(text(), 'spf-30') ]//following-sibling::p"));
            Thread.sleep(2000);
            for (WebElement webElement : price)
            {
                spf30List.add(webElement.getText());
            }
            //System.out.println(almondList);

            //sortingPrice
            Collections.replaceAll(spf30List, "Rs.", "");
            Collections.sort(spf30List);
            System.out.println(spf30List);
            String lowPrice = spf30List.get(0);
            System.out.println("lowprice is " + lowPrice);
            //Add
            driver.findElement(By.xpath("//p[contains(text(),'SPF-30') or contains(text(), 'spf-30') ]//following-sibling::p//following-sibling::button")).click();

            //--------------------SPF-50 PRODUCTS--------------------------------------------------------
            List<WebElement> spf_50_products = driver.findElements(By.xpath("//*[contains(text(),'SPF-50') or contains(text(), 'spf-50')]"));
            String storingElements1;
            for (WebElement spf50Product : spf_50_products)
            {
                storingElements1 = spf50Product.getText();
                System.out.println(storingElements1);
            }
            //PriceList of spf-50
            ArrayList<String> spf50List = new ArrayList<>();
            List<WebElement> spfPrice = driver.findElements(By.xpath("//p[contains(text(),'SPF-50') or contains(text(), 'spf-50') ]//following-sibling::p"));
            Thread.sleep(2000);
            for (WebElement webElement : spfPrice)
            {
                spf50List.add(webElement.getText());
            }
            //System.out.println(almondList);

            //sortingPrice
            Collections.replaceAll(spf50List, "Rs.", "");
            Collections.sort(spf50List);
            System.out.println(spf50List);
            String spfLowPrice = spf50List.get(0);
            System.out.println("lowprice is " + spfLowPrice);
            //Add
            driver.findElement(By.xpath("//p[contains(text(),'SPF-50') or contains(text(), 'spf-50') ]//following-sibling::p//following-sibling::button")).click();
            //GotoCart
            driver.findElement(By.xpath("//button[@onclick='goToCart()']")).click();
            //paywithCard
            driver.findElement(By.xpath("//span[text()='Pay with Card']")).click();
        }

        else
        {
            System.out.println("Temperature is less than 34");
        }
    }
 }





