Feature: RP Launches

  #Description: the purpose of this feature is to validate Report Portal Launches functionality

  Background:
    Given I log in to Report Portal

  @Regression
  Scenario: Report Portal Launches tab should show a list of launches results
    When I open All Launches page
    Then I should see a list of launches

  @Regression
  Scenario Outline: User can open launches reports by results status links
    When I open All Launches page
    And I should see a list of launches
    When I click on "<Result_Status>" report link
    Then opened page URL should contain text "<Results_Page_Url_Text>"
    Examples:
      | Result_Status     | Results_Page_Url_Text |
      | Product Bugs      | Dpb                   |
      | Automation Bugs   | Dab                   |
      | System Issues     | Dsi                   |
      | To Investigate    | Dti                   |