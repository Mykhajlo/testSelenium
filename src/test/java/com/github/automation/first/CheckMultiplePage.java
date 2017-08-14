package com.github.automation.first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.automation.first.FirstTest.driver;

/**
 * Created by mykhail on 08.08.17.
 */
public class CheckMultiplePage {
    public WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = driver;
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }
    public  void CheckMultiplePageFeatures () throws Exception{
        /* Open Game
        add  bet, check any actions with multiples page : add stake, add  EW, remove EW, Check Total Stake for Double Bet
          add, one  by one, single bets  at each race tab, check appearing multiples  bet, check Total Stake for Doubles bets
          remove, one by one, singles bets at each race tab, check disappearing multiples  bet, check Total Stake for Doubles bets
        */
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 10000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            System.out.println("Error while switching to the frame. " + e.getMessage());
        }
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //add bet 5 trap 2 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/nav/div[2]/a/span[1]/translate/span")).click(); //open multiples page
        Thread.sleep(1000);
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Double")) {
            System.out.println("Double bet is present at Multiples");
        } else System.out.println("Double bet is not present at Multiples");
        String element = "//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]";
        CheckElement checkElement = new CheckElement();
        checkElement.CheckElement(element); //check that stake element is present at the double bet
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add default stake ("+")
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();//add stake ("+")
        System.out.println("Stake is changed");
        Thread.sleep(1000);

        double stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());
        double Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());
        double bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to Stake
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake is incorrect");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div ")).click(); //Click Each Way
        Thread.sleep(2000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to Stake with EW = yes
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake is incorrect");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/div/div ")).click(); //Click Each Way
        Thread.sleep(2000);
        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to Stake with EW = yes
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake is incorrect");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 3 race
        Thread.sleep(1000);

        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Treble")) { // check that Treble bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Trixie")) { // check that Trixie bet present at Multiples page
            System.out.println("Trixie bet is present at Multiples");
        } else System.out.println("Trixie bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Patent")) { // check that Patent bet present at Multiples page
            System.out.println("Patent bet is present at Multiples");
        } else System.out.println("Patent bet is not present at Multiples");
        Thread.sleep(1000);

        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to adding new Singles
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake = " + Tstake + "according to Bets =" + bets);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //add bet 2 trap 4 race
        Thread.sleep(1000);


        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Doubles")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Treble")) { // check that Treble bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Acca")) { // check that Acca bet present at Multiples page
            System.out.println("Acca bet is present at Multiples");
        } else System.out.println("Acca bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Yankee")) { // check that Yankee bet present at Multiples page
            System.out.println("Yankee bet is present at Multiples");
        } else System.out.println("Yankee bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Lucky15")) { // check that Lucky15 bet present at Multiples page
            System.out.println("Lucky15 bet is present at Multiples");
        } else System.out.println("Lucky15 bet is not present at Multiples");

        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to adding new Singles
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake = " + Tstake + "according to Bets =" + bets);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //add bet 3 trap 5 race
        Thread.sleep(1000);

        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Doubles")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Treble")) { // check that Treble bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Fourfold")) { // check that Fourfold bet present at Multiples page
            System.out.println("Fourfold bet is present at Multiples");
        } else System.out.println("Fourfold bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Acca")) { // check that Acca bet present at Multiples page
            System.out.println("Acca bet is present at Multiples");
        } else System.out.println("Acca bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Canadian")) { // check that Canadian bet present at Multiples page
            System.out.println("Canadian bet is present at Multiples");
        } else System.out.println("Canadian bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[6]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Lucky31")) { // check that Lucky31 bet present at Multiples page
            System.out.println("Lucky31 bet is present at Multiples");
        } else System.out.println("Lucky31 bet is not present at Multiples");


        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to adding new Singles
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake = " + Tstake + "according to Bets = " + bets);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[6]")).click(); //open race 6 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //add bet 4 trap 6 race
        Thread.sleep(1000);


        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Doubles")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Treble")) { // check that Treble bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Fourfold")) { // check that Fourfold bet present at Multiples page
            System.out.println("Fourfold bet is present at Multiples");
        } else System.out.println("Fivefold bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Fivefold")) { // check that Fivefold bet present at Multiples page
            System.out.println("Fivefold bet is present at Multiples");
        } else System.out.println("Fourfold bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Acca")) { // check that Acca bet present at Multiples page
            System.out.println("Acca bet is present at Multiples");
        } else System.out.println("Acca bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[6]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Heinz")) { // check that Heinz bet present at Multiples page
            System.out.println("Heinz bet is present at Multiples");
        } else System.out.println("Heinz bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[7]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Lucky63")) { // check that Lucky63 bet present at Multiples page
            System.out.println("Lucky63 bet is present at Multiples");
        } else System.out.println("Lucky63 bet is not present at Multiples");

        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to adding new Singles
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake = " + Tstake + "according to Bets = " + bets);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[4]/td[4]/a")).click(); //remove bet 4 trap 6 race
        Thread.sleep(1000);

        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Doubles")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Treble")) { // check that Treble bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Fourfold")) { // check that Fourfold bet present at Multiples page
            System.out.println("Fourfold bet is present at Multiples");
        } else System.out.println("Fourfold bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Acca")) { // check that Acca bet present at Multiples page
            System.out.println("Acca bet is present at Multiples");
        } else System.out.println("Acca bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Canadian")) { // check that Canadian bet present at Multiples page
            System.out.println("Canadian bet is present at Multiples");
        } else System.out.println("Canadian bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[6]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Lucky31")) { // check that Lucky31 bet present at Multiples page
            System.out.println("Lucky31 bet is present at Multiples");
        } else System.out.println("Lucky31 bet is not present at Multiples");

        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to adding new Singles
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake = " + Tstake + "according to Bets = " + bets);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[5]")).click(); //open race 5 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[3]/td[4]/a")).click(); //remove bet 3 trap 5 race
        Thread.sleep(1000);

        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[1]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Doubles")) { // check that Doubles bet present at Multiples page
            System.out.println("Doubles bet is present at Multiples");
        } else System.out.println("Doubles bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Treble")) { // check that Treble bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Acca")) { // check that Acca bet present at Multiples page
            System.out.println("Acca bet is present at Multiples");
        } else System.out.println("Acca bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Yankee")) { // check that Yankee bet present at Multiples page
            System.out.println("Yankee bet is present at Multiples");
        } else System.out.println("Yankee bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[5]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Lucky15")) { // check that Lucky15 bet present at Multiples page
            System.out.println("Lucky15 bet is present at Multiples");
        } else System.out.println("Lucky15 bet is not present at Multiples");

        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to adding new Singles
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake = " + Tstake + "according to Bets =" + bets);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[4]")).click(); //open race 4 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //remove bet 2 trap 4 race
        Thread.sleep(1000);

        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Treble")) { // check that Treble bet present at Multiples page
            System.out.println("Treble bet is present at Multiples");
        } else System.out.println("Treble bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[3]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Trixie")) { // check that Trixie bet present at Multiples page
            System.out.println("Trixie bet is present at Multiples");
        } else System.out.println("Trixie bet is not present at Multiples");
        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div[4]/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Patent")) { // check that Patent bet present at Multiples page
            System.out.println("Patent bet is present at Multiples");
        } else System.out.println("Patent bet is not present at Multiples");
        Thread.sleep(1000);

        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to adding new Singles
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake = " + Tstake + "according to Bets =" + bets);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[3]")).click(); //open race 3 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[2]/td[4]/a")).click(); //remove bet 2 trap 3 race
        Thread.sleep(1000);

        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[1]/translate/span")).getText()).equals("Double")) {
            System.out.println("Double bet is present at Multiples");
        } else System.out.println("Double bet is not present at Multiples");
        Thread.sleep(1000);

        stake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText());//Stake
        Tstake = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText());//Total stake
        bets = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/div/table/tbody/tr/td[1]/table[1]/tbody/tr/td[3]")).getText().substring(7));//Bets count
        Thread.sleep(1000);
        if (Tstake == bets*stake)//Check that Total Stake changed according to adding new Singles
        {
            System.out.println("Total Stake " + Tstake + " = " + bets*stake + " -> is correct");
        } else System.out.println("Total Stake = " + Tstake + "according to Bets =" + bets);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[2]")).click(); //open race 2 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[5]/td[4]/a")).click(); //remove bet 5 trap 2 race
        Thread.sleep(1000);

        if ((driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/translate/span")).getText()).equals("Place at least 2 bets")) {
            System.out.println("Multiples page is empty");
        } else System.out.println("Multiples page is not empty");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/main-header/header/div/header-navigation/div/div/a[1]")).click(); //open race 1 tab
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //remove bet 1 trap 1 race
        Thread.sleep(1000);


        System.out.println("Test finished!");
        Thread.sleep(1000);

    }
    @Test
    public void CheckMultiplePage() throws Exception {
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckMultiplePageFeatures();
        firstTest.tearDown();
    }
}
