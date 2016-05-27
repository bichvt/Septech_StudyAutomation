/**
 * 2. Register account
URL: http://live.guru99.com/index.php/customer/account/create/
- Điền các thông tin cần thiết vào form
- Click "Register" button
- Điền giá trӏ để verify 2 trường hợp:
+ Đăng ký thành công
+ Đăng ký thất bại
 */
package Study_Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.InvalidSelectorException;


public class Selenium_BT2 {
	public static void main(String[] args) throws InterruptedException{
		//Init driver
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://live.guru99.com/index.php/customer/account/create/";

		//Open URL
		driver.get(baseUrl);

		/** TC1: Nhap thông tin ko hợp lệ để đăng kí thất bại */
		driver.findElement(By.id("firstname")).sendKeys("Vu Thi"); //Fill First name
		driver.findElement(By.id("lastname")).sendKeys("Bich"); //Fill Last name
		driver.findElement(By.id("email_address")).sendKeys("bichvt233@gmail.com"); //Fill Email Address đã được dăng kí trước đó
		driver.findElement(By.id("password")).sendKeys("123456789"); //Fill Password
		driver.findElement(By.id("confirmation")).sendKeys("123456789"); // Fill Confirm Password
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Register']")).click(); //Click "Register" button
		Thread.sleep(5000);
		if(driver.getPageSource().contains("There is already an account with this email address"))
			System.out.println("1. Ko thể đăng kí do trùng địa chỉ email. Test case 1 pass");
		else
			System.out.println("Test case 1 not pass");

		/** TC2: Nhập các thông tin hợp lệ để đăng kí thành công */
		//Xóa địa chỉ mail cũ và giữ nguyên các thông tin đã fill trước đấy
		driver.findElement(By.id("email_address")).clear();
		driver.findElement(By.id("email_address")).sendKeys("bichvt2334@gmail.com"); //Fill Email Address chưa được đăng kí bao giờ
		driver.findElement(By.id("password")).sendKeys("123456789"); //Fill Password
		driver.findElement(By.id("confirmation")).sendKeys("123456789"); // Fill Confirm Password
		driver.findElement(By.xpath("//button[@title='Register']")).click(); //Click "Register" button
		Thread.sleep(5000);
		if(driver.getPageSource().contains("Thank you for registering with Main Website Store"))
			System.out.println("2. Register successfully. Test case 2 pass");
		else
			System.out.println("Test case 2 not pass");

		//close the page
		driver.close();
	}

}
