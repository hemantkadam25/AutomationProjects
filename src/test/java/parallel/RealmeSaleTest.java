package parallel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RealmeSaleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String webURL = "https://www.realme.com/in/";
		String saleURL = "https://event.realme.com/in/realme-diwali-flashsale";
		String email = "hemantkadam25@gmail.com";
		String password = "Hem@nt25";
		By productWebElement = By.xpath("(//*[@class='good-btn'])[1]");
		String upiID = "9503020610@paytm1";

		By acceptCookie = By.xpath("//*[text()='Accept']");

		WebDriverManager.edgedriver().setup();
		// System.setProperty("webdriver.edge.driver", "E:\\Selenium\\Setup and Jar
		// Files\\Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		// WebDriverManager manager = WebDriverManager.edgedriver();
		// manager.config().setEdgeDriverVersion("103.0.1264.49");
		// manager.setup();
		// EdgeOptions options = new EdgeOptions();
		// WebDriver driver = new EdgeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to(webURL);

		if (driver.findElement(acceptCookie).isDisplayed()) {
			driver.findElement(acceptCookie).click();
		}

		driver.findElement(By.xpath("//*[@id='plus-accountLogin']/label")).click();
		driver.findElement(By.xpath("//*[text()='Sign in with password']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Phone/Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("(//*[text()='Sign in'])[4]")).click();
		
		
		int i = 0;
		while (i <= 1) {

			String text = driver.getTitle();
			System.out.println(text);
			if (text.contains("Sign in")) {				
				Thread.sleep(5000l);				
			}else if (text.contains("Dare to leap")) {
				break;
			}

		}
		
		driver.navigate().to(saleURL);

		while (i <= 1) {

			String text = driver.findElement(productWebElement).getText();
			System.out.println(text);
			if (text.equalsIgnoreCase("Buy Now")) {

				driver.findElement(productWebElement).click();
				//System.out.println(text);
				break;
			}

		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Place Order']")));
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='UPI']")).click();

		driver.findElement(By.xpath("//input[@placeholder='Enter your UPA ID']")).sendKeys(upiID);
		//driver.findElement(By.xpath("//a[normalize-space()='Pay Now']")).click();

	}
}
