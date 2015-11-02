package auto.septech.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import auto.septech.coreactions.DialogAndAlert;
import auto.septech.coreactions.CoreActionForm;
import auto.septech.coreactions.ManageFileAction;
import auto.septech.coreactions.PageCore;
import auto.septech.coreactions.WindowsAndFrames;
import auto.septech.utilities.CompareGraph;
import auto.septech.utilities.TestLogger;
import net.thucydides.core.annotations.Step;

public class VerificationBaseSteps extends EndUserBaseSteps {
	/* 
	 */
	private static final long serialVersionUID = 1L;
	PageCore pageCore;
	DialogAndAlert dialogsAndAlert;
	CoreActionForm mainActionForm;
	ManageFileAction manageFileAction;
	WindowsAndFrames windowsAndFrames;
	@Step
	public void the_absolute_URL_of_the_current_page_should_be(String url) {
		assertThat(pageCore.getCurrentUrl(),equalTo(url));
	}

	@Step
	public void the_page_title_should_contain(String pageTitle) {
		assertThat(pageCore.getTitle(),containsString(pageCore.getActualValueFromObjectRepository(pageTitle)));
	}

	@Step
	public void the_page_title_should_not_contain(String pageTitle) {
		assertThat(pageCore.getTitle(),not(containsString(pageCore.getActualValueFromObjectRepository(pageTitle))));
	}

	@Step
	public void the_page_title_should_be(String pageTitle) {
		assertThat(pageCore.getTitle(),equalTo(pageCore.getActualValueFromObjectRepository(pageTitle)));
	}

	@Step
	public void the_page_title_should_not_be(String pageTitle) {
		assertThat(pageCore.getTitle(),not(equalTo(pageCore.getActualValueFromObjectRepository(pageTitle))));
	}

	@Step
	public void the_page_should_contain(String value) {
		assertThat(pageCore.containsText(pageCore.getActualValueFromObjectRepository(value)),is(true));
	}

	@Step
	public void the_page_should_not_contain(String value) {
		assertThat(pageCore.getDriver().getPageSource().contains(pageCore.getActualValueFromObjectRepository(value)),is(false));
	}
	
	@Step
	public void the_text_of_field_should_contain_variable(String element, String var) {
		TestLogger.info(listVar.get(var));
		assertThat(pageCore.getCurrentTextOfElement(element),containsString(listVar.get(var)));
	}

	@Step
	public void the_text_of_field_should_not_contain_variable(String element, String var) {
		TestLogger.info(listVar.get(var));
		assertThat(pageCore.getCurrentTextOfElement(element),not(containsString(listVar.get(var))));
	}

	@Step
	public void the_text_of_field_should_be_variable(String element, String var) {
		TestLogger.info(listVar.get(var));
		assertThat(pageCore.getCurrentTextOfElement(element),equalTo(listVar.get(var)));
	}

	@Step
	public void the_text_of_field_should_not_be_variable(String element, String var) {
		TestLogger.info(listVar.get(var));
		assertThat(pageCore.getCurrentTextOfElement(element),not(equalTo(listVar.get(var))));
	}

	@Step
	public void the_text_element_should_be(String element, String value) {
		pageCore.waitForTextToAppear(element,pageCore.getActualValueFromObjectRepository(value));
		assertThat(pageCore.getCurrentTextOfElement(element),equalTo(pageCore.getActualValueFromObjectRepository(value)));
	}

	@Step
	public void the_text_element_should_not_be(String element, String value) {
		assertThat(pageCore.getCurrentTextOfElement(element),not(equalTo(pageCore.getActualValueFromObjectRepository(value))));
	}

	@Step
	public void the_text_element_should_contain(String element, String value) {
		wait_for_any_text_to_be_appread(pageCore.getActualValueFromObjectRepository(value));
		assertThat(pageCore.getCurrentTextOfElement(element),containsString(pageCore.getActualValueFromObjectRepository(value)));
	}

	@Step
	public void the_text_element_should_not_contain(String element, String value) {
		//wait_for_any_text_to_be_disappread(pageCore.getActualValueFromObjectRepository(value));
		assertThat(pageCore.getCurrentTextOfElement(element),not(containsString(pageCore.getActualValueFromObjectRepository(value))));
	}

	@Step
	public void the_value_of_field_should_be(String element, String value) {
		assertThat(pageCore.getCurrentValueOfElement(element),equalTo(pageCore.getActualValueFromObjectRepository(value)));
	}

	@Step
	public void the_value_of_field_should_not_be(String element, String value) {
		assertThat(pageCore.getCurrentValueOfElement(element),not(equalTo(pageCore.getActualValueFromObjectRepository(value))));
	}

	@Step
	public void the_value_of_field_should_contain(String element, String value) {
		assertThat(pageCore.getCurrentValueOfElement(element),containsString(pageCore.getActualValueFromObjectRepository(value)));
	}

	@Step
	public void the_value_of_field_should_not_contain(String element, String value) {
		assertThat(pageCore.getCurrentValueOfElement(element),not(containsString(pageCore.getActualValueFromObjectRepository(value))));
	}

