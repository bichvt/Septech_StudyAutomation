package auto.septech.coreactions;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DialogAndAlert extends PageCore{
	/**
	 * get message from alert popup, then accept alert
	 * @param element
	 * @return
	 */
	public String getAlertMessageThenAccept(String element){
		getWebElement(element).click();
		waitForAlert();
		String retMsg=getAlert().getText();
		getAlert().accept();
		return retMsg;
	}

	/**
	 * get message from alert popup, then dismiss alert
	 * @param element
	 * @return
	 */
	public String getAlertMessageThenDismiss(String element){
		getWebElement(element).click();
		waitForAlert();
		String retMsg=getAlert().getText();
		getAlert().dismiss();
		return retMsg;
	}
	
	/**
	 * Accept Alert
	 * @param element
	 */
	public void acceptAlert(String element) {
		getWebElement(element).click();
        waitForAlert();
		getAlert().accept();
	}
	
	/**
	 * Dismiss Alert
	 * @param element
	 */
	public void dismissAlert(String element) {
		getWebElement(element).click();
		waitForAlert();
		getAlert().dismiss();
	}

	/**
	 * Enter text to alert
	 * @param element
	 * @param text
	 */
	public void enterTextToAlert(String element, String text) {
		getWebElement(element).click();
		waitForAlert();
		getAlert().sendKeys(text);
		getAlert().accept();
	}

	/**
	 * Wait for alert
	 */
	private void waitForAlert(){
		new WebDriverWait(getDriver(), 60)
        .ignoring(NoAlertPresentException.class)
        .until(ExpectedConditions.alertIsPresent());
	}
	
	public boolean isAlertPresent(){
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(getDriver(), 5 /*timeout in seconds*/);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
}
