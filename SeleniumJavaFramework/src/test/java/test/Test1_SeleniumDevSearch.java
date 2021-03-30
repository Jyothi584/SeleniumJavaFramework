package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1_SeleniumDevSearch {
	public static void main(String args[]) {
		SeleniumDevSearch();
	}
	public static void SeleniumDevSearch(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumhq.org/");
		driver.findElement(By.name("search")).sendKeys("Selenium IDE");
		driver.findElement(By.name("search")).sendKeys(Keys.RETURN);
		driver.navigate().back();
		driver.findElement(By.xpath("//header/nav[@id='navbar']/a[3]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		System.out.println("Test passed successfully");
	}
}
