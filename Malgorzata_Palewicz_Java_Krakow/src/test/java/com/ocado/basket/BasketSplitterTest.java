package com.ocado.basket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class BasketSplitterTest {
    private BasketSplitter basketSplitter;
    @BeforeEach
    void setUp() {
        basketSplitter = new BasketSplitter("src/main/resources/test.json");
    }

    @Test
    void testSplitWithValidInput() {
        List<String> products = Arrays.asList("product1", "product2", "product3");
        Map<String, List<String>> result = basketSplitter.split(products);

        assertEquals(2, result.size());
        assertEquals(2, result.get("deliveryMethod1").size());
        assertEquals(1, result.get("deliveryMethod2").size());
    }

    @Test
    void testSplitWithTooManyProducts() {
        List<String> products = Arrays.asList(new String[101]);
        assertThrows(IllegalArgumentException.class, () -> basketSplitter.split(products));
    }

    @Test
    public void testBasketSplitter() {
        String validConfigFile = "src/main/resources/test.json";
        String invalidConfigFile = "src/main/resources/test2.json"; //contains more than 1000 products
        assertDoesNotThrow(() -> new BasketSplitter(validConfigFile));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BasketSplitter(invalidConfigFile));
        assertTrue(exception.getMessage().contains("The number of products in the configuration file exceeds the limit of 1000"));
    }

    @Test
    void testTooManyDeliveryMethodsInConfigFile() {
        String configFileWithTooManyMethods = "src/main/resources/test3.json";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BasketSplitter(configFileWithTooManyMethods));
        assertTrue(exception.getMessage().contains("The number of different delivery methods exceeds the limit of 10"));
    }



}
