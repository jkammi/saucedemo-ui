package com.saucedemo.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Elements {

    public SelenideElement
            loginInput = $(".form_input[placeholder='Username']"),
            passwordInput = $(".form_input[placeholder='Password']"),
            loginButton = $("#userForm #userEmail"),
            menuButton = $("#react-burger-menu-btn"),
            logOutButton = $("#logout_sidebar_link"),
            addBackpackToCart = $("#add-to-cart-sauce-labs-backpack"),
            backpackName = $("#item_4_title_link .inventory_item_name"),
            cartButton = $(".shopping_cart_link"),
            deleteBackpackFromCartButton = $("#remove-sauce-labs-backpack"),
            cartList = $(".cart_list"),
            sortButton = $(".product_sort_container"),
            priceAscendingButton = $(".product_sort_container [value='lohi']"),
            priceDescendingButton = $(".product_sort_container [value='hilo']"),
            namesAscendingButton = $(".product_sort_container [value='az']"),
            namesDescendingButton = $(".product_sort_container [value='za']"),
            menuList = $(".bm-item-list"),
            resetAppStateButton = $("#reset_sidebar_link");
}
