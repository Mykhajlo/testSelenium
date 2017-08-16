package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by mykhail on 16.08.17.
 */
public class CheckDoubleBet {
    public WebDriver webDriver;
    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
    public void CheckDoubleBetFeatures () throws  Exception {
        /* Open Game
        submit two singles with stake = 0, submit Double  bet with stake != 0,
        */
        CheckEachWayOnMultiples iframe = new CheckEachWayOnMultiples();
        iframe.openIframe();
        // submit two singles with stake = 0
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        System.out.println("Bet at race 1 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        System.out.println("Bet at race 2 added");
        Thread.sleep(2000);
        // open Multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(1000);
        String betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("betName = " + betName);
        if (betName.equals("Doubles")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);
        // Start Game
        System.out.println("Game started. Multiples bet = Double");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        Double stake;
        int bet;
        Double result;
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//double stake
        System.out.println("Stake at Double = " + stake);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//double bet
        System.out.println("Numbers of bets at Double = " + bet);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);
        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//double result
        System.out.println("Win value of Double bet = " + result);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);

        // submit 6 singles bet with stake  = 0
        CheckEachWayOnMultiples addBet = new CheckEachWayOnMultiples();
        addBet.addSixSinglesBetWithZeroStake();
        Thread.sleep(1000);
        // open Multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(1000);           //*[@id="game"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).click();// Set Stake > 0 for double  bet
        //String a = driver.findElement(By.xpath("//*[@id=\\\"game\\\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText();
        //System.out.println("a = " + a);
//        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//double stake
//        System.out.println("Stake at Double = " + stake);
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("betName = " + betName);
        if (betName.equals("Doubles")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        Thread.sleep(2000);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(6));//double bet
        System.out.println("Numbers of bets at Double = " + bet);


        // Start Game
        System.out.println("Game started. Multiples bet = " + betName);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//double stake
        System.out.println("Stake at Double = " + stake);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//double bet
        System.out.println("Numbers of bets at Double = " + bet);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);

        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//double result
        System.out.println("Win value of" + betName + " bet = " + result);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);

        // submit two singles with stake = 0
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        System.out.println("Bet at race 1 added");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        System.out.println("Bet at race 2 added");
        Thread.sleep(2000);

        // open Multiples page
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]")).click(); // open multiples  page
        Thread.sleep(1000);
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("betName = " + betName);
        if (betName.equals("Double")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        Thread.sleep(2000);

        // change stake
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// Set Stake > 0 for double  bet
        Thread.sleep(2000);

        // set EW = yes
        driver.findElement(By.xpath("66666666666666666")).click();// Set EW = yes
        Thread.sleep(2000);

        // check bet name
        betName = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText();
        System.out.println("betName = " + betName);
        if (betName.equals("Doubles")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        Thread.sleep(2000);

        // Start Game
        System.out.println("Game started. Multiples bet = " + betName);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[1]/a")).click();// Click Start Game
        Thread.sleep(1000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[2]/div")).getText());//double stake
        System.out.println("Stake at Double = " + stake);
        bet =  Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[1]/span")).getText().substring(6));//double bet
        System.out.println("Numbers of bets at Double = " + bet);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a/div")).click();// Click Skip All
        Thread.sleep(1000);

        result = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/section/table[2]/tbody/tr/td[3]/span")).getText());//double result
        System.out.println("Win value of" + betName + " bet = " + result);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/footer/a")).click();// Click New Game
        Thread.sleep(1000);


    }
    @Test
    public  void CheckDoubleBet () throws Exception {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckDoubleBetFeatures();
        firstTest.tearDown();
    }

}
