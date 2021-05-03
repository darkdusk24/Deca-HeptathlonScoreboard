Feature: Assigning a competitor in an event, I want to assign a score to a competitor
  
  Scenario: Assign competitor result to an event
  
    Given I have entered an "<event>" "<score>" for a "<competitor>"
    |competitor	|event			|score|
    |Calvin			|110mH			|900.0|
    Then I can view the score