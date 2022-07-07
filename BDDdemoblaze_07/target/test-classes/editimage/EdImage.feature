Feature: End-to-end Scenario of Edit Image
Given I have the base URL

Scenario: Successful Signin
    Given User navigates to fotor homepage
    When User enters valid credentials
    |shivrajsable83@gmail.com|Shivraj@8007|
    Then User Signin Successful

    Scenario: Upload image
    Given I have an image
    When I get image from local drive
    Then the image should be uploaded