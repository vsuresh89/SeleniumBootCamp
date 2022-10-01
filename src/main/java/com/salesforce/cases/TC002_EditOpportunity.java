package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_EditOpportunity extends ProjectSpecificMethodsSelBootCamp {
	
	@BeforeTest
	public void setData() {
		excelFileName="tc002.xlsx";
	}
	
	@Test(dataProvider="Dynamic_Data")
	
	public void EditOpportunity(String name,String desc) {
		
		
		
		
		WebElement opportunity=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]"));
		driver.executeScript("arguments[0].click();",opportunity);		
		
		//driver.executeScript("arguments[0].click();",opportunity1);
		WebElement val=driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		val.sendKeys(name);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		val.sendKeys(Keys.ENTER);
		
		WebElement dropdown=				driver.findElement(By.xpath("//tbody/tr[1]//td[8]//a"));
		//dropdown.click();
		driver.executeScript("arguments[0].click();",dropdown);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement closeDate=driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click();",closeDate);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebElement today=
				driver.findElement(By.xpath("//label[text()='Close Date']/following::input"));
		//String date=today.getText();
		//int i=Integer.parseInt(date)+1;
		driver.findElement(By.xpath("//td[@data-value='2022-09-11']//span[1]")).click();
		
		WebElement stageDropdown = driver.findElement(By.xpath("//*[contains(@aria-label,'Stage,')]"));
        stageDropdown.click();
        WebElement needAnalysisValue = driver.findElement(By.xpath("//span[@title='Perception Analysis']"));
        needAnalysisValue.click();
        
		//driver.findElement(By.xpath("(//button[@data-value='--None--'])[3]")).click();
		//driver.findElement(By.xpath("//span[contains(@title,'In progress')]")).click();
        
        driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys(desc);
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
        
		
		
		
}
}
