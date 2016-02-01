package auto.septech.scenariosteps;

import auto.septech.steps.DialogAndAlertBaseSteps;
import auto.septech.steps.EndUserBaseSteps;
import auto.septech.steps.FileActionBaseSteps;
import auto.septech.steps.CoreActionFormBaseSteps;
import auto.septech.steps.VerificationBaseSteps;
import auto.septech.steps.WindowAndFrameBaseSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
public class OtherBaseSteps {
	@Steps
	EndUserBaseSteps endUser;
	
	@Steps
	DialogAndAlertBaseSteps dialogAndAlertSteps;
	
	@Steps
	FileActionBaseSteps fileActionSteps;
	
	@Steps
	CoreActionFormBaseSteps mainActionFormSteps;
	
	@Steps
	VerificationBaseSteps verificationSteps;
	
	@Steps
	WindowAndFrameBaseSteps windowsAndFramesSteps;
	
    @Given("open the home page")
    public void open_the_home_page() {
        endUser.open_the_home_page();
    }
	
	@When("^wait for (\\d+) seconds$")
	public void wait_for_seconds(int time) throws Throwable {
	   Thread.sleep(time*1000);
	}
	
	@When("^store the result of jquery \"([^\"]*)\" in variable \"([^\"]*)\"$")
	public void store_the_result_of_jquery(String jquery, String var){
		endUser.store_result_of_jquery(jquery.replace("@", "\""), var);
	}
	
	@When("^store the sub text of variable \"(.*?)\" from index (\\d+) to index (\\d+) in \"(.*?)\" variable$")
	public void store_the_sub_text_of_variable_by_index_in_variable(String srcvar, Integer beginStr, Integer endStr, String desvar) {
		endUser.store_the_sub_text_of_variable_by_index_in_variable(srcvar, beginStr,  endStr, desvar);
	}	
	
	@When("^store the result of minus between variable \"([^\"]*)\" and variable \"([^\"]*)\" in variable \"([^\"]*)\"$")
	public void store_the_result_of_minus_between_variable(String var1, String var2, String varResult){
		endUser.store_the_result_of_minus_between_variable(var1, var2,varResult);
	}
	
	@When("^store the value of attribute \"(.*?)\" of element \"(.*?)\" in \"(.*?)\" variable$")
	public void store_the_value_of_attribute_in_variable(String attr, String element, String var){
		endUser.store_the_value_of_attribute_in_variable(attr,element, var);
	}
	
	@When("^store the text \"(.*?)\" in \"(.*?)\" variable$")
	public void store_text_value_in_variable(String text, String var){
		endUser.store_text_value_in_variable(text, var);
	}
	
	@When("^store the number in text of element \"(.*?)\" in \"(.*?)\" variable$")
	public void store_the_number_in_text_of_element_in_variable(String element, String var) {
		endUser.store_number_in_text_of_element_in_variable(element,var);
	}
	
	@When("^store the number in value of element \"(.*?)\" in \"(.*?)\" variable$")
	public void store_the_number_in_value_of_element_in_variable(String element, String var) {
		endUser.store_number_in_value_of_element_in_variable(element,var);
	}
	
	@When("^store the number in value of variable \"(.*?)\" in \"(.*?)\" variable$")
	public void store_the_number_in_value_of_variable_in_variable(String srcvar, String desvar) {
		endUser.store_number_in_value_of_variable_in_variable(srcvar,desvar);
	}
	
	@When("^store the number in string \"(.*?)\" in \"(.*?)\" variable$")
	public void store_the_number_in_string_in_variable(String element, String var) {
		endUser.store_number_in_string_in_variable(element,var);
	}
	
	@When("^store the number of element \"(.*?)\" in \"(.*?)\" variable$")
	public void store_the_number_of_element_in_variable(String element, String var) {
		endUser.store_number_of_element_in_variable(element,var);
	}
	
    @When("^store the text of \"(.*?)\" element in \"(.*?)\" variable$")
    public void store_the_text_of_element_in_variable(String element, String var) throws Throwable {
    	endUser.store_the_text_of_element_in_variable(element,var);
    }
    
	@When("^wait for the \"([^\"]*)\" element to be clickable$")
	public void wait_for_the_element_to_be_clickable(String element) throws Throwable {
		endUser.wait_for_the_element_to_be_clickable(element);
	}
	
	@When("^wait for the \"([^\"]*)\" element to be visibile$")
	public void wait_for_the_element_to_be_visibile(String element) throws Throwable {
		endUser.wait_for_the_element_to_be_visibile(element);
	}
	
	@When("^wait for any \"([^\"]*)\" text to be present$")
	public void wait_for_any_text_to_be_present(String textValue) throws Throwable {
		endUser.wait_for_any_text_to_be_present(textValue);
	}
	
	@When("^wait for any \"([^\"]*)\" text to be disappread$")
	public void wait_for_any_text_to_be_disappread(String textValue) throws Throwable {
		endUser.wait_for_any_text_to_be_disappread(textValue);
	}
	
	@When("^capture an exact image of \"([^\"]*)\" element on the screen and save it in \"([^\"]*)\"$")
	public void capture_an_exact_image_of_element_on_the_screen_and_save_it_in(String element, String pathStorge) throws Throwable {
		endUser.capture_and_save_it(element,pathStorge);
	}
	
	@When("^change \"([^\"]*)\" attribute of \"([^\"]*)\" into \"([^\"]*)\"$")
	public void change_attribute_of_into(String attr, String element, String attrValue) throws Throwable {
		endUser.change_attribute_of_element(attr,element,attrValue);
	}

	@When("^highlight \"([^\"]*)\" element$")
	public void highlight_element(String element) throws Throwable {
		endUser.highlight_element(element);
	}

	@When("^set bound for \"([^\"]*)\" element$")
	public void set_bound_for_element(String element) throws Throwable {
		endUser.set_bound_for_element(element);
	}

}
