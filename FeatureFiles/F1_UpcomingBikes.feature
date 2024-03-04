Feature: IdentifyNewBikes

  Scenario: To Display New bikes of Honda
    Given Launching zigwheels website in web browser
    When Selecting Upcoming bikes from new bikes dropdown
    And Selecting the manufacturer as Honda
    Then Extracting New Bikes of Honda

  @sanity
  Scenario: To Display New bikes of Honda
    Given Launching zigwheels website in web browser
    When Selecting Upcoming bikes from new bikes dropdown
