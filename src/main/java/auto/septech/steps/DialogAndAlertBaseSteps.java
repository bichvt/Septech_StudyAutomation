package auto.septech.steps;

import auto.septech.coreactions.DialogAndAlert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import auto.septech.coreactions.CoreActionForm;
import auto.septech.coreactions.ManageFileAction;
import auto.septech.coreactions.PageCore;
import auto.septech.coreactions.WindowsAndFrames;
import auto.septech.utilities.RandomData;
import net.thucydides.core.annotations.Step;

public class DialogAndAlertBaseSteps extends EndUserBaseSteps {
	/* 
	 */
	private static final long serialVersionUID = 1L;
	PageCore pageCore;
	DialogAndAlert dialogsAndAlert;
	CoreActionForm mainActionForm;
	ManageFileAction manageFileAction;
	RandomData randomString;
	WindowsAndFrames windowsAndFrames;
	@Step
	public void verify_alert_message_contain_text_then_accept_alert(String element, String msg){
		String retMsg=dialogsAndAlert.getAlertMessageThenAccept(element);
		assertThat(retMsg,containsString(pageCore.getActualValueFromObjectRepository(msg)));
	}

	@Step
	public void verify_alert_message_contain_text_then_dismiss_alert(String element, String msg){
		String retMsg=dialogsAndAlert.getAlertMessageThenDismiss(element);
		assertThat(retMsg,containsString(pageCore.getActualValueFromObjectRepository(msg)));
	}
	
	@Step
	public void verify_alert_message_be_text_then_accept_alert(String element, String msg){
		String retMsg=dialogsAndAlert.getAlertMessageThenAccept(element);
		assertThat(retMsg,equalTo(pageCore.getActualValueFromObjectRepository(msg)));
	}

	@Step
	public void verify_alert_message_be_text_then_dismiss_alert(String element, String msg){
		String retMsg=dialogsAndAlert.getAlertMessageThenDismiss(element);
		assertThat(retMsg,equalTo(pageCore.getActualValueFromObjectRepository(msg)));
	}
	
	@Step
	public void accept_alert(String element) {
		dialogsAndAlert.acceptAlert(element);
	}

	@Step
	public void enter_text_to_alert(String element, String answer) {
		dialogsAndAlert.enterTextToAlert(element,answer);
	}

	@Step
	public void dismiss_alert(String element) {
		dialogsAndAlert.dismissAlert(element);
	}
}
