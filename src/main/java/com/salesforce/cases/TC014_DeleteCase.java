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

public class TC014_DeleteCase extends ProjectSpecificMethodsSelBootCamp {
	@Test
	public void DeleteCase() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//one-app-nav-bar-menu-button[contains(@class,'slds-grid slds-grid_vertical-stretch')]//a")).click();
		Thread.sleep(2000);
		
		WebElement more=driver.findElement(By.xpath("(//a[@href='/lightning/o/Case/home'])[2]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", more);
		driver.findElement(By.xpath("(//label[text()='Search this list...']/following::input)[1]")).sendKeys("00001055"+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr/td[7]/span")).click();
	driver.findElement(By.xpath("//a[@title='Delete']")).click();
	Thread.sleep(4000);
				
			driver.findElement(By.xpath("//button[@title='Delete']")).click();
			driver.findElement(By.xpath("(//label[text()='Search this list...']/following::input)[1]")).clear();
			driver.findElement(By.xpath("(//label[text()='Search this list...']/following::input)[1]")).sendKeys("00001055"+Keys.ENTER);
			Thread.sleep(3000);
			WebElement errorMsg=driver.findElement(By.xpath("//span[text()='No items to display.']"));
			String Msg = errorMsg.getText();
			System.out.println(Msg);
			

			if(Msg.contains("No items to display."))
					
			  {
				System.out.println("Case is Deleted");  
			  }
			  else {
				  System.out.println("Case is not Deleted");
			  }
			
			driver.close();
			driver.quit();
				
	}
}
