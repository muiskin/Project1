@US001
Feature: Registration

  Background: go to home page
    Given user goes to home page
    When user clicks the sign up page

  @US001Positive
  Scenario: User can create an account with valid information
    When enter firstname "John"
    And enter lastname "Doe"
    And enter email "Faker"
    And enter password "Pass_123"
    And enter submit button
    Then assert that logout button is displayed
    And close driver
    And assert that the user login via API


  @US001EmptyFirstname
  Scenario: User cannot create account if firstname is empty
    When enter firstname ""
    And enter lastname "Doe"
    And enter email "Faker"
    And enter password "Pass_123!"
    And enter submit button
    Then assert that error message is contains "firstName"
    And close driver
    And assert that the user cannot login via API

#  @US001FirstnameContainsSpecialCharacters  //This Sign up page is accept firstname with special characters
#  Scenario: User cannot create account if firstname contains special characters
#    When enter firstname "@#\$%&*"
#    And enter lastname "Doe"
#    And enter email "Faker"
#    And enter password "Pass_123!"
#    And enter submit button
#    Then assert that error message is contains "firstName"
#    And close driver

#  @US001FirstnameContainsNumbers  //This Sign up page is accept firstname with numbers
#  Scenario: User cannot create account if firstname contains numbers
#    When enter firstname "John123"
#    And enter lastname "Doe"
#    And enter email "Faker"
#    And enter password "Pass_123!"
#    And enter submit button
#    Then assert that error message is contains "firstName"
#    And close driver

  @US001EmptyLastname
  Scenario: User cannot create account if lastname is empty
    When enter firstname "John"
    And enter lastname ""
    And enter email "Faker"
    And enter password "Pass_123!"
    And enter submit button
    Then assert that error message is contains "lastName"
    And close driver
    And assert that the user cannot login via API

#  @US001LastnameContainsSpecialCharacters //This Sign up page is accept lastname with special characters
#  Scenario: User cannot create account if lastname contains special characters
#    When enter firstname "John"
#    And enter lastname "@#%!"
#    And enter email "john.doe@example.com"
#    And enter password "Pass_123!"
#    And enter submit button
#    Then assert that error message is contains "lastName"
#    And close driver

#  @US001LastnameContainsNumbers //This Sign up page is accept lastname with numbers
#  Scenario: User cannot create account if lastname contains numbers
#    When enter firstname "John"
#    And enter lastname "Doe123"
#    And enter email "Faker"
#    And enter password "Pass_123!"
#    And enter submit button
#    Then assert that error message is contains "lastName"
#    And close driver

  @US001EmailWithoutAt
  Scenario: User cannot create account with email missing '@' symbol
    When enter firstname "John"
    And enter lastname "Doe"
    And enter email "johndoeexample.com"
    And enter password "Pass_123!"
    And enter submit button
    Then assert that error message is contains "Email is invalid"
    And close driver
    And assert that the user cannot login via API

  @US001EmailWithoutDomain
  Scenario: User cannot create account with email missing domain
    When enter firstname "John"
    And enter lastname "Doe"
    And enter email "john@"
    And enter password "Pass_123!"
    And enter submit button
    Then assert that error message is contains "Email is invalid"
    And close driver
    And assert that the user cannot login via API

  @US001EmptyEmail
  Scenario: User cannot create account if email is empty
    When enter firstname "John"
    And enter lastname "Doe"
    And enter email ""
    And enter password "Pass_123!"
    And enter submit button
    Then assert that error message is contains "Email is invalid"
    And close driver
    And assert that the user cannot login via API

  @US001PasswordLessThan7
  Scenario: User cannot create account if password is less than 7 characters
    When enter firstname "John"
    And enter lastname "Doe"
    And enter email "john.doe@example.com"
    And enter password "P1@a"
    And enter submit button
    Then assert that error message is contains "shorter than the minimum allowed length (7)"
    And close driver
    And assert that the user cannot login via API

#  @US001EmailMissingUppercase  //This Sign up page is accept password without uppercase letter
#  Scenario: User cannot create account if password is missing uppercase letter
#    When enter firstname "John"
#    And enter lastname "Doe"
#    And enter email "john.doe@example.com"
#    And enter password "pass_123!"
#    And enter submit button
#    Then assert that error message is contains ""
#    And close driver

#  @US001EmailMissingLowercase //This Sign up page is accept password without lowercase letter
#  Scenario: User cannot create account if password is missing lowercase letter
#    When enter firstname "John"
#    And enter lastname "Doe"
#    And enter email "john.doe@example.com"
#    And enter password "PASS_123!"
#    And enter submit button
#    Then assert that error message is contains ""
#    And close driver

#  @US001EmailWithoutNumber //This Sign up page is accept password without number
#  Scenario: User cannot create account if password is missing number
#    When enter firstname "John"
#    And enter lastname "Doe"
#    And enter email "john.doe@example.com"
#    And enter password "Pass_word!"
#    And enter submit button
#    Then assert that error message is contains ""
#    And close driver
#
#  @US001EmailWithoutSpecialCharacter //This Sign up page is accept password without special character
#  Scenario: User cannot create account if password is missing special character
#    When enter firstname "John"
#    And enter lastname "Doe"
#    And enter email "john.doe@example.com"
#    And enter password "Pass1234"
#    And enter submit button
#    Then assert that error message is contains ""
#    And close driver