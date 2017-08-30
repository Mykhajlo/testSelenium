package com.github.automation.first;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.automation.first.Utils.openLobby;
import static com.github.automation.first.Utils.setupEnvironment;
import static com.github.automation.first.Utils.switchToIframe;

/**
 * Created by Myhajlo.Rozputnyj on 30.08.2017.
 */
public class CanadianBetTest {
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
    public void checkFourfoldBetFeatures() throws Exception {
        /*Open Game
        submit five singles with stake = 0, open multiples page
        check bet name, change stake, check bet
        Start Game, check fourfold result after skipping races, Click New Game
        submit five singles with stake = 0, open multiples page, add EW to fourfold
        check bet name, change stake, check bet
        Start Game, check fourfold result after skipping races, Click New Game
        submit five singles with stake = 0, open multiples page
        check bet name, change stake, check bet
        Start Game, check fourfold result after skipping races, Click New Game
         */
        switchToIframe(driver);
        // submit five singles with stake = 0

    }
}
