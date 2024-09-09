package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionExample {

	//instantiate selenium webdriver
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		//open chrome browser
		driver = new ChromeDriver();
		
		//open url
		driver.get("https://www.google.com/");
		
		//maximise browser
		driver.manage().window().maximize();
		
		
	}
	
	@AfterClass
	void tearDown()
	{
		//close browser
		driver.close();
	}
	
	
	@Test
	void verifyPageTitle()
	{
		String ExpectedPageTitle = "Google";
		String ActualPageTitle = driver.getTitle();
		
		Assert.assertEquals(ActualPageTitle, ExpectedPageTitle,"Title is not matching.");
		
		
	}
	
	@Test
	void verifyGoogleImageIsDisplayed()
	{
		//find google image
		WebElement image = driver.findElement(By.xpath("//img[@alt=\"Google\"]"));
		
		//verify if image is displayed
	//	Assert.assertTrue(image.isDisplayed(), "Google image is not displayed.");
		
		//verify image shall not be displayed
		Assert.assertFalse(image.isDisplayed(), "Google image is displayed.");

	}
	
}
