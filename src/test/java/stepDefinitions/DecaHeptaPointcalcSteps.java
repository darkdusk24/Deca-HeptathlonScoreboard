package stepDefinitions;

import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import sprint1.Competitor;
import sprint1.ScoreCalculator;

public class DecaHeptaPointcalcSteps {

	private String inputName;
	private Competitor competitor;

	private double performance;
	private ScoreCalculator calc = new ScoreCalculator();

	// HeptaDeca Feature
	@Given("I am at the menu for inputting a contestant")
	public void i_m_at_the_menu_for_inputting_contestant() {
	}

	@When("I enter the contestants name, {string}")
	public void i_enter_the_contestant_name(String input) {
		inputName = input;
		competitor = new Competitor(inputName);
	}

	@Then("the name is saved for later use")
	public void the_name_is_saved_for_later_use() {
		assertEquals(inputName, competitor.getName());
	}

	// PointCalculator Feature
	@When("the {double} is entered")
	public void the_is_entered(double perf) {
		performance = perf;
	}

	@Then("the {int} is calculated and returned")
	public void the_result_is_outputted(int result) {
		assertEquals(result, calc.OneHundredMeters(performance));
	}

}
