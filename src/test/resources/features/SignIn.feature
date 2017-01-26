Feature: Sign In to the cashkaro web portal
As a user I want to test the Login functionality of cashkaro web portal


 @cashkaro
 Scenario: I want to login successfully on  cashkaro site
 	Given I am on login page "http://www.cashkaro.com"
	When I enter valid username "carnet99cartoon@gmail.com" and password "testing"
	And I press SignIn button
	Then I should be able to see My Account button
       

