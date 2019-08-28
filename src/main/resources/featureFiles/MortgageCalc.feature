Feature: I want to be able check that the Mortgage rate are correctly calculated
  @dev1
  Scenario Outline:Mortgage rate calculator
    Given I am on the Mortgage Calc Home page
    When i enter the following details "<homeValue>", "<downPayment>", "<loanAmount>", "<interestRate>", "<loanTerm>" and "<startMonth>" on the home pahe
    And click on the calculate button
    Then "<monthlyRepayment>", "<downPayAmaount>", "<monthlyTax>" and "<monthlyHomeInsurance>" should be accurately displayed
    Examples:
      | homeValue | downPayment | loanAmount | interestRate | loanTerm | startMonth | monthlyRepayment | downPayAmaount | monthlyTax | monthlyHomeInsurance |
      | 180000    | 25000       | 155000     | 6            | 15       | Sep        | $1,655.89        | $25,000.00     | $200.00    | $83.33               |