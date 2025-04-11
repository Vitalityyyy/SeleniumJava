package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class MenuBlock extends BasePage {

    @FindBy(xpath = "//h1[text()='Панель быстрого запуска']")
    private WebElement quickStartHeader;

    @FindBy(xpath = "//*[text()='Расходы']")
    private WebElement expensesButton;

    @FindBy(xpath = "//*[text()='Командировки']")
    private WebElement businessTripsButton;

    @Step("Проверить заголовок")
    public MenuBlock assertMenuBlockHeader() {
        waitTillVisible(quickStartHeader);
        Assertions.assertTrue(quickStartHeader.isDisplayed(), "Заголовок 'Панель быстрого запуска' не отображается");
        return this;
    }

    @Step("Перейти в Командировки")
    public BusinessTripListPage goToBusinessTripListPage() {
        click(expensesButton);
        click(businessTripsButton);
        loadingPage();
        return pageManager.getBusinessTripListPage();
    }

}
