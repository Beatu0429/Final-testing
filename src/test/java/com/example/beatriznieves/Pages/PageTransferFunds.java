package com.example.beatriznieves.Pages;

import com.example.beatriznieves.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTransferFunds extends BasePage {

    By inputUsername = By.name("username");
    By inputPassword = By.name("password");
    By loginButton = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    By transferFundLink = By.linkText("Transfer Funds");
    By inputAmount = By.xpath("//*[@id=\"amount\"]");
    By checkBoxFromAcount = By.id("fromAccountId");
    By fromAccountValue = By.xpath("//*[@id=\"fromAccountId\"]/option[2]");
    By checkBoxToAcount = By.id("toAccountId");
    By toAccountValue = By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    By transferButton = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");

    By resultMessage = By.cssSelector("h1");

    public PageTransferFunds(WebDriver driver) {

    }

    public void transferFunds() throws InterruptedException {
        teclear("AdriYcerebro", inputUsername);
        teclear("213167", inputPassword);
        oprimir(loginButton);
        oprimir(transferFundLink);
        Thread.sleep(5000);
        teclear("2", inputAmount);
        Thread.sleep(1000);
        oprimir(checkBoxToAcount);
        Thread.sleep(3000);
        oprimir(toAccountValue);
        Thread.sleep(3000);
        oprimir(transferButton);
        waitForTextToBePresent(resultMessage, "Transfer Complete!", 100);
    }
}
