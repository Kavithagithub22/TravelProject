package Pages;

import com.Baseclass.Browserfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage extends Browserfactory {

    public LeavePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(id="txtUsername")
    WebElement username;

    @FindBy(id="txtPassword")
    WebElement Password;

    @FindBy(id="btnLogin")
    WebElement loginbutton;

    public void usernameandpassword(String uname, String pass) {

        username.sendKeys(uname);
        Password.sendKeys(pass);
    }

    public void clickbutton() {
        loginbutton.click();


    }

    @FindBy(linkText="Admin")
    WebElement admin;
    @FindBy(id="searchSystemUser_userName")
    WebElement Uname;

    public void Click_Admin(){
        admin.click();
    }
    public void Click_Username(String name){
        Uname.sendKeys(name);


    }

    @FindBy(linkText="Leave")
    WebElement leave;

    @FindBy(id="calFromDate")
    WebElement from;

    public void Click_Leave() {
        leave.click();


    }


}
