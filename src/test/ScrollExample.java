package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ScrollExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
				
		driver.get("https://www.w3schools.com/html/html_tables.asp");			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		Thread.sleep(5000);
		
		
		WebElement element = driver.findElement(By.xpath("//h2[text()='Table Rows']"));
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		//obj.executeScript("arguments[0].scrollIntoView();", element);
		
		//scroll down
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				
		//scroll up
		//obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");	
		
		

	}

}
