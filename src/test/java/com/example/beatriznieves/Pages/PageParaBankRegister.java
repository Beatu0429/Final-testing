package com.example.beatriznieves.Pages;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.beatriznieves.Base.BasePage;
import com.example.beatriznieves.extentReport.ExtentFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageParaBankRegister extends BasePage {

//    Haga clic en <Register>
    By SignUpButton = By.linkText("Register");

//    Rellene el formulario de registro con los datos requeridos

    By inputFirstName = By.name("customer.firstName");
    By inputLastName = By.name("customer.lastName");

    By inputAddress = By.name("customer.address.street");

    By inputCity = By.name("customer.address.city");

    By inputState = By.name("customer.address.state");

    By inputZipCode = By.name("customer.address.zipCode");

    By inputPhone = By.name("customer.phoneNumber");

    By inputSSN = By.name("customer.ssn");

    By inputUserName = By.name("customer.username");

    By inputPassword = By.name("customer.password");

    By inputConfirm = By.name("repeatedPassword");

    By RegisterButton = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");

//    Compruebe que el texto "Su cuenta se ha creado correctamente. En la pantalla se puede ver "You are
//    now logged in".

    By resultMessage = By.xpath("/html/body/div[1]/div[3]/div[2]/p");

    public PageParaBankRegister(WebDriver driver) {
    }

    public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    public static ExtentReports extent;
    ExtentTest test;

    public void RegisterUser(){
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);
        test =extent.createTest("Registro positivo");
        test.log(Status.INFO, "Inicia el  test...");
        oprimir(SignUpButton);
        test.log(Status.PASS, "Pagina de registro");
        teclear("Adri", inputFirstName);
        test.log(Status.PASS, "Campo nombre");
        teclear("Moncada", inputLastName);
        test.log(Status.PASS, "Campo apellido");
        teclear("Santa fé", inputAddress);
        test.log(Status.PASS, "Campo dirección");
        teclear("San Diego", inputCity);
        test.log(Status.PASS, "Campo ciudad");
        teclear("California", inputState);
        test.log(Status.PASS, "Campo estado");
        teclear("S50823", inputZipCode);
        test.log(Status.PASS, "Zip code");
        teclear("7612547",inputPhone);
        test.log(Status.PASS, "Campo teléfono");
        teclear("ASLDJ", inputSSN);
        test.log(Status.PASS, "Campo SSN");
        teclear("Yuno", inputUserName);
        test.log(Status.PASS, "Campo username");
        teclear("213167", inputPassword);
        test.log(Status.PASS, "Campo contraseña");
        teclear("213167", inputConfirm);
        test.log(Status.PASS, "Confirmación de contraseña");
        oprimir(RegisterButton);
        test.log(Status.PASS, "Oprimir registro");

        waitForTextToBePresent(resultMessage, "Your account was created successfully. You are now logged in.", 100);
        test.log(Status.PASS, "Registro exitoso");
        test.log(Status.INFO, "Finaliza el  test...");
        extent.flush();

    }
}
