package com.example.beatriznieves.Tests;

import com.example.beatriznieves.Pages.PageNewBankAccount;
import com.example.beatriznieves.Pages.PageParaBankRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestParaNewAccount {

    PageNewBankAccount pageNewBankAccount;
    private WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        pageNewBankAccount = new PageNewBankAccount(driver);
        driver = pageNewBankAccount.chromeDriverConnection();
        pageNewBankAccount.link("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }


    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testNewAccount() throws InterruptedException{
        pageNewBankAccount.LoginUser();
    }
}
