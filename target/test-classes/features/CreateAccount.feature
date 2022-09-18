@apex @story3

Feature: Create an account

  Background:
    Given I access Liverpool homepage

  Scenario Outline: Validate account creation
    When I click on "Crear cuenta" link
    When I enter an email <email>
    And I enter a password <password>
    And I click on the "Crear cuenta" button
    And I fill the form with required information <nombre> <apellidoPaterno> <apellidoMaterno> <dia> <mes> <año>
    Then I should be presented with a login validation message <loginValidationText>

    Examples:
      | email                 | password | nombre | apellidoPaterno |  apellidoMaterno | dia | mes | año | loginValidationText          |
      | asdfasdf@gmail.com | T35t4p3x | asdf | ewrtsdfgdf |  jhgfjtyuy | 27 | feb | 1993 | Ingresa los siguientes datos |