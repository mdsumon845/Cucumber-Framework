Feature: Navigation to the Product Details Page

  Scenario: User navigates to the product details page
    Given the search bar is displayed on the homepage
    When the user searches for "Sony VAIO" and clicks the search button
    And the search results are displayed
    And the user clicks on the "Sony VAIO" product link
    Then the product code should be visible, confirming successful navigation to the product details page
