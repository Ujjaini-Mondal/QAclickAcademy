package com.QAAcademy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PractiseTest {

@Test
public void  practise() throws InterruptedException {
	// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Practice')]")).click();
		//Radio Button Example
		List<WebElement> radiobuttons=driver.findElements(By.xpath("//input[@class='radioButton']"));
		int count=radiobuttons.size();
		for(int i=0;i<count;i++) {
			WebElement selectedRadioButton=radiobuttons.get(i);
					selectedRadioButton.click();
			}
		//Suggession Class Example
		driver.findElement(By.id("autocomplete")).sendKeys("US");
		driver.findElement(By.xpath("//div[contains(text(),'United States (USA)')]")).click();
		//Dropdown Example
		driver.findElement(By.id("dropdown-class-example")).click();
		driver.findElement(By.xpath("//option[@value='option3']")).click();
		//Checkbox Example
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		int number=checkboxes.size();
		for(int i=0;i<number;i++) {
			WebElement selectedCheckBox=checkboxes.get(i);
				selectedCheckBox.click();
			}
		
		//Switch Window Example Open Window
			driver.findElement(By.id("openwindow")).click();
			Set<String>ids=driver.getWindowHandles();
			Iterator<String>it=ids.iterator();
			String parent = it.next();
			String newwin = it.next();
			driver.switchTo().window(newwin);
			WebDriverWait time=new WebDriverWait(driver,30);
			time.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Practice')]")));
			//perform actions on new window
			driver.close();
			driver.switchTo().window(parent);
			
			//Switch Tab Example
			driver.findElement(By.id("opentab")).click();
			Thread.sleep(4000);
			ArrayList<String>tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.close();
			driver.switchTo().window(tabs.get(0));
			
			//Switch To Alert Example
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Ujjaini");
			driver.findElement(By.id("alertbtn")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			driver.findElement(By.id("confirmbtn")).click();
			driver.switchTo().alert().dismiss();  
			
			//Element Displayed Example
			
			driver.findElement(By.id("show-textbox")).click();
			driver.findElement(By.id("displayed-text")).sendKeys("Hello");
			driver.findElement(By.id("hide-textbox")).click();
			
			
			// Mouse Hover Example
			driver.findElement(By.xpath("//legend[contains(text(),'iFrame Example')]")).click();
			Thread.sleep(2000);
			Actions hover= new Actions(driver);
			hover.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
			driver.findElement(By.xpath("//a[contains(text(),'Reload')]")).click();
			
		
		
		/*//Web Table Example
		WebElement table= driver.findElement(By.id("product"));
		int rowcount= table.findElements(By.xpath("//body//tr")).size();
		int rows= table.findElements(By.xpath("//body//tr div:nth-child(3)")).size();
		
		for(int i=0;i<rows;i++) 
		{
			System.out.println(table.findElements(By.xpath("//body//tr div:nth-child(3)")).get(i).getText());
			
		}*/
		
		
}
}

