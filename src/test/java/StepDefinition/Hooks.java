package StepDefinition;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	 public static WebDriver driver;
//	 Properties p;
     
	@BeforeAll
    public static void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();
    	    	
//    	p=BaseClass.getProperties();
//    	driver.get(p.getProperty("appURL"));
//    	driver.manage().window().maximize();			
	}
		
    @AfterAll
    public static void tearDown() {
        		
       driver.quit();
    }
    
    @AfterStep
    public static void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
    	if((scenario.isFailed())||(scenario.isFailed()==false)) {
       // if(scenario.isFailed()) {
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        }
      
    }
   
}
