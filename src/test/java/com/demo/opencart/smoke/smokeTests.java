package com.demo.opencart.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class smokeTests {

    private WebDriver driver = new ChromeDriver();

    private String baseUrl = "https://demo.opencart.com/";
    private String expectedTitle = "Your Store";

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeUp() {
        driver.quit();
    }

    @Test
    public void pageLoads() {
        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

}
