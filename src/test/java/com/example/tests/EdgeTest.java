package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EdgeTest {
    private static WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void openSignUpForm() {
        driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("sadmanxyz");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("(//input[contains(@placeholder,'Email Address')])[2]")).sendKeys("Sadmanxyz@mail.com");
        driver.findElement(By.xpath("//button[contains(text(),\"Signup\")]")).click();

        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
    }

    @Test(priority = 2)
    public void fillSignUpForm() {
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//*[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");

        WebElement dayDropdown = driver.findElement(By.xpath("//*[@id='days']"));
        Select day = new Select(dayDropdown);
        day.selectByValue("14");

        WebElement monthDropdown = driver.findElement(By.xpath("//*[@id='months']"));
        Select month = new Select(monthDropdown);
        month.selectByIndex(10);

        WebElement yearDropdown = driver.findElement(By.xpath("//*[@id='years']"));
        Select year = new Select(yearDropdown);
        year.selectByVisibleText("1998");

        driver.findElement(By.cssSelector("#newsletter")).click();
        driver.findElement(By.cssSelector("#optin")).click();

        driver.findElement(By.cssSelector("#first_name")).sendKeys("Sadman");
        driver.findElement(By.cssSelector("#company")).sendKeys("Habib");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("123 Milkyway St");
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Apt 2");
        driver.findElement(By.xpath("//*[@id='country']")).click();
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("New York");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Brooklyn");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("11456");
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("3475780991");
        driver.findElement(By.xpath("//*[@id='form']/div/div/div/div/form/button")).click();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
