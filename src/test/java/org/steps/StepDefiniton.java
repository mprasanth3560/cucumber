package org.steps;

import java.io.IOException;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefiniton extends BaseClass {

	@Given("User should be in homepage of LUMA")
	public void tc01() {
		
		HooksClass.tc01();
		
	}

	@When("User should be click on the Create An Account button")
	public void tc02() {
		try {	
			WebElement crtacc = driver.findElement(By.xpath("(//a[text() = 'Create an Account'])[1]"));
			
			clickon(crtacc);
			
			System.out.println("Click on Create an Account Button is Successfully ");
			
		} catch (Exception e) {
			
			System.out.println("Click on Create an Account Button is Not Successfully ");

		}

	}

	@Then("It Navigates to Create New Customer Account webpage")
	public void it_navigates_to_create_new_customer_account_webpage() {

	}

	@Given("User should be in the Account Creation Page")
	public void user_should_be_in_the_account_creation_page() {

	}

	@When("User should be enter the Firstname,Lastname,Email,Password and Confirm Password")
	public void user_should_be_enter_the_firstname_lastname_email_password_and_confirm_password() {
		try {

			WebElement fname = driver.findElement(By.id("firstname"));
			fname.sendKeys(readexceldata(0, 0));

			WebElement lname = driver.findElement(By.id("lastname"));
			lname.sendKeys(readexceldata(0, 1));

			WebElement email = driver.findElement(By.id("email_address"));
			email.sendKeys(readexceldata(1, 0));

			WebElement pass = driver.findElement(By.id("password"));
			pass.sendKeys(readexceldata(1, 1));

			WebElement cpass = driver.findElement(By.id("password-confirmation"));
			cpass.sendKeys(readexceldata(2, 0));

			System.out.println("Valid Credentials is Entered Successfully");

		} catch (Exception e) {

			System.out.println("Valid Credentials is Entered Not Successfully");

		}
	}

	@When("USer should be click the Create An Account button")
	public void tc04() {

		WebElement cbtn = driver.findElement(By.xpath("(//button[@title = 'Create an Account'])"));
		clickon(cbtn);

		implicitwait();

	}

	@Then("It Navigates to My Account webpage")
	public void it_navigates_to_my_account_webpage() {

	}

	@Given("User should be in the My Account Page")
	public void user_should_be_in_the_my_account_page() {

	}

	@When("User should be click the Men and Moves to Top and then click the Jackets")
	public void tc05() {

		try {

			WebElement men = driver.findElement(By.id("ui-id-5"));
			actionmoveto(men);

			WebElement tops = driver.findElement(By.id("ui-id-17"));
			actionmoveto(tops);

			WebElement jackets = driver.findElement(By.xpath("(//*[text()='Jackets'])[2]"));
			jsclick(jackets);

			implicitwait();

			System.out.println("User Click The Men and Moves to Top and then click the Jackets is Successfully");

		} catch (Exception e) {

			System.out.println("User Click The Men and Moves to Top and then click the Jackets is  Not Successfully");

		}

	}

	@When("User should be select the product and click")
	public void tc06() {

		WebElement blue = driver.findElement(By.xpath("(//a[@class='product-item-link'])[3]"));
		clickon(blue);

	}

	@Then("It Navigates to Product page")
	public void it_navigates_to_product_page() {

	}

	@Given("User should be in the Product Page")
	public void User_should_be_in_the_Product_Page() {

	}

	@When("User should be select the {string} Size of the Product")
	public void tc07(String string) {

		WebElement size = driver.findElement(By.id("option-label-size-143-item-169"));
		jsclick(size);

	}

	@When("User should be select the Colour of the Product")
	public void tc08() {

		WebElement colour = driver.findElement(By.id("option-label-color-93-item-53"));
		jsclick(colour);

	}

	@When("User should be select the Quantity of the Product")
	public void tc09() {

		WebElement qty = driver.findElement(By.id("qty"));
		qty.clear();
		inputvalue(qty, "2");

	}

	@When("User should be click the Add to Cart button and click the Shopping Cart Link")
	public void tc10() {

		WebElement addcart = driver.findElement(By.id("product-addtocart-button"));
		clickon(addcart);

		WebElement cartbtn = driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/checkout/cart/'])[1]"));
		jsclick(cartbtn);

	}

	@Then("It Navigates to Shopping Cart Page")
	public void it_navigates_to_shopping_cart_page() {

	}

	@Given("User should be in the Shopping Cart Page")
	public void user_should_be_in_the_shopping_cart_page() {

	}

	@Given("User should be clik the Proceed to Checkout button")
	public void tc11() throws InterruptedException {

		WebElement checkout = driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/checkout/cart/'])[3]"));
		jsclick(checkout);

		WebElement protout = driver.findElement(By.xpath("(//button[@class='action primary checkout'])[2]"));
		clickon(protout);

		Thread.sleep(3000);
	}

	@Then("It Navigates to Shopping Address Checkout Page")
	public void it_navigates_to_shopping_address_checkout_page() {

	}

	@Given("User should be in the CheckoutPage")
	public void user_should_be_in_the_checkout_page() {

	}

	@Given("User should be enter the Street,Street1,Street2,City,State,Zip and Phone number in the Field")
	public void tc12() {

		WebElement street = driver.findElement(By.xpath("(//input[@class='input-text'])[6]"));
		street.sendKeys(readexceldata(3, 0));

		WebElement street1 = driver.findElement(By.xpath("(//input[@class='input-text'])[7]"));
		street1.sendKeys(readexceldata(3, 1));

		WebElement street2 = driver.findElement(By.xpath("(//input[@class='input-text'])[8]"));
		street2.sendKeys(readexceldata(4, 0));

		WebElement city = driver.findElement(By.xpath("(//input[@class='input-text'])[9]"));
		city.sendKeys(readexceldata(4, 1));

		WebElement state = driver.findElement(By.xpath("(//select[@class='select'])[1]"));
		dropdown(state, "text", "California");

		WebElement zip = driver.findElement(By.xpath("(//input[@class='input-text'])[11]"));
		zip.sendKeys(readexceldata(5, 0));

		WebElement phone = driver.findElement(By.xpath("(//input[@class='input-text'])[12]"));
		phone.sendKeys(readexceldata(5, 1));

	}

	@Given("User should be click the Shipping Methods")
	public void tc13() {

		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
		clickon(checkbox);

		implicitwait();

	}

	@Given("User should be click the Next button")
	public void tc14() throws InterruptedException {
		try {
		
			WebElement order = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
			clickon(order);
			Thread.sleep(3000);
			System.out.println("Click on Next Button is Not Succesfully");
		
		} catch (Exception e) {
			 
			System.out.println("Click on Next Button is Not Succesfully");

		}

	}

	@Then("It Navigates to Review our Payments and Checkout Page")
	public void it_navigates_to_review_our_payments_and_checkout_page() {

	}

	@Given("User should be in Order Place Page")
	public void user_should_be_in_order_place_page() {

	}

	@When("User should be verify the Payment method")
	public void user_should_be_verify_the_payment_method() {

	}

	@When("User should be click the Place order button")
	public void tc15() {

		WebElement place = driver.findElement(By.xpath("//button[@class='action primary checkout']"));
		jsclick(place);

	}

	@Then("It Navigates to the Successful Page")
	public void tc16() throws InterruptedException, IOException {

		screenshot("LumaSuccess");

	}

}
