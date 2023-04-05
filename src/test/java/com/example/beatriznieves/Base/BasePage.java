package com.example.beatriznieves.Base;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\Beatriz-Nieves\\src\\test\\resources\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        return driver;
    }
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    public void teclear(String imputText,By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(imputText);
    }
    public static void oprimir (By locator) {
        driver.findElement(locator).click();
    }
    public void link (String url) {
        driver.get(url);
    }
    public void tecla (By locator, String tecla) {
        driver.findElement(locator).sendKeys(Keys.valueOf(tecla));
    }
    public void obtenerTexto (By locator) {
        String res = driver.findElement(locator).getText();
        System.out.println("Texto : " + res );
    }
    public void comparar (By locator, String texto) {
        String res = driver.findElement(locator).getText();
        assert(res.contains(texto));
    }
    public void waitForTextToBePresent(By locator, String texto, int tiempo) {
        new WebDriverWait(driver,Duration.ofSeconds(tiempo))
                .until(ExpectedConditions.textToBe(locator,texto ));
    }
}
