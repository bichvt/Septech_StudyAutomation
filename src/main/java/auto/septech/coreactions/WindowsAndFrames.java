package auto.septech.coreactions;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import auto.septech.utilities.TestLogger;
import net.thucydides.core.annotations.findby.By;

@SuppressWarnings("deprecation")
public class WindowsAndFrames extends PageCore{
	/**
	 * maximize windows
	 */
	public void maximizeWindows() {
		getDriver().manage().window().maximize();
	}

	/**
	 * forward page
	 */
	public void forwardPage() {
		getDriver().navigate().forward();
	}

	/**
	 * backward page
	 */
	public void backwardPage() {
		getDriver().navigate().back();
	}

	/**
	 * reload page
	 */
	public void reloadPage() {
		getDriver().navigate().refresh();
	}

	/**
	 * navigate to url
	 * @param url
	 */
	public void navigateToUrl(String url) {
		maximizeWindows();
		getDriver().navigate().to(url);
	}

	/**
	 * change size of window
	 * @param width
	 * @param height
	 */
	public void changeWindowSize(int width, int height) {
		getDriver().manage().window().setSize(new Dimension(width, height));
	}

	/**
	 * move Window
	 * @param x
	 * @param y
	 */
	public void moveWindowToNewPositionWithCoordinatesAtAndOnScreen(int x, int y) {
		getDriver().manage().window().setPosition(new Point(x, y));	
	}

	/**
	 * open page on new window
	 * @param url
	 */
	public void openPageOnNewWindow(String url) {
		maximizeWindows();
		defaultWindow = getDriver().getWindowHandle();
		TestLogger.info(url);
		evaluateJavascript("window.open('"+url+"', 'myD', 'fullscreen=yes');");
		getDriver().switchTo().window("myD");
	}

	/**
	 * close current window
	 */
	public void closeCurrentWindow() {
		getDriver().close();
	}

	/**
	 * switch default window
	 */
	public void switchOldWindow() {
		getDriver().switchTo().window(defaultWindow);
	}

	/**
	 * open link in a new window
	 * @param linkText
	 */
	public void openLinkInANewWindowAndSwitchToIt(String linkText) {
		try {
			Actions act = new Actions(getDriver());
			WebElement onElement = getDriver().findElement(org.openqa.selenium.By.linkText(linkText));
			act.contextClick(onElement).perform();
			act.sendKeys("w").perform(); 
			Thread.sleep(1000);
		} catch (MoveTargetOutOfBoundsException e) {e.getStackTrace();
		} catch (InterruptedException e) {e.printStackTrace();}
		//handle windows change
		String defaultWindow = getDriver().getWindowHandle();
		Set<String> set = getDriver().getWindowHandles();
		set.remove(defaultWindow);
		assert set.size() == 1;
		getDriver().switchTo().window((String) set.toArray()[0]);
	}

	/**
	 * clickToOpenWindowAndSwitchToIt
	 * @param element
	 */
	public void clickToOpenWindowAndSwitchToIt(String element) {
		getWebElement(element).click();
		defaultWindow = getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
		tabs.remove(defaultWindow);
		getDriver().switchTo().window( tabs.get(0));
		
	}
	
	/**
	 * scroll screen
	 * @param x
	 * @param y
	 */
	public void scrollScreen(int x, int y) {
		evaluateJavascript("window.scrollTo("+x+", "+y+");");
	}
	
	/**
	 * switch to iframe
	 * @param iframeName
	 */
	public void switchToIFrame(String iframeName) {
		WebElement webElement = getWebElement(iframeName);
		getDriver().switchTo().frame(webElement);
	}

	/**
	 * switch back to paren frame
	 */
	public void swichBackToParentFrame() {
		getDriver().switchTo().parentFrame();
	}

	/**
	 * switch back to main frame
	 */
	public void swichBackToMainFrame() {
		getDriver().switchTo().defaultContent();
	}
}
