package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("WebDriver initialized");

        PageDriver.getInstance().setDriver(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            PageDriver.getCurrentDriver().quit();
            PageDriver.getInstance().setDriver(null); // IMPORTANT
            System.out.println("WebDriver closed");
        }
    }
}