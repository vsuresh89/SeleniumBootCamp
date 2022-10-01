package com.salesforce.cases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class TC018_UpdateContact {
	@Test
	public void UpdateContact() throws InterruptedException {
		
		
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
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("contacts");
		driver.findElement(By.xpath("//mark[text()='Contacts']")).click();
		Thread.sleep(3000);
		
		//WebElement contact=driver.findElement(By.xpath("//table/thead/tr/th[3]/div/a/span[2]"));
		//JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		//executor3.executeScript("arguments[0].click();", contact);
		/* List<WebElement> tableRow = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

		    for (int row = 0; row < tableRow.size(); row++) {

		        WebElement colData = tableRow.get(row);

		        List<WebElement> tableCol = colData.findElements(By.tagName("td"));

		        for (int col = 0; col < tableCol.size(); col++) {
		            String result = tableCol.get(col).getText();
		        }
		    }*/
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Vaishnavi"+Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table/tbody/tr/td[8]/span/div/a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(3000);
		//10)Update Email with your persinal mail id
		WebElement email=driver.findElement(By.xpath("//label[text()='Email']/following::input[1]"));
		email.clear();
		email.sendKeys("abc@gmail.com");
		//11)Update Lead Source as Partner Referral from bottom
		driver.findElement(By.xpath("//span[text()='Purchased List']")).click();
		driver.findElement(By.xpath("//span[@title='Partner Referral']")).click();
		//12) Update MailingAddress with personal address
		driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys("90 kaveri nagar");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("600114");
		Thread.sleep(3000);
		//13) Update Level as Tertiary
		WebElement st=driver.findElement(By.xpath("//button[@data-value='--None--']"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", st);
		driver.findElement(By.xpath("//span[@title='Tertiary']")).click();
		
		//14) Update title as Automation Testing
		WebElement title=driver.findElement(By.xpath("//label[text()='Title']/following::input[1]"));
		title.clear();
		title.sendKeys("Automation Testing");
		//15) Click Save and Verify and print Email 
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        
        boolean email1 = driver.findElement(By.cssSelector("div#brandBand_1>div>div>div>div>div:nth-of-type(2)>div>div>div:nth-of-type(2)>div:nth-of-type(2)>div>div>div>table>tbody>tr>td:nth-of-type(6)>span")).isEnabled();
		System.out.println("The email is entered?: "+email1);
		System.out.println("The email entered is: "+email.getText());

		if(email1=true)
		  {
			System.out.println("Contact is Updated");  
		  }
		  else {
			  System.out.println("Contact is not Updated");
		  }
		
		driver.close();
		driver.quit();
		
		
	}
}
