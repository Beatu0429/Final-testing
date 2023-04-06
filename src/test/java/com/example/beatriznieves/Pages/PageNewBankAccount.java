package com.example.beatriznieves.Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.beatriznieves.extentReport.ExtentFactory;
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

    public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    public static ExtentReports extent;
    ExtentTest test;

    public void newBankAccount(){
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);
        test =extent.createTest("Registro positivo");
        test.log(Status.INFO, "Inicia el  test...");
        teclear("AdriYcerebro", inputUsername);
        teclear("213167", inputPassword);
        oprimir(loginButton);
        test.log(Status.PASS, "Login Exitoso");
        oprimir(newAccountLink);
        oprimir(checkBox);
        oprimir(checkSavings);
        oprimir(newAccountButton);
        waitForTextToBePresent(resultMessage, "Congratulations, your account is now open.", 100);
        test.log(Status.PASS, "Cuenta creada");
        test.log(Status.INFO, "Finaliza el  test...");
        extent.flush();
    }


}
