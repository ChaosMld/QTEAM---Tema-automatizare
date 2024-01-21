Feature: Orders

  @PositiveScenario
  Scenario: As a guest user, I'm able to place an order for a single item from women's category
    Given I navigate to homePage
    And I click on Women Category
    And I select a specific category
    And I select the SKU
    And I select the size
    And I select the color
    When I click on Add to Cart
    Then I select the cart
    And I click on Checkout
    And I fill in the Shipping details
    Then I click on Next
    And I click on Place Order
    Then I check the Order Confirmation Text


  @NegativeScenario
  Scenario: As a guest user, I will receive an error if shipping information is not filled
    Given I navigate to homePage
    And I click on Women Category
    And I select a specific category
    And I select the SKU
    And I select the size
    And I select the color
    When I click on Add to Cart
    Then I select the cart
    And I click on Checkout
    Then I click on Next
    And I check the error validation