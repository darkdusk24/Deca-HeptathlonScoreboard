Feature: User Authentication
  To avoid unauthorized personel from messing with the scores you have to put in a hard coded password
  @mytag
  Scenario Outline: Password input
    Given I have entered the <password>
    Then the correct <response> should happen

    Examples:
      |	password | response |
      |"DecaHepta123"|"true"|
      |"DecaHepta124"|"false"|