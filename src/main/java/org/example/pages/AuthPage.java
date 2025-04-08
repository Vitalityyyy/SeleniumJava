package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.utils.PropConst.PASSWORD;
import static org.example.utils.PropConst.USERNAME;

public class AuthPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Логин']")
    private WebElement loginHeader;

    @FindBy(name = "_username")
    private WebElement usernameField;

    @FindBy(name = "_password")
    private WebElement passwordField;

    @FindBy(name = "_submit")
    private WebElement submitButton;

    public MenuBlock login() {
        waitTillVisible(loginHeader);
        fillInputField(usernameField, props.getProperty(USERNAME));
        fillInputField(passwordField, props.getProperty(PASSWORD));
        click(submitButton);
        return pageManager.getMenuBlock();
    }


}
