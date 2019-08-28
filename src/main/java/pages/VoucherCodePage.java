package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VoucherCodePage extends BasePage {

    public VoucherCodePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[contains(text(),'SIGN-ON')]")
    private WebElement signOnLocator;

    @FindBy (partialLinkText = "registration")
    private WebElement RegisterpLinkLocator;

    @FindBy (xpath = "//input[@name='email']")
    private WebElement emailFieldLocator;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement passwordFieldLocator;

    public void clickOnAccountButton(){
        signOnLocator.click();
    }
    public void clickOnSignUpButton(){
        RegisterpLinkLocator.click();
    }
    public void enterEmailAddress(String email){
        emailFieldLocator.sendKeys(email);
    }

    public void enterPassword(String pswd){
        passwordFieldLocator.sendKeys(pswd);
    }
}
