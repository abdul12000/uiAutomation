package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABCTest extends BasePage implements MortgageHomePageInterface {

    public ABCTest(WebDriver driver) {
        super(driver);
    }
    //    @FindBy (id="homeval")
//    private WebElement homeValue;
    @FindBy (xpath = "//input[@id='homeval']")
    private WebElement homeValue;

//    @FindBy (css = "input#homeval")
//    private WebElement homeValue;

    @FindBy (id="downpayment")
    private WebElement downPayment;
    @FindBy (id="loanamt")
    private WebElement loanAmount;
    @FindBy (id="intrstsrate")
    private WebElement interestRate;
    @FindBy (id="loanterm")
    private WebElement loanTerm;
    @FindBy (id="start_year")
    private WebElement startYear;

    @FindBy (xpath = "//div[@class='repayment-block']/div[1]/div[1]/h3")
    private WebElement mRepaymentLocator;
    @FindBy (xpath = "//div[@class='repayment-block']/div[3]/div[1]/h3")
//    @FindBy (xpath = "//div[@class='repayment-block']/div[3]/div[1]/h3(text")
    private WebElement downPaymtAmtLocator;
    @FindBy (xpath = "//div[@class='repayment-block']/div[5]/div[1]/h3")
    private WebElement monthlyTaxPaidLocator;
    @FindBy (xpath = "//div[@class='repayment-block']/div[6]/div[1]/h3")
    private WebElement monthlyHomeInsuranceLocator;

    @FindBy (xpath = "//input[@value='Calculate']")
    private WebElement calculateButtonLocator;


    public void enterHomeValue(String hVal){
        sendKeys(homeValue, hVal);
    }
    public void enterDownPayment(String dPay){
        sendKeys(downPayment, dPay);
    }
    public void enterLoanAmount(String lAmount){
        loanAmount.sendKeys(lAmount);
    }
    public void enterIntrestRate(String intRate){
        interestRate.sendKeys(intRate);
    }
    public void enterLoanTerm(String lTerm){
        loanTerm.sendKeys(lTerm);
    }
    public void enterStartYear(String stYear){
        startYear.sendKeys(stYear);
    }

    public String getMonthlyPaymentAmount(){
        return mRepaymentLocator.getText();
    }
    public String getDownPaymtAmt(){
        return downPaymtAmtLocator.getText();
    }
    public String getMonthlyTaxPaid(){
        return get_Text(monthlyTaxPaidLocator);
//        return monthlyTaxPaidLocator.getText();
    }
    public String getMonthlyHomeInsurance(){
        return monthlyHomeInsuranceLocator.getText();
    }
    public void clickOnContinueButton(){
        calculateButtonLocator.click();
    }

}
