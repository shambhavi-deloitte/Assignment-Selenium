package Library;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Utility {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try
        {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/"+ screenshotName+".png"));
            System.out.println("Screenshot Captured");
        }
        catch (Exception e) {
            System.out.println("Exception while taking Screenshot " + e.getMessage());
        }
    }
}
