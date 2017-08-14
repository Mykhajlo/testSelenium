package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.github.automation.first.FirstTest.driver;
/**
 * Created by mykhail on 27.07.17.
 */
public class SingleBetWithDefaultStake {
    public WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
    public  void SingleBetWithNotZeroStake() throws InterruptedException {
    // make one single bet with no Zero stake and run game
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 1
        } catch (Throwable e) {
            System.out.println("Error while switching to the frame. " + e.getMessage());

        }
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a"));// Find 'Add to Bet slip'button at Race 1 3 dog
        System.out.println("Element Add to bet' slip'found!!");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")));
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); // Add single bet : race - 1  trap - 3

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.findElement(By.className("singles__table"));
        System.out.println("Single bet added correctly ");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// click "+" and change stake  to default
        String stake = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText();//take stake  value
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println(stake);
        Thread.sleep(1000);
        String Tstake = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText();
        System.out.println(Tstake);
        Thread.sleep(1000);
        if (stake.equals(Tstake))
        {
            System.out.println("Total Stake " + stake + " = " + Tstake +" Stake -> after changing stake");
        } else  System.out.println("Total Stake " + stake + " != " + Tstake +" Stake -> after changing stake");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click(); //Click Start Game'
        System.out.println("Game started");

        WebDriverWait waitVideo = new WebDriverWait(driver, 1000);
        waitVideo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]")));
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]")).click(); // Click Watch Race button
        waitVideo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")));
        //System.out.println("Skip all Button appeared after watching video");
        //driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click Skip All button
        System.out.println("New Game Button appeared");
        Thread.sleep(2000);
        String resolution  = driver.findElement(By.xpath("c")).getText();
        if (resolution.equals("LOST")) {
            System.out.println("User lost");
        } else System.out.println("User win");

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click(); // Click New Game button
        Thread.sleep(2000);
    }
    @Test
    public void  SingleBetWithDefaultStakeGame() throws IOException, InterruptedException {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        SingleBetWithNotZeroStake();
        firstTest.tearDown();
    }
}


