package com.github.automation.first;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by Myhajlo.Rozputnyj on 17.08.2017.
 */
public class CheckTrebleBet {
    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
    }
    public  void CheckTrebleBetFeatures () throws  Exception {
        /* Open Game

        */
        CheckEachWayOnMultiples iframe = new CheckEachWayOnMultiples();
        iframe.openIframe();

        // submit three singles with stake = 0
        addThreeSinglesBetWithZeroStake();
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        String betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Treble")) { // check that Doubles bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);

        // Start Game
        System.out.println("Game started. Multiples bet = " + betName);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        Double stake;
        int bet;
        Double result;
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//treble stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//treble bet
        System.out.println("Numbers of bets at " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);
        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//treble result
        System.out.println("Win value of " + betName + " bet = " + result);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);

        // submit three singles with stake = 0
        addThreeSinglesBetWithZeroStake();
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Treble")) { // check that Doubles bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        // check bets
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//double bet
        System.out.println("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 4 race
        Thread.sleep(1000);
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Treble")) { // check that Doubles bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        // check bets
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//double bet
        System.out.println("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(1000);
        // check bets
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//double bet
        System.out.println("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[6]")).click(); //open race 6 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //add bet 4 trap 6 race
        Thread.sleep(1000);
        // check bets
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//double bet
        System.out.println("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);
        System.out.println("Game started. " + betName + " bet = " + betName);
        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//treble stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//treble bet
        System.out.println("Numbers of bets at " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);
        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//treble result
        System.out.println("Win value of " + betName + " bet = " + result);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);

        // submit three singles with stake = 0
        addThreeSinglesBetWithZeroStake();
        // open multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Treble")) { // check that Doubles bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        Thread.sleep(2000);
        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        if (betName.equals("Treble")) { // check that Doubles bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        Thread.sleep(2000);
        // set EW = yes for treble bet
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div")).click();// Set EW = yes
        Thread.sleep(2000);
        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("Bet Name = " + betName);
        // check bets
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//double bet
        System.out.println("Numbers of bets at  " + betName + " = " + bet);
        Thread.sleep(1000);

        // Start Game
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//treble stake
        System.out.println("Stake at " + betName + " = " + stake);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//treble bet
        System.out.println("Numbers of bets at " + betName + " = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);
        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//treble result
        System.out.println("Win value of " + betName + " bet = " + result);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);

    }

    public void addThreeSinglesBetWithZeroStake() throws InterruptedException {
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
    }

    @Test
    public  void CheckTrebleBet () throws Exception {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckTrebleBetFeatures();
        firstTest.tearDown();
    }
}
