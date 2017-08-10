package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by mykhail on 02.08.17.
 */
public class CheckMenuItems {
    public WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    public void CheckMenuNavigations() throws  InterruptedException{
        //logic
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 5000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            System.out.println("Error while switching to the frame. " + e.getMessage());
        }
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //race2
        WebDriverWait wait = new WebDriverWait(driver, 5, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 2 and Trap 6
        System.out.println("Race 2 tab is opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click();  //race3
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Race 3 tab is opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click();  //race4
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Race 4 tab is opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //race5
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Race 5 tab is opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[6]")).click(); //race6
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Race 6 tab is opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/a")).click();//click Home button Race 1 tab loaded
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Race 1 tab is opened (home)");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a")).click(); //click Multiples button button
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[1]/div[1]/translate/span")).getText()).equals("Multiples")) {
            System.out.println("Multiples page is opened");
        } else System.out.println("Multiples page is NOT opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span/translate/span")).click(); //click Singles button button
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[1]/div[1]/translate/span")).getText()).equals("Singles")) {
            System.out.println("Singles page is opened");
        } else System.out.println("Singles page is NOT opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/settings-button/a")).click(); //click Settings button button
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Settings page is opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/settings-view/div[2]/header/div/a")).click(); //click red cross - close Settings button button
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Settings page is closed");


        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //race2
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 2 race
        Thread.sleep(1000);
        System.out.println("Single bet added into Race 2");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click();  //race3
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 3 race
        Thread.sleep(1000);
        System.out.println("Race 3 tab is opened");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click();  //race4
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //add bet 4 trap 4 race
        Thread.sleep(1000);
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[1]/div[1]/translate/span")).getText()).equals("Multiples")) {
            System.out.println("Multiples page is opened after adding 4 singles bet");
        } else System.out.println("Multiples page is NOT opened after adding 4 singles bet");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); //singles page open
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[2]/a")).click(); //delete bet 1 for race 1
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[2]/a")).click(); //delete bet 2 for race 2
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[2]/a")).click(); //delete bet 3 for race 3
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[2]/a")).click(); //delete bet 4 for race 4
        Thread.sleep(3000);
    }
    @Test
    public void  CheckMenuItems () throws IOException, InterruptedException{
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckMenuNavigations();
        firstTest.tearDown();
    }


}
