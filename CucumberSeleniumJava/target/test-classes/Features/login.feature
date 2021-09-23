Feature: Login funtionality


  Scenario: Successful log in and verify success message displays
  
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then success message displays
