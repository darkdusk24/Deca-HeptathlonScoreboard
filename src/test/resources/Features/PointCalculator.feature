Feature: Point Calculator
I want to be able to input a contestants performance and have the points calculated

Scenario Outline: Event score
Given the main event is a <combinedEvent>
And the event is <event>
When the <performance> is entered
Then the <score> is calculated and returned

Examples:
| combinedEvent|			 event| performance|score|
|		"Decathlon"|	   "100 m"|				 10.0| 1096|
|		"Decathlon"| "Long jump"|				700.0|	814|
|	 "Heptathlon"| "Long jump"|				700.0| 1172|
|	 "Heptathlon"|"200 metres"|				 23.0| 1079|