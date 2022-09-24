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

	public class TC003_DeleteOpportunity {
		
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
		}
	}
