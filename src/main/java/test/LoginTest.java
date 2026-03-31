package test;

import drivers.BaseTest;
import drivers.PageDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @BeforeClass
    public void openUrl() {
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);
    }
    @Test(priority=0)
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
}
