Feature: To Verify The Luma E-Commerce Shopping Application
	
	Scenario: User should be enter the URL navigates to the LUMA webpage
		Given User should be in homepage of LUMA
		Then User should be click on the Create An Account button 
		And It Navigates to Create New Customer Account webpage
		
	Scenario Outline: User Should be Enter The Firstname,Lastname,Email,Password,Confirm Password With Valid Credentials
		Given User should be in the Account Creation Page
		When User should be enter the Firstname,Lastname,Email,Password and Confirm Password 
		And USer should be click the Create An Account button
		Then It Navigates to My Account webpage
		
	Scenario Outline: User Should be Click The Mens-Top-Jackets	and select the Product
		Given User should be in the My Account Page
		When User should be click the Men and Moves to Top and then click the Jackets
		And User should be select the product and click
		Then It Navigates to Product page
	
	Scenario Outline: User Should be Select the Size, Colour and Quantity 
		Given User should be in the Product Page
		When User should be select the "L" Size of the Product
		When User should be select the Colour of the Product
		And User should be select the Quantity of the Product
		And User should be click the Add to Cart button and click the Shopping Cart Link
		Then It Navigates to Shopping Cart Page
	
	Scenario Outline: User Should be Click the Proceed To Check 
		Given User should be in the Shopping Cart Page
		And User should be clik the Proceed to Checkout button
		Then It Navigates to Shopping Address Checkout Page
	
	Scenario Outline: User Should be Enter the Address Details in the Field
		Given User should be in the CheckoutPage
		Given User should be enter the Street,Street1,Street2,City,State,Zip and Phone number in the Field
		Given User should be click the Shipping Methods
		And User should be click the Next button
		Then It Navigates to Review our Payments and Checkout Page
		
	Scenario Outline: User Should be verify And Place The Order
		Given User should be in Order Place Page
		When User should be verify the Payment method
		And User should be click the Place order button
		Then It Navigates to the Successful Page
		 