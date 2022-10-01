package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOpportunity extends ProjectSpecificMethodsSelBootCamp {
	
	
	
	@BeforeTest
	public void setData() {
		excelFileName="tc001";
	}
	
	
	@Test(dataProvider="Dynamic_Data")
	
	public void CreateOpportunity(String name) {
		
		
		
		
		WebElement opportunity=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]"));
		driver.executeScript("arguments[0].click();",opportunity);		
		driver.findElement(By.xpath("//div[@title='New']")).click();		
		WebElement getName=driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input"));
		getName.sendKeys(name);
		String oppname=getName.getAttribute("value");
				System.out.println(oppname);
		//System.out.println("Print the Opportunity Name"+getName.getText());
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-align_absolute-center')]")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		//Select dd=new Select(elementStage);
		//dd.selectByIndex(4);
		driver.findElement(By.xpath("//span[contains(@title,'Needs Analysis')]")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		
		//String validation=driver.findElement(By.xpath("//*[@slot='primaryField']")).getText();
		//Assert.assertEquals(name,validation);
		//WebElement opportunity1=
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement opportunity1=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]"));
		driver.executeScript("arguments[0].click();",opportunity1);
		//driver.executeScript("arguments[0].click();",opportunity1);
		WebElement val=driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		val.sendKeys("Vaishnavi",Keys.ENTER);
		driver.findElement(By.xpath("//span[@data-aura-class='forceInlineEditCell']")).getText();
		//driver.close();
		//driver.quit();
		
		
}
}
