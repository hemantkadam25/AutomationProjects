package goWorks.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import goWorks.base.Base;



public class Dashboard extends Base {
	
	private WebDriver driver;
	
	public Login login = new Login(getDriver());
		
	public Dashboard(WebDriver driver) {	
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//a[@class='logout-btn']")
	WebElement logout;
	
	@FindBy(xpath="//select[@class='header-client-drop ng-untouched ng-pristine ng-valid']")
	private WebElement clientDropdown;
	
	@FindBy(xpath="//a[@title='Campaigns']")
	private WebElement campaignMenu;	
	
	@FindBy(xpath="//div[@class='header-block']")
	private WebElement welcomeText;
	
	@FindBy(xpath="//a[@title='Jobs']")
	private WebElement jobsMenu;
		
	
	
	public WebElement getLogout() {
		return logout;
	}	
	
	public WebElement getClientDropdown() {
		return clientDropdown;
	}	
	
	public WebElement getCampaign() {
		return campaignMenu;
	}
	
	public WebElement getWelcomeText() {
		return welcomeText;
	}
	
	public WebElement getJobsMenu() {
		return jobsMenu;
	}
	
	
	
	/////
	
	// common methods
	
	
	
	public void doLoginAndWaitForClientName (String expectedClientName) throws IOException, InterruptedException {		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(login.getUsername()));
		login.doLogin(getConfigValue("AdminUsername"), getConfigValue("AdminPassword"));
		
		String welcomeText = getWelcomeText().getText();
		
		if(!welcomeText.contains(expectedClientName)) {
			
			dropdownSelect(getClientDropdown(), expectedClientName);
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getCampaign()));			
			
		}

	}
	
	public void getCampaignClick() {
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getCampaign()));
		getCampaign().click();
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getCampaign()));
		
	}
	
	
	
}








