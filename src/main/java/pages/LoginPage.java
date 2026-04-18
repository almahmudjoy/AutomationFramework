package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import drivers.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.CommonMethod;
import utility.ExtentFactory;
import utility.GetScreenShot;

import java.io.IOException;

public class LoginPage extends CommonMethod {

    /*
     * 1.PageFactory initialization
     * 2. Locators
     * 3. functions
     */


    ExtentTest test;
    public LoginPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    @FindBys({
        @FindBy(xpath = "//input[@name='username']"),
        @FindBy(xpath = "//input[@placeholder='Username']")
    })
    WebElement userName;

    @FindBys({
            @FindBy(xpath = "//input[@type='password']"),
//		    @FindBy(xpath = "//input[@placeholder='Password']"),
    })

    WebElement password;

    @FindBys({
            @FindBy(xpath = "//button[@type='submit']")
    })

    WebElement loginButton;

    public void login() throws InterruptedException, IOException {
        timeout();
        try {
            if(userName.isDisplayed()) {
                userName.sendKeys("Admin");
                timeout();
            }
        }catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Custom message </b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "user name");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "username.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(userName.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }

        try {
            if(password.isDisplayed()) {
                password.sendKeys("admin123");
                timeout();
            }
        }catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Custom message </b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "password fail");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "passwordfail.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(password.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }

        try {
            if(loginButton.isDisplayed()) {
                loginButton.click();
                timeout(5000);
                test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>Custom message.</b></p>");
                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "login pass");
                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginpass.png";
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        }catch(Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Custom message </b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "login fail");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginfail.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(loginButton.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }
    }

}
