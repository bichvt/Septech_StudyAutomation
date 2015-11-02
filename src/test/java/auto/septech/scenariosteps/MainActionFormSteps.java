package auto.septech.scenariosteps;

import auto.septech.steps.DialogAndAlertBaseSteps;
import auto.septech.steps.EndUserBaseSteps;
import auto.septech.steps.FileActionBaseSteps;
import auto.septech.steps.CoreActionFormBaseSteps;
import auto.septech.steps.VerificationBaseSteps;
import auto.septech.steps.WindowAndFrameBaseSteps;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MainActionFormSteps {
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
	
	@When("^enter into the \"([^\"]*)\" field with value of variable \"([^\"]*)\"$")
	public void enter_into_the_field_with_variable(String target, String var) throws Throwable {
		mainActionFormSteps.enter_into_the_field_with_variable(target,var);
	}

	@When("^enter into the \"([^\"]*)\" field with value \"([^\"]*)\"$")
	public void enter_into_the_field_with(String target, String value) throws Throwable {
		mainActionFormSteps.enter_into_the_field_with_value(target,value);
	}
	
    @When("^enter into the \"([^\"]*)\" field with value \"([^\"]*)\" and store into variable \"([^\"]*)\"$")
	public void enter_into_the_field_with_and_store_into_variable(String target, String value,String var) throws Throwable {
    	mainActionFormSteps.enter_into_the_field_with_value_and_store_variable(target,value,var);
	}

	@When("^enter into \"([^\"]*)\" field with random value that its length is (\\d+)$")
	public void enter_random_into_the_field_with_length(String element, int length) throws Throwable {
		mainActionFormSteps.enter_random_into_the_field_with_length(element,length);
	}

	@When("^enter into the editor \"([^\"]*)\" field with value \"([^\"]*)\"$")
	public void enter_into_the_editor_field_with_variable(String target, String var) throws Throwable {
		mainActionFormSteps.enter_into_the_editor(target,var);
	}
	
	@When("^enter into the editor \"([^\"]*)\" field with value \"([^\"]*)\" and store into variable \"([^\"]*)\"$")
	public void enter_into_the_editor_field_with_variable_and_store_into_variable(String target, String value,String var) throws Throwable {
		mainActionFormSteps.enter_into_the_editor_and_store_into_variable(target,value,var);
	}

	@When("^press enter key$")
	public void press_enter_key() throws Throwable {
		mainActionFormSteps.press_enter_key();
	}

	@When("^click on the \"([^\"]*)\"$")
	public void click_on_the(String target) throws Throwable {
		mainActionFormSteps.click_on_the_element(target);
	}

	@When("^click and hold the \"([^\"]*)\"$")
	public void click_and_hold(String element) throws Throwable {
		mainActionFormSteps.click_and_hold(element);
	}

	@When("^double-click on the \"([^\"]*)\"$")
	public void double_click_on_the(String element) throws Throwable {
		mainActionFormSteps.double_click_on_the(element);
	}
	
	@When("^right click on the \"([^\"]*)\"$")
	public void right_click_on_the(String element) throws Throwable {
		mainActionFormSteps.right_click_on_the(element);
	}
	
	@When("^right click on the \"([^\"]*)\" and click on item has index is (\\d+)$")
	public void right_click_on_the_and_click_on_item_has_index_is(String element, int indexItem) throws Throwable {
		mainActionFormSteps.right_click_on_the_and_click_on_item_has_index(element,indexItem);
	}
	
	@When("^click on the \"([^\"]*)\" at coordinates (\\d+) and (\\d+)$")
	public void click_on_the_at_coordinates(String element, int xOffset, int yOffset) throws Throwable {
		mainActionFormSteps.click_on_the_at_coordinates(element,xOffset,yOffset);
	}

	@When("^double-click on the \"([^\"]*)\" at coordinates (\\d+) and (\\d+)$")
	public void double_click_on_the_at_coordinates_and(String element, int xOffset, int yOffset) throws Throwable {
		mainActionFormSteps.double_click_on_the_at_coordinates(element,xOffset,yOffset);
	}

	@When("^right click on the \"([^\"]*)\" at coordinates (\\d+) and (\\d+)$")
	public void right_click_on_the_at_coordinates_and(String element, int xOffset, int yOffset) throws Throwable {
		mainActionFormSteps.right_click_on_the_at_coordinates(element, xOffset, yOffset);
	}

	@When("^right click the \"([^\"]*)\" at coordinates (\\d+) and (\\d+) and click on item has index is (\\d+)$")
	public void right_click_the_at_coordinates_and_and_click_on_item_has_index_is(String element, int xOffset, int yOffset, int indexItem) throws Throwable {
		mainActionFormSteps.right_click_the_at_coordinates_and_and_click_on_item_has_index(element,xOffset,yOffset,indexItem);
	}

	@When("^check on the \"([^\"]*)\"$")
	public void check_checkbox(String element){
		mainActionFormSteps.check_checkbox(element);
	}
	
	@When("^uncheck on the \"([^\"]*)\"$")
	public void uncheck_checkbox(String element){
		mainActionFormSteps.uncheck_checkbox(element);
	}
	
	@When("^select the label \"([^\"]*)\" from  the drop down \"([^\"]*)\"$")
	public void select_label_from_drop_down_list(String visibleLabel, String element) throws Throwable {
		mainActionFormSteps.select_label_from_drop_down_list(visibleLabel,element);
	}

	@When("^select the value \"([^\"]*)\" from the drop down \"([^\"]*)\"$")
	public void select_value_from_drop_down_list(String valueOption, String element) throws Throwable {
		mainActionFormSteps.select_value_from_drop_down_list(valueOption,element);
	}

	@When("^select the index (\\d+) from the drop down \"([^\"]*)\"$")
	public void select_index_from_drop_down_list(int indexOption, String element) throws Throwable {
		mainActionFormSteps.select_index_from_drop_down_list(indexOption,element);
	}

	@When("^select the multi options \"([^\"]*)\" from the drop down \"([^\"]*)\"$")
	public void add_multi_select_options_from_drop_down_list(String listOption, String element) throws Throwable {
		mainActionFormSteps.select_multi_select_options_from_drop_down_list(listOption,element);
	}

	@When("^drag the \"([^\"]*)\" and drop to the \"([^\"]*)\"$")
	public void drag_the_and_drop_to_the(String resouce, String dest) throws Throwable {
		mainActionFormSteps.drag_the_and_drop_to_the(resouce,dest);
	}

	@When("^html5 - drag the \"([^\"]*)\" and drop to the \"([^\"]*)\"$")
	public void html5_drag_the_and_drop_to_the(String resouce, String dest) throws Throwable {
		mainActionFormSteps.html5_drag_the_and_drop_to_the(resouce,dest);
	}

	@When("^move mouse to \"([^\"]*)\"$")
	public void move_mouse_to(String element) throws Throwable {
		mainActionFormSteps.move_mouse_to(element);
	}

	@When("^move mouse to \"([^\"]*)\" at coordinates (\\d+) and (\\d+)$")
	public void move_mouse_to_at_coordinates_and(String element, int xOffset, int yOffset) throws Throwable {
		mainActionFormSteps.move_mouse_to_at_coordinates(element,xOffset,yOffset);
	}
}
