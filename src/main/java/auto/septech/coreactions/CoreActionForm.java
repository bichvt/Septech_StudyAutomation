package auto.septech.coreactions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import auto.septech.utilities.TestLogger;
import org.openqa.selenium.JavascriptExecutor;
public class CoreActionForm extends PageCore {

	/*********checkbox/radio button********************/
	/**
	 * check checkbox
	 * @param element
	 */
	public void checkCheckbox(String element){
		getWebElement(element).click();
		if(!getWebElement(element).isSelected()){
			getWebElement(element).click();
		}
	}

	/**
	 * uncheck checkbox
	 * @param element
	 */
	public void uncheckCheckbox(String element){
		getWebElement(element).click();
		if(getWebElement(element).isSelected()){
			TestLogger.info("uncheck checkbox");
			getWebElement(element).click();
		}
	}

	/*********Select box and radio button********************/
	/**
	 * select value from drop down list by value
	 * @param valueOption
	 * @param element
	 */
	public void selectValueFromDropDownList(String valueOption, String element) {
		element(getWebElement(element)).selectByValue(valueOption);
	}

	/**
	 * select value from drop down list by index
	 * @param indexOption
	 * @param element
	 */
	public void selectIndexFromDropDownList(int indexOption, String element) {
		element(getWebElement(element)).selectByIndex(indexOption);
	}

	/**
	 * select value from drop down list by visible text
	 * @param textOption
	 * @param element
	 */
	public void selectTextFromDropDownList(String textOption, String element) {
		element(getWebElement(element)).selectByVisibleText(textOption);
	}

	/**
	 * select multi value
	 * @param listOption
	 * @param element
	 */
	public void addMultiSelectOptionsFromDropDownList(String listOption, String element) {
		WebElement select = element(getWebElement(element));
		java.util.List<WebElement> list = select.findElements(By.tagName("option"));
		String Data[] = listOption.split(",");
		for (int i = 0; i < Data.length; i++) {
			for (int j = 0; j < list.size(); j++){
				String str = list.get(j).getText();
				if (str.equalsIgnoreCase(Data[i])) {
					select.sendKeys(Keys.CONTROL);
					list.get(j).click();
					break;
				}
			}
		}
	}

	/**********click action***********************/
	/**
	 * click by javascript
	 */
	public void clickByJavascript(String element){
		WebElement onElement = element(getWebElement(element));
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", onElement);
	}

	/**
	 * press enter key
	 */
	public void pressEnterKey(){
		Actions action=new Actions(getDriver());
		action.sendKeys(Keys.ENTER).perform();
		action.release();
	}

	/**
	 * click on Element
	 * @param element
	 */
	public void clickOnElement(String element){
		WebElement onElement = element(getWebElement(element));
		if(!onElement.isEnabled()){
			TestLogger.info("click by javascript");
			clickByJavascript(element);
		}
		else
			onElement.click();
	}
	/**
	 * double click on element
	 * @param element
	 */
	public void doubleClickOnElement(String element) {
		WebElement onElement = element(getWebElement(element));
		withAction().doubleClick(onElement).perform();
	}

	/**
	 * right click
	 * @param element
	 */
	public void rightClickOnElement(String element) {
		WebElement link = element(getWebElement(element));
		withAction().contextClick(link).perform();
	}

	/**
	 * click and hold
	 * @param element
	 */
	public void clickAndHold(String element) {
		WebElement elementToMove = getWebElement(element);		
		Actions builder = new Actions(getDriver());
		Action drag = builder.clickAndHold(elementToMove).build();
		drag.perform();
	}

	/**
	 * right click and select index
	 * @param element
	 * @param indexItem
	 */
	public void rightClickOnTheAndClickOnItemHasIndex(String element, int indexItem) {
		try {
			WebElement link = element(getWebElement(element));
			Actions action = new Actions(getDriver());
			action.moveToElement(link).contextClick().perform();
			for(int i=1;i<=indexItem;i++){
				action.sendKeys(Keys.ARROW_DOWN);
			}
			action.sendKeys(Keys.ENTER).perform();
		} catch (MoveTargetOutOfBoundsException e) {
			e.getStackTrace();
		}
	}

	/**
	 * click at coordinates
	 * @param element
	 * @param xOffset
	 * @param yOffset
	 */
	public void clickOnTheAtCoordinates(String element, int xOffset, int yOffset) {
		WebElement toElement = element(getWebElement(element));
		withAction().moveToElement(toElement, xOffset, yOffset).click().perform();
	}

