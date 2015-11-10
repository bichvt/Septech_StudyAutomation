package auto.septech.steps;

import net.thucydides.core.annotations.Step;
import auto.septech.coreactions.DialogAndAlert;
import auto.septech.coreactions.CoreActionForm;
import auto.septech.coreactions.ManageFileAction;
import auto.septech.coreactions.PageCore;
import auto.septech.coreactions.WindowsAndFrames;

public class FileActionBaseSteps extends EndUserBaseSteps {
	/* 
	 */
	private static final long serialVersionUID = 1L;
	PageCore pageCore;
	DialogAndAlert dialogsAndAlert;
	CoreActionForm mainActionForm;
	ManageFileAction manageFileAction;
	WindowsAndFrames windowsAndFrames;
    @Step
	public void upload_file(String pathFile) {
    	manageFileAction.uploadFileUsingRobot(pathFile);
	}
    
    @Step
	public void upload_file_using_javascript(String element, String pathFile) throws InterruptedException {
    	manageFileAction.uploadFileUsingJavascript(element,pathFile);
	}
    
	@Step
	public Integer get_height_of_image(String path){
		return manageFileAction.getHeightImage(path);
	}

	@Step
	public Integer get_width_of_image(String path){
		return manageFileAction.getWidthImage(path);
	}
}
