package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MercurySignUpConfirmPage extends BasePage {

    public MercurySignUpConfirmPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td/p[1]/font/b")
    private WebElement dearLocator;
    @FindBy(xpath = "//a/font/b")
    private WebElement noteLocator;

    public String getDearMsg(){
        String dearText = dearLocator.getText();
        return dearText;
    }

    public String getNoteMsg(){
        return noteLocator.getText();

    }
}


