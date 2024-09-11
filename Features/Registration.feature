Feature: Account Registration

  @Sanity
  Scenario: Successfull Account Registration
    Given the user navigates to Register Account Page
    When the user fills in the registration form with valid details
      | firstName       | sumon         |
      | lastName        | Miah          |
      | Telephone       | 080-3030-1325 |
      | password        |         12345 |
      | Confirmpassword |         12345 |
    And the user selects Newsletter Subscribe
    And the user selects Privacy policy
    And the user click on Continue button
    Then the user Account should be created successfully
