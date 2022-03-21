package com.sao.mapstocklist;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantitiyInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.00) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName); //Burada String sınına ait equals metodunu kullandık
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo()");
        if (this == o) { //Nesne aynı ise 0 döndür.
            return 0;
        }

        if (o != null) { //Nesne null değil ise isimleri karşılaştır ve sonucu döndür.
            return this.name.compareTo(o.getName()); //Buradaki compareTo() String sınıfının
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + "\t ->  price : " + this.price;
    }
}