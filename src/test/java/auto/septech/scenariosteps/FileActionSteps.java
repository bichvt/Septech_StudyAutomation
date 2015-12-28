package auto.septech.scenariosteps;

import auto.septech.steps.DialogAndAlertBaseSteps;
import auto.septech.steps.EndUserBaseSteps;
import auto.septech.steps.FileActionBaseSteps;
import auto.septech.steps.CoreActionFormBaseSteps;
import auto.septech.steps.VerificationBaseSteps;
import auto.septech.steps.WindowAndFrameBaseSteps;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FileActionSteps {
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

	@When("^upload file \"([^\"]*)\"$")
	public void upload_file(String pathFile) throws Throwable {
		fileActionSteps.upload_file(pathFile);
	}

	@When("^upload on the element \"([^\"]*)\" file \"([^\"]*)\"$")
	public void upload_file(String element, String pathFile) throws Throwable {
		fileActionSteps.upload_file_using_javascript(element,pathFile);
	}

	@When("^store the height of image \"(.*?)\" in \"(.*?)\" variable$")
	public void store_the_height_of_image_in_variable(String path, String var) throws Throwable {
		fileActionSteps.store_text_value_in_variable(String.valueOf(fileActionSteps.get_height_of_image(path)),var);
	}

	@When("^store the width of image \"(.*?)\" in \"(.*?)\" variable$")
	public void store_the_width_of_image_in_variable(String path, String var) throws Throwable {
		fileActionSteps.store_text_value_in_variable(String.valueOf(fileActionSteps.get_width_of_image(path)),var);
	}
}
