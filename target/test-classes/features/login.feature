Feature: SwagLabs Login

Background: 

  Scenario Outline: Valid user login
    Given I launch the website
    When I login with username <username> and password <password>
    Then I verify successfully login

  Examples:
    | username       | password       |
    | standard_user  | secret_sauce   |    