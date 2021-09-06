package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import sprint1.PasswordHandler;

import static org.junit.Assert.assertEquals;

public class DecaHeptaPasswordSteps {

    private String password;
    private String output;
    private PasswordHandler pass = new PasswordHandler();

    @Given("I have entered the {string}")
    public void i_have_entered_the(String input) {
        password = input;
    }

    @Then("the correct {string} should happen")
    public void the_correct_should_happen(String response) {
        Boolean output = Boolean.valueOf(response);
        assertEquals(output, pass.passwordCheck(password));
    }

}
