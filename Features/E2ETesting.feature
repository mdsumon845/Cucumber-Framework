Feature: User Registration to Order Completion

  Scenario: Successful user registration and order completion
    Given the user navigates to the Register Account Page
    When the user fills in the registration form with valid details
      | firstName       | sumon         |
      | lastName        | Miah          |
      | Telephone       | 080-3030-1325 |
      | password        |         12345 |
      | Confirmpassword |         12345 |
    And the user selects Subscribe to Newsletter
    And the user accepts the Privacy Policy
    And the user clicks on the Continue button
    Then the user account should be created successfully
    When the user click the continue button
    Then the user should be redirected to the dashboard
    When the user searches for a product "ipod"
    And the search results are displayed
    And the user adds the product to the cart
    And the user navigates to the cart
    Then the shopping Cart text should be displayed
    When the user proceeds to checkout
    And the user enters shipping details
    And the user clicks on the Continue button
    Then the user sees the order confirmation page
    When the user clicks on the Confirm Order button
    Then the order confirmation text should be displayed
