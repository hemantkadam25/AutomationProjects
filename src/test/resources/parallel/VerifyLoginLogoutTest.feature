
Feature: To check GoWorks login logout functionality with valid and invalid credentials.

@Sanity
  Scenario: To verify GoWorks login functionality with valid credential
    Given I navigate to "GoWorks" login page and page title should be "Go Works"
    When I enter username, password and click on login button
    Then I navigate to dashboard page and page title should be "Dashboard"
    And I can see logout link on the dashboard page
    
    
@Sanity
Scenario Outline: To verify GoWorks login functionality with invalid credential
    Given I navigate to "GoWorks" login page and page title should be "Go Works"
    When I enter invalid "<username>", "<password>" and click on login button
    Then It display an error message as "Please check your username and password and try again."
    And page title should be "Go Works"
    
    
    Examples:
    | username | password |
    | HemantK  | Abc@123  |