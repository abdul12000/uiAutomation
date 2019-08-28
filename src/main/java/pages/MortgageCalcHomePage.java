package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MortgageCalcHomePage extends BasePage {
    public MortgageCalcHomePage(WebDriver driver){super (driver);}
    @FindBy(xpath="//input[@id='homeval']")
    private WebElement homeValInputLocator;
    @FindBy(xpath="//input[@id='downpayment']")
    private WebElement downpaymentInputLocator;
    @FindBy(xpath="//input[@id='loanamt']")
    private WebElement loanamtInputLocator;
    @FindBy(xpath="//input[@id='intrstsrate']")
    private WebElement intrstsrateInputLocator;
    @FindBy(id="loanterm")
    private WebElement loantermInputLocator;
    @FindBy(xpath="//select[@name='param[start_month]']")
    private WebElement startMonthSelectLocator;

    @FindBy(css="input[type='submit']")
    private WebElement calculateButtonLocator;
    @FindBy(xpath="//div[@class='repayment-block']/div[1]/div[1]/h3")
    private WebElement totalMonthlyRepaymentLocator;
    @FindBy(xpath="//div[@class='repayment-block']/div[3]/div[1]/h3")
    private WebElement downPaymentAmountLocator;
    @FindBy(xpath="//div[@class='repayment-block']/div[5]/div[1]/h3")
    private WebElement monthlyTaxPaidLocator;
    @FindBy(xpath="//div[@class='repayment-block']/div[6]/div[1]/h3")
    private WebElement monthlyHomeInsuranceLocator;

    public void enterHomeValueAmount(String amt){
        sendKeys(homeValInputLocator, amt);
    }
    public void enterDownPaymentAmount(String amt){
        sendKeys(downpaymentInputLocator, amt);
    }
    public void enterLoanAmount(String amt){
        sendKeys(loanamtInputLocator, amt);
    }
    public void enterInterestRateAmount(String amt){
        sendKeys(intrstsrateInputLocator, amt);
    }
    public void enterLoanTermAmount(String amt){
        sendKeys(loantermInputLocator, amt);
    }
    public void selectMonth(String monthName){
        selectFromDropDownUsingVisibleText(startMonthSelectLocator, monthName);
    }

    public void clickOnCalculateButon(){
//        click(calculateButtonLocator);
        calculateButtonLocator.click();
    }
    public String getTotalMonthlyRepaymentAmount(){
        return totalMonthlyRepaymentLocator.getText();
    }
    public String getDownPaymentAmount(){
        String downPayAmt = downPaymentAmountLocator.getText();
        return downPayAmt;
    }
    public String getMonthlyTaxPaidAmount(){
        return monthlyTaxPaidLocator.getText();
    }
    public String getMonhlyHomeIsuranceAmount(){
        return monthlyHomeInsuranceLocator.getText();
    }


}
