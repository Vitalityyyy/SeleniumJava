package org.example.utils;

import io.qameta.allure.Allure;
import org.example.managers.DriverManager;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureTestWatcher implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

        WebDriver driver = DriverManager.getDriverManager().getDriver();

        if (driver != null) {
            try {
                // Делаем скриншот
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot on failure",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png");

                // Добавляем исходный код страницы
                String pageSource = driver.getPageSource();
                Allure.addAttachment("Page source", "text/html", pageSource);

            } catch (Exception e) {
                Allure.addAttachment("Screenshot failed", "text/plain", e.getMessage());
            }
        }

        // Добавляем информацию об ошибке
        Allure.addAttachment("Stacktrace", "text/plain", cause.toString());
    }
}