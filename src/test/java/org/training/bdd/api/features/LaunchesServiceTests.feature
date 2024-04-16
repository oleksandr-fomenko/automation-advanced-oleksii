Feature: RP Launches Service

  #Description: the purpose of this feature is to validate Report Portal Launches api functionality

  @Regression
  Scenario: Report Portal Launches service should return a success status code for a valid request
    Given I send a Get Launches Service request
    Then I should see service response status code 200

  @Regression
  Scenario Outline: Report Portal Launches service should return a success status code for a valid request
    Given I send a Get Launches Service request with result status filter "<Result_Status>"
    Then I should see service response status code 200
    Examples:
      | Result_Status |
      | passed        |
      | failed        |
      | skipped       |
      | total         |