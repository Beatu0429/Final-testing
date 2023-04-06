package com.example.beatriznieves.Tests;

import com.example.beatriznieves.Pages.PageAccountsOverview;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestParaPageAccountsOverview {

    PageAccountsOverview pageAccountsOverview;

    private WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        pageAccountsOverview = new PageAccountsOverview(driver);
        driver = pageAccountsOverview.chromeDriverConnection();
        pageAccountsOverview.link("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testNewAccount() throws InterruptedException{
        pageAccountsOverview.accountOverview();
    }
}
