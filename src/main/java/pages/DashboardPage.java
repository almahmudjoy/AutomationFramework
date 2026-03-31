package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import drivers.PageDriver;
import utility.CommonMethod;

public class DashboardPage extends CommonMethod{
    //incase of constructor no 'void'
    public DashboardPage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
    }
    @FindBys({
            @FindBy(xpath="//span[normalize-space()='Directory']']")
    })
    WebElement adminOption;

    public void clickAdmin() {
        try{
            if(adminOption.isDisplayed()) {
                adminOption.click();
                timeout();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}