package com.Nimap.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Nimap.Base.BaseTest;
import com.Nimap.utils.DataProviders;
import com.Nimap.utils.WaitUtils;

public class CustomerTest extends BaseTest {

    @BeforeMethod
    public void setUpPages() {
        

        loginPage.login("shahidbagwan0704@gmail.com", "Shahid@12345");
        WaitUtils.waitForUrlContains(driver, "dashboard", 10);

        dashPage.openCustomerPage();
        WaitUtils.waitForUrlContains(driver, "customers", 10);
    }

    @Test
    public void testNewCustomerToastDisplayed() {
        custPage.clickNewCustButton();
        Assert.assertTrue(custPage.checkFormVisible(), "New Customer Form Popup Not displayed");
    }

    @Test(dataProvider = "newCustomerData", dataProviderClass = DataProviders.class)
    public void testNewCustomer(String name, String email, String country, String filepath) {
        custPage.clickNewCustButton();
        custPage.fillForm(name, email, country, filepath);
        custPage.saveForm();

        boolean isCreated = custPage.validateUserCreated(name);
        Assert.assertTrue(isCreated, "User not created");
    }
}
