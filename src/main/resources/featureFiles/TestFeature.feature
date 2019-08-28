Feature: As a user i want to be able to signup to the Mercury tours website and automate the process

  @AutomatedScenario @dev
  Scenario: Test that user cannot login to the Mercury site using invalid login details
    Given I am on the Mercury site
    When i enter invalid username and password as "sOOOaaPotPP" and "HOOOIpeSamPP"
    And click sign-in button
    Then I should NOT be signed in