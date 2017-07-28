package com.github.automation.first;

/**
 * Created by mykhail on 18.07.17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class FirstTest {

    public static WebDriver driver;

   @BeforeClass
  public void setUp() {
       driver = new ChromeDriver();
       System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
   }

    @BeforeMethod
    public void OpenLobbyPage () {
        //Open url
        driver.get("https://cdn.gameiom.com/gameiom/gamelobby/test/build-3/index.html#!/login");
        String handle = driver.getWindowHandle();
    }

    @AfterClass
    public void tearDown () {
        driver.close();
    }


    public void testSignInLobby() throws InterruptedException {
        // Fill 'Login' field
        WebDriverWait wait = new WebDriverWait(driver, 20);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/section/form/input[1]")));
        driver.findElement(By.xpath("/html/body/div/div/section/section/form/input[1]"))
                .sendKeys("gameiom_test4");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        //Click 'Login' button
        driver.findElement(xpath("/html/body/div/div/section/section/form/button")).click();
        System.out.println(driver.getCurrentUrl());
    }

    public void testOpenGame() throws InterruptedException {
        //PageLoadTimeout Command
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/div/div[5]/div[5]/a[1]")));
        driver.findElement(xpath("/html/body/div/div/section/div/div[5]/div[5]/a[1]")).click();
        Thread.sleep(5000);
        for(String handleGame : driver.getWindowHandles()){
            driver.switchTo().window(handleGame);
        }
        System.out.println(driver.getCurrentUrl());
    }


    @Test
    public void OpenLobbyRunGame() throws InterruptedException {
        //setProperty();
        //setUp();
        OpenLobbyPage();
        testSignInLobby();
        testOpenGame();
        //tearDown();
    }


}
