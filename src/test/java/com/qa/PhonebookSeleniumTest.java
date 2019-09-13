package com.qa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class PhonebookSeleniumTest {

    private ChromeDriver driver;
    private JavascriptExecutor js;
    private Actions action;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\IdeaProjects\\PhonebookSelenium\\src\\test\\java\\resources\\chromedriver.exe");


        driver = new ChromeDriver();

        js = (JavascriptExecutor) driver;

        action = new Actions (driver);

        //comment


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
        //test
        //createContact();
        editContact();
    }

    @Test
    public void createContact(){

    }



    @Test
    public void editContact() throws InterruptedException {
        WebElement editBtn = driver.findElementById("edit-contact-btn");
        editBtn.click();
        Thread.sleep(3000);
    }








}
