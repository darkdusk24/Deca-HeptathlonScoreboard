package stepDefinitions;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.*;
import sprint1.CompetitorsScore;

public class CompetitorSteps {

	private CompetitorsScore competitorScore;

	@Given("I have entered a result {double} and score of {int} for {string} in event {string}")
	public void i_have_entered_an_event_score_for_a_contestant(Double result, int score, String competitorName, String event) {
//		competitorScore = new CompetitorsScore(competitorName);
//		competitorScore.addSportEvent(event, result, score);
	}
	
	@Given("I have added a result {double} and score of {double} in event {string}")
	public void i_have_added_an_event_score_for_a_contestant(Double result, Double score, String event) {
//		competitorScore.addSportEvent(event, result, score);
	}

	@Then("I can verify the {double}")
	public void i_can_verify_the_score(Double score) {
//		assertEquals(score, competitorScore.getTotalScore());
	}

}
