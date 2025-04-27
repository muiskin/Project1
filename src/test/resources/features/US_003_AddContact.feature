@US003
Feature: Contact List Add

  Background:
    Given user goes to home page
    When enter valid email("qwe@qwe.com") for login
    And enter valid password("qweqweqwe") for login
    And the user clicks the login button

  @US003AccessAddContactFeature
  Scenario: User can access the Add Contact feature from the application's main menu
    Then assert that add contact button displayed
    And close driver

    #Firstname and Lastname are mandatory

  @US003ValidFirstAndLastName
  Scenario: user can add a new contact with valid mandatory fields
    When the user clicks the add a new contact button
    And the user enter valid firstname "Faker"
    And the user enter valid lastname "Faker"
    And the user clicks the submit button
    Then assert that user added
    And close driver

  @US003EmptyFirstname
  Scenario: user can not add a new contact with empty firstname
    When the user clicks the add a new contact button
    And the user enter valid firstname ""
    And the user enter valid lastname "Faker"
    And the user clicks the submit button
    Then assert that add contact page error message is contains "firstName"
    And close driver

  @US003EmptyLastname
  Scenario: user can not add a new contact with empty lastname
    When the user clicks the add a new contact button
    And the user enter valid firstname "Faker"
    And the user enter valid lastname ""
    And the user clicks the submit button
    Then assert that add contact page error message is contains "lastName"
    And close driver

#  @US003FirstnameWithNumber
#  Scenario: user can not add a new contact when firstname with numbers
#    When the user clicks the add a new contact button
#    And the user enter valid firstname "12345"
#    And the user enter valid lastname "Faker"
#    And the user clicks the submit button
#    Then assert that add contact page error message is contains "firstName"
#    And close driver
#
#  @US003LastnameWithNumber
#  Scenario: user can not add a new contact when lastname with numbers
#    When the user clicks the add a new contact button
#    And the user enter valid firstname "Faker"
#    And the user enter valid lastname "12345"
#    And the user clicks the submit button
#    Then assert that add contact page error message is contains "lastName"
#    And close driver
#
#  @US003FirstnameWithSpecialCharacters
#  Scenario: user can not add a new contact when firstname with special characters
#    When the user clicks the add a new contact button
#    And the user enter valid firstname "@!.-'*"
#    And the user enter valid lastname "Faker"
#    And the user clicks the submit button
#    Then assert that add contact page error message is contains "firstName"
#    And close driver
#
#  @US003LastnameWithSpecialCharacters
#  Scenario: user can add a new contact when lastname with special characters
#    When the user clicks the add a new contact button
#    And the user enter valid firstname "Faker"
#    And the user enter valid lastname "@!.-'*"
#    And the user clicks the submit button
#    Then assert that add contact page error message is contains "lastName"
#    And close driver

  @US003EditContactByClicking
  Scenario: The user should be able to view the details of the newly added contact by clicking on it from the contact list
    When the user clicks the recently added contact
    Then assert that edit contact button is displayed
    And close driver



