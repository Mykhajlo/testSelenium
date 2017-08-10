package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by mykhail on 04.08.17.
 */
public class CheckRacePage {
    public WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
    public void CheckRacePageFeatures() throws  InterruptedException{
        /* Open Game
        add single  bet, check hint, delete bet
        add other single bet, check hint, delete bet
        do for all traps at race 1
        */
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 5000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            System.out.println("Error while swithing to the frame. " + e.getMessage());
        }
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[2]/span")).click();// 1 race 1 dog name hint appeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[2]/span")).click();// 1 race 1 dog name hint disappeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //delete bet 1 trap 1 race

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[2]/span")).click();// 1 race 2 dog name hint appeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[2]/span")).click();// 1 race 2 dog name hint disappeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //delete bet 2 trap 1 race

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[2]/span")).click();// 1 race 3 dog name hint appeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[2]/span")).click();// 1 race 3 dog name hint disappeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //delete bet 3 trap 1 race

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //add bet 4 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[2]/span")).click();// 1 race 4 dog name hint appeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[2]/span")).click();// 1 race 4 dog name hint disappeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //delete bet 4 trap 1 race

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[2]/span")).click();// 1 race 5 dog name hint appeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[2]/span")).click();// 1 race 5 dog name hint disappeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //delete bet 5 trap 1 race

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[2]/span")).click();// 1 race 6 dog name hint appeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[2]/span")).click();// 1 race 6 dog name hint disappeared
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //delete bet 6 trap 1 race
        Thread.sleep(1000);
        System.out.println("All singles added, hints checked, bets deleted");


    }
    @Test
    public void CheckRacePage () throws IOException,  InterruptedException{
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckRacePageFeatures();
        firstTest.tearDown();
    }
}
