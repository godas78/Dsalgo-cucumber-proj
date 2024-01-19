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
#Feature: Test Login functionality
Feature: Validate Login page
#@signin_01
 # Scenario: Verifying Register link
 #   Given The user is on signin page
 #   When The user clicks on register link on signin page
 #   Then The user redirected to Registration page from signin page
    
# @signin_02
 # Scenario Outline: User on login page and login with invalid inputs "<username>" and "<password>"
 #   Given The user is on signin page
 #   When The user enter invalid "<username>" and "<password>"
 #   Then click login button to verify

 #   Examples: 
  #    | username | password |
  #    | user     |          |
  #    |          | passowrd |
  #    |          |          |
      
#@signin_03
#  Scenario: Verifying signout link
 #   Given The user is on signin page with valid username "winterchamps" and password "Testwinter1!"
 #   When The user click signout button
 #   Then The user redirected to homepage
   
#@signin_04
#  Scenario: The user is logged in to DS Algo portal
 #   Given The user is on Signin page of DS Algo portal
 #   When The user enter valid "winterchamps" and "Testwinter1!"
 #   And The user click on login button
  #  Then The user logged in successfully

@signin_05
  Scenario Outline: User on login page and login with invalid and valid inputs from Excel "<Sheetname>" and <RowNumber>
    Given The user is on signin page
    When The user enter sheet "<Sheetname>" and <RowNumber>
    Then click login button

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |
      
