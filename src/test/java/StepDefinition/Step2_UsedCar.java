package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UsedCar;

public class Step2_UsedCar {
	// UC;
	
	 UsedCar UC=new UsedCar(BaseClass.getDriver());
	@Given("Navigate back to home page")
	public void navigate_back_to_home_page() throws InterruptedException {
		BaseClass.getLogger().info("----Navigating back to home page----");
		UC.navigate_back();

	}

	@When("Select Chennai from Used cars dropdown")
	public void select_chennai_from_used_cars_dropdown() throws InterruptedException {
		BaseClass.getLogger().info("----Selecting Used Cars from Chenneai----");
		UC.used_Cars();
		UC.select_chennai();

	}

	@Then("Extract the popular models in chennai")
	public void extract_the_popular_models_in_chennai() throws InterruptedException, IOException {
		BaseClass.getLogger().info("----Exracting the Popular Model List----");
		UC.scrolltopopularcars();
	    UC.display_cars();

	}

	
	    
	
}



