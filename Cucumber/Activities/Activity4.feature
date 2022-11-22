@Activity4
Feature: Data driven test without Example

  Scenario: Testing with Data from Scenario
    Given User is on the Login page
    When User enters credentials "admin" and "password"
    Then Read the page title message and confirmation message
    And Close the Browser URL