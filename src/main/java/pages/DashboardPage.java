package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import org.testng.Assert;
import utility.CommonMethod;
import utility.GetScreenShot;

import java.io.IOException;

public class DashboardPage extends CommonMethod{

    ExtentTest test;
    public DashboardPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }


    //incase of constructor no 'void'
    public DashboardPage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
    }
    @FindBys({
            @FindBy(xpath="//span[normalize-space()='Admin']")

    })
    WebElement adminOption;

    public void clickAdmin() throws IOException  {
        try{
            if(adminOption.isDisplayed()) {
                adminOption.click();
                timeout();
                test.pass("Clicked on Admin option");
            }
        }catch(Exception e){
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Access Denied </b></p>");
//            Throwable t = new InterruptedException("Exception");
//            test.fail(t);
            test.fail(e);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "admin_error");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "admin_error.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
//          Assert.assertTrue(adminOption.isDisplayed());
            Assert.fail("Test failed due to exception");
//            PageDriver.getCurrentDriver().quit();
        }
    }
}