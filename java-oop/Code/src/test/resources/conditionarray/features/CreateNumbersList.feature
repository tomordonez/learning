Feature: Create Numbers List

  Scenario: Create a list of positive odd numbers
    Given I have a list of positive numbers
    When I filter by odd numbers
    Then A list of positive odd numbers is created

  Scenario: Create a list of positive even numbers
    Given I have a list of positive numbers [0, 1, 2, 3, 4, 5]
    When I filter by even numbers
    Then A list of positive even numbers [0, 2, 4] is created

  Scenario: Create a list of positive prime numbers
    Given I have a list of positive numbers [0, 1, 2, 3, 4, 5]
    When I filter by prime numbers
    Then A list of positive prime numbers [2, 3, 5] is created