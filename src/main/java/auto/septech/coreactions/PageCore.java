package auto.septech.coreactions;
import org.openqa.selenium.JavascriptExecutor;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import auto.septech.utilities.ObjectMap;
import auto.septech.utilities.TestLogger;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://admin.smaport.stg/")
public class PageCore extends PageObject {

	public static Properties properties;

	String defaultWindow="";
	public PageCore() {
		properties = ObjectMap.loading_object_properties_from_package("objects");
	}
	/**
	 * maximize page
	 */
	public void maximizeBrowser(){
		getDriver().manage().window().maximize();
	}
	
	/**
	 * open the page
	 * @throws IOException 
	 */
	public void openThePage(){
		maximizeBrowser();
		open();
	}
	
	/**
	 * get location of element
	 * @param target
	 * @return
	 */
	public String getActualValueFromObjectRepository(String target){
		return ObjectMap.getActualValueFromObjectRepository(target);
	}
	
	/**
	 * Scroll to a element on the website
	 * @param element
	 * @param driver
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/**
	 * runJquery
	 * @param jquery
	 * @return
	 */
	public String runJquery(String jquery) {
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		String response = jse.executeScript(jquery).toString();
		return response;
	}
	
	/**
	 * get element
	 * @param target
	 * @return
	 */
	public WebElement getWebElement(String target) {
		try {
			//String locator = OBJECT.getProperty(target);
			TestLogger.info(getObject(getActualValueFromObjectRepository(target).toString()));
			return getDriver().findElement(getObject(getActualValueFromObjectRepository(target)));
			//return getDriver().findElement(getObject(target));

		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return null;
	}

	/**
	 * get list elements
	 * @param target
	 * @return
	 */
	public List<WebElement> getWebElements(String target){
		try {
			Thread.sleep(1000);
			return getDriver().findElements(getObject(ObjectMap.getActualValueFromObjectRepository(target)));

		} catch (NoSuchElementException | InterruptedException e) {
			e.getMessage();
		}
		return null;
	}

	/**
	 * get locator 
	 * @param locator
	 * @return
	 */
	public By getObject(String locator) {
		By by = null;
		try {
			if (locator.startsWith("id=")) {

				locator = locator.substring(3);
				by = By.id(locator);

			} else if (locator.startsWith("name=")) {

				locator = locator.substring(5);
				by = By.name(locator);

			} else if (locator.startsWith("css=")) {

				locator = locator.substring(4);
				by = By.cssSelector(locator);

			} else if (locator.startsWith("linkText=")) {

				locator = locator.substring(5);
				by = By.linkText(locator);

			} else if (locator.startsWith("xpath=")) {
				locator = locator.substring(6);
				by = By.xpath(locator);
			}
			else{
				by = By.xpath(locator);
			}

			return by;
		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	/**
	 * get current page url
	 * @return
	 */
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	/**
	 * get enable status of element
	 * @param element
	 * @return true: enable
	 * 			false: disable
	 */
	public boolean getEnableStatusOfElement(String element) {
		return element(getWebElement(element)).isEnabled();
	}

	/**
	 * get present status of element
	 * @param element
	 * @return true: present
	 * 			false: absent
	 */
	public boolean getPresentStatusOfElement(String element) {
		return element(getWebElement(element)).isPresent();
	}

	/**
	 * get visibility status of element
	 * @param element
	 * @return true: visible
	 * 			false: hidden
	 */
	public boolean getVisibleStatusOfElement(String element) {
		return element(getWebElement(element)).isVisible();
	}

	/**
	 * get current selected text from listbox
	 * @param element
	 * @return
	 */
	public String getSelectedVisibleTextValue(String element) {
		return element(getWebElement(element)).getSelectedVisibleTextValue();
	}

	/**
	 * get value of element
	 * @param element
	 * @return
	 */
	public String getCurrentValueOfElement(String element) {
		return  element(getWebElement(element)).getValue().trim();
	}	

	/**
	 * get text of element
	 * @param element
	 * @return
	 */
	public String getCurrentTextOfElement(String element) {
		return  element(getWebElement(element)).getText().trim();
	}

	/**
	 * wait until element to be clickable
	 * @param element
	 */
	public void waitUntilElementTobeClickable(String element) {
		new WebDriverWait(getDriver(), 60)
		.ignoring(NoAlertPresentException.class)
		.until(ExpectedConditions.elementToBeClickable(getWebElement(element)));
	}

	/**
	 * wait until element visible
	 * @param element
	 */
	public void waitUntilElementVisibility(String element) {
		new WebDriverWait(getDriver(), 60)
		.ignoring(NoAlertPresentException.class)
		.until(ExpectedConditions.visibilityOf(getWebElement(element)));
	}

	/**
	 * wait for text appear
	 * @param element
	 * @param value
	 */
	public void waitForTextToAppear(String element, String value) {
		waitForTextToAppear(getWebElement(element), value);
	}

	/**
	 * set attribute for element
	 * @param attributeName
	 * @param element
	 * @param value
	 */
	public void setAttribute(String attributeName, String element, String value) {
		WebElement webElement = getWebElement(element);
		evaluateJavascript("arguments[0].setAttribute(arguments[1], arguments[2])", webElement, attributeName, value);
	}
	
	/**
	 * get attribute of element
	 * @param attrName
	 * @param element
	 * @return
	 */
	public String getAttribute(String attrName,String element){
		return getWebElement(element).getAttribute(attrName);
	}

	/**
	 * capture element
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public File captureElementBitmap( String element) throws Exception {

		File screen = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		WebElement webElemet = getWebElement(element);
		// Create an instance of Buffered Image from captured screenshot
		BufferedImage img = ImageIO.read(screen);

		// Get the Width and Height of the WebElement using getSize()
		int width = webElemet.getSize().getWidth();
		int height = webElemet.getSize().getHeight();

		// Create a rectangle using Width and Heights
		Rectangle rect = new Rectangle(width, height);

		// Get the Location of WebElement in a Point.
		// This will provide X & Y co-ordinates of the WebElement
		Point p = webElemet.getLocation();

		// Create image by_class for element using its location and size.
		// This will give image data specific to the WebElement
		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);

		// Write back the image data for element in File object
		ImageIO.write(dest, "png", screen);

		// Return the File object containing image data
		return screen;
	}

	/**
	 * highlight element
	 * @param element
	 */
	public  void highlightElement(String element) {
		WebElement webElement = getWebElement(element);
		for (int i = 0; i < 10; i++) {
			evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", webElement,
					"color: green; border: 2px solid green;");
			evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", webElement, "");
		}
	}

	/**
	 * set bounds
	 * @param element
	 */
	public void setBounds(String element) {
		WebElement webElement = getWebElement(element);
		evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", webElement,
				"color: red; border: 3px solid red;");
	}
	
	/**
	 * get number in string
	 * @param value
	 * @return
	 */
	public String getNumberInString(String value){
		String numberOnly= value.replaceAll("[^0-9.]", "");
		return numberOnly;
	}
}