	@Step
	public void the_value_of_field_should_contain_variable(String element, String var) {
		TestLogger.info(listVar.get(var));
		assertThat(pageCore.getCurrentValueOfElement(element),containsString(listVar.get(var)));
	}

	@Step
	public void the_value_of_field_should_not_contain_variable(String element, String var) {
		TestLogger.info(listVar.get(var));
		assertThat(pageCore.getCurrentValueOfElement(element),not(containsString(listVar.get(var))));
	}

	@Step
	public void the_value_of_field_should_be_variable(String element, String var) {
		TestLogger.info(listVar.get(var));
		assertThat(pageCore.getCurrentValueOfElement(element),equalTo(listVar.get(var)));
	}

	@Step
	public void the_value_of_field_should_not_be_variable(String element, String var) {
		TestLogger.info(listVar.get(var));
		assertThat(pageCore.getCurrentValueOfElement(element),not(equalTo(listVar.get(var))));
	}
	
	@Step
	public void the_attribute_of_element_should_be_variable(String attrName, String element, String var) {
		assertThat(pageCore.getAttribute(attrName, element),equalTo(listVar.get(var)));
	}

	@Step
	public void the_attribute_of_element_should_not_be_variable(String attrName, String element, String var) {
		assertThat(pageCore.getAttribute(attrName, element),not(equalTo(listVar.get(var))));
	}

	@Step
	public void the_attribute_of_element_should_contain_variable(String attrName, String element, String var) {
		assertThat(pageCore.getAttribute(attrName, element),containsString(listVar.get(var)));
	}

	@Step
	public void the_attribute_of_element_should_not_contain_variable(String attrName, String element, String var) {
		assertThat(pageCore.getAttribute(attrName, element),not(containsString(listVar.get(var))));
	}
	
	@Step
	public void the_attribute_of_element_should_be(String attrName, String element, String value) {
		assertThat(pageCore.getAttribute(attrName, element),equalTo(pageCore.getActualValueFromObjectRepository(value)));
	}

	@Step
	public void the_attribute_of_element_should_not_be(String attrName, String element, String value) {
		assertThat(pageCore.getAttribute(attrName, element),not(equalTo(pageCore.getActualValueFromObjectRepository(value))));
	}

	@Step
	public void the_attribute_of_element_should_contain(String attrName, String element, String value) {
		assertThat(pageCore.getAttribute(attrName, element),containsString(pageCore.getActualValueFromObjectRepository(value)));
	}

	@Step
	public void the_attribute_of_element_should_not_contain(String attrName, String element, String value) {
		assertThat(pageCore.getAttribute(attrName, element),not(containsString(pageCore.getActualValueFromObjectRepository(value))));
	}

	@Step
	public void the_element_should_be_enabled(String element) {
		assertThat(pageCore.getEnableStatusOfElement(element),is(true));
	}

	@Step
	public void the_element_should_be_disabled(String element) {
		assertThat(pageCore.getEnableStatusOfElement(element),is(false));
	}

	@Step
	public void the_element_should_be_present(String element) {
		assertThat(pageCore.getPresentStatusOfElement(element),is(true));
	}

	@Step
	public void the_element_should_not_be_present(String element) {
		assertThat(pageCore.getPresentStatusOfElement(element),is(false));
	}

	@Step
	public void the_element_should_be_visible(String element) {
		assertThat(pageCore.getVisibleStatusOfElement(element),is(true));
	}

	@Step
	public void the_element_should_be_hidden(String element) {
		assertThat(pageCore.getVisibleStatusOfElement(element),is(false));
	}

    @Step
	public void the_option_label_in_should_be_selected(String visibleText, String element) {
    	assertThat(pageCore.getSelectedVisibleTextValue(element),equalTo(pageCore.getActualValueFromObjectRepository(visibleText)));
	}

    @Step
	public void the_option_label_in_should_not_be_selected(String visibleText, String element) {
    	assertThat(pageCore.getSelectedVisibleTextValue(element),not(equalTo(pageCore.getActualValueFromObjectRepository(visibleText))));
	}
    
    @Step
	public void actual_image_and_expected_image_should_be_similar(String expectImg, String actualImge) {
    	assertThat(CompareGraph.Result.Matched,equalTo(CompareGraph.CompareImage(expectImg,actualImge)));
	}
    
    @Step
	public void variable_should_be(String var, String valueCompare) {
    	assertThat(listVar.get(var),equalTo(valueCompare));
	}
    
	@Step
	public void the_variable1_equal_variable2(String var1, String var2) {
		assertThat(listVar.get(var1),equalTo(listVar.get(var2)));
	}
	
	@Step
	public void the_variable1_not_equal_variable2(String var1, String var2) {
		assertThat(listVar.get(var1),not(equalTo(listVar.get(var2))));
	}
	
	@Step
	public void the_variable1_contain_variable2(String var1, String var2) {
		assertThat(listVar.get(var1),containsString(listVar.get(var2)));
	}
	
	@Step
	public void the_variable1_not_contain_variable2(String var1, String var2) {
		assertThat(listVar.get(var1),not(containsString(listVar.get(var2))));
	}
}
