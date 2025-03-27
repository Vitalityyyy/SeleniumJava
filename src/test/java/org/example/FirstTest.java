package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //1 Перейти на страницу http://training.appline.ru/user/login
        driver.get("http://training.appline.ru/user/login");
    }

    @Test
    public void test() {
        //2 Пройти авторизацию
        waitTillVisible(driver.findElement(By.xpath("//h2[text()='Логин']")));
        fillField(driver.findElement(By.name("_username")), "Секретарь");
        fillField(driver.findElement(By.name("_password")), "testing");
        click(driver.findElement(By.name("_submit")));
        //3 Проверить наличие на странице заголовка Панель быстрого запуска
        WebElement quickStartHeader = driver.findElement(By.xpath("//h1[text()='Панель быстрого запуска']"));
        waitTillVisible(quickStartHeader);
        Assertions.assertTrue(quickStartHeader.isDisplayed(), "Заголовок 'Панель быстрого запуска' не отображается");
        //4 В выплывающем окне раздела Расходы нажать на Командировки
        click(driver.findElement(By.xpath("//*[text()='Расходы']")));
        click(driver.findElement(By.xpath("//*[text()='Командировки']")));
        loading();
        //5 Нажать на  Создать командировку
        click(driver.findElement(By.cssSelector(".pull-left.btn-group.icons-holder")));
        //6 Проверить наличие на странице заголовка "Создать командировку"
        WebElement createBusinessTripHeader = driver.findElement(By.xpath("//h1[text()='Создать командировку']"));
        Assertions.assertTrue(createBusinessTripHeader.isDisplayed(), "Заголовок 'Создать командировку' не отображается");
        /*7 На странице создания командировки заполнить или выбрать поля:
        — Подразделение - выбрать Отдел внутренней разработки
        — Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
        — В задачах поставить чекбокс на "Заказ билетов"
        — Указать города выбытия и прибытия
        — Указать даты выезда и возвращения
        — !! Раздел Командированные сотрудники не заполнять*/
        WebElement departmentDropdown = driver.findElement(By.cssSelector(".selector.input-widget-select"));
        departmentDropdown.click();
        click(departmentDropdown.findElement(By.cssSelector("option[value='10']"))); // варианта Отдел внутренней разработки нет в системе
        click(driver.findElement(By.xpath("//a[text()='Открыть список']")));
        WebElement companyList = driver.findElement(By.cssSelector(".select2-container.select2.input-widget"));
        companyList.click();
        WebElement company = driver.findElement(By.cssSelector(".select2-search input"));
        fillField(company, "Applana");
        click(driver.findElement(By.xpath("//*[text()='Applana']")));
        WebElement checkbox = driver.findElement(By.cssSelector("[data-name='field__1']"));
        click(checkbox);
        WebElement departureCity = driver.findElement(By.cssSelector("[data-name='field__departure-city']"));
        fillField(departureCity, "Санкт-Петербург");
        WebElement arrivalCity = driver.findElement(By.cssSelector("[data-name='field__arrival-city']"));
        fillField(arrivalCity, "Казань");
        WebElement departureDate = driver.findElement(By.cssSelector("[id^=date_selector_crm_business_trip_departureDatePlan]"));
        fillField(departureDate, "31.03.2025");
        WebElement returnDate = driver.findElement(By.cssSelector("[id^=date_selector_crm_business_trip_returnDatePlan]"));
        fillField(returnDate, "13.04.2025");
        returnDate.sendKeys(Keys.TAB);
        //8 Проверить, что все поля заполнены
        Assertions.assertEquals(departmentDropdown.findElement(By.cssSelector("span")).getText(), "Администрация");
        Assertions.assertEquals(companyList.getText(), "Applana");
        Assertions.assertTrue(checkbox.isSelected());
        Assertions.assertEquals(departureCity.getDomProperty("value"), "Санкт-Петербург");
        Assertions.assertEquals(arrivalCity.getDomProperty("value"), "Казань");
        Assertions.assertEquals(departureDate.getDomProperty("value"), "31.03.2025");
        Assertions.assertEquals(returnDate.getDomProperty("value"), "13.04.2025");
        //9 Нажать "Сохранить и закрыть"
        click(driver.findElement(By.cssSelector(".btn.btn-success.action-button:not(.main-group)")));
        //10 Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
        WebElement errorMessage = driver.findElement(By.xpath("//*[text()='Список командируемых сотрудников не может быть пустым']"));
        Assertions.assertTrue(errorMessage.isDisplayed());
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    public void loading() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div.loader-mask.shown"))));
    }

    public void waitTillVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitTillClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        waitTillClickable(element);
        element.click();
    }

    public void fillField(WebElement element, String text) {
        waitTillClickable(element);
        element.clear();
        element.sendKeys(text);
    }
}
