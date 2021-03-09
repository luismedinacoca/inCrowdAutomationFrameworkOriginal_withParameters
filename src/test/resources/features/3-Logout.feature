Feature: Successful Orange HRM Logout
  @smoke
  Scenario: Successful Admin Logout
    Given user is on the "home" screen
    And user clicks on Logout button
    Then user is on the "login" screen