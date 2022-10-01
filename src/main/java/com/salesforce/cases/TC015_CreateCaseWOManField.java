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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC015_CreateCaseWOManField extends ProjectSpecificMethodsSelBootCamp {
	@Test
	public void CreateCaseWOManField() throws InterruptedException {
		
		
		
		driver.findElement(By.xpath("//one-app-nav-bar-menu-button[contains(@class,'slds-grid slds-grid_vertical-stretch')]//a")).click();
		Thread.sleep(2000);
		WebElement more=driver.findElement(By.xpath("(//a[@href='/lightning/o/Case/home'])[2]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", more);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'primaryLabel slds-truncate')])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-value='New']")).click();
		driver.findElement(By.xpath("//span[@title='--None--']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Subject'])[2]/following::input")).sendKeys("Testing");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("Automated Testing");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
					
		
		
		WebElement error=driver.findElement(By.xpath("//ul[@class='errorsList']//li[1]"));
		String errorMsg=error.getText();
		System.out.println("Error Msg: "+errorMsg);
		 if(errorMsg.contains("These required fields must be completed:")) {
			 System.out.println("Enter the Mandatory Field");
		 }else
		 {
			 System.out.println("Case created successfully");
		 }
			
		 driver.close();
			driver.quit();
			

	}
}

