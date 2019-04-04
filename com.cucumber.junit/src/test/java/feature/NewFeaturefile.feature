Feature: Test Amazon Search

  Scenario: Amazon Search for Fiction books
    Given Amazon website is open
    When search is enabled
    Then all fiction books should be listed
