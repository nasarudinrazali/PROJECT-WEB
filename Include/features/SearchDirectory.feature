#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@SearchDirectory
Feature: Search directory feature
  As a user, I want to find an employee by using name on directory

  @valid
  Scenario Outline: Search Directory with a valid name
    Given I navigate to OrangeHRM homepage
    When I enter username and password
    And I click Login button
    And I click Directory tab
    And I type <employee_Name>
    And I click on the hint
    And I click on Search button
    Then I should be able to view the <employee_Name> in the record

    Examples: 
      | employee_Name  | 
      | Peter				 	 | 
      
     

   @invalid
    Scenario Outline: Search Directory with an invalid name
    Given I navigate to OrangeHRM homepage
    When I enter username and password
    And I click Login button
    And I click Directory tab
    And I type <employee_Name>
    And I click on the hint
    Then I should be able to view the invalid message
    
     Examples: 
      | employee_Name	|
      | test+username |  
    
   
   
   