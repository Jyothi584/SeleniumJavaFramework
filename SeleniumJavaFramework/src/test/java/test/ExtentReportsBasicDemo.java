package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SeleniumDevPageObjects;

public class ExtentReportsBasicDemo {
	private static WebDriver driver = null;
	public static void main(String args[]){
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		//create extent reports and attach extent reports
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//creates a toggle for the given test and adds all log events under it
		ExtentTest test = extent.createTest("Selenium Dev Search Test One","This is a test to validate the search functionality");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		SeleniumDevPageObjects obj = new SeleniumDevPageObjects(driver);
		test.log(Status.INFO, "Starting test case");
		
		driver.get("http://seleniumhq.org/");
		test.pass("Navigated to Selenium Dev website");
		
		obj.setTextInSearchBox("Selenium IDE");
		test.pass("Entered text in search box");
		test.pass("Pressed keyboard enterkey");
		
		driver.navigate().back();
		test.pass("Came back to home page");
		
		obj.clickHyperlink();
		test.pass("Clicked on Documentation link");
		
		driver.close();
		driver.quit();
		test.pass("Closed the browser");
		test.info("Test completed");
		
		//calling flush writes everything to the log file
		extent.flush();
	}
}
