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
@linkedlist  
Feature: Testing LinkedList page
  Background: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enter valid "winterchamps" and "Testwinter1!"
    And The user click on login button
    Then The user redirected to homepage
 
@ll_01
  Scenario: User navigated to "linked list" page
    Given The user is on the "home page" after logged in
    When The user selecting linkedlist item from the drop down menu
    Then The user redirected to "Linked List" Page
  
 @ll_02
  Scenario: User navigated to "Introduction" page of linked list
    Given The user is on the "Linked List page" after logged in
    When The user clicks Introduction link
    Then The user redirected to "Introduction" Page
    
 @ll_03
  Scenario: User navigated to tryEditor page with Run button from Introduction page
    Given The user is on the "Introduction" after logged in
    When The user clicks "Try Here" button in the "introduction" page
    Then The user redirected to the page having an tryEditor with a Run button to test
 @ll_04
  Scenario Outline: The user run the code in tryEditor with valid input for Introduction page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |
  @ll_05
  Scenario Outline: The user getting error message with invalid python code for Introduction page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user get the error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
  @ll_06
  Scenario: User navigated to "creating linked list" page
    Given The user is on the "Linked List page" after logged in
    When The user clicks creating linked list link
    Then The user should be directed to "Creating Linked LIst" of Linked List Page
  @ll_07
  Scenario: User navigated to tryEditor page with Run button from Creating a Linked List page
    Given The user is on the "Creating a Linked List" after logged in
    When The user clicks "Try Here" button in the "creating linked list" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test
  @ll_08
  Scenario Outline: The user run the code in tryEditor with valid input for Creating a Linked List page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |    
   @ll_09
  Scenario Outline: The user getting error message with invalid python code for Creating a Linked List page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user get the error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
      
   @ll_10
  Scenario: User navigated to "Types of linked list" page
    Given The user is on the "Linked List page" after logged in
    When The user clicks the Types of Linked List button
    Then The user should be directed to "Types of Linked List" of Linked List Page
   @ll_11
  Scenario: User navigated to tryEditor page with Run button from Types of Linked List
    Given The user is on the "Types of Linked list" after logged in
    When The user clicks "Try Here" button in the "types of linked list" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  @ll_12
  Scenario Outline: The user run the code in tryEditor with valid input for Types of Linked List
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @ll_13
  Scenario Outline: The user getting error message with invalid python code for Types of Linked List
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user get the error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
    @ll_14
  Scenario: user navigated to "Implementation linked list in python" page
    Given The user is on the "Linked List page" after logged in
    When The user clicks the Implement Linked List in Python button
    Then The user should be directed to "Implement Linked List in Python" of Linked List Page
   @ll_15
  Scenario: User navigated to tryEditor page with Run button from Implement Linked List in Python page
    Given The user is on the "Implement Linked List in Python" after logged in
    When The user clicks "Try Here" button in the "implemented linked list in python" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test

 	@ll_16
  Scenario Outline: The user run the code in tryEditor with valid input for Implement Linked List in Python page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @ll_17
  Scenario Outline: The user getting error message with invalid python code for Implement Linked List in Python page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user get the error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
    @ll_18
  Scenario: user navigated to "Traversal" page
    Given The user is on the "Linked List page" after logged in
    When The user clicks the Traversal button
    Then The user should be directed to "Traversal" of Linked List Page
    @ll_20
  Scenario: User navigated to tryEditor page with Run button from Traversal page
    Given The user is on the "Traversal" after logged in
    When The user clicks "Try Here" button in the "traversal" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test

 @ll_21
  Scenario Outline: The user run the code in tryEditor with valid input for Traversal page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

 	@ll_22
  Scenario Outline: The user getting error message with invalid python code for Traversal page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user get the error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
     @ll_23
  Scenario: user navigated to "Insertion" page
    Given The user is on the "Linked List page" after logged in
    When The user clicks the Insertion button
    Then The user should be directed to "Insertion" of Linked List Page
    @ll_24
  Scenario: User navigated to tryEditor page with Run button from Insertion page
    Given The user is on the "Insertion" after logged in
    When The user clicks "Try Here" button in the "Insertion" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test

 	@ll_25
  Scenario Outline: The user run the code in tryEditor with valid input for Insertion page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @ll_26
  Scenario Outline: The user getting error message with invalid python code for Insertion page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user get the error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
    @ll_27
  Scenario: user navigated to "Deletion" page
    Given The user is on the "Linked List page" after logged in
    When The user clicks the Deletion button
    Then The user should be directed to "Deletion" of Linked List Page
   @ll_28
  Scenario: User navigated to tryEditor page with Run button from Deletion page
    Given The user is on the "Deletion" after logged in
    When The user clicks "Try Here" button in the "Deletion" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  @ll_29
  Scenario Outline: The user run the code in tryEditor with valid input for Deletion page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @ll_30
  Scenario Outline: The user getting error message with invalid python code for Deletion page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user get the error message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
    @ll_31
  Scenario: The user validating "Practice Questions" page
    Given The user is on the "Linked List page" after logged in
    When The user clicks Introduction link
    And The user clicks on the Practice Questions
    Then The user should be directed to Practice Questions of Linked List Page
    