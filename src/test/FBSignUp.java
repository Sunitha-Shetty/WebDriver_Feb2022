package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Chrome Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		//Firefox Driver
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
				
		driver.get("https://www.facebook.com/");			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		Thread.sleep(5000);
		
		WebElement SignUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		SignUp.click();
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement Mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		FirstName.sendKeys("ABCD");
		LastName.sendKeys("M");
		Mobile.sendKeys("123456789");
		Password.sendKeys("Test@123");
		
		String strGender = "Female";
       
		//STATIC XPATH==
        //input[@value='1']
        //input[@value='2']
        //input[@value='-1']
        
        //label[text()='Male']/following-sibling::input
        //label[text()='Female']/following-sibling::input
        //label[text()='Custom']/following-sibling::input
        
		
		//DYNAMIC XPATH==
        String genXpath = "//label[text()='" + strGender + "']/following-sibling::input";
        
        WebElement gen = driver.findElement(By.xpath(genXpath));
        gen.click();
        
        List<WebElement> Months = driver.findElements(By.xpath("//select[@title='Month']/option"));
        
        for(WebElement elm : Months) 
        {    
            System.out.println(elm.getText());
        }
        
        WebElement CurrMonth = driver.findElement(By.xpath("//select[@title='Month']/option[@selected='1']"));
        System.out.println("Current Month " + CurrMonth.getText());
        
        
        WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
        
        Select ddDay = new Select(Day);
        ddDay.selectByVisibleText("25");
        
        
        WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
        
        Select ddMonth = new Select(Month);
        ddMonth.selectByVisibleText("Mar");
        
        
        WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
        
        Select ddYear = new Select(Year);
        ddYear.selectByVisibleText("1990");
        
        
	}

}
