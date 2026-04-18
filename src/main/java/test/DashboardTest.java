package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import drivers.PageDriver;
import pages.DashboardPage;
import utility.ExtentFactory;

//import javax.naming.ldap.ExtendedRequest;
import java.io.IOException;


public class DashboardTest extends BaseTest {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void openUrl() {
        PageDriver.getCurrentDriver().manage().window().maximize();
//        PageDriver.getCurrentDriver().get(url);

        report = ExtentFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\">" +
                "<b>OrangeHRM TEST</b></p>").assignAuthor("JOY").assignDevice("Windows");
    }

    @Test(priority=0)
    public void dashboardTest() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\">" +
                "<b>Dashboard Test</b></p>");
        DashboardPage dashboardPage = new DashboardPage(childTest);
        dashboardPage.clickAdmin();
    }
    @AfterClass
    public void afterClass() {
        report.flush();
    }
}