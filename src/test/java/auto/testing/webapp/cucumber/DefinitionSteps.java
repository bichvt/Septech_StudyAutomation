package auto.testing.webapp.cucumber;

import auto.testing.webapp.steps.EndUserSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.vi.Khi;
import cucumber.api.java.vi.Thì;
import net.thucydides.core.annotations.Steps;
public class DefinitionSteps {
	
	protected static String actualImage = System.getProperty("user.dir")+ "\\images\\";
	protected static String tmpImage = System.getProperty("user.dir")+ "\\target\\";
		
    @Steps
    EndUserSteps endUser;

    @Given("open the home page")
    public void open_the_home_page() {
        endUser.open_the_home_page();
    }
    
    @When("^enter into the \"(.*?)\" field with \"(.*?)\"$")
    public void enter_into_the_field_with(String target, String value) throws Throwable {
    	endUser.enter_into_the_field_with(target,value);
    }
    
    @When("^type into the \"([^\"]*)\" field with \"([^\"]*)\"$")
    public void type_into_the_field_with(String target, String value) throws Throwable {
    	endUser.type_into_the_field_with(target,value);
    }
    
    @When("^maximize the window$")
    public void maximize_the_window() throws Throwable {
    	endUser.maximize_the_window();
    }
    
    @When("^click on the \"(.*?)\"$")
    public void click_on_the(String target) throws Throwable {
    	endUser.click_on_the(target);
    }
    
    @Then("^the text \"(.*?)\" element should be \"(.*?)\"$")
    public void the_text_element_should_be(String target, String value) throws Throwable {
    	endUser.the_text_element_should_be(target,value);
    }
    
    @Then("^the text \"(.*?)\" element should not be \"(.*?)\"$")
    public void the_text_element_should_not_be(String target, String value) throws Throwable {
    	endUser.the_text_element_should_not_be(target,value);
    }
    
    @Then("^the text \"(.*?)\" element should contain \"(.*?)\"$")
    public void the_text_element_should_contain(String target, String value) throws Throwable {
    	endUser.the_text_element_should_contain(target,value);
    }
    
    @Then("^the text \"(.*?)\" element should not contain \"(.*?)\"$")
    public void the_text_element_should_not_contain(String target, String value) throws Throwable {
    	endUser.the_text_element_should_not_contain(target,value);
    }
    
    @When("^move forward one page$")
    public void move_forward_one_page() throws Throwable {
    	endUser.move_forward_one_page();
    }

    @When("^move backward one page$")
    public void move_backward_one_page() throws Throwable {
    	endUser.move_backward_one_page();
    }

    @When("^reload the page$")
    public void reload_the_page() throws Throwable {
    	endUser.reload_the_page();
    }
    
   
    @When("^store the text of \"(.*?)\" element in \"(.*?)\" variable$")
    public void store_the_text_of_element_in_variable(String element, String var) throws Throwable {
    	endUser.store_the_text_of_element_in_variable(element,var);
    }
    
    @When("^enter random into \"([^\"]*)\" field with data length is (\\d+)$")
    public void enter_random_into_the_field_with_length(String element, int length) throws Throwable {
    	endUser.enter_random_into_the_field_with_length(element,length);
    }
    
    @When("^navigate to \"(.*?)\"$")
    public void navigate_to(String url) throws Throwable {
    	endUser.navigate_to(url);
    }
    
    @When("^select \"(.*?)\" label from \"(.*?)\" drop-down list$")
    public void select_label_from_drop_down_list(String visibleLabel, String element) throws Throwable {
    	endUser.select_label_from_drop_down_list(visibleLabel,element);
    }

    @When("^select \"(.*?)\" value from \"(.*?)\" drop-down list$")
    public void select_value_from_drop_down_list(String valueOption, String element) throws Throwable {
    	endUser.select_value_from_drop_down_list(valueOption,element);
    }

    @When("^select (\\d+) index from \"(.*?)\" drop-down list$")
    public void select_index_from_drop_down_list(int indexOption, String element) throws Throwable {
    	endUser.select_index_from_drop_down_list(indexOption,element);
    }
    
    @When("^add multi-select \"([^\"]*)\" options from \"([^\"]*)\" drop-down list$")
    public void add_multi_select_options_from_drop_down_list(String listOption, String element) throws Throwable {
    	endUser.add_multi_select_options_from_drop_down_list(listOption,element);
    }
    
    @When("^remove multi-select \"([^\"]*)\" options from \"([^\"]*)\" drop-down list$")
    public void remove_multi_select_options_from_drop_down_list(String listOption, String element) throws Throwable {
    	endUser.remove_multi_select_options_from_drop_down_list(listOption,element);
    }
    
