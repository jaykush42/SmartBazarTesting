Feature: Check Title of the Application
  Background:
    Given Open the browser
    When User enters the URL

@Smoke
  Scenario: Check Title
    Then user verifies the "SmartBazar - Home" title

@System
Scenario Outline:
  And User enters the data '<SearchData>' of the product
  Then User verifies the result
  Examples:
  |SearchData|
  |Rice      |
  |wheat     |