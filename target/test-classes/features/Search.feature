Feature: Search a Product

  Scenario: Validate successful Product Catalog view
    Given I access Liverpool homepage
    When I input smart tv as article in search bar
    And I click on the search button
    Then I should be presented with a successful catalog with the results