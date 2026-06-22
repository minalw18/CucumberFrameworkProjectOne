Feature: place the order for Products

@PlaceOrder
Scenario Outline: Search experience for product in both home and offers page

Given User is on Greencart landing page
When user searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
| Name |
|Tom |