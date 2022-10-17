package com.nopcommerce.testCases;

import com.github.javafaker.Faker;
import com.nopcommerce.baseClass.BaseClass;
import com.nopcommerce.pageObjects.RegistrationPages;
import com.nopcommerce.utilities.ReadExcelFile;

import java.io.IOException;

import org.testng.annotations.Test;

public class TC_RegistrationTest extends BaseClass{

    RegistrationPages registrationPages;
    Faker faker = new Faker();
    
    @Test(dataProvider = "registerDataProvider", dataProviderClass = ReadExcelFile.class)
    public void verifyRegistration(String firstName, String lastName, String company) throws IOException {
    	
    	registrationPages = new RegistrationPages(driver);

    	test = reports.createTest("Module 1: Verify Registration Page");
    	
        test.info("<strong>Step-1: User go to the NopCommerce Home page</strong>");
        logger.info("Step-1: User go to the NopCommerce Home page");
    	registrationPages.navigate(baseUrl);
    	
        test.info("<strong>Step-2: User navigate to the Registration page</strong>");
        logger.info("Step-2: User navigate to the Registration page");
    	registrationPages.clickToRegisterNav();

        test.info("<strong>Step-3: User select the type as gender</strong>");
        logger.info("Step-3: User select the type as gender");
    	registrationPages.setMaleGender();

        test.info("<strong>Step-4: User set first name and last name</strong>");
        logger.info("Step-4: User set first name and last name");
    	registrationPages.setFirstName(firstName);
    	registrationPages.setLastname(lastName);

        test.info("<strong>Step-5: User set date of birth</strong>");
        logger.info("Step-5: User set date of birth");
	    registrationPages.selectDay("10");
	    registrationPages.selectMonth("December");
	    registrationPages.selectYear("1992");

        test.info("<strong>Step-6: User set the email</strong>");
        logger.info("Step-6: User set the email");
	    registrationPages.setEmail(faker.internet().emailAddress());

        test.info("<strong>Step-7: User set company details</strong>");
        logger.info("Step-7: User set company details");
	    registrationPages.setCompany(company);
	    
        test.info("<strong>Step-8: User set Newsletter options</strong>");
        logger.info("Step-8: User set Newsletter option");
	    registrationPages.newletterOption();

        test.info("<strong>Step-9: User set password and confirm password</strong>");
        logger.info("Step-9: User set password and confirm password");
	    registrationPages.setPassword("password123");
	    registrationPages.setConfirmPass("password123");

        test.info("<strong>Step-10: User click on the Register button</strong>");
        logger.info("Step-10: User click on the Register button");
	    registrationPages.clickToRegisterBtn();

        test.info("<strong>Step-11: Verify the registration message is displayed</strong>");
        logger.info("Step-11: Verify the registration message is displayed");
        registrationPages.regSuccessMsg();
        registrationPages.captureScreenshot(driver, "RegSuccessMessage");
        registrationPages.regCompletedBtn();
        
		test.info("<strong>Step-12: Verify logout button display and click on it</strong>");
		logger.info("Step-12: Verify logout button display and click on it");
		registrationPages.logoutBtn(); 
    }
    
    

}
