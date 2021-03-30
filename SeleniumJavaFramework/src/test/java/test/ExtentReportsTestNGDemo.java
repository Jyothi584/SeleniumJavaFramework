package test;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SeleniumDevPageObjects;

public class ExtentReportsTestNGDemo {
	
	WebDriver driver = null;
	ExtentHtmlReporter htmlReporter = null;
	ExtentReports extent = null;
	ExtentTest test = null;
	
	@BeforeSuite
	public void setUP() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		htmlReporter = new ExtentHtmlReporter("extentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	@Test
	public void seleniumDevSearch() throws IOException {
		
		test = extent.createTest("Selenium Dev Search Test", "This is to validate search functionality");
		test.log(Status.INFO, "Starting test case");
		driver.get("http://seleniumhq.org/");
		test.pass("Navigated to Selenium Dev website");
		SeleniumDevPageObjects obj = new SeleniumDevPageObjects(driver);
		obj.setTextInSearchBox("Selenium IDE");
		test.pass("Entered text in the searach box");
		test.pass("Pressed keyboard enter key");
		driver.navigate().back();
		test.pass("Navigated back to home page");
		obj.clickHyperlink();
		test.pass("clicked on Documentation link");
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@Test
	public void seleniumDevSearch1() throws IOException {
		//same as seleniumDevSearch(). Just added to see the behaviour of more than one test.
		
		test = extent.createTest("Selenium Dev Search Test", "This is to validate search functionality");
		test.log(Status.INFO, "Starting test case");
		driver.get("http://seleniumhq.org/");
		test.pass("Navigated to Selenium Dev website");
		SeleniumDevPageObjects obj = new SeleniumDevPageObjects(driver);
		obj.setTextInSearchBox("Selenium IDE");
		test.pass("Entered text in the searach box");
		test.pass("Pressed keyboard enter key");
		driver.navigate().back();
		test.pass("Navigated back to home page");
		obj.clickHyperlink();
		test.fail("clicked on Documentation link");
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.close();
		driver.quit();
		test.pass("Closed the browser");
		test.info("Completed test");
		extent.flush();
		
	}
}
