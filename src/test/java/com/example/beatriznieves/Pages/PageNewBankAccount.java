package com.example.beatriznieves.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.example.beatriznieves.Base.BasePage;



public class PageNewBankAccount extends BasePage{

    By inputUsername = By.name("username");
    By inputPassword = By.name("password");
    By loginButton = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    By newAccountLink = By.linkText("Open New Account");
    By checkBox = By.xpath("//*[@id=\"type\"]");
    By checkSavings = By.xpath("//*[@id=\"type\"]/option[2]");
    By newAccountButton = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    By resultMessage = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");

    public PageNewBankAccount(WebDriver driver) {
    }

    public void newBankAccount(){
        teclear("AdriYcerebro", inputUsername);
        teclear("213167", inputPassword);
        oprimir(loginButton);
        oprimir(newAccountLink);
        oprimir(checkBox);
        oprimir(checkSavings);
        oprimir(newAccountButton);
        waitForTextToBePresent(resultMessage, "Congratulations, your account is now open.", 100);

    }


}
