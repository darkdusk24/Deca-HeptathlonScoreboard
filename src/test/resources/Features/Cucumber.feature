Feature: Enter name 
I want to input a contestants name and have the program store it for later use 

Scenario: I want to register a contestant
Given I am at the menu for inputing contestants 
When I enter the contestants name, "Bilbo Baggins" 
Then the name is saved for later use 
