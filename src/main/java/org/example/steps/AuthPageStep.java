package org.example.steps;

import io.cucumber.java.ru.Дано;
import io.qameta.allure.Step;
import org.example.managers.PageManager;

public class AuthPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @Дано("я авторизован в системе")
    @Step("Логин")
    public void login() {
        pageManager.getAuthPage().login();
    }

}
