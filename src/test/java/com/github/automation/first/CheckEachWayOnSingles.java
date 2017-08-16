package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by mykhail on 14.08.17.
 */
public class CheckEachWayOnSingles {
    public WebDriver webDriver;
    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
    public void CheckEachWayOnSinglesFeatures ()throws Exception{
        /* Open Game
        add 6th singles bet, set EW = yes for all 6 singles bet
        start race, watch race, skip all races , check result word under dogs name
        start new game
        */
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            System.out.println("Error while switching to the frame. " + e.getMessage());
        }
        Thread.sleep(1000);
        //add 6th singles bet
        CheckCashout addBets = new CheckCashout();
        addBets.addSixSinglesWithStakes();

        // set EW = yes for all 6 singles bet
        SetEachWayForSixSingles();

        // start race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        // watch 1 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]/div/translate/span")).click();// Click Watch Race
        Thread.sleep(1000);

        //wait Skip All button
        WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div/translate/span")));// wait until Skip All button appeared

        // check result value for 1 race
        double betResult;

        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[1]/td[7]/span")).getText());
        checkBetResult(betResult);

        // check result word under dog name
        String result;

        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[1]/td[3]/span[2]/translate/span")).getText();
        checkResultsWord(result);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);

        // check race 2 results
        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[2]/td[7]/span")).getText());
        checkBetResult(betResult);
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[2]/td[3]/span[2]/translate/span")).getText();
        checkResultsWord(result);
        // check race 3 results
        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[3]/td[7]/span")).getText());
        checkBetResult(betResult);
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[3]/td[3]/span[2]/translate/span")).getText();
        checkResultsWord(result);
        // check race 4 results
        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[4]/td[7]/span")).getText());
        checkBetResult(betResult);
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[4]/td[3]/span[2]/translate/span")).getText();
        checkResultsWord(result);
        // check race 5 results
        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[5]/td[7]/span")).getText());
        checkBetResult(betResult);
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[5]/td[3]/span[2]/translate/span")).getText();
        checkResultsWord(result);
        // check race 6 results
        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[6]/td[7]/span")).getText());
        checkBetResult(betResult);
        result = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[6]/td[3]/span[2]/translate/span")).getText();
        checkResultsWord(result);


        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);


    }

    public void checkResultsWord(String result) throws InterruptedException {
        System.out.println(result);
        if (result.equals("LOST")) {
            System.out.println("User " + result + " lost bet");
        }
        if (result.equals("WON")) {
            System.out.println("User " + result + " win bet");
        }
        if (!result.equals("WON") & !result.equals("LOST")) {
            System.out.println("User " + result + " EW played,  user win  bet");
        }
        Thread.sleep(1000);
    }

    public void checkBetResult(double betResult) throws InterruptedException {
        System.out.println("Single bet result for race = " + betResult);
        Thread.sleep(1000);
        if (betResult > 0)//Check win value > 0 or not
        {
            System.out.println("Bet win " + betResult + " > " + "0" + " -> is correct");
        } else System.out.println("Bet lost");
        Thread.sleep(1000);
    }

    public void SetEachWayForSixSingles() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[1]/a/span")).click(); // open singles page
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click();// Set EW = yes for 1 single bet
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click();// Set EW = yes for 2 single bet
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click();// Set EW = yes for 3 single bet
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click();// Set EW = yes for 4 single bet
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click();// Set EW = yes for 5 single bet
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[6]/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click();// Set EW = yes for 6 single bet
        Thread.sleep(2000);
    }

    @Test
    public void CheckEachWayOnSingles () throws Exception{
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckEachWayOnSinglesFeatures();
        firstTest.tearDown();
    }
}
