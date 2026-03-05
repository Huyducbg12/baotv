package com.example.thi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class VitimexTest {
    private WebDriver webDriver;
    private String randomEmail = "huyduc" + System.currentTimeMillis() + "@gmail.com";
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }
    @Test
    @DisplayName("Test quy trình Đăng ký -> Đăng xuất -> Đăng nhập lại")
    void testVitimexWorkflow() throws InterruptedException {
        webDriver.get("https://vitimex.com.vn/account/register");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Nguyễn Huy");
        webDriver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Đức");
        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(randomEmail);
        webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Huyduc123@");
        webDriver.findElement(By.xpath("//input[@value='Đăng ký']")).click();
        Thread.sleep(5000);
        try {
            WebElement logoutLink = webDriver.findElement(By.xpath("//a[contains(@href, '/account/logout')]"));
            logoutLink.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            webDriver.get("https://vitimex.com.vn/account/logout");
            Thread.sleep(2000);
        }
        webDriver.get("https://vitimex.com.vn/account/login");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"customer_email\"]")).sendKeys(randomEmail);
        webDriver.findElement(By.xpath("//*[@id=\"customer_password\"]")).sendKeys("Huyduc123@");
        webDriver.findElement(By.xpath("//input[@value='Đăng nhập']")).click();
        Thread.sleep(3000);
        WebElement accountInfo = webDriver.findElement(By.xpath("//a[contains(@href, '/account/logout')]"));
        assertTrue(accountInfo.isDisplayed(), "Đăng nhập không thành công!");
    }
    @AfterEach
    void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}