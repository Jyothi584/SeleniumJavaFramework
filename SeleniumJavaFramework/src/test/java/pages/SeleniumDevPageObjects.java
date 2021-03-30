package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SeleniumDevPageObjects {
	WebDriver driver = null;
	By textBox_search = By.name("search");
	By hLink_click = By.xpath("//header/nav[@id='navbar']/a[3]");
	
	public SeleniumDevPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void setTextInSearchBox(String text) {
		driver.findElement(textBox_search).sendKeys(text);
		driver.findElement(textBox_search).sendKeys(Keys.RETURN);
	}
	public void clickHyperlink(){
		driver.findElement(hLink_click).click();
	}
}
