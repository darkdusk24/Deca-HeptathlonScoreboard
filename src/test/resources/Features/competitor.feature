Feature: Assigning a competitor in an event

  I want to assign a score to a competitor
  @myTag
  Scenario Outline: Assign competitor to an event
    Given I have entered a "<name>" into the system
    When I have chosen the "<sportsEvent>"
    And I have assigned  a <score> to the competitor
    Then I can then view the "<name>" "<sportsEvent>" <score>

  Examples:
    | name | sportsEvent | score |
    | Calvin | 110mH | 900 |
