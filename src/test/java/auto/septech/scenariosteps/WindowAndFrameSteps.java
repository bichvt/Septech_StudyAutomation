package auto.septech.scenariosteps;

import auto.septech.steps.DialogAndAlertBaseSteps;
import auto.septech.steps.EndUserBaseSteps;
import auto.septech.steps.FileActionBaseSteps;
import auto.septech.steps.CoreActionFormBaseSteps;
import auto.septech.steps.VerificationBaseSteps;
import auto.septech.steps.WindowAndFrameBaseSteps;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class WindowAndFrameSteps {
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
    
    @When("^navigate to \"(.*?)\"$")
    public void navigate_to(String url) throws Throwable {
    	windowsAndFramesSteps.navigate_to(url);
    }
    
    @When("^maximize the window$")
    public void maximize_the_window() throws Throwable {
    	windowsAndFramesSteps.maximize_the_window();
    }
    
    @When("^move forward one page$")
    public void move_forward_one_page() throws Throwable {
    	windowsAndFramesSteps.move_forward_one_page();
    }

    @When("^move backward one page$")
    public void move_backward_one_page() throws Throwable {
    	windowsAndFramesSteps.move_backward_one_page();
    }

    @When("^reload the page$")
    public void reload_the_page() throws Throwable {
    	windowsAndFramesSteps.reload_the_page();
    }
    
    @When("^change window size with width (\\d+) px and height (\\d+) px$")
    public void change_window_size_with_width_px_and_height_px(int width, int height) throws Throwable {
    	windowsAndFramesSteps.change_window_size_with_width_px_and_height_px(width,height);
    }
    
    @When("^move window to new position  with coordinates at (\\d+) and (\\d+) on screen$")
    public void move_window_to_new_position_with_coordinates_at_and_on_screen(int x, int y) throws Throwable {
    	windowsAndFramesSteps.move_window_to_new_position_with_coordinates_at_and_on_screen(x,y);
    }
    
    @When("^open \"([^\"]*)\" in new window and switch to it$")
    public void open_in_new_window_and_switch_to_it(String url) throws Throwable {
    	windowsAndFramesSteps.open_in_new_window_and_switch_to_it(url);
    }
    
    @When("^open the \"([^\"]*)\"$")
    public void open_the(String url) throws Throwable {
    	windowsAndFramesSteps.open_the(url);
    }
    
	@When("^close current window$")
	public void close_current_window() throws Throwable {
		windowsAndFramesSteps.close_current_window();
	}

	@When("^switch back to the original window$")
	public void switch_back_to_the_original_window() throws Throwable {
		windowsAndFramesSteps.switch_back_to_the_original_window();
	}
	
	@When("^open \"([^\"]*)\" link in a new window and switch to it$")
	public void open_link_in_a_new_window_and_switch_to_it(String linkText) throws Throwable {
		windowsAndFramesSteps.open_link_in_a_new_window_and_switch_to_it(linkText);
	}
	
	@When("^scroll screen at (\\d+) follow the horizontal line and (\\d+) follow vertical line$")
	public void scroll_screen_at_follow_the_horizontal_line_and_follow_vertical_line(int x, int y) throws Throwable {
		windowsAndFramesSteps.scroll_screen_at_follow_the_horizontal_line_and_follow_vertical_line(x,y);
	}
	
	@When("^switch to \"([^\"]*)\" frame$")
	public void swich_to_frame(String iframeName) throws Throwable {
		windowsAndFramesSteps.swich_to_frame(iframeName);
	}

	@When("^switch back to parent frame$")
	public void swich_back_to_parent_frame() throws Throwable {
		windowsAndFramesSteps.swich_back_to_parent_frame();
	}

	@When("^switch back to main frame$")
	public void swich_back_to_main_frame() throws Throwable {
		windowsAndFramesSteps.swich_back_to_main_frame();
	}
}
