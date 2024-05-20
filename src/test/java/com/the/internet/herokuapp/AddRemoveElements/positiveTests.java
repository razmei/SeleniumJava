package com.the.internet.herokuapp.AddRemoveElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class positiveTests {

    private WebDriver driver = new ChromeDriver();
    private String baseUrl = "https://the-internet.herokuapp.com/add_remove_elements/";



    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void closeUp() {
        driver.quit();
    }

    @Test
    public void addElement() {
        driver.get(baseUrl);

        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        addButton.click();

        WebElement deleteButton = driver.findElement(By.cssSelector("#elements > button"));
        Assert.assertTrue(deleteButton.isDisplayed());
    }

}

