package org.example.Lesson_5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function

public class Test3 extends Main {
    @Test
    void test() throws InterruptedException {
        getDriver().get("https://www.livejournal.com/");
        WebElement webElement = getDriver().findElement(By.cssSelector(".s-header-search__icon"));
        webElement.click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);


        Thread.sleep(10000);

        WebElement webElement2 = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id(".s-header-item__link"));
            }
        });

        webElement2.click();
        webElement2.sendKeys();
        webElement2.submit();
    }
}
