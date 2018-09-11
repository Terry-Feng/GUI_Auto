Feature: login and register function test

  Scenario: login with non-existent user
    Given user is on the login page
    When login with username: "non-existent-user" and password "password"
    Then error message displays as "Username or password is incorrect"

  Scenario: cancel register user
    Given user is on the login page
    When click register link
    Then register page displayed
    When click cancel link
    Then login page displayed

  Scenario: register user
    Given user is on the login page
    When click register link
    Then register page displayed
    When register with fixed username and password "password"
    Then page navigate to login page and display message "Registration successful"

  Scenario: register with duplicate user
    Given user is on the login page
    When click register link
    Then register page displayed
    When register with fixed username and password "password"
    Then error msg displayed as username is already taken

  Scenario: user login
    Given user is on the login page
    When login with fixed username and password "password"
    Then user login successfully