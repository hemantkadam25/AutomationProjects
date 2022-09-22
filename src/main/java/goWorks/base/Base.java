package goWorks.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {		
	
public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	
	public static Logger log = Logger.getLogger(Base.class.getName());	
	
    public String getConfigValue(String key) throws IOException {  
    	
    	String projectPath = System.getProperty("user.dir");  // To get project folder path  	
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(projectPath+"\\src\\main\\java\\goWorks\\configFiles\\config.properties"); 
		properties.load(fileInputStream);		
		return (String) properties.get(key);
			
	}

	public WebDriver initialization() throws IOException {			
		
		String browserName = getConfigValue("Browser");					

		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();			
			threadLocal.set(new ChromeDriver());			
			log.info("Execution start on "+browserName+" browser");
			

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "");
			threadLocal.set(new FirefoxDriver());
			log.info("Execution start on "+browserName+" browser");

		} else if (browserName.equalsIgnoreCase("Edge")) {

			//System.setProperty("webdriver.edge.driver", "");
			WebDriverManager.edgedriver().setup();
			threadLocal.set(new EdgeDriver());	
			log.info("Execution start on "+browserName+" browser");

		} else if (browserName.equalsIgnoreCase("IE")) {

			WebDriverManager.iedriver().setup();
			threadLocal.set(new InternetExplorerDriver());
			log.info("Execution start on "+browserName+" browser");

		} else if (browserName.equalsIgnoreCase("Chrome_Headless")) {

			WebDriverManager.chromedriver().setup();			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");					 
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			options.addArguments("disable-gpu");
	        options.addArguments("window-size=1400,2100"); 
	        threadLocal.set(new ChromeDriver(options));	
			log.info("Execution start on "+browserName+" browser");

		} else if (browserName.equalsIgnoreCase("Edge_Headless")) {

			WebDriverManager.edgedriver().setup();			
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless");
			options.addArguments("--headless");					 
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			options.addArguments("disable-gpu");
	        options.addArguments("window-size=1400,2100");       
			
			threadLocal.set(new EdgeDriver(options));
			log.info("Execution start on "+browserName+" browser");

		}else if (browserName.equalsIgnoreCase("Firefox_Headless")) {

			WebDriverManager.firefoxdriver().setup();			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--headless");
			options.addArguments("--headless");					 
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			options.addArguments("disable-gpu");
	        options.addArguments("window-size=1400,2100");
			threadLocal.set(new FirefoxDriver(options));
			log.info("Execution start on "+browserName+" browser");

		}		
		

		getDriver().manage().window().maximize();			
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
					
		return getDriver();			
	}
	
	
	public static synchronized WebDriver getDriver() {
		return threadLocal.get();
	}
	
	public void getDriverNavigate(String webURL) throws IOException {
		getDriver().get(getConfigValue(webURL));
		//getDriver().get("https://goworks.ergoengineering.com/goworks/#/login");
	}
	
     public void getDriverQuit() {
		
    	 log.info("Browser Quit");
    	 getDriver().quit();		
	}     
     
	
	public WebDriverWait getWebDriverWait() {
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));		
		return wait;
	}
	
	public String getPageTitle(String expectedPageTitle) {			
		
		getWebDriverWait().until(ExpectedConditions.titleContains(expectedPageTitle));		
		return getDriver().getTitle();
	}
	
   public void getClick(WebElement webelement) {			
		
	   getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webelement));
	   webelement.click();		
	}
   
   public void getSendKeys(WebElement webelement, String text) {			
		
	   getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webelement));
	   webelement.sendKeys(text);
	}
	
   public void dropdownSelect (WebElement webelement, String selectVisibleText)  {		
		
	   getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webelement));
		Select select = new Select(webelement);
		select.selectByVisibleText(selectVisibleText);		
	}
   
   public void selectOwnerName(WebElement webelement, String expectedText) {
	   
	   Actions actions = new Actions(getDriver());
       actions.moveToElement(webelement).sendKeys(expectedText).build().perform();	
       
       
       
       //webelement.sendKeys();
      List<WebElement> element = getDriver().findElements(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div/span"));
     
      
      for (int i=0; i<element.size(); i++) {
    	  
    	if(element.get(i).getText().equalsIgnoreCase(expectedText)) {
    		element.get(i).click();
    	}
      }	
   }
   
   public void getVerifyText(WebElement webelement, String expectedMessage) {
	   
	   getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webelement));
	   webelement.getText().equalsIgnoreCase(expectedMessage);
   }
   
 /// Select start and due date in calendar
	
	public void selectDatesInCalendar(WebElement calendar, List<WebElement> dayList, WebElement monthDropdown, WebElement yearDropdown, String day, String month, String year) {			
		
		getClick(calendar);	
		
		dropdownSelect(monthDropdown, month);
		dropdownSelect(yearDropdown, year);  
		
		
		for (int i=0; i<dayList.size(); i++ ) {				
			
			if (dayList.get(i).getText().equalsIgnoreCase(day)) {		
				
				getClick(dayList.get(i));
				break;
			}
			
		}			
	
	}
   
  
}