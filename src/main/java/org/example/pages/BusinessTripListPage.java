package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTripListPage extends BasePage {

    @FindBy(css = ".pull-left.btn-group.icons-holder")
    private WebElement createBusinessTripButton;

    public BusinessTripCreationPage clickCreateBusinessTripButton() {
        click(createBusinessTripButton);
        return pageManager.getBusinessTripCreationPage();
    }
}
