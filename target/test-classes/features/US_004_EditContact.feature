@US004
Feature: Contact List Edit

  Background:
    Given user goes to home page
    When enter valid email("qwe@qwe.com") for login
    And enter valid password("qweqweqwe") for login
    And the user clicks the login button

    @US004EditCorrectContact
  Scenario: The user can navigate to the contact they want to edit from the contact list.
      When the user clicks the exist contact
      Then assert that the name the user clicked on and the name on the edit page are the same
      And close driver

  @US004EditButtonIsDisplayed
  Scenario: Upon selecting the contact, an "Edit" button or option should be available.
      When the user clicks the exist contact
      Then assert that edit contact button is displayed
      And close driver

@US004EditButtonClick
  Scenario: Clicking the "Edit" button should open a contact edit form or modal.
      When the user clicks the exist contact
      And the user clicks the edit button
      Then assert that edit contact header displayed
      And close driver
