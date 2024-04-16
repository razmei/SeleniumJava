package com.the.internet.herokuapp.BasicAuth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class negativeTests {

    private WebDriver driver = new ChromeDriver();
    private String baseUrl = "the-internet.herokuapp.com/basic_auth";
    private String username = "admin";
    private String password = "admin";

    private String wrongUsername = "wrongUser";
    private String wrongPassword = "wrongPass";


    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeUp() {
        driver.quit();
    }

    public static boolean loginWithCredentials(WebDriver driver, String username, String password) {
        // Extracting username and password input fields
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//form//button"));

        // Entering username and password
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        // Clicking on the login button
        loginButton.click();

        // Checking if login was successful
        String currentUrl = driver.getCurrentUrl();
        return !currentUrl.equals("https://the-internet.herokuapp.com/basic_auth");
    }

    @Test
    public void wrongUsername() {
//        driver.get("https://" + wrongUsername + ":" + password + "@" + baseUrl);
//        String expectedMessage = "Congratulations! You must have the proper credentials.";
//        String loginMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
//        Assert.assertEquals(expectedMessage,loginMessage);


        // 1. Attempting to log in with incorrect credentials
        boolean loginAttemptResult = loginWithCredentials(driver, "invalidUsername", "invalidPassword");
        Assert.assertFalse(loginAttemptResult, "Login with incorrect credentials was successful.");

        // 2. Accessing the page without providing any credentials
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, "https://the-internet.herokuapp.com/basic_auth",
                "Accessing the page without credentials was successful.");

        // 3. Attempting to bypass basic authentication by directly accessing the URL
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, "https://the-internet.herokuapp.com/basic_auth",
                "Bypassing basic authentication was successful.");

        // 4. Reloading the page after providing incorrect credentials
        loginAttemptResult = loginWithCredentials(driver, "invalidUsername", "invalidPassword");
        Assert.assertFalse(loginAttemptResult, "Login with incorrect credentials was successful after reloading.");


    }

}
