package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		//Creating instance of a Chrome browser		
		WebDriver driver = new ChromeDriver();
		
	//	WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
				
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		
		
		UserName.sendKeys("Java_Sel@gmail.com");
		Password.sendKeys("Abc@2021");
		RememberMe.click();
		LoginBtn.click();
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg= "The email or password you have entered is invalid.";
		
		if(ActualMsg.equals(ExpMsg))
		{
			System.out.println("TC Passed");
		}
		else {
			System.out.println("TC Failed");
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		
		for(WebElement elm : links)
		{
			System.out.println(elm.getAttribute("href"));
		}
		
		
		driver.close();	
		
		
	}

}
