package parallel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MiSaleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String webURL = "https://www.realme.com/in/";
		String saleURL = "https://event.realme.com/in/realme-flashsale";
		String email = "hemantkadam25@gmail.com";
		String password = "Hem@nt25";
		By productWebElement = By.xpath("(//button[@class='good-btn'])[1]");
		String upiID= "9503020610@paytm";

		WebDriverManager.edgedriver().setup();
		//System.setProperty("webdriver.edge.driver", "E:\\Selenium\\Setup and Jar Files\\Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
		driver.manage().window().maximize();			
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to(webURL);
		
		driver.findElement(By.xpath("//*[@id='plus-accountLogin']/label")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Sign in with password']")));
		driver.findElement(By.xpath("//*[text()='Sign in with password']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Phone/Email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("(//div[text()='Sign in'])[2]")).click();
		Thread.sleep(20000l);
		driver.navigate().to(saleURL);
		
		System.out.println("New Changes");
		System.out.println("New Changes");
		
		int i=0;
		
		while(i<=1) {
			
			String text = driver.findElement(productWebElement).getText();
			System.out.println(text);
			if(text.equalsIgnoreCase("Buy now")) {
				
				driver.findElement(productWebElement).click();	
				System.out.println(text);
				break;
			}
			
		}
		
				
		driver.findElement(By.xpath("//*[text()='Check Out']")).click();
		driver.findElement(By.xpath("//input[@id='checkoutFormBtn']")).click();
		
		driver.findElement(By.xpath("//div[@data-type='upi']")).click();
		driver.findElement(By.xpath("//div[@class='banks-radio upi-payway UPI Other Upi Options']")).click();
		
		driver.findElement(By.xpath("//*[@placeholder='Enter your VPA']")).sendKeys(upiID);
		driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
		
						
				
	}

}
	

