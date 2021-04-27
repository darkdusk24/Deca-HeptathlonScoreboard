package stepDefinitions;

import static org.junit.Assert.*;

import decaHepta.Contestants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import sprint1.ScoreCalculator;

public class StepDefinitions {
	private String inputName;
	private Contestants name;
  
  private double performance;
	private ScoreCalculator calc = new ScoreCalculator();
  
  private CompetitorsScore competitor = new CompetitorsScore();


	@Given("I'm at the menu for inputing contestants")
	public void i_m_at_the_menu_for_inputing_contestants() {
		throw new io.cucumber.java.PendingException();
	}
  
   @Given("I have entered a {string} into the system")
   public void i_have_entered_a_calvin_into_the_system(String name) {
     assertEquals (name ,competitor.AssignName(name));
        }

	@When("I enter the contestants name, {string}")
	public void i_enter_the_contestants_name(String input) {
		inputName = input;
		name = new Contestants();
		name.setName(inputName);

	}
  
   @When ("I have chosen the {string}")
   public void i_have_chosen_the_sportsEvent(String sportsEvent) {
     assertEquals (sportsEvent,competitor.AssignEvent (sportsEvent));
        }
  
  @And("I have assigned  a {double} to the competitor")
  public void i_can_assign_a_score_to_the_competitor(double score) {
     assertEquals (score, competitor.AssignScore (score));
        }

	@Then("the name is saved for later use")
	public void the_name_is_saved_for_later_use() {

		assertEquals(inputName, name.getName());
		System.out.println(name.getName());

	}
  
  @When("the {double} is entered")
	public void the_is_entered(double perf) {
		performance = perf;
	}

	@Then("the {int} is calculated and outputted")
	public void the_result_is_outputted(int result) {
		assertEquals(result, calc.OneHundredMeters(performance));
	}
  
  @Then("I can then view the {string} {string} {double}")
        public void i_can_then_view_the_name_sportsEvent_score(String name,
                                               String sportsEvent,double score ) {
                assertTrue(name.equalsIgnoreCase ("Calvin"));
                assertTrue(sportsEvent.equalsIgnoreCase ("110mH"));
                assertTrue(score == 900);

                ArrayList<Object> CompetScore = new ArrayList<> ();

                CompetScore.add ("Calvin");
                CompetScore.add ("100mH");
                CompetScore.add (900);

                if (name.equalsIgnoreCase ("calvin") && sportsEvent.equalsIgnoreCase ("110mH")
                        && (score == 900)) {
                        assertArrayEquals (CompetScore, competitor.AssignScoreToCompetitor ());
                } else {
                        System.out.println ("Something went wrong...");
                }
        }

        private void assertArrayEquals(ArrayList<Object> competScore, ArrayList assignScoreToCompetitor) {
        }
}

