package Landingpage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class booktrain {
	
	WebDriver driver;
	String image1 = "";
	
	@BeforeTest
	public void setdriver()
	{
//		System.setProperty("webdriver.chrome.driver",("F:\\ChromeDriver\\chromedriver.exe"));
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver",("F:\\GeckoDriver\\geckodriver.exe"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
	}
	public void booktrainfunc () throws InterruptedException 
	{
		driver.get("https://www.irctc.co.in/nget/train-search");
		clickables cl = new clickables(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    //cl.later().click();
		cl.okclick().click();
		js.executeScript("window.scrollBy(0,135)");
		cl.origin().sendKeys("HWH");
	    Thread.sleep(1000);
		cl.sel1().click();
		cl.dest().sendKeys("NDLS");
		Thread.sleep(1000);
		cl.sel2().click();
		Thread.sleep(1000);
		Actions at = new Actions(driver);		
		at.moveToElement(cl.jdate()).click().build().perform();
		cl.djour().click();
		Thread.sleep(1000);
		at.moveToElement(cl.jclass()).click().build().perform();
		cl.cls().click();
		Thread.sleep(1000);
		at.moveToElement(cl.jquota()).click().build().perform();
		cl.qot().click();
		Thread.sleep(1000);
		//at.moveToElement(cl.submit()).click().build().perform();
		cl.submit().click();
	}
	
}

