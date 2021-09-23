Feature: Select row at Large & Deep DOM page

  Scenario Outline: Select a row
    Given user is at Large & Deep DOM page
    When user select row "<row>"
    Then row "<row>" is selected

    Examples: 
      | row      | 
      | Siblings |
      | 1.3      |    
      | 13.2     |