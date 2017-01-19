Feature: User logs into Altoro mutual banking page 

 @altoro
 Scenario: I want to login successfully on Altoro Mutual page
 	Given I am on test fire login page "http://demo.testfire.net"
	When I enter valid username "admin" and password "admin"
	And I press Go button
	Then I am on admin dashboard page 

 @altoro
 Scenario: I want to signoff from the online banking account
        Given I am on test fire login page "http://demo.testfire.net"
	When I enter valid username "admin" and password "admin"
	And I press Go button
        Given I am on admin dashboard page
        When I click on sign off button
        Then I should be on the default page