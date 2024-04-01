package com.the.internet.herokuapp.BasicAuth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class positiveTests {

    public String baseUrl = "https://the-internet.herokuapp.com/basic_auth";
    public WebDriver driver = new ChromeDriver();


    @BeforeTest
    public void setUp() {
        driver.get(baseUrl);
    }

    @AfterTest
    public void closeUp() {
        driver.quit();
    }

    @Test
    public void verifyPageLoads() {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, baseUrl);
    }

}
