package com.sao.mapstocklist;

import java.util.Map;

public class Main {
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
        System.out.println(ahmetBasket);

        sellItem(ahmetBasket, "Bread", 1);
        sellItem(ahmetBasket, "Cup", 12);
        sellItem(ahmetBasket, "Juice", 4);
        System.out.println(ahmetBasket);

        System.out.println(stockList);

//        temp = new StockItem("Pen", 1.12);
//        stockList.Items().put(temp.getName(),temp); //Hata verecektir. Çünkü unmodifiableMap olarak ayarlandı.
        stockList.Items().get("Car").adjustStock(20); //Collectionun kendisi unmodifiable dır içindeki nesneler değil!!!!!
        stockList.get("Car").adjustStock(-10); //Üst satır ile aynı işlemi yapıyor. Collections içindeki nesneler değiştilemez değildir!!!
        System.out.println(stockList);

        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
