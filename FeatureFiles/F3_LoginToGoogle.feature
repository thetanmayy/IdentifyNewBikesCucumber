Feature: Login to Google with Invalid Email Id

  Scenario: Login to Google
    Given Click on Login or Signup button
    When Select Google to Login
    Then Give Invalid Email Id for Login
    And Extract the Error Message Displayed

  @sanity
  Scenario: Login to Google
    Given Click on Login or Signup button
