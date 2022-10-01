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

public class TC006_DeleteAccount extends ProjectSpecificMethodsSelBootCamp {
	
	@Test
	
	public void DeleteAccount() throws InterruptedException {
		
		
		
		Thread.sleep(2000);
		WebElement account=				driver.findElement(By.xpath("(//span[@class='slds-truncate'])[9]"));
		driver.executeScript("arguments[0].click();",account);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Vaishnavi"+Keys.ENTER);
		Thread.sleep(2000);
		//name.sendKeys(Keys.ENTER);
		
		//WebElement dropdown=				driver.findElement(By.xpath("//tbody/tr[1]/td[6]//ul[1]"));
		//dropdown.click();
		/*WebElement dropdown=driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", dropdown);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Delete']//span[1]")).click();
		Thread.sleep(2000);*/
		
		//7. Verify Whether account is Deleted using account Name
		//driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(Keys.ENTER);
		WebElement errorMsg=driver.findElement(By.xpath("//span[text()='No items to display.']"));
		String Msg = errorMsg.getText();
		System.out.println(Msg);
		

		if(Msg.contains("No items to display."))
				
		  {
			System.out.println("Account is Deleted");  
		  }
		  else {
			  System.out.println("Account is not Deleted");
		  }
		
		/*Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String verifyName=driver.findElement(By.xpath("//div[contains(@class,'testonly-outputNameWithHierarchyIcon slds-grid')]//lightning-formatted-text[1]")).getText();
		System.out.println(verifyName);
		
		String expectedText="Vaishnavi";
		Assert.assertEquals(verifyName,expectedText );*/
		
		driver.close();
		driver.quit();
		
		}
}