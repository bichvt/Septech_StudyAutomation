/**
 * 1. Verify element, click, type elements
URL: http://only-testing-blog.blogspot.in/2013/09/test.html
- Send key to textbox
- Click button
- Select checkbox/radio button
- Click link
- Back page
- Verify an element in table
- Study how to upload file (optional)
 */

package Study_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.InvalidSelectorException;

public class Selenium_BT1 {
	public static void main(String[] args) throws InterruptedException{
		//Init Driver
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://only-testing-blog.blogspot.in/2013/09/test.html";

		//Open the above URL
		driver.get(baseURL);

		//Send key to textbox
		driver.findElement(By.id("fname")).sendKeys("Vu Thi Bich");	
		Thread.sleep(5000);

		//Click button Submit Query
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);

		//Select 2 checkbox [I have a bike] and [I have a boat]
		driver.findElement(By.xpath("//*[@value='Bike']")).click();
		driver.findElement(By.xpath("//*[@value='Boat']")).click();

		//Select radio button Male
		driver.findElement(By.xpath("//*[@value='male']")).click();

		//Click link Home on the page
		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(5000);

		// Back page
		driver.navigate().back();

		//Verify an element =11 in Test table
		driver.findElement(By.xpath("//td[contains(.,'11')]"));
		System.out.println("Table on the page contains value = 11");

		//close the page
		// abc
		driver.close();
	}
}
