package com.the.internet.herokuapp.BasicAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class positiveTests {

    private WebDriver driver = new ChromeDriver();
    private String baseUrl = "the-internet.herokuapp.com/basic_auth";
    private String username = "admin";
    private String password = "admin";


    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://" + username + ":" + password + "@" + baseUrl);
    }

    @AfterMethod
    public void closeUp() {
        driver.quit();
    }

    @Test
    public void loginSuccess() {
        String expectedMessage = "Congratulations! You must have the proper credentials.";
        String loginMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
        Assert.assertEquals(expectedMessage,loginMessage);
    }

}
