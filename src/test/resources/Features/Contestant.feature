Feature: Assign event scores to contestants

  Scenario Outline: Assign an event score to a contestant
    Given I have entered a result 7.2 and score of 900.0 for "Daniel Almgren" in event "Jump"
    Given I have added a result 70.3 and score of 230.2 in event "Javelin"
    Then I can verify the 1130.2

 