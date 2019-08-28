package stepDef;

import base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.MercuryLoginPage;
import pages.MercurySignUpConfirmPage;
import pages.MercurySignUpPage;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MercurySignup_SteDef extends BaseUtil {
    private BaseUtil base;

    public MercurySignup_SteDef(BaseUtil base) {
        this.base = base;
    }
public int get4RandomDigits(){
        Random  rand = new Random();
        int ran_integer = rand.nextInt(9999);
        return ran_integer;
}

    @Given("^I am on the Mercury site$")
    public void i_am_on_the_Mercury_site() throws Throwable {
        base.driver.navigate().to("http://newtours.demoaut.com");

    }

    @When("^I click on Signup button$")
    public void i_click_on_Signup_button() throws Throwable {
        MercurySignUpPage mercurySignUpPage = new MercurySignUpPage(base.driver);
//        mercurySignUpPage.clickOnSignupLink();
        base.driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
        mercurySignUpPage.clickOnRegistrationLink();


    }

    @When("^enter details as follows \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_details_as_follows_and(String fName, String lName, String email, String uName, String pwd) throws Throwable {
        MercurySignUpPage mercurySignUpPage = new MercurySignUpPage(base.driver);

        mercurySignUpPage.enterFirstName(fName);
        mercurySignUpPage.enterLastName(lName);
        mercurySignUpPage.enterEmailAddress(get4RandomDigits()+email);
        mercurySignUpPage.selectCountry();
        mercurySignUpPage.enterUserName(uName);
        mercurySignUpPage.enterPassword(pwd);
        mercurySignUpPage.enterConfirmPassword(pwd);
    }

    @When("^click on submit$")
    public void click_on_submit() throws Throwable {
        MercurySignUpPage mercurySignUpPage = new MercurySignUpPage(base.driver);
        mercurySignUpPage.clickSubmitutton();
    }

    @Then("^\"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" are displayed on the confirmation page$")
    public void and_are_displayed_on_the_confirmation_page(String fName, String lName, String uName) throws Throwable {
        MercurySignUpConfirmPage mercurySignUpConfirmPage = new MercurySignUpConfirmPage(base.driver);
        assertThat(mercurySignUpConfirmPage.getDearMsg(), is(equalTo("Dear " + fName + " " + lName + ",")));
//        mercurySignUpConfirmPage.getDearMsg();
        assertThat(mercurySignUpConfirmPage.getNoteMsg(), is(equalTo("Note: Your user name is " + uName + ".")));
//        assertThat(base.driver.findElement(By.xpath("//a/font/b")).getText(), is (equalTo("Note: Your user name is " + uName + ".")));

    }


    @When("^i enter valid username and password as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterValidUsernameAndPasswordAsAnd(String uName, String pword) throws Throwable {
        MercuryLoginPage mercuryLoginPage = new MercuryLoginPage(base.driver);
        mercuryLoginPage.enterUserName(uName);
        mercuryLoginPage.enterPasswod(pword);
    }

    @And("^click sign-in button$")
    public void clickSignInButton() throws Throwable {
        MercuryLoginPage mercuryLoginPage = new MercuryLoginPage(base.driver);
        mercuryLoginPage.clickOnSignInButton();
    }

    @Then("^I should be signed in$")
    public void iShouldBeSignedIn() throws Throwable {
        System.out.println("THIS IS THE PAGETITLE:  " + base.driver.getTitle());
        assertThat(base.driver.getTitle(), is (equalTo("Find a Flight Mercury Tours:")));
    }


    @When("^i enter invalid username and password as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterInvalidUsernameAndPasswordAsAnd(String uName, String pWord) throws Throwable {
        MercuryLoginPage mercuryLoginPage = new MercuryLoginPage(base.driver);
        mercuryLoginPage.enterUserName(uName);
        mercuryLoginPage.enterPasswod(pWord);
    }

    @Then("^I should NOT be signed in$")
    public void iShouldNOTBeSignedIn() throws Throwable {
        MercuryLoginPage mercuryLoginPage = new MercuryLoginPage(base.driver);
        mercuryLoginPage.printPageTitle();
        System.out.println("THIS IS THE PAGETITLE:  " + base.driver.getTitle());
        assertThat(base.driver.getTitle(), is (equalTo("Sign-on: Mercury Tours")));
    }
}
