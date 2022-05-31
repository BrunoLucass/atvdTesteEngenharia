import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class teste {

    @Test
    public void testabrirPagina () {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pichau\\Desktop\\Eclipse\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://www.casasbahia.com.br/");

        // teste para ver se irá abrir a página certa
        String url = driver.getCurrentUrl();
        assertEquals("https://www.casasbahia.com.br/", url);
        // fecha a aplicação
        driver.quit();

    }
    @Test
    public void testClear() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pichau\\Desktop\\Eclipse\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.casasbahia.com.br/");

        // vai achar a caixa de busca, escrever playstation, apagar e escrever xbox
        WebElement caixaDeBusca = driver.findElement(By.id("strBusca"));
        caixaDeBusca.sendKeys("Playstation");
        caixaDeBusca.clear();
        caixaDeBusca.sendKeys("Xbox");

        // vai enviar clicando no botão
        WebElement botaoBusca = driver.findElement(By.id("btnOK"));
        botaoBusca.click();


        String url = driver.getCurrentUrl();
        assertTrue(driver.getCurrentUrl().contains("xbox"));

        // fecha a aplicação
        driver.quit();

    }
    @Test
    public void testSearch() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pichau\\Desktop\\Eclipse\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.casasbahia.com.br/");

        // vai achar a caixa de busca e escrever Panelas
        WebElement caixaDeBusca = driver.findElement(By.id("strBusca"));
        caixaDeBusca.sendKeys("Panelas");


        // vai enviar clicando no botão
        WebElement botaoBusca = driver.findElement(By.id("btnOK"));
        botaoBusca.click();

        //verifica
        String title = driver.getTitle();
        assertTrue(title.contains("Panelas"));

        // fecha a aplicação
        driver.quit();

    }

}

