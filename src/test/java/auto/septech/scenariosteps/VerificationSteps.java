package auto.septech.scenariosteps;

import auto.septech.steps.DialogAndAlertBaseSteps;
import auto.septech.steps.EndUserBaseSteps;
import auto.septech.steps.FileActionBaseSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import auto.septech.steps.CoreActionFormBaseSteps;
import auto.septech.steps.VerificationBaseSteps;
import auto.septech.steps.WindowAndFrameBaseSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class VerificationSteps {
	protected static String actualImage = System.getProperty("user.dir")+ "\\images\\";
	protected static String tmpImage = System.getProperty("user.dir")+ "\\target\\";
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

	@Then("^the text of \"([^\"]*)\" element should contain variable \"([^\"]*)\"$")
	public void the_text_of_field_should_contain_variable(String element, String var) throws Throwable {
		verificationSteps.the_text_of_field_should_contain_variable(element,var);
	}

	@Then("^the text of \"([^\"]*)\" element should not contain variable \"([^\"]*)\"$")
	public void the_text_of_field_should_not_contain_variable(String element, String var) throws Throwable {
		verificationSteps.the_text_of_field_should_not_contain_variable(element,var);
	}

	@Then("^the text of \"([^\"]*)\" element should not be variable \"([^\"]*)\"$")
	public void the_text_element_should_not_be_variable(String element, String var) throws Throwable {
		verificationSteps.the_text_of_field_should_not_be_variable(element,var);
	}

	@Then("^the text of \"([^\"]*)\" element should be variable \"([^\"]*)\"$")
	public void the_text_element_should_be_variable(String element, String var) throws Throwable {
		verificationSteps.the_text_of_field_should_be_variable(element,var);
	}

	@Then("^the text of \"(.*?)\" element should be \"(.*?)\"$")
	public void the_text_element_should_be(String target, String value) throws Throwable {
		verificationSteps.the_text_element_should_be(target,value);
	}

	@Then("^the text of \"(.*?)\" element should not be \"(.*?)\"$")
	public void the_text_element_should_not_be(String target, String value) throws Throwable {
		verificationSteps.the_text_element_should_not_be(target,value);
	}

	@Then("^the text of \"(.*?)\" element should contain \"(.*?)\"$")
	public void the_text_element_should_contain(String target, String value) throws Throwable {
		verificationSteps.the_text_element_should_contain(target,value);
	}

	@Then("^the text of \"(.*?)\" element should not contain \"(.*?)\"$")
	public void the_text_element_should_not_contain(String target, String value) throws Throwable {
		verificationSteps.the_text_element_should_not_contain(target,value);
	}

	@Then("^the variable \"(.*?)\" should be \"(.*?)\"$")
	public void variable_should_be(String var, String valueCompare) throws Throwable {
		verificationSteps.variable_should_be(var,valueCompare);
	}

	@Then("^the page should contain \"(.*?)\"$")
	public void the_page_should_contain(String value) throws Throwable {
		verificationSteps.the_page_should_contain(value);
	}

	@Then("^the page should not contain \"(.*?)\"$")
	public void the_page_should_not_contain(String value) throws Throwable {
		verificationSteps.the_page_should_not_contain(value);
	}
	
	@Then("^the \"(.*?)\" attribute of \"(.*?)\" should contain variable \"(.*?)\"$")
	public void the_attribute_of_element_should_contain_variable(String attribute, String element, String var) throws Throwable {
		verificationSteps.the_attribute_of_element_should_contain_variable(attribute,element,var);
	}

	@Then("^the \"(.*?)\" attribute of \"(.*?)\" should be variable \"(.*?)\"$")
	public void the_attribute_of_element_should_be_variable(String attribute, String element, String var) throws Throwable {
		verificationSteps.the_attribute_of_element_should_be_variable(attribute,element,var);
	}

	@Then("^the \"([^\"]*)\" attribute of  \"([^\"]*)\" should not contain variable \"([^\"]*)\"$")
	public void the_attribute_of_element_should_not_contain_variable(String attribute, String element, String var) throws Throwable {
		verificationSteps.the_attribute_of_element_should_not_contain_variable(attribute,element,var);
	}

	@Then("^the \"(.*?)\" attribute of \"(.*?)\" should not be variable \"(.*?)\"$")
	public void the_attribute_of_element_should_not_be_variable(String attribute, String element, String var) throws Throwable {
		verificationSteps.the_attribute_of_element_should_not_be_variable(attribute,element,var);
	}

	@Then("^the \"(.*?)\" attribute of \"(.*?)\" should contain \"(.*?)\"$")
	public void the_attribute_of_element_should_contain(String attribute, String element, String value) throws Throwable {
		verificationSteps.the_attribute_of_element_should_contain(attribute,element,value);
	}

	@Then("^the \"(.*?)\" attribute of \"(.*?)\" should be \"(.*?)\"$")
	public void the_attribute_of_element_should_be(String attribute, String element, String value) throws Throwable {
		verificationSteps.the_attribute_of_element_should_be(attribute,element,value);
	}

	@Then("^the \"([^\"]*)\" attribute of  \"([^\"]*)\" should not contain \"([^\"]*)\"$")
	public void the_attribute_of_element_should_not_contain(String attribute, String element, String value) throws Throwable {
		verificationSteps.the_attribute_of_element_should_not_contain(attribute,element,value);
	}

	@Then("^the \"(.*?)\" attribute of \"(.*?)\" should not be \"(.*?)\"$")
	public void the_attribute_of_element_should_not_be(String attribute, String element, String value) throws Throwable {
		verificationSteps.the_attribute_of_element_should_not_be(attribute,element,value);
	}

	@Then("^the \"(.*?)\" element should be enabled$")
	public void the_element_should_be_enabled(String element) throws Throwable {
		verificationSteps.the_element_should_be_enabled(element);
	}

	@Then("^the \"(.*?)\" element should be disabled$")
	public void the_element_should_be_disabled(String element) throws Throwable {
		verificationSteps.the_element_should_be_disabled(element);
	}

	@Then("^the \"(.*?)\" element should be present$")
	public void the_element_should_be_present(String element) throws Throwable {
		verificationSteps.the_element_should_be_present(element);
	}

	@Then("^the \"(.*?)\" element should not be present$")
	public void the_element_should_not_be_present(String element) throws Throwable {
		verificationSteps.the_element_should_not_be_present(element);
	}

	@Then("^the \"(.*?)\" element should be visible$")
	public void the_element_should_be_visible(String element) throws Throwable {
		verificationSteps.the_element_should_be_visible(element);
	}

	@Then("^the \"(.*?)\" element should be hidden$")
	public void the_element_should_be_hidden(String element) throws Throwable {
		verificationSteps.the_element_should_be_hidden(element);
	}

	@Then("^the \"(.*?)\" option label in \"(.*?)\" should be selected$")
	public void the_option_label_in_should_be_selected(String visibleText, String element) throws Throwable {
		verificationSteps.the_option_label_in_should_be_selected(visibleText,element);
	}

	@Then("^the \"(.*?)\" option label in \"(.*?)\" should not be selected$")
	public void the_option_label_in_should_not_be_selected(String visibleText, String element) throws Throwable {
		verificationSteps.the_option_label_in_should_not_be_selected(visibleText,element);
	}

	@Then("^the value of \"([^\"]*)\" element should be \"([^\"]*)\"$")
	public void the_value_of_field_should_be(String element, String value) throws Throwable {
		verificationSteps.the_value_of_field_should_be(element,value);
	}

	@Then("^the value of \"([^\"]*)\" element should not be \"([^\"]*)\"$")
	public void the_value_of_field_should_not_be(String element, String value) throws Throwable {
		verificationSteps.the_value_of_field_should_not_be(element,value);
	}

	@Then("^the value of \"([^\"]*)\" element should contain \"([^\"]*)\"$")
	public void the_value_of_field_should_contain(String element, String value) throws Throwable {
		verificationSteps.the_value_of_field_should_contain(element,value);
	}

	@Then("^the value of \"([^\"]*)\" element should not contain \"([^\"]*)\"$")
	public void the_value_of_field_should_not_contain(String element, String value) throws Throwable {
		verificationSteps.the_value_of_field_should_not_contain(element,value);
	}

	@Then("^the value of \"([^\"]*)\" element should contain variable \"([^\"]*)\"$")
	public void the_value_of_field_should_contain_variable(String element, String var) throws Throwable {
		verificationSteps.the_value_of_field_should_contain_variable(element,var);
	}

	@Then("^the value of \"([^\"]*)\" element should not contain variable \"([^\"]*)\"$")
	public void the_value_of_field_should_not_contain_variable(String element, String var) throws Throwable {
		verificationSteps.the_value_of_field_should_not_contain_variable(element,var);
	}

	@Then("^the value of \"([^\"]*)\" element should not be variable \"([^\"]*)\"$")
	public void the_value_element_should_not_be_variable(String element, String var) throws Throwable {
		verificationSteps.the_value_of_field_should_not_be_variable(element,var);
	}

	@Then("^the value of \"([^\"]*)\" element should be variable \"([^\"]*)\"$")
	public void the_value_element_should_be_variable(String element, String var) throws Throwable {
		verificationSteps.the_value_of_field_should_be_variable(element,var);
	}
	
	@Then("^the page title should contain \"([^\"]*)\"$")
	public void the_page_title_should_contain(String pageTitle) throws Throwable {
		verificationSteps.the_page_title_should_contain(pageTitle);
	}

	@Then("^the page title should not contain \"([^\"]*)\"$")
	public void the_page_title_should_not_contain(String pageTitle) throws Throwable {
		verificationSteps.the_page_title_should_not_contain(pageTitle);
	}


	@Then("^the page title should be \"([^\"]*)\"$")
	public void the_page_title_should_be(String pageTitle) throws Throwable {
		verificationSteps.the_page_title_should_be(pageTitle);
	}

	@Then("^the page title should not be \"([^\"]*)\"$")
	public void the_page_title_should_not_be(String pageTitle) throws Throwable {
		verificationSteps.the_page_title_should_not_be(pageTitle);
	}

	@Then("^the absolute URL of the current page should be \"([^\"]*)\"$")
	public void the_absolute_URL_of_the_current_page_should_be(String url) throws Throwable {
		verificationSteps.the_absolute_URL_of_the_current_page_should_be(url);
	}

	@Then("^actual \"([^\"]*)\" image and expected \"([^\"]*)\" image should be similar$")
	public void actual_image_and_expected_image_should_be_similar(String actualImge,String expectImg) throws Throwable {
		String expect = tmpImage + expectImg;
		String actual = actualImage + actualImge;
		verificationSteps.actual_image_and_expected_image_should_be_similar(expect, actual);
	}

	@When("^capture an exact image of \"([^\"]*)\" element on the screen and save as \"([^\"]*)\"$")
	public void capture_an_exact_image_of_element_on_the_screen_and_save_as(String element, String nameImg) throws Throwable {
		String pathStorge = tmpImage + nameImg;;
		endUser.capture_and_save_it(element,pathStorge);
	}
	
	@Then("^the variable \"([^\"]*)\" should be variable \"([^\"]*)\"$")
	public void the_variable_should_be_variable(String var1, String var2) throws Throwable {
		verificationSteps.the_variable1_equal_variable2(var1,var2);
	}
	
	@Then("^the variable \"([^\"]*)\" should not be variable \"([^\"]*)\"$")
	public void the_variable_should_not_be_variable(String var1, String var2) throws Throwable {
		verificationSteps.the_variable1_not_equal_variable2(var1,var2);
	}
	
	@Then("^the variable \"([^\"]*)\" should contain variable \"([^\"]*)\"$")
	public void the_variable_should_contain_variable(String var1, String var2) throws Throwable {
		verificationSteps.the_variable1_contain_variable2(var1,var2);
	}
	
	@Then("^the variable \"([^\"]*)\" should not contain variable \"([^\"]*)\"$")
	public void the_variable_should_not_contain_variable(String var1, String var2) throws Throwable {
		verificationSteps.the_variable1_not_contain_variable2(var1,var2);
	}
	
	@Then("^the number of \"([^\"]*)\" element should be (\\d+)$")
	public void the_number_of_element_should_be(String element, int number) {
		Integer numberResult = endUser.get_number_of_element(element);
		assertThat(number,equalTo(numberResult));
	}
}