    @When("^change window size with width (\\d+) px and height (\\d+) px$")
    public void change_window_size_with_width_px_and_height_px(int width, int height) throws Throwable {
    	endUser.change_window_size_with_width_px_and_height_px(width,height);
    }
    
    @When("^move window to new position  with coordinates at (\\d+) and (\\d+) on screen$")
    public void move_window_to_new_position_with_coordinates_at_and_on_screen(int x, int y) throws Throwable {
    	endUser.move_window_to_new_position_with_coordinates_at_and_on_screen(x,y);
    }
    
    @When("^open \"([^\"]*)\" in new window and switch to it$")
    public void open_in_new_window_and_switch_to_it(String url) throws Throwable {
    	endUser.open_in_new_window_and_switch_to_it(url);
    }
    
    @When("^open the \"([^\"]*)\"$")
    public void open_the(String url) throws Throwable {
        endUser.open_the(url);
    }
    

	@When("^close current window$")
	public void close_current_window() throws Throwable {
		endUser.close_current_window();
	}

	@When("^switch back to the original window$")
	public void switch_back_to_the_original_window() throws Throwable {
		endUser.switch_back_to_the_original_window();
	}
	
	@When("^open \"([^\"]*)\" link in a new window and switch to it$")
	public void open_link_in_a_new_window_and_switch_to_it(String linkText) throws Throwable {
		endUser.open_link_in_a_new_window_and_switch_to_it(linkText);
	}
	
	@When("^scroll screen at (\\d+) follow the horizontal line and (\\d+) follow vertical line$")
	public void scroll_screen_at_follow_the_horizontal_line_and_follow_vertical_line(int x, int y) throws Throwable {
		endUser.scroll_screen_at_follow_the_horizontal_line_and_follow_vertical_line(x,y);
	}
	
	@When("^double-click on the \"([^\"]*)\"$")
	public void double_click_on_the(String element) throws Throwable {
		endUser.double_click_on_the(element);
	}
	
	@When("^click on the \"([^\"]*)\" at coordinates (\\d+) and (\\d+)$")
	public void click_on_the_at_coordinates(String element, int xOffset, int yOffset) throws Throwable {
		endUser.click_on_the_at_coordinates(element,xOffset,yOffset);
	}

	@When("^double-click on the \"([^\"]*)\" at coordinates (\\d+) and (\\d+)$")
	public void double_click_on_the_at_coordinates_and(String element, int xOffset, int yOffset) throws Throwable {
		endUser.double_click_on_the_at_coordinates(element,xOffset,yOffset);
	}

	@When("^right click on the \"([^\"]*)\"$")
	public void right_click_on_the(String element) throws Throwable {
		endUser.right_click_on_the(element);
	}
	
	@When("^right click on the \"([^\"]*)\" at coordinates (\\d+) and (\\d+)$")
	public void right_click_on_the_at_coordinates_and(String element, int xOffset, int yOffset) throws Throwable {
		endUser.right_click_on_the_at_coordinates(element, xOffset, yOffset);
	}

	@When("^right click on the \"([^\"]*)\" and click on item has index is (\\d+)$")
	public void right_click_on_the_and_click_on_item_has_index_is(String element, int indexItem) throws Throwable {
		endUser.right_click_on_the_and_click_on_item_has_index(element,indexItem);
	}
	
	@When("^right click the \"([^\"]*)\" at coordinates (\\d+) and (\\d+) and click on item has index is (\\d+)$")
	public void right_click_the_at_coordinates_and_and_click_on_item_has_index_is(String element, int xOffset, int yOffset, int indexItem) throws Throwable {
		endUser.right_click_the_at_coordinates_and_and_click_on_item_has_index(element,xOffset,yOffset,indexItem);
	}
	
	@When("^drag the \"([^\"]*)\" and drop to the \"([^\"]*)\"$")
	public void drag_the_and_drop_to_the(String resouce, String dest) throws Throwable {
		endUser.drag_the_and_drop_to_the(resouce,dest);
	}
	
	@When("^html5 - drag the \"([^\"]*)\" and drop to the \"([^\"]*)\"$")
	public void html5_drag_the_and_drop_to_the(String resouce, String dest) throws Throwable {
		endUser.html5_drag_the_and_drop_to_the(resouce,dest);
	}
	
	@When("^click and hold the \"([^\"]*)\"$")
	public void click_and_hold(String element) throws Throwable {
		endUser.click_and_hold(element);
	}

	@When("^move mouse to \"([^\"]*)\"$")
	public void move_mouse_to(String element) throws Throwable {
		endUser.move_mouse_to(element);
	}
	
	@When("^move mouse to \"([^\"]*)\" at coordinates (\\d+) and (\\d+)$")
	public void move_mouse_to_at_coordinates_and(String element, int xOffset, int yOffset) throws Throwable {
		endUser.move_mouse_to_at_coordinates(element,xOffset,yOffset);
	}
	
