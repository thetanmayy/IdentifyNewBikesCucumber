package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.For_ReadWriteExcel;

public class UsedCar extends BasePage{
	public String datastr[];
	public UsedCar(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "(//a[@class='c-p'])[4]")
	public static WebElement usedCar;
	
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")  ///(//span[contains(text(),'Chennai')]
	public static WebElement city_Chennai;
	
	@FindBy(xpath = "//div[contains(text(),'Popular Models')]")
	public static WebElement scrollpop;
	
	@FindBy(xpath = "//div[@class='gsc_thin_scroll']")
	public static WebElement popularModelweb;
	
	@FindBy(xpath = "//div[@class='gsc_thin_scroll']")
	public static String popularModel;
	
	
	//****************************************************************************************//
                                      //ACTION METHODS//
	//****************************************************************************************//

	//Hover to the used cars Dropdown
	
	public void navigate_back() {
		driver.navigate().back();
	}
	public void used_Cars() throws InterruptedException  
	{
		Actions action=new Actions(driver);
		action.moveToElement(usedCar).perform();
		
	}
	public void select_chennai() throws InterruptedException  
	{
		city_Chennai.click();
	}
	public void scrolltopopularcars()
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView();",scrollpop);
	}
	public void display_cars()
	{
		String filepath = System.getProperty("user.dir")+"./src/main/resources/test_OP_data.xlsx";
    	popularModel=driver.findElement(By.xpath("//div[@class='gsc_thin_scroll']")).getText();//extracting all popular models
    	List<String> usedCarsList = new ArrayList<String>();
    	String[] pm = popularModel.split("\\n");
    	for (int i = 0; i<pm.length; i++) {
    		usedCarsList.add(pm[i]);
    	}
    	System.out.println("Popular Models of Used Cars in Chennai\n\n"+popularModel);
    	try {
			For_ReadWriteExcel.writeUsedCars(usedCarsList, filepath);
		} catch (IOException e) {
			e.printStackTrace();
		} 	

	}
	
	
	
		
}
