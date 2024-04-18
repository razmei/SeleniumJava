package com.demo.opencart.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class userRegistration {

    private WebDriver driver = new ChromeDriver();

    private String registerUrl = "https://demo.opencart.com/index.php?route=account/register&language=en-gb";
    private String expectedTitle = "Register Account";
    private String firstNameField = "//*[@id=\"input-firstname\"]";
    private String lastNameField = "//*[@id=\"input-lastname\"]";
    private String emailField = "//*[@id=\"input-email\"]";
    private String passwordField = "//*[@id=\"input-password\"]";

    private String agreementButton = "//*[@id=\"form-register\"]/div/div/div/input";
    private String submitButton = "//*[@id=\"form-register\"]/div/div/button";

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeUp() {
        driver.quit();
    }

    //Method that will randomly generate a String length of 10 alpha-numeric characters to use for name
    //Credits to: https://www.baeldung.com/java-random-string
    public String generateRandom() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    @Test
    public void registerUser() {

        driver.get(registerUrl);
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        String firstName = generateRandom();
        String lastName = generateRandom();
        String password = generateRandom();
        String email = generateRandom() + "@" + generateRandom() + ".com";

        driver.findElement(By.xpath(firstNameField)).sendKeys(firstName);
        driver.findElement(By.xpath(lastNameField)).sendKeys(lastName);
        driver.findElement(By.xpath(passwordField)).sendKeys(password);
        driver.findElement(By.xpath(emailField)).sendKeys(email);

        if (driver.findElement(By.xpath(submitButton)).isDisplayed()) {
            driver.findElement(By.xpath(agreementButton)).sendKeys(" ");
            driver.findElement(By.xpath(submitButton)).sendKeys(" ");
        }
    }


}
