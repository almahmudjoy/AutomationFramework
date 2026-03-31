package test;

import drivers.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import drivers.PageDriver;
import pages.DashboardPage;


public class DashboardTest extends BaseTest {
    @BeforeClass
    public void openUrl() {
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);
    }
    @Test(priority=0)
    public void DashboardTest() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.clickAdmin();
    }
}