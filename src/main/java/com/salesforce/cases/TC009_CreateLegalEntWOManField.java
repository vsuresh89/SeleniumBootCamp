package com.salesforce.cases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC009_CreateLegalEntWOManField {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement elementUsername=driver.findElement(By.id("username"));
		elementUsername.sendKeys("hari.radhakrishnan@qeagle.com");
		WebElement elementPassword=driver.findElement(By.id("password"));
		elementPassword.sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("legal");
		driver.findElement(By.xpath("//p[text()=' Entities']")).click();
		Thread.sleep(2000);
		
		WebElement LE=				driver.findElement(By.xpath("//div[@title='New']"));
		driver.executeScript("arguments[0].click();",LE);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@title='New']")).click();
		/*WebElement getName=driver.findElement(By.xpath("//span[text()='*']/following::input"));
		getName.sendKeys("Salesforce Automation by Vaishnavi");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();*/
		//7.Enter the Company name as 'Tetsleaf'.
		driver.findElement(By.xpath("//span[text()='Company Name']/following::input")).sendKeys("Testleaf");
		//8. Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("SalesForce");
					//9.Select Status as 'Active'
		WebElement st=driver.findElement(By.xpath("//a[@class='select']"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", st);
		WebElement status=driver.findElement(By.xpath("//a[@title='Active']"));
		status.click();
		driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();
		
		WebElement error=driver.findElement(By.xpath("//ul[contains(@class,'has-error uiInputDefaultError')]//li[1]"));
		String errorMsg=error.getText();
		System.out.println("Error Msg: "+errorMsg);
		 if(errorMsg.contains("Complete this field")) {
			 System.out.println("Enter the Mandatory Field");
		 }else
		 {
			 System.out.println("Account created successfully");
		 }
			
		

	}
}

