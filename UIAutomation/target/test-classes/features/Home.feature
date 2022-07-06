@ui @login
Feature: Home functionality


  Scenario: Login to app
    Given user has launched url "https://www.saucedemo.com/"
    And user has logged in to application using following credentials
      | UserName      | Password     |
      | standard_user | secret_sauce |


#    Scenario: Add to cart on Home Page
#      Given user click on "Add to cart"