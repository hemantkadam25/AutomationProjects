package goWorks.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	private WebDriver driver;
	

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}	
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="(//input[@value='Google Search'])[2]")
	private WebElement searchButton;
	
	public WebElement getSearchBox() {
		return searchTextBox;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}	
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public void getTypeAndSearch() {
		getSearchBox().sendKeys("Testing");
		getSearchBox().sendKeys(Keys.ENTER);
	}

	
	
}