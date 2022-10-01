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

public class TC021_EditTask extends ProjectSpecificMethodsSelBootCamp {
	@Test
	public void EditTask() throws InterruptedException {
								
		WebElement more=driver.findElement(By.xpath("//a[@title='Tasks']"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", more);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Show 9 more actions']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//7. Select todays date as Due date
		driver.findElement(By.xpath("//label[text()='Due Date']/following::input[1]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		//8. Select Priority as low
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		driver.findElement(By.xpath("//a[@title='Low']")).click();
		//10. Click save and verify Subject
		driver.findElement(By.xpath("//button[@title='Save']//span[1]")).click();
		//Expected Result:
		//Task is Edited Successfully  and Verification of the Subject is done
		
		Thread.sleep(3000);		
				
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(300));
		WebElement toast=driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small forceActionsText')]"));
		String toastMsg=toast.getText();
		System.out.println("The task is editted successfully:- " +toastMsg);
		//wait.until(ExpectedConditions.textToBePresentInElement(toast.getText(), "Vaishnavi"));
		
	}
}
