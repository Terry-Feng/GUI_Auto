Feature: login and register function test

  Scenario: login with non-existent user
    Given user is on the login page
    When login with username: "non-existent-user" and password "password"
    Then error message displays as "Username or password is incorrect"