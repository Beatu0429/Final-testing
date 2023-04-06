package com.example.beatriznieves.Tests;

import com.example.beatriznieves.Pages.PageNewBankAccount;
import com.example.beatriznieves.Pages.PageTransferFunds;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestTransferFunds {

    PageTransferFunds pageTransferFunds;

    private WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        pageTransferFunds = new PageTransferFunds(driver);
        driver = pageTransferFunds.chromeDriverConnection();
        pageTransferFunds.link("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testNewAccount() throws InterruptedException{
        pageTransferFunds.transferFunds();
    }

}
