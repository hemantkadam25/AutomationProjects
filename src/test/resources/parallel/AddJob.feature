Feature: Create new job for print, social and email job type from job page.

  Background: 
    Given I navigate to "GoWorks" login page and page title should be "Go Works"
    And I login as admin and client is "Nestle Australia"
    
    
@Skip
  Scenario Outline: To verify whether new print job has been created from job page
    Given I navigate to Jobs page and page title should be "Jobs"
    And I click on the Add Job button
    When I enter "<Client>", Campaign, "<Job Type>", "<Name>", "<Owner Name>"
    Then It display "Success Insert successful" message

    Examples: 
      | Client           | Job Type | Name                                   | Owner Name   |
      | Nestle Australia | Print    | Test Job Hemant Print WebAutomation 01 | Hemant Kadam |


 @Skip
 Scenario Outline: To verify whether new social job has been created from job page
    Given I navigate to Jobs page and page title should be "Jobs1"
    And I click on the Add Job button
    When I enter "<Client>", Campaign, "<Job Type>", "<Name>", "<Owner Name>"
    Then It display "Success Insert successful" message

    Examples: 
      | Client           | Job Type | Name                                    | Owner Name   |
      | Nestle Australia | Social   | Test Job Hemant Social WebAutomation 01 | Hemant Kadam |

@Skip 
  Scenario Outline: To verify whether new email job has been created from job page
    Given I navigate to Jobs page and page title should be "Jobs"
    And I click on the Add Job button
    When I enter "<Client>", Campaign, "<Job Type>", "<Name>", "<Owner Name>"
    Then It display "Success Insert successful" message

    Examples: 
      | Client           | Job Type | Name                                   | Owner Name   |
      | Nestle Australia | Email    | Test Job Hemant Email WebAutomation 01 | Hemant Kadam |
 