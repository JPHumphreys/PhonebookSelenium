package com.qa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.assertTrue;

import java.io.File;

public class PhonebookSeleniumTest {

    private ChromeDriver driver;
    private JavascriptExecutor js;
    private Actions action;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\testing2\\src\\test\\java\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;

        action = new Actions (driver);

    //delete this

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void firstTest() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://localhost:5500/");
        Thread.sleep(2000);

        createContactButtonTest();
        removeCreateContactMenu();
        searchContactButtonTest();

    }

    @Test
    public void createContactButtonTest() throws InterruptedException {
        WebElement createContactButton = driver.findElement(By.id("create-contact-btn"));
        WebElement createMenu = driver.findElement(By.xpath("/html/body/div[1]/div[1]"));

        createContactButton.click();
        Thread.sleep(1000);

        assertTrue(createMenu.getAttribute("style").equals("display: block;"));
        Thread.sleep(500);
    }

    @Test
    public void removeCreateContactMenu() throws InterruptedException {
        WebElement closeButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/form/div[4]/button[1]"));
        WebElement createMenu = driver.findElement(By.xpath("/html/body/div/div[1]"));


        closeButton.click();
        Thread.sleep(1000);

        assertTrue(createMenu.getAttribute("style").equals("display: none;"));
        Thread.sleep(500);
    }

    @Test
    public void searchContactButtonTest() throws InterruptedException {
        WebElement searchContactButton = driver.findElement(By.id("search-contact-btn"));
        WebElement searchMenu = driver.findElement(By.xpath("/html/body/div/div[3]"));

        searchContactButton.click();
        Thread.sleep(1000);

        assertTrue(searchMenu.getAttribute("style").equals("display: block;"));
    }







}
