package auto.septech.scenariosteps;

import auto.septech.steps.EndUserBaseSteps;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DBSteps {
	@Steps
	EndUserBaseSteps endUser;
	@When("^store the result of query database \"([^\"]*)\" in variable \"([^\"]*)\"$")
	public void store_number_of_result_of_query(String query, String var){
		endUser.store_number_of_result_of_query(query, var);
	}
}
