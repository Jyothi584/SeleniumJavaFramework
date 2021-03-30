package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDemo {
	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1280,800");
		
		WebDriver driver = new ChromeDriver(options);
		
		
		driver.get("http://seleniumhq.org/");
		System.out.println("Title is : " + driver.getTitle());
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("search")).sendKeys("SeleniumIDE");
		driver.findElement(By.name("search")).sendKeys(Keys.RETURN);
		
		
		driver.close();
		driver.quit();
		System.out.println("Completed");
	}
}
