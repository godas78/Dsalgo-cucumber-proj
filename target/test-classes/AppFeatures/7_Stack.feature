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
@stack
Feature: User tests the stack page on the Ds algo application

  Background: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enter valid "winterchamps" and "Testwinter1!"
    And The user click on login button
    Then The user redirected to homepage

  @stack_02
  Scenario: The user is directed to "Stack" Page
    Given The user is on the "home page" after logged in
    When The user selects Stack item from the drop down menu
    Then The user should be directed to "Stack" Page
  @stack_03
  Scenario: The user is able to navigate to "Operations in Stack" page
    Given The user is on the "Stack page" after logged in
    When The user clicks on the Operations in Stack link
    Then The user should then be directed to "Operations in Stack" Page
  @stack_04
  Scenario: The user is able to navigate to a page having an tryEditor from Operations in Stack page
    Given The user is on the "Operations in Stack page" after logged in
    When The user clicks "Try Here" button in "stack" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test
   @stack_05
  Scenario Outline: The user is able to run code in tryEditor for Operations in Stack page
    Given The user is in stack page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in stack tryEditor
    Then The user should be presented with Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @stack_06
  Scenario Outline: The user is able to get the error message for invalid syntax for Operations in Stack page
    Given The user is in stack page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in stack tryEditor
    Then The user should be presented with error output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
   @stack_07
  Scenario: The user is able to navigate to "Implementation" Page
    Given The user is on the "Stack page" after logged in
    When The user clicks on the Implementation button
    Then The user should be directed to Implementation Page
   @stack_08
  Scenario: The user is able to navigate to Implementation page having an tryEditor 
    Given The user is on the "Stack Implementation page" after logged in
    When The user clicks "Try Here" button in "stack Implementation" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test
   @stack_09
  Scenario Outline: The user is able to run code in tryEditor for stack Implementation page
    Given The user is in stack page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in stack tryEditor
    Then The user should be presented with Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @stack_10
  Scenario Outline: The user is able to get the error message for invalid syntax for stack Implementation page
    Given The user is in stack page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in stack tryEditor
    Then The user should be presented with error output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
   @stack_11
  Scenario: The user is able to navigate to "Applications" in stack Page
    Given The user is on the "Stackpage" after logged in
    When The user clicks on the Applications button
    Then The user should be directed to Applications Page
   @stack_12
  Scenario: The user is able to navigate to Applications page having an tryEditor
    Given The user is on the "Application stack page" after logged in
    When The user clicks "Try Here" button in "stack Applications" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test
   @stack_13
  Scenario Outline: The user is able to run code in tryEditor for stack Applications page
    Given The user is in stack page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in stack tryEditor
    Then The user should be presented with Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @stack_14
  Scenario Outline: The user is able to get the error messagefor invalid syntax for stack Applications page
    Given The user is in stack page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in stack tryEditor
    Then The user should be presented with error output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @stack_15
  Scenario: The user is able to navigate to "Practice Questions" in stack Page
    Given The user is on the "Stack page" after logged in
    When The user clicks on the Practice Questions button
    Then The user should be directed to Practice Questions  Page