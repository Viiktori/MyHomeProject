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

    @FindBy(css = ".s-header-search__icon")
    private WebElement search;

    @FindBy(css = ".s-header-item__link")
    private WebElement input;

    @FindBy(css = ".categories__link--topcategory")
    private List<WebElement> searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void toSearch(String value){
        search.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys(value);
        input.submit();
    }

    public void takeItem(int n){
        searchItems.get(n).click();
    }


}
