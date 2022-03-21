package com.sao.mapstocklist;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>(); //StockItem.compareTo içine gider.
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0); //Listede önceden ekli ürün var mı varsa getir, yoksa 0 ata.
            list.put(item, inBasket + quantity); // Yeni eklenen  item miktarını sepette bulunana ekle.
            return inBasket;
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "\nShopping Basket " + name + " contains " + list.size() + (list.size() == 1 ? " item" : " items") + "\n";
        double totalCost = 0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
