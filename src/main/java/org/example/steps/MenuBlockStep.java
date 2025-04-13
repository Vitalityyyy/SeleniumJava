package org.example.steps;

import io.cucumber.java.ru.И;
import io.qameta.allure.Step;
import org.example.managers.PageManager;
import org.example.pages.MenuBlock;
import org.junit.jupiter.api.Assertions;

public class MenuBlockStep {

    PageManager pageManager = PageManager.getPageManager();

    @И("проверяю заголовок меню")
    @Step("Проверить заголовок")
    public void assertMenuBlockHeader() {
        pageManager.getMenuBlock().assertMenuBlockHeader();
    }

    @И("перехожу в список командировок")
    @Step("Перейти в Командировки")
    public void goToBusinessTripListPage() {
        pageManager.getMenuBlock().goToBusinessTripListPage();
    }
}
