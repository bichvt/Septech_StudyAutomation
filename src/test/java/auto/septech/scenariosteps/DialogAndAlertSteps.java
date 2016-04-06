package auto.septech.scenariosteps;

import auto.septech.steps.DialogAndAlertBaseSteps;
import auto.septech.steps.EndUserBaseSteps;
import auto.septech.steps.FileActionBaseSteps;
import auto.septech.steps.CoreActionFormBaseSteps;
import auto.septech.steps.VerificationBaseSteps;
import auto.septech.steps.WindowAndFrameBaseSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DialogAndAlertSteps {
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
	
	@When("^alert popup should be message \"(.*?)\" then accept alert$")
	public void accept_alert(String msg) throws Throwable {
		dialogAndAlertSteps.verify_alert_message_then_accept_alert(msg);
	}
	
	@When("^alert popup should be message \"(.*?)\" then dismiss alert$")
	public void dismiss_alert(String msg) throws Throwable {
		dialogAndAlertSteps.verify_alert_message_then_dismiss_alert(msg);
	}
	
	@When("^click on the element \"(.*?)\" and accept the alert popup$")
	public void accept_the_currently_displayed_dialog(String element) throws Throwable {
		dialogAndAlertSteps.accept_alert(element);
	}
	
	@When("^click on the element \"(.*?)\" and dismiss the alert popup$")
	public void dismiss_the_currently_displayed_dialog(String element) throws Throwable {
		dialogAndAlertSteps.dismiss_alert(element);
	}
	
	@When("^click on the element \"(.*?)\" and enter text \"(.*?)\" to alert popup$")
	public void enter_text_to_alert(String element, String value) throws Throwable {
		dialogAndAlertSteps.enter_text_to_alert(element,value);
	}
	
	@When("^click on the element \"([^\"]*)\" to open pop-up window and switch to it$")
	public void click_on_the_to_open_pop_up_window_and_switch_to_it(String element) throws Throwable {
		windowsAndFramesSteps.click_on_the_to_open_pop_up_window_and_switch_to_it(element);
	}
	
	@Then("^click on the element \"(.*?)\" and alert popup should be message \"(.*?)\" then accept alert$")
	public void verify_aleart_msg_should_be_then_accept(String element, String msg) throws Throwable {
		dialogAndAlertSteps.verify_alert_message_be_text_then_accept_alert(element,msg);
	}
	
	@Then("^click on the element \"(.*?)\" and alert popup should be message \"(.*?)\" then dismiss alert$")
	public void verify_aleart_msg_should_be_then_dismiss(String element, String msg) throws Throwable {
		dialogAndAlertSteps.verify_alert_message_be_text_then_dismiss_alert(element,msg);
	}
	
	@Then("^click on the element \"(.*?)\" and alert popup should contain message \"(.*?)\" then accept alert$")
	public void verify_aleart_msg_should_contain_then_accept(String element, String msg) throws Throwable {
		dialogAndAlertSteps.verify_alert_message_contain_text_then_accept_alert(element,msg);
	}
	
	@Then("^click on the element \"(.*?)\" and alert popup should contain message \"(.*?)\" then dismiss alert$")
	public void verify_aleart_msg_should_contain_then_dismiss(String element, String msg) throws Throwable {
		dialogAndAlertSteps.verify_alert_message_contain_text_then_dismiss_alert(element,msg);
	}
}
