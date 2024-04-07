package com.ocado.basket;

import com.ocado.json.Json; //import the Json class to use the jsonToMap method
import java.util.*;
import java.util.stream.Collectors;

public class BasketSplitter {
    private final Map<String, List<String>> deliveryMap;
    public BasketSplitter(String absolutePathToConfigFile){
        //reading JSON file containing delivery information for products
        this.deliveryMap = Json.jsonToMap(absolutePathToConfigFile);

        Collection<List<String>> allDeliveryMethods = deliveryMap.values();
        Set<String> delivery = new HashSet<>();
        for (List<String> deliveryMethods : allDeliveryMethods) {
            delivery.addAll(deliveryMethods);
        }
        int count = delivery.size();
        if (count > 10) {
            throw new IllegalArgumentException("The number of different delivery methods exceeds the limit of 10");
        }
        if (deliveryMap.size() > 1000) {
            throw new IllegalArgumentException("The number of products in the configuration file exceeds the limit of 1000");
        }
    }


    public Map<String, List<String>> split (List<String> products){
        if(products.size() > 100){
            throw new IllegalArgumentException("The number of products in the basket exceeds the limit of 100");
        }
            Map<String, List<String>> basketMap = createBasketMap(products, deliveryMap);
            return optimize(sortingMap(basketMap));
    }

    //creating new map where the key is delivery and value are products
    private Map<String, List<String>> createBasketMap (List<String> products, Map<String, List<String>> deliveryMap){
        Map<String, List<String>> basketMap = new HashMap<>();
        for (String product : products) {
            List<String> deliveries = deliveryMap.get(product);
            if (deliveries != null) {
                for (String delivery : deliveries) {
                    basketMap.computeIfAbsent(delivery, k -> new ArrayList<>()).add(product);
                }
            }
        }
        return basketMap;
    }

    private Map<String, List<String>> sortingMap(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }


    private Map<String, List<String>> optimize(Map<String, List<String>> basketMap) {
        Map<String, List<String>> optimizedMap = new LinkedHashMap<>(basketMap);

        for (Map.Entry<String, List<String>> entry : basketMap.entrySet()) {
            String deliveryMethod = entry.getKey();
            List<String> products = entry.getValue();

            Iterator<Map.Entry<String, List<String>>> iterator = optimizedMap.entrySet().iterator();

            // searching through the next keys of the map
            while (iterator.hasNext()) {
                Map.Entry<String, List<String>> nextEntry = iterator.next();
                String nextDeliveryMethod = nextEntry.getKey();
                List<String> nextProducts = nextEntry.getValue();

                if (nextDeliveryMethod.equals(deliveryMethod)) continue; //key for which we have already checked products
                nextProducts.removeAll(products); //removing the products that exist in the current and the next one delivery method
            }
        }
        optimizedMap.entrySet().removeIf(entry -> entry.getValue().isEmpty()); //removing keys without values
        return optimizedMap;
    }

    public void display(Map<String, List<String>> map){
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();

        System.out.println("Key-Value pairs:");
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}

