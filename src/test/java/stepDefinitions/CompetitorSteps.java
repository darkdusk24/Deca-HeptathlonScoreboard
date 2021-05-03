package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.Before;
import io.cucumber.java.ca.Cal;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sprint1.CompetitorsScore;

public class CompetitorSteps {
	
	private List<CompetitorsScore> competitorScoreList;
	
	@Before() 
	public void setUp() {
		competitorScoreList = new ArrayList<>();
	}
	
	@Given("I have entered an {string} {string} for a {string}")
	public void i_have_entered_an_event_score_for_a_competitor(
			String event, 
			String score, 
			String competitor) {
	  
	  }
	 
	
	@Then("I can view the score")
	public void iCanViewTheScore() {	
		Double expectedScore = 900.0;
		//assertEquals(expectedScore, competitorScore.getScore(), 0);
	}
	
}
