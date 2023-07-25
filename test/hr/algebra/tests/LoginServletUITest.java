package hr.algebra.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivan
 */
public class LoginServletUITest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        // Set the path to the web driver executable
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan\\Desktop\\Selenium\\chromedriver.exe");


        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();

        

        // Set the base URL of the web application
        baseUrl = "http://localhost:8080/NRAKO/"; // Replace with your actual base URL
    }

    @After
    public void tearDown() {
        // Close the browser after each test
        driver.quit();
    }

    @Test
    public void testLoginSuccess() {
        // Navigate to the login page
        driver.get(baseUrl + "LoginUser.html"); // Replace with the actual URL of your login page

        // Enter the username and password in the input fields
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("123");

        // Click on the login button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Wait for the redirect to the home page (adjust wait time as needed)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the user is redirected to the home page
        assertTrue(driver.getCurrentUrl().endsWith("homejsp.jsp")); // Replace with the actual URL of your home page
    }

    @Test
    public void testLoginFailure() {
        // Navigate to the login page
        driver.get(baseUrl + "LoginUser.html"); // Replace with the actual URL of your login page

        // Enter an invalid username and password in the input fields
        driver.findElement(By.name("username")).sendKeys("invalid-username");
        driver.findElement(By.name("password")).sendKeys("invalid-password");

        // Click on the login button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Wait for the login failure message (adjust wait time as needed)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the user is still on the login page (login failed)
        assertTrue(driver.getCurrentUrl().endsWith("http://localhost:8080/NRAKO/LoginServlet")); // Replace with the actual URL of your login page
    }
}
