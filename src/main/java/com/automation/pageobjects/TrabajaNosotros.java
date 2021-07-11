package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TrabajaNosotros {

    private final WebDriver driver;

    public TrabajaNosotros(WebDriver driver) {
        this.driver = driver;
    }

    By TodasLasOfertas() { return By.cssSelector("div.empty-thumb"); }

    public boolean isLoaded() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2"))).isDisplayed();
    }
    
    public void obtenerTodasLasOfertas(){
        int i=0;
        List<WebElement> ofertas = driver.findElements(TodasLasOfertas());
        String nombreOferta ="";
        String fechaOferta ="";
        String descripcionOferta ="";

        for (WebElement oferta: ofertas) {
            i++;
            nombreOferta = oferta.findElement(By.cssSelector("div.premium-blog-entry-container>h3>a")).getText();
            fechaOferta = oferta.findElement(By.cssSelector("div.premium-blog-entry-container>div>span>span")).getText();
            descripcionOferta = oferta.findElement(By.cssSelector(".premium-blog-post-content")).getText();

            System.out.println("\n ---------------------------------------------------------------------------\n");
            System.out.println("Nombre de la oferta de empleo No."+ i +" :" + nombreOferta);
            System.out.println("Fecha de publicación de la oferta de empleo No."+ i +" :" + fechaOferta);
            System.out.println("Descripción de la oferta de empleo No."+ i +" :" + descripcionOferta);
            System.out.println("\n ---------------------------------------------------------------------------\n");

        }
    }
}
