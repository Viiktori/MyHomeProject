package org.example.Lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test5 {
    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void getPage(){
        driver.get("https://www.livejournal.com/");
    }

    @Test
    void test() throws InterruptedException {

        WebElement webElement = driver.findElement(By.cssSelector(".s-header-search__icon"));
        webElement.click();
        Thread.sleep(1000);
        WebElement webElement2 = driver.findElement(By.cssSelector(".s-header-item__link"));
        webElement2.click();
        webElement2.sendKeys();
        webElement2.submit();
        Assertions.assertEquals("Поиск",driver.getTitle(),"Не та страница");
    }

    @AfterAll
    static void close(){
        driver.quit();
    }

}
