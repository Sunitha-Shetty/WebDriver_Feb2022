package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
				
		driver.get("https://www.facebook.com/");			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		Thread.sleep(5000);
			
		WebElement UserName = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement Password = driver.findElement(By.xpath("//input[@id='pass']"));
		WebElement LoginBtn = driver.findElement(By.xpath("//button[@name='login']"));
		
		UserName.sendKeys("Java_Sel@gmail.com");
		Password.sendKeys("Abc@2021");
		LoginBtn.click();
			
	//	driver.close();
		
		
		

	}

}
