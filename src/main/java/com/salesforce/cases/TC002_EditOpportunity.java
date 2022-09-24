package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_EditOpportunity {
	
	public static void main(String[] args) {
		
		
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		
		WebElement opportunity=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]"));
		driver.executeScript("arguments[0].click();",opportunity);		
		
		//driver.executeScript("arguments[0].click();",opportunity1);
		WebElement val=driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
		val.sendKeys("Salesforce Automation by Vaishnavi");
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
        
        driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("SalesForce");
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
		
		
		
}
}
