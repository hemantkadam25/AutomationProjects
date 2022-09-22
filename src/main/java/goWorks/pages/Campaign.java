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


public class Campaign extends Base {
	
private WebDriver driver;
	
	public Campaign(WebDriver driver) {	
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath = "//button[normalize-space()='Get a quote']")
	private WebElement getaQuote;

	@FindBy(xpath = "//input[@name='requireProject']")
	private WebElement projectName;

	@FindBy(xpath = "//input[@name='milestonestartDate']")
	private WebElement completionDate;

	@FindBy(xpath = "//div[@class='form-group ng-star-inserted']//input[@placeholder='Type here']")
	private WebElement projectContact;

	@FindBy(xpath = "//select[@id='select-102']")
	private WebElement division;

	@FindBy(xpath = "//select[@id='select-103']")
	private WebElement brand;

	@FindBy(xpath = "(//div[@class='form-group']/Select)[5]")
	private WebElement kmmsContact;

	@FindBy(xpath = "//button[normalize-space()='Save Campaign']")
	private WebElement saveCampaign;

	@FindBy(xpath = "//div[@id='toast-container']/div/div[2]/ul")
	private WebElement errorMessage;

	@FindBy(xpath = "//select[@id='select-104']")
	private WebElement channel;

	@FindBy(xpath = "//textarea[@placeholder='Type here']")
	private WebElement comments;

	@FindBy(xpath = "//div[@class='toast-success ngx-toastr ng-trigger ng-trigger-flyInOut']")
	private WebElement successMessage;	                 

	@FindBy(xpath = "//button[normalize-space()='Add Campaign']")
	private WebElement addCampaign;	

	@FindBy(xpath = "//select[@name='choice']")
	private WebElement clientDropDown;

	@FindBy(xpath = "//input[@name='campaignCrudname']")
	private WebElement campaignName;

	@FindBy(xpath = "//div[contains(text(),'Enter Name')]")
	private WebElement ownerName;

	@FindBy(xpath = "//div[@class='ng-option ng-option-marked ng-star-inserted']")
	private WebElement populateOwnerName;	
		
	@FindBy(xpath = "//input[@name='campaignCrudstartDate']")
	private WebElement startDate;

	@FindBy(xpath = "//input[@name='campaignCruddeadLine']")
	private WebElement dueDate;

	@FindBy(xpath = "//button[@class='btn btn-primary']/span")
	private WebElement save;
	
	@FindBy(xpath = "//ng-select[@placeholder='Enter Channel Category']")
	private WebElement channelCategory;	
		
	@FindBy(xpath = "//div[contains(@class,'ng-option-marked')]")
	private WebElement populateChannelName;	
		
	@FindBy(xpath = "//div[5]/app-project-meta-data/div/select")
	private WebElement kmmsContact1;                   
	
	@FindBy(xpath = "//input[@placeholder='Type here']")
	private WebElement projectContact1;
	
	@FindBy(xpath = "//select[@id='select-102']")
	private WebElement division1;
	
	@FindBy(xpath = "//select[@id='select-103']")
	private WebElement brand1;
	
	@FindBy(xpath = "//select[@id='select-104']")
	private WebElement channel1;
	
	@FindBy(xpath = "//textarea[@name='comments']")
	private WebElement comments1;	
	
	@FindBy(xpath = "//select[contains(@class, 'datepicker-year')]")
	private WebElement datepickerYearDropdown;
	
	@FindBy(xpath = "//select[contains(@class, 'datepicker-month')]")
	private WebElement datepickerMonthDropdown;
	
	@FindBy(xpath = "//td[contains(@class,'ng-star-inserted')]")
	private List<WebElement> dayCalendar;  
	
	
	public WebElement getGetAQuote() {
		return getaQuote;
	}

	public WebElement getProjectName() {
		return projectName;
	}

	public WebElement getCompletionDate() {
		return completionDate;
	}

	public WebElement getProjectContact() {
		return projectContact;
	}

	public WebElement getDivision() {
		return division;
	}

	public WebElement getBrand() {
		return brand;
	}

	public WebElement getKmmsContact() {
		return kmmsContact;
	}

