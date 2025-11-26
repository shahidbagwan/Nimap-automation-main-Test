package com.Nimap.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {

            { "9175171771", "Shahid@12345", "success" },

            { "user@mail.com", "WrongPass99", "invalid" },
            { "1122334455", "Invalid@123", "invalid" },

            { "", "Pass@1234", "required" },
            { "9876543210", "", "required" }
        };
    }

    @DataProvider(name = "newCustomerData")
    public Object[][] customerData() {

        return new Object[][] {

            { "Ayaan Khan", "ayaan.khan91@gmail.com", "United Arab Emirates", "./Pictures/Profile1.jpg" },

            { "Sofia Lewis", "sofia.lewis12@mail.com", "Singapore", "./Pictures/Profile2.jpg" },

            { "Harsh Patel", "harsh.patel09@gmail.com", "Saudi Arabia", "./Pictures/Profile3.jpg" },

            { "Emily Carter", "emily.carter88@mailbox.com", "Bangladesh", "./Pictures/Profile4.jpg" },

            { "Mohammed Irfan", "irfan.dev@mail.com", "Bahrain", "./Pictures/Profile5.jpg" }
        };
    }
}
