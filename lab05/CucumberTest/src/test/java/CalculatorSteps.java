import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {
    private Calculator calculator;

    @Given("^a calculator I just turned on$")
    public void setup() {
        calculator = new Calculator();
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void add(int arg1, int arg2) {
        calculator.push(arg1);
        calculator.push(arg2);
        calculator.push("+");
    }

    @When("^I subtract (\\d+) to (\\d+)$")
    public void subtract(int arg1, int arg2) {
        calculator.push(arg1);
        calculator.push(arg2);
        calculator.push("-");
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expected) {
        assertEquals(expected, calculator.value());
    }
}
