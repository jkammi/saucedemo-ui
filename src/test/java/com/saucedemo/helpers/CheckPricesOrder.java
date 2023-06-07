package com.saucedemo.helpers;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class CheckPricesOrder {
    public void priceOrderCheck(boolean descendingOrder) {
        List<SelenideElement> inventoryItems = $$(".inventory_item");
        List<Double> prices = new ArrayList<>();
        for (SelenideElement item : inventoryItems) {
            SelenideElement priceElement = item.$(".inventory_item_price");
            String priceText = priceElement.getText();
            String priceCleaned = priceText.replace(",", "");
            double price = Double.parseDouble(priceCleaned.substring(1));
            System.out.println("Price: " + price);
            prices.add(price);
        }
        List<Double> sortedPrices = new ArrayList<>(prices);
        if (descendingOrder) {
            Collections.sort(sortedPrices, Collections.reverseOrder());
        } else {
            Collections.sort(sortedPrices);
        }

        if (!prices.equals(sortedPrices)) {
            String order = descendingOrder ? "descending" : "ascending";
            throw new AssertionError("Prices are not in " + order + " order!");
        }
    }
}