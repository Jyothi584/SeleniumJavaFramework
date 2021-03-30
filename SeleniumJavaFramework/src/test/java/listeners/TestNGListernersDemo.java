package listeners;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListernersDemo {
	@Test
	public void test1() {
		System.out.println("Inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside test2");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumhq.org/");
		driver.findElement(By.name("search")).sendKeys("SeleniumIDE");
		driver.findElement(By.name("search1")).sendKeys("SeleniumIDE");	//mistake made intentionally
		
		driver.close();
	
	
	}
	 
	@Test
	public void test3() {
		System.out.println("Inside test3");
		throw new SkipException("This test is Skipped");
	}
}
