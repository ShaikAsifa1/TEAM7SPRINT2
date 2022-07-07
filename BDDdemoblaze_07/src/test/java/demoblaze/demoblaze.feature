Feature: End-to-end Scenario of ProductStore
Given I have the base URL
Scenario: Successful Signup
    Given User navigates to Store homepage
    When User enters valid credentials
    |shivrajsable123@gmail.com|Shiv@123|
    Then User Signin Successful


Scenario Outline: Successful Login
    Given User navigates to Login page
    When user enter login credential
    |Username|Password|
    |shivrajsable123@gmail.com|Shiv@123|
     Then User should get login successful
    
Scenario Outline: Add product to cart
    Given I entered product <ProductName>
    When I click on add to cart
    | ProductName|
    | "Samsung galaxy s6"|
    | "Nokia lumia 1520" | 
    Then Product should get added to cart
    
      
      
    
Scenario: Delete Product
    Given User navigates to Product in cart page
    When I click on delete
    Then Product should get deleted from cart
    
Scenario Outline: Place order
    Given User navigates to Place order
    When user click on Place order
    |Shivraj|India|Pune|0987654321|October|2023|
    Then Product order should get placed
    
Scenario Outline: Contact store
    Given User navigates to contact
    When I click on contact in home page
    |Contact Email|Contact Name|Message|
    |shivrajsable83@gmail.com|Shivraj|"Amout debited twice from my account"|
    Then user should be able to contact store
    
Scenario: Logout
    Given User navigates to Logout
    When I click on Logout on home page
    Then User should logout