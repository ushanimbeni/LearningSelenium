Feature: Testing Sum method of utility Class

  #-----------Example of taking the data into collection Object
  Scenario: verify Mul of two numbers
    Given Mul_test Data is
      | TC     | a  | b  | result |
      | 001_TC | 10 | 10 |    100 |
      | 002_TC | 20 | 10 |    200 |
      | 003_TC |  0 |  1 |      1 |
    When Mul_two numbers
    #Then Sum_verify OP