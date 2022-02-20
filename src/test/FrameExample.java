package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
				
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
						
		driver.get("https://demoqa.com/frames");			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.switchTo().frame("frame1");
		
		WebElement heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(heading.getText());
		
		driver.switchTo().defaultContent(); // defaultContent will help to go back to parent window/frame
		
		


	}

}
