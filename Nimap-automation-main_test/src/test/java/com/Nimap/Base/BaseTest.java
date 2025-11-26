package com.Nimap.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Nimap.PageObject.CustomerPage;
import com.Nimap.PageObject.DashboardPage;
import com.Nimap.PageObject.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashPage;
    protected CustomerPage custPage;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testffc.nimapinfotech.com/");

        loginPage = new LoginPage(driver);
        dashPage = new DashboardPage(driver);
        custPage = new CustomerPage(driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
