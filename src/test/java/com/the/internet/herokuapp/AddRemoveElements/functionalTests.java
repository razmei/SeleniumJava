package com.the.internet.herokuapp.AddRemoveElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


//Verify functionality of the Add/Remove Elements page

public class functionalTests {

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
        /*
        A) Test Add button functionality
            Steps:
            1. Open web page
            2. Click on "Add" button
            3. Assert element is created
         */

        driver.get(baseUrl);

        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        addButton.click();

        WebElement deleteButton = driver.findElement(By.cssSelector("#elements > button"));
        Assert.assertTrue(deleteButton.isDisplayed());
    }

    @Test
    public void deleteElement() {
        /*
        B) Test Delete button functionality
            Steps:
            2. Click on "Add" button
            3. Assert element is created
            4. Click on "Delete" button
            5. Assert element is deleted
         */

        driver.get(baseUrl);

        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        addButton.click();

        WebElement deleteButton = driver.findElement(By.cssSelector("#elements > button"));
        Assert.assertTrue(deleteButton.isDisplayed());
        deleteButton.click();

        List<WebElement> elements = driver.findElements(By.cssSelector("#elements > button"));
        Assert.assertTrue(elements.isEmpty());
    }

    @Test
    public void addElements() {
        /*
        C) Test multiple Add button functionality? (does this functionality work)
            Steps:
            1. Open web page
            2. Click on "Add" button x3 times
            3. Assert there are 3 "Delete" buttons created
         */

        driver.get(baseUrl);

        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        addButton.click();
        addButton.click();
        addButton.click();

        List<WebElement> elements = driver.findElements(By.cssSelector("#elements > button"));
        Assert.assertEquals(elements.size(),3);

    }

    @Test
    public void deleteElements() {
        /*
        D) Test multiple Delete button functionality (idem)
            Steps:
            1. Open web page
            2. Click on "Add" button x3 times
            3. Assert 3 elements are created
            4. Click delete button.
            5. Assert 2 elements remain
         */

        driver.get(baseUrl);

        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        addButton.click();
        addButton.click();
        addButton.click();
        List<WebElement> elements = driver.findElements(By.cssSelector("#elements > button"));
        Assert.assertEquals(elements.size(),3);

        WebElement deleteButton = driver.findElement(By.cssSelector("#elements > button"));
        deleteButton.click();
        List<WebElement> elements2 = driver.findElements(By.cssSelector("#elements > button"));
        Assert.assertEquals(elements2.size(),2);

    }

}

