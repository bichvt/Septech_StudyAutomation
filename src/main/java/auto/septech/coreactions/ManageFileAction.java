package auto.septech.coreactions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import auto.septech.utilities.TestLogger;

public class ManageFileAction extends PageCore{
	
	/**
	 * set clipboard
	 * @param string
	 */
	private void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	/**
	 * upload file using robot
	 * @param fileLocation
	 */
	public void uploadFileUsingRobot(String fileLocation) {
        try {
        	//Setting clip board with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }

	/**
	 * upload file using javascript
	 * @param element
	 * @param fileLocation
	 * @throws InterruptedException
	 */
	public void uploadFileUsingJavascript(String element, String fileLocation) throws InterruptedException{
		TestLogger.info("Attach a file");
		String fs = File.separator;
		WebElement elem=getWebElement(element);
		fileLocation=System.getProperty("user.dir")+fileLocation.replace("/", fs).replace("\\", fs);
		TestLogger.info(fileLocation);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.display = 'block';", elem);
		elem.sendKeys(fileLocation);
		Thread.sleep(5000);
	}
}
