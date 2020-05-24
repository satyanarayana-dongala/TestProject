package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPoi  {
	ChromeDriver driver=new ChromeDriver();
	Login login;
	@BeforeTest
	public void open() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@Test 
	public void data() {
		login=PageFactory.initElements(driver, Login.class);
		login.login("Admin", "admin123");
	}
}
