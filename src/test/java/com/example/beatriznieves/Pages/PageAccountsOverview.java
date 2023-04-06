package com.example.beatriznieves.Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.beatriznieves.Base.BasePage;
import com.example.beatriznieves.extentReport.ExtentFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageAccountsOverview extends BasePage {

    By inputUsername = By.name("username");
    By inputPassword = By.name("password");
    By loginButton = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    By transferFundLink = By.linkText("Accounts Overview");
    By textBalance = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
    By account = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    By textAccountDetails = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");


    public PageAccountsOverview(WebDriver driver) {
    }

    public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    public static ExtentReports extent;
    ExtentTest test;

    public void accountOverview() throws InterruptedException {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);
        test =extent.createTest("Registro positivo");
        test.log(Status.INFO, "Inicia el  test...");
        teclear("AdriYcerebro", inputUsername);
        teclear("213167", inputPassword);
        oprimir(loginButton);
        test.log(Status.PASS, "Login Exitoso");
        Thread.sleep(5000);
        oprimir(transferFundLink);
        waitForTextToBePresent(textBalance, "*Balance includes deposits that may be subject to holds", 100);
        Thread.sleep(5000);
        oprimir(account);
        waitForTextToBePresent(textAccountDetails, "Account Details", 100);
        test.log(Status.PASS, "Se observa el detalle de la cuenta");
        test.log(Status.INFO, "Finaliza el  test...");
        extent.flush();
    }

}
