package Pages;


import com.Baseclass.Browserfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Browserfactory{


    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(id="txtPassword")
    WebElement password;

    @FindBy(id="btnLogin")
    WebElement loginbutton;

    @FindBy(id="welcome")
    WebElement welcomeuser;



    public void usernameandpassword(String uname, String pass){
        username.sendKeys(uname);
        password.sendKeys(pass);
    }

    public void clickbutton() {

        loginbutton.click();
    }
    public boolean verifyLogin() {

        boolean welcome = false;

        if (welcomeuser.isDisplayed()) {
            String text = welcomeuser.getText();
            welcome = text.contains("Welcome");
        }
        return welcome;



    }


}
