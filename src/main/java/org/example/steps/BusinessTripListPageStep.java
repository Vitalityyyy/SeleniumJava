package org.example.steps;

import io.cucumber.java.ru.И;
import io.qameta.allure.Step;
import org.example.managers.PageManager;

public class BusinessTripListPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @И("нажимаю Создать командировку")
    @Step("Нажать Создать командировку")
    public void clickCreateBusinessTripButton() {
        pageManager.getBusinessTripListPage().clickCreateBusinessTripButton();
    }
}
