package auto.septech.steps;
import java.awt.AWTException;

import net.thucydides.core.annotations.Step;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import auto.septech.coreactions.DialogAndAlert;
import auto.septech.coreactions.CoreActionForm;
import auto.septech.coreactions.ManageFileAction;
import auto.septech.coreactions.PageCore;
import auto.septech.coreactions.WindowsAndFrames;
import auto.septech.utilities.RandomData;
import auto.septech.utilities.TestLogger;
import auto.septech.utilities.ObjectMap;
public class CoreActionFormBaseSteps extends EndUserBaseSteps {
	/* 
	 */
	private static final long serialVersionUID = 1L;
	PageCore pageCore;
	DialogAndAlert dialogsAndAlert;
	CoreActionForm mainActionForm;
	ManageFileAction manageFileAction;
	RandomData randomData;
	WindowsAndFrames windowsAndFrames;

	/*************************Enter value into textbox/editor box************************************************/
	@Step
	public void enter_into_the_editor(String iframe, String value) {
		windowsAndFrames.switchToIFrame(iframe);
		WebElement inputsummary = null;
		inputsummary = getDriver().switchTo().activeElement();
		inputsummary.click();
		inputsummary.clear();
		randomData = new RandomData();
		value=randomData.processRandomCucumber(value);
		((JavascriptExecutor) getDriver()).executeScript("document.body.innerHTML='" + value + "' + document.body.innerHTML;");
		windowsAndFrames.swichBackToMainFrame();
	}

	@Step
	public void enter_into_the_editor_and_store_into_variable(String iframe, String value, String var) {
		windowsAndFrames.switchToIFrame(iframe);
		WebElement inputsummary = null;
		inputsummary = getDriver().switchTo().activeElement();
		inputsummary.click();
		inputsummary.clear();
		randomData = new RandomData();
		value=randomData.processRandomCucumber(value);
		((JavascriptExecutor) getDriver()).executeScript("document.body.innerHTML='" + value + "' + document.body.innerHTML;");
		windowsAndFrames.swichBackToMainFrame();
		listVar.put(var, value);
		TestLogger.info(listVar.get(var));
	}

	@Step
	public void enter_random_into_the_field_with_length(String element, int length) {	
		randomData = new RandomData();
		String value = randomData.getStr(length);
		enter_into_the_field_with_value(element, value);
	}

	@Step
	public void enter_into_the_field_with_value(String element, String value) {
		WebElement webElement = pageCore.getWebElement(element);
		pageCore.waitFor(webElement);
		pageCore.element(webElement).clear();
		randomData = new RandomData();
		value=randomData.processRandomCucumber(value);
		pageCore.typeInto(webElement, value);
	}

	@Step
	public void enter_into_the_field_with_value_and_store_variable(String element, String value, String var) {
		WebElement webElement = pageCore.getWebElement(element);
		pageCore.waitFor(webElement);
		pageCore.element(webElement).clear();
		randomData = new RandomData();
		value=randomData.processRandomCucumber(value);
		pageCore.typeInto(webElement, value);
		listVar.put(var, value);
		TestLogger.info(listVar.get(var));
	}

	@Step
	public void enter_into_the_field_with_variable(String element, String var) {
		WebElement webElement = pageCore.getWebElement(element);
		pageCore.waitFor(webElement);
		pageCore.element(webElement).clear();
		TestLogger.info(listVar.get(var));
		pageCore.element(webElement).sendKeys(listVar.get(var));
	}


	/*************************Click action************************************************/
   
	@Step
	public void press_down_arrow_key(){
		mainActionForm.pressDownArrowKey();
	}
	
	@Step
	public void press_enter_key(){
		mainActionForm.pressEnterKey();
	}
	
	@Step
	public void press_tab_key(Integer number){
		mainActionForm.pressTabKey(number);
	}
	
	@Step
	public void click_on_the_text(String text) {
		pageCore.$("//*[text()="+text+"]").click();
	}
	
