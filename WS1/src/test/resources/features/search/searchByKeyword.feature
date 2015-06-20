Feature: Search by keyword
  In order for customers to find what they are looking for more efficiently
  As a seller
  I want customers to be able to search for movies by keywords

  Scenario: Search for movies by keyword
    Given I want to see supernatural
    When I search for 'supernatural'
    Then I should see only movies related to 'supernatural'
