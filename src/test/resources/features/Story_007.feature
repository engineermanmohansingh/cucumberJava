Feature: User logs into Altoro mutual banking page 


 Scenario: I want to login successfully on Altoro Mutual page
 	Given I am on test fire login page "http://demo.testfire.net"
	When I enter valid username "admin" and password "admin"
	And I press Go button
	Then I am on admin dashboard page 
