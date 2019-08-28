package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MercuryLoginPage extends BasePage {
    public MercuryLoginPage(WebDriver driver){super(driver);}
    @FindBy(xpath = "//input[@name='userName']")
    private WebElement usernameLocator;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordLocator;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement signInButtonLocator;

    public void enterUserName(String uName){
//        usernameLocator.sendKeys(uName);
        sendKeys(usernameLocator, uName);

    }

    public void enterPasswod(String pWord){
        passwordLocator.sendKeys(pWord);
        sendKeys(passwordLocator, pWord);
    }

    public void enterPasswodB(String pWordA, String pWordB){
        sendKeys(passwordLocator, pWordA, pWordB);
    }

    public void clickOnSignInButton(){
        click(signInButtonLocator);
    }
//    public String getPageTitle(){
//        return
//    }

    public void printPageTitle(){
        System.out.println("THIS IS FROM THE MERCURYLOGINPAGE");
    }

}
