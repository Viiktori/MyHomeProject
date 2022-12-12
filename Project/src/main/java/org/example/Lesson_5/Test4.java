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

import java.time.Duration;

public class Test4 extends Main {
    @Test
    void myActiontest() throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.livejournal.com/"));
        Assertions.assertTrue(getDriver().getTitle().contains("живой журнал"), "страница входа недоступна");

        // Создадим экземпляр класса Actions
        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.cssSelector(".s-header-search__icon")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector(".s-header-item__link"))
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector(".categories__link--topcategory")))
                .build()
                .perform();

        Thread.sleep(1000);
    }

    @Test
    void jsTest() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        System.out.println("Размер окна " +windowWidth);
        jsExecutor.executeScript("window.scrollBy(0,500)");

        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

    }

    @Test
    void cookieTest(){
        getDriver().manage().addCookie(new Cookie("promo_code", "november2"));
        for(Cookie cookie: getDriver().manage().getCookies()){
            System.out.println(cookie.getName() + " " + cookie.getExpiry());
        }

        getDriver().manage().deleteCookie(new Cookie("promo_code", "november2"));

    }

    @Test
    @Disabled
    void voidTest(){
        WebElement voidElement = getDriver().findElement(By.cssSelector(".s-header-search__icon"));
        Actions actionProviderContext = new Actions(getDriver());
        actionProviderContext.contextClick(voidElement).build().perform();

        Actions actionProviderDouble = new Actions(getDriver());
        actionProviderDouble.doubleClick(voidElement).build().perform();

        Actions actionProviderMove = new Actions(getDriver());
        actionProviderMove.moveToElement(voidElement).build().perform();

        Actions actionProviderOffset = new Actions(getDriver());
        actionProviderOffset.moveByOffset(1, 1).build().perform();

        Actions actionProvider = new Actions(getDriver());
        actionProvider.dragAndDrop(voidElement, voidElement).build().perform();

        Actions actionProviderHold = new Actions(getDriver());
        actionProviderHold.clickAndHold(voidElement).moveToElement(voidElement).build().perform();
        actionProviderHold.release().build().perform();

    }

    @Test
    @Disabled
    void voidKeyTest(){
        Actions actionProvider = new Actions(getDriver());
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();

        keydown.perform();

        actionProvider.sendKeys(Keys.ENTER).perform();
    }

    @Test
    @Disabled
    void voidBrowserTest(){
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        getDriver().navigate().to("https://selenium.dev");
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Test
    @Disabled
    void voidElements(){
        WebElement selectElement = getDriver().findElement(By.id("selectElementID"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(1);
        selectObject.selectByValue("value1");
        selectObject.selectByVisibleText("Bread");
        selectObject.deselectAll();
    }
}
