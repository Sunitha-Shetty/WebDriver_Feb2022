package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
				
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
						
		driver.get("http://demo.guru99.com/test/drag_drop.html");			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
				
		Thread.sleep(5000);	
		 
		WebElement From = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		
		WebElement To = driver.findElement(By.xpath("//ol[@id='bank']/li"));
				
		Actions act = new Actions(driver);
				
		act.dragAndDrop(From, To).build().perform();
				

	}

}
