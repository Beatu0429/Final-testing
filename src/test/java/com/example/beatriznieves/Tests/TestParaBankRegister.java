package com.example.beatriznieves.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.beatriznieves.Pages.PageNewBankAccount;
import com.example.beatriznieves.Pages.PageParaBankRegister;
import com.example.beatriznieves.extentReport.ExtentFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestParaBankRegister {
    private WebDriver driver;
    PageParaBankRegister pageParaBankRegister;


    @BeforeEach
    public void setUp() throws Exception {
        pageParaBankRegister = new PageParaBankRegister(driver);
        driver = pageParaBankRegister.chromeDriverConnection();
        pageParaBankRegister.link("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }


    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        pageParaBankRegister.RegisterUser();
    }


}
