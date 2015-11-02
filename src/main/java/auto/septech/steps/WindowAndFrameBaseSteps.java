package auto.septech.steps;

import auto.septech.coreactions.DialogAndAlert;
import auto.septech.coreactions.CoreActionForm;
import auto.septech.coreactions.ManageFileAction;
import auto.septech.coreactions.PageCore;
import auto.septech.coreactions.WindowsAndFrames;
import net.thucydides.core.annotations.Step;

public class WindowAndFrameBaseSteps extends EndUserBaseSteps {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PageCore pageCore;
	DialogAndAlert dialogsAndAlert;
	CoreActionForm mainActionForm;
	ManageFileAction manageFileAction;
	WindowsAndFrames windowsAndFrames;
    @Step
	public void open_the(String url) {
    	pageCore.openAt(pageCore.getActualValueFromObjectRepository(url));
	}
    
    @Step
	public void navigate_to(String url) {
    	windowsAndFrames.navigateToUrl(pageCore.getActualValueFromObjectRepository(url));
	}
    
	@Step
	public void maximize_the_window() {
		windowsAndFrames.maximizeWindows();
	}

	@Step
	public void move_forward_one_page() {
		windowsAndFrames.forwardPage();
	}

	@Step
	public void move_backward_one_page() {
		windowsAndFrames.backwardPage();
	}

	@Step
	public void reload_the_page() {
		windowsAndFrames.reloadPage();
	}

	@Step
	public void change_window_size_with_width_px_and_height_px(int width, int height) {
		windowsAndFrames.changeWindowSize(width,height);
	}

	@Step
	public void move_window_to_new_position_with_coordinates_at_and_on_screen(int x, int y) {
		windowsAndFrames.moveWindowToNewPositionWithCoordinatesAtAndOnScreen(x,y);
	}

	@Step
	public void open_in_new_window_and_switch_to_it(String url) {
		windowsAndFrames.openPageOnNewWindow(pageCore.getActualValueFromObjectRepository(url));
	}

	@Step
	public void close_current_window() {
		windowsAndFrames.closeCurrentWindow();
	}

	@Step
	public void switch_back_to_the_original_window() {
		windowsAndFrames.switchOldWindow();
	}
	
    @Step
	public void click_on_the_to_open_pop_up_window_and_switch_to_it(String element) {
    	windowsAndFrames.clickToOpenWindowAndSwitchToIt(element);
	}

	@Step
	public void open_link_in_a_new_window_and_switch_to_it(String linkText) {
		windowsAndFrames.openLinkInANewWindowAndSwitchToIt(linkText);
	}

	@Step
	public void scroll_screen_at_follow_the_horizontal_line_and_follow_vertical_line(int x, int y) {
		windowsAndFrames.scrollScreen(x,y);
	}

	@Step
	public void swich_to_frame(String iframeName) {
		windowsAndFrames.switchToIFrame(iframeName);
	}

	@Step
	public void swich_back_to_parent_frame() {
		windowsAndFrames.swichBackToParentFrame();
	}

	@Step
	public void swich_back_to_main_frame() {
		windowsAndFrames.swichBackToMainFrame();
	}
}