	@When("^follow confirm box \"(.*?)\" and accept the currently displayed dialog$")
	public void accept_the_currently_displayed_dialog(String element) throws Throwable {
		endUser.accept_the_currently_displayed_dialog(element);
	}
	
	@When("^follow confirm box \"(.*?)\" and dismiss the currently displayed dialog$")
	public void dismiss_the_currently_displayed_dialog(String element) throws Throwable {
		endUser.dismiss_the_currently_displayed_dialog(element);
	}
	
	@When("^follow prompt box \"(.*?)\" and answer the prompt on the dialog is \"(.*?)\"$")
	public void answer_the_currently_displayed_dialog(String element, String answer) throws Throwable {
		endUser.answer_the_currently_displayed_dialog(element,answer);
	}
	
	@When("^click on the \"([^\"]*)\" to open pop-up window and switch to it$")
	public void click_on_the_to_open_pop_up_window_and_switch_to_it(String element) throws Throwable {
		endUser.click_on_the_to_open_pop_up_window_and_switch_to_it(element);
	}
	
	@When("^wait for the \"([^\"]*)\" element to be clickable$")
	public void wait_for_the_element_to_be_clickable(String element) throws Throwable {
		endUser.wait_for_the_element_to_be_clickable(element);
	}
	
	@When("^wait for the \"([^\"]*)\" element to be visibile$")
	public void wait_for_the_element_to_be_visibile(String element) throws Throwable {
		endUser.wait_for_the_element_to_be_visibile(element);
	}

