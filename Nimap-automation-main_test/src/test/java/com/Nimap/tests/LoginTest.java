package com.Nimap.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Nimap.Base.BaseTest;
import com.Nimap.utils.DataProviders;
import com.Nimap.utils.WaitUtils;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUpPage() {
        
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void testLogin(String username, String password, String expectedResult) {

        loginPage.login(username, password);

        switch (expectedResult.toLowerCase()) {

        case "success":
            WaitUtils.waitForUrlContains(driver, "dashboard", 20);
            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Valid login FAILED!");
            break;

        case "invalid":
            String alertMsg = loginPage.getAlertMessage();
            Assert.assertTrue(alertMsg.toLowerCase().contains("invalid"),
                    "Invalid login alert not shown!");
            break;

        case "required":
            Assert.assertTrue(loginPage.checkRequiredMessage(),
                    "Required field message NOT displayed!");
            break;

        default:
            Assert.fail("Invalid expectedResult in DataProvider: " + expectedResult);
        }
    }
}
