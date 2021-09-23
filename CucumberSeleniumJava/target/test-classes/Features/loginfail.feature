Feature: Login funtionality with incorrect password


  Scenario: Attempt to log in with an incorrect password and 
  verify invalid password message displays
  
    Given user2 is on login page
    When user2 enters username and password
    And user2 clicks on login button
    Then invalid password message displays
