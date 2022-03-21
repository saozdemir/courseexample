package com.sao.mapstocklistchallange;

import java.util.Map;

public class MainChallange {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("Cup", 0.45, 200);
        stockList.addStock(temp);

        temp = new StockItem("Door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList); // toString metodu override edildiği için hemen yazdırır.

        /**
         * Program çalıştırıldığında HashMap olarak tanımlanan liste elemanları karışık bir sırada gösterir.
         * Sıralı bir şekilde gösterim için LinkedHashMap yapısı kullanılır.
         */

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }
        /**
         * stockList.Items() metodu Collections.unmodifiableMap metodu ile değiştirilemez bir liste döndürür.
         * StockList sınfı içindeki HashMap yapısını LinkedHashMap ile değiştirirsek sıralama  referasn alınan map ile aynı olur.
         */

        Basket ahmetBasket = new Basket("Ahmet");
        sellItem(ahmetBasket, "Car", 1);
        System.out.println(ahmetBasket);
        sellItem(ahmetBasket, "Car", 1);
        System.out.println(ahmetBasket);
        sellItem(ahmetBasket, "Car", 1); //Car bitti
        System.out.println(ahmetBasket);

        sellItem(ahmetBasket, "Spanner", 7); // Olmayan ürün
        // System.out.println(ahmetBasket);

        sellItem(ahmetBasket, "Bread", 1);
        sellItem(ahmetBasket, "Cup", 12);
        sellItem(ahmetBasket, "Juice", 4);
        // System.out.println(ahmetBasket);

        //System.out.println(stockList);

        Basket basket = new Basket("Esra");
        sellItem(basket, "Cup", 100);
        sellItem(basket, "Juice", 5);
        removeItem(basket, "Cup", 1);
        System.out.println(basket);

        removeItem(ahmetBasket, "Car", 1);
        removeItem(ahmetBasket, "Cup", 9);
        removeItem(ahmetBasket, "Car", 1);
        System.out.println(ahmetBasket);

        removeItem(ahmetBasket, "Bread", 1);
        removeItem(ahmetBasket, "Cup", 3);
        removeItem(ahmetBasket, "Juice", 4);
        removeItem(ahmetBasket, "Cup", 3);
        System.out.println(ahmetBasket);

        System.out.println("\nDisplay stocklist before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

//        temp = new StockItem("Pen", 1.12);
//        stockList.Items().put(temp.getName(),temp); //Hata verecektir. Çünkü unmodifiableMap olarak ayarlandı.
        stockList.Items().get("Car").adjustStock(20); //Collectionun kendisi unmodifiable dır içindeki nesneler değil!!!!!
        stockList.get("Car").adjustStock(-10); //Üst satır ile aynı işlemi yapıyor. Collections içindeki nesneler değiştilemez değildir!!!
        System.out.println(stockList);

//        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        checkOut(ahmetBasket);
        System.out.println(ahmetBasket);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unReserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
