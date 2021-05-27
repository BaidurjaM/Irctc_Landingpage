package Landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
public class ValidLinks {
	
	private static int count;
	private static int count3;
	private static int count2;


	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver",("F:\\GeckoDriver\\geckodriver.exe"));
		WebDriver driver = new FirefoxDriver();
			
			
	        driver.manage().window().maximize();
	        driver.get("https://www.irctc.co.in/nget/train-search/");
	 
	        //Storing the links in a list and traversing through the links
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	 
	        // This line will print the number of links and the count of links.
	        System.out.println("No of links are "+ links.size()); 
//            System.out.println("No. of invalid Links are: "+count);
//            System.out.println("No.of Valid Links are: "+count2);
//            System.out.println("No.of Exception Links are: "+count3);
	      
	        //checking the links fetched.
	        for(int i=0;i<links.size();i++)
	        {
	            WebElement E1= links.get(i);
	            String url= E1.getAttribute("href");
	            verifyLinks(url);
	        }
	        
	        driver.quit();
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
	    
	    
	}