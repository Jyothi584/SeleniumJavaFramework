package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SeleniumDevPageObjects;

public class TestNGDemo2 {
	WebDriver driver = null;

	@BeforeTest
	public void setUPTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@Test
	public void seleniumDevSearchTest() {
		SeleniumDevPageObjects obj = new SeleniumDevPageObjects(driver);
		driver.get("http://seleniumhq.org/");
		obj.setTextInSearchBox("Selenium IDE");
		driver.navigate().back();
		obj.clickHyperlink();
	}
	
	@Test
	public void seleniumDevSearchTest1() {
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
		System.out.println("Ran using TestNG successfully");

	}

}
