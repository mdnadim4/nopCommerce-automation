package com.nopcommerce.pageObjects;

import com.nopcommerce.baseClass.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPages extends BaseClass {

	WebDriver ldriver;

	public RegistrationPages(WebDriver rdriver) {
		this.ldriver = driver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(className = "ico-register")
	WebElement registerNav;
	@FindBy(id = "gender-male")
	WebElement maleGender;
	@FindBy(id = "gender-female")
	WebElement femaleGender;
	@FindBy(id = "FirstName")
	WebElement firstName;
	@FindBy(id = "LastName")
	WebElement lastName;
	@FindBy(name = "DateOfBirthDay")
	WebElement selectDay;
	@FindBy(name = "DateOfBirthMonth")
	WebElement selectMonth;
	@FindBy(name = "DateOfBirthYear")
	WebElement selectYear;
	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "Company")
	WebElement company;
    @FindBy(id = "Newsletter")
    WebElement newletterOption;
	@FindBy(id = "Password")
	WebElement password;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPass;
	@FindBy(id = "register-button")
	WebElement registerBtn;
	@FindBy(css = "[class=\"result\"]")
	WebElement regSuccessMsg;
	@FindBy(css = "[class=\"button-1 register-continue-button\"]")
	WebElement regCompletedBtn;
    @FindBy(css = "[class=\"ico-logout\"]")
    WebElement logoutBtn;
    @FindBy(css = "[class=\"ico-login\"]")
    WebElement loginBtn;

    
	public void navigate(String url) {
		driver.get(url);
	}
	
	public void clickToRegisterNav() {
    	Assert.assertTrue(registerNav.isDisplayed());
		registerNav.click();
	}

	public void setMaleGender() {
    	Assert.assertTrue(maleGender.isDisplayed());
    	Assert.assertTrue(maleGender.isEnabled());
		maleGender.click();
    	Assert.assertTrue(maleGender.isSelected());
	}

	public void setFemaleGender() {
    	Assert.assertTrue(femaleGender.isDisplayed());
    	Assert.assertTrue(femaleGender.isEnabled());
		femaleGender.click();
    	Assert.assertTrue(femaleGender.isSelected());
	}

	public void setFirstName(String firstname) {
    	Assert.assertTrue(firstName.isDisplayed());
    	firstName.clear();
		firstName.sendKeys(firstname);
	}

	public void setLastname(String lastname) {
    	Assert.assertTrue(lastName.isDisplayed());
    	lastName.clear();
		lastName.sendKeys(lastname);
	}

	public void selectDay(String day1) {
		Select day = new Select(selectDay);
		day.selectByValue(day1);
	}

	public void selectMonth(String month1) {
		Select month = new Select(selectMonth);
		month.selectByVisibleText(month1);
	}

	public void selectYear(String year1) {
		Select year = new Select(selectYear);
		year.selectByValue(year1);
	}

	public void setEmail(String emailAddress) {
    	Assert.assertTrue(email.isDisplayed());
    	email.clear();
		email.sendKeys(emailAddress);
	}

	public void setCompany(String companyName) {
    	Assert.assertTrue(company.isDisplayed());
    	company.clear();
		company.sendKeys(companyName);
	}
	
	public void newletterOption() {
		Assert.assertTrue(newletterOption.isSelected());
		newletterOption.click();
		Assert.assertFalse(newletterOption.isSelected());
	}

	public void setPassword(String pwd) {
    	Assert.assertTrue(password.isDisplayed());
    	password.clear();
		password.sendKeys(pwd);
	}

	public void setConfirmPass(String confirmPwd) {
    	Assert.assertTrue(confirmPass.isDisplayed());
    	confirmPass.clear();
		confirmPass.sendKeys(confirmPwd);
	}

	public void clickToRegisterBtn() {
    	Assert.assertTrue(registerBtn.isDisplayed());
    	Assert.assertTrue(registerBtn.isEnabled());
		registerBtn.click();
	}

	public void regSuccessMsg() {
		String sucessMsg = regSuccessMsg.getText();
		Assert.assertTrue(sucessMsg.contains("Your registration completed"));
	}
	
	public void regCompletedBtn() {
    	Assert.assertTrue(regCompletedBtn.isDisplayed());
    	Assert.assertTrue(regCompletedBtn.isEnabled());
		regCompletedBtn.click();
	}
	
    public void logoutBtn() {
    	Assert.assertTrue(logoutBtn.isDisplayed());
    	logoutBtn.click();
    	Assert.assertTrue(loginBtn.isDisplayed());
    }
    

}
