package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC013_EditCase extends ProjectSpecificMethodsSelBootCamp {
	@Test
	public void EditCase() throws InterruptedException {
		
		
		
		driver.findElement(By.xpath("//one-app-nav-bar-menu-button[contains(@class,'slds-grid slds-grid_vertical-stretch')]//a")).click();
		Thread.sleep(2000);
		
		WebElement more=driver.findElement(By.xpath("(//a[@href='/lightning/o/Case/home'])[2]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", more);
		driver.findElement(By.xpath("(//label[text()='Search this list...']/following::input)[1]")).sendKeys("00001066"+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr/td[7]/span")).click();
	driver.findElement(By.xpath("//a[@title='Edit']")).click();
	Thread.sleep(4000);
	WebElement st=driver.findElement(By.xpath("//button[@data-value='Escalated']"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", st);
		Thread.sleep(2000);
		WebElement status=driver.findElement(By.xpath("//span[@title='Working']"));
		status.click();
		String sta=status.getText();
		driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Low']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='select'])[3]")).click();
		driver.findElement(By.xpath("//a[@title='Phone']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-interactive-uid='12']//a[1]")).click();
		driver.findElement(By.xpath("//a[@title='No']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();
		Thread.sleep(3000);
		WebElement link=driver.findElement(By.xpath("//tbody/tr[1]/th/span/a"));
		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
		executor5.executeScript("arguments[0].click();", link);
		Thread.sleep(3000);
		WebElement statusValidation=driver.findElement(By.xpath("(//p[contains(@class,'fieldComponent slds-text-body--regular')]//lightning-formatted-text)[2]"));
		String staVal=statusValidation.getText();
		System.out.println("The value of status: "+staVal);
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(300));
		//WebElement toast=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a"));
		if(sta==staVal) {
			System.out.println("Case is editted and Status is verified as Working successfully");
		}else {
			System.out.println("Status is not verified as Working successfully");
		}
		driver.close();
		driver.quit();
		
	}
}
