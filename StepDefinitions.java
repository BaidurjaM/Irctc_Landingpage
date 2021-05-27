package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Landingpage.clickables;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.junit.Cucumber;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;



//@RunWith(Cucumber.class)
public class StepDefinitions {
	WebDriver driver;
	private static int count;
	private static int count3;
	private static int count2;


	@Before
	public void setUp() {
		System.out.println("In Set Up method");
	    //System.setProperty("webdriver.chrome.driver",("F:\\ChromeDriver\\chromedriver.exe"));
		//driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver",("F:\\GeckoDriver\\geckodriver.exe"));
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws Throwable {
		clickables cl = new clickables(driver);
		System.out.println("On landing page");
		driver.get("https://www.irctc.co.in/nget/train-search");
		cl.okclick().click();
		Thread.sleep(1000);
	}

	@Given("^Irctc logo is visible$")
	public void irctc_logo_is_visible() throws Throwable {
		String actualsrc = "https://www.irctc.co.in/nget/assets/images/logo.png";
		WebElement url = driver.findElement(By.xpath("//img[@src='./assets/images/logo.png']"));
		String image1 = url.getAttribute("src");
		Thread.sleep(1000);
		Assert.assertEquals(actualsrc, image1);
       	System.out.println("Logo Verified");
       	Thread.sleep(1000);
	}

	@Given("^All links and tabs are displayed$")
	public void all_links_and_tabs_are_displayed() throws Throwable {
		clickables cl = new clickables(driver);
		 cl.flight().click();
		 cl.ecat().click();
		 cl.hillrail().click();
		 Thread.sleep(1000);		 
		 
	}

	@Given("^Click on Flights tab$")
	public void click_on_Flights_tab() throws Throwable {
		 //clickables cl = new clickables(driver);
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(newTb.get(3));
		 Thread.sleep(1000);
		// cl.okflight().click();
		 String exp = driver.getTitle();
		 String actflight = "Air Ticket Booking | Book Flight Tickets | Cheap Air Fare - IRCTC Air";
		 Assert.assertEquals(actflight, exp, "Not redirected correctly");
		 System.out.println("Redirected correctly to flights");
		 Thread.sleep(1000);
	}

	@Given("^Click on ecatering tab$")
	public void click_on_ecatering_tab() throws Throwable {
		 //clickables cl = new clickables(driver);
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(newTb.get(2));
		 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		 String exp1 = driver.getTitle();
		 String actecat = "Order Food Online On Train | Quick & Tasty Food Delivery in Train";
		 Assert.assertEquals(actecat, exp1, "Not redirected correctly");
		 System.out.println("Redirected correctly to E-catering");
		 Thread.sleep(2000);
	}

	@Given("^Click on hilltrain$")
	public void click_on_hilltrain() throws Throwable {
		 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(newTb.get(1));
		 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		 String exp2 = driver.getTitle();
		 String acthillrail = "Railways Tourism, Retiring Rooms, Holidays Customized Tours, LTC Tours, Maharajas, Mahaparinirvan";
		 Assert.assertEquals(acthillrail, exp2, "redirected correctly");
		 System.out.println("Redirected correctly to Hill Railways");
		 Thread.sleep(1000);
	}

	@Then("^We can say landing page verified$")
	public void we_can_say_landing_page_verified() throws Throwable {
		System.out.println("Page Verified");
	}
	
	@Given("^User enters source station$")
	public void user_enters_source_station() throws Throwable {
		clickables cl = new clickables(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,135)");
		cl.origin().sendKeys("HWH");
		System.out.println("Source Station : Howrah-HWH");
	    Thread.sleep(1000);
		cl.sel1().click();
	}
	
	
	@Given("^User enters destination station$")
	public void user_enters_destination_station() throws Throwable {
		clickables cl = new clickables(driver);
		cl.dest().sendKeys("NDLS");
		System.out.println("Destination Station : NewDelhi-NDLS");
		Thread.sleep(1000);
		cl.sel2().click();
		Thread.sleep(1000);
	}

	@Given("^User enters date of journey$")
	public void user_enters_date_of_journey() throws Throwable {
		clickables cl = new clickables(driver);
		Actions at = new Actions(driver);
		at.moveToElement(cl.jdate()).click().build().perform();
		cl.djour().click();
		System.out.println("Date of journey : 30/05/2021");
		Thread.sleep(1000);
	}

	@Given("^User enters the class of travel$")
	public void user_enters_the_class_of_travel() throws Throwable {
		clickables cl = new clickables(driver);
		Actions at = new Actions(driver);
		at.moveToElement(cl.jclass()).click().build().perform();
		cl.cls().click();
		System.out.println("Class : All Classes");
		Thread.sleep(1000);
	}

	@Given("^User enters Quota$")
	public void user_enters_Quota() throws Throwable {
		clickables cl = new clickables(driver);
		Actions at = new Actions(driver);
		at.moveToElement(cl.jquota()).click().build().perform();
		cl.qot().click();
		System.out.println("Quota : General");
		Thread.sleep(1000);
	}

	@Given("^User Clicks on Search button$")
	public void user_Clicks_on_Search_button() throws Throwable {
		Actions at = new Actions(driver);
		clickables cl = new clickables(driver);
		at.moveToElement(cl.submit()).click().build().perform();
		Thread.sleep(1000);
	}

	@Then("^user can view list of trains$")
	public void user_can_view_list_of_trains() throws Throwable {
		Thread.sleep(3000);
	    System.out.println("you are viewing List of tains");
	}

	@Then("^user views all links on Home page$")
	public void user_views_all_links_on_Home_page() throws Throwable {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links are "+ links.size()); 
		for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            verifyLinks(url);
        }
	}
		public static void verifyLinks(String linkUrl)
	    {
	    	  System.out.println("No. of invalid Links are: "+count);
              System.out.println("No.of Valid Links are: "+count2);
              System.out.println("No.of Exception Links are: "+count3);
	        try
	        {
	            URL url = new URL(linkUrl);
	          //Now we will be creating url connection and getting the response code
	            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection(); //check the HTTP status of each using HttpURLConnection class in Java.
	            httpURLConnect.setConnectTimeout(5000);//waiting 5 seconds for connection timeout
	            httpURLConnect.connect();

	            if(httpURLConnect.getResponseCode()>=400)// checking the response code either 200 or 404
	            {
	            
					
	             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
	             
				 count++;
	            
	            }  
	                   
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
					count2++;
	        
	            }
	           
	        }
	        catch (Exception e) {
	        	count3++;
	      }
	}

	@After
	public void tearDown() {
		driver.quit();
		System.out.println("Driver closed");
	}
}

