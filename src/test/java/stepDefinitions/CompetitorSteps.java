package stepDefinitions;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.*;
import sprint1.CompetitorsScore;

public class CompetitorSteps {
	
	private CompetitorsScore competitorScore;
	private Double expectedScore;
	
	@Given("I have entered a score of {double} for {string} in event {string}")
	public void i_have_entered_an_event_score_for_a_contestant(
			Double score,  
			String competitorName, 
			String event) {
			competitorScore = new CompetitorsScore(competitorName);
			competitorScore.setSportsEvent(event);
			competitorScore.setScore(score);
			expectedScore = score;
	  }
	 
	
	@Then("I can verify the score")
	public void i_can_verify_the_score() {	
		assertEquals(expectedScore, competitorScore.getScore(), 0);
	}
	
}
