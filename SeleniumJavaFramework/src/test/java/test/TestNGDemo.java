package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SeleniumDevPageObjects;

public class TestNGDemo {
	WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setUPTest() {
		PropertiesFile.getProperties();
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
	}
	@Test
	public void seleniumDevSearchTest() {
		SeleniumDevPageObjects obj = new SeleniumDevPageObjects(driver);
		driver.get("http://seleniumhq.org/");
		obj.setTextInSearchBox("Selenium IDE");
		driver.navigate().back();
		obj.clickHyperlink();
	}
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		PropertiesFile.setProperties();
		System.out.println("Ran using TestNG successfully");

	}

}
