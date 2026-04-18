package utility;

import drivers.BaseTest;
import drivers.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethod extends BaseTest {
    public static void timeout() throws InterruptedException {
        Thread.sleep(3000);
    }

    public static void timeout(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}