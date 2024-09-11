Feature: Product Advanced Search Functionality

  Scenario: Product advanced search
    Given the search bar is displayed on the homepage
    When the user clicks on the search button
    And the user scrolls up to the Price Filter
    And filters the price using mouse actions
    And clicks on the Apple Brand
    And clicks on the In Stock button
    And clicks on the List icon
    Then all products should be related to the Apple Brand and within the filtered price range
