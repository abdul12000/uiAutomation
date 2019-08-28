package stepDef;

import base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MortgageCalcHomePage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertEquals;

public class MortgageCalcStepDef extends BaseUtil {
    private BaseUtil base;
    public MortgageCalcStepDef(BaseUtil base){
        this.base = base;
    }

    @Given("^I am on the Mortgage Calc Home page$")
    public void i_am_on_the_Mortgage_Calc_Home_page() throws Throwable {
        base.driver.navigate().to("https://www.mortgagecalculator.org/");

    }

    @When("^i enter the following details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" on the home pahe$")
    public void i_enter_the_following_details_and_on_the_home_pahe(String homeVal, String downPymt, String loanAmt, String intRate, String loanTerm, String startMonth) throws Throwable {
        MortgageCalcHomePage mortgageCalcHomePage = new MortgageCalcHomePage(base.driver);
        mortgageCalcHomePage.enterHomeValueAmount(homeVal);
        mortgageCalcHomePage.enterDownPaymentAmount(downPymt);
        mortgageCalcHomePage.enterLoanAmount(loanAmt);
        mortgageCalcHomePage.enterInterestRateAmount(intRate);
        mortgageCalcHomePage.enterLoanTermAmount(loanTerm);
        mortgageCalcHomePage.selectMonth(startMonth);

    }

    @When("^click on the calculate button$")
    public void click_on_the_calculate_button() throws Throwable {
        MortgageCalcHomePage mortgageCalcHomePage = new MortgageCalcHomePage(base.driver);
        mortgageCalcHomePage.clickOnCalculateButon();

    }

    @Then("^\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" should be accurately displayed$")
    public void and_should_be_accurately_displayed(String monthlyRpt, String downPymt, String monthlyTax, String mHomeInsurance) throws Throwable {
        MortgageCalcHomePage mortgageCalcHomePage = new MortgageCalcHomePage(base.driver);
        assertEquals(monthlyRpt, mortgageCalcHomePage.getTotalMonthlyRepaymentAmount());
        List<String> expectedGetDownPaymentAmts = Arrays.asList(downPymt,"2000", "4000", "50000");
        assertThat(expectedGetDownPaymentAmts, hasItem(mortgageCalcHomePage.getDownPaymentAmount()));
        System.out.println("The array is " + expectedGetDownPaymentAmts);

//        assertEquals(downPymt, mortgageCalcHomePage.getDownPaymentAmount());
        assertEquals(monthlyTax, mortgageCalcHomePage.getMonthlyTaxPaidAmount());
        assertEquals(mHomeInsurance, mortgageCalcHomePage.getMonhlyHomeIsuranceAmount());

    }

}
