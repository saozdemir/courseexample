package com.sao.mapstocklistchallange;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock = 0;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

//    public int quantityInStock() {
//        return quantityInStock;
//    }

    public void setPrice(double price) {
        if (price > 0.00) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) {
            this.quantityInStock = newQuantity;
        }
    }

    public int availableQuantity() {
        return quantityInStock - reserved; //Mevcut stok miktarından ayrılanı çıkar
    }

    public int reserveStock(int quantity) {
        if (quantity <= availableQuantity()) {
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unReserveStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finalizeStock(int quantity) {
        if (quantity <= reserved) {
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
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
        //System.out.println("Entering StockItem.compareTo()");
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
        return this.name + "\t ->  price : " + this.price + " reserved : " + this.reserved;
    }
}