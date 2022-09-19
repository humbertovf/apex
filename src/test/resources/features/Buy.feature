@apex @purchase

Feature: Purchase a Product

  Background:
    Given I access Liverpool homepage

  Scenario: Search for a Smart TV
    When I input smart tv as article in search bar
    And I click on the search button
    And I select samsung at the "Marcas" panel
    And I select 43 pulgadas at the "Tamaño" panel
    And I select price less than 5000 at the "Precios" section
    Then I should be presented with the successful message resultados