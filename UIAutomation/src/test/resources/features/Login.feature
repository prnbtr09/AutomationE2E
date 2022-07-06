@ui
Feature: Login functionality


  Scenario: Login to app
    Given user has launched url "https://www.saucedemo.com/"
    And user has logged in to application using following credentials
      | UserName      | Password     |
      | standard_user | secret_sauce |

