package com.sao.arraylist.bank;

import sun.swing.BakedArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Esra Bankası");

        bank.addBranch("Katılım");

        bank.addCustomer("Katılım", "Ahmet", 5000);
        bank.addCustomer("Katılım", "Esra", 1000);
        bank.addCustomer("Katılım", "Tarçın", 100);

        bank.addCustomerTransaction("Katılım", "Ahmet", 500);
        bank.addCustomerTransaction("Katılım", "Ahmet", 4000);
        bank.addCustomerTransaction("Katılım", "Esra", 600);

        bank.listCustomers("Katılım", true);
    }
}
