Feature: Assign event scores to contestants

  Scenario Outline: Assign an event score to a contestant
    Given I have entered a score of 900.0 for "Daniel Almgren" in event "Jump"
    Then I can verify the score
