package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumDevPage {
	static WebElement element = null;
	public static WebElement textBoxSearch(WebDriver driver) {
		element = driver.findElement(By.name("search"));
		return element;
	}
	public static WebElement hLinkClick(WebDriver driver){
		element = driver.findElement(By.xpath("//header/nav[@id='navbar']/a[3]"));
		return element;
	}
}
