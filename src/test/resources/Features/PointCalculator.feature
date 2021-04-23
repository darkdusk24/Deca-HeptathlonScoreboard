Feature: Point Calculator
I want to be able to input a contestants performance and have the points calculated

Scenario Outline: 100 meters
When the <performance> is entered
Then the <score> is calculated and outputted

Examples:
|performance|score|
|				10.0| 1096|