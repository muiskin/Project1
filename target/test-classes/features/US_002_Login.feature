@US002
Feature: Login

  Background: go to home page
  Given user goes to home page

  @US002LoginWithValidCredentials
  Scenario: User can login with valid credentials
    When enter valid email("qwe@qwe.com") for login
    And enter valid password("qweqweqwe") for login
    And the user clicks the login button
    Then assert that logout button is displayed
    And close driver
    And assert that the user login via API


 @US002LoginWithInvalidEmailAndPassword
  Scenario: User can not login with invalid credentials
    When enter email("invalid@qwe.com") for login
    And enter password("invalid") for login
    And the user clicks the login button
    Then assert that error message is contains "Incorrect username or password" for login
    And close driver
   And assert that the user cannot login via API

  @US002LoginWithInvalidEmail
  Scenario: User can not login with invalid email and correct password
    When enter email("invalid@invalid.com") for login
    And enter password("qweqweqwe") for login
    And the user clicks the login button
    Then assert that error message is contains "Incorrect username or password" for login
    And close driver
    And assert that the user cannot login via API

  @US002LoginWithEmptyEmail
  Scenario: User can not login with empty email
    When enter email("") for login
    And enter password("qweqweqwe") for login
    And the user clicks the login button
    Then assert that error message is contains "Incorrect username or password" for login
    And close driver
    And assert that the user cannot login via API

  @US002LoginWithMissingAtSymbol
  Scenario: User can not an invalid email format without @ symbol
    When enter email("qwe1qwe.com") for login
    And enter password("qweqweqwe") for login
    And the user clicks the login button
    Then assert that error message is contains "Incorrect username or password" for login
    And close driver
    And assert that the user cannot login via API

@US002LoginWithMissingDomain
  Scenario: User can not an email without domain
    When enter email("qwe1@") for login
    And enter password("qweqweqwe") for login
    And the user clicks the login button
    Then assert that error message is contains "Incorrect username or password" for login
    And close driver
  And assert that the user cannot login via API

@US002LoginWithInvalidPassword
  Scenario: User can not login with invalid password
    When enter email("qwe1@qwe.com") for login
    And enter password("invalidPass") for login
    And the user clicks the login button
    Then assert that error message is contains "Incorrect username or password" for login
    And close driver
  And assert that the user cannot login via API

@US002LoginWithEmptyPassword
  Scenario: User leaves the password input blank
    When enter email("qwe1@qwe.com") for login
    And enter password("") for login
    And the user clicks the login button
    Then assert that error message is contains "Incorrect username or password" for login
    And close driver
  And assert that the user cannot login via API


