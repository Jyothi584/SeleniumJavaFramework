import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilitiesDemo {
	
	public static void main(String args[]) {
		
		DesiredCapabilities dCaps = new DesiredCapabilities();
		dCaps.setCapability("ignoreProtectedModeSettings", true);
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://seleniumhq.org/");
		driver.findElement(By.name("search")).sendKeys("SeleniumIDE");
		driver.findElement(By.name("search")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();
		
	}
	
}
