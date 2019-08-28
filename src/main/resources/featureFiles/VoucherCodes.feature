#@AutomatedScenario
Feature: As a user I want to be able to Sign up

#  Background:
  Scenario Outline: Sign up
    Given I am on the voucher codes page
    When I enter sign up with the following details "<emailAddress>", "<password>"
    Then is hould be on the landing page
    Examples:
      | emailAddress                | password    |
      | sherifabdulsalam8@gmail.com | UsualUsual1 |