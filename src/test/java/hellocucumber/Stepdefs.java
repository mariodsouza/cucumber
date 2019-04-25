package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

//public class Stepdefs {
//	
//	@Given("^today is Sunday$")
//public void today_is_Sunday() throws Exception {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//}
//
//@When("^I ask whether it's Friday yet$")
//public void i_ask_whether_it_s_Friday_yet() throws Exception {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//}
//
//@Then("^I should be told \"([^\"]*)\"$")
//public void i_should_be_told(String arg1) throws Exception {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//}
//	
//}

class IsItFriday {
    static String isItFriday(String today) {
    	if (today.equals("Friday")) {
            return "TGIF";
        }
		if (today.equals("Tuesday")) {
            return "No, its Tuesday";
        }
        return "Nope";
    }
}

public class Stepdefs {
    private String today;
    private String actualAnswer;
    
    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String today) {
        this.today = today;
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_is_s_Friday_yet() {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}