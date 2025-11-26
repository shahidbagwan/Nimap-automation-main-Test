package com.Nimap.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Nimap.Base.BaseTest;
import com.Nimap.utils.WaitUtils;

public class DashboardTest extends BaseTest {

    @BeforeMethod
    public void setUpPages() {
        

        loginPage.login("shahidbagwan0704@gmail.com", "Shahid@12345");
        WaitUtils.waitForUrlContains(driver, "dashboard", 20);
    }

    @Test
    public void testPunchInToastDisplayed() {

        dashPage.clickPunchinButton();
        boolean toastVisible = dashPage.punchinToastDisplayed();
        Assert.assertTrue(toastVisible, "Punch In popup/toast was NOT displayed after clicking button");
    }

    @Test
     public void testPunchInToastInteraction() {

        dashPage.clickPunchinButton();

        Assert.assertTrue(dashPage.punchinToastDisplayed(), "Punch In popup did NOT open!");

        dashPage.interactToast("report");
    }
}
