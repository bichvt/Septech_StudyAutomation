/**
 * 3. Login/Logout
URL: http://live.guru99.com
- Điền các thông tin cần thiết vào form
- Click “Login" button
- Điền giá trӏ để verify 2 trường hợp:
+ Login thành công
+ Login thất bại
- Logout
 */

package Study_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.InvalidSelectorException;

public class Selenium_BT3 {
	public static void main(String[] args) throws InterruptedException{
		// Init driver
		WebDriver driver = new FirefoxDriver();
		String baseUrl="http://live.guru99.com/index.php/customer/account/login/";

		//Open URL
		driver.get(baseUrl);

		/** TC1: Nhap mail và pass ko hợp lệ để login ko thành công */
		driver.findElement(By.id("email")).sendKeys("email@gmail.com"); //fill email
		driver.findElement(By.id("pass")).sendKeys("12345678"); //fill password
		driver.findElement(By.xpath("//button[@id='send2']")).click(); //click Login button
		Thread.sleep(5000);
		String expectLogin1 = "Invalid login or password";
		Boolean actualLogin1;
		actualLogin1 = driver.getPageSource().contains("Invalid login or password"); //get actualLogin
		if(driver.getPageSource().contains(expectLogin1)==actualLogin1)
			System.out.println("Not can login. Test case 1 pass");
		else
			System.out.println("Test case 1 fail");

		/** Xóa email và password đã nhập trước đó */
		driver.findElement(By.id("email")).clear(); //xóa email đã nhập
		driver.findElement(By.id("pass")).clear(); //xóa password đã nhập

		/** TC2: Nhap email và password hợp lệ để login thành công */
		driver.findElement(By.id("email")).sendKeys("bichvt233@gmail.com"); //fill email đã được đăng kí thành công
		driver.findElement(By.id("pass")).sendKeys("123456789"); // fill password đã đăng kí thành công
		driver.findElement(By.xpath("//button[@id='send2']")).click(); //click button Login
		Thread.sleep(5000);
		String expectLogin2 = "My Account";
		String actualLogin2="";
		//get actualLogin
		actualLogin2 = driver.getTitle();
		if(actualLogin2.contentEquals(expectLogin2))
			System.out.println("Login thành công. Test case 2 pass");
		else
			System.out.println("Test case 2 fail");

		//close the page
		driver.close();
	}
}
