package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC022_CreateNewTaskWOManField extends ProjectSpecificMethodsSelBootCamp {
	@Test
	public void CreateNewTaskWOManField() throws InterruptedException {
								
		/*WebElement more=driver.findElement(By.xpath("//a[@title='Tasks']"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", more);
		Thread.sleep(3000);*/
		driver.findElement(By.xpath("(//span[text()='Tasks'])[1]//following::lightning-primitive-icon[1]")).click();
		Thread.sleep(3000);
		WebElement newtask=driver.findElement(By.xpath("//span[text()='New Task']"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", newtask);
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("//div[text()='Vaishnavi Suresh']/following-sibling::div")).click();
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("SALES FORCE Automation Using Selenium");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();	
		
		Thread.sleep(2000);
				
		WebElement error=driver.findElement(By.xpath("//ul[@class='errorsList']//li[1]"));
		String errorMsg=error.getText();
		System.out.println("Error Msg: "+errorMsg);
		 if(errorMsg.contains("fields must be completed")) {
			 System.out.println("Enter the Mandatory Field");
		 }else
		 {
			 System.out.println("Task created successfully");
		 }
		//wait.until(ExpectedConditions.textToBePresentInElement(toast.getText(), "Vaishnavi"));
		
	}
}