	/**
	 * double click at coordinates
	 * @param element
	 * @param xOffset
	 * @param yOffset
	 */
	public void doubleClickOnTheAtCoordinates(String element, int xOffset, int yOffset) {
		WebElement toElement = element(getWebElement(element));
		withAction().moveToElement(toElement, xOffset, yOffset).doubleClick().perform();
	}

	/**
	 * right click at coordinates
	 * @param element
	 * @param xOffset
	 * @param yOffset
	 */
	public void rightClickOnTheAtCoordinates(String element, int xOffset, int yOffset) {
		WebElement toElement = element(getWebElement(element));
		withAction().moveToElement(toElement, xOffset, yOffset).contextClick().perform();
	}

	/**
	 * right click at coordinates, then select index
	 * @param element
	 * @param xOffset
	 * @param yOffset
	 * @param indexItem
	 */
	public void rightClickTheAtCoordinatesAndClickOnItemHasIndex(String element, int xOffset, int yOffset,
			int indexItem) {
		try {
			WebElement link = element(getWebElement(element));
			Actions action = new Actions(getDriver());
			action.moveToElement(link,xOffset,yOffset).contextClick().perform();
			for(int i=1;i<=indexItem;i++){
				action.sendKeys(Keys.ARROW_DOWN);
			}
			action.sendKeys(Keys.ENTER).perform();
		} catch (MoveTargetOutOfBoundsException e) {e.getStackTrace();}
	}



	/********mouse over actions*************/
	/**
	 * drag and drop
	 * @param resouce
	 * @param des
	 * @param xOffset
	 * @param yOffset
	 * @throws AWTException
	 */
	public void dragAndDropElementHtml(String resouce, String des, int xOffset, int yOffset) throws AWTException{

		WebElement dragFrom = getWebElement(resouce);
		WebElement dragTo = getWebElement(des);

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension fromSize = dragFrom.getSize();
		Dimension toSize = dragTo.getSize();

		//Get center distance
		int xCentreFrom = fromSize.width / 2;
		int yCentreFrom = fromSize.height / 2;
		int xCentreTo = toSize.width / 2;
		int yCentreTo = toSize.height / 2;

		Point toLocation = dragTo.getLocation();
		Point fromLocation = dragFrom.getLocation();
		TestLogger.info(fromLocation.toString());

		//Make Mouse coordinate center of element
		toLocation.x += xOffset + xCentreTo;
		toLocation.y += yOffset + yCentreTo;
		fromLocation.x += xOffset + xCentreFrom;
		fromLocation.y += yOffset + yCentreFrom;

		TestLogger.info(fromLocation.toString());

		//Move mouse to drag from location
		robot.mouseMove(fromLocation.x, fromLocation.y);
		//Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(((toLocation.x - fromLocation.x) / 2) + fromLocation.x, ((toLocation.y - fromLocation.y) / 2) + fromLocation.y);

		//Move to final position
		robot.mouseMove(toLocation.x, toLocation.y);
		//Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	/**
	 * drag and drop
	 * @param resouce
	 * @param dest
	 */
	public void dragAndDropElement(String resouce, String dest) {

		WebElement elementToMove = getWebElement(resouce);
		Actions builder = new Actions(getDriver());
		Action drag = builder.clickAndHold(elementToMove).build();
		drag.perform();

		WebElement moveToElement = getWebElement(dest);
		Actions builder2 = new Actions(getDriver());
		Action dragAndDrop = builder2.moveToElement(moveToElement).release(moveToElement).build();
		dragAndDrop.perform();
	}

	/**
	 * move mouse action
	 * @param element
	 */
	public void moveMouse(String element) {
		WebElement moveToElement = getWebElement(element);

		Actions builder = new Actions(getDriver());
		Action dragAndDrop = builder.moveToElement(moveToElement).release(moveToElement).build();
		dragAndDrop.perform();
	}

	/**
	 * move mouse at coordinates
	 * @param element
	 * @param xOffset
	 * @param yOffset
	 */
	public void moveMouseToAtCoordinates(String element, int xOffset, int yOffset) {
		WebElement moveToElement = getWebElement(element);

		Actions builder = new Actions(getDriver());
		Action dragAndDrop = builder.moveToElement(moveToElement,xOffset,yOffset).release(moveToElement).build();
		dragAndDrop.perform();
	}
}
