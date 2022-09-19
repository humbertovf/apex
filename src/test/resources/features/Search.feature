@apex @search

Feature: Search a Product

  Background:
    Given I access Liverpool homepage

  @search1.1
  Scenario: Validate successful Product Catalog view
    When I input switch as article in search bar
    And I click on the search button
    Then I should be presented with the successful message resultados

  @search1.2
  Scenario: Validate error message for non existing Product
    When I input lannyard as article in search bar
    And I click on the search button
    Then I should be presented with the error message Lo sentimos, no encontramos nada para lanyard

  @search1.3
  Scenario: Search article by brand, physical characteristic, model
    When I input laptop as article in search bar
    And I click on the search button
    And I select acer at the "Marcas" panel
    And I select Intel Core i7 at the "Modelo del Procesador" panel
    Then I should be presented with the successful message resultados
