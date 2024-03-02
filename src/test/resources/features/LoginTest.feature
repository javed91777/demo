Feature: LoginTest Feature
  @LoginTest
 Scenario Outline: LoginTest Scenario
   Given User is on the login page
   When User enters the username "<username>"
   And User enters the password "<password>"
   And User clicks on submit button
   Then User validates home page is displayed
   And User clicks on Logout button

   Examples:
     | username | password             |
     | tomsmith | SuperSecretPassword! |