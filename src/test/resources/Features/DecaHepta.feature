Feature: ContestantStoring

Scenario: Store The Name
Given I am at the menu for inputting a contestant
When I enter the contestants name, "Bilbo Baggins" 
Then the name is saved for later use 

