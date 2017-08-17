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
 * Created by mykhail on 07.08.17.
 */
public class CheckSinglesPage {
    public WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = driver;
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
    }
    public void CheckSinglesPageFeatures() throws  InterruptedException{
        /* Open Game
a           add one single  bet
            add default stake, change stake, compare with Total Stake
            add EW = yes, compare with Total stake, set EW = No,
            compare with Total Stake, remove single  bet, check that Singles page is empty
        */
        driver.switchTo().frame(driver.findElement(By.id("iframeContainer")));
        System.out.println("Bingo! You are at iframeContainer");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 5000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[6]/td[4]/a"))); // find Add to Bet slip button for Race 1 and Trap 6
        } catch (Throwable e) {
            System.out.println("Error while switching to the frame. " + e.getMessage());
        }
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[1]/section/table/tbody/tr[1]/td[4]/a")).click(); //add bet 1 trap 1 race
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[3]")).click();// click "+" and change stake to default
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[1]")).click();// click "-" and change stake
        Thread.sleep(1000);
        String stake = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText();//take stake  value
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Stake = " + stake);
        Thread.sleep(1000);
        String Tstake = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText();
        System.out.println("Total stake = " + Tstake);
        Thread.sleep(1000);
        if (stake.equals(Tstake))
        {
            System.out.println("Total Stake " + stake + " = " + Tstake +" Stake -> after changing stake");
        } else System.out.println("Total Stake " + stake + " != " + Tstake +" Stake -> after changing stake");
        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click(); //Click Each Way
        Thread.sleep(1000);

        String Estake = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[1]/div/div[2]")).getText();//take stake value
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        System.out.println("Stake = " + Estake);
        double EWstake = Double.parseDouble(Estake);
        Thread.sleep(1000);

        String TEstake = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText();// take  Total Stake value
        System.out.println("Total stake = " + TEstake);
        double EWTstake = Double.parseDouble(TEstake);
        Thread.sleep(1000);

        if (EWTstake == 2*EWstake)//Check that Total Stake changed according to EW = yes
        {
            System.out.println("Total Stake " + EWTstake + " = " + 2*EWstake + " -> is correct");
        } else System.out.println("Total Stake is incorrect");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[1]/table[2]/tbody/tr/td[2]/div")).click(); //Click Each Way
        Thread.sleep(1000);
        String TEEstake = driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[1]/div/span")).getText();// take  Total Stake value
        System.out.println("Total stake = " + TEEstake);
        double EEWTstake = Double.parseDouble(TEEstake);
        Thread.sleep(1000);
        if (EEWTstake == EWstake)//Check that Total Stake changed according to EW = no
        {
            System.out.println("Total Stake " + EEWTstake + " = " + EWstake + " -> is correct");
        } else System.out.println("Total Stake is incorrect");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"game\"]/div[1]/section/div[2]/div/div/div[1]/div/div[2]/div/table/tbody/tr/td[2]/a")).click();//delete single bet
        Thread.sleep(1000);
    }
    @Test
    public void CheckSinglesPage () throws IOException,  InterruptedException{
        FirstTest firstTest = new FirstTest();
        firstTest.setUp();
        firstTest.OpenLobbyRunGame();
        System.out.println("Game is opened");
        CheckSinglesPageFeatures();
        firstTest.tearDown();
    }

}
