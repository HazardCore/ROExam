package org.example;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    // НЕ ВИТРАЧАВ ЧАС НА ГЕТТЕРИ ТА СЕТТЕРИ. КЛАС НЕ ІДЕАЛЬНИЙ
    public int id;
    public String name;
    public String UPC;
    public String manufacturer;
    public int price;
    public Date shelfLife;
    public int amount;
    public Product(int id, String name, String UPC, String manufacturer, int price, Date shelfLife, int amount) {
        this.id = id;
        this.name = name;
        this.UPC = UPC;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Name: " + this.name +
                ", UPC: " + this.UPC;
    }
}