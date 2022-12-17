package org.example.Lesson_7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TestTwo extends TestOne {
    @Test
    void test1(){
        try {
            getWebDriver().findElement(By.id("элемент отсутствует'"));
        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getWebDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }

    }

    @Test
    void test2(){
        WebElement webElement = getWebDriver().findElement(By.cssSelector(".s-header-search__icon"));
        webElement.click();

    }
}
