package stepDefinitions;

import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import sprint1.Contestant;
import sprint1.ScoreCalculator;

public class DecaHeptaPointcalcSteps {

	private String inputName;
	private Contestant competitor;

	private String combinedEvent;
	private String event;
	private double result;
	private ScoreCalculator calc = new ScoreCalculator();

	// HeptaDeca Feature
	@Given("I am at the menu for inputting a contestant")
	public void i_m_at_the_menu_for_inputting_contestant() {
	}

	@When("I enter the contestants name, {string}")
	public void i_enter_the_contestant_name(String input) {
		inputName = input;
		competitor = new Contestant(inputName);
	}

	@Then("the name is saved for later use")
	public void the_name_is_saved_for_later_use() {
		assertEquals(inputName, competitor.getName());
	}

	// PointCalculator Feature
	@Given("the main event is a {string}")
	public void the_main_event_is_a(String mainEvent) {
		combinedEvent = mainEvent;
	}
	
	@Given("the event is {string}")
	public void the_event_is(String contest) {
		event = contest;
	}

	@When("the {double} is entered")
	public void the_is_entered(double perf) {
		result = perf;
	}

	@Then("the {int} is calculated and returned")
	public void the_result_is_outputted(int score) {
		assertEquals(score, calc.eventScore(combinedEvent, event, result));
	}

}
