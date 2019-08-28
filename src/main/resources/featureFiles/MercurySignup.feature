Feature: As a user i want to be able to signup to the Mercury tours website and automate the process

  @AutomatedScenario
  Scenario Outline: Signup using valid details
    Given I am on the Mercury site
    When I click on Signup button
    And enter details as follows "<firstName>", "<lastName>", "<email>", "<username>" and "<password>"
    And click on submit
    Then "<firstName>", "<lastName>" and "<username>" are displayed on the confirmation page
  @pre
    Examples:
      | firstName | lastName | email               | username   | password  |
      | SamREawR   | SamwSEaR  | samSweRa@hotmail.com | sameRwaaPot | HoRawpeSam |
      | AdaWeR     | AdaBeR    | adaeR@yahoo.com      | adIRse      | isRAdde    |
  @dev
    Examples:
      | firstName | lastName | email               | username   | password  |
      | SamREawRq   | SamwSEaRq  | samSweRqa@hotmail.com | sameRwaaPotq | HoRawpeSamq |
      | AdaWeqR     | AdaBeRq    | adaeRq@yahoo.com     | adIRseq      | isRAddeq    |
      | SamREa    | SamSEa   | samSea@hotmail.com  | sameaPot   | aHoPeSam  |
#      | AdaWf     | AdaBf    | adaf@yahoo.com      | adfIs      | isAfdd    |

  @pro
    Examples:
      | firstName | lastName | email               | username   | password  |
      | SamREawRq   | SamwSEaRq  | samSweRqa@hotmail.com | sameRwaaPotq | HoRawpeSamq |
      | AdaWeqR     | AdaBeRq    | adaeR@yahoo.com q     | adIRseq      | isRAddeq    |
#      | SamREa    | SamSEa   | samSea@hotmail.com  | sameaPot   | aHoPeSam  |
#      | AdaWf     | AdaBf    | adaf@yahoo.com      | adfIs      | isAfdd    |

#  @dev
  Scenario: login to the Mercury site using valid login details
    Given I am on the Mercury site
    When i enter valid username and password as "sameRwaaPot" and "HoRawpeSam"
    And click sign-in button
    Then I should be signed in

  Scenario: Test that user cannot login to the Mercury site using invalid login details
    Given I am on the Mercury site
    When i enter invalid username and password as "sOOOaaPotPP" and "HOOOIpeSamPP"
    And click sign-in button
    Then I should NOT be signed in