package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SeleniumDevPage;

public class SeleniumDevTest {
	static WebDriver driver = null;
	public static void main(String args[]) {
		seleniumDevSearch();
	}
	public static void seleniumDevSearch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumhq.org/");
		SeleniumDevPage.textBoxSearch(driver).sendKeys("Selenium IDE");
		SeleniumDevPage.textBoxSearch(driver).sendKeys(Keys.RETURN);
		driver.navigate().back();
		SeleniumDevPage.hLinkClick(driver).click();
		driver.close();
		System.out.println("Yay!!! ran the test successfully");
	}
}
