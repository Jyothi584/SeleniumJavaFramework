package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {
	public static void main(String args[]) {
		test();
	}
	public static void test(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumhq.org/");
		driver.findElement(By.name("search")).sendKeys("SeleniumIDE");
		driver.findElement(By.name("search")).sendKeys(Keys.RETURN);
		//driver.findElement(By.linkText("W3C WebDriver specification")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.linkText("W3C WebDriver specification"));
				if(linkElement.isEnabled()) {
					System.out.println("Element found");
					
				}
				return linkElement;
			}
		});
		element.click();
		
		
		
		//Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
