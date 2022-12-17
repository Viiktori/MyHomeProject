package org.example.Lesson_7;

import io.qameta.allure.*;
import org.example.Lesson_5_6_update.Test3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class TestThree extends TestOne {
    @Test
    @DisplayName("Пустой скрипт")
    @Description("Тест ничего не делает")
    @Link("http://google.com")
    @Issue("https://www.livejournal.com/")
    @TmsLink("")
    @Severity(SeverityLevel.MINOR)
    void testTrue(){
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Сделай скрин")
    @Description("Тест создает скрин")
    @Link("http://google.com")
    @Issue("https://www.livejournal.com/")
    @Severity(SeverityLevel.BLOCKER)
    void testFalse() throws InterruptedException, IOException {
        Thread.sleep(1000);
        File file = MyUtils.makeScreenshot(getWebDriver(),"failure- org.example.Lesson_7.TestThree.testFalse" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        Assertions.assertTrue(true);
    }

    @Step("Степ 1")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    @DisplayName("Дай логи")
    @Description("Создаем логи")
    @Link("http://google.com")
    @Issue("https://www.livejournal.com/")
    @Severity(SeverityLevel.NORMAL)
    void testLogs(){
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0 ) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });

        }
    }

    @Feature("Фича 1")
    @Test
    void testTrue2(){
        Assertions.assertTrue(true);
    }

    @Feature("Фича 1")
    @Test
    void testTrue3(){
        Assertions.assertTrue(true);
    }

    @Feature("Фича 1")
    @Test
    void testTrue4(){
        Assertions.assertTrue(false);
    }
}
