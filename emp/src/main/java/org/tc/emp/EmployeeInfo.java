package org.tc.emp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeInfo {
	File file;
	FileInputStream fileInput;
	ChromeDriver driver=new ChromeDriver();
	Properties prop = new Properties();
	
	@BeforeTest
	public void openBrowser() throws InterruptedException {
		file = new File("D:\\satya\\selenium\\emp\\emp\\src\\main\\resources\\employee.properties");
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		  }
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		  }
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	}
	
	//Employees
	
	@Test (priority=0)
	public void salary() throws InterruptedException {
		Thread.sleep(1000);
		//salary btn
		driver.findElement(By.xpath(prop.getProperty("SALARYBUTTON"))).click();
		Thread.sleep(500);
		//old salary btn
		driver.findElement(By.xpath(prop.getProperty("OLDSALARTRECORDS"))).click();
		//add salary button
	   Thread.sleep(500);
		driver.findElement(By.xpath(prop.getProperty("ADDSALARYBUTTON"))).click();
		Thread.sleep(500);
		//salary amount
		driver.findElement(By.xpath(prop.getProperty("SALARYAMOUNT"))).sendKeys("50000");
		//submit
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("SALARYSUBMIT"))).click();
		Thread.sleep(1000);
		//go to main menu
		driver.findElement(By.xpath(prop.getProperty("MAINMENU"))).click();
		driver.findElement(By.xpath(prop.getProperty("EMPLOYEES"))).click();
	}
	
	@Test (priority=1)
	public void advance() throws InterruptedException {
			Thread.sleep(5000);
			//advance button
		driver.findElement(By.xpath(prop.getProperty("SALARYADVANCE"))).click();
		Thread.sleep(3000);
		//give advance button
		driver.findElement(By.xpath(prop.getProperty("GIVEADVANCE"))).click();
		//advance amount
		driver.findElement(By.xpath(prop.getProperty("ADVANCEAMOUNT"))).sendKeys("500");
		//description
		driver.findElement(By.xpath(prop.getProperty("DESCRIPTION"))).sendKeys("personal");
		Thread.sleep(1000);
		//submit
		driver.findElement(By.xpath(prop.getProperty("ADVANCESUBMITBUTTON"))).click();
		//close
		driver.findElement(By.xpath(prop.getProperty("ADVANCECLOSE"))).click();
		//show all
		driver.findElement(By.xpath(prop.getProperty("SHOWALLBUTTON"))).click();
		Thread.sleep(1000);
		//show all close
		driver.findElement(By.xpath(prop.getProperty("SHOWALLBUTTONCLOSE"))).click();
		Thread.sleep(1000);
		//main menu
		driver.findElement(By.xpath(prop.getProperty("MAINMENU"))).click();
		driver.findElement(By.xpath(prop.getProperty("EMPLOYEES"))).click();
		Thread.sleep(300);
	}
	@Test (priority=2)
	public void updateEmpProfile() throws InterruptedException {
		//update button
		Thread.sleep(300);
		
		driver.findElement(By.xpath(prop.getProperty("UPDATEBUTTON"))).click();
		//emp name
		driver.findElement(By.xpath(prop.getProperty("EMPLOYEENAME"))).clear();
		Thread.sleep(500);
		driver.findElement(By.xpath(prop.getProperty("EMPLOYEENAME"))).sendKeys(" nath");
		Thread.sleep(500);
		//submit
		driver.findElement(By.xpath(prop.getProperty("UPDATESUBMITBUTTON"))).click();
		Thread.sleep(500);
	}
	@Test (priority=3)
	public void addEmployee() throws InterruptedException {
		driver.navigate().refresh();
		//add emp btn
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("ADDEMPBUTTON"))).click();
		//name
		driver.findElement(By.xpath(prop.getProperty("EMP_NAME"))).sendKeys("satya");
		//email
		driver.findElement(By.xpath(prop.getProperty("EMP_EMAIL"))).sendKeys("satya@gmail.com");
		//mobile
		driver.findElement(By.xpath(prop.getProperty("EMP_MOBILE"))).sendKeys("9052929220");
		//address
		driver.findElement(By.xpath(prop.getProperty("EMP_ADDRESS"))).sendKeys("Gudivada");
		//Alt contact
		driver.findElement(By.xpath(prop.getProperty("ALT_CONTACT"))).sendKeys("9849308016");
		//emg contact
		driver.findElement(By.xpath(prop.getProperty("EMG_CONTACT"))).sendKeys("9848055225");
		//emg contact name
		driver.findElement(By.xpath(prop.getProperty("EMG_CONTACT_NAME"))).sendKeys("hussi");
		Thread.sleep(1000);
		//submit 
		driver.findElement(By.xpath(prop.getProperty("EMP_SUBMIT_BUTTON"))).click();
		}
	@Test (priority=4,enabled=false)
	public void delete() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("EMP_DELETE"))).click();
	}
	
	//Attandance
	
	@Test (priority=5)
	public void attendance() throws InterruptedException {
		//main menu
		driver.findElement(By.xpath(prop.getProperty("MAINMENU"))).click();
		driver.findElement(By.xpath(prop.getProperty("ATTENDENCE"))).click();
		// date between two dates
		driver.findElement(By.xpath(prop.getProperty("START_END_DATE"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("START_DATE"))).click();
		Thread.sleep(200);
		driver.findElement(By.xpath(prop.getProperty("END_DATE"))).click();
		Sleeper.sleepTightInSeconds(5);
		//select leave day 
		driver.findElement(By.xpath(prop.getProperty("SELECT_ALL"))).click();
		driver.findElement(By.xpath(prop.getProperty("SELECT_SUNDAY"))).click();
		Sleeper.sleepTightInSeconds(5);
		//absent
		driver.findElement(By.xpath(prop.getProperty("PERSONAL_LEAVE"))).click();
		//attandance submit
		driver.findElement(By.xpath(prop.getProperty("ATTANDANCE_SUBMIT"))).click();
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
}
