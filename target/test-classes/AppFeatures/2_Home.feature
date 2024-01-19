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
#@tag
Feature: User launch dsalgo application and navigate to Home page
@home_01
  Scenario: User launch home page of dsalgo project
    Given The user opens DS Algo portal link
    When User Click on "Get Started"
    Then Home Page Title should be "NumpyNinja" 
    
@home_02
  Scenario Outline:user click on getstarted link "<option>" on homepage without login
    Given User is on Homepage
    When now click on "<option>" get started without login
   Then The user get warning message "You are not logged in"
    
    Examples: 
      | option         |
      | Data Structures-Introduction |
      | Arrays         |
      | Linkedlist     |
      | Stack          |
      | Queue          |
      | Tree           |
      | Graph          |
    
   @home_03
  Scenario Outline: User is on Home page and click on dropdown "<option>" without sign in
    Given User is on Homepage
    When The user clicks on dropdown "<option>"
    Then The user get warning message "You are not logged in"

    Examples: 
      | option     |
      | Arrays     |
      | Linkedlist |
      | Stack      |
      | Queue      |
      | Tree       |
      | Graph      |
    
 @home_04
  Scenario: User is on Home page and click on sign in
    Given User is on Homepage
    When The user clicks on signin link
    Then The user redirected to login page

  @home_05
  Scenario: User is on Homepage and click on Register
    Given User is on Homepage
    When The user clicks on register link
    Then The user redirected to Registration page
