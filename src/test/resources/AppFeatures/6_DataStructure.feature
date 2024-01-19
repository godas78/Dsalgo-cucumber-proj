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
#@data_structure
Feature: User launch dsalgo application and test Data Structure introduction page
	Background: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enter valid "winterchamps" and "Testwinter1!"
    And The user click on login button
    Then The user logged in successfully
    
	@DS_01
  Scenario: The user is able to navigate to Data Structure introduction page
    Given The user is on the "home page" after logged in
    When The user clicks the "Getting Started" button in Data Structure Page introduction Panel
    Then The user be directed to "Data Structures-Introduction" page
       
	@DS_02
  Scenario: The user is able to navigate to Time Complexity page
    Given The user is on the "Data Structures Introduction" after logged in
    When The user clicks Time Complexity link
    Then The user is redirected to "Time Complexity" page
  @DS_03
  Scenario: The user is able to navigate to a page having an tryEditor from Time Complexity page
    Given The user is on the "Time Complexity" after logged in
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test
  @DS_04
  Scenario Outline: The user is able run code in tryEditor for Time Complexity page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<SheetName>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with Run result

    Examples: 
      | SheetName  | RowNumber |
      |pythonCode|0|
      
   @DS_05
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Time Complexity page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button
    Then The user should be presented with error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
    
