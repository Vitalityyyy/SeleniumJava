package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTripCreationPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Создать командировку']")
    private WebElement createBusinessTripHeader;

    @FindBy(css = ".selector.input-widget-select")
    private WebElement departmentDropdown;

    @FindBy(css = "option[value='10']")
    private WebElement departmentOption;

    @FindBy(xpath = "//a[text()='Открыть список']")
    private WebElement openCompanyListButton;

    @FindBy(css = ".select2-container")
    private WebElement companyList;

    @FindBy(css = ".select2-search input")
    private WebElement company;

    @FindBy(xpath = "//*[text()='Applana']")
    private WebElement applanaCompany;

    @FindBy(css = "[data-name='field__1']")
    private WebElement ticketsOrderCheckbox;

    @FindBy(css = "[data-name='field__departure-city']")
    private WebElement departureCity;

    @FindBy(css = "[data-name='field__arrival-city']")
    private WebElement arrivalCity;

    @FindBy(css = "[id^=date_selector_crm_business_trip_departureDatePlan]")
    private WebElement departureDate;

    @FindBy(css = "[id^=date_selector_crm_business_trip_returnDatePlan]")
    private WebElement returnDate;

    @FindBy(css = ".btn.btn-success.action-button:not(.main-group)")
    private WebElement saveAndCloseButton;

    @FindBy(xpath = "//*[text()='Список командируемых сотрудников не может быть пустым']")
    private WebElement errorMessage;


    public BusinessTripCreationPage assertBusinessTripCreationPageHeader() {
        Assertions.assertTrue(createBusinessTripHeader.isDisplayed(), "Заголовок 'Создать командировку' не отображается");
        return this;
    }

    public BusinessTripCreationPage selectDepartment() {
        departmentDropdown.click();
        click(departmentOption);
        return this;
    }

    public BusinessTripCreationPage selectCompany() {
        click(openCompanyListButton);
        companyList.click();
        fillInputField(company, "Applana");
        click(applanaCompany);
        return this;
    }

    public BusinessTripCreationPage clickTicketsOrderCheckbox() {
        click(ticketsOrderCheckbox);
        return this;
    }

    public BusinessTripCreationPage fillDepartureCity(String city) {
        fillInputField(departureCity, city);
        return this;
    }

    public BusinessTripCreationPage fillArrivalCity(String city) {
        fillInputField(arrivalCity, city);
        return this;
    }

    public BusinessTripCreationPage fillDepartureDate(String date) {
        fillDateField(departureDate, date);
        return this;
    }

    public BusinessTripCreationPage fillReturnDate(String date) {
        fillDateField(returnDate, date);
        returnDate.sendKeys(Keys.TAB);
        return this;
    }

    public BusinessTripCreationPage assertFieldsFilled() {
        scrollToElementJs(departmentDropdown);
        Assertions.assertEquals(departmentDropdown.findElement(By.cssSelector("span")).getText(), "Администрация");
        scrollToElementJs(companyList);
        Assertions.assertEquals(companyList.getText(), "Applana");
        Assertions.assertTrue(ticketsOrderCheckbox.isSelected());
        Assertions.assertEquals(departureCity.getDomProperty("value"), "Санкт-Петербург");
        Assertions.assertEquals(arrivalCity.getDomProperty("value"), "Казань");
        Assertions.assertEquals(departureDate.getDomProperty("value"), "31.03.2025");
        Assertions.assertEquals(returnDate.getDomProperty("value"), "13.04.2025");
        return this;
    }

    public BusinessTripCreationPage clickSaveAndClose() {
        click(saveAndCloseButton);
        return this;
    }

    public BusinessTripCreationPage assertErrorMessage() {
        Assertions.assertTrue(errorMessage.isDisplayed());
        return this;
    }
}
