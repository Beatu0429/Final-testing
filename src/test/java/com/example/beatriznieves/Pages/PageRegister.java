package com.example.beatriznieves.Pages;

import com.example.beatriznieves.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageRegister extends BasePage {

    By SignUpButton = By.linkText("My Account");
    By SignUpButton2 = By.linkText("Register");
    By inputFirstName = By.name("firstname");
    By inputLastName = By.id("input-lastname");
    By inputEmail = By.id("input-email");
    By inputTelephone = By.id("input-telephone");
    By inputPassword = By.xpath("//*[@id=\"input-password\"]");
    By inputConfirmPassword = By.xpath("//*[@id=\"input-confirm\"]");
    By NoSuscribe = By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/div/label[2]/input");
    By policy = By.name("agree");
    By buttomContinue = By.cssSelector("input.btn");
    By result = By.xpath("/html/body/div[2]/div/div/p[1]");




    public PageRegister(WebDriver driver) {

    }


    public void registerUser(){

        oprimir(SignUpButton);
        oprimir(SignUpButton2);
        teclear("Beatriz", inputFirstName);
        teclear("Nieves", inputLastName);
        teclear("nievesb0429@gmail.com", inputEmail);
        teclear("123456789", inputTelephone);
        teclear("123456", inputPassword);
        teclear("123456", inputConfirmPassword);
        oprimir(NoSuscribe);
        oprimir(policy);
        oprimir(buttomContinue);

        waitForTextToBePresent(result,"Congratulations! Your new account has been successfully created!",10);



    }

}
