Feature: Testing Sum method of utility Class

  Scenario: Add two integeres
    Given two numbers are 10 and 20
    When I will add two numbers
    Then the output should be 30
    
    Scenario: Add two numbers less than 10
    Given two numbers are 3 and 7
    When I will add two numbers
    Then the output should be 5
