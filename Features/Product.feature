Feature: Product Search Functionality

  Scenario: Search results display related products
    When the user searches for "Samsung"
    Then the search results should display products related to "Samsung"
