package org.example.tests;

import org.example.BaseTest;
import org.junit.jupiter.api.Test;

public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        app.getAuthPage().login()
                .assertMenuBlockHeader()
                .goToBusinessTripListPage()
                .clickCreateBusinessTripButton()
                .assertBusinessTripCreationPageHeader()
                .selectDepartment()
                .selectCompany()
                .clickTicketsOrderCheckbox()
                .fillDepartureCity("Санкт-Петербург")
                .fillArrivalCity("Казань")
                .fillDepartureDate("31.03.2025")
                .fillReturnDate("13.04.2025")
                .assertFieldsFilled()
                .clickSaveAndClose()
                .assertErrorMessage();

    }




}
