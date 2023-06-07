package com.saucedemo.tests.ui;

import com.saucedemo.steps.Steps;
import org.junit.jupiter.api.Test;

public class UiTests {

    Steps steps = new Steps();

    @Test
    void autorizationTest() {
        steps
                .openMainPage()
                .successfulAutorization()
                .logOut();
    }
    // gradle clean test -Dlogin="pigano1956@cutefier.com" -Dpassword="123123123qqQ"

    @Test
    void addToBasketTest() {
        steps
                .openMainPage()
                .successfulAutorization()
                .addToCartItem()
                .openCart()
                .checkItemInTheCart()
                .deleteItemFromTheCart();
    }

    @Test
    void deleteFromBasketTest() {
        steps
                .openMainPage()
                .successfulAutorization()
                .addToCartItem()
                .openCart()
                .deleteItemFromTheCart()
                .checkIfTheBasketIsEmpty();
    }

    @Test
    void sortByPriceTest() {
        steps
                .openMainPage()
                .successfulAutorization()
                .clickOnSortButton()
                .selectSortByPrice(false)
                .checkIfAllItemsInCertainOrder(false);
    }

    @Test
    void sortByNameTest() {
        steps
                .openMainPage()
                .successfulAutorization()
                .clickOnSortButton()
                .selectSortOrderByName(true)
                .checkIfAllItemsNamesInOrder(true);
    }

    @Test
    void checkMenuButtonsTest() {
        steps
                .openMainPage()
                .successfulAutorization()
                .clickMenuButton()
                .checkListOfMenu();
    }

    @Test
    void resetAppState() {
        steps
                .openMainPage()
                .successfulAutorization()
                .addToCartItem()
                .clickMenuButton()
                .clickResetState()
                .openCart()
                .checkIfTheBasketIsEmpty();
    }

}
