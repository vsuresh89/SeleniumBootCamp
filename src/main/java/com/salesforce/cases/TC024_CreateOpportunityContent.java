package com.salesforce.cases;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC024_CreateOpportunityContent {
	
	@Test
	
	public void CreateOpportunityContent() throws InterruptedException {
		
		
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
		/*String actualTitle = driver.getTitle();
		String expectedTitle = "Lightning Experience";
		if(actualTitle!=expectedTitle) {
			driver.findElement(By.xpath("//div[@class='linkElements']//a")).click();
			Thread.sleep(2000);
		}
		Thread.sleep(3000);*/
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		Thread.sleep(3000);
		
		WebElement KD=				driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		driver.executeScript("arguments[0].click();",KD);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(@class,'triggerLinkText selectedListView')]")).click();
		Thread.sleep(2000);
		WebElement allOpp=driver.findElement(By.xpath("(//span[text()='All Opportunities'])[2]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", allOpp);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(3000);
		//8. Give Opportunity Name as SRM Steels
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input")).sendKeys("SRMS Steels");
		//9. Select Type as New Customer and Lead Source as Partner Referral
		driver.findElement(By.xpath("(//button[@data-value='--None--']//span)[2]")).click();
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		driver.findElement(By.xpath("(//button[@data-value='--None--']//span)[2]")).click();
		driver.findElement(By.xpath("//span[@title='Partner Referral']")).click();
		Thread.sleep(3000);
		//10. Give Amount as 75000 and Select Close Date as Next month 20th day 
		driver.findElement(By.xpath("//label[text()='Amount']/following::input")).sendKeys("75000");
		driver.findElement(By.xpath("//label[text()='Close Date']/following::input")).click();
		driver.findElement(By.xpath("//button[@title='Next Month']//lightning-primitive-icon[1]")).click();
		driver.findElement(By.xpath("//span[text()='20']")).click();
		Thread.sleep(3000);
	
		//11. Select Stage as Needs Analysis
		driver.findElement(By.xpath("(//button[@data-value='--None--']//span)[1]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		Thread.sleep(2000);
		
		//12. Click in Primary Campaign  Source and Select first option
		driver.findElement(By.xpath("//input[@placeholder='Search Campaigns...']")).click();
		driver.findElement(By.xpath("//span[@title='BootCamp'][1]")).click();
		Thread.sleep(2000);
		//13. Click Save and Verify the SRM Steels opportunity is created
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//Expected Result:
		//opportunity "SRM Steels" should be created with the given details
		Thread.sleep(3000);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(300));
		WebElement toast=driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"));
		String toastMsg=toast.getText();
		System.out.println("The Opportunity is created successfully:- " +toastMsg);	
			
		driver.close();
		driver.quit();
		
	}
}
