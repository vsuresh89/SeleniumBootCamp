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

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC012_CreateNewCase {
	
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("sales");
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		driver.findElement(By.xpath("//one-app-nav-bar-menu-button[contains(@class,'slds-grid slds-grid_vertical-stretch')]//a")).click();
		Thread.sleep(2000);
		WebElement more=driver.findElement(By.xpath("(//a[@href='/lightning/o/Case/home'])[2]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", more);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		//Select contactDropDown = new Select(driver.findElement(By.xpath("//input[@title='Search Contacts']")));
		//contactDropDown.selectByIndex(2);
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'primaryLabel slds-truncate')])[2]")).click();
		
		driver.findElement(By.xpath("(//a[@class='select'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Email']")).click();
		driver.findElement(By.xpath("//button[@data-value='New']")).click();
		driver.findElement(By.xpath("//span[@title='Escalated']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Subject'])[2]/following::input")).sendKeys("Testing");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("TestLeaf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(300));
		WebElement toast=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		String toastMsg=toast.getText();
		System.out.println("The case created successfully" +toastMsg);
		//wait.until(ExpectedConditions.textToBePresentInElement(toast.getText(), "was created"));
		
	}
}
