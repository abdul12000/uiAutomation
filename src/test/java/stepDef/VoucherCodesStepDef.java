package stepDef;

import base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.VoucherCodePage;

public class VoucherCodesStepDef extends BaseUtil {

    private BaseUtil base;

    public VoucherCodesStepDef(BaseUtil base) {
        this.base = base;
    }


    @Given("^I am on the voucher codes page$")
    public void iAmOnTheVoucherCodesPage() throws Throwable {
        base.driver.navigate().to("http://newtours.demoaut.com/");
    }

    @When("^I enter sign up with the following details \"([^\"]*)\", \"([^\"]*)\"$")
    public void iEnterSignUpWithTheFollowingDetails(String email, String pswd) throws Throwable {
        VoucherCodePage voucherCodePage = new VoucherCodePage(base.driver);
        voucherCodePage.clickOnAccountButton();
        voucherCodePage.clickOnSignUpButton();
        voucherCodePage.enterEmailAddress(email);
        voucherCodePage.enterPassword(pswd);

    }

    @Then("^is hould be on the landing page$")
    public void isHouldBeOnTheLandingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

}
