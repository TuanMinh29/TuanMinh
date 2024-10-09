package com.testselenium.TuanMinh;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class DangNhap {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://student.hunre.edu.vn/congthongtin/login.aspx");
    }

    @Test
    public void testLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Ép kiểu JavascriptExecutor để đảm bảo tương thích
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        try {
            // Đợi trang tải hoàn toàn
            wait.until(webDriver -> jsExecutor.executeScript("return document.readyState").equals("complete"));

            // Các thao tác đăng nhập tiếp theo
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            username.sendKeys("21111060400");

            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            password.sendKeys("29/10/2003");

            WebElement loginButton = driver.findElement(By.name("cms_authenticate_do_login"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

            wait.until(ExpectedConditions.urlContains("https://student.hunre.edu.vn/congthongtin/Index.aspx#lichhoc"));
            WebElement dashboardElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='banner']")));
            assert dashboardElement.isDisplayed() : "Test Failed: Không tìm thấy trang chính!";
            System.out.println("Test Passed: Đăng nhập thành công!");
        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
