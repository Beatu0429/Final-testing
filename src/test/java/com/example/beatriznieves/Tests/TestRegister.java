package com.example.beatriznieves.Tests;

import com.example.beatriznieves.Pages.PageRegister;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestRegister {


    private WebDriver driver;
    PageRegister pageregister;

    @BeforeEach
    public void setUp() throws Exception {
        pageregister = new PageRegister(driver);
        driver = pageregister.chromeDriverConnection();
        pageregister.link("https://opencart.abstracta.us/index.php?route=common/home");
    }


    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        pageregister.registerUser();
    }


}
