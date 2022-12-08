package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_two {

    public static void main(String[] args) {

        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");

        WebElement webElement1 = driver.findElement(By.class("post-card__link"));
        WebElement webElement2 = driver.findElement(By.class("s-header-item-post--short"));



        try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        }

        List<WebElement> webElements = driver.findElements(By.name("error"));
        if(webElements.size()>1){

        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.urlContains("livejournal"));

        driver.navigate().to("https://www.livejournal.com/");

        try {
            webElement3.sendKeys("Новые лица");
        } catch (StaleElementReferenceException e){
            System.out.println(e.getSupportUrl());
        }

        try {
            driver.findElement(By.xpath(".//textarea")).click();
        } catch (ElementNotInteractableException e){
            System.out.println(e.getSupportUrl());
        }

        // driver.quit();
    }
}
