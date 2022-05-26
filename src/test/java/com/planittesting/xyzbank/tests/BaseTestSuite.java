package com.planittesting.xyzbank.tests;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class BaseTestSuite {
    protected WebDriver driver;

    @BeforeEach
    public void setupTest() throws InterruptedException {
        driver = new ChromeDriver();
       
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @AfterEach
    public void teardownTest() {
        driver.close();
    }

}