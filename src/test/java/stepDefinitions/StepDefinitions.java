package stepDefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sprint1.ScoreCalculator;

public class StepDefinitions {

	private double performance;
	private ScoreCalculator calc = new ScoreCalculator();

	@When("the {double} is entered")
	public void the_is_entered(double perf) {
		performance = perf;
	}

	@Then("the {int} is calculated and outputted")
	public void the_result_is_outputted(int result) {
		assertEquals(result, calc.OneHundredMeters(performance));
	}

}
