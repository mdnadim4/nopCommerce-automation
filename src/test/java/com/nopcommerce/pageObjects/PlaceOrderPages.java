package com.nopcommerce.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PlaceOrderPages {

    WebDriver ldriver;

    public PlaceOrderPages(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(partialLinkText = "Electronics")
    WebElement electronicsNav;
    @FindBy(partialLinkText = "Cell phones")
    WebElement cellPhones;
    @FindBy(partialLinkText = "Nokia Lumia 1020")
    WebElement nokiaLumia;
    @FindBy(id = "product_enteredQuantity_20")
    WebElement quantity;
    @FindBy(id = "add-to-cart-button-20")
    WebElement addToCart;
    @FindBy(partialLinkText = "Shopping cart")
    WebElement shoppingCart;
    @FindBy(className = "close")
    WebElement closeBtn;
    @FindBy(css = "[class=\"button-1 cart-button\"]")
    WebElement goToCartBtn;
    @FindBy(id = "termsofservice")
    WebElement termsServices;
    @FindBy(id = "checkout")
    WebElement checkout;
    @FindBy(css = "[class=\"button-1 checkout-as-guest-button\"]")
    @CacheLookup
    WebElement checkoutAsGuest;
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement billFirstName;
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement billLastName;
    @FindBy(id = "BillingNewAddress_Email")
    WebElement billEmail;
    @FindBy(id = "BillingNewAddress_Company")
    WebElement billCompany;
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement billCountry;
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement billState;
    @FindBy(id = "BillingNewAddress_City")
    WebElement billCity;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement billAddress;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement billZipCode;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement billPhoneNumber;
    @FindBy(id = "BillingNewAddress_FaxNumber")
    WebElement billFaxNumber;
    @FindBy(css = "[class=\"button-1 new-address-next-step-button\"]")
    WebElement billContinueBtn;
    @FindBy(id = "shippingoption_1")
    WebElement nextDayAirBtn;
    @FindBy(css = "[class=\"button-1 shipping-method-next-step-button\"]")
    WebElement shippingContinueBtn;
    @FindBy(id = "paymentmethod_1")
    WebElement creditCard;
    @FindBy(css = "[class=\"button-1 payment-method-next-step-button\"]")
    WebElement paymentContiuneBtn;
    @FindBy(id = "CreditCardType")
    WebElement selectCreditCard;
    @FindBy(id = "CardholderName")
    WebElement cardHolderName;
    @FindBy(id = "CardNumber")
    WebElement cardNumber;
    @FindBy(id = "ExpireMonth")
    WebElement expireMonth;
    @FindBy(id = "ExpireYear")
    WebElement expireYear;
    @FindBy(id = "CardCode")
    WebElement cardCode;
    @FindBy(css = "[class=\"button-1 payment-info-next-step-button\"]")
    WebElement paymentInfoBtn;
    @FindBy(css = "[class=\"button-1 confirm-order-next-step-button\"]")
    WebElement confirmBtn;
    @FindBy(css = "[class=\"center-1\"] [class=\"title\"]>strong")
    WebElement thankYouMsg;
    @FindBy(css = "[class=\"button-1 order-completed-continue-button\"]")
    WebElement orderCompleteBtn;

	public void navigate(String url) {
		ldriver.get(url);
	}
	
	public String verifyURL() {
		return ldriver.getCurrentUrl();
	}

    public void electronicsNav() {
    	Assert.assertTrue(electronicsNav.isDisplayed());
        electronicsNav.click();
    }

    public void cellPhones() {
    	Assert.assertTrue(cellPhones.isDisplayed());
        cellPhones.click();
    }

    public void nokiaLumia() {
    	Assert.assertTrue(nokiaLumia.isDisplayed());
        nokiaLumia.click();
    }

    public void setQuantity(Integer count) {
    	Assert.assertTrue(quantity.isDisplayed());
        quantity.click();
        quantity.sendKeys(Keys.CONTROL+"A");
        quantity.sendKeys(Keys.BACK_SPACE);
        quantity.sendKeys(Keys.NUMPAD2);
    }

    public void addToCart() {
    	Assert.assertTrue(addToCart.isDisplayed());
    	Assert.assertTrue(addToCart.isEnabled());
        addToCart.click();
    }
    
    public void closeBtn() {
    	Assert.assertTrue(closeBtn.isDisplayed());
    	closeBtn.click();
    }

    public void shoppingCart() {
		  Actions action = new Actions(ldriver);
		  action.moveToElement(shoppingCart).perform();
    }

    public void goToCartBtn() {
    	Assert.assertTrue(goToCartBtn.isEnabled());
        goToCartBtn.click();
    }
    
    public void scrollToCheckout() {
    	JavascriptExecutor checkout = (JavascriptExecutor) ldriver;
    	checkout.executeScript("arguments[0].scrollIntoView(true);", termsServices);
    }
    
    public void termsServices() {
    	Assert.assertTrue(termsServices.isDisplayed());
    	Assert.assertTrue(termsServices.isEnabled());
        termsServices.click();
    }

    public void checkout() {
    	Assert.assertTrue(checkout.isDisplayed());
    	Assert.assertTrue(checkout.isEnabled());
        checkout.click();
    }

    public void checkoutAsGuest() {
    	Assert.assertTrue(checkoutAsGuest.isDisplayed());
    	Assert.assertTrue(checkoutAsGuest.isEnabled());
        checkoutAsGuest.click();
    }

    public void setBillFirstName(String billfirstname) {
    	Assert.assertTrue(billFirstName.isDisplayed());
    	billFirstName.clear();
        billFirstName.sendKeys(billfirstname);
    }

    public void setBillLastName(String billlastname) {
    	Assert.assertTrue(billLastName.isDisplayed());
    	billLastName.clear();
        billLastName.sendKeys(billlastname);
    }

    public void setBillEmail(String billemail) {
    	Assert.assertTrue(billEmail.isDisplayed());
    	billEmail.clear();
        billEmail.sendKeys(billemail);
    }

    public void setBillCompany(String billcompany) {
    	Assert.assertTrue(billCompany.isDisplayed());
    	billCompany.clear();
        billCompany.sendKeys(billcompany);
    }

    public void setBillCountry(String setCountry) {
		Select country = new Select(billCountry);
		country.selectByVisibleText(setCountry);
    }

    public void setBillState(String setState) {
		Select state = new Select(billState);
		state.selectByVisibleText(setState);
    }

    public void setBillCity(String city) {
    	Assert.assertTrue(billCity.isDisplayed());
    	billCity.clear();
        billCity.sendKeys(city);
    }

    public void setBillAddress(String billaddress) {
    	Assert.assertTrue(billAddress.isDisplayed());
    	billAddress.clear();
        billAddress.sendKeys(billaddress);
    }

    public void setBillZipCode(String zipcode) {
    	Assert.assertTrue(billZipCode.isDisplayed());
    	billZipCode.clear();
        billZipCode.sendKeys(zipcode);
    }

    public void setBillPhoneNumber(String phnumber) {
    	Assert.assertTrue(billPhoneNumber.isDisplayed());
    	billPhoneNumber.clear();
        billPhoneNumber.sendKeys(phnumber);
    }

    public void setBillFaxNumber(String faxnumber) {
    	Assert.assertTrue(billFaxNumber.isDisplayed());
    	billFaxNumber.clear();
        billFaxNumber.sendKeys(faxnumber);
    }

    public void billContinueBtn() {
    	Assert.assertTrue(billContinueBtn.isDisplayed());
    	Assert.assertTrue(billContinueBtn.isEnabled());
        billContinueBtn.click();
    }

    public void nextDayAirBtn() {
    	Assert.assertTrue(nextDayAirBtn.isDisplayed());
    	Assert.assertTrue(nextDayAirBtn.isEnabled());
        nextDayAirBtn.click();
    }

    public void shippingContinueBtn() {
    	Assert.assertTrue(shippingContinueBtn.isDisplayed());
    	Assert.assertTrue(shippingContinueBtn.isEnabled());
    	shippingContinueBtn.click();
    }

    public void creditCard() {
    	Assert.assertTrue(creditCard.isDisplayed());
    	Assert.assertTrue(creditCard.isEnabled());
        creditCard.click();
    }
    
    public void paymentContiuneBtn() {
    	Assert.assertTrue(paymentContiuneBtn.isDisplayed());
    	Assert.assertTrue(paymentContiuneBtn.isEnabled());
    	paymentContiuneBtn.click();
    }

    public void selectCreditCard(String element) {
		Select creditCard = new Select(selectCreditCard);
		creditCard.selectByVisibleText(element);
		
    }

    public void cardHolderName(String cardholdername) {
    	Assert.assertTrue(cardHolderName.isDisplayed());
    	cardHolderName.clear();
        cardHolderName.sendKeys(cardholdername);
    }

    public void cardNumber(String cardnumber) {
    	Assert.assertTrue(cardNumber.isDisplayed());
    	cardNumber.clear();
        cardNumber.sendKeys(cardnumber);
    }

    public void expireMonth(String element) {
		Select expireM = new Select(expireMonth);
		expireM.selectByValue(element);
    }

    public void expireYear(String element) {
		Select expireY = new Select(expireYear);
		expireY.selectByValue(element);
    }

    public void cardCode(String element) {
    	Assert.assertTrue(cardCode.isDisplayed());
    	cardCode.clear();
        cardCode.sendKeys(element);
    }
    
    public void paymentInfoBtn() {
    	Assert.assertTrue(paymentInfoBtn.isDisplayed());
    	Assert.assertTrue(paymentInfoBtn.isEnabled());
    	paymentInfoBtn.click();
    }

    public void confirmBtn() {
    	Assert.assertTrue(confirmBtn.isEnabled());
        confirmBtn.click();
    }

    public void thankYouMsg() {
    	String message = thankYouMsg.getText();
    	Assert.assertFalse(message.contains("Your order has been successfully processed!"));
    }
    
    public void orderCompleteBtn() {
    	Assert.assertTrue(orderCompleteBtn.isDisplayed());
    	Assert.assertTrue(orderCompleteBtn.isEnabled());
    	orderCompleteBtn.click();
    }

}
