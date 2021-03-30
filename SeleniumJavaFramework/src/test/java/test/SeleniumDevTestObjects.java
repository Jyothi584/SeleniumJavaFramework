package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SeleniumDevPageObjects;

public class SeleniumDevTestObjects {
	static WebDriver driver = null;
	public static void main(String args[]) {
		seleniumDevSearchTest();
	}
	public static void seleniumDevSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		SeleniumDevPageObjects obj = new SeleniumDevPageObjects(driver);
		driver.get("http://seleniumhq.org/");
		obj.setTextInSearchBox("Selenium IDE");
		driver.navigate().back();
		obj.clickHyperlink();
		driver.close();
		
	}
}
