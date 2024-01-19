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
@register
Feature: Validate Register page
  @register_01
  Scenario: launch to Homepage
   	Given The user opens DS Algo portal link
    When User Click on "Get Started"
    Then Home Page Title should be "NumpyNinja" 
  #Scenario: User is on Homepage and click on Register
    Given User is on Homepage
    When The user clicks on register link
    Then The user redirected to Registration page
 # @register_02
  #Scenario: The user is presented with error message for empty fields below Username textbox
   # Given The user opens Register Page
   # When The user clicks "Register" button with all fields empty
   # Then It should display an error message "Please fill out this field." below Username textbox
   @register_03
  Scenario: The user is presented with error message for empty fields below Password textbox
    Given The user opens Register Page
    When The user clicks "Register" button after entering username with other fields empty
      | username       |
      | testing123 |
    Then It should display an error message "Please fill out this field." below Password textbox
   @register_04
  Scenario: The user is presented with error message for empty fields below confirm Password textbox
    Given The user opens Register Page
    When The user clicks "Register" button after entering "username" and "password" with Password Confirmation field empty
      | username       | password     |
      | testuser123 | testpassword |
    Then It should display an error message "Please fill out this field." below Password Confirmation textbox
    @register_05
  Scenario: The user is presented with error message for invalid username
    Given The user opens Register Page
    When The user enters a "username" with characters other than Letters, digits and "@/./+/-/_"
      | username | password     | password confirmation |
      | &**&**&  | testpassword | testpassword          |
    Then It should display an error message "password_mismatch:The two password fields didn’t match."
     @register_06
  Scenario: The user is presented with error message for password mismatch
    Given The user opens Register Page
    When The user clicks "Register" button after entering valid "username" and different passwords in "password" and "password confirmation" fields
      | username       | password     | password confirmation |
      | winterchamps | testpassword | testpassword1         |
    Then It should display an error message "password_mismatch:The two password fields didn’t match."
    @register_07
  Scenario: The user redirected to Homepage with valid details
    Given The user opens Register Page
    When The user enters a valid "username" and "password" and "password confirmation"
      | username       | password  | password confirmation |
      | winterchamps12 | Testwinter1! |  Testwinter1! |
    Then The user should be redirected to Homepage with the message "New Account Created. You are logged in as <username>"
  #   @register_08
  #Scenario Outline: User on signin page and login with valid credentials
  #  Given The user is on signin page
   # When The user enter valid "<username>" and "<password>"
    #Then click login button to verify

    #Examples: 
     # | username       | password  |
      #| winterchamps | Testwinter1! |