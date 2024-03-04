package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HondaBike;

public class Step1_HondaBike {
	 static WebDriver driver;
	HondaBike HB;
	
	@Given("Launching zigwheels website in web browser")
	public void launching_zigwheels_website_in_web_browser()  {
		BaseClass.getLogger().info("----Opening zigwheels site----");
		driver=BaseClass.getDriver();
		HB=new HondaBike(BaseClass.getDriver());

	}

	@When("Selecting Upcoming bikes from new bikes dropdown")
	public void selecting_HBcoming_bikes_from_new_bikes_dropdown() throws InterruptedException  {
		BaseClass.getLogger().info("----Selecting HBcoming Bikes and Page navigates----");
	    HB.dropDown();
	}
	
	@When("Selecting the manufacturer as Honda")
	public void selecting_the_manufacturer_as_honda() throws InterruptedException   {
		BaseClass.getLogger().info("----Selecting Honda Bikes----");
		HB.selectManufacturer();
		HB.scrollto();
		HB.clickLoadMore();
	}


	@Then("Extracting New Bikes of Honda")
	public void extracting_new_bikes_of_honda() throws IOException {
		BaseClass.getLogger().info("----Extracting details of selected Honda bikes----");
	    HB.bikeDetails();
		

	}


}
