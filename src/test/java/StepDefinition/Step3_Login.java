package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Login;

public class Step3_Login {
	static WebDriver driver;
	Login login;
	
	@Given("Click on Login or Signup button")
	public void click_on_login_signup_button() throws InterruptedException {
		BaseClass.getLogger().info("----Clicking on Login/signup button----");
		login=new Login(BaseClass.getDriver());
		login.navigate_back();
		login.clickLogin();
	   
	}

	@When("Select Google to Login")
	public void select_google_to_login() throws InterruptedException {
		BaseClass.getLogger().info("----Selecting Google to login to the account----");
		login.clickGoogle();
		login.handlingFrame();
	}

	@Then("Give Invalid Email Id for Login")
	public void give_invalid_email_id_for_login() throws InterruptedException, IOException {
		BaseClass.getLogger().info("----Giving Invalid Email Id----");
		login.input_Email();
	    
	}

	@Then("Extract the Error Message Displayed")
	public void extract_the_error_message_displayed() throws InterruptedException {
		BaseClass.getLogger().info("----Extracting the Error Message Displayed----");
		login.show_error();

	    
	}
}


