package com.nopcommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.nopcommerce.baseClass.BaseClass;
import com.nopcommerce.pageObjects.PlaceOrderPages;

public class TC_PlaceOrderTest extends BaseClass {

	PlaceOrderPages placeOrderPage;
	Faker faker = new Faker();

	@Test
	public void verifyPlaceOrder() throws InterruptedException {

		placeOrderPage = new PlaceOrderPages(driver);

		test = reports.createTest("Module 2: Verify Place Order Page");

		test.info("<strong>Step-1: User go to the NopCommerce Home page</strong>");
		logger.info("Step-1: User go to the NopCommerce Home page");
		placeOrderPage.navigate(baseUrl);
		Assert.assertEquals(placeOrderPage.verifyURL(), "https://demo.nopcommerce.com/");

		test.info("<strong>Step-2: User click \"Cell phones\" option from \"Electronics\" category</strong>");
		logger.info("Step-2: User click \"Cell phones\" option from \"Electronics\" category");
		placeOrderPage.electronicsNav();
		placeOrderPage.cellPhones();

		test.info("<strong>Step-3: User click on the \"Nokia Lumia 1020\" for product details</strong>");
		logger.info("Step-3: User click on the \"Nokia Lumia 1020\" for product details");
		placeOrderPage.nokiaLumia();

		test.info("<strong>Step-4: User set the quantity number 2 in the quantity field</strong>");
		logger.info("Step-4: User set the quantity number 2 in the quantity field");
		placeOrderPage.setQuantity(2);

		test.info("<strong>Step-5: User click on the \"ADD TO CARD\" button</strong>");
		logger.info("Step-5: User click on the \"ADD TO CARD\" button");
		placeOrderPage.addToCart();
		placeOrderPage.closeBtn();

		test.info("<strong>Step-6: User go to the shipping cart page</strong>");
		logger.info("Step-6: User go to the shipping cart page");
		placeOrderPage.shoppingCart();
		Thread.sleep(2000);
		placeOrderPage.goToCartBtn();

		test.info("<strong>Step-7: User accept terms conditions and click checkout button</strong>");
		logger.info("Step-7: User accept terms conditions and click checkout button");
		placeOrderPage.scrollToCheckout();
		placeOrderPage.termsServices();
		placeOrderPage.checkout();
		Thread.sleep(2000);

		test.info("<strong>Step-8: User click checkout as guest button</strong>");
		logger.info("Step-8: User click checkout as guest button");
		placeOrderPage.checkoutAsGuest();

		test.info("<strong>Step-8: User input all the billing details and click continue</strong>");
		logger.info("Step-8: User input all the billing details and click continue");
		placeOrderPage.setBillFirstName(faker.address().firstName());
		placeOrderPage.setBillLastName(faker.address().lastName());
		placeOrderPage.setBillEmail(faker.internet().emailAddress());
		placeOrderPage.setBillCompany(faker.company().name());
		placeOrderPage.setBillCountry("United States");
		Thread.sleep(2000);
		placeOrderPage.setBillState("New York");
		placeOrderPage.setBillCity(faker.address().cityName());
		placeOrderPage.setBillAddress(faker.address().streetAddress());
		placeOrderPage.setBillZipCode(faker.address().zipCode());
		placeOrderPage.setBillPhoneNumber(faker.phoneNumber().phoneNumber());
		placeOrderPage.setBillFaxNumber(faker.phoneNumber().phoneNumber());
		placeOrderPage.billContinueBtn();
		Thread.sleep(2000);

		test.info("<strong>Step-9: User select shipping method \"Next Day Air\" and click continue</strong>");
		logger.info("Step-9: User select shipping method \"Next Day Air\" and click continue");
		placeOrderPage.nextDayAirBtn();
		placeOrderPage.shippingContinueBtn();
		Thread.sleep(2000);

		test.info("<strong>Step-10: User select payment method \"Credit Card\" and click continue</strong>");
		logger.info("Step-10: User select payment method \"Credit Card\" and click continue");
		placeOrderPage.creditCard();
		placeOrderPage.paymentContiuneBtn();
		Thread.sleep(2000);

		test.info("<strong>Step-11: User select \"Visa\" card and input card information</strong>");
		logger.info("Step-11: User select \"Visa\" card and input card information");
		placeOrderPage.selectCreditCard("Visa");
		placeOrderPage.cardHolderName(faker.address().firstName() + " " + faker.address().lastName());
		placeOrderPage.cardNumber("4415-8715-1169-2639");
		placeOrderPage.expireMonth("10");
		placeOrderPage.expireYear("2026");
		placeOrderPage.cardCode("253");
		Thread.sleep(2000);
		placeOrderPage.paymentInfoBtn();

		test.info("<strong>Step-12: User click confirm button to place the order</strong>");
		logger.info("Step-12: User click confirm button to place the order");
		placeOrderPage.confirmBtn();

		test.info("<strong>Step-13: Verify that the order place message</strong>");
		logger.info("Step-13: Verify that the order place message");
		placeOrderPage.thankYouMsg();
		Thread.sleep(2000);
		placeOrderPage.orderCompleteBtn();
	}

}
