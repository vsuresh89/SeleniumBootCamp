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

public class TC020_CreateNewTask extends ProjectSpecificMethodsSelBootCamp {
	@Test
	public void CreateNewTask() throws InterruptedException {
								
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
		
		driver.findElement(By.xpath("//div[@role='none']//input[1]")).sendKeys("Bootcamp");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@data-interactive-lib-uid='3']")).click();
		driver.findElement(By.xpath("//a[@title='Waiting on someone else']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();	
		
		Thread.sleep(2000);
				
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(300));
		WebElement toast=driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"));
		String toastMsg=toast.getText();
		System.out.println("The task is created successfully:- " +toastMsg);
		//wait.until(ExpectedConditions.textToBePresentInElement(toast.getText(), "Vaishnavi"));
		
	}
}
