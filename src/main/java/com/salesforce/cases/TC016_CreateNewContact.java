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

public class TC016_CreateNewContact extends ProjectSpecificMethodsSelBootCamp {
	@Test
	public void CreateNewContact() throws InterruptedException {
						
		
		WebElement more=driver.findElement(By.xpath("//a[@href='/lightning/o/Contact/home']//span[1]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", more);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		//6) Pick Salutation as 'Mr.'
		driver.findElement(By.xpath("//button[@data-value='--None--']")).click();
		driver.findElement(By.xpath("//span[@title='Ms.']")).click();
		Thread.sleep(2000);
		//7) Enter First Name as 'Naveen'
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Vaishnavi");
		//driver.findElement(By.xpath("//span[@title='Mr.']")).click();
		Thread.sleep(2000);
		//8) Enter Last Name as 'Elumalai'
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Suresh");
		//9) Enter email as 'naveen@test.com'
		driver.findElement(By.xpath("//input[@inputmode='email']")).sendKeys("vaishnavi@test.com");
		//10) Create a New Account for Account Name
		driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).click();
		driver.findElement(By.xpath("//span[@title='New Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='*']/following::input")).sendKeys("Credits");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		//11) Enter account name as 'Credits' and save
		
		//12) Click and save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//13) Verify contact using Unique name and print the name

		//Expected Result:
		//contact verfied using unique name	
		
		Thread.sleep(2000);
				
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(300));
		WebElement toast=driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"));
		String toastMsg=toast.getText();
		System.out.println("The contact created successfully:- " +toastMsg);
		//wait.until(ExpectedConditions.textToBePresentInElement(toast.getText(), "Vaishnavi"));
		driver.close();
		driver.quit();
		
	}
}
