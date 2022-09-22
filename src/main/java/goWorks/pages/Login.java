package goWorks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import goWorks.base.Base;


public class Login extends Base {
	
	private WebDriver driver;
	
	public Login(WebDriver driver) {	
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	By username1= By.xpath("//input[@id='userName1']");
	
	@FindBy(xpath = "//input[@id='userName1']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password1']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement login;	
	
	@FindBy(xpath = "//div[@id='toast-container']")
	private WebElement alertDialog;
	
	
	
	
	public WebElement getUsername1() {
		
		return driver.findElement(username1);
	}
	
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getLogin() {
		return login;
	}
	
	public WebElement getAlertMessage() {
		return alertDialog;
	}
	
	
      public void doLogin(String username, String password) throws InterruptedException {		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getUsername()));		
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLogin().click();	
		Thread.sleep(2000l);
	}
	
	
	

}
