package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.For_ReadWriteExcel;

public class HondaBike extends BasePage{
	String[] strAr3= new String[3];

	public HondaBike(WebDriver driver) 
	{
		super(driver);
		
	}
	
	public List<String> bikenames=new ArrayList<>();
	public List<String> bikePrice=new ArrayList<>();
	public List<String> launchDate1=new ArrayList<>();
	
	@FindBy(xpath = "//a[normalize-space()='New Bikes']") 
	WebElement newBikeDropdown;
	
	@FindBy(xpath = "//span[contains(text(),'Upcoming Bikes')]")
	public WebElement upcomingBike;
	
	@FindBy(className = "custom-select")
	public WebElement manufacturer;
	
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	WebElement scrollLink;
	
	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']") ////*[@id="modelList"]/li[16]/span/text() ////span[@class='zw-cmn-loadMore']
	public WebElement LoadMore;
	
	@FindBy(xpath = "//a[@data-track-label='model-name']")
	List<WebElement> bikeNames;
	
	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[1]")
	List<WebElement> price;
	
	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[2]")
	List<WebElement> launchDate;
	
	String filepath = System.getProperty("user.dir")+"./src/main/resources/test_OP_data.xlsx";
	
	
	//****************************************************************************************//
	                                //ACTION METHODS//
	//****************************************************************************************//
	
	
	//Hover to the NewBike Dropdown
	public void dropDown() throws InterruptedException  
	{
		Actions action=new Actions(driver);
		action.moveToElement(newBikeDropdown).perform();
		Thread.sleep(5000);
		action.moveToElement(upcomingBike).click().perform();
		//upcomingBike.click();
	}
	
	//Selecting the Manufacturer
	public void selectManufacturer()
	{
		Select drpdwn= new Select(manufacturer);
    	drpdwn.selectByVisibleText("Honda");
	}
	
	//scrolling
	public void scrollto()
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();",scrollLink);
	}
	
	//clicking load more
	public void clickLoadMore() throws InterruptedException
	{	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", LoadMore);
	}
	
	//Displaying Bike Details
	public void bikeDetails() throws IOException
	{
		for (int i = 0; i < bikeNames.size(); i++) 
		{
			String str = bikeNames.get(i).getText();
			bikenames.add(str);
			String str1 = price.get(i).getText();
			bikePrice.add(str1);
			String str2 = launchDate.get(i).getText();
			launchDate1.add(str2);
			
			String priceString = str1.replaceAll("[^\\d.]", "").replaceFirst("\\.(?=.*\\.)", "");
			double price = Double.parseDouble(priceString);
				
		
		
		// Check if the price is under 4 lakhs and print the bike details
		if (price < 4.0) 
		{
			System.out.println(str);
			System.out.println(str1);
			System.out.println(str2+"\n");
		}
		
		
		}
		
		//Displaying the data in an excel file
		For_ReadWriteExcel.writeBikenames(bikenames,filepath);
		For_ReadWriteExcel.writebikePrice(bikePrice,filepath);
		For_ReadWriteExcel.writelaunchDate(launchDate1,filepath);
	}
	
	
	
	
	

}
