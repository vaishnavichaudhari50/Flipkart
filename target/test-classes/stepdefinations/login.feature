@tag
Feature: Login Action
  Description: This feature will test a LogIn and LogOut functionality

  @tag1
  Scenario Outline: Login with valid and Invalid Credentials
    Given User is on Home Page
    When User navigate to Login Page
    Then User enters "<username>" and "<password>"
    And Keeping case as Valid
    Then User should get logged in
    And Message displayed Login Successfully
    Then User enters "<username>" and "<password>"
    And Keeping case as InValid
    Then user will be asked to go back to login page
    And Provide correct credentials

    @tag2
    Examples: 
      | username       | password | Case    |
      | abc@gmail.com  |    12345 | Valid   |
      | abc1@gmail.com | dfsd2    | InValid |
