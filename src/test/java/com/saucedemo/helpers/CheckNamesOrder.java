package com.saucedemo.helpers;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckNamesOrder {
    public void namesOrderCheck(boolean ascendingOrder) {
        List<SelenideElement> inventoryItems = $$(".inventory_item");
        List<String> names = new ArrayList<>();
        for (SelenideElement item : inventoryItems) {
            SelenideElement nameElement = item.$(".inventory_item_name");
            String name = nameElement.getText();
            System.out.println("Name: " + name);
            names.add(name);
        }

        List<String> sortedNames = new ArrayList<>(names);
        if (ascendingOrder) {
            Collections.sort(sortedNames);
        } else {
            Collections.sort(sortedNames, Collections.reverseOrder());
        }

        if (!names.equals(sortedNames)) {
            String order = ascendingOrder ? "ascending" : "descending";
            throw new AssertionError("Names are not in " + order + " order!");
        }
    }
}