package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriverWait wait;
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver,20);
    }

    /**
     * Common explicit wait methods;
     */

    public void waitForVisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForClickabilityOfElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Common interaction methods;
     */

    public void sendKeys(WebElement element, String keyword){
        waitForVisibilityOfElement(element);
        element.clear();
        element.sendKeys(keyword);
    }
    public void sendKeys(WebElement element, String keywordA, String kewyordB){
        waitForVisibilityOfElement(element);
        element.clear();
        element.sendKeys(keywordA + kewyordB);
    }


    public void submit(WebElement element){
        waitForVisibilityOfElement(element);
        element.submit();;
    }

    public void click(WebElement element){
        waitForVisibilityOfElement(element);
        element.click();
    }

    public void selectFromDropDownUsingIndex(WebElement element, int index){
        waitForVisibilityOfElement(element);
        Select sfos = new Select(element);
        sfos.selectByIndex(index);
    }

    public void selectFromDropDownUsingOption(WebElement element, String option){
        waitForVisibilityOfElement(element);
        Select sfos = new Select(element);
        sfos.selectByValue(option);
    }
    public void selectFromDropDownUsingVisibleText(WebElement element, String textName){
        waitForVisibilityOfElement(element);
        Select sfos = new Select(element);
        sfos.selectByVisibleText(textName);
    }

    public String get_Text(WebElement element){
        waitForVisibilityOfElement(element);
        return element.getText();
    }
    public void printPageTitle(){
        System.out.println("THIS IS FROM THE BASEPAGE");
    }

}

