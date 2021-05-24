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
|	 "Heptathlon"|		 "200 m"|				 23.0| 1079|


Scenario Outline: Total score
Given the contestants scores are <eventscores>
Then the <totalscore> is calculated and it is returned

Examples:
|																				  eventscores|totalscore|
|							 [900, 1200, 1500, 0, 0, 0, 0, 0, 0, 0]|		  3600|
|[800, 1300, 1550, 567, 658, 500, 600, 600, 300, 700]|			7575|