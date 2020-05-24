package demo;

import java.awt.Menu;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public Menu menu=null;
	public Login(WebDriver driver) {
		menu=PageFactory.initElements(driver, Menu.class);
	}
	@FindBy(id="txtUsername") WebElement userName;
	@FindBy (id="txtPassword") WebElement password;
	@FindBy (id="btnLogin") WebElement loginBtn;
	
	public void login(String user,String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
	}

}
