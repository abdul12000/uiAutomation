  @dev
Feature: As a user I want to be able to check the rate of Mortgaes available to me

#  Background:
  Scenario Outline: Calculate mortgage
    Given I am on the Mortgage Calculator Home Page
    When I enter valid details "<Home_Value>", "<Down_Payment>", "<Loan_Amount>", "<Interest_Rate>", "<Loan_Term>", "<Start_Date>" to calculate Mortgage
    And click on continue button
    Then "<Monthly_repayment>", "<Down_PymtAmount>", "<Monthly_Tax>" and "<Monthly_HomeInsurance>" to be paid are displayed
    Examples:
      | Home_Value | Down_Payment | Loan_Amount | Interest_Rate | Loan_Term | Start_Date | Monthly_repayment | Down_PymtAmount | Monthly_Tax | Monthly_HomeInsurance |
      | 180000     | 25000        | 155000       |6            | 15        | 2019       | $1,655.89        | $25,000.00      | $200.00     | $83.33                |
#      | 200000     | 30000        | 170000      | 7             | 25        | 2019       | $1,555.69        | $30,000.00     | $200.00     | $83.33               |
#      | 160000     | 5000