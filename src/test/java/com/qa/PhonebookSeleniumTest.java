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
import java.util.ArrayList;
import java.util.List;

public class PhonebookSeleniumTest {

    private ChromeDriver driver;
    private JavascriptExecutor js;
    private Actions action;

    @Before
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\testing2\\src\\test\\java\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\PhonebookSelenium2\\src\\test\\java\\resources\\chromedriver.exe");

        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;

        action = new Actions (driver);

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void firstTest() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://localhost:5500/");
        Thread.sleep(1000);

        createContactButtonTest();
        removeCreateContactMenuTest();
        searchContactButtonTest();
        closeSearchContactMenuTest();
        editContact();
        closeEditContactMenu();

        createTest();
        searchTest();
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
    public void removeCreateContactMenuTest() throws InterruptedException {
        WebElement closeButton = driver.findElement(By.id("create-contact-close"));
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

    @Test
    public void closeSearchContactMenuTest() throws InterruptedException {
        WebElement closeButton = driver.findElement(By.id("search-contact-close"));
        WebElement searchMenu = driver.findElement(By.xpath("/html/body/div/div[3]"));

        closeButton.click();
        Thread.sleep(1000);

        assertTrue(searchMenu.getAttribute("style").equals("display: none;"));
    }

    @Test
    public void editContact() throws InterruptedException {
        WebElement editBtn = driver.findElementById("edit-contact-btn");
        editBtn.click();
        Thread.sleep(1000);

        WebElement editMenu = driver.findElement(By.xpath("/html/body/div[2]"));
        assertTrue(editMenu.getAttribute("class").equals("modal-backdrop fade show"));
        Thread.sleep(1000);
    }

    @Test
    public void closeEditContactMenu() throws InterruptedException {
        WebElement closeButton = driver.findElement(By.id("edit-modal-close"));

        closeButton.click();
        assertTrue(true);

        Thread.sleep(1000);
    }

    @Test
    public void createTest() throws InterruptedException {
        createContactButtonTest();

        WebElement  firstNameBox = driver.findElement(By.id("firstName"));
        WebElement addressBox = driver.findElement(By.id("address"));
        WebElement numberBox = driver.findElement(By.id("phoneNumber"));
        WebElement createButton = driver.findElement(By.id("create-contact-create"));

        List<String> names = new ArrayList<String>();
        List<String> addresses = new ArrayList<String>();
        List<String> numbers = new ArrayList<String>();

        names.add("Jon");
        names.add("Mark");
        names.add("Dave");
        addresses.add("10 Jon-Way");
        addresses.add("20 Mark Avenue");
        addresses.add("30 Dave Lane");
        numbers.add("07555 844955");
        numbers.add("07655 234445");
        numbers.add("07111 478883");


        for (int i = 0; i<=2; i++) {
            firstNameBox.sendKeys(names.get(i));
            Thread.sleep(500);
            addressBox.sendKeys(addresses.get(i));
            Thread.sleep(500);
            numberBox.sendKeys(numbers.get(i));
            Thread.sleep(1000);
            createButton.click();
            Thread.sleep(1000);

            if (i==2) {
                break;
            } else {
                createContactButtonTest();
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void searchTest() throws InterruptedException {
        searchContactButtonTest();

        WebElement nameBox = driver.findElement(By.id("firstName"));
        WebElement searchButton = driver.findElement(By.id("search-contact-search"));

        List<String> names = new ArrayList<String>();
        names.add("Jon");
        names.add("Mark");
        names.add("Dave");

        for (int i = 0; i<=2; i++) {
            nameBox.sendKeys(names.get(i));
            Thread.sleep(1000);
            searchButton.click();
            Thread.sleep(1000);

            if (i==2) {
                break;
            } else {
                searchContactButtonTest();
                Thread.sleep(1000);
            }
        }
    }


    @Test
    public void editTest() throws InterruptedException {
        //FILL THIS IN
    }





}
