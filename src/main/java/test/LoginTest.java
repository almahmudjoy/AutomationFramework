package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.BaseTest;
import drivers.PageDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.ExtentFactory;

import java.io.IOException;

public class LoginTest extends BaseTest {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void openUrl() {
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);

        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Orange HRM TEST</b>" +
                "</p>").assignAuthor("QA TEAM").assignDevice("Windows");
    }

    @Test(priority=0)
    public void loginTest() throws InterruptedException, IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\">" +
                "<b>Login Test</b></p>");
        LoginPage loginPage = new LoginPage(childTest);
        loginPage.login();
    }

    @AfterClass
    public void afterClass() {
        report.flush();
    }
}
