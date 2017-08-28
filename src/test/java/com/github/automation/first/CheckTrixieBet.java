package com.github.automation.first;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by Myhajlo.Rozputnyj on 28.08.2017.
 */
public class CheckTrixieBet {
    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
    }
    public  void CheckTrixieBetFeatures () throws  Exception {
        /* Open Game
        submit three singles with stake = 0,open multiples page, check bet name
        Set Stake > 0 for trixie  bet, Start Game
        check trixie stake/bet/result, Click Skip All, Click New Game
        submit three singles with stake = 0,open multiples page, check bet name,
        Set Stake > 0 for trixie  bet, check trixie stake/bet/
        set EW = yes for trixie bet, check bet name/bet, Click Start Game
        check trixie stake/bet/result, Click Skip All, Click New Game
        */
        CheckEachWayOnMultiples iframe = new CheckEachWayOnMultiples();
        iframe.openIframe();
        // submit three singles with stake = 0,
        CheckTrebleBet addThreeSingles = new CheckTrebleBet();
        addThreeSingles.addThreeSinglesBetWithZeroStake();
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        String betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Trixie")) { // check that Trixie bet present at Multiples page
            System.out.println("Trixie bet is present at Multiples");
        } else System.out.println("Trixie bet is not present at Multiples");
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for trixie  bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for trixie  bet
        Thread.sleep(2000);

        // Start Game
        System.out.println("Game started. Multiples bet = " + betName);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        Double stake;
        int bet;
        Double result;
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//trixie stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//trixie bet
        System.out.println("Numbers of bets at " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);
        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//trixie result
        System.out.println("Win value of " + betName + " bet = " + result);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);

        // submit three singles with stake = 0,
        addThreeSingles.addThreeSinglesBetWithZeroStake();
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Trixie")) { // check that Trixie bet present at Multiples page
            System.out.println("Trixie bet is present at Multiples");
        } else System.out.println("Trixie bet is not present at Multiples");
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for trixie  bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for trixie  bet
        Thread.sleep(2000);
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Trixie")) { // check that Trixie bet present at Multiples page
            System.out.println("Trixie bet is present at Multiples");
        } else System.out.println("Trixie bet is not present at Multiples");
        Thread.sleep(2000);
        // set EW = yes for treble bet
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        // check bets
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7)); // trixie bet
        System.out.println("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);

        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//trixie stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//trixie bet
        System.out.println("Numbers of bets at " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);
        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//trixie result
        System.out.println("Win value of " + betName + " bet = " + result);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);

    }
    @Test
    public  void CheckTrixieBet () throws Exception {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckTrixieBetFeatures();
        firstTest.tearDown();
    }
}
