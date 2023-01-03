Feature: Extract Digits From File
  Scenario: Extract digits from a text file
    Given I have a text file
      | There are 12 apples and 29 pears at the store on 40th street today. |
      | I heard 2 people from the 75 center are going to the party |
      | in Brooklyn on 6th avenue. |
    When I extract the digits from the file
    Then A list of digits is extracted
      | 12 | 29 | 40 | 2 | 75 | 6 |