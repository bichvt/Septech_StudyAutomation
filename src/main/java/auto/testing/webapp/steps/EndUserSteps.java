package auto.testing.webapp.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import auto.testing.utilities.CompareGraph;
import auto.testing.utilities.RandomData;
import auto.testing.webapp.pages.PageCore;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class EndUserSteps extends ScenarioSteps {

    PageCore pageCore;
    RandomData randomData = null;
    HashMap<String, String> listVar = new HashMap<String, String>();

    @Step
    public void open_the_home_page() {
        pageCore.open();
    }
    
    @Step
	public void navigate_to(String url) {
    	pageCore.navigate_to(url);
	}

    @Step
	public void enter_into_the_field_with(String element, String value) {
    	pageCore.wait_for_the_element_to_be_visibile(element);
    	WebElement webElement = pageCore.getWebElement(element);
    	pageCore.element(webElement).sendKeys(value);
    	//pageCore.enter(value).into(webElement);
    	//pageCore.$(webElement).sendKeys(value);
	}

    @Step
	public void maximize_the_window() {
    	pageCore.maximize_the_window();
	}

    @Step
	public void click_on_the(String element) {
    	pageCore.wait_for_the_element_to_be_clickable(element);
    	WebElement webElement = pageCore.getWebElement(element);
    	pageCore.clickOn(webElement);
	}

    @Step
	public void the_text_element_should_be(String element, String value) {
    	pageCore.wait_for_text_apprea(element,value);
    	assertThat(getText(element),equalTo(value));
	}
    
    private String getText(String element){
        	return pageCore.getWebElement(element).getText();
    }
    
    private String getAttribute(String attrName,String element){
    	return pageCore.getWebElement(element).getAttribute(attrName);
    }
    
    @Step
   	public void the_text_element_should_not_be(String element, String value) {
       	assertThat(getText(element),not(equalTo(value)));
   	}

	@Step
	public void the_text_element_should_contain(String element, String value) {
		wait_for_any_text_to_be_appread(value);
    	assertThat(getText(element),containsString(value));
	}
	
	@Step
	public void the_text_element_should_not_contain(String element, String value) {
		wait_for_any_text_to_be_disappread(value);
    	assertThat(getText(element),not(containsString(value)));
	}

    @Step
	public void move_forward_one_page() {
    	pageCore.move_forward_one_page();
	}

    @Step
	public void move_backward_one_page() {
    	pageCore.move_backward_one_page();
	}

    @Step
	public void reload_the_page() {
    	pageCore.reload_the_page();
	}

    @Step
	public void the_page_should_contain(String value) {
    	assertThat(pageCore.containsText(value),is(true));
	}

    @Step
	public void the_page_should_not_contain(String value) {
    	assertThat(pageCore.getDriver().getPageSource().contains(value),is(false));
	}
   
    @Step
	public void store_the_text_of_element_in_variable(String element, String var) {
    	String value = pageCore.getWebElement(element).getText();
    	listVar.put(var, value);
	}

    @Step
	public void variable_should_be(String var, String valueCompare) {
    	assertThat(listVar.get(var),equalTo(valueCompare));
	}

    @Step
	public void the_attribute_of_element_should_contain(String attrName, String element, String value) {
    	assertThat(getAttribute(attrName, element),containsString(value));
	}
    
    @Step
   	public void the_attribute_of_element_should_be(String attrName, String element, String value) {
       	assertThat(getAttribute(attrName, element),equalTo(value));
   	}
    
    @Step
	public void the_attribute_of_element_should_not_contain(String attrName, String element, String value) {
    	assertThat(getAttribute(attrName, element),not(containsString(value)));
	}
    
    @Step
	public void the_attribute_of_element_should_not_be(String attrName, String element, String value) {
    	assertThat(getAttribute(attrName, element),not(equalTo(value)));
	}

    @Step
	public void select_label_from_drop_down_list( String visibleLabel, String element) {
		WebElement webElement = pageCore.getWebElement(element);
    	pageCore.selectFromDropdown(webElement, visibleLabel);
	}

    @Step
	public void select_value_from_drop_down_list(String valueOption, String element) {
    	pageCore.select_value_from_drop_down_list(valueOption,element);
	}

    @Step
	public void select_index_from_drop_down_list(int indexOption, String element) {
    	pageCore.select_index_from_drop_down_list(indexOption,element);
	}

    @Step
	public void the_element_should_be_enabled(String element) {
    	assertThat(pageCore.the_element_should_be_enabled(element),is(true));
	}

    @Step
	public void the_element_should_be_disabled(String element) {
    	assertThat(pageCore.the_element_should_be_enabled(element),is(false));
	}

    @Step
	public void the_element_should_be_present(String element) {
    	assertThat(pageCore.the_element_should_be_present(element),is(true));
	}

    @Step
	public void the_element_should_not_be_present(String element) {
		assertThat(pageCore.the_element_should_be_present(element),is(false));
	}

    @Step
	public void the_element_should_be_visible(String element) {
    	assertThat(pageCore.the_element_should_be_visible(element),is(true));
	}

    @Step
	public void the_element_should_be_hidden(String element) {
    	assertThat(pageCore.the_element_should_be_visible(element),is(false));
	}

    @Step
	public void the_option_label_in_should_be_selected(String visibleText, String element) {
    	assertThat(pageCore.the_option_label_in_should_be_selected(element),equalTo(visibleText));
	}

    @Step
	public void the_option_label_in_should_not_be_selected(String visibleText, String element) {
    	assertThat(pageCore.the_option_label_in_should_be_selected(element),not(equalTo(visibleText)));
	}

    @Step
	public void type_into_the_field_with(String element, String value) {
    	pageCore.wait_for_the_element_to_be_visibile(element);
    	WebElement webElement = pageCore.getWebElement(element);
    	pageCore.typeInto(webElement, value);
	}
    
    @Step
	public void the_value_of_field_should_be(String element, String value) {
    	assertThat(pageCore.the_value_of_field(element),equalTo(value));
	}

    @Step
	public void the_value_of_field_should_not_be(String element, String value) {
    	assertThat(pageCore.the_value_of_field(element),not(equalTo(value)));
	}

    @Step
	public void the_value_of_field_should_contain(String element, String value) {
    	assertThat(pageCore.the_value_of_field(element),containsString(value));
	}
    
    @Step
   	public void the_value_of_field_should_not_contain(String element, String value) {
       	assertThat(pageCore.the_value_of_field(element),not(containsString(value)));
   	}

    @Step
	public void add_multi_select_options_from_drop_down_list(String listOption, String element) {
    	pageCore.add_multi_select_options_from_drop_down_list(listOption,element);
	}
    
    @Step
	public void remove_multi_select_options_from_drop_down_list(String listOption, String element) {
    	pageCore.add_multi_select_options_from_drop_down_list(listOption,element);
	}

    @Step
	public void change_window_size_with_width_px_and_height_px(int width, int height) {
    	pageCore.change_window_size_with_width_px_and_height_px(width,height);
	}

    @Step
	public void move_window_to_new_position_with_coordinates_at_and_on_screen(int x, int y) {
    	pageCore.move_window_to_new_position_with_coordinates_at_and_on_screen(x,y);
	}

    @Step
	public void open_in_new_window_and_switch_to_it(String url) {
    	pageCore.open_in_new_window_and_switch_to_it(url);
	}

    @Step
	public void close_current_window() {
    	pageCore.close_current_window();
	}

    @Step
	public void switch_back_to_the_original_window() {
    	pageCore.switch_back_to_the_original_window();
	}

    @Step
	public void open_link_in_a_new_window_and_switch_to_it(String linkText) {
    	pageCore.open_link_in_a_new_window_and_switch_to_it(linkText);
	}

    @Step
	public void scroll_screen_at_follow_the_horizontal_line_and_follow_vertical_line(int x, int y) {
    	pageCore.scroll_screen_at_follow_the_horizontal_line_and_follow_vertical_line(x,y);
	}

    @Step
	public void the_page_title_should_contain(String pageTitle) {
    	assertThat(pageCore.getTitle(),containsString(pageTitle));
	}
    
    @Step
	public void the_page_title_should_not_contain(String pageTitle) {
    	assertThat(pageCore.getTitle(),not(containsString(pageTitle)));
	}

    @Step
	public void the_page_title_should_be(String pageTitle) {
    	assertThat(pageCore.getTitle(),equalTo(pageTitle));
	}

    @Step
	public void the_page_title_should_not_be(String pageTitle) {
    	assertThat(pageCore.getTitle(),not(equalTo(pageTitle)));
	}

    @Step
	public void the_absolute_URL_of_the_current_page_should_be(String url) {
    	assertThat(pageCore.the_absolute_URL_of_the_current_page(),equalTo(url));
	}

    @Step
	public void double_click_on_the(String element) {
    	pageCore.double_click_on_the(element);
	}

    @Step
	public void click_on_the_at_coordinates(String element, int xOffset, int yOffset) {
    	pageCore.click_on_the_at_coordinates(element,xOffset,yOffset);
	}

    @Step
	public void double_click_on_the_at_coordinates(String element, int xOffset, int yOffset) {
    	pageCore.double_click_on_the_at_coordinates(element,xOffset,yOffset);
	}

    @Step
	public void right_click_on_the(String element) {
    	pageCore.right_click_on_the(element);
	}

    @Step
	public void right_click_on_the_at_coordinates(String element, int xOffset, int yOffset) {
    	pageCore.right_click_on_the_at_coordinates(element,xOffset,yOffset);
	}

    @Step
	public void right_click_on_the_and_click_on_item_has_index(String element, int indexIterm) {
    	pageCore.right_click_on_the_and_click_on_item_has_index(element,indexIterm);
	}

    @Step
	public void right_click_the_at_coordinates_and_and_click_on_item_has_index(String element, int xOffset, int yOffset,
			int indexItem) {
    	pageCore.right_click_the_at_coordinates_and_and_click_on_item_has_index(element,xOffset,yOffset,indexItem);
		
	}

    @Step
	public void drag_the_and_drop_to_the(String resouce, String dest) {
    	pageCore.drag_the_and_drop_to_the(resouce,dest);
	}

    @Step
	public void click_and_hold(String element) {
    	pageCore.click_and_hold(element);
	}

    @Step
	public void move_mouse_to(String element) {
    	pageCore.move_mouse_to(element);
	}

    @Step
	public void open_the(String url) {
    	pageCore.openAt(url);
	}

    @Step
	public void move_mouse_to_at_coordinates(String element, int xOffset, int yOffset) {
    	pageCore.move_mouse_to_at_coordinates(element,xOffset,yOffset);
	}

    @Step
	public void accept_the_currently_displayed_dialog(String element) {
    	pageCore.accept_the_currently_displayed_dialog(element);
	}

    @Step
	public void answer_the_currently_displayed_dialog(String element, String answer) {
    	pageCore.answer_the_currently_displayed_dialog(element,answer);
	}

    @Step
	public void dismiss_the_currently_displayed_dialog(String element) {
    	pageCore.dismiss_the_currently_displayed_dialog(element);
	}

    @Step
	public void click_on_the_to_open_pop_up_window_and_switch_to_it(String element) {
    	pageCore.click_on_the_to_open_pop_up_windown_and_switch_to_it(element);
	}

    @Step
	public void wait_for_the_element_to_be_clickable(String element) {
    	pageCore.wait_for_the_element_to_be_clickable(element);
	}

    @Step
	public void html5_drag_the_and_drop_to_the(String resouce, String dest) throws AWTException {
    	pageCore.drag_the_and_drop_html5(resouce, dest, 0, 70);
	}

    @Step
	public void upload_file(String pathFile) {
    	pageCore.upload_file(pathFile);
	}

    @Step
	public void wait_for_any_text_to_be_present(String textValue) {
    	pageCore.waitForAnyTextToAppear(textValue);
	}

    @Step
	public void capture_and_save_it(String element, String pathStorge) {
    	try {
    			FileUtils.copyFile(pageCore.captureElementBitmap(element), new File(pathStorge));
	    	} catch (IOException e) {e.printStackTrace();
			} catch (Exception e) {	e.printStackTrace();}
    	}

    @Step
	public void actual_image_and_expected_image_should_be_similar(String expectImg, String actualImge) {
    	assertThat(CompareGraph.Result.Matched,equalTo(CompareGraph.CompareImage(expectImg,actualImge)));
	}

    @Step
	public void change_attribute_of_into(String attr, String element, String attrValue) {
    	pageCore.setAttribute(attr,element,attrValue);
	}

    @Step
	public void highlight_element(String element) {
    	pageCore.highlightElement(element);
	}

    @Step
	public void set_bound_for_element(String element) {
    	pageCore.setBounds(element);
	}

    @Step
	public void swich_to_frame(String iframeName) {
    	pageCore.swich_to_frame(iframeName);
	}

    @Step
	public void swich_back_to_parent_frame() {
    	pageCore.swich_back_to_parent_frame();
	}

    @Step
	public void swich_back_to_main_frame() {
    	pageCore.swich_back_to_main_frame();
	}

    @Step
	public void enter_random_into_the_field_with_length(String element, int length) {	
    	randomData = new RandomData();
    	String value = randomData.getStr(length);
    	enter_into_the_field_with(element, value);
	}

    @Step
	public void wait_for_the_element_to_be_visibile(String element) {
    	pageCore.wait_for_the_element_to_be_visibile(element);
	}
    
    @Step
	public void enter_into_the_ckeditor_with(String iframe, String value) {
		swich_to_frame(iframe);
		WebElement inputsummary = null;
		inputsummary = getDriver().switchTo().activeElement();
		inputsummary.click();
		inputsummary.clear();
		((JavascriptExecutor) getDriver()).executeScript("document.body.innerHTML='" + value + "' + document.body.innerHTML;");
		swich_back_to_parent_frame();
	}

    @Step
	public void wait_for_any_text_to_be_disappread(String textValue) {
    	pageCore.waitForTextToDisappear(textValue);
	}
    
    @Step
  	public void wait_for_any_text_to_be_appread(String textValue) {
      	pageCore.waitForTextToAppear(textValue);
  	}

    @Step
	public void click_on_the_text(String industryName) {
		pageCore.$("//*[text()="+industryName+"]").click();
	}
    
}