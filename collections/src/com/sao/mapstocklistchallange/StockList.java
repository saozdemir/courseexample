package com.sao.mapstocklistchallange;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>(); //Sıralama yapması için HashMap<>() yerine LinkedHashMap<>() yazıldı.
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // Map'te item.getName() keyine sahip value varsa onu getir. Yoksa default olarak item instanceını al.
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) { //item map'den geliyosa farklı instance'dır. Bu durumda aynı ürün için sadece stok güncellenecek.
                item.adjustStock(inStock.availableQuantity());
            }
            // Map listinde hali hazırda isntance mevcutsa  eklemeyecek. Ama yoksa ekleyecek.
            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)) {
            return inStock.finalizeStock(quantity);
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)) {
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unReserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)) {
            return inStock.unReserveStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0;

        for (Map.Entry<String, StockItem> item : list.entrySet()) { //Map için iterator yapısı!!!!
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

            s = s + stockItem + ". There are " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}
