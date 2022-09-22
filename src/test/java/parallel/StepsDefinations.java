package parallel;

import java.io.IOException;
import org.testng.Assert;
import goWorks.base.Base;
import goWorks.pages.Campaign;
import goWorks.pages.Dashboard;
import goWorks.pages.Jobs;
import goWorks.pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepsDefinations extends Base {	
		
	public Login login = new Login(getDriver());
	public Dashboard dashboard = new Dashboard(getDriver());	
	public Campaign campaign = new Campaign(getDriver());
	public Jobs jobs = new Jobs(getDriver());
	
	
	
	@Given("I navigate to {string} login page and page title should be {string}")
	public void i_navigate_to_login_page_and_page_title_should_be(String webURL, String expectedPageTitle) throws IOException {	    
		
		getDriverNavigate(webURL);
		Assert.assertEquals(getPageTitle(expectedPageTitle), expectedPageTitle);
	}

	@When("I enter username, password and click on login button")
	public void i_enter_username_password_and_click_on_login_button() throws IOException, InterruptedException {
		
		login.doLogin(getConfigValue("AdminUsername"), getConfigValue("AdminPassword"));
		
	}

	@Then("I navigate to dashboard page and page title should be {string}")
	public void i_navigate_to_dashboard_page_and_page_title_should_be(String expectedPageTitle) {
	   
		Assert.assertEquals(getPageTitle(expectedPageTitle), expectedPageTitle);
	}

	@Then("I can see logout link on the dashboard page")
	public void i_can_see_logout_link_on_the_home_page() {	   
		
        Assert.assertTrue(dashboard.getLogout().isDisplayed());		
	}
	
	@When("I enter invalid {string}, {string} and click on login button")
	public void i_enter_invalid_and_click_on_login_button(String username, String password) throws InterruptedException {
	    
		login.doLogin(username, password);
	}

	@Then("It display an error message as {string}")
	public void it_display_an_error_message_as(String expectedErrorMessage) {
	   
		Assert.assertTrue(login.getAlertMessage().getText().contains(expectedErrorMessage));
		
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedPageTitle) {	    
		
		Assert.assertEquals(expectedPageTitle, getPageTitle(expectedPageTitle));
	}

	
	
	@Given("I login as admin and client is {string}")
	public void i_login_as_admin_and_client_is(String expectedClientName) throws InterruptedException, IOException  {
		
		login.doLogin(getConfigValue("AdminUsername"), getConfigValue("AdminPassword"));
	   
	}
	
	@Given("I navigate to Jobs page and page title should be {string}")
	public void i_navigate_to_jobs_page_and_page_title_should_be(String expectedPageTitle) {
	    
		dashboard.getJobsMenu().click();
		Assert.assertEquals(getPageTitle(expectedPageTitle), expectedPageTitle);
		
	}
	
	@Given("I click on the Add Job button")
	public void i_click_on_the_add_job_button() {
		
		jobs.getAddJobButton().click();
	    
	}
	
	@When("I enter {string}, Campaign, {string}, {string}, {string}")
	public void i_enter_campaign(String client, String jobType, String name, String ownerName) throws IOException, InterruptedException {
	   
		jobs.getCreateJob(client, jobType, name, ownerName);
	}
	
	@Then("It display {string} message")
	public void it_display_message(String string) {
	   
	}

		
		
}

	
	
	
	
	
	
	
