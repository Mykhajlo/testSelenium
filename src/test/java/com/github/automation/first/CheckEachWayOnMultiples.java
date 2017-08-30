package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by mykhail on 15.08.17.
 */
public class CheckEachWayOnMultiples {
    public WebDriver webDriver;
    @BeforeClass
    public void setUp() {
        webDriver = driver;
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
    }
    public void CheckEachWayOnMultiplesFeatures ()throws Exception {
        /* Open Game
        add 6th singles bet, add EW to all available multiples bet, Start Game
        watch 1 race, Skip All, check race results
        */
        openIframe();

        // add 6th singles bet
        addSixSinglesBetWithZeroStake();
        // add EW to all available multiples bet
        addEachWayToSevenMultiplesBet();
        // Start Game
        System.out.println("Game started. Multiples with EW = Yes.");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        // watch 1 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]/div/translate/span")).click();// Click Watch Race
        Thread.sleep(1000);
        //wait Skip All button
        WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div/translate/span")));// wait until Skip All button appeared
        // check result word under dog name
        String result;

        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[1]/td[3]/span[2]/translate/span")).getText();
        CheckEachWayOnSingles checkResult = new CheckEachWayOnSingles();
        checkResult.checkResultsWord(result);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);

        // check race 2 results
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[2]/td[3]/span[2]/translate/span")).getText();
        checkResult.checkResultsWord(result);
        // check race 3 results
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[3]/td[3]/span[2]/translate/span")).getText();
        checkResult.checkResultsWord(result);
        // check race 4 results
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[4]/td[3]/span[2]/translate/span")).getText();
        checkResult.checkResultsWord(result);
        // check race 5 results
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[5]/td[3]/span[2]/translate/span")).getText();
        checkResult.checkResultsWord(result);
        // check race 6 results
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[6]/td[3]/span[2]/translate/span")).getText();
        checkResult.checkResultsWord(result);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);


    }

    public void openIframe() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            System.out.println("Error while switching to the frame. " + e.getMessage());
        }
        Thread.sleep(1000);
    }

    public void addEachWayToSevenMultiplesBet() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes for Doubles multiples bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes for Treble multiples bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes for Fourfold multiples bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes for Fivefold multiples bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes for Acca multiples bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[6]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes for Heinz multiples bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes for Lucky63 multiples bet
        Thread.sleep(2000);
    }

    public void addSixSinglesBetWithZeroStake() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        System.out.println("Bet at race 1 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        System.out.println("Bet at race 2 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 3 race
        System.out.println("Bet at race 3 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 4 race
        Thread.sleep(2000);
        System.out.println("Bet at race 4 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        System.out.println("Bet at race 5 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[6]")).click(); //open race 6 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //add bet 4 trap 6 race
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        System.out.println("Bet at race 6 added");
        Thread.sleep(2000);
    }

    @Test
    public  void CheckEachWayOnMultiples () throws Exception {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckEachWayOnMultiplesFeatures();
        firstTest.tearDown();
    }
}
