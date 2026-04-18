package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class GetScreenShot {
    public static String capture(WebDriver driver, String screenShotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + screenShotName + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        return dest;
    }
}