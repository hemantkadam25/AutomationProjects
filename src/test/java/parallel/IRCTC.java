package parallel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTC {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String webURL = "https://www.irctc.co.in/";
		//String saleURL = "https://event.realme.com/in/realme-diwali-flashsale";
		String username = "hemkad2509";
		String password = "Hemant@123";
		String fromStation = "DADAR - DR";
		String toStation = "VAIBHAVWADI RD - VBW";
		String calendarDay = "20";
		String upiID = "9503020610@paytm1";

		By acceptOkButton = By.xpath("//button[normalize-space()='OK']");

		WebDriverManager.edgedriver().setup();		
		driver = new EdgeDriver();		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to(webURL);
		
		wait.until(ExpectedConditions.elementToBeClickable(acceptOkButton));

		if (driver.findElement(acceptOkButton).isDisplayed()) {
			
			
			driver.findElement(acceptOkButton).click();
		}

		driver.findElement(By.xpath("//a[normalize-space()='LOGIN']")).click();		
		driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
			
		Thread.sleep(15000l);
		
		driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//input[@role='searchbox'])[1]"))));
		
		driver.findElement(By.xpath("(//input[@role='searchbox'])[2]")).sendKeys(toStation);		
		Thread.sleep(3000l);
		
		driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys(fromStation);		
		Thread.sleep(3000l);
		
		
		
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']/input")).click();
		selectElementFromList("//tr[@class='ng-tns-c58-10 ng-star-inserted']/td/a",calendarDay);		
		
		driver.findElement(By.xpath("//*[@id='journeyQuota']")).click();
		selectElementFromList("//li[@role='option']/span","TATKAL");
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		
        
        driver.findElement(By.xpath("(//td[@class='active border-all filter-tm pull-left ng-star-inserted'])[1]")).click();
        driver.findElement(By.xpath("(//td[@class='active border-all filter-tm pull-left ng-star-inserted'])[2]")).click();
        driver.findElement(By.xpath("//td[@class='active border-all filter-tm pull-right ng-star-inserted']")).click();
		
		
			
		
		
		
		
		
		
		
		
		

	}
	
	
	public static void selectElementFromList(String webelement, String text) {
		
    List<WebElement> tatkalDropdown = driver.findElements(By.xpath(webelement));
		
		for(int i=0; i<=tatkalDropdown.size(); i++) {
			
			if(tatkalDropdown.get(i).getText().contains(text))
			{
				tatkalDropdown.get(i).click();
				break;
			}
			
		}
		
	}
}