	@Step
	public void click_on_the_element_with_variable(String element, String var) throws Exception {
		System.out.println(ObjectMap.getLocatorString(element)+"[contains(text(),'"+listVar.get(var)+"')]");
		WebElement webElement = getDriver().findElement(pageCore.getObject(ObjectMap.getLocatorString(element)+"[contains(text(),'"+listVar.get(var)+"')]"));
		pageCore.clickOn(webElement);
	}
    
	@Step
	public void click_on_the_element_by_javascript(String element) {
		mainActionForm.clickByJavascript(element);
	}
	
	@Step
	public void click_on_the_element(String element) {
		mainActionForm.clickOnElement(element);
	}

	@Step
	public void double_click_on_the(String element) {
		mainActionForm.doubleClickOnElement(element);
	}

	@Step
	public void click_on_the_at_coordinates(String element, int xOffset, int yOffset) {
		mainActionForm.clickOnTheAtCoordinates(element,xOffset,yOffset);
	}

	@Step
	public void double_click_on_the_at_coordinates(String element, int xOffset, int yOffset) {
		mainActionForm.doubleClickOnTheAtCoordinates(element,xOffset,yOffset);
	}

	@Step
	public void right_click_on_the(String element) {
		mainActionForm.rightClickOnElement(element);
	}

	@Step
	public void right_click_on_the_at_coordinates(String element, int xOffset, int yOffset) {
		mainActionForm.rightClickOnTheAtCoordinates(element,xOffset,yOffset);
	}

	@Step
	public void right_click_on_the_and_click_on_item_has_index(String element, int indexIterm) {
		mainActionForm.rightClickOnTheAndClickOnItemHasIndex(element,indexIterm);
	}

	@Step
	public void right_click_the_at_coordinates_and_and_click_on_item_has_index(String element, int xOffset, int yOffset,
			int indexItem) {
		mainActionForm.rightClickTheAtCoordinatesAndClickOnItemHasIndex(element,xOffset,yOffset,indexItem);

	}

	@Step
	public void click_and_hold(String element) {
		mainActionForm.clickAndHold(element);
	}

	/*************************checkbox************************************************/
	@Step
	public void check_checkbox(String element) {
		mainActionForm.checkCheckbox(element);
	}

	@Step
	public void uncheck_checkbox(String element) {
		mainActionForm.uncheckCheckbox(element);
	}
    
	/*************************combobox/listbox************************************************/
	@Step
	public void select_value_variable_label_from_drop_down_list( String variable, String element) {
		mainActionForm.selectTextFromDropDownList(listVar.get(variable),element);
	}

	@Step
	public void select_value_variable_value_from_drop_down_list(String variable, String element) {
		mainActionForm.selectValueFromDropDownList(listVar.get(variable),element);
	}
	
	@Step
	public void select_label_from_drop_down_list( String visibleLabel, String element) {
		mainActionForm.selectTextFromDropDownList(visibleLabel,element);
	}

	@Step
	public void select_value_from_drop_down_list(String valueOption, String element) {
		mainActionForm.selectValueFromDropDownList(valueOption,element);
	}

	@Step
	public void select_index_from_drop_down_list(int indexOption, String element) {
		mainActionForm.selectIndexFromDropDownList(indexOption,element);
	}
	
    @Step
	public void select_multi_select_options_from_drop_down_list(String listOption, String element) {
    	mainActionForm.addMultiSelectOptionsFromDropDownList(listOption,element);
	}

	/********mouse over actions*************/
	@Step
	public void drag_the_and_drop_to_the(String resouce, String dest) {
		mainActionForm.dragAndDropElement(resouce,dest);
	}
	
    @Step
	public void html5_drag_the_and_drop_to_the(String resouce, String dest) throws AWTException {
    	mainActionForm.dragAndDropElementHtml(resouce, dest, 0, 70);
	}

	@Step
	public void move_mouse_to(String element) {
		mainActionForm.moveMouse(element);
	}

	@Step
	public void move_mouse_to_at_coordinates(String element, int xOffset, int yOffset) {
		mainActionForm.moveMouseToAtCoordinates(element,xOffset,yOffset);
	}
}
