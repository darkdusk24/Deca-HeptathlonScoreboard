package stepDefinitions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import sprint1.Contestant;
import sprint1.ContestantSportEvent;
import sprint1.ScoreCalculator;

public class DecaHeptaPointcalcSteps {

	private String inputName;
	private String countryCode;
	private int number;
	private Contestant competitor;

	private String combinedEvent;
	private String event;
	private double result;
	private ScoreCalculator calc = new ScoreCalculator();
	private List<ContestantSportEvent> events = new ArrayList<>();
	private static String[] decathlon = { "100 m", "Long jump", "Shot put", "High jump", "400 m", "110 m hurdles",
			"Discus throw", "Pole vault", "Javelin throw", "1500 m" };
	private static String[] heptathlon = { "100 m hurdles", "High jump", "Shot put", "200 m", "Long jump",
			"Javelin throw", "800 m" };
	private List<Double> results = new ArrayList<>();

	// HeptaDeca Feature
	@Given("I am at the menu for inputting a contestant")
	public void i_m_at_the_menu_for_inputting_contestant() {
	}

	@When("I enter the contestants {string}")
	public void i_enter_the_contestants(String name) {
		inputName = name;
	}

	@When("I enter the contestants countrys alpha3 {string}")
	public void i_enter_the_contestants_countrys_alpha3(String country) {
		countryCode = country;
	}

	@When("I enter the contestants {int}")
	public void i_enter_the_contestants(int number) {
		this.number = number;
	}

	@Then("the name is saved for later use")
	public void the_name_is_saved_for_later_use() {
		competitor = new Contestant(inputName, number, countryCode);
		assertEquals(inputName, competitor.getName());
		assertEquals(countryCode, competitor.getCountry());
		assertEquals(number, competitor.getNumber());
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
		assertEquals(score, calc.eventScoreCalculation(combinedEvent, event, result));
	}

	@Given("the contestants results are [{double}, {double}, {double}, {double}, {double}, {double}, {double}, {double}, {double}, {double}]")
	public void the_contestants_results_are(double double1, double double2, double double3, double double4,
			double double5, double double6, double double7, double double8, double double9, double double10) {
		results.add(double1);
		results.add(double2);
		results.add(double3);
		results.add(double4);
		results.add(double5);
		results.add(double6);
		results.add(double7);
		results.add(double8);
		results.add(double9);
		results.add(double10);

		for (int i = 0; i < results.size(); i++) {
			events.add(new ContestantSportEvent(decathlon[i], results.get(i),
					calc.eventScoreCalculation(combinedEvent, decathlon[i], results.get(i))));
		}
	}

	@Given("the contestants results are [{double}, {double}, {double}, {double}, {double}, {double}, {double}]")
	public void the_contestants_results_are(Double double1, Double double2, Double double3, Double double4,
			Double double5, Double double6, Double double7) {
		results.add(double1);
		results.add(double2);
		results.add(double3);
		results.add(double4);
		results.add(double5);
		results.add(double6);
		results.add(double7);

		for (int i = 0; i < results.size(); i++) {
			events.add(new ContestantSportEvent(heptathlon[i], results.get(i),
					calc.eventScoreCalculation(combinedEvent, heptathlon[i], results.get(i))));
		}
	}

	@Then("the {int} is calculated and it is returned")
	public void the_is_calculated_and_it_is_returned(int totalScore) {
		assertEquals(totalScore, calc.totalScoreCalculation(events));
	}

}
