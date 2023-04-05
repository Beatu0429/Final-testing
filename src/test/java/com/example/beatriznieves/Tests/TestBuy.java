package com.example.beatriznieves.Tests;


import com.example.beatriznieves.Pages.PageBuy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
public class TestBuy {
    WebDriver driver;
    PageBuy pagebuy;


    @BeforeEach
    public void setUp() throws Exception {
        pagebuy = new PageBuy(driver);
        driver = pagebuy.chromeDriverConnection();
        pagebuy.link("https://opencart.abstracta.us/index.php?route=common/home");
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        pagebuy.buyProduct();
    }
}