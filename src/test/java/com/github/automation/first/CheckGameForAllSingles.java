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
public class CheckGameForAllSingles {
    public WebDriver webDriver;
    @BeforeClass
    public void setUp() {
        webDriver = driver;
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
    }
    public  void CheckGameForAllSinglesFeatures () throws Exception{
        /* Open Game
        submit 6 singles bet with stake != 0,
        strat game, watch race, skip race, watch game, skip video,
        skip all
        start new Game
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

        CheckCashout addBets = new CheckCashout();
        addBets.addSixSinglesWithStakes();
        // start race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);

        // watch 1 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]/div/translate/span")).click();// Click Watch Race
        Thread.sleep(1000);
        // Check that Skipp button is present under video
        String skipButton = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a/div/translate/span")).getText();
        System.out.println(skipButton);
        if (skipButton.equals("SKIP")) {
            System.out.println(skipButton + " is appeared");
        } else System.out.println(skipButton +  " is NOT appeared");
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div/translate/span")));// wait until Skip All button appeared

        double betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[1]/td[7]/span")).getText());
        System.out.println("Single bet result for 1 race = " + betResult);
        Thread.sleep(1000);
        if (betResult > 0)//Check win value > 0 or not
        {
            System.out.println("Bet win " + betResult + " > " + "0" + " -> is correct");
        } else System.out.println("Bet lost");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);

        // watch 2 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]/div/translate/span")).click();// Click Watch Race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a/div")).click();// Click Skip
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div/translate/span")));// wait until Skip All button appeared

        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[2]/td[7]/span")).getText());
        System.out.println("Single bet result for 2 race = " + betResult);
        Thread.sleep(1000);
        if (betResult > 0)//Check win value > 0 or not
        {
            System.out.println("Bet win " + betResult + " > " + "0" + " -> is correct");
        } else System.out.println("Bet lost");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);

        // watch 3 race

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[1]/div")).click();// Click Skip 3 race
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div/translate/span")));// wait until Skip All button appeared

        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[3]/td[7]/span")).getText());
        System.out.println("Single bet result for 3 race = " + betResult);
        Thread.sleep(1000);
        if (betResult > 0)//Check win value > 0 or not
        {
            System.out.println("Bet win " + betResult + " > " + "0" + " -> is correct");
        } else System.out.println("Bet lost");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);

        // watch 4 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a[2]/div/translate/span")).click();// Click Watch Race
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div/section/a/div/translate/span")).click();// Click Skip
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div/translate/span")));// wait until Skip All button appeared

        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[4]/td[7]/span")).getText());
        System.out.println("Single bet result for 4 race = " + betResult);
        Thread.sleep(1000);
        if (betResult > 0)//Check win value > 0 or not
        {
            System.out.println("Bet win " + betResult + " > " + "0" + " -> is correct");
        } else System.out.println("Bet lost");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/div[2]/div[2]/a/div")).click();// Click Next Race
        Thread.sleep(1000);

        // watch 5 race
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a[2]/div")).click();// Click Skip All
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div/translate/span")));// wait until Skip All button appeared

        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[5]/td[7]/span")).getText());
        System.out.println("Single bet result for 5 race = " + betResult);
        Thread.sleep(1000);
        if (betResult > 0)//Check win value > 0 or not
        {
            System.out.println("Bet win " + betResult + " > " + "0" + " -> is correct");
        } else System.out.println("Bet lost");

        betResult = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[1]/tbody/tr[6]/td[7]/span")).getText());
        System.out.println("Single bet result for 6 race = " + betResult);

        Thread.sleep(1000);
        if (betResult > 0)//Check win value > 0 or not
        {
            System.out.println("Bet win " + betResult + " > " + "0" + " -> is correct");
        } else System.out.println("Bet lost");

        Thread.sleep(1000);


        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);


    }
    @Test
    public void CheckGameForAllSingles () throws Exception {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckGameForAllSinglesFeatures();
        firstTest.tearDown();
    }
}
