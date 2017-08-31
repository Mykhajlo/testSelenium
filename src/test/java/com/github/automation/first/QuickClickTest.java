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
 * Created by Myhajlo.Rozputnyj on 31.08.2017.
 */
public class QuickClickTest {
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
    public void QuickClickFeatures() throws Exception {
        /*Open Game

         */
        switchToIframe(driver);

    }
}
