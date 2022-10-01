package com.salesforce.cases;

	

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TC003_DeleteOpportunity extends ProjectSpecificMethodsSelBootCamp {
		
		@Test
		
		public void DeleteOpportunity() throws InterruptedException {
			
			
			
			
			WebElement opportunity=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]"));
			driver.executeScript("arguments[0].click();",opportunity);		
			
			//driver.executeScript("arguments[0].click();",opportunity1);
			WebElement val=driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
			val.sendKeys("Vaishnavi");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			val.sendKeys(Keys.ENTER);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement dropdown=				driver.findElement(By.xpath("//tbody/tr[1]//td[8]//a"));
			//dropdown.click();
			driver.executeScript("arguments[0].click();",dropdown);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//a[@title='Delete']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Delete']")).click();
			//driver.close();
			//driver.quit();
			
		}
	}
