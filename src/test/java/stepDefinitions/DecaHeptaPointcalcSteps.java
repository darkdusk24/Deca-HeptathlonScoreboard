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
	private int[] scoreboard = new int[10];

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

	@Given("the contestants scores are [{int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}]")
	public void the_contestants_scores_are(int int1, int int2, int int3, int int4, int int5,
			int int6, int int7, int int8, int int9, int int10) {
		scoreboard[0] = int1;
		scoreboard[1] = int2;
		scoreboard[2] = int3;
		scoreboard[3] = int4;
		scoreboard[4] = int5;
		scoreboard[5] = int6;
		scoreboard[6] = int7;
		scoreboard[7] = int8;
		scoreboard[8] = int9;
		scoreboard[9] = int10;
	}

	@Then("the {int} is calculated and it is returned")
	public void the_is_calculated_and_it_is_returned(int totalScore) {
		assertEquals(totalScore, calc.totalScore(scoreboard));
	}

}
