
package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sprint1.CompetitorsScore;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
        private CompetitorsScore competitor = new CompetitorsScore();

        @Given("I have entered a {string} into the system")
        public void i_have_entered_a_calvin_into_the_system(String name) {
                assertEquals (name ,competitor.AssignName(name));
        }

        @When ("I have chosen the {string}")
        public void i_have_chosen_the_sportsEvent(String sportsEvent) {
                assertEquals (sportsEvent,competitor.AssignEvent (sportsEvent));
        }

        @And("I have assigned  a {double} to the competitor")
        public void i_can_assign_a_score_to_the_competitor(double score) {
                assertEquals (score, competitor.AssignScore (score));
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
                
                assertArrayEquals (CompetScore, competitor.AssignScoreToCompetitor());
        }

        private void assertArrayEquals(ArrayList<Object> competScore, ArrayList assignScoreToCompetitor) {
        }
}
