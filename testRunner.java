package Options;


import org.junit.runner.RunWith;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@Test
//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature/HomePage.feature" ,
		glue = "stepdefinition",
//		dryRun = true ,
//		monochrome = true
//		format =pretty
		//tags = "@FunctionalTest" 
		tags = "@SmokeTest"
		//tags = "@links"
	  //  plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class testRunner extends AbstractTestNGCucumberTests {
	

}
