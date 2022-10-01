package com.salesforce.cases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_CreateAccount extends ProjectSpecificMethodsSelBootCamp {
	
	@BeforeTest
	public void setData() {
		excelFileName="tc004_CreateAccount";
	}
	
	@Test(dataProvider="Dynamic_Data")
	
	public void CreateAccount(String name) throws InterruptedException {
		
		
		
		Thread.sleep(2000);
		WebElement account=				driver.findElement(By.xpath("(//span[@class='slds-truncate'])[9]"));
		driver.executeScript("arguments[0].click();",account);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement getName=driver.findElement(By.xpath("//label[text()='Account Name']/following::input"));
		getName.sendKeys(name);
		String accountName=driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).getText();
		driver.findElement(By.xpath("(//span[text()='--None--'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String verifyName=driver.findElement(By.xpath("//div[contains(@class,'testonly-outputNameWithHierarchyIcon slds-grid')]//lightning-formatted-text[1]")).getText();
		System.out.println(verifyName);
		
		String expectedText="Vaishnavi";
		Assert.assertEquals(verifyName,expectedText );
		
		//driver.close();
		//driver.quit();
		
		}
}