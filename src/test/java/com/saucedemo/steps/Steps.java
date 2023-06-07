package com.saucedemo.steps;

import com.saucedemo.config.AuthorizationConfig;
import com.saucedemo.elements.Elements;
import com.saucedemo.helpers.CheckNamesOrder;
import com.saucedemo.helpers.CheckPricesOrder;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


public class Steps {

    AuthorizationConfig config = ConfigFactory.create(AuthorizationConfig.class, System.getProperties());
    private String BackpackName;
    CheckPricesOrder checkThePricesOrder = new CheckPricesOrder();
    CheckNamesOrder checkNamesOrder = new CheckNamesOrder();
    Elements elements = new Elements();

    @Step("Open main page")
    public Steps openMainPage() {
        open("https://www.saucedemo.com/");
        return this;
    }

    @Step("successfulAutorization")
    public Steps successfulAutorization() {
        elements.loginInput.setValue("standard_user");
        elements.passwordInput.setValue("secret_sauce");
        elements.loginButton.click();
        return this;
    }

    @Step("logOut")
    public Steps logOut() {
        elements.menuButton.click();
        elements.logOutButton.click();
        return this;
    }

    @Step("addToCartItem")
    public Steps addToCartItem() {
        elements.addBackpackToCart.click();
        BackpackName = elements.backpackName.getText();
        return this;
    }

    @Step("openCart")
    public Steps openCart() {
        elements.cartButton.click();
        return this;
    }

    @Step("checkItemInTheCart")
    public Steps checkItemInTheCart() {
        elements.backpackName.shouldHave(text(BackpackName));
        return this;
    }

    @Step("deleteItemFromTheCart")
    public Steps deleteItemFromTheCart() {
        elements.deleteBackpackFromCartButton.click();
        return this;
    }

    @Step("checkIfTheBasketIsEmpty")
    public Steps checkIfTheBasketIsEmpty() {
        elements.cartList.shouldNotHave(text(BackpackName));
        return this;
    }

    @Step("clickOnSortButton")
    public Steps clickOnSortButton() {
        elements.sortButton.click();
        return this;
    }

    @Step("selectSortByPrice: descending={0}")
    public Steps selectSortByPrice(boolean descending) {
        if (descending) {
            elements.priceDescendingButton.click();
        } else {
            elements.priceAscendingButton.click();
        }
        return this;
    }

    @Step("selectSortOrderByName: ascending={0}")
    public Steps selectSortOrderByName(boolean ascending) {
        if (ascending) {
            elements.namesAscendingButton.click();
        } else {
            elements.namesDescendingButton.click();
        }
        return this;
    }

    @Step("checkIfAllItemsInCertainOrder")
    public Steps checkIfAllItemsInCertainOrder(boolean descending) {
        checkThePricesOrder.priceOrderCheck(descending);
        return this;
    }

    @Step("checkIfAllItemsNamesInOrder")
    public Steps checkIfAllItemsNamesInOrder(boolean ascending) {
        checkNamesOrder.namesOrderCheck(ascending);
        return this;
    }

    @Step("clickMenuButton")
    public Steps clickMenuButton() {
        elements.menuButton.click();
        return this;
    }

    @Step("checkListOfMenu")
    public Steps checkListOfMenu() {
        elements.menuList.shouldHave(text("All Items"));
        elements.menuList.shouldHave(text("About"));
        elements.menuList.shouldHave(text("Logout"));
        elements.menuList.shouldHave(text("Reset App State"));
        return this;
    }

    @Step("clickResetState")
    public Steps clickResetState() {
        elements.resetAppStateButton.click();
        return this;
    }
}

