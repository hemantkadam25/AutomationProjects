package goWorks.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import goWorks.base.Base;

public class Jobs extends Base {
	
private WebDriver driver;
	
	public Jobs(WebDriver driver) {	
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//i[@class='fa fa-plus']")
	private WebElement addJob;	
	
	@FindBy(xpath = "(//ng-select[contains(@class, 'ng-select')])[1]")
	private WebElement clientDropdown;
	
	@FindBy(xpath = "//div[2]/div[1]/div[4]/select")
	private WebElement campaignDropdown;
	
	@FindBy(xpath = "//div[2]/div[1]/div[6]/select")
	private WebElement jobTypeDropdown;
	
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	private WebElement jobName;
	
	@FindBy(xpath = "//ng-select[@class='tags-input ng-select ng-select-typeahead ng-select-multiple ng-select-searchable ng-untouched ng-pristine ng-valid']//span[@class='ng-value-icon left ng-star-inserted'][normalize-space()='×']")
	private WebElement ownerNameRemove;
	
	@FindBy(xpath = "//div[contains(text(),'Enter Owner Name')]")
	private WebElement ownerNameTextBox;
	
	@FindBy(xpath = "//div[@id='showDetailsTab-jc']//button[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//button[@class='btn btn-primary'])[4]")
	private WebElement notifysaveButton;
	
	@FindBy(xpath = "//div[@id='toast-container']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//input[@placeholder='Search...']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button//i[@title='Edit']")
	private WebElement editButton;
	
	@FindBy(xpath = "//button[normalize-space()='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement okButton;
	
	@FindBy(xpath = "//div[@role='alert']/p")
	private WebElement noRecordText;
	
	
	

	
	
	public WebElement getAddJobButton() {
		return addJob;
	}	
	
	public WebElement getClientDropdown() {
		return clientDropdown;
	}
	
	public WebElement getCampaignDropdown() {
		return campaignDropdown;
	}
	
	public WebElement getJobTypeDropdown() {
		return jobTypeDropdown;
	}
	
	public WebElement getJobName() {
		return jobName;
	}
	
	public WebElement getOwnerNameRemove() {
		return ownerNameRemove;
	}
	
	public WebElement getOwnerNameTextBox() {
		return ownerNameTextBox;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getNotifySaveButton() {
		return notifysaveButton;
	}
	
	public WebElement getSuccessMessage() {
		return successMessage;
	}
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
	public WebElement getEditButton() {
		return editButton;
	}
	
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	public WebElement getOkButton() {
		return okButton;
	}
	
	public WebElement getNoRecordText() {
		return noRecordText;
	}
	
	
	
	
	public void getCreateJob(String client, String jobType, String name, String ownerName) throws IOException, InterruptedException {      
		
		
		//getVerifyText(getClientDropdown(), client);
		dropdownSelect(getCampaignDropdown(), getConfigValue("NestleCampaignNameForJob"));	
		
		
	if (jobType.equalsIgnoreCase("Email") || jobType.equalsIgnoreCase("Print") || jobType.equalsIgnoreCase("Social")) {
		
		dropdownSelect(getJobTypeDropdown(), jobType);			
		 getSendKeys(getJobName(), name);
			
			if(getOwnerNameRemove().isDisplayed()) {			
				
				getClick(getOwnerNameRemove());
			}		
		
		selectOwnerName(getOwnerNameTextBox(), ownerName);	
		
		}	
	
	do {
		getClick(getSaveButton());	
	} while(getDriver().findElement(By.xpath("(//div[@class='modal-content'])[4]")).isDisplayed());
	
	getClick(getNotifySaveButton());	
	Thread.sleep(3000l);	
}
	
public void getTypeJobNameAndHitEnter() throws IOException {
		
		getSendKeys(getSearchBox(), getConfigValue("NestleJobNameForDelete"));
		getSearchBox().sendKeys(Keys.ENTER);
		
	}
	
	public void getEditTheJobAndClickOnDelete() throws IOException {			
			getClick(getEditButton());
			getClick(getDeleteButton());
			getClick(getOkButton());	
		
	}
}

	