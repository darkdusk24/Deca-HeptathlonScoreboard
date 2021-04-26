package stepDefinitions;

import static org.junit.Assert.*;

import decaHepta.Contestants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	private String inputName;
	private Contestants name;


	@Given("I'm at the menu for inputing contestants")
	public void i_m_at_the_menu_for_inputing_contestants() {
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter the contestants name, {string}")
	public void i_enter_the_contestants_name(String input) {
		inputName = input;
		name = new Contestants();
		name.setName(inputName);

	}

	@Then("the name is saved for later use")
	public void the_name_is_saved_for_later_use() {

		assertEquals(inputName, name.getName());
		System.out.println(name.getName());

	}

}