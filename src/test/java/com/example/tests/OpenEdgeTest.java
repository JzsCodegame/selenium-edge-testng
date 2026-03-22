package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenEdgeTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    @Test
    public void openWebsite() {
        driver.get("https://automationexercise.com/"); // replace with your site
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

