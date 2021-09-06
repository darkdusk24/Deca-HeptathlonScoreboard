Feature: Point Calculator
I want to be able to input a contestants performance and have the points calculated

Scenario Outline: Event score
Given the main event is a <combinedEvent>
And the event is <event>
When the <performance> is entered
Then the <score> is calculated and returned

Examples:
| combinedEvent|			 event| performance|score|
|	  "Decathlon"|	   "100 m"|				 10.0| 1096|
|	  "Decathlon"| "Long jump"|				700.0|	814|
|	 "Heptathlon"| "Long jump"|				700.0| 1172|
|	 "Heptathlon"|	   "200 m"|				 23.0| 1079|

@mytag
Scenario Outline: Total score Decathlon
Given the main event is a <combinedEvent>
Given the contestants results are <eventscores>
Then the <totalscore> is calculated and it is returned

Examples:
|combinedEvent|													   eventscores|totalscore|
|  "Decathlon"|		[11.0, 685.0, 14.6, 0.0, 82.0, 28.5, 0.0, 0.0, 0.0, 480.0]|		 2404|
|  "Decathlon"|[10.0, 694.0, 15.6, 210.0, 50.30, 15.2, 49.3, 493, 69.5, 245.0]|		 8788|
| "Heptathlon"|						 [10.0, 210.0, 0.0, 42.5, 0.0, 0.0, 254.0]|		 2990|