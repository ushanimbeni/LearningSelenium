Feature: Testing Sum method of utility Class

  #-----------Plain Scenraios
  #Scenario: Add two integeres
  #Given two numbers are 10 and 20
  #When I will add two numbers
  #Then the output should be 30
  #
  #Scenario: Add two numbers less than 10
  #Given two numbers are 3 and 7
  #When I will add two numbers
  #Then the output should be 5
  #----------- Scenarios outline
  #Scenario Outline: Add two numbers
  #Given two numbers are <a> and <b>
  #When I will add two numbers
  #Then the output should be <c>
  #
  #Examples:
  #| a  | b  | c  |
  #| 10 | 10 | 20 |
  #| 20 | 10 |  3 |
  #|  0 |  1 |  1 |
  #-----------Example of taking the data into collection Object
  Scenario: verify Sum of two numbers
    Given Sum_test Data is
      | TC     | a  | b  | result |
      | 001_TC | 10 | 10 |     20 |
      | 002_TC | 20 | 10 |     31 |
      | 003_TC |  0 |  1 |      1 |
    When Sum_two numbers
    #Then Sum_verify OP
