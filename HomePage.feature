Feature: Home Page or landing Page

Background: Opening and verifying landing page
Given User is on landing page

@FunctionalTest
Scenario: Logo, Links and tabs


And Irctc logo is visible
Given All links and tabs are displayed
And Click on Flights tab
And Click on ecatering tab
And Click on hilltrain
Then We can say landing page verified
 
 @SmokeTest
 Scenario: Browse Train functionality 
 
 And  User enters source station
 And User enters destination station
 And User enters date of journey
 And User enters the class of travel
 And User enters Quota
 And User Clicks on Search button
 Then user can view list of trains 
 

 @links
 Scenario: To check all links on page
Then user views all links on Home page