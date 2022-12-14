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

    @FindBy(css = ".s-header-search__icon")
    private WebElement search;

    @FindBy(css = ".s-header-item__link")
    private WebElement input;

    @FindBy(css = ".categories__link--topcategory")
    private List<WebElement> searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @AfterAll
    static void close(){
        driver.quit();
    }

}
