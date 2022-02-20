package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTabExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
				
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
						
		driver.get("https://demoqa.com/browser-windows");			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	
	//CODE FOR OPENING NEW WINDOW
		String ParentWin = driver.getWindowHandle();
		System.out.println("Before clicking new button: " + ParentWin);
		
		WebElement element = driver.findElement(By.xpath("//button[@id='tabButton']"));
		element.click();
		
		System.out.println("After clicking new tab button");
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		
		while(itr.hasNext()) {
			
			String currentVal = itr.next();
			System.out.println(currentVal);
			
			if(!currentVal.equals(ParentWin)) {
				
				driver.switchTo().window(currentVal);
			}
		}
		
		WebElement heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(heading.getText());
		driver.close();
	//	driver.quit(); this will close the parent/previous window after closing the child/current window
		
		driver.switchTo().window(ParentWin);
		System.out.println("Back to parent Window");
		driver.close();
		

	}

}
