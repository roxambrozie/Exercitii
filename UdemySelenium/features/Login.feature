#Each feature contains one feature
Feature: Test the login functionality on sdet university

  #A feature may have given different specific scenarios
  #Scenarios use Given-When-Then structure
  #Gherkin language - business

  Scenario: the user should be able to log in with correct username and correct password
    Given user is on the login page
    When user enters correct username and correct password
    And user clicks login button
    Then user gets confirmation

  Scenario Outline: the user should be able to login

    Given user is on the login page
    When user enters email <username>
    And user enters password <password>
    And user clicks login button
    Then user gets confirmation

    Examples:
      | username          | password |
      | tim@testemail.com | trpass   |
      | rw@testemail.com  | rwpass   |
