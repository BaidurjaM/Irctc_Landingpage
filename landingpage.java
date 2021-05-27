package Landingpage;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class landingpage {
	
	WebDriver driver;
	String image1 = "";
	
	@BeforeTest
	public void setdriver()
	{
		System.setProperty("webdriver.gecko.driver",("F:\\GeckoDriver\\geckodriver.exe"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
	}
		public void landingPageVerification () throws InterruptedException
	{
		driver.get("https://www.irctc.co.in/nget/train-search");
		clickables cl = new clickables(driver);
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    //cl.later().click();
		cl.okclick().click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		String actualsrc = "https://www.irctc.co.in/nget/assets/images/logo.png";
		WebElement url = driver.findElement(By.xpath("//img[@src='./assets/images/logo.png']"));
		image1 = url.getAttribute("src");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
       	Assert.assertEquals(actualsrc,image1,"No image not displayed");
       	System.out.println("Logo Verified");
	    //Thread.sleep(2000);
			 cl.flight().click();
			 cl.ecat().click();
			 cl.hillrail().click();
			 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
			 driver.switchTo().window(newTb.get(3));
			 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			 cl.okflight().click();
			 String exp = driver.getTitle();
			 String actflight = "Air Ticket Booking | Book Flight Tickets | Cheap Air Fare | LTC Fare| IRCTC AIR";
			 Assert.assertEquals(actflight, exp, "Not true");
			 System.out.println("Redirected correctly to flights");
			 driver.switchTo().window(newTb.get(2));
			 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			 String exp1 = driver.getTitle();
			 String actecat = "Order Food Online On Train | Quick & Tasty Food Delivery in Train";
			 Assert.assertEquals(actecat, exp1, "Not true");
			 System.out.println("Redirected correctly to E-catering");
			 driver.switchTo().window(newTb.get(1));
			 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			 String exp2 = driver.getTitle();
			 String acthillrail = "Railways Tourism, Retiring Rooms, Holidays Customized Tours, LTC Tours, Maharajas, Mahaparinirvan";
			 Assert.assertEquals(acthillrail, exp2, "Not true");
			 System.out.println("Redirected correctly to Hill Railways");
			 driver.switchTo().window(newTb.get(0));
			 //cl.later().click();
			 			 
			  
	}

		
		@AfterTest
	public void closedriver()
	{
			driver.quit();
	}
}
