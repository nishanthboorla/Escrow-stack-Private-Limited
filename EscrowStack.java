import java.awt.Window;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EscrowStack {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Wrist Watches");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Leather']")).click();
	    JavascriptExecutor js =  (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,450)");
	    Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']/ul/span/span/li/span)[1]")).click();
		//JavascriptExecutor js =  (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,6500)");
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[text()='2']")).click();
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,6750);");
		 Thread.sleep(3000);
		 js.executeScript("window.scrollBy(0,-6700);");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		 
		String parentid= driver.getWindowHandle();
		Set<String> childIds = driver.getWindowHandles();
		for(String childId:childIds)
		{
			
		if (!parentid.equals(childId)) {
			
			driver.switchTo().window(childId);
			Thread.sleep(2000);
			driver.findElement(By.id("add-to-cart-button")).click();
			
			
		}
		}
		driver.quit();	
		
	}

}