	@When("^upload \"([^\"]*)\" file$")
	public void upload_file(String pathFile) throws Throwable {
		endUser.upload_file(pathFile);
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
	
	@When("^capture an exact image of \"([^\"]*)\" element on the screen and save as \"([^\"]*)\"$")
	public void capture_an_exact_image_of_element_on_the_screen_and_save_as(String element, String nameImg) throws Throwable {
		String pathStorge = tmpImage + nameImg;;
		endUser.capture_and_save_it(element,pathStorge);
	}
	
	@When("^change \"([^\"]*)\" attribute of \"([^\"]*)\" into \"([^\"]*)\"$")
	public void change_attribute_of_into(String attr, String element, String attrValue) throws Throwable {
		endUser.change_attribute_of_into(attr,element,attrValue);
	}

	@When("^highlight \"([^\"]*)\" element$")
	public void highlight_element(String element) throws Throwable {
		endUser.highlight_element(element);
	}

	@When("^set bound for \"([^\"]*)\" element$")
	public void set_bound_for_element(String element) throws Throwable {
		endUser.set_bound_for_element(element);
	}
	
	@When("^swich to \"([^\"]*)\" frame$")
	public void swich_to_frame(String iframeName) throws Throwable {
		endUser.swich_to_frame(iframeName);
	}

	@When("^swich back to parent frame$")
	public void swich_back_to_parent_frame() throws Throwable {
		endUser.swich_back_to_parent_frame();
	}

	@When("^swich back to main frame$")
	public void swich_back_to_main_frame() throws Throwable {
		endUser.swich_back_to_main_frame();
	}
	
	@When("^wait for (\\d+) seconds$")
	public void wait_for_seconds(int time) throws Throwable {
	   Thread.sleep(time*1000);
	}
	
	@When("^enter into the ckeditor \"([^\"]*)\" field with \"([^\"]*)\"$")
	public void enter_into_the_ckeditor_field_with_variable(String target, String var) throws Throwable {
		endUser.enter_into_the_ckeditor_with(target,var);
	}

    // Verify
    @Then("^\"(.*?)\" variable should be \"(.*?)\"$")
    public void variable_should_be(String var, String valueCompare) throws Throwable {
    	endUser.variable_should_be(var,valueCompare);
    }
    
    @Then("^the page should contain \"(.*?)\"$")
    public void the_page_should_contain(String value) throws Throwable {
    	endUser.the_page_should_contain(value);
    }
    
    @Then("^the page should not contain \"(.*?)\"$")
    public void the_page_should_not_contain(String value) throws Throwable {
    	endUser.the_page_should_not_contain(value);
    }
    
    @Then("^the \"(.*?)\" attribute of \"(.*?)\" should contain \"(.*?)\"$")
    public void the_attribute_of_element_should_contain(String attribute, String element, String value) throws Throwable {
    	endUser.the_attribute_of_element_should_contain(attribute,element,value);
    }
    
    @Then("^the \"(.*?)\" attribute of \"(.*?)\" should be \"(.*?)\"$")
    public void the_attribute_of_element_should_be(String attribute, String element, String value) throws Throwable {
    	endUser.the_attribute_of_element_should_be(attribute,element,value);
    }
    
    @Then("^the \"(.*?)\" attribute of \"(.*?)\" should not contain \"(.*?)\"$")
    public void the_attribute_of_element_should_not_contain(String attribute, String element, String value) throws Throwable {
    	endUser.the_attribute_of_element_should_not_contain(attribute,element,value);
    }
    
    @Then("^the \"(.*?)\" attribute of \"(.*?)\" should not be \"(.*?)\"$")
    public void the_attribute_of_element_should_not_be(String attribute, String element, String value) throws Throwable {
    	endUser.the_attribute_of_element_should_not_be(attribute,element,value);
    }
    
    @Then("^the \"(.*?)\" element should be enabled$")
    public void the_element_should_be_enabled(String element) throws Throwable {
    	endUser.the_element_should_be_enabled(element);
    }
    
    @Then("^the \"(.*?)\" element should be disabled$")
    public void the_element_should_be_disabled(String element) throws Throwable {
    	endUser.the_element_should_be_disabled(element);
    }
    
    @Then("^the \"(.*?)\" element should be present$")
    public void the_element_should_be_present(String element) throws Throwable {
    	endUser.the_element_should_be_present(element);
    }
    
    @Then("^the \"(.*?)\" element should not be present$")
    public void the_element_should_not_be_present(String element) throws Throwable {
    	endUser.the_element_should_not_be_present(element);
    }
    
    @Then("^the \"(.*?)\" element should be visible$")
    public void the_element_should_be_visible(String element) throws Throwable {
    	endUser.the_element_should_be_visible(element);
    }

    @Then("^the \"(.*?)\" element should be hidden$")
    public void the_element_should_be_hidden(String element) throws Throwable {
    	endUser.the_element_should_be_hidden(element);
    }
    
    @Then("^the \"(.*?)\" option label in \"(.*?)\" should be selected$")
    public void the_option_label_in_should_be_selected(String visibleText, String element) throws Throwable {
    	endUser.the_option_label_in_should_be_selected(visibleText,element);
    }

    @Then("^the \"(.*?)\" option label in \"(.*?)\" should not be selected$")
    public void the_option_label_in_should_not_be_selected(String visibleText, String element) throws Throwable {
    	endUser.the_option_label_in_should_not_be_selected(visibleText,element);
    }
    
    @Then("^the value of \"([^\"]*)\" field should be \"([^\"]*)\"$")
    public void the_value_of_field_should_be(String element, String value) throws Throwable {
    	endUser.the_value_of_field_should_be(element,value);
    }

    @Then("^the value of \"([^\"]*)\" field should not be \"([^\"]*)\"$")
    public void the_value_of_field_should_not_be(String element, String value) throws Throwable {
    	endUser.the_value_of_field_should_not_be(element,value);
    }

    @Then("^the value of \"([^\"]*)\" field should contain \"([^\"]*)\"$")
    public void the_value_of_field_should_contain(String element, String value) throws Throwable {
    	endUser.the_value_of_field_should_contain(element,value);
    }

    @Then("^the value of \"([^\"]*)\" field should not contain \"([^\"]*)\"$")
    public void the_value_of_field_should_not_contain(String element, String value) throws Throwable {
    	endUser.the_value_of_field_should_not_contain(element,value);
    }
    
    @Then("^the page title should contain \"([^\"]*)\"$")
    public void the_page_title_should_contain(String pageTitle) throws Throwable {
    	endUser.the_page_title_should_contain(pageTitle);
    }
    
    @Then("^the page title should not contain \"([^\"]*)\"$")
    public void the_page_title_should_not_contain(String pageTitle) throws Throwable {
    	endUser.the_page_title_should_not_contain(pageTitle);
    }
    
    
    @Then("^the page title should be \"([^\"]*)\"$")
    public void the_page_title_should_be(String pageTitle) throws Throwable {
    	endUser.the_page_title_should_be(pageTitle);
    }
    
    @Then("^the page title should not be \"([^\"]*)\"$")
    public void the_page_title_should_not_be(String pageTitle) throws Throwable {
    	endUser.the_page_title_should_not_be(pageTitle);
    }
    
    @Then("^the absolute URL of the current page should be \"([^\"]*)\"$")
    public void the_absolute_URL_of_the_current_page_should_be(String url) throws Throwable {
    	endUser.the_absolute_URL_of_the_current_page_should_be(url);
    }
    
    @Then("^actual \"([^\"]*)\" image and expected \"([^\"]*)\" image should be similar$")
    public void actual_image_and_expected_image_should_be_similar(String actualImge,String expectImg) throws Throwable {
    	String expect = tmpImage + expectImg;
    	String actual = actualImage + actualImge;
    	endUser.actual_image_and_expected_image_should_be_similar(expect, actual);
    }
}
