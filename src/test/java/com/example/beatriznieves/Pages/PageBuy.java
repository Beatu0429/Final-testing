package com.example.beatriznieves.Pages;

import com.example.beatriznieves.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBuy extends BasePage {

    /*Introduzca el texto "Iphone" en el campo "buscar"*/
    By searchBox = By.xpath("/html/body/header/div/div/div[2]/div/input");


    /*Haga clic en el icono de la lupa para buscar*/
    By searchButton = By.xpath("/html/body/header/div/div/div[2]/div/span/button");

    /*En el primer artículo mostrado, haga clic en "Añadir a la cesta"*/
    By cartButton = By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/div[2]/button[1]");
    /*Corroborar mensaje de éxito*/

    By resultMessage = By.xpath("/html/body/div[2]/div[1]");

    public PageBuy(WebDriver driver) {

    }


    public void buyProduct() throws InterruptedException{
        teclear("Iphone", searchBox);
        Thread.sleep(100);
        oprimir(searchButton);
        Thread.sleep(100);
        oprimir(cartButton);
        Thread.sleep(1000);
        comparar(resultMessage, "Success: You have added iPhone to your shopping cart!");
        /*waitForTextToBePresent(resultMessage,"Success: You have added iPhone to your shopping cart!",10);*/


    }
}