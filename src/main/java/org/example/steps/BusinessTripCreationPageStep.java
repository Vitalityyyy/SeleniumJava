package org.example.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.example.managers.PageManager;

public class BusinessTripCreationPageStep {

    PageManager pageManager = PageManager.getPageManager();

    @И("проверяю заголовок страницы создания командировки")
    @Step("Проверить заголовок")
    public void assertBusinessTripCreationPageHeader() {
        pageManager.getBusinessTripCreationPage().assertBusinessTripCreationPageHeader();
    }

    @И("выбираю отдел")
    @Step("Выбратть отдел")
    public void selectDepartment() {
        pageManager.getBusinessTripCreationPage().selectDepartment();
    }

    @И("выбираю компанию")
    @Step("Выбрать компанию")
    public void selectCompany() {
        pageManager.getBusinessTripCreationPage().selectCompany();
    }

    @И("нажимаю чекбокс Заказать билеты")
    @Step("Нажать чекбокс")
    public void clickTicketsOrderCheckbox() {
        pageManager.getBusinessTripCreationPage().clickTicketsOrderCheckbox();
    }

    @И("заполняю город отправления")
    @Step("Заполнить город отправления")
    public void fillDepartureCity() {
        pageManager.getBusinessTripCreationPage().fillDepartureCity("Санкт-Петербург");
    }

    @И("заполняю город прибытия")
    @Step("Заполнить город прибытия")
    public void fillArrivalCity() {
        pageManager.getBusinessTripCreationPage().fillArrivalCity("Казань");
    }

    @И("заполняю дату отправления")
    @Step("Заполнить дату отправления")
    public void fillDepartureDate() {
        pageManager.getBusinessTripCreationPage().fillDepartureDate("31.03.2025");
    }

    @И("заполняю дату прибытия")
    @Step("Заполнить дату прибытия")
    public void fillReturnDate() {
        pageManager.getBusinessTripCreationPage().fillReturnDate("13.04.2025");
    }

    @И("проверяю заполнение полей")
    @Step("Проверить заполнение полей")
    public void assertFieldsFilled() {
        pageManager.getBusinessTripCreationPage().assertFieldsFilled();
    }

    @И("нажимаю Сохранить и выйти")
    @Step("Нажать Сохранить и выйти")
    public void clickSaveAndClose() {
        pageManager.getBusinessTripCreationPage().clickSaveAndClose();
    }

    @Тогда("я должен увидеть ошибку валидации незаполненных обязательных полей")
    @Step("Проверить ошибку валидации")
    public void assertErrorMessage() {
        pageManager.getBusinessTripCreationPage().assertErrorMessage();
    }
}
