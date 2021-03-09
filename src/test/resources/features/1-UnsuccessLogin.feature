Feature: Unsuccessful Orange HRM Login
  @smoke
  Scenario: Unsuccessful Admin Login using invalid credentials
    Given user is on the "login" screen
    And user enter username "Admin" and password "admin-123" to login
    Then user is on the "login" screen


