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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005_EditAccount extends ProjectSpecificMethodsSelBootCamp {
	
	@BeforeTest
	public void setData() {
		excelFileName="tc005_EditAccount";
	}
	
	@Test(dataProvider="Dynamic_Data")
	
	public void EditAccount(String name, String bstreet,String city,String pro,String stcode,String country,
			String shstreet,String shcity,String shpro,String shcode,String shcountry,String phno) 
			throws InterruptedException {
		
		
		
		Thread.sleep(2000);
		WebElement account=				driver.findElement(By.xpath("(//span[@class='slds-truncate'])[9]"));
		driver.executeScript("arguments[0].click();",account);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(name +Keys.ENTER);
		Thread.sleep(2000);
		//name.sendKeys(Keys.ENTER);
		
		//WebElement dropdown=				driver.findElement(By.xpath("//tbody/tr[1]/td[6]//ul[1]"));
		//dropdown.click();
		WebElement dropdown=driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", dropdown);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@role='presentation']//a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//div[@role='none']//button)[2]")).click();
		driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		WebElement R=driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[4]"));
		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
		executor5.executeScript("arguments[0].click();", R);
		
		WebElement element6=driver.findElement(By.xpath("//span[text()='Healthcare']"));
		JavascriptExecutor executor6 = (JavascriptExecutor)driver;
		executor6.executeScript("arguments[0].click();", element6);
		Thread.sleep(2000);
		
		//10)Enter Billing Address
		driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea")).sendKeys(bstreet);
		driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys(city);
		driver.findElement(By.xpath("(//input[@name='province'])[1]")).sendKeys(pro);
		driver.findElement(By.xpath("(//input[@name='postalCode'])[1]")).sendKeys(stcode);
		driver.findElement(By.xpath("(//input[@name='country'])[1]")).sendKeys(country);
		//11)Enter Shipping Address
		driver.findElement(By.xpath("(//textarea[@name='street'])[2]")).sendKeys(shstreet);
		driver.findElement(By.xpath("(//input[@name='city'])[2]")).sendKeys(shcity);
		driver.findElement(By.xpath("(//input[@name='province'])[2]")).sendKeys(shpro);
		driver.findElement(By.xpath("(//input[@name='postalCode'])[2]")).sendKeys(shcode);
		driver.findElement(By.xpath("(//input[@name='country'])[2]")).sendKeys(shcountry);
		Thread.sleep(2000);
		
		//12)Select Customer Priority as Low
		WebElement CP=				driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[5]"));
		driver.executeScript("arguments[0].click();",CP);
		driver.findElement(By.xpath("//span[@title='Low']")).click();
		Thread.sleep(2000);
		
		//13)Select SLA as Silver		
		WebElement SLA=				driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[6]"));
		driver.executeScript("arguments[0].click();",SLA);
		driver.findElement(By.xpath("//span[@title='Silver']")).click();
		Thread.sleep(2000);
		
		//14) Select Active as NO 
		WebElement Act=				driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[8]"));
		driver.executeScript("arguments[0].click();",Act);
		driver.findElement(By.xpath("//span[@title='No']")).click();
		Thread.sleep(2000);
		
		//15) Enter Unique Number in Phone Field
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys(phno);	
		Thread.sleep(2000);
		
		//16)Select Upsell Oppurtunity as No
		WebElement UpOp=				driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[7]"));
		driver.executeScript("arguments[0].click();",UpOp);
		driver.findElement(By.xpath("//span[@title='No']")).click();
		Thread.sleep(2000);
		
		//17)Click on save and verfiy Phone number
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		boolean phnumber = driver.findElement(By.xpath("//span[@class='forceOutputPhone slds-truncate']")).isEnabled();
		System.out.println(phno);
//Expected Result:
//The Account is Edited Successfully
		if(phnumber=true)
		  {
			System.out.println("Account is Edited");  
		  }
		  else {
			  System.out.println("Account is not edited");
		  }
		
		/*Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String verifyName=driver.findElement(By.xpath("//div[contains(@class,'testonly-outputNameWithHierarchyIcon slds-grid')]//lightning-formatted-text[1]")).getText();
		System.out.println(verifyName);
		
		String expectedText="Vaishnavi";
		Assert.assertEquals(verifyName,expectedText );*/
		
		
		
		}
}