package pages;

import drivers.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utility.CommonMethod;

public class LoginPage extends CommonMethod {

    /*
     * 1.PageFactory initialization
     * 2. Locators
     * 3. functions
     */


    public LoginPage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
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

    public void login() throws InterruptedException {
        timeout();
        try {
            if(userName.isDisplayed()) {
                userName.sendKeys("Admin");
                timeout();
            }
        }catch(Exception e) {
            System.out.println(e);
        }

        try {
            if(password.isDisplayed()) {
                password.sendKeys("admin123");
                timeout();
            }
        }catch(Exception e) {
            System.out.println(e);
        }

        try {
            if(loginButton.isDisplayed()) {
                loginButton.click();
                timeout(5000);
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }

}
