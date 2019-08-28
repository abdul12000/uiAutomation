package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MercurySignUpPage extends BasePage {


    public MercurySignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[contains(text(),'SIGN-ON')]")
    private WebElement signOnLocator;

    @FindBy (partialLinkText = "registration")
    private WebElement registrationLinkLocator;

    @FindBy (xpath = "//select[@name='country']")
    private WebElement countryLocator;

    @FindBy (xpath = "//input[@name='firstName']")
    private WebElement enterNameLocator;

    @FindBy(css = "input[name='firstName']")
    private WebElement firstNameLocator;

    @FindBy(css = "input[name='lastName']")
    private WebElement lastNameLocator;

    @FindBy(css = "input[id='userName']")
    private WebElement emailLocator;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement countrySelectLocator;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement usernameLocator;


    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordLocator;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPasswordLocator;

    @FindBy(xpath = "//input[@name='register']")
    private WebElement confirmButtonLocator;

    public void clickOnSignupLink(){
        signOnLocator.click();
    }
    public void clickOnRegistrationLink(){
        registrationLinkLocator.click();
    }

    public void enterFirstName(String firstName){
        firstNameLocator.sendKeys(firstName);
    }
    public void enterLastName(String LastName){
       sendKeys(lastNameLocator, LastName);
    }
    public void enterEmailAddress(String email){
        sendKeys(emailLocator, email);
    }
    public void selectCountry(){
        Select country = new Select(countrySelectLocator);
        country.selectByVisibleText("UNITED KINGDOM ");
    }
    public void enterUserName(String username){
        usernameLocator.sendKeys(username);
    }
    public void enterPassword(String pwd){
        passwordLocator.sendKeys(pwd);
    }
    public void enterConfirmPassword(String pwd){
        confirmPasswordLocator.sendKeys(pwd);
    }
    public void clickSubmitutton(){
        confirmButtonLocator.click();
    }





}
