package com.salesforce.cases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_CreateLegalEntity {
	
	@Test
	
	public void CreateLegalEntity() throws InterruptedException {
		
		
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
		WebElement getName=driver.findElement(By.xpath("//span[text()='*']/following::input"));
		getName.sendKeys("Salesforce Automation by Vaishnavi");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();
			
		String nameLegal=getName.getText();
		System.out.println(nameLegal);
		WebElement createLegalName = driver.findElement(By.xpath("//span[contains(@class,'test-id__field-value slds-form-element__static')]"));
				String CLN = createLegalName.getText();
		
		if(CLN==nameLegal) {
			System.out.println("The Legal Entity is created Successfully");
		}else {
			System.out.println("The Legal Entity is not created Successfully");
		}
		driver.close();
		driver.quit();
		
	}
}
