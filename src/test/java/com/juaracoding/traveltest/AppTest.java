package com.juaracoding.traveltest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTest {
    private WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
    }
    @Test
    public void registerUserTest() throws InterruptedException {
        // isi form register
        driver.findElement(By.name("firstName")).sendKeys("Zenitha");
        driver.findElement(By.name("lastName")).sendKeys("QA");
        driver.findElement(By.name("phone")).sendKeys("08123456789");
        driver.findElement(By.name("userName")).sendKeys("zenitha@test.com");
        driver.findElement(By.name("address1")).sendKeys("Jl. Testing");
        driver.findElement(By.name("city")).sendKeys("Jakarta");
        driver.findElement(By.name("state")).sendKeys("DKI");
        driver.findElement(By.name("postalCode")).sendKeys("12345");
        driver.findElement(By.name("email")).sendKeys("zenithaQA");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirmPassword")).sendKeys("123456");
        driver.findElement(By.name("submit")).click();

        WebElement successMessage = driver.findElement(By.xpath("//table//p[3]/font"));
        String actualText = successMessage.getText();
        String expectedText = "Note: Your user name is zenithaQA.";

        Assert.assertEquals(actualText, expectedText, "Registrasi gagal!");
    }

}
