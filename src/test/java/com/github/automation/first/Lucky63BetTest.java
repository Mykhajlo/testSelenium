package com.github.automation.first;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.automation.first.Utils.*;

/**
 * Created by Myhajlo.Rozputnyj on 31.08.2017.
 */
public class Lucky63BetTest {
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
    public void checkLucky63BetFeatures() throws Exception {
        /*Open Game
        submit six singles with stake = 0, open multiples page
        check bet name, change stake, check bet
        Start Game, check lucky63 result after skipping races, Click New Game
        submit six singles with stake = 0, open multiples page, add EW to lucky63
        check bet name, change stake, check bet
        Start Game, check lucky63 result after skipping races, Click New Game
         */
        switchToIframe(driver);
        // submit six singles with stake = 0
        addSixSinglesBetWithZeroStakes(driver);
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        String betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Lucky63".equals(betName)) { // check that Lucky63 bet present at Multiples page
            LOGGER.info("Lucky63 bet is present at Multiples");
        } else {
            LOGGER.info("Lucky63 bet is not present at Multiples");
        }
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for lucky63 bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for lucky63 bet
        Thread.sleep(2000);
        // check bet
        int bet;
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// fourfold bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);

        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Double stake;
        Double result;
        Thread.sleep(2000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//lucky63 stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//lucky63 bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);
        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//lucky63 result
        System.out.println("Win value of " + betName + " bet = " + result);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(2000);

        // submit six singles with stake = 0 (EW = Yes)
        addSixSinglesBetWithZeroStakes(driver);
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        LOGGER.info("Bet Name = " + betName);
        if ("Lucky63".equals(betName)) { // check that Lucky63 bet present at Multiples page
            LOGGER.info("Lucky63 bet is present at Multiples");
        } else {
            LOGGER.info("Lucky63 bet is not present at Multiples");
        }
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for lucky63 bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for lucky63 bet
        Thread.sleep(2000);
        // Set EW = yes
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Click EW
        Thread.sleep(2000);
        // check bet
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));// fourfold bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);

        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(2000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//lucky63 stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//lucky63 bet
        LOGGER.info("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);
        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//lucky63 result
        System.out.println("Win value of " + betName + " bet = " + result);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(2000);
    }
}
