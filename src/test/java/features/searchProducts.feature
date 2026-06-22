Feature: Search and place the order for Products

@OfferPage
Scenario Outline: Search experience for product in both home and offers page

Given User is on Greencart landing page
When user searched with shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page to check if product exist with same name
And validate product name matches in Offers page with Landing page

Examples:
| Name |
|Tom |
| Beet |