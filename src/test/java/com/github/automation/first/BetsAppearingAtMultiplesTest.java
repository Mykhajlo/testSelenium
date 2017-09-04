package com.github.automation.first;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.automation.first.Utils.openLobby;
import static com.github.automation.first.Utils.setupEnvironment;
import static com.github.automation.first.Utils.switchToIframe;

/**
 * @author Myhajlo.Rozputnyj  on 04.09.2017.
 */
public class BetsAppearingAtMultiplesTest {
    private static final Logger LOGGER = Logger.getLogger(AccaBetTest.class);

    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = setupEnvironment();
    }

    @BeforeMethod
    public void openLobbyPage() throws InterruptedException {
        openLobby(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
    @Test
    public void BetsAppearingAtMultiplesFeatures() throws Exception {
        /*Open Game

        */
        switchToIframe(driver);

        // add two singles bet
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        LOGGER.info("Bet at race 1 added");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        LOGGER.info("Bet at race 2 added");
        Thread.sleep(2000);
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        int bet;
        String betName;

        // check appeearing of bet and it numbers
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Double".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info(betName + " bet is present at Multiples");
        } else {
            LOGGER.info(betName + " bet is present at Multiples");
        }
        Thread.sleep(2000);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at " + betName + " = " + bet);

        // add one more single bet (3)

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a")).click(); //add bet 6 trap 3 race
        LOGGER.info("Bet at race 3 added");
        Thread.sleep(2000);
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);

        // check appeearing of bet and it numbers
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Double".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info(betName + " bet is present at Multiples");
        } else {
            LOGGER.info(betName + " bet is present at Multiples");
        }
        Thread.sleep(2000);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at " + betName + " = " + bet);

        // check appeearing of bet and it numbers
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Treble".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info(betName + " bet is present at Multiples");
        } else {
            LOGGER.info(betName + " bet is present at Multiples");
        }
        Thread.sleep(2000);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at " + betName + " = " + bet);

        // check appeearing of bet and it numbers
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Trixie".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info(betName + " bet is present at Multiples");
        } else {
            LOGGER.info(betName + " bet is present at Multiples");
        }
        Thread.sleep(2000);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at " + betName + " = " + bet);

        // check appeearing of bet and it numbers
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Patent".equals(betName)) { // check that Acca bet present at Multiples page
            LOGGER.info(betName + " bet is present at Multiples");
        } else {
            LOGGER.info(betName + " bet is present at Multiples");
        }
        Thread.sleep(2000);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// acca bet
        LOGGER.info("Numbers of bets at " + betName + " = " + bet);

        Thread.sleep(20000);



    }
}
