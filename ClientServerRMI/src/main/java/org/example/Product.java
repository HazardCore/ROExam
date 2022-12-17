//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
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

    public String toString() {
        return "Name: " + this.name + ", UPC: " + this.UPC;
    }
}
