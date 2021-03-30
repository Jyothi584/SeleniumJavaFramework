import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserElementTest {
	public static void main(String args[]) {
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectLocation+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumhq.org/");
		//driver.findElement(By.id("gsc-i-id1")).sendKeys("selenium IDE");
		//WebElement textBox = driver.findElement(By.id("gsc-i-id1"));
		WebElement textBox = driver.findElement(By.xpath("//input[@id='gsc-i-id1']"));
		textBox.sendKeys("selenium");
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int count = listOfInputElements.size(); 
		System.out.println("count is :"+count);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
