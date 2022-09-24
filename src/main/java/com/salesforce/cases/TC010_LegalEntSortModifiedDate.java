package com.salesforce.cases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC010_LegalEntSortModifiedDate {
	
	public static void main(String[] args) throws InterruptedException {
		
		
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
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("legal");
		driver.findElement(By.xpath("//p[text()=' Entities']")).click();
		Thread.sleep(2000);
		
		WebElement elementTable = driver.findElement(By.xpath("//*[@class='slds-table--edit_container slds-is-relative  inlineEdit--enabled keyboardMode--active inlineEditGrid forceInlineEditGrid']//following::table[1]"));
		List<WebElement> rows=elementTable.findElements(By.tagName("th"));
		System.out.println("No. of rows: "+rows.size());
		
		
		//driver.findElement(By.xpath("//span[@title='Last Modified Date']")).click();
		
		
		//((//tbody/tr[2]//td[3])[2]//span[1]/span)[1]
		
		

	}
}
