package com.ocado;

import com.ocado.basket.BasketSplitter;

import java.util.*;
import static com.ocado.json.Json.jsonToList;

public class Main {
    public static void main(String[] args) {

        BasketSplitter configMap = new BasketSplitter("src/main/resources/config.json");
        List<String> products = jsonToList("src/main/resources/basket-1.json");
        Map<String, List<String>> basketMap = configMap.split(products);
        configMap.display(basketMap);

    }
}