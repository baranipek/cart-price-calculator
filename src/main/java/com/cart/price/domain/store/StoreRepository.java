package com.cart.price.domain.store;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class StoreRepository {

    private static final Map<String, Integer> store = new ConcurrentHashMap<>();

    public StoreRepository() {
        store.put("productCode1", 5);
        store.put("productCode", 3);
    }

    public boolean isInStock(String productCode) {
        return store.get(productCode) != null;
    }


    public void reduceStock(String productCode) {
        store.put(productCode, store.get(productCode) - 1);
    }
}
