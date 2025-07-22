Feature: Add items under a price to the cart

  Scenario Outline: Add and verify all items below a price
    Given I am logged in with username "<username>" and password "<password>"
    When I add all items priced below <price> to the cart
    Then I should see all items priced below <price> in the cart

  Examples:
    | username       | password     | price |
    | standard_user  | secret_sauce | 15    |
    | standard_user  | secret_sauce | 10    |
