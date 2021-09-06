Feature: ContestantStoring

Scenario Outline: Store The Name
Given I am at the menu for inputting a contestant
When I enter the contestants <name>
And I enter the contestants countrys alpha3 <code>
And I enter the contestants <number> 
Then the name is saved for later use 

Examples:
|			name| code|number|
|"Bilbo Baggins"|"SWE"|	   12|