package stepDef;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ABCTest;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ABCTestStep extends BaseUtil {

    private BaseUtil base;

    public ABCTestStep(BaseUtil base) {
        this.base = base;
    }

    @Then("^\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" to be paid are displayed$")
    public void andToBePaidAreDisplayed(String mRepaymt, String dPymtAmt, String mTax, String mHomeInsur) throws Throwable {
        ABCTest ABCTest = new ABCTest(base.driver);
        List<String > expectedMPaymentAmount = Arrays.asList(mRepaymt, "2000", "3000");
//        expectedMPaymentAmount.size();
        assertThat(expectedMPaymentAmount, hasItem(ABCTest.getMonthlyPaymentAmount()));
//        assertThat(ABCTest.getMonthlyPaymentAmount(), is(equalTo(mRepaymt)));
        assertThat(ABCTest.getDownPaymtAmt(), is(equalTo(dPymtAmt)));
        assertThat(ABCTest.getMonthlyTaxPaid(), is(equalTo(mTax)));
        assertThat(ABCTest.getMonthlyHomeInsurance(), is(equalTo(mHomeInsur)));
    }

    @And("^click on continue button$")
    public void clickOnContinueButton() throws Throwable {
        ABCTest ABCTest = new ABCTest(base.driver);
        ABCTest.clickOnContinueButton();
    }

    @Given("^I am on the Mortgage Calculator Home Page$")
    public void iAmOnTheMortgageCalculatorHomePage() throws Throwable {
        base.driver.navigate().to("https://www.mortgagecalculator.org");

    }

    @When("^I enter valid details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" to calculate Mortgage$")
    public void iEnterValidDetailsToCalculateMortgage(String hValue, String dPaymt, String lAmt, String intRate, String lTerm, String startDate) throws Throwable {
        ABCTest ABCTest = new ABCTest(base.driver);
        ABCTest.enterHomeValue(hValue);
        ABCTest.enterDownPayment(dPaymt);
        ABCTest.enterLoanAmount(lAmt);
        ABCTest.enterLoanTerm(lTerm);
        ABCTest.enterIntrestRate(intRate);
        ABCTest.enterStartYear(startDate);
    }
}
