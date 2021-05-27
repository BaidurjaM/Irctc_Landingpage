package Landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class clickables {
WebDriver driver;

//	@FindBy (xpath="//button[contains(text(),'Later']") 
//	WebElement later;
	
	@FindBy (xpath="/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button")
	WebElement okclick;
	
	@FindBy (xpath="//span[@class='allcircle circleone']")
	WebElement flight;
	
	@FindBy (xpath="//button[@type='button']")
	WebElement okflight;
	
	@FindBy (xpath="//span[@class='allcircle circlefour']")
	WebElement ecat;
	
	@FindBy (xpath="//span[@class='allcircle circleseven']")
	WebElement hillrail;
	
	@FindBy (xpath="//*[@id='origin']/span/input")
	WebElement origin;
	
	@FindBy (xpath="//*[@id='destination']/span/input")
	WebElement dest;
	
	@FindBy (xpath="//*[@id='jDate']/span/input")
	WebElement jdate;
	
	@FindBy (xpath="//*[@id='journeyClass']/div")
	WebElement jclass;
	
	@FindBy (xpath="//*[@id='journeyQuota']/div")
	WebElement jquota;
          //     "//*[@id='pr_id_1_list']/li/span")
	      //     ("//*[@id='pr_id_2_list']/li[1]")
	@FindBy(xpath="//*[@id='pr_id_1_list']/li/span")
	WebElement sel1;
	
	@FindBy(xpath="//*[@id='pr_id_2_list']/li[1]")
	WebElement sel2;
	
	@FindBy (xpath="//button[@label='Find Trains']")
	WebElement submit;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar ng-tns-c59-10']//td/a[contains(@class,'state-default')][contains(text(),'30')]")
	WebElement djour;
	
	@FindBy(xpath="//*[@id='journeyClass']/div/div[4]/div/ul/p-dropdownitem[1]/li/span")
	//@FindBy(xpath="//*[@id='journeyClass']/div/div[4]/div/ul/p-dropdownitem/li/span[contains(text(),'All Classes')]")
	WebElement cls;
	
	@FindBy(xpath="//*[@id='journeyQuota']/div/div[4]/div/ul/p-dropdownitem[1]/li/span")
	//@FindBy(xpath="//*[@id='journeyQuota']/div/div[4]/div/ul/p-dropdownitem/li/span[contains(text(),'GENERAL')]")
	WebElement qot;
	
	// $x("//table[@class='ui-datepicker-calendar ng-tns-c59-10']//td/a[contains(@class,'state-default')][contains(text(),'25')]")
	// $x("//*[@id='journeyQuota']/div/div[4]/div/ul/p-dropdownitem/li/span[contains(text(),'GENERAL')]")
	
	//button[@label='Find Trains']
	public clickables(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
        
//	public WebElement later()
//	{	
//		return later;
//	}
	
	public WebElement okclick()
	{	
		return okclick;
	}
	public WebElement flight()
	{
		return flight;
	}
	public WebElement okflight()
	{
		return okflight;
	}
	public WebElement ecat()
	{
		return ecat;
	}
	public WebElement hillrail()
	{
		return hillrail;
	}
	public WebElement origin()
	{	
		return origin;
	}
	public WebElement dest()
	{	
		return dest;
	}
	public WebElement jdate()
	{	
		return jdate;
	}
	public WebElement jclass()
	{	
		return jclass;
	}
	public WebElement jquota()
	{	
		return jquota;
	}
	public WebElement submit()
	{	
		return submit;
	}
	public WebElement sel1()
	{
		return sel1;
	}
	public WebElement sel2()
	{
		return sel2;
	}
	public WebElement djour()
	{
		return djour;
	}
	public WebElement cls()
	{
		return cls;
	}
	public WebElement qot()
	{
		return qot;
	}
}