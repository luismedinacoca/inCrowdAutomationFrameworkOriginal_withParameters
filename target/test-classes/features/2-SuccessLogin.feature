Feature: Successful Orange HRM Login
  @smoke
  Scenario: Successful Admin Login using invalid credentials
    Given user is on the "login" screen
    And user enter username "Admin" and password "admin123" to login
    Then user is on the "home" screen