	public WebElement getSaveCampaign() {
		return saveCampaign;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public WebElement getChannel() {
		return channel;
	}

	public WebElement getComments() {
		return comments;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public WebElement getAddCampaign() {
		return addCampaign;
	}

	public WebElement getClientDropDown() {
		return clientDropDown;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getOwnerName() {
		return ownerName;
	}

	public WebElement getPopulatedOwnerName() {
		return populateOwnerName;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getDueDate() {
		return dueDate;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getChannelCategory() {
		return channelCategory;
	}
	
	public WebElement getPopulateChannelName() {
		return populateChannelName;
	}
	
	public WebElement getKmmsContact1() {
		return kmmsContact1;
		       
	}
	
	public WebElement getProjectContact1() {
		return projectContact1;
	}
	
	public WebElement getDivision1() {
		return division1;
	}
	
	public WebElement getBrand1() {
		return brand1;
	}
	
	public WebElement getChannel1() {
		return channel1;
	}
	
	public WebElement getComments1() {
		return comments1;
	}
		
	public WebElement getDatepickerYearDropdown() {
		return datepickerYearDropdown;
	}
	
	public WebElement getDatepickerMonthDropdown() {
		return datepickerMonthDropdown;
	}
	
	public List<WebElement> getDayCalendar() {
		return dayCalendar;
	}
	

	
	
	
	
	/// ********************************** ////

		// common methods

		public void getCreateCampaignThroughGetAQuote(String projectname, String completiondate, String projectcontact,
				String division, String brand, String channel, String kmmscontact, String comments) {
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getDivision()));
			getSaveCampaign().click();
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getErrorMessage()));
			getErrorMessage().getText()
					.contains("Name Required - please key in Name Due Date Required KMMS Contact Required");

			getProjectName().sendKeys(projectname);
			getCompletionDate().sendKeys(completiondate);
			getProjectContact().sendKeys(projectcontact);
			dropdownSelect(getDivision(), division);
			dropdownSelect(getBrand(), brand);
			dropdownSelect(getKmmsContact(), kmmscontact);
			dropdownSelect(getChannel(), channel);
			getComments().sendKeys(comments);
			getSaveCampaign().click();

		}
		
		

		public void getVerifySuccessMessage(WebElement element, String successMessage) {

			getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
			element.getText().contains(successMessage);
		}

		
		
			

		public void getCreateCampaignThroughAddCampaign(String client, String ownername, String startdate,	String duedate, String kmmscontact, String projectcontact, String division, String brand, String channel, String comments) throws InterruptedException, IOException {

			Thread.sleep(3000l);			
			getClick(getSave());			
			getErrorMessage().getText().contains("Name Required - please key in Name Start Date Required Due Date Required");
			Actions actions = new Actions(driver);		
			dropdownSelect(getClientDropDown(), client);			
			getSendKeys(getCampaignName(), getConfigValue("NestleCampaignName"));
			
			actions.moveToElement(getOwnerName()).click().sendKeys(ownername).build().perform();			
			getPopulatedOwnerName().click();
			
			selectDatesInCalendar(getDueDate(), getDayCalendar(), getDatepickerMonthDropdown(), getDatepickerYearDropdown(), "1", "December","2025");
			selectDatesInCalendar(getStartDate(), getDayCalendar(), getDatepickerMonthDropdown(), getDatepickerYearDropdown(), "1", "January","2015");
			
			getClick(getChannelCategory());			
			int size = driver.findElements(By.xpath("//div[@role='option']")).size();
			
            for (int i=0; i<size; i++) 
				
			{	
				actions.moveToElement(getChannelCategory()).sendKeys(Keys.ENTER).build().perform();
			}
			
			dropdownSelect(getKmmsContact1(), kmmscontact);		
			getProjectContact1().sendKeys(projectcontact);
			dropdownSelect(getDivision1(), division);		
			dropdownSelect(getBrand1(), brand);	
			dropdownSelect(getChannel1(), channel);			
			getSendKeys(getComments1(), comments);
			getClick(getSave());
			
			
			
			//actions.doubleClick(getSave()).build().perform();		

		}
	

		




}








